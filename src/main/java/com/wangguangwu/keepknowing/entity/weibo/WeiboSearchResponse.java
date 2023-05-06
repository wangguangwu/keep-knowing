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
@SuppressWarnings("all")
public class WeiboSearchResponse {

    @JsonProperty("ok")
    private Integer ok;
    @JsonProperty("data")
    private DataDTO data;

    @Data
    @NoArgsConstructor
    public static class DataDTO {
        @JsonProperty("cardlistInfo")
        private CardlistInfoDTO cardlistInfo;
        @JsonProperty("cards")
        private List<CardsDTO> cards;
        @JsonProperty("ext_trans")
        private ExtTransDTO extTrans;
        @JsonProperty("scheme")
        private String scheme;
        @JsonProperty("showAppTips")
        private Integer showAppTips;

        @Data
        @NoArgsConstructor
        public static class CardlistInfoDTO {
            @JsonProperty("v_p")
            private String vP;
            @JsonProperty("containerid")
            private String containerid;
            @JsonProperty("title_top")
            private String titleTop;
            @JsonProperty("total")
            private Integer total;
            @JsonProperty("starttime")
            private Integer starttime;
            @JsonProperty("search_request_id")
            private String searchRequestId;
            @JsonProperty("search_ssid")
            private String searchSsid;
            @JsonProperty("can_shared")
            private Integer canShared;
            @JsonProperty("cardlist_head_cards")
            private List<CardlistHeadCardsDTO> cardlistHeadCards;
            @JsonProperty("toolbar_menus")
            private List<ToolbarMenusDTO> toolbarMenus;
            @JsonProperty("page_size")
            private String pageSize;
            @JsonProperty("show_style")
            private Integer showStyle;
            @JsonProperty("shared_text")
            private String sharedText;
            @JsonProperty("share_containerid")
            private String shareContainerid;
            @JsonProperty("cardlist_title")
            private String cardlistTitle;
            @JsonProperty("desc")
            private String desc;
            @JsonProperty("portrait")
            private String portrait;
            @JsonProperty("shared_text_qrcode")
            private String sharedTextQrcode;
            @JsonProperty("share_content")
            private ShareContentDTO shareContent;
            @JsonProperty("page")
            private Integer page;

            @Data
            @NoArgsConstructor
            public static class ShareContentDTO {
                @JsonProperty("description")
                private String description;
                @JsonProperty("icon")
                private String icon;
            }

            @Data
            @NoArgsConstructor
            public static class CardlistHeadCardsDTO {
                @JsonProperty("head_type")
                private Integer headType;
                @JsonProperty("head_type_name")
                private String headTypeName;
                @JsonProperty("show_menu")
                private Integer showMenu;
                @JsonProperty("menu_scheme")
                private String menuScheme;
                @JsonProperty("channel_list")
                private List<ChannelListDTO> channelList;

                @Data
                @NoArgsConstructor
                public static class ChannelListDTO {
                    @JsonProperty("id")
                    private String id;
                    @JsonProperty("name")
                    private String name;
                    @JsonProperty("default_add")
                    private Integer defaultAdd;
                    @JsonProperty("must_show")
                    private Integer mustShow;
                    @JsonProperty("scheme")
                    private String scheme;
                    @JsonProperty("containerid")
                    private String containerid;
                    @JsonProperty("request_mark_interval")
                    private Integer requestMarkInterval;
                    @JsonProperty("actionlog")
                    private ActionlogDTO actionlog;
                    @JsonProperty("type")
                    private String type;

                    @Data
                    @NoArgsConstructor

                    public static class ActionlogDTO {
                        @JsonProperty("act_code")
                        private Integer actCode;
                        @JsonProperty("ext")
                        private String ext;
                        @JsonProperty("luicode")
                        private Object luicode;
                        @JsonProperty("uicode")
                        private Object uicode;
                        @JsonProperty("fid")
                        private String fid;
                        @JsonProperty("lfid")
                        private Object lfid;
                    }
                }
            }

