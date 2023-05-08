package com.wangguangwu.keepknowing.service.impl;

import com.wangguangwu.keepknowing.service.WeiboService;
import com.wangguangwu.keepknowing.service.WeiboVisitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class WeiboServiceImpl implements WeiboService {

    @Resource
    private WeiboVisitService weiboVisitService;

    @Override
    public List<Long> listUserUid(String name) {
        return weiboVisitService.getUidGroup(name);
    }

    @Override
    public void initPeople(String name) {
        // 获取用户对应的 uid
        List<Long> uidGroup = weiboVisitService.getUidGroup(name);
        for (Long uid : uidGroup) {
            // 访问用户 weibo 数据
            weiboVisitService.visitWeibo(uid);
        }
    }

    @Override
    public void updatePeople(String name) {

    }

    @Override
    public void searchPeople(String name) {

    }
}