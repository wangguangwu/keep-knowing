package com.wangguangwu.keepknowing.entity.weibo;

import com.wangguangwu.keepknowing.entity.Blog;
import com.wangguangwu.keepknowing.entity.BlogVideo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wangguangwu
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeiboBlogInfoDTO {

    private Blog blog;

    private List<WeiboBlogJpgDTO> weiboBlogJpgList;

    private List<String> blogVideoList;

}
