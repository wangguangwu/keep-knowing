package com.wangguangwu.keepknowing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.*;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author wangguangwu
 * @since 2023-05-06
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 微博用户 id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 用户名称
     */
    @TableField("user_name")
    private String userName;

    /**
     * 用户描述
     */
    @TableField("user_description")
    private String userDescription;

    /**
     * 性别，0:男；1:女；2:未知
     */
    @TableField("user_gender")
    private Byte userGender;

    /**
     * 关注多少人
     */
    @TableField("user_following_count")
    private String userFollowingCount;

    /**
     * followersCount
     */
    @TableField("user_followers_count")
    private String userFollowersCount;

    /**
     * 头像地址
     */
    @TableField("user_head_image_url")
    private String userHeadImageUrl;

    /**
     * 背景图地址
     */
    @TableField("user_cover_image_url")
    private String userCoverImageUrl;

    /**
     * 是否认证，0:未认证；1:已认证
     */
    @TableField("user_is_verified")
    private Byte userIsVerified;

    /**
     * 认证类型
     */
    @TableField("user_verified_type")
    private String userVerifiedType;

    /**
     * 认证类型原因
     */
    @TableField("user_verified_reason")
    private String userVerifiedReason;

    /**
     * 是否删除；0：未删除，1：删除
     */
    @TableField("is_deleted")
    @TableLogic
    private Byte isDeleted;

    /**
     * 创建时间
     */
    @TableField("gmt_create")
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    @TableField("gmt_modified")
    private LocalDateTime gmtModified;
}
