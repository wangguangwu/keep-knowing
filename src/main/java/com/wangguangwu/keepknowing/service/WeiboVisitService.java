package com.wangguangwu.keepknowing.service;

import java.util.List;

/**
 * @author wangguangwu
 */
public interface WeiboVisitService {

    /**
     * 根据姓名获取对应的 uid
     *
     * @param name 姓名
     * @return List of Uid
     */
    List<Long> getUidGroup(String name);

    /**
     * 获取 uid 对应的 blog
     *
     * @param uid uid
     */
    void visitWeibo(Long uid);

}
