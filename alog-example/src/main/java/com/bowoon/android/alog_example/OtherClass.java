package com.bowoon.android.alog_example;

import com.bowoon.android.alog.ALog;

/**
 * Created by Null on 2018-02-21.
 */

public class OtherClass {
    public OtherClass() {
        ALog.i("other class constructor");
    }

    public void method1() {
        ALog.i("other class method1");
    }

    public void method2() {
        ALog.v("other class method2");
    }

    public void method3() {
        ALog.d("other class method3");
    }

    public void method4() {
        ALog.w("other class method4");
    }

    public void method5() {
        ALog.e("other class method5");
    }
}
