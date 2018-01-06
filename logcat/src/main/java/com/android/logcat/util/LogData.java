package com.android.logcat.util;

/**
 * Created by Null on 2018-01-01.
 */

public class LogData {
    private String msg;
    private String tag;
    private String level;
    private long time;
    private long totalMemory;
    private long availMemory;
    private double memoryPercentage;
    private long threshold;
    private boolean lowMemory;
    private int dalvikPss;
    private int nativePss;
    private int otherPss;
    private int totalPss;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
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

    @Override
    public String toString() {
        return "LogLevel : " + getLevel() + "\n" +
                "Time : " + getTime() + "\n" +
                "Tag : " + getTag() + "\n" +
                "Message : " + getMsg() + "\n";
    }
}