            @Data
            @NoArgsConstructor
            public static class ToolbarMenusDTO {
                @JsonProperty("skip_format")
                private Integer skipFormat;
                @JsonProperty("type")
                private String type;
                @JsonProperty("name")
                private String name;
                @JsonProperty("pic")
                private String pic;
                @JsonProperty("is_expand")
                private Integer isExpand;
                @JsonProperty("params")
                private ParamsDTO params;
                @JsonProperty("actionlog")
                private ActionlogDTO actionlog;
                @JsonProperty("scheme")
                private String scheme;

                @Data
                @NoArgsConstructor
                public static class ParamsDTO {
                    @JsonProperty("scheme")
                    private String scheme;
                }

                @Data
                @NoArgsConstructor
                public static class ActionlogDTO {
                    @JsonProperty("act_code")
                    private Integer actCode;
                    @JsonProperty("ext")
                    private String ext;
                    @JsonProperty("luicode")
                    private Object luicode;
                    @JsonProperty("fid")
                    private String fid;
                    @JsonProperty("lfid")
                    private Object lfid;
                }
            }
        }

        @NoArgsConstructor
        @Data
        public static class ExtTransDTO {
            @JsonProperty("search_ssid")
            private String searchSsid;
        }

        @NoArgsConstructor
        @Data
        public static class CardsDTO {
            @JsonProperty("card_type")
            private Integer cardType;
            @JsonProperty("card_group")
            private List<CardGroupDTO> cardGroup;
            @JsonProperty("show_type")
            private Integer showType;
            @JsonProperty("is_hotweibo")
            private Integer isHotweibo;
            @JsonProperty("display_socialtitle")
            private Integer displaySocialtitle;
            @JsonProperty("display_followbtn")
            private Integer displayFollowbtn;
            @JsonProperty("mblog")
            private MblogDTO mblog;
            @JsonProperty("itemid")
            private String itemid;
            @JsonProperty("actionlog")
            private ActionlogDTO actionlog;
            @JsonProperty("positive_recom_pos")
            private Integer positiveRecomPos;
            @JsonProperty("cate_id")
            private String cateId;
            @JsonProperty("display_arrow")
            private Integer displayArrow;
            @JsonProperty("scheme")
            private String scheme;
            @JsonProperty("container_color")
            private String containerColor;
            @JsonProperty("container_color_dark")
            private String containerColorDark;
            @JsonProperty("title")
            private String title;

