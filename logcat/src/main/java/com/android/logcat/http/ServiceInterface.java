package com.android.logcat.http;


import com.android.logcat.vo.LogVO;

import org.acra.data.CrashReportData;

public interface ServiceInterface {
    void requestLogData(String apiKey, LogVO data, final VolleyCallback callback);
    void requestCrashData(String apiKey, CrashReportData report, final VolleyCallback callback);
}
