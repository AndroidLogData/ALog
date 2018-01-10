package com.android.logcat.http;


import com.android.logcat.util.LogData;

import org.acra.data.CrashReportData;

public interface ServiceInterface {
    void requestLogData(LogData data, final VolleyCallback callback);
    void requestCrashData(CrashReportData report, final VolleyCallback callback);
}
