package net.mergecreation.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.mergecreation.myapplication.base.BaseActivity;

import net.mergecreation.myapplication.home_activity.AskForHelpActivity;
import net.mergecreation.myapplication.home_activity.DisasterTypeActivity;
import net.mergecreation.myapplication.home_activity.HelpLineTypeActivity;
import net.mergecreation.myapplication.home_activity.HotlineActivity;
import net.mergecreation.myapplication.home_activity.NewsActivity;
import net.mergecreation.myapplication.home_activity.OthersActivity;

public class HomeActivity extends BaseActivity {
    private Button btnDisasterInfo, btnAskForHelp, btnImportantPhoneNumber, btnHotLine, btnNews, btnOthers;
    private Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        activateToolbar("দূর্যোগ সেবা");
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
                intent = new Intent(HomeActivity.this, DisasterTypeActivity.class);
                startActivity(intent);
                //finish();
            }
        });
        btnAskForHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(HomeActivity.this, AskForHelpActivity.class);
                startActivity(intent);
            }
        });
        btnImportantPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(HomeActivity.this, HelpLineTypeActivity.class);
                startActivity(intent);
            }
        });

        btnHotLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(HomeActivity.this, HotlineActivity.class);
                startActivity(intent);
            }
        });
        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(HomeActivity.this, NewsActivity.class);
                startActivity(intent);
            }
        });

        btnOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(HomeActivity.this, OthersActivity.class);
                startActivity(intent);
            }
        });
    }
}
