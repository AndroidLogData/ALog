package com.android.logcat.memory;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;

import com.android.logcat.vo.MemoryVO;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static android.content.Context.ACTIVITY_SERVICE;

/**
 * Created by Null on 2018-01-02.
 */

public class MemoryChecker {
    private Context context;
    private MemoryInfo activityMemoryInfo;
    private ActivityManager activityManager;
    private List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
    private Map<Integer, String> pidMap;

    public MemoryChecker(Context context) {
        this.context = context;
    }

    public MemoryVO getMemoryInfo() {
        activityMemoryInfo = new MemoryInfo();
        activityManager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(activityMemoryInfo);

        MemoryVO memoryVO = null;
        runningAppProcesses = activityManager.getRunningAppProcesses();
        pidMap = new TreeMap<Integer, String>();

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
                    memoryVO = new MemoryVO(
                            // 전체 메모리
                            activityMemoryInfo.totalMem,
                            // 사용가능한 메모리
                            activityMemoryInfo.availMem,
                            // 메모리 백분율
                            100.0 * ((activityMemoryInfo.totalMem - activityMemoryInfo.availMem) / activityMemoryInfo.totalMem),
                            // 메모리 임계값
                            activityMemoryInfo.threshold,
                            // 메모리가 부족하다면 true
                            activityMemoryInfo.lowMemory,
                            pidMemoryInfo.dalvikPss,
                            pidMemoryInfo.nativePss,
                            pidMemoryInfo.otherPss,
                            pidMemoryInfo.getTotalPss());
                }
            }
        }

        return memoryVO;
    }
}
