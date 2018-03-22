package com.android.logcat.vo;

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

    @Override
    public String toString() {
        return "LogLevel : " + getLevel() + "\n" +
                "Time : " + getTime() + "\n" +
                "Tag : " + getTag() + "\n" +
                "Message : " + getMsg() + "\n";
    }
}
