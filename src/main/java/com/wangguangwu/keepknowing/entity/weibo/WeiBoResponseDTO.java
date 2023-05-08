package com.wangguangwu.keepknowing.entity.weibo;

import com.alibaba.fastjson.JSONObject;
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
@SuppressWarnings("all")
public class WeiBoResponseDTO {

    @JsonProperty("data")
    private DataDTO data;
    @JsonProperty("ok")
    private Integer ok;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JsonProperty("since_id")
        private String sinceId;
        @JsonProperty("list")
        private List<ListDTO> list;
        @JsonProperty("status_visible")
        private Integer statusVisible;
        @JsonProperty("bottom_tips_visible")
        private Boolean bottomTipsVisible;
        @JsonProperty("bottom_tips_text")
        private String bottomTipsText;
        @JsonProperty("topicList")
        private List<?> topicList;
        @JsonProperty("total")
        private Integer total;

        @NoArgsConstructor
        @Data
        public static class ListDTO {
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
            @JsonProperty("source")
            private String source;
            @JsonProperty("favorited")
            private Boolean favorited;
            @JsonProperty("rid")
            private String rid;
            @JsonProperty("cardid")
            private String cardid;
            @JsonProperty("pic_ids")
            private List<String> picIds;
            @JsonProperty("geo")
            private String geo;
            @JsonProperty("pic_num")
            private Integer picNum;
            @JsonProperty("is_paid")
            private Boolean isPaid;
            @JsonProperty("pic_bg_new")
            private String picBgNew;
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
            @JsonProperty("repost_type")
            private Integer repostType;
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
            @JsonProperty("retweeted_status")
            private RetweetedStatusDTO retweetedStatus;
            @JsonProperty("topic_struct")
            private List<TopicStructDTO> topicStruct;
            @JsonProperty("url_struct")
            private List<UrlStructDTO> urlStruct;
            @JsonProperty("page_info")
            private PageInfoDTO pageInfo;
            @JsonProperty("textLength")
            private Integer textLength;
            @JsonProperty("pic_focus_point")
            private List<PicFocusPointDTO> picFocusPoint;
            @JsonProperty("pic_infos")
            private JSONObject picInfos;

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
                private List<IconListDTO> iconList;

                @NoArgsConstructor
                @Data
                public static class IconListDTO {
                    @JsonProperty("type")
                    private String type;
                }
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
            public static class RetweetedStatusDTO {
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
                @JsonProperty("cardid")
                private String cardid;
                @JsonProperty("pic_ids")
                private List<?> picIds;
                @JsonProperty("geo")
                private String geo;
                @JsonProperty("pic_num")
                private Integer picNum;
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
                    private List<IconListDTO> iconList;

                    @NoArgsConstructor
                    @Data
                    public static class IconListDTO {
                        @JsonProperty("type")
                        private String type;
                    }
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
            }

            @NoArgsConstructor
            @Data
            public static class PageInfoDTO {
                @JsonProperty("type")
                private String type;
                @JsonProperty("page_id")
                private String pageId;
                @JsonProperty("object_type")
                private String objectType;
                @JsonProperty("object_id")
                private String objectId;
                @JsonProperty("content1")
                private String content1;
                @JsonProperty("content2")
                private String content2;
                @JsonProperty("act_status")
                private Integer actStatus;
                @JsonProperty("media_info")
                private MediaInfoDTO mediaInfo;
                @JsonProperty("page_pic")
                private String pagePic;
                @JsonProperty("page_title")
                private String pageTitle;
                @JsonProperty("page_url")
                private String pageUrl;
                @JsonProperty("pic_info")
                private PicInfoDTO picInfo;
                @JsonProperty("oid")
                private String oid;
                @JsonProperty("type_icon")
                private String typeIcon;
                @JsonProperty("author_id")
                private String authorId;
                @JsonProperty("authorid")
                private String authorid;
                @JsonProperty("warn")
                private String warn;
                @JsonProperty("actionlog")
                private ActionlogDTO actionlog;

