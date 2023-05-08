package com.wangguangwu.keepknowing.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

/**
 * @author wangguangwu
 */
public class DateUtil {

    private DateUtil() {
    }

    public static LocalDateTime cst2Date(String cstTime) {
        if (StringUtils.isBlank(cstTime)) {
            return null;
        }
        SimpleDateFormat sim1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date date;
        try {
            date = sim1.parse(cstTime);
            Instant instant = date.toInstant();
            ZoneId zoneId = ZoneId.systemDefault();
            return instant.atZone(zoneId).toLocalDateTime();
        } catch (ParseException e) {
            throw new IllegalArgumentException("无法解析");
        }
    }
}
