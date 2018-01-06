package com.android.logcat.http;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by 보운 on 2017-12-23.
 */

public class VolleyCustomRequest extends Request<String> {
    private final Listener<String> mListener;
    private HttpOption option;

    public VolleyCustomRequest(int method, String url, Listener<String> listener, ErrorListener errorListener) {
        super(method, url, errorListener);
        this.mListener = listener;
    }

    public VolleyCustomRequest(int method, String url, HttpOption option, Listener<String> listener, ErrorListener errorListener) {
        super(method, url, errorListener);
        this.mListener = listener;
        this.option = option;
    }

    @Override
    public String getBodyContentType() {
        if (option.getBodyContentType() != null) {
            return option.getBodyContentType();
        }
        return "application/x-www-form-urlencoded; charset=utf-8";
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        if (option.getHeaders() != null) {
            return option.getHeaders();
        }
        return null;
    }

    @Override
    public Map<String, String> getParams() throws AuthFailureError {
        if (option.getParams() != null) {
            return option.getParams();
        }
        return null;
    }

    @Override
    protected void deliverResponse(String response) {
        mListener.onResponse(response);
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        String parsed;
        try {
            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            parsed = new String(response.data);
        }
        return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
    }
}
