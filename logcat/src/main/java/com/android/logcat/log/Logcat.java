package com.android.logcat.log;

/**
 * Created by Null on 2018-01-01.
 */

import android.content.Context;
import android.util.Log;

import com.android.logcat.http.HttpServiceProvider;
import com.android.logcat.http.ProviderImplement;
import com.android.logcat.http.VolleyCallback;
import com.android.logcat.http.VolleyManager;
import com.android.logcat.memory.MemoryChecker;
import com.android.logcat.util.LogData;
import com.android.logcat.util.Utility;


public final class Logcat {
    private static boolean showLog;
    private static boolean logTransfer;
    private static boolean debug;
    private static LogData data;
    private static MemoryChecker memoryChecker;

    private Logcat() {

    }

    public static void logSetting(Context context, boolean showLog, boolean logTransfer) {
        HttpServiceProvider.registerDefaultProvider(new ProviderImplement());
        VolleyManager.getInstance().setRequestQueue(context);
        memoryChecker = new MemoryChecker(context);

        Logcat.showLog = showLog;
        Logcat.logTransfer = logTransfer;
        Logcat.data = new LogData();
    }

    public static void setDebug(boolean debug) {
        Logcat.debug = debug;
    }

    /**
     * verbose
     * 동작여부를 자세히 살피는 로그
     *
     * @param msg
     */
    public static void v(String msg) {
        if (showLog) {
            Log.v(buildLogTag(), msg);
        }

        if (logTransfer) {
            data.setLevel("v");
            data.setTag(buildLogTag());
            data.setMsg(msg);
            data.setTime(Utility.getTime());
            logDataTransfer(data);
        }
    }

    /**
     * debug
     * 디버깅 목적으로 문제가 있을만한 곳에 남기는 로그
     *
     * @param msg
     */
    public static void d(String msg) {
        if (showLog) {
            Log.d(buildLogTag(), msg);
        }

        if (logTransfer) {
            data.setLevel("d");
            data.setTag(buildLogTag());
            data.setMsg(msg);
            data.setTime(Utility.getTime());
            logDataTransfer(data);
        }
    }

    /**
     * information
     * 처리과정등을 모니터링하기 위한 로그
     *
     * @param msg
     */
    public static void i(String msg) {
        if (showLog) {
            Log.i(buildLogTag(), msg);
        }

        if (logTransfer) {
            data.setLevel("i");
            data.setTag(buildLogTag());
            data.setMsg(msg);
            data.setTime(Utility.getTime());
            logDataTransfer(data);
        }
    }

    /**
     * warning
     * 지금은 문제가 되지않지만 나중에 문제가 될만한 정보를 남기는 로그
     *
     * @param msg
     */
    public static void w(String msg) {
        if (showLog) {
            Log.w(buildLogTag(), msg);
        }

        if (logTransfer) {
            data.setLevel("w");
            data.setTag(buildLogTag());
            data.setMsg(msg);
            data.setTime(Utility.getTime());
            logDataTransfer(data);
        }
    }

    /**
     * error
     * 심각한 에러를 나타내는 로그
     *
     * @param msg
     */
    public static void e(String msg) {
        if (showLog) {
            Log.e(buildLogTag(), msg);
        }

        if (logTransfer) {
            data.setLevel("e");
            data.setTag(buildLogTag());
            data.setMsg(msg);
            data.setTime(Utility.getTime());
            logDataTransfer(data);
        }
    }

    private double getMemory() {
        return memoryChecker.getMemoryPercentage();
    }

    private static void debugMode(LogData data) {
        data.setTotalMemory(memoryChecker.getTotalMemory());
        data.setAvailMemory(memoryChecker.getAvailableMemory());
        data.setLowMemory(memoryChecker.getLowMemory());
        data.setMemoryPercentage(memoryChecker.getMemoryPercentage());
        data.setThreshold(memoryChecker.getThreshold());
        data.setDalvikPss(memoryChecker.getDalvikPss());
        data.setNativePss(memoryChecker.getNativePss());
        data.setOtherPss(memoryChecker.getOtherPss());
        data.setTotalPss(memoryChecker.getTotalPss());
    }

    private static StringBuilder buildLog() {
        StackTraceElement ste = Thread.currentThread().getStackTrace()[5];

        StringBuilder sb = new StringBuilder();

        sb.append("[");
        sb.append(ste.getFileName().replace(".java", ""));
        sb.append("::");
        sb.append(ste.getMethodName());
        sb.append("]");

        return sb;
    }

    private static String buildLogTag() {
        return buildLog().toString();
    }

    private static void logDataTransfer(LogData data) {
        if (debug) {
            debugMode(data);
        }

        HttpServiceProvider.newInstance().requestLogData(
                data,
                new VolleyCallback() {
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
