package com.xmh.networkdemo.biz;

import android.content.Context;

import com.google.gson.Gson;
import com.xmh.networkdemo.application.AppConfig;
import com.xmh.networkdemo.model.JokeResult;
import com.xmh.networkdemo.web.OkHttpHelper;
import com.xmh.networkdemo.web.VolleyHelper;
import com.xmh.networkdemo.web.WebHelper;

/**
 * Created by mengh on 2016/6/7 007.
 */
public class JokeLoader {

    /**调用自带的请求*/
    public static void LoadJokeByWeb(final OnJokeLoadFinishListener listener){
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
    public static void LoadJokeByVolley(Context context,OnJokeLoadFinishListener listener){
        VolleyHelper.request(context,AppConfig.httpUrl, AppConfig.httpArg,listener);
    }

    public static void LoadJokeByOkHttp(OnJokeLoadFinishListener listener){
        OkHttpHelper.request(AppConfig.httpUrl,AppConfig.httpArg,listener);

    }

    public interface OnJokeLoadFinishListener{
        void onFinish(JokeResult result);
    }

}
