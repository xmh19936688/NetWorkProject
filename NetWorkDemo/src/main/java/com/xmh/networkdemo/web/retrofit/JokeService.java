package com.xmh.networkdemo.web.retrofit;

import com.xmh.networkdemo.application.AppConfig;
import com.xmh.networkdemo.model.JokeResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by mengh on 2016/6/17 017.
 */
public interface JokeService {

    @GET(AppConfig.JOKE_URL)
    Call<JokeResult> getJoke(@Header("apikey") String appkey,@Query("page") int page);

}
