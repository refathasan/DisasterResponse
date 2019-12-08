package net.mergecreation.myapplication.home_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import net.mergecreation.myapplication.R;
import net.mergecreation.myapplication.adapters.ImmergencyPhoneTypeAdapter;
import net.mergecreation.myapplication.base.BaseActivity;
import net.mergecreation.myapplication.base.OnItemListener;
import net.mergecreation.myapplication.model.HelpLineModel;
import net.mergecreation.myapplication.network.ApiIClientInstance;
import net.mergecreation.myapplication.network.IApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImportantPhoneNumberActivity extends BaseActivity implements OnItemListener {
    RecyclerView recyclerView;
    IApiService iApiService;
    //HelpLineModel helpLineModel;
    ProgressDialog progressDoalog;
    ImmergencyPhoneTypeAdapter immergencyPhoneTypeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important_phone_number);
        activateToolbar("জরুরি যোগাযোগ");
        recyclerView = findViewById(R.id.immergecncyRecycleView);
        iApiService = ApiIClientInstance.getInstance().create(IApiService.class);
        /*LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ImportantPhoneNumberActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);*/
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);

        progressDoalog = new ProgressDialog(ImportantPhoneNumberActivity.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("অনুগ্রহপূর্বক অপেক্ষা করুন...");
        progressDoalog.setTitle("আপনার তথ্য প্রদর্শনীর জন্য তৈরী হচ্ছে");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        // show it
        progressDoalog.show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        getPhoneNumeber();
    }

    private void getPhoneNumeber() {
        Call<List<HelpLineModel>> call = iApiService.getAllHelpLineNumber();
        call.enqueue(new Callback<List<HelpLineModel>>() {
            @Override
            public void onResponse(Call<List<HelpLineModel>> call, Response<List<HelpLineModel>> response) {
                if (response.isSuccessful()) {
                    immergencyPhoneTypeAdapter = new ImmergencyPhoneTypeAdapter(ImportantPhoneNumberActivity.this, response.body());
                    // Toast.makeText(ImportantPhoneNumberActivity.this, response.body().get(0).getDescription(), Toast.LENGTH_SHORT).show();
                }
                recyclerView.setAdapter(immergencyPhoneTypeAdapter);
                progressDoalog.dismiss();
            }

            @Override
            public void onFailure(Call<List<HelpLineModel>> call, Throwable t) {
                call.cancel();
                progressDoalog.dismiss();
                Toast.makeText(ImportantPhoneNumberActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT).show();
    }
}
