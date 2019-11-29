package net.mergecreation.myapplication.home_activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import net.mergecreation.myapplication.R;
import net.mergecreation.myapplication.base.BaseActivity;
import net.mergecreation.myapplication.utils.IntentStrings;

public class SelectLocationActivity extends BaseActivity {
    TextView tvDisasterType,tvDivisionType,tvDistrictType,tvUpozilaType;
    Spinner spUnionType, spWordType;
    Intent intent;
    int disasterTypeValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_location);
        tvDisasterType =findViewById(R.id.tv_disa_type);
        tvDivisionType=findViewById(R.id.tv_div_type);
        tvDistrictType=findViewById(R.id.tv_dis_type);
        tvUpozilaType=findViewById(R.id.tv_up_type);
        spUnionType=findViewById(R.id.sp_uni_type);
        spWordType=findViewById(R.id.sp_wor_type);
        intent= getIntent();



    }



    private void getDisaster(int type)
    {
        switch (disasterTypeValue)
        {
            case 0:
                tvDisasterType.setText(getResources().getText(R.string.text_flood));
                break;
            case 1:
                tvDisasterType.setText(getResources().getText(R.string.text_fire));
                break;
            case 2:
                tvDisasterType.setText(getResources().getText(R.string.text_lightning));
                break;
            case 3:
                tvDisasterType.setText(getResources().getText(R.string.text_earth));
                break;
            case 4:
                tvDisasterType.setText(getResources().getText(R.string.text_cyclone));
                break;
            case 5:
                tvDisasterType.setText(getResources().getText(R.string.text_land));
                break;
            case 6:
                tvDisasterType.setText(getResources().getText(R.string.text_accident));
                break;
            case 7:
                tvDisasterType.setText(getResources().getText(R.string.text_bcollapse));
                break;
            case 8:
                tvDisasterType.setText(getResources().getText(R.string.text_surge));
                break;
        }
    }

    private int getIntentData( String value)
    {
        disasterTypeValue =intent.getIntExtra(value);
        switch (disasterTypeValue){
            case 0 :


        }
    }

}
