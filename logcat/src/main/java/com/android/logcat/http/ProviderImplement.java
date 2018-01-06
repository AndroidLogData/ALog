package com.android.logcat.http;

public class ProviderImplement implements ProviderInterface {
    @Override
    public ServiceInterface newService() {
        return new HttpService();
    }
}
