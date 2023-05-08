package com.wangguangwu.keepknowing.util;

import com.wangguangwu.keepknowing.constant.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangguangwu
 */
public final class RegexUtil {

    private RegexUtil() {
    }

    public static List<String> videoMatch(String content) {
        // 1. 正则规则
        Pattern pattern = Pattern.compile(Regex.WEIBO_VIDEO_PATTERN);

        // 2. 通过正则对象获取匹配器对象
        Matcher mat = pattern.matcher(content);

        // 3. 创建结果集合
        List<String> result = new ArrayList<>();

        // 4. 查找并处理匹配的子序列
        while (mat.find()) {
            String group = mat.group();
            int index = group.indexOf("\"");
            if (index > 0) {
                group = group.substring(0, index);
            }
            result.add(group);
        }
        return result;
    }

    public static String urlRedirect(String text) {
        Pattern pattern = Pattern.compile(Regex.WEIBO_REDIRECT_URL);
        Matcher matcher = pattern.matcher(text);

        return matcher.find() ? matcher.group(1) : "";
    }
}
