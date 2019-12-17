package net.mergecreation.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.mergecreation.myapplication.base.BaseActivity;

import net.mergecreation.myapplication.home_activity.AskForHelpActivity;
import net.mergecreation.myapplication.home_activity.DisasterTypeActivity;
import net.mergecreation.myapplication.home_activity.HelpLineTypeActivity;
import net.mergecreation.myapplication.home_activity.HotlineActivity;
import net.mergecreation.myapplication.home_activity.NewsActivity;
import net.mergecreation.myapplication.home_activity.OthersActivity;
import net.mergecreation.myapplication.utils.IntentStrings;
import net.mergecreation.myapplication.utils.PreferenceUtils;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends BaseActivity {
    private Button btnDisasterInfo, btnAskForHelp, btnImportantPhoneNumber, btnHotLine, btnNews, btnOthers;
    private Intent intent;
    CircleImageView imageView;
    TextView textView;
    //public static final String MyPREFERENCES = "myprefs";

   // SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        activateToolbar("দূর্যোগ সেবা");
        //sharedPreferences = getSharedPreferences(IntentStrings.MyPREFERENCES, Context.MODE_PRIVATE);

        btnDisasterInfo = findViewById(R.id.btn_disaster_info);
        btnAskForHelp = findViewById(R.id.btn_disaster_ask_help);
        btnImportantPhoneNumber = findViewById(R.id.btn_important_phn);
        btnHotLine = findViewById(R.id.btn_hotline);
        btnNews = findViewById(R.id.btn_news);
        imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(HomeActivity.this, LogoutActivity.class);
                startActivity(intent);
                finish();
            }
        });
        textView = findViewById(R.id.nameText);
        textView.setText(PreferenceUtils.getUserName(this));
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

        if(PreferenceUtils.getUserId(this)==null || PreferenceUtils.getUserId(this).equals(""))
        {
            intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }else
        {
            return;
        }
    }
}
