package com.wangguangwu.keepknowing.service.impl;

import cn.hutool.core.date.DateUtil;
import com.wangguangwu.keepknowing.constant.Company;
import com.wangguangwu.keepknowing.constant.Media;
import com.wangguangwu.keepknowing.constant.Symbol;
import com.wangguangwu.keepknowing.entity.UserInfo;
import com.wangguangwu.keepknowing.entity.weibo.WeiboSearchResponseDTO;
import com.wangguangwu.keepknowing.service.WeiboTransferService;
import com.wangguangwu.keepknowing.util.DownloadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class WeiboTransferServiceImpl implements WeiboTransferService {

    @Override
    public List<UserInfo> transferUserInfo(List<WeiboSearchResponseDTO.DataDTO.CardsDTO.CardGroupDTO.UserDTO> userGroup) {
        return Optional.ofNullable(userGroup)
                .orElse(Collections.emptyList())
                .stream()
                .map(userDTO -> UserInfo.builder()
                        .userId(userDTO.getId())
                        .userName(userDTO.getScreenName())
                        .userDescription(userDTO.getDescription())
                        .userGender((byte) ("m".equals(userDTO.getGender()) ? 0 : 1))
                        .userHeadImageUrl(DownloadUtil.download(getImageLarge(userDTO.getAvatarHd()), Company.WEIBO + File.separator + userDTO.getId() + File.separator + "avatar", String.valueOf(DateUtil.currentSeconds()), Media.JPG))
                        .userVerifiedReason(userDTO.getVerifiedReason())
                        .userFollowingCount(String.valueOf(userDTO.getFollowCount()))
                        .userFollowersCount(userDTO.getFollowersCountStr())
                        .userIsVerified((byte) (Boolean.TRUE.equals(userDTO.getVerified()) ? 1 : 0))
                        .userVerifiedType(String.valueOf(userDTO.getVerifiedType()))
                        .userCoverImageUrl(DownloadUtil.download(getImageLarge(userDTO.getCoverImagePhone()), Company.WEIBO + File.separator + userDTO.getId() + File.separator + "cover", String.valueOf(DateUtil.currentSeconds()), Media.JPG))
                        .build()
                ).collect(Collectors.toList());
    }

    /**
     * 获取 large 影像件
     *
     * @param image 影像件地址
     * @return large image
     */
    private String getImageLarge(String image) {
        int index1 = image.indexOf(".cn");
        if (index1 == -1) {
            return image;
        }
        index1 += 4;
        String head = image.substring(0, index1);
        String end = image.substring(index1 + 1);
        int index2 = end.indexOf(Symbol.SLASH);
        if (index2 == -1) {
            return image;
        }
        end = end.substring(index2);
        return head + "large" + end;
    }
}
