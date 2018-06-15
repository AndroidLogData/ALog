package com.bowoon.android.alog.vo;

/**
 * Created by Null on 2018-01-30.
 */

public class MemoryVO {
    /**
     * Native Heap Memory
     */
    private long nativeFreeMemory;
    private long nativeMaxMemory;
    private long nativeTotalMemory;
    /**
     * Memory Information
     */
    private long totalMemory;
    private long availMemory;
    private double memoryPercentage;
    private long threshold;
    private boolean lowMemory;
    /**
     * Debug Native Heap
     */
    private double debugNativeFree;
    private double debugNativeAllocated;
    private double debugNativeAvailable;

    public MemoryVO(long nativeFreeMemory, long nativeMaxMemory, long nativeTotalMemory, long totalMemory, long availMemory, double memoryPercentage, long threshold, boolean lowMemory, double debugNativeFree, double debugNativeAllocated, double debugNativeAvailable) {
        this.nativeFreeMemory = nativeFreeMemory;
        this.nativeMaxMemory = nativeMaxMemory;
        this.nativeTotalMemory = nativeTotalMemory;
        this.totalMemory = totalMemory;
        this.availMemory = availMemory;
        this.memoryPercentage = memoryPercentage;
        this.threshold = threshold;
        this.lowMemory = lowMemory;
        this.debugNativeFree = debugNativeFree;
        this.debugNativeAllocated = debugNativeAllocated;
        this.debugNativeAvailable = debugNativeAvailable;
    }

    public MemoryVO(MemoryVO memoryVO) {
        this(
                memoryVO.nativeFreeMemory,
                memoryVO.nativeMaxMemory,
                memoryVO.nativeTotalMemory,
                memoryVO.totalMemory,
                memoryVO.availMemory,
                memoryVO.memoryPercentage,
                memoryVO.threshold,
                memoryVO.lowMemory,
                memoryVO.debugNativeFree,
                memoryVO.debugNativeAllocated,
                memoryVO.debugNativeAvailable);
    }

    public long getNativeFreeMemory() {
        return nativeFreeMemory;
    }

    public void setNativeFreeMemory(long nativeFreeMemory) {
        this.nativeFreeMemory = nativeFreeMemory;
    }

    public long getNativeMaxMemory() {
        return nativeMaxMemory;
    }

    public void setNativeMaxMemory(long nativeMaxMemory) {
        this.nativeMaxMemory = nativeMaxMemory;
    }

    public long getNativeTotalMemory() {
        return nativeTotalMemory;
    }

    public void setNativeTotalMemory(long nativeTotalMemory) {
        this.nativeTotalMemory = nativeTotalMemory;
    }

    public long getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(long totalMemory) {
        this.totalMemory = totalMemory;
    }

    public long getAvailMemory() {
        return availMemory;
    }

    public void setAvailMemory(long availMemory) {
        this.availMemory = availMemory;
    }

    public double getMemoryPercentage() {
        return memoryPercentage;
    }

    public void setMemoryPercentage(double memoryPercentage) {
        this.memoryPercentage = memoryPercentage;
    }

    public long getThreshold() {
        return threshold;
    }

    public void setThreshold(long threshold) {
        this.threshold = threshold;
    }

    public boolean isLowMemory() {
        return lowMemory;
    }

    public void setLowMemory(boolean lowMemory) {
        this.lowMemory = lowMemory;
    }

    public double getDebugNativeFree() {
        return debugNativeFree;
    }

    public void setDebugNativeFree(double debugNativeFree) {
        this.debugNativeFree = debugNativeFree;
    }

    public double getDebugNativeAllocated() {
        return debugNativeAllocated;
    }

    public void setDebugNativeAllocated(double debugNativeAllocated) {
        this.debugNativeAllocated = debugNativeAllocated;
    }

    public double getDebugNativeAvailable() {
        return debugNativeAvailable;
    }

    public void setDebugNativeAvailable(double debugNativeAvailable) {
        this.debugNativeAvailable = debugNativeAvailable;
    }
}
