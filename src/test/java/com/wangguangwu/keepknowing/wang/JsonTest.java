package com.wangguangwu.keepknowing.wang;

import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.wangguangwu.keepknowing.entity.weibo.WeiboSearchResponse;
import com.wangguangwu.keepknowing.util.FileReadUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author wangguangwu
 */
@Disabled
class JsonTest {

    @ParameterizedTest
    @MethodSource("dataProvider")
    void testJsonParsers(String content, Function<String, WeiboSearchResponse> parserFunction) {
        WeiboSearchResponse weiboSearchResponse = parserFunction.apply(content);
        Assertions.assertNotNull(weiboSearchResponse);
    }

    public static Stream<Arguments> dataProvider() {
        String content = FileReadUtil.readFile("weibo/WeiboSearchResponse.txt");
        return Stream.of(
                Arguments.of(content, (Function<String, WeiboSearchResponse>) data -> JSON.parseObject(data, WeiboSearchResponse.class)),
                Arguments.of(content, (Function<String, WeiboSearchResponse>) data -> new Gson().fromJson(data, WeiboSearchResponse.class)),
                Arguments.of(content, (Function<String, WeiboSearchResponse>) data -> {
                    try {
                        return new ObjectMapper().readValue(data, WeiboSearchResponse.class);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                })
        );
    }
}