                @NoArgsConstructor
                @Data
                public static class MediaInfoDTO {
                    @JsonProperty("video_orientation")
                    private String videoOrientation;
                    @JsonProperty("name")
                    private String name;
                    @JsonProperty("stream_url")
                    private String streamUrl;
                    @JsonProperty("stream_url_hd")
                    private String streamUrlHd;
                    @JsonProperty("h5_url")
                    private String h5Url;
                    @JsonProperty("mp4_sd_url")
                    private String mp4SdUrl;
                    @JsonProperty("mp4_hd_url")
                    private String mp4HdUrl;
                    @JsonProperty("h265_mp4_hd")
                    private String h265Mp4Hd;
                    @JsonProperty("h265_mp4_ld")
                    private String h265Mp4Ld;
                    @JsonProperty("inch_4_mp4_hd")
                    private String inch4Mp4Hd;
                    @JsonProperty("inch_5_mp4_hd")
                    private String inch5Mp4Hd;
                    @JsonProperty("inch_5_5_mp4_hd")
                    private String inch55Mp4Hd;
                    @JsonProperty("mp4_720p_mp4")
                    private String mp4720pMp4;
                    @JsonProperty("hevc_mp4_720p")
                    private String hevcMp4720p;
                    @JsonProperty("prefetch_type")
                    private Integer prefetchType;
                    @JsonProperty("prefetch_size")
                    private Integer prefetchSize;
                    @JsonProperty("act_status")
                    private Integer actStatus;
                    @JsonProperty("protocol")
                    private String protocol;
                    @JsonProperty("media_id")
                    private String mediaId;
                    @JsonProperty("origin_total_bitrate")
                    private Integer originTotalBitrate;
                    @JsonProperty("duration")
                    private Integer duration;
                    @JsonProperty("forward_strategy")
                    private Integer forwardStrategy;
                    @JsonProperty("search_scheme")
                    private String searchScheme;
                    @JsonProperty("is_short_video")
                    private Integer isShortVideo;
                    @JsonProperty("vote_is_show")
                    private Integer voteIsShow;
                    @JsonProperty("belong_collection")
                    private Integer belongCollection;
                    @JsonProperty("titles_display_time")
                    private String titlesDisplayTime;
                    @JsonProperty("show_progress_bar")
                    private Integer showProgressBar;
                    @JsonProperty("ext_info")
                    private ExtInfoDTO extInfo;
                    @JsonProperty("next_title")
                    private String nextTitle;
                    @JsonProperty("kol_title")
                    private String kolTitle;
                    @JsonProperty("play_completion_actions")
                    private List<PlayCompletionActionsDTO> playCompletionActions;
                    @JsonProperty("video_publish_time")
                    private Integer videoPublishTime;
                    @JsonProperty("play_loop_type")
                    private Integer playLoopType;
                    @JsonProperty("video_title")
                    private String videoTitle;
                    @JsonProperty("author_mid")
                    private String authorMid;
                    @JsonProperty("author_name")
                    private String authorName;
                    @JsonProperty("extra_info")
                    private ExtraInfoDTO extraInfo;
                    @JsonProperty("has_recommend_video")
                    private Integer hasRecommendVideo;
                    @JsonProperty("video_download_strategy")
                    private VideoDownloadStrategyDTO videoDownloadStrategy;
                    @JsonProperty("jump_to")
                    private Integer jumpTo;
                    @JsonProperty("online_users")
                    private String onlineUsers;
                    @JsonProperty("online_users_number")
                    private Integer onlineUsersNumber;
                    @JsonProperty("ttl")
                    private Integer ttl;
                    @JsonProperty("storage_type")
                    private String storageType;
                    @JsonProperty("is_keep_current_mblog")
                    private Integer isKeepCurrentMblog;
                    @JsonProperty("author_info")
                    private AuthorInfoDTO authorInfo;
                    @JsonProperty("playback_list")
                    private List<PlaybackListDTO> playbackList;

