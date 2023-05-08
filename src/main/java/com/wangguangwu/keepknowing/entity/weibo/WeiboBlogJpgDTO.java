package com.wangguangwu.keepknowing.entity.weibo;

import com.wangguangwu.keepknowing.entity.BlogJpg;
import com.wangguangwu.keepknowing.entity.BlogLive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangguangwu
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeiboBlogJpgDTO {

    private BlogJpg blogJpg;

    private BlogLive blogLive;

}
