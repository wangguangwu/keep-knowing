package com.wangguangwu.keepknowing.service;

import java.util.List;

/**
 * @author wangguangwu
 */
public interface WeiboVisitService {

    /**
     * 根据姓名获取对应的 Uid
     *
     * @param name 姓名
     * @return List of Uid
     */
    List<Long> getUidGroup(String name);

}
