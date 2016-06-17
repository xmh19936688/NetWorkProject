package com.xmh.networkdemo.web.retrofit;

import com.xmh.networkdemo.application.AppConfig;
import com.xmh.networkdemo.biz.JokeLoader;
import com.xmh.networkdemo.model.JokeResult;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mengh on 2016/6/17 017.
 */
public class RetrofitHelper {
    public static void request(final JokeLoader.OnJokeLoadFinishListener listener){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(AppConfig.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    JokeService service=retrofit.create(JokeService.class);
                    Call<JokeResult> joke = service.getJoke(AppConfig.appKey, 1);
                    JokeResult result = joke.execute().body();
                    listener.onFinish(result);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
