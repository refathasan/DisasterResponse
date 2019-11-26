package net.mergecreation.myapplication.network;

import net.mergecreation.myapplication.utils.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiIClientInstance {
    private static Retrofit retrofit;

    public static synchronized Retrofit getInstance(){
        if(retrofit==null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Utils.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