                    @NoArgsConstructor
                    @Data
                    public static class ExtInfoDTO {
                        @JsonProperty("video_orientation")
                        private String videoOrientation;
                    }

                    @NoArgsConstructor
                    @Data
                    public static class ExtraInfoDTO {
                        @JsonProperty("sceneid")
                        private String sceneid;
                    }

                    @NoArgsConstructor
                    @Data
                    public static class VideoDownloadStrategyDTO {
                        @JsonProperty("abandon_download")
                        private Integer abandonDownload;
                    }

                    @NoArgsConstructor
                    @Data
                    public static class AuthorInfoDTO {
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
                        @JsonProperty("description")
                        private String description;
                        @JsonProperty("location")
                        private String location;
                        @JsonProperty("gender")
                        private String gender;
                        @JsonProperty("followers_count")
                        private Integer followersCount;
                        @JsonProperty("followers_count_str")
                        private String followersCountStr;
                        @JsonProperty("friends_count")
                        private Integer friendsCount;
                        @JsonProperty("statuses_count")
                        private Integer statusesCount;
                        @JsonProperty("url")
                        private String url;
                        @JsonProperty("svip")
                        private Integer svip;
                        @JsonProperty("cover_image_phone")
                        private String coverImagePhone;
                    }

                    @NoArgsConstructor
                    @Data
                    public static class PlayCompletionActionsDTO {
                        @JsonProperty("type")
                        private String type;
                        @JsonProperty("icon")
                        private String icon;
                        @JsonProperty("text")
                        private String text;
                        @JsonProperty("link")
                        private String link;
                        @JsonProperty("btn_code")
                        private Integer btnCode;
                        @JsonProperty("show_position")
                        private Integer showPosition;
                        @JsonProperty("actionlog")
                        private ActionlogDTO actionlog;
                        @JsonProperty("display_starttime")
                        private Integer displayStarttime;
                        @JsonProperty("display_endtime")
                        private Integer displayEndtime;
                        @JsonProperty("countdown_time")
                        private Integer countdownTime;
                        @JsonProperty("scheme")
                        private String scheme;
                        @JsonProperty("ext")
                        private ExtDTO ext;
                        @JsonProperty("display_mode")
                        private Integer displayMode;
                        @JsonProperty("display_type")
                        private Integer displayType;

                        @NoArgsConstructor
                        @Data
                        public static class ActionlogDTO {
                            @JsonProperty("oid")
                            private String oid;
                            @JsonProperty("act_code")
                            private Integer actCode;
                            @JsonProperty("act_type")
                            private Integer actType;
                            @JsonProperty("source")
                            private String source;
                        }

                        @NoArgsConstructor
                        @Data
                        public static class ExtDTO {
                            @JsonProperty("uid")
                            private String uid;
                            @JsonProperty("user_name")
                            private String userName;
                            @JsonProperty("followers_count")
                            private Integer followersCount;
                            @JsonProperty("verified_type")
                            private Integer verifiedType;
                            @JsonProperty("level")
                            private Integer level;
                        }
                    }

                    @NoArgsConstructor
                    @Data
                    public static class PlaybackListDTO {
                        @JsonProperty("meta")
                        private MetaDTO meta;
                        @JsonProperty("play_info")
                        private PlayInfoDTO playInfo;

                        @NoArgsConstructor
                        @Data
                        public static class MetaDTO {
                            @JsonProperty("label")
                            private String label;
                            @JsonProperty("quality_index")
                            private Integer qualityIndex;
                            @JsonProperty("quality_desc")
                            private String qualityDesc;
                            @JsonProperty("quality_label")
                            private String qualityLabel;
                            @JsonProperty("quality_class")
                            private String qualityClass;
                            @JsonProperty("type")
                            private Integer type;
                            @JsonProperty("quality_group")
                            private Integer qualityGroup;
                            @JsonProperty("is_hidden")
                            private Boolean isHidden;
                        }

