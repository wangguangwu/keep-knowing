package com.wangguangwu.keepknowing.service;

import java.util.List;

/**
 * @author wangguangwu
 */
public interface WeiboService {

    /**
     * 获取需要访问的用户 Uid
     *
     * @param name 人员姓名
     * @return list of uid
     */
    List<Long> listUserUid(String name);

    /**
     * 初始化人员信息
     *
     * @param name 人员姓名
     */
    void initPeople(String name);

    /**
     * 更新人员信息
     *
     * @param name 人员姓名
     */
    void updatePeople(String name);

    /**
     * 查询人员信息
     *
     * @param name 人员姓名
     */
    void searchPeople(String name);


}
