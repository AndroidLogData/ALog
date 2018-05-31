package com.android.logcat.http;

public class HttpServiceProvider {
    private HttpServiceProvider() {} // 인스턴스 생성 X

    private static class Singleton {
        private static final HttpService provider = new HttpService();
    }

    public static HttpService getInstance() {
        return Singleton.provider;
    }
}