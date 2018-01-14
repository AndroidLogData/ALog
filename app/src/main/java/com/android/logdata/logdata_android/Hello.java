package com.android.logdata.logdata_android;

import com.android.logcat.log.Logcat;

/**
 * Created by Null on 2018-01-11.
 */

public class Hello {
    public Hello() {
        Logcat.i("Hello info");
        Logcat.e("Hello error");
        Logcat.d("Hello debug");
        Logcat.w("Hello warning");
        Logcat.v("Hello verb");
    }
}