                        @NoArgsConstructor
                        @Data
                        public static class PlayInfoDTO {
                            @JsonProperty("type")
                            private Integer type;
                            @JsonProperty("mime")
                            private String mime;
                            @JsonProperty("protocol")
                            private String protocol;
                            @JsonProperty("label")
                            private String label;
                            @JsonProperty("url")
                            private String url;
                            @JsonProperty("bitrate")
                            private Integer bitrate;
                            @JsonProperty("prefetch_range")
                            private String prefetchRange;
                            @JsonProperty("video_codecs")
                            private String videoCodecs;
                            @JsonProperty("fps")
                            private Integer fps;
                            @JsonProperty("width")
                            private Integer width;
                            @JsonProperty("height")
                            private Integer height;
                            @JsonProperty("size")
                            private Integer size;
                            @JsonProperty("duration")
                            private Double duration;
                            @JsonProperty("sar")
                            private String sar;
                            @JsonProperty("audio_codecs")
                            private String audioCodecs;
                            @JsonProperty("audio_sample_rate")
                            private Integer audioSampleRate;
                            @JsonProperty("quality_label")
                            private String qualityLabel;
                            @JsonProperty("quality_class")
                            private String qualityClass;
                            @JsonProperty("quality_desc")
                            private String qualityDesc;
                            @JsonProperty("audio_channels")
                            private Integer audioChannels;
                            @JsonProperty("audio_sample_fmt")
                            private String audioSampleFmt;
                            @JsonProperty("audio_bits_per_sample")
                            private Integer audioBitsPerSample;
                            @JsonProperty("watermark")
                            private String watermark;
                            @JsonProperty("extension")
                            private ExtensionDTO extension;
                            @JsonProperty("video_decoder")
                            private String videoDecoder;
                            @JsonProperty("prefetch_enabled")
                            private Boolean prefetchEnabled;
                            @JsonProperty("tcp_receive_buffer")
                            private Integer tcpReceiveBuffer;

                            @NoArgsConstructor
                            @Data
                            public static class ExtensionDTO {
                                @JsonProperty("transcode_info")
                                private TranscodeInfoDTO transcodeInfo;

                                @NoArgsConstructor
                                @Data
                                public static class TranscodeInfoDTO {
                                    @JsonProperty("pcdn_rule_id")
                                    private Integer pcdnRuleId;
                                    @JsonProperty("pcdn_jank")
                                    private Integer pcdnJank;
                                    @JsonProperty("origin_video_dr")
                                    private String originVideoDr;
                                    @JsonProperty("ab_strategies")
                                    private String abStrategies;
                                }
                            }
                        }
                    }
                }

                @NoArgsConstructor
                @Data
                public static class PicInfoDTO {
                    @JsonProperty("pic_big")
                    private PicBigDTO picBig;
                    @JsonProperty("pic_small")
                    private PicSmallDTO picSmall;
                    @JsonProperty("pic_middle")
                    private PicMiddleDTO picMiddle;

                    @NoArgsConstructor
                    @Data
                    public static class PicBigDTO {
                        @JsonProperty("height")
                        private String height;
                        @JsonProperty("url")
                        private String url;
                        @JsonProperty("width")
                        private String width;
                    }

                    @NoArgsConstructor
                    @Data
                    public static class PicSmallDTO {
                        @JsonProperty("height")
                        private String height;
                        @JsonProperty("url")
                        private String url;
                        @JsonProperty("width")
                        private String width;
                    }

                    @NoArgsConstructor
                    @Data
                    public static class PicMiddleDTO {
                        @JsonProperty("url")
                        private String url;
                        @JsonProperty("height")
                        private String height;
                        @JsonProperty("width")
                        private String width;
                    }
                }

