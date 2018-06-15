package com.bowoon.android.alog.memory;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Debug;
import com.bowoon.android.alog.vo.MemoryVO;

import static android.content.Context.ACTIVITY_SERVICE;

/**
 * Created by Null on 2018-01-02.
 */

public class MemoryChecker {
    private Context context;
    private MemoryInfo activityMemoryInfo;
    private ActivityManager activityManager;

    public MemoryChecker(Context context) {
        this.context = context;
    }

    public MemoryVO getMemoryInfo() {
        Runtime runtime = Runtime.getRuntime();
        // 현재 할당된 힙 메모리 중 사용가능한 크기
//        Log.i("freeMemory", String.valueOf(runtime.freeMemory()));
        // 최대로 할당될 수 있는 메모리 크기
//        Log.i("maxMemory", String.valueOf(runtime.maxMemory()));
        // 현재 힙에 할당된 총 메모리 크기
//        Log.i("totalMemory", String.valueOf(runtime.totalMemory()));

        activityMemoryInfo = new MemoryInfo();
        activityManager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(activityMemoryInfo);

//        Log.i("memoryInfoTotalMemory", String.valueOf(activityMemoryInfo.totalMem));
//        Log.i("memoryInfoAvailMemory", String.valueOf(activityMemoryInfo.availMem));

        Double allocated = (double) ((Debug.getNativeHeapAllocatedSize()) / 1024);
        Double available = (double) ((Debug.getNativeHeapSize()) / 1024);
        Double free = (double) ((Debug.getNativeHeapFreeSize()) / 1024);
//        Log.e("free ", String.valueOf(free));
//        Log.e("allocated ", String.valueOf(allocated));
//        Log.e("available ", String.valueOf(available));

        return new MemoryVO(
                runtime.freeMemory(),
                runtime.maxMemory(),
                runtime.totalMemory(),
                activityMemoryInfo.totalMem,
                activityMemoryInfo.availMem,
                100.0 * (((double) activityMemoryInfo.totalMem - (double) activityMemoryInfo.availMem) / (double) activityMemoryInfo.totalMem),
                activityMemoryInfo.threshold,
                activityMemoryInfo.lowMemory,
                free,
                allocated,
                available
        );
    }
}
