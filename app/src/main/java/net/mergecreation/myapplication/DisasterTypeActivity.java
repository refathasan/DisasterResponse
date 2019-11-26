package net.mergecreation.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import net.mergecreation.myapplication.base.BaseActivity;
import net.mergecreation.myapplication.model.DisasterTypeModel;
import net.mergecreation.myapplication.network.ApiInstance;
import net.mergecreation.myapplication.network.IApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisasterTypeActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    IApiService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disaster_type);
        recyclerView = findViewById(R.id.disaster_tyle_rec_view);
       // gridLayoutManager = new GridLayoutManager(this,2);
       // recyclerView.setLayoutManager(gridLayoutManager);
        apiService = ApiInstance.getInstance().create(IApiService.class);
        getAllDisasterList();

    }

    private void getAllDisasterList()
    {
        Call<DisasterTypeModel>call = apiService.getAllDisasterType();
        call.enqueue(new Callback<DisasterTypeModel>() {
            @Override
            public void onResponse(Call<DisasterTypeModel> call, Response<DisasterTypeModel> response) {
                if(response.isSuccessful())
                {
                    DisasterTypeModel disasterTypeModel = response.body();

                    Toast.makeText(DisasterTypeActivity.this, disasterTypeModel.getName(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DisasterTypeModel> call, Throwable t) {

            }
        });
    }
}
