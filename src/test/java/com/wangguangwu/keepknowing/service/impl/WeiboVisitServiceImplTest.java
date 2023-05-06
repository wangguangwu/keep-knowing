package com.wangguangwu.keepknowing.service.impl;

import com.wangguangwu.keepknowing.service.WeiboVisitService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class WeiboVisitServiceImplTest {

    @Resource
    private WeiboVisitService weiboVisitService;

    @Test
    void testGetUidGroup() {
        List<Long> uidGroup = weiboVisitService.getUidGroup("何同学");
        Assertions.assertNotNull(uidGroup);
    }
}