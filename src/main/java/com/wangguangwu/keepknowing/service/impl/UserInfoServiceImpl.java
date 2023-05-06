package com.wangguangwu.keepknowing.service.impl;

import com.wangguangwu.keepknowing.entity.UserInfo;
import com.wangguangwu.keepknowing.mapper.UserInfoMapper;
import com.wangguangwu.keepknowing.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author wangguangwu
 * @since 2023-05-06
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
