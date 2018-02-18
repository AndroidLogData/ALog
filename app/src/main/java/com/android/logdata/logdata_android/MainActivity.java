package com.android.logdata.logdata_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.logcat.log.Logcat;

import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {
    private Long[] longs = new Long[10000000];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logcat.logSetting(getApplicationContext(), true, true);
        Logcat.setDebug(true);

        Practice p = new Practice();
        p.pracitce();

        Hello h = new Hello();

        Logcat.i("info");
        Logcat.e("error");
        Logcat.d("debug");
        Logcat.w("warning");
        Logcat.v("verb");

        Button btn1 = (Button) findViewById(R.id.main_btn_1);
        btn1.setOnClickListener(listener1);
        Button btn2 = (Button) findViewById(R.id.main_btn_2);
        btn2.setOnClickListener(listener2);
        Button btn3 = (Button) findViewById(R.id.main_btn_3);
        btn3.setOnClickListener(listener3);
        Button btn4 = (Button) findViewById(R.id.main_btn_4);
        btn4.setOnClickListener(listener4);
        Button btn5 = (Button) findViewById(R.id.main_btn_5);
        btn5.setOnClickListener(listener5);

        for (int i = 0; i < longs.length; i++) {
            longs[i] = 1L;
        }
    }

    Button.OnClickListener listener1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            throw new NullPointerException();
        }
    };

    Button.OnClickListener listener2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            throw new IllegalArgumentException();
        }
    };

    Button.OnClickListener listener3 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            throw new ArrayIndexOutOfBoundsException();
        }
    };

    Button.OnClickListener listener4 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                throw new ClassNotFoundException();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    };

    Button.OnClickListener listener5 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    };
}
