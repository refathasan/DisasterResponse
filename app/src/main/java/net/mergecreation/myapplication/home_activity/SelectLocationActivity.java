package net.mergecreation.myapplication.home_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.mergecreation.myapplication.R;
import net.mergecreation.myapplication.base.BaseActivity;
import net.mergecreation.myapplication.utils.IntentStrings;

public class SelectLocationActivity extends BaseActivity {
    TextView tvDisasterType,tvDivisionType,tvDistrictType,tvUpozilaType;
    Spinner spUnionType, spWordType;
    Intent intent;
    Bundle exteras;
    Button btnBack,btnForoward;
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
        btnBack =findViewById(R.id.btnCancel);
        btnForoward=findViewById(R.id.btnSubmit);
        tvDivisionType.setText("খুলনা");
        tvDistrictType.setText("খুলনা");
        tvUpozilaType.setText("বটিয়াঘাটা");
        intent= getIntent();
        setFlag();
        unionSetup();
        wordSetup();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnForoward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectLocationActivity.this,PostDisasterDetailsActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void setFlag()
    {
        exteras = intent.getExtras();
        if(exteras!=null)
        {
            if(exteras.getInt(IntentStrings.FLOOD_EXTRA)==IntentStrings.FLOOD_ID){
                tvDisasterType.setText(getResources().getText(R.string.text_flood));
            }else if(exteras.getInt(IntentStrings.FIRE_EXTRA)==IntentStrings.FIRE_ID){
                tvDisasterType.setText(getResources().getText(R.string.text_fire));
            }else if(exteras.getInt(IntentStrings.LIGHTNING_EXTRA)==IntentStrings.LIGHTNING_ID){
                tvDisasterType.setText(getResources().getText(R.string.text_lightning));
            }else if(exteras.getInt(IntentStrings.EARTHQUAKE_EXTRA)==IntentStrings.EARTHQUAKE_ID){
                tvDisasterType.setText(getResources().getText(R.string.text_earth));
            }else if(exteras.getInt(IntentStrings.CYCLONE_EXTRA)==IntentStrings.CYCLONE_ID){
                tvDisasterType.setText(getResources().getText(R.string.text_cyclone));
            }else if(exteras.getInt(IntentStrings.LAND_SLIDES_EXTRA)==IntentStrings.LAND_SLIDES_ID){
                tvDisasterType.setText(getResources().getText(R.string.text_land));
            }else if(exteras.getInt(IntentStrings.ACCIDENT_EXTRA)==IntentStrings.ACCIDENT_ID){
                tvDisasterType.setText(getResources().getText(R.string.text_accident));
            }else if(exteras.getInt(IntentStrings.BUILDING_COLLAPSE_EXTRA)==IntentStrings.BUILDING_COLLAPSE_ID){
                tvDisasterType.setText(getResources().getText(R.string.text_bcollapse));
            }else if(exteras.getInt(IntentStrings.SURGE_EXTRA)==IntentStrings.SURGE_ID){
                tvDisasterType.setText(getResources().getText(R.string.text_surge));
            }
        }else
        {
            Toast.makeText(this, "Extras Null", Toast.LENGTH_SHORT).show();
        }
    }

    private void unionSetup(){
        ArrayAdapter<String>unionSpinertAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.union));
        spUnionType.setAdapter(unionSpinertAdapter);
    }
    private void wordSetup(){
        ArrayAdapter<String>wordSpinertAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.word));
        spWordType.setAdapter(wordSpinertAdapter);
    }
}
