package com.wangguangwu.keepknowing.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import com.wangguangwu.keepknowing.client.WeiboClient;
import com.wangguangwu.keepknowing.entity.UserInfo;
import com.wangguangwu.keepknowing.entity.weibo.WeiBoResponseDTO;
import com.wangguangwu.keepknowing.entity.weibo.WeiboBlogInfoDTO;
import com.wangguangwu.keepknowing.exception.HttpStatusException;
import com.wangguangwu.keepknowing.service.WeiboParseService;
import com.wangguangwu.keepknowing.service.WeiboProcessService;
import com.wangguangwu.keepknowing.service.WeiboVisitService;
import com.wangguangwu.keepknowing.util.HttpClientUtil;
import com.wangguangwu.keepknowing.util.WeiboUrlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class WeiboVisitServiceImpl implements WeiboVisitService {

    @Resource
    private WeiboParseService weiboParseService;

    @Resource
    private WeiboProcessService weiboSaveService;

    @Resource
    private WeiboClient weiboClient;

    private static final Integer MAX_RETRY_TIMES = 3;

    @Override
    public List<Long> getUidGroup(String name) {
        // 对姓名进行编码
        String url = WeiboUrlUtil.getSearchUrl(name);
        List<UserInfo> users = null;
        try {
            // 响应数据
            String content = HttpClientUtil.getBody(url);
            // 获取用户数据
            users = weiboParseService.parseSearchResponse(name, content);
            // 处理并插入数据
            weiboSaveService.processUserInfo(users);
        } catch (HttpStatusException e) {
            log.error("微博根据姓名[{}]获取 uid 失败：{}", name, e.getMessage(), e);
        }
        return toUserIdList(users);
    }

    @Override
    public void visitWeibo(Long uid) {
        visitBlog(uid, 0, 0);
    }


    /**
     * 访问用户微博
     *
     * @param uid        用户 id
     * @param searchPage 查询页数
     * @param retryTimes 重试次数
     */
    void visitBlog(Long uid, Integer searchPage, Integer retryTimes) {
        if (retryTimes > MAX_RETRY_TIMES) {
            log.info("[{}]已达到最大重试次数，停止访问", uid);
            return;
        }
        String blogUrl = WeiboUrlUtil.getBlogUrl(uid, searchPage);
        String body = weiboClient.get(blogUrl);

        WeiBoResponseDTO weiBoResponseDTO = JSON.parseObject(body, WeiBoResponseDTO.class);

        if (isVisitEnd(weiBoResponseDTO)) {
            // 重试
            log.info("访问[{}]失败，停止访问", blogUrl);
            visitBlog(uid, searchPage, ++retryTimes);
            return;
        }

        // 微博 blogs 处理
        processBlogsAndVisitNextPage(weiBoResponseDTO, uid, searchPage);
    }

    private boolean isVisitEnd(WeiBoResponseDTO weiBoResponseDTO) {
        return Optional.ofNullable(weiBoResponseDTO)
                .map(dto -> dto.getOk() != 1 || dto.getData() == null || CollUtil.isEmpty(dto.getData().getList()))
                .orElse(true);
    }

    private void processBlogsAndVisitNextPage(WeiBoResponseDTO weiBoResponseDTO, Long uid, Integer searchPage) {
        Optional.of(weiBoResponseDTO)
                .map(WeiBoResponseDTO::getData)
                .map(WeiBoResponseDTO.DataDTO::getList)
                .ifPresent(blogs -> {
                    // 解析微博 blogs
                    List<WeiboBlogInfoDTO> blogList = weiboParseService.parseBlogs(blogs);
                    // TODO: 插入数据
                    // 访问下一页数据
                    int nextPage = searchPage + 1;
                    visitBlog(uid, nextPage, 0);
                });
    }


    private List<Long> toUserIdList(List<UserInfo> users) {
        return Optional.ofNullable(users)
                .map(userList -> userList.stream().map(UserInfo::getUserId).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }
}
