package net.mergecreation.myapplication.home_activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import net.mergecreation.myapplication.R;
import net.mergecreation.myapplication.base.BaseActivity;

public class HotlineActivity extends BaseActivity {
    private TextView hotLineTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotline);
        hotLineTextView =findViewById(R.id.hotline_number);
        hotLineTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:999"));
               if(ActivityCompat.checkSelfPermission(HotlineActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    return;
                }
                startActivity(callIntent);
            }
        });
    }

}
