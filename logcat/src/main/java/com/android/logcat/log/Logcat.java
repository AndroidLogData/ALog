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

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class Logcat {
    private Context context;
    private boolean showLog;
    private boolean logTransfer;
    private boolean debug;
    private LogData data;
    private MemoryChecker memoryChecker;

    public static class Builder {
        // 필수 인자
        private Context context;
        private boolean showLog;
        private boolean logTransfer;
        // 선택적 인자
        private boolean debug;
        // 그 외
        private LogData data;
        private MemoryChecker memoryChecker;

        public Builder(Context context, boolean showLog, boolean logTransfer) {
            this.showLog = showLog;
            this.context = context;
            this.logTransfer = logTransfer;
            this.data = new LogData();
            this.memoryChecker = new MemoryChecker(context);
            HttpServiceProvider.registerDefaultProvider(new ProviderImplement());
            VolleyManager.getInstance().setRequestQueue(context);
        }

        public Builder setDebug(boolean value) {
            debug = value;
            return this;
        }

        public Logcat build() {
            return new Logcat(this);
        }
    }

    private Logcat(Builder builder) {
        debug = builder.debug;
        logTransfer = builder.logTransfer;
        data = builder.data;
        showLog = builder.showLog;
        context = builder.context;
        memoryChecker = builder.memoryChecker;
    }

    /**
     * verbose
     * 동작여부를 자세히 살피는 로그
     *
     * @param msg
     */
    public void v(String msg) {
        if (showLog) {
            Log.v(buildLogTag(), msg);
        }

        if (logTransfer) {
            data.setLevel("v");
            data.setTag(buildLogTag());
            data.setMsg(msg);
            data.setTime(getTime());
            logDataTransfer(data);
        }
    }

    /**
     * debug
     * 디버깅 목적으로 문제가 있을만한 곳에 남기는 로그
     *
     * @param msg
     */
    public void d(String msg) {
        if (showLog) {
            Log.d(buildLogTag(), msg);
        }

        if (logTransfer) {
            data.setLevel("d");
            data.setTag(buildLogTag());
            data.setMsg(msg);
            data.setTime(getTime());
            logDataTransfer(data);
        }
    }

    /**
     * information
     * 처리과정등을 모니터링하기 위한 로그
     *
     * @param msg
     */
    public void i(String msg) {
        if (showLog) {
            Log.i(buildLogTag(), msg);
        }

        if (logTransfer) {
            data.setLevel("i");
            data.setTag(buildLogTag());
            data.setMsg(msg);
            data.setTime(getTime());
            logDataTransfer(data);
        }
    }

    /**
     * warning
     * 지금은 문제가 되지않지만 나중에 문제가 될만한 정보를 남기는 로그
     *
     * @param msg
     */
    public void w(String msg) {
        if (showLog) {
            Log.w(buildLogTag(), msg);
        }

        if (logTransfer) {
            data.setLevel("w");
            data.setTag(buildLogTag());
            data.setMsg(msg);
            data.setTime(getTime());
            logDataTransfer(data);
        }
    }

    /**
     * error
     * 심각한 에러를 나타내는 로그
     *
     * @param msg
     */
    public void e(String msg) {
        if (showLog) {
            Log.e(buildLogTag(), msg);
        }

        if (logTransfer) {
            data.setLevel("e");
            data.setTag(buildLogTag());
            data.setMsg(msg);
            data.setTime(getTime());
            logDataTransfer(data);
        }
    }

    private String getTime() {
        DateTime date = DateTime.now();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

        return date.toString(fmt);
    }

    private double getMemory() {
        return memoryChecker.getMemoryPercentage();
    }

    private void debugMode(LogData data) {
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

    private StringBuilder buildLog() {
        StackTraceElement ste = Thread.currentThread().getStackTrace()[2];

        StringBuilder sb = new StringBuilder();

        sb.append("[");
        sb.append(ste.getFileName().replace(".java", ""));
        sb.append("::");
        sb.append(ste.getMethodName());
        sb.append("]");

        return sb;
    }

    private String buildLogTag() {
        return buildLog().toString();
    }

    private void logDataTransfer(LogData data) {
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
