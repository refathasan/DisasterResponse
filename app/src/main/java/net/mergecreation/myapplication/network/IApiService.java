package net.mergecreation.myapplication.network;

import net.mergecreation.myapplication.model.DisasterInformationResponse;
import net.mergecreation.myapplication.model.DisasterTypeModel;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IApiService {
    @GET("DisasterApi/getAllDisasterType")
    Call<DisasterTypeModel> getDisasterTypeData();
    @FormUrlEncoded
    @POST("DisasterApi/insertDisasterInfo")
    Call<DisasterInformationResponse> postDisaster();
}