            @NoArgsConstructor
            @Data
            public static class MblogDTO {
                @JsonProperty("ac_stat")
                private String acStat;
                @JsonProperty("attitudes_count")
                private Integer attitudesCount;
                @JsonProperty("can_edit")
                private Boolean canEdit;
                @JsonProperty("comment_manage_info")
                private CommentManageInfoDTO commentManageInfo;
                @JsonProperty("comments_count")
                private Integer commentsCount;
                @JsonProperty("content_auth")
                private Integer contentAuth;
                @JsonProperty("created_at")
                private String createdAt;
                @JsonProperty("darwin_tags")
                private List<?> darwinTags;
                @JsonProperty("delThreeYearsStatus")
                private Integer delThreeYearsStatus;
                @JsonProperty("digit_attr")
                private Integer digitAttr;
                @JsonProperty("dispatch_ctrl")
                private Integer dispatchCtrl;
                @JsonProperty("extern_safe")
                private Integer externSafe;
                @JsonProperty("f_level")
                private Integer fLevel;
                @JsonProperty("f_level_1")
                private Integer fLevel1;
                @JsonProperty("f_level_2")
                private Integer fLevel2;
                @JsonProperty("fans")
                private Integer fans;
                @JsonProperty("favorited")
                private Boolean favorited;
                @JsonProperty("hot_page")
                private HotPageDTO hotPage;
                @JsonProperty("id")
                private String id;
                @JsonProperty("isLongText")
                private Boolean isLongText;
                @JsonProperty("is_paid")
                private Boolean isPaid;
                @JsonProperty("jump_type")
                private Integer jumpType;
                @JsonProperty("mblog_vip_type")
                private Integer mblogVipType;
                @JsonProperty("mblogtype")
                private Integer mblogtype;
                @JsonProperty("mid")
                private String mid;
                @JsonProperty("mlevel")
                private Integer mlevel;
                @JsonProperty("new_comment_style")
                private Integer newCommentStyle;
                @JsonProperty("number_display_strategy")
                private NumberDisplayStrategyDTO numberDisplayStrategy;
                @JsonProperty("oversea_filter")
                private String overseaFilter;
                @JsonProperty("oversea_pass")
                private String overseaPass;
                @JsonProperty("pending_approval_count")
                private Integer pendingApprovalCount;
                @JsonProperty("pic_ids")
                private List<?> picIds;
                @JsonProperty("pic_num")
                private Integer picNum;
                @JsonProperty("reposts_count")
                private Integer repostsCount;
                @JsonProperty("reprint_cmt_count")
                private Integer reprintCmtCount;
                @JsonProperty("rid")
                private String rid;
                @JsonProperty("safe_tags")
                private Integer safeTags;
                @JsonProperty("show_additional_indication")
                private Integer showAdditionalIndication;
                @JsonProperty("show_mlevel")
                private Integer showMlevel;
                @JsonProperty("source")
                private String source;
                @JsonProperty("status")
                private Integer status;
                @JsonProperty("status_city")
                private String statusCity;
                @JsonProperty("status_country")
                private String statusCountry;
                @JsonProperty("status_province")
                private String statusProvince;
                @JsonProperty("text")
                private String text;
                @JsonProperty("textLength")
                private Integer textLength;
                @JsonProperty("user")
                private UserDTO user;
                @JsonProperty("visible")
                private VisibleDTO visible;
                @JsonProperty("title")
                private TitleDTO title;
                @JsonProperty("button_business_no")
                private String buttonBusinessNo;
                @JsonProperty("summary_order")
                private List<Integer> summaryOrder;
                @JsonProperty("mblog_show_union_info")
                private Integer mblogShowUnionInfo;
                @JsonProperty("buttons")
                private List<ButtonsDTO> buttons;
                @JsonProperty("itemid")
                private Object itemid;
                @JsonProperty("analysis_extra")
                private String analysisExtra;
                @JsonProperty("page_info")
                private PageInfoDTO pageInfo;
                @JsonProperty("bid")
                private String bid;

                @Data
                @NoArgsConstructor
                public static class CommentManageInfoDTO {
                    @JsonProperty("approval_comment_type")
                    private Integer approvalCommentType;
                    @JsonProperty("comment_permission_type")
                    private Integer commentPermissionType;
                    @JsonProperty("comment_sort_type")
                    private Integer commentSortType;
                }

                @NoArgsConstructor
                @Data
                public static class HotPageDTO {
                    @JsonProperty("feed_detail_type")
                    private Integer feedDetailType;
                    @JsonProperty("fid")
                    private String fid;
                }

                @Data
                @NoArgsConstructor
                public static class NumberDisplayStrategyDTO {
                    @JsonProperty("apply_scenario_flag")
                    private Integer applyScenarioFlag;
                    @JsonProperty("display_text")
                    private String displayText;
                    @JsonProperty("display_text_min_number")
                    private Integer displayTextMinNumber;
                }

