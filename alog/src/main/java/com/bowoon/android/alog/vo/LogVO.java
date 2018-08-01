package com.bowoon.android.alog.vo;

import android.location.Location;

/**
 * Created by Null on 2018-01-01.
 */

public class LogVO {
    private String packageName;
    private Object msg;
    private String tag;
    private String level;
    private long time;
    private MemoryVO memory;
    private String batteryStatus;
    private String batteryCharge;
    private Location location;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
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

    public MemoryVO getMemory() {
        return memory;
    }

    public void setMemory(MemoryVO memory) {
        this.memory = memory;
    }

    public String getBatteryStatus() {
        return batteryStatus;
    }

    public void setBatteryStatus(String batteryStatus) {
        this.batteryStatus = batteryStatus;
    }

    public String getBatteryCharge() {
        return batteryCharge;
    }

    public void setBatteryCharge(String batteryCharge) {
        this.batteryCharge = batteryCharge;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "LogLevel : " + getLevel() + "\n" +
                "Time : " + getTime() + "\n" +
                "Tag : " + getTag() + "\n" +
                "Message : " + getMsg() + "\n";
    }
}
