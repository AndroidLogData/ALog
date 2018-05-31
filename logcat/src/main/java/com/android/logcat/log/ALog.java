package com.android.logcat.log;

/**
 * Created by Null on 2018-01-01.
 */

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import com.android.logcat.http.HttpCallback;
import com.android.logcat.http.HttpServiceProvider;
import com.android.logcat.http.VolleyManager;
import com.android.logcat.memory.MemoryChecker;
import com.android.logcat.util.LogType;
import com.android.logcat.util.Utility;
import com.android.logcat.vo.LogVO;
import com.android.logcat.vo.MemoryVO;


public final class ALog {
    private static String packageName;
    private static boolean showLog;
    private static boolean logTransfer;
    private static boolean debug;
    private static LogVO data;
    private static MemoryChecker memoryChecker;
    private static String apiKey;

    private ALog() throws IllegalAccessException {
        throw new IllegalAccessException("Access Denied");
    }

    public static void logSetting(Context context, boolean showLog, boolean logTransfer) {
        if (Utility.checkedNull(context)) {
            throw new IllegalArgumentException("Need Context");
        }

        VolleyManager.getInstance().setRequestQueue(context);
        memoryChecker = new MemoryChecker(context);
        setApiKey(context);

        ALog.showLog = showLog;
        ALog.logTransfer = logTransfer;
        ALog.data = new LogVO();
        ALog.packageName = context.getPackageName();
    }

    public static void setDebug(boolean debug) {
        ALog.debug = debug;
    }

