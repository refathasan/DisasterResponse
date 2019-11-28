package net.mergecreation.myapplication.home_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import net.mergecreation.myapplication.R;
import net.mergecreation.myapplication.base.BaseActivity;

public class HotlineActivity extends BaseActivity {
    RecyclerView hotlineRecView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotline);
    }

    private void initialize()
    {
        hotlineRecView = findViewById(R.id.hotline_rec_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        hotlineRecView.setLayoutManager(gridLayoutManager);
    }
}