                @Data
                @NoArgsConstructor
                public static class UserDTO {
                    @JsonProperty("id")
                    private Long id;
                    @JsonProperty("screen_name")
                    private String screenName;
                    @JsonProperty("profile_image_url")
                    private String profileImageUrl;
                    @JsonProperty("profile_url")
                    private String profileUrl;
                    @JsonProperty("statuses_count")
                    private Integer statusesCount;
                    @JsonProperty("verified")
                    private Boolean verified;
                    @JsonProperty("verified_type")
                    private Integer verifiedType;
                    @JsonProperty("verified_type_ext")
                    private Integer verifiedTypeExt;
                    @JsonProperty("verified_reason")
                    private String verifiedReason;
                    @JsonProperty("close_blue_v")
                    private Boolean closeBlueV;
                    @JsonProperty("description")
                    private String description;
                    @JsonProperty("gender")
                    private String gender;
                    @JsonProperty("mbtype")
                    private Integer mbtype;
                    @JsonProperty("urank")
                    private Integer urank;
                    @JsonProperty("mbrank")
                    private Integer mbrank;
                    @JsonProperty("follow_me")
                    private Boolean followMe;
                    @JsonProperty("following")
                    private Boolean following;
                    @JsonProperty("follow_count")
                    private Integer followCount;
                    @JsonProperty("followers_count")
                    private String followersCount;
                    @JsonProperty("followers_count_str")
                    private String followersCountStr;
                    @JsonProperty("cover_image_phone")
                    private String coverImagePhone;
                    @JsonProperty("avatar_hd")
                    private String avatarHd;
                    @JsonProperty("like")
                    private Boolean like;
                    @JsonProperty("like_me")
                    private Boolean likeMe;
                    @JsonProperty("badge")
                    private BadgeDTO badge;

                    @Data
                    @NoArgsConstructor
                    public static class BadgeDTO {
                        @JsonProperty("kaixue21_2021")
                        private Integer kaixue212021;
                        @JsonProperty("party_cardid_state")
                        private Integer partyCardidState;
                        @JsonProperty("pc_new")
                        private Integer pcNew;
                        @JsonProperty("user_name_certificate")
                        private Integer userNameCertificate;
                        @JsonProperty("vip_activity2")
                        private Integer vipActivity2;
                        @JsonProperty("weibozhiye_2021")
                        private Integer weibozhiye2021;
                    }
                }

                @Data
                @NoArgsConstructor
                public static class VisibleDTO {
                    @JsonProperty("list_id")
                    private Integer listId;
                    @JsonProperty("type")
                    private Integer type;
                }

                @Data
                @NoArgsConstructor
                public static class TitleDTO {
                    @JsonProperty("text")
                    private String text;
                }

                @Data
                @NoArgsConstructor
                public static class PageInfoDTO {
                    @JsonProperty("type")
                    private String type;
                    @JsonProperty("object_type")
                    private Integer objectType;
                    @JsonProperty("url_ori")
                    private String urlOri;
                    @JsonProperty("page_pic")
                    private PagePicDTO pagePic;
                    @JsonProperty("page_url")
                    private String pageUrl;
                    @JsonProperty("object_id")
                    private String objectId;
                    @JsonProperty("page_title")
                    private String pageTitle;
                    @JsonProperty("title")
                    private String title;
                    @JsonProperty("content1")
                    private String content1;
                    @JsonProperty("content2")
                    private String content2;
                    @JsonProperty("video_orientation")
                    private Object videoOrientation;
                    @JsonProperty("play_count")
                    private String playCount;
                    @JsonProperty("media_info")
                    private MediaInfoDTO mediaInfo;
                    @JsonProperty("urls")
                    private Object urls;

                    @Data
                    @NoArgsConstructor
                    public static class PagePicDTO {
                        @JsonProperty("height")
                        private Integer height;
                        @JsonProperty("url")
                        private String url;
                        @JsonProperty("width")
                        private Integer width;
                    }

                    @Data
                    @NoArgsConstructor

                    public static class MediaInfoDTO {
                        @JsonProperty("stream_url")
                        private String streamUrl;
                        @JsonProperty("stream_url_hd")
                        private String streamUrlHd;
                    }
                }

                @Data
                @NoArgsConstructor
                public static class ButtonsDTO {
                    @JsonProperty("sub_type")
                    private Integer subType;
                    @JsonProperty("name")
                    private String name;
                    @JsonProperty("pic")
                    private String pic;
                    @JsonProperty("scheme")
                    private String scheme;
                    @JsonProperty("params")
                    private ParamsDTO params;
                    @JsonProperty("show_loading")
                    private Integer showLoading;
                    @JsonProperty("type")
                    private String type;
                    @JsonProperty("actionlog")
                    private ActionlogDTO actionlog;

