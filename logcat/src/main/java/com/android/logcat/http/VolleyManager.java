package com.android.logcat.http;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyManager {
    private RequestQueue rq;

    private VolleyManager() {

    }

    private static class Singleton {
        private static final VolleyManager INSTANCE = new VolleyManager();
    }

    public static VolleyManager getInstance() {
        return Singleton.INSTANCE;
    }

    public RequestQueue getRequestQueue() throws IllegalAccessException {
        if (rq == null) {
            throw new IllegalAccessException("Need Initialize Request Queue");
        }
        return rq;
    }

    public void setRequestQueue(Context context) {
        this.rq = Volley.newRequestQueue(context);
    }
}