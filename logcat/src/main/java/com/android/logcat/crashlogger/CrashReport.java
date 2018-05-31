package com.android.logcat.crashlogger;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import com.android.logcat.http.HttpServiceProvider;
import com.android.logcat.http.HttpCallback;

import org.acra.data.CrashReportData;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;

/**
 * Created by Null on 2018-01-03.
 */

public class CrashReport implements ReportSender {
    @Override
    public void send(Context context, CrashReportData report) throws ReportSenderException {
        String apiKey = setApiKey(context);
        HttpServiceProvider.getInstance().requestCrashData(
                apiKey,
                report,
                new HttpCallback() {
                    @Override
                    public void onSuccess(Object result) {
                        Log.i("onSuccess", result.toString());
                    }

                    @Override
                    public void onFail() {
                        Log.i("onFail", "onFail");
                    }
                }
        );
    }

    private static String setApiKey(Context context) {
        String apiKey = null;

        try {
            String e = context.getPackageName();
            ApplicationInfo ai = context
                    .getPackageManager()
                    .getApplicationInfo(e, PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            if (bundle != null) {
                apiKey = bundle.getString("com.logcat.apiKey");
                return apiKey;
            }
        } catch (Exception var6) {
            Log.d("setApiKey", "Caught non-fatal exception while retrieving apiKey: " + var6);
        }
        return null;
    }
}
