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

    public void setLogLevel(String level) {
        setParams("level", level);
    }

    public void setLogMessage(String message) {
        setParams("message", message);
    }

    public void setTime(long time) {
        setParams("time", String.valueOf(time));
    }

    public void setTotalMemory(long totalMemory) {
        setParams("totalMemory", String.valueOf(totalMemory));
    }

    public void setAvailMemory(long availMemory) {
        setParams("availMemory", String.valueOf(availMemory));
    }

    public void setMemoryPercentage(double percentage) {
        setParams("memoryPercentage", String.valueOf(percentage));
    }

    public void setThreshold(long threshold) {
        setParams("threshold", String.valueOf(threshold));
    }

    public void setLowMemory(boolean lowMemory) {
        setParams("lowMemory", String.valueOf(lowMemory));
    }

    public void setTag(String tag) {
        setParams("tag", tag);
    }

    public void setDalvikPss(int dalvikPss) {
        setParams("dalvikPss", String.valueOf(dalvikPss));
    }

    public void setOtherPss(int otherPss) {
        setParams("dalvikPss", String.valueOf(otherPss));
    }

    public void setNativePss(int nativePss) {
        setParams("dalvikPss", String.valueOf(nativePss));
    }

    public void setContentType(String value) {
        setHeaders("Content-Type", value);
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
