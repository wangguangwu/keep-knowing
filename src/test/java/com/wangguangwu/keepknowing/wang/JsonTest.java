package com.wangguangwu.keepknowing.wang;

import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.wangguangwu.keepknowing.entity.weibo.WeiboSearchResponseDTO;
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
    void testJsonParsers(String content, Function<String, WeiboSearchResponseDTO> parserFunction) {
        WeiboSearchResponseDTO weiboSearchResponseDTO = parserFunction.apply(content);
        Assertions.assertNotNull(weiboSearchResponseDTO);
    }

    public static Stream<Arguments> dataProvider() {
        String content = FileReadUtil.readFile("weibo/WeiboSearchResponse.txt");
        return Stream.of(
                Arguments.of(content, (Function<String, WeiboSearchResponseDTO>) data -> JSON.parseObject(data, WeiboSearchResponseDTO.class)),
                Arguments.of(content, (Function<String, WeiboSearchResponseDTO>) data -> new Gson().fromJson(data, WeiboSearchResponseDTO.class)),
                Arguments.of(content, (Function<String, WeiboSearchResponseDTO>) data -> {
                    try {
                        return new ObjectMapper().readValue(data, WeiboSearchResponseDTO.class);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                })
        );
    }
}
