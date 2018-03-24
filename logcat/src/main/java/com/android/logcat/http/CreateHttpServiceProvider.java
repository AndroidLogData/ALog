package com.android.logcat.http;

public class CreateHttpServiceProvider implements CreateHttpService {
    @Override
    public HttpServiceList newService() {
        return new HttpService();
    }
}
