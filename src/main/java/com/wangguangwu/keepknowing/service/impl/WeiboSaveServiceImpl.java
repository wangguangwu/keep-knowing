package com.wangguangwu.keepknowing.service.impl;

import com.wangguangwu.keepknowing.entity.UserInfo;
import com.wangguangwu.keepknowing.entity.UserInfoHistory;
import com.wangguangwu.keepknowing.service.UserInfoHistoryService;
import com.wangguangwu.keepknowing.service.UserInfoService;
import com.wangguangwu.keepknowing.service.WeiboSaveService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangguangwu
 */
@Service
public class WeiboSaveServiceImpl implements WeiboSaveService {

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private UserInfoHistoryService userInfoHistoryService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUserInfoBatch(List<UserInfo> userInfoList, List<UserInfoHistory> userInfoHistoryList) {
        userInfoHistoryService.saveBatch(userInfoHistoryList);
        userInfoService.saveBatch(userInfoList);
    }
}
