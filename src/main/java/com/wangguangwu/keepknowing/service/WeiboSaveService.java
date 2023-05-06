package com.wangguangwu.keepknowing.service;

import com.wangguangwu.keepknowing.entity.UserInfo;
import com.wangguangwu.keepknowing.entity.UserInfoHistory;

import java.util.List;

/**
 * @author wangguangwu
 */
public interface WeiboSaveService {


    /**
     * 保存数据
     *
     * @param userInfoList        用户信息数据
     * @param userInfoHistoryList 用户信息历史数据
     */
    void saveUserInfoBatch(List<UserInfo> userInfoList, List<UserInfoHistory> userInfoHistoryList);

}
