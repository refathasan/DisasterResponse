package net.mergecreation.myapplication.network;

import net.mergecreation.myapplication.utils.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiInstance {
    private static Retrofit retrofit=null;

    public static Retrofit getInstance(){
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
