package net.mergecreation.myapplication.home_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import net.mergecreation.myapplication.R;
import net.mergecreation.myapplication.adapters.HelpLineTypeAdapter;
import net.mergecreation.myapplication.base.BaseActivity;
import net.mergecreation.myapplication.base.OnItemListener;
import net.mergecreation.myapplication.model.HelpLineCategoryTypeModel;
import net.mergecreation.myapplication.network.ApiIClientInstance;
import net.mergecreation.myapplication.network.IApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HelpLineTypeActivity extends BaseActivity implements OnItemListener {
    RecyclerView recyclerView;
    ProgressDialog progressDoalog;
    IApiService iApiService;
    HelpLineTypeAdapter helpLineTypeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_line_type);
        activateToolbar("হেল্প লাইনের ধরণ");
        iApiService = ApiIClientInstance.getInstance().create(IApiService.class);
        recyclerView = findViewById(R.id.recylerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        progressDoalog = new ProgressDialog(HelpLineTypeActivity.this);
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
        getHelpLineType();
    }

    private void getHelpLineType()
    {
        Call<List<HelpLineCategoryTypeModel>>call =iApiService.getHelpLineCategory();
        call.enqueue(new Callback<List<HelpLineCategoryTypeModel>>() {
            @Override
            public void onResponse(Call<List<HelpLineCategoryTypeModel>> call, Response<List<HelpLineCategoryTypeModel>> response) {
                if(response.isSuccessful())
                {
                    helpLineTypeAdapter = new HelpLineTypeAdapter(HelpLineTypeActivity.this,response.body());
                }
                recyclerView.setAdapter(helpLineTypeAdapter);
                progressDoalog.dismiss();
            }

            @Override
            public void onFailure(Call<List<HelpLineCategoryTypeModel>> call, Throwable t) {
                call.cancel();
                progressDoalog.dismiss();
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this,ImportantPhoneNumberActivity.class);
        startActivity(intent);
        finish();
    }
}
