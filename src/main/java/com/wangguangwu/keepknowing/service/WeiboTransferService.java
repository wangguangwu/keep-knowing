package com.wangguangwu.keepknowing.service;

import com.wangguangwu.keepknowing.entity.UserInfo;
import com.wangguangwu.keepknowing.entity.weibo.WeiboSearchResponse;

import java.util.List;

/**
 * @author wangguangwu
 */
public interface WeiboTransferService {

    /**
     * 转换用户信息
     * @param userGroup 用户数据
     * @return 转换后的数据
     */
    List<UserInfo> transferUserInfo(List<WeiboSearchResponse.DataDTO.CardsDTO.CardGroupDTO.UserDTO> userGroup);

}
