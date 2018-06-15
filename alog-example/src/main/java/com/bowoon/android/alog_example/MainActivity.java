package com.bowoon.android.alog_example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.bowoon.android.alog.ALog;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ALog.logSetting(getApplicationContext(), true, true);
        ALog.setDebug(true);

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", "kim");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ArrayList<String> a = new ArrayList<>();
        a.add("Hi");
        a.add("Hello");
        HashMap<String, String> map = new HashMap<>();
        map.put("Hi", "Hello");

        ALog.v("example");
        ALog.i("example");
        ALog.d("example");
        ALog.w("example");
        ALog.e("example");

        ALog.v(jsonObject);
        ALog.i(jsonObject);
        ALog.d(jsonObject);
        ALog.w(jsonObject);
        ALog.e(jsonObject);

        ALog.v(a);
        ALog.i(map);
        ALog.d(true);
        ALog.w(1);
        ALog.e(1.0);

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
            ALog.v("activityOne intent");
            startActivity(intent);
        }
    };

    Button.OnClickListener listener2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), ActivityTwo.class);
            ALog.v("activityTwo intent");
            startActivity(intent);
        }
    };

    Button.OnClickListener listener3 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ALog.e("NullPointerException");
            throw new NullPointerException();
        }
    };

    Button.OnClickListener listener4 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ALog.e("ArrayIndexOutOfBoundsException");
            throw new ArrayIndexOutOfBoundsException();
        }
    };

    Button.OnClickListener listener5 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ALog.e("IllegalArgumentException");
            throw new IllegalArgumentException();
        }
    };

    Button.OnClickListener listener6 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ALog.e("ArithmeticException");
            throw new ArithmeticException();
        }
    };

    Button.OnClickListener listener7 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ALog.e("StackOverflowError");
            throw new StackOverflowError();
        }
    };
}