                    @Data
                    @NoArgsConstructor

                    public static class ParamsDTO {
                        @JsonProperty("type")
                        private String type;
                        @JsonProperty("uid")
                        private Long uid;
                        @JsonProperty("extparams")
                        private ExtparamsDTO extparams;

                        @NoArgsConstructor
                        @Data
                        public static class ExtparamsDTO {
                            @JsonProperty("followcardid")
                            private String followcardid;
                        }
                    }

                    @Data
                    @NoArgsConstructor
                    public static class ActionlogDTO {
                        @JsonProperty("act_code")
                        private Integer actCode;
                        @JsonProperty("ext")
                        private String ext;
                        @JsonProperty("luicode")
                        private Object luicode;
                        @JsonProperty("uicode")
                        private Object uicode;
                        @JsonProperty("fid")
                        private String fid;
                        @JsonProperty("lfid")
                        private Object lfid;
                    }
                }
            }

            @Data
            @NoArgsConstructor
            public static class ActionlogDTO {
                @JsonProperty("act_code")
                private Integer actCode;
                @JsonProperty("ext")
                private String ext;
                @JsonProperty("luicode")
                private Object luicode;
                @JsonProperty("uicode")
                private Object uicode;
                @JsonProperty("fid")
                private String fid;
                @JsonProperty("lfid")
                private Object lfid;
            }

            @Data
            @NoArgsConstructor
            public static class CardGroupDTO {
                @JsonProperty("card_type")
                private Integer cardType;
                @JsonProperty("itemid")
                private String itemid;
                @JsonProperty("desc1")
                private String desc1;
                @JsonProperty("desc2")
                private String desc2;
                @JsonProperty("scheme")
                private String scheme;
                @JsonProperty("user")
                private UserDTO user;
                @JsonProperty("actionlog")
                private ActionlogDTO actionlog;
                @JsonProperty("buttons")
                private List<ButtonsDTO> buttons;
                @JsonProperty("analysis_extra")
                private String analysisExtra;
                @JsonProperty("type")
                private Integer type;
                @JsonProperty("roundedcorner")
                private Integer roundedcorner;
                @JsonProperty("display_arrow")
                private Integer displayArrow;
                @JsonProperty("items_feature")
                private ItemsFeatureDTO itemsFeature;
                @JsonProperty("margin")
                private List<Integer> margin;
                @JsonProperty("elements")
                private List<ElementsDTO> elements;
                @JsonProperty("users")
                private List<UsersDTO> users;
                @JsonProperty("title")
                private String title;
                @JsonProperty("desc")
                private String desc;
                @JsonProperty("desc_extr")
                private String descExtr;
                @JsonProperty("pic")
                private String pic;
                @JsonProperty("cate_id")
                private String cateId;
                @JsonProperty("container_color")
                private String containerColor;
                @JsonProperty("container_color_dark")
                private String containerColorDark;

