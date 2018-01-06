package com.android.logcat.crashlogger;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Environment;
import android.util.DisplayMetrics;

import org.acra.annotation.AcraCore;
import org.acra.data.CrashReportData;
import org.acra.data.StringFormat;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;

/**
 * Created by Null on 2018-01-03.
 */

@AcraCore(reportFormat = StringFormat.JSON,
        reportSenderFactoryClasses = CrashReportFactory.class)
public class CrashReport implements ReportSender {
    @Override
    public void send(Context context, CrashReportData report) throws ReportSenderException {
        // Iterate over the CrashReportData instance and do whatever
        // you need with each pair of ReportField key / String value
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        PackageInfo pInfo = null;
        try {
            pInfo = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        report.put("OS", System.getProperty("os.name"));
        report.put("Architecture", System.getProperty("os.arch"));
        report.put("OSVersion", System.getProperty("os.version"));
        report.put("AndroidAPI", Build.VERSION.SDK_INT);
        report.put("Device", Build.DEVICE);
        report.put("Model", Build.MODEL);
        report.put("Manufacturer", Build.MANUFACTURER);
        report.put("PackageName", context.getPackageName());
        report.put("VersionName", pInfo.versionName);
        report.put("VersionCode", pInfo.versionCode);
        report.put("TAG", Build.TAGS);
        report.put("ScreenWidth", System.getProperty("os.version"));
        report.put("ScreenHeight", System.getProperty("os.version"));
        report.put("SDCard", Environment.getExternalStorageState());
        report.put("KeyboardAvailable", context.getResources().getConfiguration().keyboard != Configuration.KEYBOARD_NOKEYS);
        report.put("TrackballAvailable", context.getResources().getConfiguration().navigation == Configuration.NAVIGATION_TRACKBALL);
        report.put("ScreenWidth", dm.widthPixels);
        report.put("ScreenHeight", dm.heightPixels);
    }
}
