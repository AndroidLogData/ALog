package com.android.logdata.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.logcat.log.Logcat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logcat.logSetting(getApplicationContext(), true, true);
        Logcat.setDebug(true);

        Logcat.v("example");
        Logcat.i("example");
        Logcat.d("example");
        Logcat.w("example");
        Logcat.e("example");

        Button button1 = (Button) findViewById(R.id.main_activity_one_btn);
        Button button2 = (Button) findViewById(R.id.main_activity_two_btn);
        Button button3 = (Button) findViewById(R.id.main_null_exception_btn);
        Button button4 = (Button) findViewById(R.id.main_array_index_exception_btn);
        Button button5 = (Button) findViewById(R.id.main_illegal_argument_exception_btn);
        Button button6 = (Button) findViewById(R.id.main_arithmetic_exception_btn);
        Button button7 = (Button) findViewById(R.id.main_stack_overflow_error_btn);
        button1.setOnClickListener(listener1);
        button2.setOnClickListener(listener2);
        button3.setOnClickListener(listener3);
        button4.setOnClickListener(listener4);
        button5.setOnClickListener(listener5);
        button6.setOnClickListener(listener6);
        button7.setOnClickListener(listener7);
    }

    Button.OnClickListener listener1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), ActivityOne.class);
            Logcat.v("activityOne intent");
            startActivity(intent);
        }
    };

    Button.OnClickListener listener2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), ActivityTwo.class);
            Logcat.v("activityTwo intent");
            startActivity(intent);
        }
    };

    Button.OnClickListener listener3 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Logcat.e("NullPointerException");
            throw new NullPointerException();
        }
    };

    Button.OnClickListener listener4 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Logcat.e("ArrayIndexOutOfBoundsException");
            throw new ArrayIndexOutOfBoundsException();
        }
    };

    Button.OnClickListener listener5 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Logcat.e("IllegalArgumentException");
            throw new IllegalArgumentException();
        }
    };

    Button.OnClickListener listener6 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Logcat.e("ArithmeticException");
            throw new ArithmeticException();
        }
    };

    Button.OnClickListener listener7 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Logcat.e("StackOverflowError");
            throw new StackOverflowError();
        }
    };
}