                @Data
                @NoArgsConstructor
                public static class UserDTO {
                    @JsonProperty("id")
                    private Long id;
                    @JsonProperty("screen_name")
                    private String screenName;
                    @JsonProperty("profile_image_url")
                    private String profileImageUrl;
                    @JsonProperty("profile_url")
                    private String profileUrl;
                    @JsonProperty("statuses_count")
                    private Integer statusesCount;
                    @JsonProperty("verified")
                    private Boolean verified;
                    @JsonProperty("verified_type")
                    private Integer verifiedType;
                    @JsonProperty("verified_type_ext")
                    private Integer verifiedTypeExt;
                    @JsonProperty("verified_reason")
                    private String verifiedReason;
                    @JsonProperty("close_blue_v")
                    private Boolean closeBlueV;
                    @JsonProperty("description")
                    private String description;
                    @JsonProperty("gender")
                    private String gender;
                    @JsonProperty("mbtype")
                    private Integer mbtype;
                    @JsonProperty("urank")
                    private Integer urank;
                    @JsonProperty("mbrank")
                    private Integer mbrank;
                    @JsonProperty("follow_me")
                    private Boolean followMe;
                    @JsonProperty("following")
                    private Boolean following;
                    @JsonProperty("follow_count")
                    private Integer followCount;
                    @JsonProperty("followers_count")
                    private String followersCount;
                    @JsonProperty("followers_count_str")
                    private String followersCountStr;
                    @JsonProperty("cover_image_phone")
                    private String coverImagePhone;
                    @JsonProperty("avatar_hd")
                    private String avatarHd;
                    @JsonProperty("like")
                    private Boolean like;
                    @JsonProperty("like_me")
                    private Boolean likeMe;
                    @JsonProperty("badge")
                    private BadgeDTO badge;
                    @JsonProperty("desc1")
                    private String desc1;
                    @JsonProperty("desc2")
                    private Object desc2;

                    @Data
                    @NoArgsConstructor
                    public static class BadgeDTO {
                        @JsonProperty("user_name_certificate")
                        private Integer userNameCertificate;
                        @JsonProperty("status_visible")
                        private Integer statusVisible;
                        @JsonProperty("hongrenjie_2019")
                        private Integer hongrenjie2019;
                        @JsonProperty("hongbao_2020")
                        private Integer hongbao2020;
                        @JsonProperty("pc_new")
                        private Integer pcNew;
                        @JsonProperty("hongrenjie_2020")
                        private Integer hongrenjie2020;
                        @JsonProperty("zhongcaoguan_2021")
                        private Integer zhongcaoguan2021;
                        @JsonProperty("hongrenjie_2021")
                        private Integer hongrenjie2021;
                        @JsonProperty("gaokao_2022")
                        private Integer gaokao2022;
                    }
                }

                @Data
                @NoArgsConstructor
                public static class ActionlogDTO {
                    @JsonProperty("act_code")
                    private Integer actCode;
                    @JsonProperty("ext")
                    private String ext;
                    @JsonProperty("luicode")
                    private Object luicode;
                    @JsonProperty("uicode")
                    private Object uicode;
                    @JsonProperty("fid")
                    private String fid;
                    @JsonProperty("lfid")
                    private Object lfid;
                }

                @Data
                @NoArgsConstructor
                public static class ItemsFeatureDTO {
                    @JsonProperty("items")
                    private List<ItemsDTO> items;
                    @JsonProperty("padding")
                    private List<Integer> padding;
                    @JsonProperty("distance")
                    private Integer distance;

                    @Data
                    @NoArgsConstructor
                    public static class ItemsDTO {
                        @JsonProperty("type")
                        private Integer type;
                        @JsonProperty("icon")
                        private String icon;
                        @JsonProperty("icon_dark")
                        private String iconDark;
                        @JsonProperty("display_name")
                        private String displayName;
                        @JsonProperty("scheme")
                        private String scheme;
                        @JsonProperty("actionlog")
                        private ActionlogDTO actionlog;

                        @Data
                        @NoArgsConstructor
                        public static class ActionlogDTO {
                            @JsonProperty("act_code")
                            private Integer actCode;
                            @JsonProperty("ext")
                            private String ext;
                            @JsonProperty("luicode")
                            private Object luicode;
                            @JsonProperty("uicode")
                            private Object uicode;
                            @JsonProperty("fid")
                            private String fid;
                            @JsonProperty("lfid")
                            private Object lfid;
                        }
                    }
                }

                @Data
                @NoArgsConstructor
                public static class ButtonsDTO {
                    @JsonProperty("type")
                    private String type;
                    @JsonProperty("name")
                    private String name;
                    @JsonProperty("name_after")
                    private String nameAfter;
                    @JsonProperty("pic")
                    private String pic;
                    @JsonProperty("pic_after")
                    private String picAfter;
                    @JsonProperty("params")
                    private ParamsDTO params;
                    @JsonProperty("sub_type")
                    private Integer subType;
                    @JsonProperty("actionlog")
                    private ActionlogDTO actionlog;
                    @JsonProperty("scheme")
                    private String scheme;

