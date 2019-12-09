package net.mergecreation.myapplication.home_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import net.mergecreation.myapplication.R;
import net.mergecreation.myapplication.adapters.NewsAdapter;
import net.mergecreation.myapplication.base.BaseActivity;
import net.mergecreation.myapplication.model.NewsModel;
import net.mergecreation.myapplication.network.ApiIClientInstance;
import net.mergecreation.myapplication.network.IApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends BaseActivity {
    RecyclerView recyclerView;
    IApiService iApiService;
    ProgressDialog progressDoalog;
    NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        activateToolbar("সংবাদ");
        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        iApiService = ApiIClientInstance.getInstance().create(IApiService.class);
        progressDoalog = new ProgressDialog(NewsActivity.this);
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
        getNews();
    }

    private void getNews() {
        Call<List<NewsModel>> call = iApiService.getNewsData();
        call.enqueue(new Callback<List<NewsModel>>() {
            @Override
            public void onResponse(Call<List<NewsModel>> call, Response<List<NewsModel>> response) {
                if (response.isSuccessful()) {
                    newsAdapter = new NewsAdapter(NewsActivity.this, response.body());
                }
                recyclerView.setAdapter(newsAdapter);
                progressDoalog.dismiss();
            }

            @Override
            public void onFailure(Call<List<NewsModel>> call, Throwable t) {
                call.cancel();
                progressDoalog.dismiss();
            }
        });
    }
}
