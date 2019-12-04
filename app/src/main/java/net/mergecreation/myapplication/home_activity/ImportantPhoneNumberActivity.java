package net.mergecreation.myapplication.home_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import net.mergecreation.myapplication.R;
import net.mergecreation.myapplication.base.BaseActivity;

public class ImportantPhoneNumberActivity extends BaseActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important_phone_number);
        activateToolbar("জরুরি যোগাযোগ");
        recyclerView = findViewById(R.id.immergecncyRecycleView);
    }
}
