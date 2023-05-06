package com.wangguangwu.keepknowing.service.impl;

import com.wangguangwu.keepknowing.entity.UserInfo;
import com.wangguangwu.keepknowing.entity.UserInfoHistory;
import com.wangguangwu.keepknowing.mapper.UserInfoHistoryMapper;
import com.wangguangwu.keepknowing.service.UserInfoHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 用户历史信息表 服务实现类
 * </p>
 *
 * @author wangguangwu
 * @since 2023-05-05
 */
@Service
public class UserInfoHistoryServiceImpl extends ServiceImpl<UserInfoHistoryMapper, UserInfoHistory> implements UserInfoHistoryService {


}
