package com.xmh.networkdemo.web;

import com.google.gson.Gson;
import com.xmh.networkdemo.application.AppConfig;
import com.xmh.networkdemo.biz.JokeLoader;
import com.xmh.networkdemo.model.JokeResult;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mengh on 2016/6/7 007.
 */
public class OkHttpHelper {

    public static void request(String httpUrl, String httpArg, final JokeLoader.OnJokeLoadFinishListener listener){
        httpUrl = httpUrl + "?" + httpArg;//拼接url
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(httpUrl)
                .addHeader("apikey", AppConfig.appKey)//header
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //处理返回json串
                JokeResult jokeResult = new Gson().fromJson(response.body().string(), JokeResult.class);
                listener.onFinish(jokeResult);
            }
        });

    }
}
