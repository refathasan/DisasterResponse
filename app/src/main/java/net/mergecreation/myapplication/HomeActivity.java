package net.mergecreation.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.mergecreation.myapplication.base.BaseActivity;

public class HomeActivity extends BaseActivity {
    private Button btnDisasterInfo, btnAskForHelp, btnImportantPhoneNumber, btnHotLine, btnNews, btnOthers;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnDisasterInfo = findViewById(R.id.btn_disaster_info);
        btnAskForHelp = findViewById(R.id.btn_disaster_ask_help);
        btnImportantPhoneNumber = findViewById(R.id.btn_important_phn);
        btnHotLine = findViewById(R.id.btn_hotline);
        btnNews = findViewById(R.id.btn_news);
        btnOthers = findViewById(R.id.btn_others);
        btnDisasterInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(HomeActivity.this, R.string.disaster_info, Toast.LENGTH_SHORT).show();
                intent = new Intent(HomeActivity.this,DisasterTypeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnAskForHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, R.string.ask_for_help, Toast.LENGTH_SHORT).show();
            }
        });
        btnImportantPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, R.string.important_phn_number, Toast.LENGTH_SHORT).show();
            }
        });

        btnHotLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, R.string.hotline, Toast.LENGTH_SHORT).show();
            }
        });
        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, R.string.news, Toast.LENGTH_SHORT).show();
            }
        });

        btnOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, R.string.others, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
