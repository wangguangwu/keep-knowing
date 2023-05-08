package com.wangguangwu.keepknowing.entity.weibo;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangguangwu
 */
@NoArgsConstructor
@Data
public class WeiboVideoResponseDTO {

    @JsonProperty("code")
    private String code;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JsonProperty("Component_Play_Playinfo")
        private ComponentPlayPlayinfoDTO componentPlayPlayinfo;

        @NoArgsConstructor
        @Data
        public static class ComponentPlayPlayinfoDTO {
            @JsonProperty("mid")
            private Long mid;
            @JsonProperty("id")
            private String id;
            @JsonProperty("oid")
            private String oid;
            @JsonProperty("media_id")
            private Long mediaId;
            @JsonProperty("user")
            private UserDTO user;
            @JsonProperty("is_follow")
            private Boolean isFollow;
            @JsonProperty("attitude")
            private Boolean attitude;
            @JsonProperty("date")
            private String date;
            @JsonProperty("real_date")
            private Integer realDate;
            @JsonProperty("idstr")
            private String idstr;
            @JsonProperty("author")
            private String author;
            @JsonProperty("nickname")
            private String nickname;
            @JsonProperty("verified")
            private Boolean verified;
            @JsonProperty("verified_type")
            private Integer verifiedType;
            @JsonProperty("verified_type_ext")
            private Object verifiedTypeExt;
            @JsonProperty("verified_reason")
            private String verifiedReason;
            @JsonProperty("avatar")
            private String avatar;
            @JsonProperty("followers_count")
            private String followersCount;
            @JsonProperty("reposts_count")
            private String repostsCount;
            @JsonProperty("comments_count")
            private String commentsCount;
            @JsonProperty("attitudes_count")
            private Integer attitudesCount;
            @JsonProperty("title")
            private String title;
            @JsonProperty("urls")
            private JSONObject urls;
            @JsonProperty("cover_image")
            private String coverImage;
            @JsonProperty("duration")
            private String duration;
            @JsonProperty("duration_time")
            private Double durationTime;
            @JsonProperty("play_start")
            private Integer playStart;
            @JsonProperty("play_start_time")
            private Integer playStartTime;
            @JsonProperty("play_count")
            private String playCount;
            @JsonProperty("topics")
            private Object topics;
            @JsonProperty("uuid")
            private String uuid;
            @JsonProperty("text")
            private String text;
            @JsonProperty("url_short")
            private String urlShort;
            @JsonProperty("is_show_bulletin")
            private Integer isShowBulletin;
            @JsonProperty("comment_manage_info")
            private CommentManageInfoDTO commentManageInfo;
            @JsonProperty("video_orientation")
            private String videoOrientation;
            @JsonProperty("is_contribution")
            private Integer isContribution;
            @JsonProperty("live")
            private Boolean live;
            @JsonProperty("ip_info_str")
            private String ipInfoStr;
            @JsonProperty("attitude_dynamic_adid")
            private String attitudeDynamicAdid;
            @JsonProperty("user_video_count")
            private Integer userVideoCount;
            @JsonProperty("allow_comment")
            private Boolean allowComment;

            @NoArgsConstructor
            @Data
            public static class UserDTO {
                @JsonProperty("id")
                private Long id;
            }

            @NoArgsConstructor
            @Data
            public static class CommentManageInfoDTO {
                @JsonProperty("comment_permission_type")
                private Integer commentPermissionType;
                @JsonProperty("approval_comment_type")
                private Integer approvalCommentType;
            }
        }
    }
}