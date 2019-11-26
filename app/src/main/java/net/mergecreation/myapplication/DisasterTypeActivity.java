package net.mergecreation.myapplication;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;

import net.mergecreation.myapplication.base.BaseActivity;
import net.mergecreation.myapplication.model.DisasterTypeModel;
import net.mergecreation.myapplication.network.ApiIClientInstance;
import net.mergecreation.myapplication.network.IApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisasterTypeActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    IApiService iApiService;
    List<String>images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disaster_type);
        recyclerView = findViewById(R.id.disaster_type_rec_view);
        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

       // getAllDisasterList();

    }

    @Override
    protected void onStart() {
        super.onStart();
        iApiService = ApiIClientInstance.getInstance().create(IApiService.class);
        Log.e("TAG-->",iApiService.toString());
        getAllDisasterList();
    }

    private void getAllDisasterList() {
        Call<DisasterTypeModel> call = iApiService.getDisasterTypeData();
        call.enqueue(new Callback<DisasterTypeModel>() {
            @Override
            public void onResponse(Call<DisasterTypeModel> call, Response<DisasterTypeModel> response) {
                if (response!=null) {
                    DisasterTypeModel disasterTypeModel = response.body();
                    images.add(disasterTypeModel.getImgUrl());
                    //Toast.makeText(DisasterTypeActivity.this, disasterTypeModel.getName(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DisasterTypeModel> call, Throwable t) {
                call.cancel();
            }
        });
    }
}
