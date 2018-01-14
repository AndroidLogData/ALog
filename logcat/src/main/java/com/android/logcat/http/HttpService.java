package com.android.logcat.http;

import android.net.Uri;
import android.util.Log;

import com.android.logcat.util.LogData;
import com.android.logcat.util.TransferType;
import com.android.logcat.util.Utility;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.acra.ReportField;
import org.acra.data.CrashReportData;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpService implements ServiceInterface {
    private String makeURL(TransferType type) {
        Uri.Builder uri = new Uri.Builder();
        uri.scheme("http");
        uri.encodedAuthority("52.231.37.113:8080");
//        uri.encodedAuthority("192.168.0.7:8080");

        switch (type) {
            case CRASH:
                uri.path("crash");
                break;
            case LOG_DATA:
                uri.path("logdata");
                break;
            default:
                break;
        }

        return uri.build().toString();
    }

    private JSONObject makeLogDataJSON(LogData data) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("packageName", data.getPackageName());
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
            jsonObject.put("nativePss", data.getNativePss());
            jsonObject.put("otherPss", data.getOtherPss());
            jsonObject.put("totalPss", data.getTotalPss());
            return jsonObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private JSONObject makeCrashDataJSON(CrashReportData report) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("AndroidVersion", report.getString(ReportField.ANDROID_VERSION));
            jsonObject.put("APPVersionCode", report.getString(ReportField.APP_VERSION_CODE));
            jsonObject.put("APPVersionName", report.getString(ReportField.APP_VERSION_NAME));
            jsonObject.put("AvailableMemorySize", report.getString(ReportField.AVAILABLE_MEM_SIZE));
            jsonObject.put("Brand", report.getString(ReportField.BRAND));
            jsonObject.put("Build", report.getString(ReportField.BUILD));
            jsonObject.put("DeviceID", report.getString(ReportField.DEVICE_ID));
            jsonObject.put("Display", report.getString(ReportField.DISPLAY));
            jsonObject.put("DeviceFeatures", report.getString(ReportField.DEVICE_FEATURES));
            jsonObject.put("Environment", report.getString(ReportField.ENVIRONMENT));
            jsonObject.put("PackageName", report.getString(ReportField.PACKAGE_NAME));
            jsonObject.put("TotalMemorySize", report.getString(ReportField.TOTAL_MEM_SIZE));
            jsonObject.put("ApplicationLog", report.getString(ReportField.APPLICATION_LOG));
            jsonObject.put("Logcat", report.getString(ReportField.LOGCAT));
            jsonObject.put("Time", Utility.getTime());
            return jsonObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void requestCrashData(CrashReportData report, final VolleyCallback callback) {
        String url = makeURL(TransferType.CRASH);

        JSONObject jsonObject = makeCrashDataJSON(report);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                url,
                jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.i("Response", response.get("result").toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VolleyError", "Crash Transfer Error");
                    }
                });

        request.setRetryPolicy(new DefaultRetryPolicy(2000, 5, 1));

        addRequestQueue(request);
    }

    public void requestLogData(LogData data, final VolleyCallback callback) {
        String url = makeURL(TransferType.LOG_DATA);

        JSONObject jsonObject = makeLogDataJSON(data);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                url,
                jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.i("Response", response.get("result").toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VolleyError", "Log Transfer Error");
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