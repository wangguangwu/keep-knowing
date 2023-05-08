package com.wangguangwu.keepknowing.service;

import com.wangguangwu.keepknowing.entity.UserInfo;
import com.wangguangwu.keepknowing.entity.weibo.WeiBoResponseDTO;
import com.wangguangwu.keepknowing.entity.weibo.WeiboBlogInfoDTO;

import java.util.List;

/**
 * @author wangguangwu
 */
public interface WeiboParseService {

    /**
     * 解析微博响应
     *
     * @param name    用户名称
     * @param content 响应
     * @return 用户数据
     */
    List<UserInfo> parseSearchResponse(String name, String content);

    /**
     * 解析微博 blogs
     *
     * @param blogs 博文
     * @return
     */
    List<WeiboBlogInfoDTO> parseBlogs(List<WeiBoResponseDTO.DataDTO.ListDTO> blogs);

}
