package net.mergecreation.myapplication.network;

import net.mergecreation.myapplication.model.DisasterInformationResponse;
import net.mergecreation.myapplication.model.DisasterTypeModel;
import net.mergecreation.myapplication.model.DivisionModel;
import net.mergecreation.myapplication.model.HelpLineModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IApiService {
    @GET("DisasterApi/getAllDisasterType")
    Call<DisasterTypeModel> getDisasterTypeData();
    @FormUrlEncoded
    @POST("DisasterApi/insertDisasterInfo")
    Call<DisasterInformationResponse> postDisaster(@Field("title") String title,
                                                   @Field("description") String description,
                                                   @Field("disaster_type_id") int disaster_type_id,
                                                   @Field("file_url") String file_url,
                                                   @Field("division_id") int division_id,
                                                   @Field("district_id") int district_id,
                                                   @Field("upazila_id") int upazila_id,
                                                   @Field("union_id") int union_id,
                                                   @Field("word_id") int word_id,
                                                   @Field("created_by") int created_by);

    @GET("DisasterApi/getDivision")
    Call<DivisionModel> divisionData();

    @GET("DisasterApi/getAllHelplineNumber")
    Call<List<HelpLineModel>>getAllHelpLineNumber();
}
