package com.wangguangwu.keepknowing.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wangguangwu.keepknowing.entity.UserInfo;
import com.wangguangwu.keepknowing.entity.UserInfoHistory;
import com.wangguangwu.keepknowing.service.UserInfoService;
import com.wangguangwu.keepknowing.service.WeiboProcessService;
import com.wangguangwu.keepknowing.service.WeiboSaveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangguangwu
 */
@Service
public class WeiboProcessServiceImpl implements WeiboProcessService {

    @Resource
    private WeiboSaveService weiboSaveService;

    @Resource
    private UserInfoService userInfoService;

    @Override
    public void processUserInfo(List<UserInfo> users) {
        List<UserInfo> userInfoList = new ArrayList<>();
        List<UserInfoHistory> userInfoHistoryList = new ArrayList<>();

        synchronized (this) {
            users.forEach(user -> {
                // 数据库层面使用了唯一索引，保证唯一性
                UserInfo userInfo = userInfoService.getOne(Wrappers.<UserInfo>lambdaQuery()
                        .eq(UserInfo::getUserId, user.getUserId())
                        .select(UserInfo::getUserName, UserInfo::getUserDescription), false);
                if (userInfo == null) {
                    // 没有 userId，插入到当前用户表中
                    userInfoList.add(user);
                } else {
                    Long userId = user.getUserId();
                    String userName = user.getUserName();
                    String userDescription = user.getUserDescription();
                    // 数据完全相同，不插入
                    if (!userInfo.getUserName().equals(userName) || !userInfo.getUserDescription().equals(userDescription)) {
                        UserInfoHistory userInfoHistory = UserInfoHistory.builder().userId(userId)
                                .userName(userName)
                                .userDescription(userDescription)
                                .build();
                        userInfoHistoryList.add(userInfoHistory);
                    }
                }
            });
            // 插入数据
            weiboSaveService.saveUserInfoBatch(userInfoList, userInfoHistoryList);
        }
    }
}
