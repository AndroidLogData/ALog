package com.android.logcat.http;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 보운 on 2018-01-01.
 */

public class HttpOption {
    private Map<String, String> headers;
    private Map<String, String> params;
    private String bodyContentType;

    public HttpOption() {
        headers = new HashMap<String, String>();
        params = new HashMap<String, String>();
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getBodyContentType() {
        return bodyContentType;
    }

    public void setBodyContentType(String bodyContentType) {
        this.bodyContentType = bodyContentType;
    }

    public void setContentType(String value) {
        setHeaders("Content-Type", value);
    }

    public void setAcceptEncoding(String value) {
        setHeaders("Accept-Encoding", value);
    }

    public void setSecretKey(String secretKey) {
        setHeaders("secretKey", secretKey);
    }

    private void setHeaders(String key, String value) {
        headers.put(key, value);
    }

    private void setParams(String key, String value) {
        params.put(key, value);
    }
}
