package net.mergecreation.myapplication.home_activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    int unionId;
    int wordId;
    int disasterTypeId;
    AlertDialog.Builder dialogBuilder;
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
        dialogBuilder = new AlertDialog.Builder(SelectLocationActivity.this);
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

                if(unionId<=0|| wordId<=0)
                {

                    dialogBuilder.setMessage("ওয়ার্ড বা ইউনিয়ন সিলেক্ট করা হয় নি, সিলেক্ট করুন");
                    dialogBuilder.setCancelable(true);
                    dialogBuilder.setPositiveButton("ওয়ার্ড ও ইউনিয়ন সিলেক্ট করুন", new DialogInterface.OnClickListener() {
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

                }else
                {
                Intent intent = new Intent(SelectLocationActivity.this,PostDisasterDetailsActivity.class);
                intent.putExtra(IntentStrings.DISASTER_EXTRA,disasterTypeId);
                intent.putExtra(IntentStrings.DIVISION_EXTRA,2);
                intent.putExtra(IntentStrings.DISTRICT_EXTRA,2);
                intent.putExtra(IntentStrings.UPOZILA_EXTRA,2);
                intent.putExtra(IntentStrings.UNION_EXTRA,unionId);
                intent.putExtra(IntentStrings.WORD_EXTRA,wordId);
                startActivity(intent);
                finish();
                }
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
                disasterTypeId =IntentStrings.FLOOD_ID;
            }else if(exteras.getInt(IntentStrings.FIRE_EXTRA)==IntentStrings.FIRE_ID){
                tvDisasterType.setText(getResources().getText(R.string.text_fire));
                disasterTypeId =IntentStrings.FIRE_ID;
            }else if(exteras.getInt(IntentStrings.LIGHTNING_EXTRA)==IntentStrings.LIGHTNING_ID){
                tvDisasterType.setText(getResources().getText(R.string.text_lightning));
                disasterTypeId =IntentStrings.LIGHTNING_ID;
            }else if(exteras.getInt(IntentStrings.EARTHQUAKE_EXTRA)==IntentStrings.EARTHQUAKE_ID){
                tvDisasterType.setText(getResources().getText(R.string.text_earth));
                disasterTypeId =IntentStrings.EARTHQUAKE_ID;
            }else if(exteras.getInt(IntentStrings.CYCLONE_EXTRA)==IntentStrings.CYCLONE_ID){
                tvDisasterType.setText(getResources().getText(R.string.text_cyclone));
                disasterTypeId =IntentStrings.CYCLONE_ID;
            }else if(exteras.getInt(IntentStrings.LAND_SLIDES_EXTRA)==IntentStrings.LAND_SLIDES_ID){
                tvDisasterType.setText(getResources().getText(R.string.text_land));
                disasterTypeId =IntentStrings.LAND_SLIDES_ID;
            }else if(exteras.getInt(IntentStrings.ACCIDENT_EXTRA)==IntentStrings.ACCIDENT_ID){
                tvDisasterType.setText(getResources().getText(R.string.text_accident));
                disasterTypeId =IntentStrings.ACCIDENT_ID;
            }else if(exteras.getInt(IntentStrings.BUILDING_COLLAPSE_EXTRA)==IntentStrings.BUILDING_COLLAPSE_ID){
                tvDisasterType.setText(getResources().getText(R.string.text_bcollapse));
                disasterTypeId =IntentStrings.BUILDING_COLLAPSE_ID;
            }else if(exteras.getInt(IntentStrings.SURGE_EXTRA)==IntentStrings.SURGE_ID){
                tvDisasterType.setText(getResources().getText(R.string.text_surge));
                disasterTypeId =IntentStrings.SURGE_ID;
            }
        }else
        {
            Toast.makeText(this, "Extras Null", Toast.LENGTH_SHORT).show();
        }
    }

    private void unionSetup(){
        ArrayAdapter<String>unionSpinertAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.union));
        unionSpinertAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spUnionType.setAdapter(unionSpinertAdapter);
        spUnionType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:

                        //Toast.makeText(SelectLocationActivity.this, String.valueOf(unionId), Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        unionId =2;
                        Toast.makeText(SelectLocationActivity.this, String.valueOf(unionId), Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        unionId =3;
                        Toast.makeText(SelectLocationActivity.this, String.valueOf(unionId), Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        unionId =4;
                        Toast.makeText(SelectLocationActivity.this, String.valueOf(unionId), Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        unionId =5;
                        Toast.makeText(SelectLocationActivity.this, String.valueOf(unionId), Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        unionId =6;
                        Toast.makeText(SelectLocationActivity.this, String.valueOf(unionId), Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        unionId =7;
                        Toast.makeText(SelectLocationActivity.this, String.valueOf(unionId), Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        unionId =8;
                        Toast.makeText(SelectLocationActivity.this, String.valueOf(unionId), Toast.LENGTH_SHORT).show();
                        break;
                   /* default:
                        unionId =2;
                        Toast.makeText(SelectLocationActivity.this, String.valueOf(unionId), Toast.LENGTH_SHORT).show();
                        break;*/
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                unionId =-1;
            }
        });
    }
    private void wordSetup(){
        ArrayAdapter<String>wordSpinertAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.word));
        wordSpinertAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spWordType.setAdapter(wordSpinertAdapter);
        spWordType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        break;
                    case 1:
                        wordId=1;
                        break;
                    case 2:
                        wordId=2;
                        break;
                    case 3:
                        wordId=3;
                        break;
                    case 4:
                        wordId=4;
                        break;
                    case 5:
                        wordId=5;
                        break;
                    case 6:
                        wordId=6;
                        break;
                    case 7:
                        wordId=7;
                        break;
                    case 8:
                        wordId=8;
                        break;
                    case 9:
                        wordId=9;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                wordId=-1;
            }
        });
    }
}
