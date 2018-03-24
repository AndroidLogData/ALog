package com.android.logcat.http;

/**
 * Created by 보운 on 2017-12-20.
 */

public interface HttpCallback {
    void onSuccess(Object result);
    void onFail();
}
