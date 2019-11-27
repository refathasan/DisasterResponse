package net.mergecreation.myapplication.network;

import net.mergecreation.myapplication.model.DisasterTypeModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IApiService {
    @GET("DisasterApi/getDisasterTypeData")
    Call<DisasterTypeModel> getDisasterTypeData();
}
