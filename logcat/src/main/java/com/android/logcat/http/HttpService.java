package com.android.logcat.http;

import android.net.Uri;
import android.util.Log;

import com.android.logcat.util.LogData;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

public class HttpService implements ServiceInterface {
    private String makeURL() {
        Uri uri = new Uri.Builder()
                .scheme("http")
                .encodedAuthority("192.168.0.7:8080")
                .path("logdata")
                .build();
        Log.i("URL", uri.toString());
        return uri.toString();
    }

    private HttpOption httpOptionSetting(LogData data) {
        HttpOption option = new HttpOption();

        option.setBodyContentType("application/x-www-form-urlencoded; charset=utf-8");
        option.setLogLevel(data.getLevel());
        option.setLogMessage(data.getMsg());
        option.setTime(data.getTime());
        option.setAvailMemory(data.getAvailMemory());
        option.setTotalMemory(data.getTotalMemory());
        option.setMemoryPercentage(data.getMemoryPercentage());
        option.setLowMemory(data.isLowMemory());
        option.setThreshold(data.getThreshold());

        return option;
    }

    public void requestLogData(LogData data, final VolleyCallback callback) {
        String url = makeURL();

        HttpOption option = httpOptionSetting(data);

        VolleyCustomRequest request = new VolleyCustomRequest(
                Request.Method.POST,
                url,
                option,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("Response", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VolleyError", "error");
                        Log.e("VolleyError", error.getMessage());
                    }
                });


        request.setRetryPolicy(new DefaultRetryPolicy(2000, 5, 1));

        addRequestQueue(request);
    }

    private void addRequestQueue(VolleyCustomRequest request) {
        try {
            VolleyManager.getInstance().getRequestQueue().add(request);
        } catch (IllegalAccessException e) {
            Log.i("IllegalAccessException", e.getMessage());
        }
    }
}