package com.wangguangwu.keepknowing.service;

import com.wangguangwu.keepknowing.entity.UserInfo;

import java.util.List;

/**
 * @author wangguangwu
 */
public interface WeiboProcessService {

    /**
     * 处理并保存用户信息
     *
     * @param users 用户信息
     */
    void processUserInfo(List<UserInfo> users);

}
