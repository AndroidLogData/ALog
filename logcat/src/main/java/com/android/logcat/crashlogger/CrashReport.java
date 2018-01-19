package com.android.logcat.crashlogger;

import android.content.Context;
import android.util.Log;

import com.android.logcat.http.HttpServiceProvider;
import com.android.logcat.http.VolleyCallback;

import org.acra.data.CrashReportData;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;

/**
 * Created by Null on 2018-01-03.
 */

public class CrashReport implements ReportSender {
    @Override
    public void send(Context context, CrashReportData report) throws ReportSenderException {
        // Iterate over the CrashReportData instance and do whatever
        // you need with each pair of ReportField key / String value

//        DisplayMetrics dm = context.getResources().getDisplayMetrics();
//        PackageInfo pInfo = null;
//        try {
//            pInfo = context.getPackageManager().getPackageInfo(
//                    context.getPackageName(), PackageManager.GET_META_DATA);
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        report.put("ScreenWidth", dm.widthPixels);
//        report.put("ScreenHeight", dm.heightPixels);

        HttpServiceProvider.newInstance().requestCrashData(
                report,
                new VolleyCallback() {
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
}
