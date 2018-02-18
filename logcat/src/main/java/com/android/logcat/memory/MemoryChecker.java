package com.android.logcat.memory;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static android.content.Context.ACTIVITY_SERVICE;

/**
 * Created by Null on 2018-01-02.
 */

public class MemoryChecker {
    private MemoryInfo activityMemoryInfo;
    private ActivityManager activityManager;
    private int totalPss;
    private int dalvikPss;
    private int nativePss;
    private int otherPss;

    public MemoryChecker(Context context) {
        activityMemoryInfo = new MemoryInfo();
        activityManager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(activityMemoryInfo);

        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();

        Map<Integer, String> pidMap = new TreeMap<Integer, String>();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            pidMap.put(runningAppProcessInfo.pid, runningAppProcessInfo.processName);
        }

        Collection<Integer> keys = pidMap.keySet();

        for (int key : keys) {
            int pids[] = new int[1];
            pids[0] = key;
            android.os.Debug.MemoryInfo[] memoryInfoArray = activityManager.getProcessMemoryInfo(pids);
            for (android.os.Debug.MemoryInfo pidMemoryInfo : memoryInfoArray) {
//                Log.i("MemoryChecker", String.format("** MEMINFO in pid %d [%s] **\n", pids[0], pidMap.get(pids[0])));
                if (context.getPackageName().equals(pidMap.get(pids[0]))) {
                    totalPss = pidMemoryInfo.getTotalPss();
                    dalvikPss = pidMemoryInfo.dalvikPss;
                    nativePss = pidMemoryInfo.nativePss;
                    otherPss = pidMemoryInfo.otherPss;
                }
            }
        }
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
        return dalvikPss;
    }

    public int getNativePss() {
        return nativePss;
    }

    public int getOtherPss() {
        return otherPss;
    }

    public int getTotalPss() {
        return totalPss;
    }
}
