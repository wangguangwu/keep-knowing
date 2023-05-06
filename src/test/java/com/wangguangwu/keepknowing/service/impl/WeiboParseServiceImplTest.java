package com.wangguangwu.keepknowing.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.wangguangwu.keepknowing.entity.UserInfo;
import com.wangguangwu.keepknowing.service.WeiboParseService;
import com.wangguangwu.keepknowing.util.FileReadUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class WeiboParseServiceImplTest {

    @Resource
    private WeiboParseService weiboParseService;

    @Test
    void testParseSearchResponse() {
        String content = FileReadUtil.readFile("weibo/WeiboSearchResponse.txt");
        Assertions.assertNotNull(content, "读取文件失败");
        List<UserInfo> userInfoList = weiboParseService.parseSearchResponse("何同学", content);
        Assertions.assertTrue(CollUtil.isNotEmpty(userInfoList));
        userInfoList.forEach(System.out::println);
    }
}