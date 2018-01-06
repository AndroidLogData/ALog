package com.android.logcat.memory;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Debug;

import static android.content.Context.ACTIVITY_SERVICE;

/**
 * Created by Null on 2018-01-02.
 */

public class MemoryChecker {
    private MemoryInfo activityMemoryInfo;
    private Debug.MemoryInfo debugMemoryInfo;
    private ActivityManager activityManager;

    public MemoryChecker(Context context) {
        activityMemoryInfo = new MemoryInfo();
        activityManager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(activityMemoryInfo);

        debugMemoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(debugMemoryInfo);
    }

    // 사용가능한 메모리
    public long getAvailableMemory() {
        return activityMemoryInfo.availMem;
    }

    // 전체 메모리
    public long getTotalMemory() {
        return activityMemoryInfo.totalMem;
    }

    // 메모리 임계값
    public long getThreshold() {
        return activityMemoryInfo.threshold;
    }

    // 메모리가 부족하다면 true
    public boolean getLowMemory() {
        return activityMemoryInfo.lowMemory;
    }

    // 메모리 백분율
    public double getMemoryPercentage() {
        return 100.0 * (getTotalMemory() - getAvailableMemory()) / getTotalMemory();
    }

    public int getDalvikPss() {
        return debugMemoryInfo.dalvikPss;
    }

    public int getNativePss() {
        return debugMemoryInfo.nativePss;
    }

    public int getOtherPss() {
        return debugMemoryInfo.otherPss;
    }

    public int getTotalPss() {
        return debugMemoryInfo.getTotalPss();
    }
}