                    @Data
                    @NoArgsConstructor
                    public static class ParamsDTO {
                        @JsonProperty("uid")
                        private Long uid;
                    }

                    @Data
                    @NoArgsConstructor
                    public static class ActionlogDTO {
                        @JsonProperty("act_code")
                        private Integer actCode;
                        @JsonProperty("ext")
                        private String ext;
                        @JsonProperty("luicode")
                        private Object luicode;
                        @JsonProperty("fid")
                        private String fid;
                        @JsonProperty("lfid")
                        private Object lfid;
                    }
                }

                @Data
                @NoArgsConstructor
                public static class ElementsDTO {
                    @JsonProperty("uid")
                    private String uid;
                    @JsonProperty("scheme")
                    private String scheme;
                    @JsonProperty("actionlog")
                    private ActionlogDTO actionlog;

                    @Data
                    @NoArgsConstructor
                    public static class ActionlogDTO {
                        @JsonProperty("act_code")
                        private Integer actCode;
                        @JsonProperty("ext")
                        private String ext;
                        @JsonProperty("luicode")
                        private Object luicode;
                        @JsonProperty("uicode")
                        private Object uicode;
                        @JsonProperty("fid")
                        private String fid;
                        @JsonProperty("lfid")
                        private Object lfid;
                    }
                }

                @Data
                @NoArgsConstructor
                public static class UsersDTO {
                    @JsonProperty("id")
                    private Long id;
                    @JsonProperty("screen_name")
                    private String screenName;
                    @JsonProperty("profile_image_url")
                    private String profileImageUrl;
                    @JsonProperty("profile_url")
                    private String profileUrl;
                    @JsonProperty("statuses_count")
                    private Integer statusesCount;
                    @JsonProperty("verified")
                    private Boolean verified;
                    @JsonProperty("verified_type")
                    private Integer verifiedType;
                    @JsonProperty("verified_type_ext")
                    private Integer verifiedTypeExt;
                    @JsonProperty("verified_reason")
                    private String verifiedReason;
                    @JsonProperty("close_blue_v")
                    private Boolean closeBlueV;
                    @JsonProperty("description")
                    private String description;
                    @JsonProperty("gender")
                    private String gender;
                    @JsonProperty("mbtype")
                    private Integer mbtype;
                    @JsonProperty("urank")
                    private Integer urank;
                    @JsonProperty("mbrank")
                    private Integer mbrank;
                    @JsonProperty("follow_me")
                    private Boolean followMe;
                    @JsonProperty("following")
                    private Boolean following;
                    @JsonProperty("follow_count")
                    private Integer followCount;
                    @JsonProperty("followers_count")
                    private String followersCount;
                    @JsonProperty("followers_count_str")
                    private String followersCountStr;
                    @JsonProperty("cover_image_phone")
                    private String coverImagePhone;
                    @JsonProperty("avatar_hd")
                    private String avatarHd;
                    @JsonProperty("like")
                    private Boolean like;
                    @JsonProperty("like_me")
                    private Boolean likeMe;
                    @JsonProperty("badge")
                    private BadgeDTO badge;

                    @Data
                    @NoArgsConstructor
                    public static class BadgeDTO {
                        @JsonProperty("user_name_certificate")
                        private Integer userNameCertificate;
                        @JsonProperty("pc_new")
                        private Integer pcNew;
                        @JsonProperty("zhongcaoguan_2021")
                        private Integer zhongcaoguan2021;
                        @JsonProperty("hongbaofei2022_2021")
                        private Integer hongbaofei20222021;
                        @JsonProperty("gaokao_2022")
                        private Integer gaokao2022;
                        @JsonProperty("hongrenjienew_2022")
                        private Integer hongrenjienew2022;
                    }
                }
            }
        }
    }
}
