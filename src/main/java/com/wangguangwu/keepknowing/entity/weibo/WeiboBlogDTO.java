package com.wangguangwu.keepknowing.entity.weibo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wangguangwu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeiboBlogDTO {

    @JsonProperty("visible")
    private VisibleDTO visible;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("idstr")
    private String idstr;
    @JsonProperty("mid")
    private String mid;
    @JsonProperty("mblogid")
    private String mblogid;
    @JsonProperty("user")
    private UserDTO user;
    @JsonProperty("can_edit")
    private Boolean canEdit;
    @JsonProperty("text_raw")
    private String textRaw;
    @JsonProperty("text")
    private String text;
    @JsonProperty("textLength")
    private Integer textLength;
    @JsonProperty("source")
    private String source;
    @JsonProperty("favorited")
    private Boolean favorited;
    @JsonProperty("rid")
    private String rid;
    @JsonProperty("pic_ids")
    private List<String> picIds;
    @JsonProperty("geo")
    private String geo;
    @JsonProperty("pic_num")
    private Integer picNum;
    @JsonProperty("pic_infos")
    private Object picInfos;
    @JsonProperty("is_paid")
    private Boolean isPaid;
    @JsonProperty("mblog_vip_type")
    private Integer mblogVipType;
    @JsonProperty("number_display_strategy")
    private NumberDisplayStrategyDTO numberDisplayStrategy;
    @JsonProperty("reposts_count")
    private Integer repostsCount;
    @JsonProperty("comments_count")
    private Integer commentsCount;
    @JsonProperty("attitudes_count")
    private Integer attitudesCount;
    @JsonProperty("attitudes_status")
    private Integer attitudesStatus;
    @JsonProperty("isLongText")
    private Boolean isLongText;
    @JsonProperty("mlevel")
    private Integer mlevel;
    @JsonProperty("content_auth")
    private Integer contentAuth;
    @JsonProperty("is_show_bulletin")
    private Integer isShowBulletin;
    @JsonProperty("comment_manage_info")
    private CommentManageInfoDTO commentManageInfo;
    @JsonProperty("share_repost_type")
    private Integer shareRepostType;
    @JsonProperty("mblogtype")
    private Integer mblogtype;
    @JsonProperty("showFeedRepost")
    private Boolean showFeedRepost;
    @JsonProperty("showFeedComment")
    private Boolean showFeedComment;
    @JsonProperty("pictureViewerSign")
    private Boolean pictureViewerSign;
    @JsonProperty("showPictureViewer")
    private Boolean showPictureViewer;
    @JsonProperty("rcList")
    private List<?> rcList;
    @JsonProperty("region_name")
    private String regionName;
    @JsonProperty("customIcons")
    private List<?> customIcons;

    @NoArgsConstructor
    @Data
    public static class VisibleDTO {
        @JsonProperty("type")
        private Integer type;
        @JsonProperty("list_id")
        private Integer listId;
    }

    @NoArgsConstructor
    @Data
    public static class UserDTO {
        @JsonProperty("id")
        private Long id;
        @JsonProperty("idstr")
        private String idstr;
        @JsonProperty("pc_new")
        private Integer pcNew;
        @JsonProperty("screen_name")
        private String screenName;
        @JsonProperty("profile_image_url")
        private String profileImageUrl;
        @JsonProperty("profile_url")
        private String profileUrl;
        @JsonProperty("verified")
        private Boolean verified;
        @JsonProperty("verified_type")
        private Integer verifiedType;
        @JsonProperty("domain")
        private String domain;
        @JsonProperty("weihao")
        private String weihao;
        @JsonProperty("avatar_large")
        private String avatarLarge;
        @JsonProperty("avatar_hd")
        private String avatarHd;
        @JsonProperty("follow_me")
        private Boolean followMe;
        @JsonProperty("following")
        private Boolean following;
        @JsonProperty("mbrank")
        private Integer mbrank;
        @JsonProperty("mbtype")
        private Integer mbtype;
        @JsonProperty("planet_video")
        private Boolean planetVideo;
        @JsonProperty("icon_list")
        private List<?> iconList;
    }

    @NoArgsConstructor
    @Data
    public static class NumberDisplayStrategyDTO {
        @JsonProperty("apply_scenario_flag")
        private Integer applyScenarioFlag;
        @JsonProperty("display_text_min_number")
        private Integer displayTextMinNumber;
        @JsonProperty("display_text")
        private String displayText;
    }

    @NoArgsConstructor
    @Data
    public static class CommentManageInfoDTO {
        @JsonProperty("comment_permission_type")
        private Integer commentPermissionType;
        @JsonProperty("approval_comment_type")
        private Integer approvalCommentType;
        @JsonProperty("comment_sort_type")
        private Integer commentSortType;
    }

    @NoArgsConstructor
    @Data
    public static class PicInfoDTO {

        @JsonProperty("thumbnail")
        private ThumbnailDTO thumbnail;
        @JsonProperty("bmiddle")
        private BmiddleDTO bmiddle;
        @JsonProperty("large")
        private LargeDTO large;
        @JsonProperty("original")
        private OriginalDTO original;
        @JsonProperty("largest")
        private LargestDTO largest;
        @JsonProperty("mw2000")
        private Mw2000DTO mw2000;
        @JsonProperty("object_id")
        private String objectId;
        @JsonProperty("pic_id")
        private String picId;
        @JsonProperty("photo_tag")
        private Integer photoTag;
        @JsonProperty("video")
        private String video;
        @JsonProperty("type")
        private String type;
        @JsonProperty("fid")
        private String fid;
        @JsonProperty("pic_status")
        private Integer picStatus;

        @NoArgsConstructor
        @Data
        public static class ThumbnailDTO {
            @JsonProperty("url")
            private String url;
            @JsonProperty("width")
            private Integer width;
            @JsonProperty("height")
            private Integer height;
            @JsonProperty("cut_type")
            private Integer cutType;
            @JsonProperty("type")
            private String type;
        }

        @NoArgsConstructor
        @Data
        public static class BmiddleDTO {
            @JsonProperty("url")
            private String url;
            @JsonProperty("width")
            private Integer width;
            @JsonProperty("height")
            private Integer height;
            @JsonProperty("cut_type")
            private Integer cutType;
            @JsonProperty("type")
            private String type;
        }

        @NoArgsConstructor
        @Data
        public static class LargeDTO {
            @JsonProperty("url")
            private String url;
            @JsonProperty("width")
            private Integer width;
            @JsonProperty("height")
            private Integer height;
            @JsonProperty("cut_type")
            private Integer cutType;
            @JsonProperty("type")
            private String type;
        }

        @NoArgsConstructor
        @Data
        public static class OriginalDTO {
            @JsonProperty("url")
            private String url;
            @JsonProperty("width")
            private Integer width;
            @JsonProperty("height")
            private Integer height;
            @JsonProperty("cut_type")
            private Integer cutType;
            @JsonProperty("type")
            private String type;
        }

        @NoArgsConstructor
        @Data
        public static class LargestDTO {
            @JsonProperty("url")
            private String url;
            @JsonProperty("width")
            private Integer width;
            @JsonProperty("height")
            private Integer height;
            @JsonProperty("cut_type")
            private Integer cutType;
            @JsonProperty("type")
            private String type;
        }

        @NoArgsConstructor
        @Data
        public static class Mw2000DTO {
            @JsonProperty("url")
            private String url;
            @JsonProperty("width")
            private Integer width;
            @JsonProperty("height")
            private Integer height;
            @JsonProperty("cut_type")
            private Integer cutType;
            @JsonProperty("type")
            private String type;
        }
    }
}
