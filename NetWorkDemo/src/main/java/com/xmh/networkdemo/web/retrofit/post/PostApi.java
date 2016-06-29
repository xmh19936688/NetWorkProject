package com.xmh.networkdemo.web.retrofit.post;

import com.xmh.networkdemo.application.AppConfig;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by mengh on 2016/6/28 028.
 */
public interface PostApi {

    @FormUrlEncoded
    @POST(AppConfig.POST_LIST_URL)
    Call<Object> requestPostList(@Field("client_id")String id,@Field("client_secret")String info);

    @POST(AppConfig.POST_LIST_URL)
    Call<Object> requestPostListByBody(@Body RequestBody body);

}
