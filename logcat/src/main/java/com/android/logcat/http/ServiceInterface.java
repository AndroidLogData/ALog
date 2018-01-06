package com.android.logcat.http;


import com.android.logcat.util.LogData;

public interface ServiceInterface {
    void requestLogData(LogData data, final VolleyCallback callback);
}
