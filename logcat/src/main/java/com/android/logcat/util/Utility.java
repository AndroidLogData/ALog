package com.android.logcat.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by Null on 2018-01-10.
 */

public class Utility {
    public static String getTime() {
        DateTime date = DateTime.now();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

        return date.toString(fmt);
    }
}
