package com.newspaper.dusz7.newspapermanagement.internet_module;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by dusz7 on 23/03/2017.
 */

/*
//回调接口在子线程中执行，如需更改UI操作，则需要传递到主线程操作
// runOnUiThread()方法
HttpUtil.sendOkHttpRequest("http://www.baidu.com", new okhttp3.Callback(){
    @Override
    public void onResponse(Call call, Response response) throws IOException {
        String responseData = response.body().string();
    }

    @Override
    public void onFailure(Call call, IOException e) {

    }
 */

public class HttpUtil {

    public static void sendOkHttpGetRequest(String address, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }

    public static void sendOkHttpPostRequest(String address, RequestBody body, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
