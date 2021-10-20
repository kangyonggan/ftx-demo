package com.kangyonggan.ftx.components;

import com.kangyonggan.ftx.constants.FtxConstants;
import com.kangyonggan.ftx.constants.Method;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * 签名
 *
 * @author kyg
 */
@Component
public class FtxSignature {

    @Autowired
    private FtxProperties ftxProperties;

    /**
     * 签名
     *
     * @param ts
     * @param method
     * @param url
     * @param body
     * @return
     */
    public String signature(Long ts, Method method, String url, String body) {
        String plainText = ts + method.name() + url;
        if (StringUtils.isNotEmpty(body)) {
            plainText += body;
        }

        try {
            Mac mac = Mac.getInstance(FtxConstants.SIGNATURE_METHOD_VALUE);
            mac.init(new SecretKeySpec(ftxProperties.getApiSecretKey().getBytes(), FtxConstants.SIGNATURE_METHOD_VALUE));
            byte[] plainHash = mac.doFinal(plainText.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte hash : plainHash) {
                sb.append(String.format("%02x", hash));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("FTX签名异常", e);
        }
    }

}
