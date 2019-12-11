package net.mergecreation.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import net.mergecreation.myapplication.base.BaseActivity;

public class LogoutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
    }
}
