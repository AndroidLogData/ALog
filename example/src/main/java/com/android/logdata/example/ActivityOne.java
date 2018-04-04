package com.android.logdata.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.android.logcat.log.ALog;

/**
 * Created by Null on 2018-02-21.
 */

public class ActivityOne extends AppCompatActivity {
    long[] longArray1 = new long[10000000];
    Long[] longArray2 = new Long[10000000];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (int i = 0; i < longArray1.length; i++) {
            longArray1[i] = i;
        }
        ALog.i("long array1");

        for (int i = 0; i < longArray2.length; i++) {
            longArray2[i] = (long) i;
        }
        ALog.i("long array2");
    }
}
