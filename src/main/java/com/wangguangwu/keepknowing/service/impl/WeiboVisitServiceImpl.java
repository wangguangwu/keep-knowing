package com.wangguangwu.keepknowing.service.impl;

import com.wangguangwu.keepknowing.constant.WeiboConstant;
import com.wangguangwu.keepknowing.entity.UserInfo;
import com.wangguangwu.keepknowing.exception.CommonException;
import com.wangguangwu.keepknowing.service.WeiboParseService;
import com.wangguangwu.keepknowing.service.WeiboProcessService;
import com.wangguangwu.keepknowing.service.WeiboVisitService;
import com.wangguangwu.keepknowing.util.EncodeUtil;
import com.wangguangwu.keepknowing.util.HttpConnectionUtil;
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

    @Override
    public List<Long> getUidGroup(String name) {
        // 对姓名进行编码
        String url = getSearchUrl(name);
        List<UserInfo> users = null;
        try {
            // 响应数据
            String content = HttpConnectionUtil.get(url);
            // 获取用户数据
            users = weiboParseService.parseSearchResponse(name, content);
            // 处理并插入数据
            weiboSaveService.processUserInfo(users);
        } catch (CommonException e) {
            log.error("微博根据姓名[{}]获取 Uid 失败：{}", name, e.getMessage(), e);
        }
        return toUserIdList(users);
    }

    private List<Long> toUserIdList(List<UserInfo> users) {
        return Optional.ofNullable(users)
                .orElse(Collections.emptyList())
                .stream()
                .map(UserInfo::getUserId)
                .collect(Collectors.toList());
    }

    private String getSearchUrl(String name) {
        return WeiboConstant.WEIBO_SEARCH_BASE_URL.replace("name", EncodeUtil.urlEncode(name));
    }
}
