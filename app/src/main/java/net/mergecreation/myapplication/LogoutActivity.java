package net.mergecreation.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.mergecreation.myapplication.base.BaseActivity;
import net.mergecreation.myapplication.utils.Constants;
import net.mergecreation.myapplication.utils.PreferenceUtils;

import de.hdodenhof.circleimageview.CircleImageView;

public class LogoutActivity extends BaseActivity {
    CircleImageView imageView;
    TextView nameTextView, addressTextView, phoneTextView;
    Button btnLogout, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        activateToolbar("লগ আউট");
        imageView = findViewById(R.id.ivUserImage);
        nameTextView = findViewById(R.id.tvUserName);
        addressTextView = findViewById(R.id.tvUserAddress);
        btnLogout = findViewById(R.id.btnLogout);
        btnCancel = findViewById(R.id.btnCancel);
        phoneTextView = findViewById(R.id.tvPhoneNumber);

        nameTextView.setText(PreferenceUtils.getUserName(this));
        addressTextView.setText(PreferenceUtils.getUserAddress(this));
        phoneTextView.setText(PreferenceUtils.getPhoneNumber(this));
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceUtils.saveUserId(null, LogoutActivity.this);
                PreferenceUtils.saveUserName(null, LogoutActivity.this);
                PreferenceUtils.saveUserAddress(null, LogoutActivity.this);
                PreferenceUtils.savePhoneNumber(null, LogoutActivity.this);
                Intent intent = new Intent(LogoutActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogoutActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
