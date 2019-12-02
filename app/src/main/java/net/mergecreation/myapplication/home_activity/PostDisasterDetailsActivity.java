package net.mergecreation.myapplication.home_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.mergecreation.myapplication.R;
import net.mergecreation.myapplication.base.BaseActivity;
import net.mergecreation.myapplication.model.DisasterInformationResponse;
import net.mergecreation.myapplication.network.ApiIClientInstance;
import net.mergecreation.myapplication.network.IApiService;
import net.mergecreation.myapplication.utils.IntentStrings;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostDisasterDetailsActivity extends BaseActivity {
    Button brnSubmitData;
    IApiService iApiService;
    DisasterInformationResponse disasterInformationResponse;
    Intent intent;
    Bundle extras;
    int disasterTypeId, divisionId,districtId,upozilaId,unionId,wordId;
    String mDisasterTypeId, mDivisionId, mDistrictId, mUpozilaId, mUunionId, mWordId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_disaster_details);
        brnSubmitData = findViewById(R.id.btnSubmitData);
        iApiService = ApiIClientInstance.getInstance().create(IApiService.class);
        getIntentData();
        brnSubmitData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postDisasterInformation("আগুন ","পানি চাই",disasterTypeId,"",divisionId,districtId,upozilaId,unionId,wordId,11);
            }
        });
    }

    private void getIntentData(){
        intent = getIntent();
        extras = intent.getExtras();
        disasterTypeId = extras.getInt(IntentStrings.DISASTER_EXTRA);
        mDisasterTypeId = String.valueOf(disasterTypeId);
        divisionId = extras.getInt(IntentStrings.DIVISION_EXTRA);
        mDivisionId = String.valueOf(divisionId);
        districtId =extras.getInt(IntentStrings.DISTRICT_EXTRA);
        mDistrictId = String.valueOf(districtId);
        upozilaId = extras.getInt(IntentStrings.UPOZILA_EXTRA);
        mUpozilaId=String.valueOf(upozilaId);
        unionId = extras.getInt(IntentStrings.UNION_EXTRA);
        mUunionId = String.valueOf(unionId);
        wordId = extras.getInt(IntentStrings.WORD_EXTRA);
        mWordId = String.valueOf(wordId);

    }

    /**
     *
     * @param description
     * @param disasterType
     * @param image
     * @param divisionId
     * @param districtId
     * @param upozilaId
     * @param unionId
     * @param wordId
     * @param createdBy
     */
    private void postDisasterInformation(String title,String description,int disasterType,String image, int divisionId,
                                         int districtId,int upozilaId,int unionId, int wordId, int createdBy)
    {
        Call<DisasterInformationResponse>call = iApiService.postDisaster(title,description,disasterType,image,divisionId,districtId,upozilaId,unionId,wordId,createdBy);
        call.enqueue(new Callback<DisasterInformationResponse>() {
            @Override
            public void onResponse(Call<DisasterInformationResponse> call, Response<DisasterInformationResponse> response) {
                if(response!=null)
                {
                    disasterInformationResponse = response.body();
                    Toast.makeText(PostDisasterDetailsActivity.this, disasterInformationResponse.getMsg(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DisasterInformationResponse> call, Throwable t) {
                call.cancel();
            }
        });
    }
}
