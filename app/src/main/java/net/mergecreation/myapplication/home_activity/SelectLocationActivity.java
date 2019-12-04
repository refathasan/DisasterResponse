package net.mergecreation.myapplication.home_activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.mergecreation.myapplication.R;
import net.mergecreation.myapplication.base.BaseActivity;
import net.mergecreation.myapplication.model.DivisionModel;
import net.mergecreation.myapplication.network.ApiIClientInstance;
import net.mergecreation.myapplication.network.IApiService;
import net.mergecreation.myapplication.utils.IntentStrings;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectLocationActivity extends BaseActivity {
    Spinner spDivisionType, spDistrictType, spUpozilaType;
    TextView tvDisasterType;
    Spinner spUnionType, spWordType;
    Intent intent;
    Bundle exteras;
    Button btnBack, btnForoward;
    int divisionId;
    int districtId;
    int upozilaId;
    int unionId;
    int wordId;
    int disasterTypeId;
    CharSequence disasterType="";
    AlertDialog.Builder dialogBuilder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_location);

        tvDisasterType =findViewById(R.id.tv_location_title);
        spDivisionType = findViewById(R.id.sp_division_type);
        spDistrictType = findViewById(R.id.sp_district_type);
        spUpozilaType = findViewById(R.id.sp_upozila_type);
        spUnionType = findViewById(R.id.sp_uni_type);
        spWordType = findViewById(R.id.sp_wor_type);
        btnBack = findViewById(R.id.btnCancel);
        btnForoward = findViewById(R.id.btnSubmit);
        dialogBuilder = new AlertDialog.Builder(SelectLocationActivity.this);
        intent = getIntent();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnForoward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (divisionId <= 0 || districtId <= 0 || upozilaId <= 0||unionId <= 0 || wordId <= 0 ) {

                    dialogBuilder.setMessage("বিভাগ/ জেলা / উপজেলা / ওয়ার্ড /ইউনিয়ন সিলেক্ট করা হয় নি, সিলেক্ট করুন");
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

                } else {
                    Intent intent = new Intent(SelectLocationActivity.this, PostDisasterDetailsActivity.class);
                    intent.putExtra(IntentStrings.DISASTER_EXTRA, disasterTypeId);
                    intent.putExtra(IntentStrings.DIVISION_EXTRA, divisionId);
                    intent.putExtra(IntentStrings.DISTRICT_EXTRA, districtId);
                    intent.putExtra(IntentStrings.UPOZILA_EXTRA, upozilaId);
                    intent.putExtra(IntentStrings.UNION_EXTRA, unionId);
                    intent.putExtra(IntentStrings.WORD_EXTRA, wordId);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        activateToolbar("দূর্যোগের অবসস্থান");
        setFlag();
        tvDisasterType.setText("দুর্যোগের ধরণঃ "+disasterType);
        divisionSetup();
        districtSetup();
        upozilaSetup();
        unionSetup();
        wordSetup();

    }

    private void setFlag()
          {
              exteras = intent.getExtras();
              if(exteras!=null)
              {
                  if(exteras.getInt(IntentStrings.FLOOD_EXTRA)==IntentStrings.FLOOD_ID){
                     // spDisasterType.setText();
                      disasterType =getResources().getText(R.string.text_flood);
                      disasterTypeId =IntentStrings.FLOOD_ID;
                  }else if(exteras.getInt(IntentStrings.FIRE_EXTRA)==IntentStrings.FIRE_ID){
                     // spDisasterType.setText();
                      disasterType = getResources().getText(R.string.text_fire);
                      disasterTypeId =IntentStrings.FIRE_ID;
                  }else if(exteras.getInt(IntentStrings.LIGHTNING_EXTRA)==IntentStrings.LIGHTNING_ID){
                     // spDisasterType.setText();
                      disasterType =getResources().getText(R.string.text_lightning);
                      disasterTypeId =IntentStrings.LIGHTNING_ID;
                  }else if(exteras.getInt(IntentStrings.EARTHQUAKE_EXTRA)==IntentStrings.EARTHQUAKE_ID){
                     // spDisasterType.setText();
                      disasterType=getResources().getText(R.string.text_earth);
                      disasterTypeId =IntentStrings.EARTHQUAKE_ID;
                  }else if(exteras.getInt(IntentStrings.CYCLONE_EXTRA)==IntentStrings.CYCLONE_ID){
                     // spDisasterType.setText();
                      disasterType=getResources().getText(R.string.text_cyclone);
                      disasterTypeId =IntentStrings.CYCLONE_ID;
                  }else if(exteras.getInt(IntentStrings.LAND_SLIDES_EXTRA)==IntentStrings.LAND_SLIDES_ID){
                     // spDisasterType.setText();
                      disasterType=getResources().getText(R.string.text_land);
                      disasterTypeId =IntentStrings.LAND_SLIDES_ID;
                  }else if(exteras.getInt(IntentStrings.ACCIDENT_EXTRA)==IntentStrings.ACCIDENT_ID){
                      //spDisasterType.setText();
                      disasterType=getResources().getText(R.string.text_accident);
                      disasterTypeId =IntentStrings.ACCIDENT_ID;
                  }else if(exteras.getInt(IntentStrings.BUILDING_COLLAPSE_EXTRA)==IntentStrings.BUILDING_COLLAPSE_ID){
                     // spDisasterType.setText();
                      disasterType =getResources().getText(R.string.text_bcollapse);
                      disasterTypeId =IntentStrings.BUILDING_COLLAPSE_ID;
                  }else if(exteras.getInt(IntentStrings.SURGE_EXTRA)==IntentStrings.SURGE_ID){
                     // spDisasterType.setText();
                      disasterType =getResources().getText(R.string.text_surge);
                      disasterTypeId =IntentStrings.SURGE_ID;
                  }
              }else
              {
                  Toast.makeText(this, "Extras Null", Toast.LENGTH_SHORT).show();
              }
          }
          //division
    private void divisionSetup() {
        ArrayAdapter<String> divisionAdapter = new ArrayAdapter<String>(SelectLocationActivity.this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.division));
        divisionAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spDivisionType.setAdapter(divisionAdapter);
        spDivisionType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        divisionId = 2;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                divisionId = -1;
            }
        });
    }
    //district
    private void districtSetup() {
        ArrayAdapter<String> districtAdapter = new ArrayAdapter<String>(SelectLocationActivity.this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.district));
        districtAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spDistrictType.setAdapter(districtAdapter);
        spDistrictType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        districtId = 2;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                districtId = -1;
            }
        });
    }

    private void upozilaSetup() {
        ArrayAdapter<String> upozilaAdapter = new ArrayAdapter<String>(SelectLocationActivity.this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.upozila));
        upozilaAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spUpozilaType.setAdapter(upozilaAdapter);
        spUpozilaType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        upozilaId = 2;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                upozilaId = -1;
            }
        });
    }

    private void unionSetup() {
        ArrayAdapter<String> unionSpinertAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.union));
        unionSpinertAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spUnionType.setAdapter(unionSpinertAdapter);
        spUnionType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:

                        //Toast.makeText(SelectLocationActivity.this, String.valueOf(unionId), Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        unionId = 2;
                        //Toast.makeText(SelectLocationActivity.this, String.valueOf(unionId), Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        unionId = 3;
                        //Toast.makeText(SelectLocationActivity.this, String.valueOf(unionId), Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        unionId = 4;
                        //Toast.makeText(SelectLocationActivity.this, String.valueOf(unionId), Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        unionId = 5;
                        //Toast.makeText(SelectLocationActivity.this, String.valueOf(unionId), Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        unionId = 6;
                        //Toast.makeText(SelectLocationActivity.this, String.valueOf(unionId), Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        unionId = 7;
                        //Toast.makeText(SelectLocationActivity.this, String.valueOf(unionId), Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        unionId = 8;
                        //Toast.makeText(SelectLocationActivity.this, String.valueOf(unionId), Toast.LENGTH_SHORT).show();
                        break;
                   /* default:
                        unionId =2;
                        Toast.makeText(SelectLocationActivity.this, String.valueOf(unionId), Toast.LENGTH_SHORT).show();
                        break;*/
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                unionId = -1;
            }
        });
    }

    private void wordSetup() {
        ArrayAdapter<String> wordSpinertAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.word));
        wordSpinertAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spWordType.setAdapter(wordSpinertAdapter);
        spWordType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        wordId = 1;
                        break;
                    case 2:
                        wordId = 2;
                        break;
                    case 3:
                        wordId = 3;
                        break;
                    case 4:
                        wordId = 4;
                        break;
                    case 5:
                        wordId = 5;
                        break;
                    case 6:
                        wordId = 6;
                        break;
                    case 7:
                        wordId = 7;
                        break;
                    case 8:
                        wordId = 8;
                        break;
                    case 9:
                        wordId = 9;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                wordId = -1;
            }
        });
    }
}