                @NoArgsConstructor
                @Data
                public static class ActionlogDTO {
                    @JsonProperty("act_type")
                    private Integer actType;
                    @JsonProperty("act_code")
                    private Integer actCode;
                    @JsonProperty("lcardid")
                    private String lcardid;
                    @JsonProperty("fid")
                    private String fid;
                    @JsonProperty("mid")
                    private String mid;
                    @JsonProperty("oid")
                    private String oid;
                    @JsonProperty("uuid")
                    private Long uuid;
                    @JsonProperty("source")
                    private String source;
                    @JsonProperty("ext")
                    private String ext;
                }
            }

            @NoArgsConstructor
            @Data
            public static class TopicStructDTO {
                @JsonProperty("title")
                private String title;
                @JsonProperty("topic_url")
                private String topicUrl;
                @JsonProperty("topic_title")
                private String topicTitle;
                @JsonProperty("is_invalid")
                private Integer isInvalid;
                @JsonProperty("actionlog")
                private ActionlogDTO actionlog;

                @NoArgsConstructor
                @Data
                public static class ActionlogDTO {
                    @JsonProperty("act_type")
                    private Integer actType;
                    @JsonProperty("act_code")
                    private Integer actCode;
                    @JsonProperty("oid")
                    private String oid;
                    @JsonProperty("uuid")
                    private Long uuid;
                    @JsonProperty("cardid")
                    private String cardid;
                    @JsonProperty("lcardid")
                    private String lcardid;
                    @JsonProperty("uicode")
                    private String uicode;
                    @JsonProperty("luicode")
                    private String luicode;
                    @JsonProperty("fid")
                    private String fid;
                    @JsonProperty("lfid")
                    private String lfid;
                    @JsonProperty("ext")
                    private String ext;
                }
            }

            @NoArgsConstructor
            @Data
            public static class UrlStructDTO {
                @JsonProperty("url_title")
                private String urlTitle;
                @JsonProperty("url_type_pic")
                private String urlTypePic;
                @JsonProperty("ori_url")
                private String oriUrl;
                @JsonProperty("page_id")
                private String pageId;
                @JsonProperty("short_url")
                private String shortUrl;
                @JsonProperty("long_url")
                private String longUrl;
                @JsonProperty("url_type")
                private Integer urlType;
                @JsonProperty("result")
                private Boolean result;
                @JsonProperty("actionlog")
                private ActionlogDTO actionlog;
                @JsonProperty("storage_type")
                private String storageType;
                @JsonProperty("hide")
                private Integer hide;
                @JsonProperty("object_type")
                private String objectType;
                @JsonProperty("ttl")
                private Integer ttl;
                @JsonProperty("need_save_obj")
                private Integer needSaveObj;

                @NoArgsConstructor
                @Data
                public static class ActionlogDTO {
                    @JsonProperty("act_type")
                    private Integer actType;
                    @JsonProperty("act_code")
                    private Integer actCode;
                    @JsonProperty("oid")
                    private String oid;
                    @JsonProperty("uuid")
                    private Long uuid;
                    @JsonProperty("cardid")
                    private String cardid;
                    @JsonProperty("lcardid")
                    private String lcardid;
                    @JsonProperty("uicode")
                    private String uicode;
                    @JsonProperty("luicode")
                    private String luicode;
                    @JsonProperty("fid")
                    private String fid;
                    @JsonProperty("lfid")
                    private String lfid;
                    @JsonProperty("ext")
                    private String ext;
                }
            }

            @NoArgsConstructor
            @Data
            public static class PicFocusPointDTO {
                @JsonProperty("focus_point")
                private FocusPointDTO focusPoint;
                @JsonProperty("pic_id")
                private String picId;

                @NoArgsConstructor
                @Data
                public static class FocusPointDTO {
                    @JsonProperty("left")
                    private Double left;
                    @JsonProperty("top")
                    private Double top;
                    @JsonProperty("width")
                    private Double width;
                    @JsonProperty("height")
                    private Double height;
                }
            }
        }
    }
}