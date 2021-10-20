package com.kangyonggan.ftx.components;

import com.alibaba.fastjson.JSONObject;
import com.kangyonggan.ftx.constants.FtxConstants;
import com.kangyonggan.ftx.constants.Method;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author kyg
 */
@Component
public class FtxClient {

    private OkHttpClient client;

    @Autowired
    private FtxProperties ftxProperties;

    @Autowired
    private FtxSignature ftxSignature;

    @PostConstruct
    public void init() {
        if (StringUtils.isEmpty(ftxProperties.getApiKey()) || StringUtils.isEmpty(ftxProperties.getApiSecretKey())) {
            throw new RuntimeException("请先配置./src/main/resources/application.yml中的apiKey和apiSecretKey");
        }
        client = new OkHttpClient().newBuilder().build();
    }

    /**
     * get obj
     *
     * @param url
     * @param clazz
     * @return
     */
    public <T> T get(String url, Class<T> clazz) {
        return request(Method.GET, url, null).getJSONObject("result").toJavaObject(clazz);
    }

    /**
     * get list
     *
     * @param url
     * @param clazz
     * @return
     */
    public <T> List<T> getList(String url, Class<T> clazz) {
        return request(Method.GET, url, null).getJSONArray("result").toJavaList(clazz);
    }

    /**
     * request
     *
     * @param method
     * @param url
     * @param body
     * @return
     */
    private JSONObject request(Method method, String url, String body) {
        long ts = System.currentTimeMillis();
        String sign = ftxSignature.signature(ts, method, url, body);
        Request.Builder builder = new Request.Builder().url(ftxProperties.getHost() + url)
                .header("accept", FtxConstants.SIGNATURE_METHOD_VALUE)
                .header("Content-Type", FtxConstants.SIGNATURE_METHOD_VALUE)
                .header("FTX-KEY", ftxProperties.getApiKey())
                .header("FTX-TS", String.valueOf(ts))
                .header("FTX-SIGN", sign);

        if (Method.POST == method) {
            builder = builder.post(RequestBody.create(MediaType.parse(FtxConstants.APPLICATION_JSON), StringUtils.EMPTY));
        } else if (Method.PUT == method) {
            builder = builder.put(RequestBody.create(MediaType.parse(FtxConstants.APPLICATION_JSON), StringUtils.EMPTY));
        } else if (Method.DELETE == method) {
            builder = builder.delete();
        }

        Request request = builder.build();
        try (Response response = client.newCall(request).execute()) {
            if (response.body() != null) {
                JSONObject res = JSONObject.parseObject(response.body().string());
                System.out.println(res);
                if (!res.getBoolean("success")) {
                    throw new RuntimeException("FTX接口返回失败，错误信息：" + res.getString("error"));
                }
                return res;
            } else {
                throw new RuntimeException("请求FTX接口失败");
            }
        } catch (Exception e) {
            throw new RuntimeException("请求FTX接口异常", e);
        }
    }

}