    private static void setApiKey(Context context) {
        apiKey = null;

        try {
            String e = context.getPackageName();
            ApplicationInfo ai = context
                    .getPackageManager()
                    .getApplicationInfo(e, PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            if (bundle != null) {
                apiKey = bundle.getString("com.logcat.apiKey");
            }
        } catch (Exception var6) {
            Log.d("setApiKey", "Caught non-fatal exception while retrieving apiKey: " + var6);
        }
    }

    /**
     * verbose
     * 동작여부를 자세히 살피는 로그
     *
     * @param msg
     */
    public static void v(Object msg) {
        if (showLog) {
            Log.v(buildLogTag(), msg.toString());
        }

        if (logTransfer) {
            data.setPackageName(packageName);
            data.setLevel(LogType.VERB.getValue());
            data.setTag(buildLogTag());
            data.setMsg(msg);
            data.setTime(System.currentTimeMillis());
            logDataTransfer(data);
        }
    }

    public static void v(Object msg, Throwable tr) {
        if (showLog) {
            Log.v(buildLogTag(), msg.toString(), tr);
        }

        if (logTransfer) {
            data.setPackageName(packageName);
            data.setLevel(LogType.VERB.getValue());
            data.setTag(buildLogTag());
            data.setMsg(msg);
            data.setTime(System.currentTimeMillis());
            logDataTransfer(data);
        }
    }

    /**
     * debug
     * 디버깅 목적으로 문제가 있을만한 곳에 남기는 로그
     *
     * @param msg
     */
    public static void d(Object msg) {
        if (showLog) {
            Log.d(buildLogTag(), msg.toString());
        }

        if (logTransfer) {
            data.setPackageName(packageName);
            data.setLevel(LogType.DEBUG.getValue());
            data.setTag(buildLogTag());
            data.setMsg(msg);
            data.setTime(System.currentTimeMillis());
            logDataTransfer(data);
        }
    }

    public static void d(Object msg, Throwable tr) {
        if (showLog) {
            Log.d(buildLogTag(), msg.toString(), tr);
        }

        if (logTransfer) {
            data.setPackageName(packageName);
            data.setLevel(LogType.DEBUG.getValue());
            data.setTag(buildLogTag());
            data.setMsg(msg);
            data.setTime(System.currentTimeMillis());
            logDataTransfer(data);
        }
    }

    /**
     * information
     * 처리과정등을 모니터링하기 위한 로그
     *
     * @param msg
     */
    public static void i(Object msg) {
        if (showLog) {
            Log.i(buildLogTag(), msg.toString());
        }

        if (logTransfer) {
            data.setPackageName(packageName);
            data.setLevel(LogType.INFO.getValue());
            data.setTag(buildLogTag());
            data.setMsg(msg);
            data.setTime(System.currentTimeMillis());
            logDataTransfer(data);
        }
    }

    public static void i(Object msg, Throwable tr) {
        if (showLog) {
            Log.i(buildLogTag(), msg.toString(), tr);
        }

        if (logTransfer) {
            data.setPackageName(packageName);
            data.setLevel(LogType.INFO.getValue());
            data.setTag(buildLogTag());
            data.setMsg(msg);
            data.setTime(System.currentTimeMillis());
            logDataTransfer(data);
        }
    }

    /**
     * warning
     * 지금은 문제가 되지않지만 나중에 문제가 될만한 정보를 남기는 로그
     *
     * @param msg
     */
    public static void w(Object msg) {
        if (showLog) {
            Log.w(buildLogTag(), msg.toString());
        }

        if (logTransfer) {
            data.setPackageName(packageName);
            data.setLevel(LogType.WARNING.getValue());
            data.setTag(buildLogTag());
            data.setMsg(msg);
            data.setTime(System.currentTimeMillis());
            logDataTransfer(data);
        }
    }

    public static void w(Object msg, Throwable tr) {
        if (showLog) {
            Log.w(buildLogTag(), msg.toString(), tr);
        }

        if (logTransfer) {
            data.setPackageName(packageName);
            data.setLevel(LogType.WARNING.getValue());
            data.setTag(buildLogTag());
            data.setMsg(msg);
            data.setTime(System.currentTimeMillis());
            logDataTransfer(data);
        }
    }

    /**
     * error
     * 심각한 에러를 나타내는 로그
     *
     * @param msg
     */
    public static void e(Object msg) {
        if (showLog) {
            Log.e(buildLogTag(), msg.toString());
        }

        if (logTransfer) {
            data.setPackageName(packageName);
            data.setLevel(LogType.ERROR.getValue());
            data.setTag(buildLogTag());
            data.setMsg(msg);
            data.setTime(System.currentTimeMillis());
            logDataTransfer(data);
        }
    }

    public static void e(Object msg, Throwable tr) {
        if (showLog) {
            Log.e(buildLogTag(), msg.toString(), tr);
        }

        if (logTransfer) {
            data.setPackageName(packageName);
            data.setLevel(LogType.ERROR.getValue());
            data.setTag(buildLogTag());
            data.setMsg(msg);
            data.setTime(System.currentTimeMillis());
            logDataTransfer(data);
        }
    }

    private static MemoryVO debugMode() {
        return new MemoryVO(
                memoryChecker.getMemoryInfo()
        );
    }

    private static StringBuilder buildLog() {
        StackTraceElement ste = Thread.currentThread().getStackTrace()[5];
        String[] packageName = ste.getClassName().split("[.]");

        StringBuilder sb = new StringBuilder();

        sb.append("[");
        sb.append(packageName[packageName.length - 1]);
        sb.append("::");
        sb.append(ste.getMethodName());
        sb.append("(").append(ste.getLineNumber()).append(")");
        sb.append("]");

        return sb;
    }

    private static String buildLogTag() {
        return buildLog().toString();
    }

    private static void logDataTransfer(LogVO data) {
        if (debug) {
            data.setMemory(debugMode());
        }

        HttpServiceProvider.getInstance().requestLogData(
                apiKey,
                data,
                new HttpCallback() {
                    @Override
                    public void onSuccess(Object result) {
                        Log.i("onSuccess", result.toString());
                    }

                    @Override
                    public void onFail() {
                        Log.i("onFail", "onFail");
                    }
                });
    }
}
