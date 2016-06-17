package com.xmh.networkdemo.biz;

import android.content.Context;

import com.google.gson.Gson;
import com.xmh.networkdemo.application.AppConfig;
import com.xmh.networkdemo.model.JokeResult;
import com.xmh.networkdemo.web.OkHttpHelper;
import com.xmh.networkdemo.web.VolleyHelper;
import com.xmh.networkdemo.web.WebHelper;
import com.xmh.networkdemo.web.retrofit.RetrofitHelper;

/**
 * Created by mengh on 2016/6/7 007.
 */
public class JokeLoader {

    /**调用原生请求*/
    public static void loadJokeByWeb(final OnJokeLoadFinishListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String jsonResult = WebHelper.request(AppConfig.httpUrl, AppConfig.httpArg);
                JokeResult jokeResult = new Gson().fromJson(jsonResult, JokeResult.class);
                listener.onFinish(jokeResult);
            }
        }).start();
    }

    /**调用volley请求*/
    public static void loadJokeByVolley(Context context, OnJokeLoadFinishListener listener){
        VolleyHelper.request(context,AppConfig.httpUrl, AppConfig.httpArg,listener);
    }

    /**调用okHttp请求*/
    public static void loadJokeByOkHttp(OnJokeLoadFinishListener listener){
        OkHttpHelper.request(AppConfig.httpUrl,AppConfig.httpArg,listener);

    }

    public static void loadJokeByRetrofit(OnJokeLoadFinishListener listener){
        RetrofitHelper.request(listener);
    }

    /**请求成功后的回调*/
    public interface OnJokeLoadFinishListener{
        void onFinish(JokeResult result);
    }

}
