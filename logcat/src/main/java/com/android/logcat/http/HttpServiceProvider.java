package com.android.logcat.http;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HttpServiceProvider {
    private HttpServiceProvider() {} // 인스턴스 생성 X

    private static final Map<String, CreateHttpService> providers =
            new ConcurrentHashMap<String, CreateHttpService>();
    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    // 제공자 등록 API
    public static void registerDefaultProvider(CreateHttpService p) {
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvider(String name, CreateHttpService p) {
        providers.put(name, p);
    }

    // 서비스 접근 API
    public static HttpServiceList newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static HttpServiceList newInstance(String name) {
        CreateHttpService p = providers.get(name);
        if (p == null) {
            throw new IllegalArgumentException(
                    "No provider registered with name: " + name);
        }
        return p.newService();
    }
}