package com.android.logdata.example;

import com.android.logcat.log.Logcat;

/**
 * Created by Null on 2018-02-21.
 */

public class OtherClass {
    public OtherClass() {
        Logcat.i("other class constructor");
    }

    public void method1() {
        Logcat.i("other class method1");
    }

    public void method2() {
        Logcat.v("other class method2");
    }

    public void method3() {
        Logcat.d("other class method3");
    }

    public void method4() {
        Logcat.w("other class method4");
    }

    public void method5() {
        Logcat.e("other class method5");
    }
}
