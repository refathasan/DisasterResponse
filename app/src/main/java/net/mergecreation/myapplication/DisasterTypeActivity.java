package net.mergecreation.myapplication;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import net.mergecreation.myapplication.adapters.DisasterTypeAdapter;
import net.mergecreation.myapplication.base.BaseActivity;
import net.mergecreation.myapplication.network.ApiIClientInstance;
import net.mergecreation.myapplication.network.IApiService;

import java.util.ArrayList;
import java.util.List;

public class DisasterTypeActivity extends BaseActivity implements DisasterTypeAdapter.OnItemListener {
    RecyclerView recyclerView;
    List<Integer> imageList = new ArrayList<>();
    List<String>nameList = new ArrayList<>();
    Intent intent;
    IApiService iApiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disaster_type);
        initialize();

    }

    @Override
    protected void onStart() {
        super.onStart();
        //IApiService iApiService = ApiIClientInstance.getInstance().create(IApiService.class);
    }

    private void initialize()
    {
        recyclerView = findViewById(R.id.disaster_type_rec_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);
        imageList.add(R.drawable.icon_flood);
        imageList.add(R.drawable.icon_fire);
        imageList.add(R.drawable.icon_lightning);
        imageList.add(R.drawable.icon_earthquake);
        imageList.add(R.drawable.icon_cyclone);
        imageList.add(R.drawable.icon_land_slides);
        imageList.add(R.drawable.icon_accident);
        imageList.add(R.drawable.icon_building_collapse);
        imageList.add(R.drawable.icon_surge);
        nameList.add("বন্যা");
        nameList.add("অগ্নিকান্ড");
        nameList.add("বজ্রপাত");
        nameList.add("ভূমিকম্প");
        nameList.add("ঘূর্ণিঝড়");
        nameList.add("ভূমিধ্বস");
        nameList.add("সড়ক/নৌ দুর্ঘটনা");
        nameList.add("ভবন ধ্বস");
        nameList.add("জলোছ্বাস");
        recyclerView.setAdapter(new DisasterTypeAdapter(imageList,nameList,this));


    }

    @Override
    public void onItemClick(int position) {
       //Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT).show();

        switch (position){
            case 0:
                intent = new Intent();
        }
    }
}
