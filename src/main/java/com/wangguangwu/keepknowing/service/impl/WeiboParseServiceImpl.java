package com.wangguangwu.keepknowing.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson2.JSON;
import com.wangguangwu.keepknowing.entity.UserInfo;
import com.wangguangwu.keepknowing.entity.weibo.WeiboSearchResponse;
import com.wangguangwu.keepknowing.service.WeiboParseService;
import com.wangguangwu.keepknowing.service.WeiboTransferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class WeiboParseServiceImpl implements WeiboParseService {

    @Resource
    private WeiboTransferService weiboTransferService;

    @Override
    public List<UserInfo> parseSearchResponse(String name, String content) {
        // 解析响应
        WeiboSearchResponse weiboSearchResponse = JSON.parseObject(content, WeiboSearchResponse.class);

        Integer ok = weiboSearchResponse.getOk();
        if (ok != 1) {
            log.info("微博搜索[{}]失败，ok：{}", name, ok);
            return Collections.emptyList();
        }

        // 主体数据
        WeiboSearchResponse.DataDTO data = weiboSearchResponse.getData();
        List<WeiboSearchResponse.DataDTO.CardsDTO> cards = data.getCards();
        // 获取用户数据
        List<WeiboSearchResponse.DataDTO.CardsDTO.CardGroupDTO.UserDTO> userGroup = parseCards(cards);
        return weiboTransferService.transferUserInfo(userGroup);
    }

    private List<WeiboSearchResponse.DataDTO.CardsDTO.CardGroupDTO.UserDTO> parseCards(List<WeiboSearchResponse.DataDTO.CardsDTO> cards) {
        return cards.stream()
                .filter(Objects::nonNull)
                .map(WeiboSearchResponse.DataDTO.CardsDTO::getCardGroup)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .flatMap(card -> Stream.concat(
                        // 获取推荐用户
                        Stream.of(card.getUser()).filter(Objects::nonNull),
                        // 获取相关用户
                        parseCardUsers(card.getUsers()).stream()
                )).collect(Collectors.toList());
    }

    private List<WeiboSearchResponse.DataDTO.CardsDTO.CardGroupDTO.UserDTO> parseCardUsers(List<WeiboSearchResponse.DataDTO.CardsDTO.CardGroupDTO.UsersDTO> cardUsers) {
        return CollUtil.isEmpty(cardUsers) ?
                Collections.emptyList() : cardUsers
                .stream()
                .map(user -> {
                    WeiboSearchResponse.DataDTO.CardsDTO.CardGroupDTO.UserDTO userDTO = new WeiboSearchResponse.DataDTO.CardsDTO.CardGroupDTO.UserDTO();
                    BeanUtils.copyProperties(user, userDTO);
                    return userDTO;
                }).collect(Collectors.toList());
    }
}
