package com.bowoon.android.alog.util;

/**
 * Created by haioe on 2018-03-22.
 */

public enum LogType {
    VERB("v"),
    INFO("i"),
    DEBUG("d"),
    WARNING("w"),
    ERROR("e");

    private String level;

    LogType(String level) {
        this.level = level;
    }

    public String getValue() {
        return level;
    }
}
