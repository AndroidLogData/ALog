package com.bowoon.android.alog.http;

import com.bowoon.android.alog.vo.LogVO;

import org.acra.data.CrashReportData;

public interface HttpServiceList {
    void requestLogData(String apiKey, LogVO data, final HttpCallback callback);
    void requestCrashData(String apiKey, CrashReportData report, final HttpCallback callback);
}
