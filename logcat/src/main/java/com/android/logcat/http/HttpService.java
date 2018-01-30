package com.android.logcat.http;

import android.net.Uri;
import android.util.Log;

import com.android.logcat.vo.LogVO;
import com.android.logcat.util.TransferType;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.acra.ReportField;
import org.acra.data.CrashReportData;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpService implements ServiceInterface {
    private String makeURL(TransferType type) {
        Uri.Builder uri = new Uri.Builder();
        uri.scheme("http");
//        uri.encodedAuthority("52.231.37.113:8080");
        uri.encodedAuthority("192.168.0.7:8080");

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

    private JSONObject makeLogDataJSON(LogVO data) {
        try {
            JSONObject jsonObject = new JSONObject();
            JSONObject memoryInfo = new JSONObject();

            jsonObject.put("packageName", data.getPackageName());
            jsonObject.put("message", data.getMsg());
            jsonObject.put("tag", data.getTag());
            jsonObject.put("level", data.getLevel());
            jsonObject.put("time", data.getTime());

            memoryInfo.put("totalMemory", data.getMemory().getTotalMemory());
            memoryInfo.put("availMemory", data.getMemory().getAvailMemory());
            memoryInfo.put("memoryPercentage", data.getMemory().getMemoryPercentage());
            memoryInfo.put("threshold", data.getMemory().getThreshold());
            memoryInfo.put("lowMemory", data.getMemory().isLowMemory());
            memoryInfo.put("dalvikPss", data.getMemory().getDalvikPss());
            memoryInfo.put("nativePss", data.getMemory().getNativePss());
            memoryInfo.put("otherPss", data.getMemory().getOtherPss());
            memoryInfo.put("totalPss", data.getMemory().getTotalPss());

            jsonObject.put("memoryInfo", memoryInfo);
            return jsonObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private JSONObject makeCrashDataJSON(CrashReportData report) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("packageName", report.get(String.valueOf(ReportField.PACKAGE_NAME)));
            jsonObject.put("androidVersion", report.get(String.valueOf(ReportField.ANDROID_VERSION)));
            jsonObject.put("appVersionCode", report.get(String.valueOf(ReportField.APP_VERSION_CODE)));
            jsonObject.put("appVersionName", report.get(String.valueOf(ReportField.APP_VERSION_NAME)));
            jsonObject.put("availableMemorySize", report.get(String.valueOf(ReportField.AVAILABLE_MEM_SIZE)));
            jsonObject.put("brand", report.get(String.valueOf(ReportField.BRAND)));
            jsonObject.put("build", report.get(String.valueOf(ReportField.BUILD)));
            jsonObject.put("deviceID", report.get(String.valueOf(ReportField.DEVICE_ID)));
            jsonObject.put("display", report.get(String.valueOf(ReportField.DISPLAY)));
            jsonObject.put("deviceFeatures", report.get(String.valueOf(ReportField.DEVICE_FEATURES)));
            jsonObject.put("environment", report.get(String.valueOf(ReportField.ENVIRONMENT)));
            jsonObject.put("packageName", report.get(String.valueOf(ReportField.PACKAGE_NAME)));
            jsonObject.put("totalMemorySize", report.get(String.valueOf(ReportField.TOTAL_MEM_SIZE)));
            jsonObject.put("applicationLog", report.get(String.valueOf(ReportField.APPLICATION_LOG)));
            jsonObject.put("logcat", report.get(String.valueOf(ReportField.LOGCAT)));
            jsonObject.put("time", System.currentTimeMillis());
            return jsonObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private HttpOption httpOptionSetting(String apiKey) {
        HttpOption option = new HttpOption();

        option.setBodyContentType("application/json");
        option.setContentType("application/json");
        option.setSecretKey(apiKey);

        return option;
    }

    public void requestCrashData(String apiKey, CrashReportData report, final VolleyCallback callback) {
        String url = makeURL(TransferType.CRASH);

        HttpOption option = httpOptionSetting(apiKey);
        JSONObject jsonObject = makeCrashDataJSON(report);

        JsonCustomRequest request = new JsonCustomRequest(
                Request.Method.POST,
                url,
                option,
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

    public void requestLogData(String apiKey, LogVO data, final VolleyCallback callback) {
        String url = makeURL(TransferType.LOG_DATA);

        HttpOption option = httpOptionSetting(apiKey);
        JSONObject jsonObject = makeLogDataJSON(data);

        JsonCustomRequest request = new JsonCustomRequest(
                Request.Method.POST,
                url,
                option,
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

    private void addRequestQueue(JsonCustomRequest request) {
        try {
            VolleyManager.getInstance().getRequestQueue().add(request);
        } catch (IllegalAccessException e) {
            Log.i("IllegalAccessException", e.getMessage());
        }
    }
}