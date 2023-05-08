package com.wangguangwu.keepknowing.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wangguangwu.keepknowing.constant.*;
import com.wangguangwu.keepknowing.entity.*;
import com.wangguangwu.keepknowing.entity.weibo.*;
import com.wangguangwu.keepknowing.service.BlogService;
import com.wangguangwu.keepknowing.service.WeiboParseService;
import com.wangguangwu.keepknowing.service.WeiboTransferService;
import com.wangguangwu.keepknowing.util.DateUtil;
import com.wangguangwu.keepknowing.util.DownloadUtil;
import com.wangguangwu.keepknowing.util.RegexUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.File;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class WeiboParseServiceImpl implements WeiboParseService {

    @Resource
    private WeiboTransferService weiboTransferService;

    @Resource
    private BlogService blogService;

    @Override
    public List<UserInfo> parseSearchResponse(String name, String content) {
        // 解析响应
        WeiboSearchResponseDTO weiboSearchResponseDTO = JSON.parseObject(content, WeiboSearchResponseDTO.class);

        Integer ok = weiboSearchResponseDTO.getOk();
        if (ok != 1) {
            log.info("微博搜索[{}]失败，ok：{}", name, ok);
            return Collections.emptyList();
        }

        // 主体数据
        WeiboSearchResponseDTO.DataDTO data = weiboSearchResponseDTO.getData();
        List<WeiboSearchResponseDTO.DataDTO.CardsDTO> cards = data.getCards();
        // 获取用户数据
        List<WeiboSearchResponseDTO.DataDTO.CardsDTO.CardGroupDTO.UserDTO> userGroup = parseCards(cards);
        return weiboTransferService.transferUserInfo(userGroup);
    }

    @Override
    public List<WeiboBlogInfoDTO> parseBlogs(List<WeiBoResponseDTO.DataDTO.ListDTO> blogs) {
        return blogs.stream()
                .map(this::parseBlog)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private WeiboBlogInfoDTO parseBlog(WeiBoResponseDTO.DataDTO.ListDTO blog) {
        if (blog == null || blog.getUser() == null) {
            return null;
        }
        // 微博 id
        Long blogId = blog.getId();
        // 根据 blog id  判断是否存过
        if (containsBlog(blogId)) {
            log.info("weibo blog [{}] has saved", blogId);
            return null;
        }
        // 根据 blog id  判断是否存过
        // 用户
        WeiBoResponseDTO.DataDTO.ListDTO.UserDTO user = blog.getUser();
        // 用户 id
        Long userId = user.getId();
        // 创建时间
        LocalDateTime create = DateUtil.cst2Date(blog.getCreatedAt());
        // 发布文本
        String text = blog.getText();
        // 判断文件中有没有超链接
        List<String> videoList = RegexUtil.videoMatch(text);
        // 文本长度
        Integer textLength = blog.getTextLength() == null ? text.length() : blog.getTextLength();
        // 发布来源
        String source = blog.getSource();
        // live 视频
        JSONObject picInfos = blog.getPicInfos();
        // 图片
        List<WeiboBlogJpgDTO> blogJpgs = parseJpgs(blog.getPicIds(), userId, blogId, picInfos);
        // 视频
        // 图片数目
        Integer picNum = blog.getPicNum();
        // 发布地点
        String region = getRegion(blog.getRegionName());
        Blog blogInfo = Blog.builder().blogId(blogId).isDeleted(0).userId(userId).blogCreat(create).text(text).textLength(textLength).source(source).picCount(picNum).region(region).build();

        return WeiboBlogInfoDTO.builder().blog(blogInfo).weiboBlogJpgList(blogJpgs).blogVideoList(videoList).build();
    }


    private boolean containsBlog(Long blogId) {
        return blogService.count(Wrappers.<Blog>lambdaQuery()
                .eq(Blog::getBlogId, blogId)) > 0;
    }

    private List<WeiboSearchResponseDTO.DataDTO.CardsDTO.CardGroupDTO.UserDTO> parseCards(List<WeiboSearchResponseDTO.DataDTO.CardsDTO> cards) {
        return cards.stream()
                .filter(Objects::nonNull)
                .map(WeiboSearchResponseDTO.DataDTO.CardsDTO::getCardGroup)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .flatMap(card -> Stream.concat(
                        // 获取推荐用户
                        Stream.of(card.getUser()).filter(Objects::nonNull),
                        // 获取相关用户
                        parseCardUsers(card.getUsers()).stream()
                )).collect(Collectors.toList());
    }

    private List<WeiboSearchResponseDTO.DataDTO.CardsDTO.CardGroupDTO.UserDTO> parseCardUsers(List<WeiboSearchResponseDTO.DataDTO.CardsDTO.CardGroupDTO.UsersDTO> cardUsers) {
        return CollUtil.isEmpty(cardUsers) ?
                Collections.emptyList() : cardUsers
                .stream()
                .map(user -> {
                    WeiboSearchResponseDTO.DataDTO.CardsDTO.CardGroupDTO.UserDTO userDTO = new WeiboSearchResponseDTO.DataDTO.CardsDTO.CardGroupDTO.UserDTO();
                    BeanUtils.copyProperties(user, userDTO);
                    return userDTO;
                }).collect(Collectors.toList());
    }

    /**
     * 解析并保存 jpg 和 live 图片
     *
     * @param picIds   jpg
     * @param userId   用户 id
     * @param blogId   微博 id
     * @param picInfos live 图片
     */
    private List<WeiboBlogJpgDTO> parseJpgs(List<String> picIds, Long userId, Long blogId, JSONObject picInfos) {
        return CollectionUtils.isEmpty(picIds) ? Collections.emptyList() : picIds.stream()
                .map(jpgId -> getWeiboBlogJpgDTO(userId, blogId, picInfos, jpgId))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private static WeiboBlogJpgDTO getWeiboBlogJpgDTO(Long userId, Long blogId, JSONObject picInfos, String jpgId) {
        // 完整的 jpg url
        String jpgUrlWeibo = WeiboUrl.WEIBO_JPG_BASE_URL.replace("replace", jpgId);
        // 本地 jpg url
        String jpgUrlLocal = DownloadUtil.download(jpgUrlWeibo, Company.WEIBO + File.separator + userId + File.separator + blogId, jpgId, Media.JPG);
        WeiboBlogDTO.PicInfoDTO picInfoDTO = JSON.parseObject(JSON.toJSONString(picInfos.get(jpgId)), WeiboBlogDTO.PicInfoDTO.class);

        String liveUrlWeibo = picInfoDTO.getVideo();
        BlogLive blogLive = null;
        if (StringUtils.isNotBlank(liveUrlWeibo)) {
            // live 图
            String liveUrlLocal = DownloadUtil.download(liveUrlWeibo, Company.WEIBO + File.separator + userId + File.separator + blogId, jpgId, Media.MOV);

            // blog 对应的 live 图
            blogLive = BlogLive.builder().jpgId(jpgId)
                    .blogId(blogId)
                    .liveUrl(liveUrlLocal)
                    .build();
        }
        // blog 对应的 jpg
        BlogJpg blogJpg = BlogJpg.builder().jpgId(jpgId)
                .jpgUrl(jpgUrlLocal)
                .blogId(blogId)
                .build();

        return WeiboBlogJpgDTO.builder().blogJpg(blogJpg).blogLive(blogLive).build();
    }

    /**
     * 获取清晰度最高的 video url
     *
     * @param playPlayInfo playPlayInfo
     */
    private String getVideoUrl(WeiboVideoResponseDTO.DataDTO.ComponentPlayPlayinfoDTO playPlayInfo) {
        // 视频地址
        JSONObject videoUrls = playPlayInfo.getUrls();
        // 拿出所有的 key
        Set<String> keySet = videoUrls.keySet();
        // 最清晰的视频
        String videoKey = getVideoType(keySet);
        if (StringUtils.isBlank(videoKey)) {
            return "";
        }
        // 解析出视频地址
        String videoUrl = String.valueOf(videoUrls.get(videoKey));
        return videoUrl.startsWith(Protocol.HTTPS) ? videoUrl : Protocol.HTTPS + videoUrl;
    }

    @SuppressWarnings("all")
    private String getVideoType(Set<String> keySet) {
        String key = "";
        if (keySet.contains("超清 4K")) {
            key = "超清 4K";
        } else if (keySet.contains("超清 2K")) {
            key = "超清 2K";
        } else if (keySet.contains("高清 1080P")) {
            key = "高清 1080P";
        } else if (keySet.contains("高清 720P")) {
            key = "高清 720P";
        } else if (keySet.contains("标清 480P")) {
            key = "标清 480P";
        } else if (keySet.contains("流畅 360P")) {
            key = "流畅 360P";
        }
        return key;
    }

    /**
     * 获取省份或者国家信息
     *
     * @param regionName 地区数据
     * @return 截取后的地区
     */
    private String getRegion(String regionName) {
        if (StringUtils.isBlank(regionName)) {
            return "";
        }
        int index = regionName.indexOf(" ");
        return index == -1 ? regionName : regionName.substring(index + 1);
    }
}
