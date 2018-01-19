package com.android.logcat.crashlogger;

import android.content.Context;
import android.support.annotation.NonNull;

import org.acra.config.CoreConfiguration;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderFactory;

/**
 * Created by Null on 2018-01-03.
 */

public class CrashReportFactory implements ReportSenderFactory {
    @NonNull
    @Override
    public ReportSender create(@NonNull Context context, @NonNull CoreConfiguration config) {
        return new CrashReport();
    }

    @Override
    public boolean enabled(@NonNull CoreConfiguration config) {
        return true;
    }
}
