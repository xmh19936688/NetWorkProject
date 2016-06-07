package com.xmh.networkdemo.web;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.xmh.networkdemo.application.AppConfig;
import com.xmh.networkdemo.biz.JokeLoader;
import com.xmh.networkdemo.model.JokeResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengh on 2016/6/7 007.
 */
public class VolleyHelper {

    public static void request(Context context,String httpUrl, String httpArg, final JokeLoader.OnJokeLoadFinishListener listener){
        httpUrl = httpUrl + "?" + httpArg;//拼接url
        StringRequest stringRequest = new StringRequest(httpUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //处理返回json串
                JokeResult jokeResult = new Gson().fromJson(response, JokeResult.class);
                listener.onFinish(jokeResult);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            //重载方法添加header
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("apikey",AppConfig.appKey);
                return map;
            }
        };
        Volley.newRequestQueue(context).add(stringRequest);
    }

}
