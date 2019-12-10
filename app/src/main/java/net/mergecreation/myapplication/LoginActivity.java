package net.mergecreation.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import net.mergecreation.myapplication.base.BaseActivity;
import net.mergecreation.myapplication.home_activity.RegistrationActivity;
import net.mergecreation.myapplication.model.UserModel;
import net.mergecreation.myapplication.network.ApiIClientInstance;
import net.mergecreation.myapplication.network.IApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {
    Button loginButton;
    EditText edtPhoneNumber;
    Intent intent = null;
    IApiService iApiService;
    UserModel userModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        activateToolbar("দুর্যোগ সেবা");
        iApiService = ApiIClientInstance.getInstance().create(IApiService.class);
        loginButton = findViewById(R.id.btn_login);
        edtPhoneNumber = findViewById(R.id.edt_mbl_number);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*intent=new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();*/
                getUserData(edtPhoneNumber.getText().toString());
            }
        });
    }

    private void getUserData(final String phoneNumber) {
        Call<List<UserModel>> call = iApiService.getUser(phoneNumber);
        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                if (response.isSuccessful()) {
                    if(response.body().)
                }
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                call.cancel();
            }
        });
    }
}
