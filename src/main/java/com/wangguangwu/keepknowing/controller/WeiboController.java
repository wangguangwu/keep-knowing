package com.wangguangwu.keepknowing.controller;

import com.wangguangwu.keepknowing.service.WeiboService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangguangwu
 */
@RestController
@RequestMapping("weibo")
@Slf4j
public class WeiboController {

    @Resource
    private WeiboService weiboService;

    /**
     * 获取需要访问的用户 Uid
     * @param name name
     * @return uid
     */
    @GetMapping("/listUserUid")
    public List<Long> listUserUid(String name) {
        return weiboService.listUserUid(name);
    }

    /**
     * 初始化人员信息
     *
     * @param name 人员姓名
     */
    @GetMapping("/initPeople")
    public void initPeople(String name) {
        weiboService.initPeople(name);
    }

    /**
     * 更新人员信息
     *
     * @param name 人员姓名
     */
    @GetMapping("/updatePeople")
    public void updatePeople(String name) {

    }

    /**
     * 查询人员信息
     *
     * @param name 人员姓名
     */
    @GetMapping("/searchPeople")
    public void searchPeople(String name) {
    }

}
