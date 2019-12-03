package net.mergecreation.myapplication.home_activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

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
    String inputData ="";
    String disasterTitle = "";
    private TextInputEditText inputDisasterDataEditText;
    static  ProgressDialog progressDoalog;
    AlertDialog.Builder dialogBuilder;
    boolean validation = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_disaster_details);
        brnSubmitData = findViewById(R.id.btnSubmitData);
        inputDisasterDataEditText = findViewById(R.id.inputDisasterDataEditText);
        dialogBuilder = new AlertDialog.Builder(PostDisasterDetailsActivity.this);
        iApiService = ApiIClientInstance.getInstance().create(IApiService.class);
        getIntentData();
        brnSubmitData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputData = inputDisasterDataEditText.getText().toString();
                disasterTitle(disasterTypeId);

                if(textValidation()!=false)
                {

                    progressDoalog = new ProgressDialog(PostDisasterDetailsActivity.this);
                    progressDoalog.setMax(100);
                    progressDoalog.setMessage("অনুগ্রহপূর্বক অপেক্ষা করুন...");
                    progressDoalog.setTitle("আপনার তথ্য জমা হচ্ছে");
                    progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    // show it
                    progressDoalog.show();
                    postDisasterInformation(disasterTitle,inputData,disasterTypeId,"",divisionId,districtId,upozilaId,unionId,wordId,11);
                }
                else
                {
                    dialogBuilder.setMessage("দয়া করে আপনার দুর্যোগের তথ্য প্রগবেশ করান");
                    dialogBuilder.setCancelable(true);
                    dialogBuilder.setPositiveButton("তথ্য পূরণ করুন", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    dialogBuilder.setNegativeButton("বাতিল করুন", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = dialogBuilder.create();
                    alertDialog.show();

                }

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
                progressDoalog.dismiss();
                inputDisasterDataEditText.setText("");
            }

            @Override
            public void onFailure(Call<DisasterInformationResponse> call, Throwable t) {

                Toast.makeText(PostDisasterDetailsActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                Log.d("TAG--->",t.getMessage());
                //call.cancel();
                progressDoalog.dismiss();
            }
        });
    }

    private void disasterTitle(int disasterTypeId)
    {
        switch (disasterTypeId){
            case IntentStrings.FLOOD_ID:
                disasterTitle =getResources().getText(R.string.text_flood).toString();
                break;
            case IntentStrings.FIRE_ID:
                disasterTitle =getResources().getText(R.string.text_fire).toString();
                break;
            case IntentStrings.LIGHTNING_ID:
                disasterTitle =getResources().getText(R.string.text_lightning).toString();
                break;
            case IntentStrings.EARTHQUAKE_ID:
                disasterTitle = getResources().getText(R.string.text_earth).toString();
                break;
            case IntentStrings.CYCLONE_ID:
                disasterTitle = getResources().getText(R.string.text_cyclone).toString();
                break;
            case IntentStrings.LAND_SLIDES_ID:
                disasterTitle = getResources().getText(R.string.text_land).toString();
                break;
            case IntentStrings.ACCIDENT_ID:
                disasterTitle = getResources().getText(R.string.text_accident).toString();
                break;
            case IntentStrings.BUILDING_COLLAPSE_ID:
                disasterTitle = getResources().getText(R.string.text_bcollapse).toString();
                break;
            case IntentStrings.SURGE_ID:
                disasterTitle = getResources().getText(R.string.text_surge).toString();
                break;
        }
    }

    private boolean textValidation()
    {

        if(inputData.isEmpty())
        {

            validation = false;
        }else
        {

            validation = true;
        }
        return validation;
    }
}
