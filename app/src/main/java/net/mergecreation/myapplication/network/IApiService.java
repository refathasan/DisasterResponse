package net.mergecreation.myapplication.network;

import net.mergecreation.myapplication.model.DisasterTypeModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IApiService {
    @GET("getDisasterTypeData")
    Call<DisasterTypeModel> getDisasterTypeData();
}
