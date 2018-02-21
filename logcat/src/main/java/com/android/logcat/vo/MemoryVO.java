package com.android.logcat.vo;

/**
 * Created by Null on 2018-01-30.
 */

public class MemoryVO {
    private long totalMemory;
    private long availMemory;
    private double memoryPercentage;
    private long threshold;
    private boolean lowMemory;
    private int dalvikPss;
    private int nativePss;
    private int otherPss;
    private int totalPss;

    public MemoryVO(long totalMemory, long availMemory, double memoryPercentage, long threshold, boolean lowMemory, int dalvikPss, int nativePss, int otherPss, int totalPss) {
        this.totalMemory = totalMemory;
        this.availMemory = availMemory;
        this.memoryPercentage = memoryPercentage;
        this.threshold = threshold;
        this.lowMemory = lowMemory;
        this.dalvikPss = dalvikPss;
        this.nativePss = nativePss;
        this.otherPss = otherPss;
        this.totalPss = totalPss;
    }

    public MemoryVO(MemoryVO memoryVO) {
        this(
                memoryVO.totalMemory,
                memoryVO.availMemory,
                memoryVO.memoryPercentage,
                memoryVO.threshold,
                memoryVO.lowMemory,
                memoryVO.dalvikPss,
                memoryVO.nativePss,
                memoryVO.otherPss,
                memoryVO.totalPss);
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

    public int getDalvikPss() {
        return dalvikPss;
    }

    public void setDalvikPss(int dalvikPss) {
        this.dalvikPss = dalvikPss;
    }

    public int getNativePss() {
        return nativePss;
    }

    public void setNativePss(int nativePss) {
        this.nativePss = nativePss;
    }

    public int getOtherPss() {
        return otherPss;
    }

    public void setOtherPss(int otherPss) {
        this.otherPss = otherPss;
    }

    public int getTotalPss() {
        return totalPss;
    }

    public void setTotalPss(int totalPss) {
        this.totalPss = totalPss;
    }

//    @Override
//    public String toString() {
//        return "Total Memory : " + getTotalMemory() + "\n" +
//                "Avail Memory : " + getAvailMemory() + "\n" +
//                "Memory Percentage : " + getMemoryPercentage() + "\n" +
//                "Threshold : " + getThreshold() + "\n" +
//                "Low Memory : " + isLowMemory() + "\n" +
//                "Dalvik Pss : " + getDalvikPss() + "\n" +
//                "Native Pss : " + getNativePss() + "\n" +
//                "Other Pss : " + getOtherPss() + "\n" +
//                "Total Pss : " + getTotalPss() + "\n";
//    }
}
