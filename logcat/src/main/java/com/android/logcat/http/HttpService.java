package com.android.logcat.http;

import android.net.Uri;
import android.util.Log;

import com.android.logcat.util.LogData;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class HttpService implements ServiceInterface {
    private String makeURL() {
        Uri uri = new Uri.Builder()
                .scheme("http")
                .encodedAuthority("52.231.37.113:8080")
                .path("logdata")
                .build();
        Log.i("URL", uri.toString());
        return uri.toString();
    }

    private HttpOption httpOptionSetting(LogData data) {
        HttpOption option = new HttpOption();

        option.setContentType("application/x-www-form-urlencoded");
        option.setAcceptEncoding("gzip, deflate");
        option.setLogLevel(data.getLevel());
        option.setTag(data.getTag());
        option.setLogMessage(data.getMsg());
        option.setTime(data.getTime());
        option.setAvailMemory(data.getAvailMemory());
        option.setTotalMemory(data.getTotalMemory());
        option.setMemoryPercentage(data.getMemoryPercentage());
        option.setLowMemory(data.isLowMemory());
        option.setThreshold(data.getThreshold());
        option.setDalvikPss(data.getDalvikPss());
        option.setOtherPss(data.getOtherPss());
        option.setNativePss(data.getNativePss());

        return option;
    }

    private JSONObject makeJSON(LogData data) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message", data.getMsg());
            jsonObject.put("tag", data.getTag());
            jsonObject.put("level", data.getLevel());
            jsonObject.put("time", data.getTime());
            jsonObject.put("totalMemory", data.getTotalMemory());
            jsonObject.put("availMemory", data.getAvailMemory());
            jsonObject.put("memoryPercentage", data.getMemoryPercentage());
            jsonObject.put("threshold", data.getThreshold());
            jsonObject.put("lowMemory", data.isLowMemory());
            jsonObject.put("dalvikPss", data.getDalvikPss());
            jsonObject.put("otherPss", data.getOtherPss());
            jsonObject.put("totalPss", data.getTotalPss());
            return jsonObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void requestLogData(LogData data, final VolleyCallback callback) {
        String url = makeURL();

        JSONObject jsonObject = makeJSON(data);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                url,
                jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("Response", "success");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VolleyError", "error");
                    }
                });

        request.setRetryPolicy(new DefaultRetryPolicy(2000, 5, 1));

        addRequestQueue(request);
    }

    private void addRequestQueue(JsonObjectRequest request) {
        try {
            VolleyManager.getInstance().getRequestQueue().add(request);
        } catch (IllegalAccessException e) {
            Log.i("IllegalAccessException", e.getMessage());
        }
    }
}