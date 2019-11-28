package net.mergecreation.myapplication.network;

import net.mergecreation.myapplication.utils.Utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiIClientInstance {
    private static Retrofit retrofit;
    static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    public static Retrofit getInstance(){
        if(retrofit==null)
        {
             retrofit = new Retrofit.Builder()
                    .baseUrl(Utils.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }
}
