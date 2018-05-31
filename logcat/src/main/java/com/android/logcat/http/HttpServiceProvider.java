package com.android.logcat.http;

public class HttpServiceProvider {
    private HttpServiceProvider() {} // 인스턴스 생성 X

    private static HttpService provider;

    public static HttpService getInstance() {
        if (provider == null) {
            provider = new HttpService();
        }

        return provider;
    }
}