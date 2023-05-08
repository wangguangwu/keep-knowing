package com.wangguangwu.keepknowing.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wangguangwu.keepknowing.constant.UserAgent;
import com.wangguangwu.keepknowing.constant.WeiboCookie;
import com.wangguangwu.keepknowing.util.HttpClientUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangguangwu
 */
@Component
public class CookieFetcher {

    static final String PASSPORT_URL = "https://passport.weibo.com/visitor/visitor?entry=miniblog&a=enter&url=http://weibo.com/?category=2" + "&domain=.weibo.com&ua=php-sso_sdk_client-0.6.23";

    static final String GEN_VISITOR_URL = "https://passport.weibo.com/visitor/genvisitor";

    static final String VISITOR_URL = "https://passport.weibo.com/visitor/visitor?a=restore&cb=restore_back&from=weibo&_rand=0.";

    /**
     * 获取 cookie
     *
     * @return cookie
     */
    public String getCookie() {
        Map<String, String> map;
        int retryTimes = 3;
        for (int i = 0; i < retryTimes; i++) {
            map = getCookieParam();
            if (map.containsKey(WeiboCookie.SUB) && map.containsKey(WeiboCookie.SUB_P) && StringUtils.isNotBlank(map.get(WeiboCookie.SUB)) && StringUtils.isNotBlank(map.get(WeiboCookie.SUB_P))) {
                return " YF-Page-G0=" + WeiboCookie.S_TENTRY + map.get(WeiboCookie.SUB) + WeiboCookie.SUB_P_E + map.get(WeiboCookie.SUB_P);
            }
        }
        return " YF-Page-G0=" + WeiboCookie.S_TENTRY + WeiboCookie.SUB_P_E;
    }

    /**
     * 获取 cookie 参数
     *
     * @return map
     */
    private Map<String, String> getCookieParam() {
        String time = System.currentTimeMillis() + "";
        time = time.substring(0, 9) + "." + time.substring(9, 13);
        String passportUrl = PASSPORT_URL + "&_rand=" + time;

        String tid = "";
        String w = "";
        String c = "";
        {
            JSONObject jsonObject = postGenVisitor(passportUrl);
            if (jsonObject.containsKey(WeiboCookie.RET_CODE) && jsonObject.getLong(WeiboCookie.RET_CODE) == 20000000) {
                JSONObject data = jsonObject.getJSONObject("data");
                tid = data.getString("tid");
                try {
                    URLEncoder.encode(tid, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    // ignore
                }
                c = data.containsKey("confidence") ? String.valueOf(data.getIntValue("confidence")) : "100";
                w = Boolean.TRUE.equals(data.containsKey("new_tid")) ? "3" : "2";
            }
        }
        String s = "";
        String sp = "";
        {
            if (StringUtils.isNotBlank(tid) && StringUtils.isNotBlank(w) && StringUtils.isNotBlank(c)) {
                JSONObject jsonObject = getVisitor(tid, w, c, passportUrl);
                if (jsonObject.containsKey(WeiboCookie.RET_CODE) && jsonObject.getLong(WeiboCookie.RET_CODE) == 20000000) {
                    JSONObject data = jsonObject.getJSONObject("data");
                    s = data.getString(WeiboCookie.SUB);
                    sp = data.getString(WeiboCookie.SUB_P);
                }
            }
        }
        Map<String, String> map = new HashMap<>(2);
        map.put(WeiboCookie.SUB, s);
        map.put(WeiboCookie.SUB_P, sp);
        return map;
    }

    /**
     * 生成访客信息
     *
     * @param passportUrl passportUrl
     * @return content
     */
    private JSONObject postGenVisitor(String passportUrl) {
        Map<String, String> headers = new HashMap<>(3);
        headers.put(HttpHeaders.ACCEPT, "*/*");
        headers.put(HttpHeaders.ORIGIN, "https://passport.weibo.com");
        headers.put(HttpHeaders.REFERER, passportUrl);
        headers.put(HttpHeaders.USER_AGENT, UserAgent.getRandomUserAgent());

        Map<String, String> params = new HashMap<>(2);
        params.put("cb", "gen_callback");
        params.put("fp", fp());

        String response = HttpClientUtil.post(GEN_VISITOR_URL, headers, params);

        if (StringUtils.isBlank(response)) {
            return new JSONObject();
        }
        String data = response.substring(response.indexOf("(") + 1, response.lastIndexOf(""));
        return JSON.parseObject(data);
    }

    private JSONObject getVisitor(String tid, String w, String c, String passportUrl) {
        String url = VISITOR_URL + rand();
        Map<String, String> headers = new HashMap<>(4);
        headers.put(HttpHeaders.ACCEPT, "*/*");
        headers.put(HttpHeaders.HOST, "passport.weibo.com");
        headers.put(HttpHeaders.COOKIE, "tid=" + tid + "__0" + c + "; " + "SRT=D.QqHBTrsPOGHzO-RtOeYoWr9NUdS6SG9G4FsTdPzn5QVqMdbbN-bZTrEdNbHi5mYNUCsuTZ%21pVdrnAQMNAZSAiZScN4SeSsBPTs9k4rYO5DBSSd9gJePSMqYRUQMmQn77%2AB.vAflW-P9Rc0lR-ykKDvnJqiQVbiRVPBtS%21r3J8sQVqbgVdWiMZ4siOzu4DbmKPWFArbPSEymR-PjdE4-AeiONOiN4bBf; ");
        headers.put(HttpHeaders.REFERER, passportUrl);

        String response = HttpClientUtil.getWithHeaders(url, headers);

        if (StringUtils.isBlank(response)) {
            return new JSONObject();
        }
        String data = response.substring(response.indexOf("(") + 1, response.lastIndexOf(""));
        return JSON.parseObject(data);
    }

    private  String rand() {
        return BigDecimal.valueOf(Math.floor(Math.random() * 10000000000000000L)).toString();
    }

    /**
     * 模拟页面参数
     *
     * @return fp
     */
    private  String fp() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("os", "1");
        jsonObject.put("browser", "Chrome59,0,3071,115");
        jsonObject.put("fonts", "undefined");
        jsonObject.put("screenInfo", "1920×1920*27");
        jsonObject.put("plugins", "Enables Widevine licenses for playback of HTML audio/video content. (version: 1.4.8.984)::widevinecdmadapter.dll::Widevine Content Decryption Module|Shockwave Flash 26.0 r0::pepflashplayer.dll::Shockwave Flash|::mhjfbmdgcfjbbpaeojofohoefgiehjai::Chrome PDF Viewer|::internal-nacl-plugin::Native Client|Portable Document Format::internal-pdf-viewer::Chrome PDF Viewer");
        return jsonObject.toString();
    }
}
