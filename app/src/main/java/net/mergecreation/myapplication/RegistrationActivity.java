package net.mergecreation.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.mergecreation.myapplication.R;
import net.mergecreation.myapplication.base.BaseActivity;
import net.mergecreation.myapplication.model.UserRegistrationModel;
import net.mergecreation.myapplication.network.ApiIClientInstance;
import net.mergecreation.myapplication.network.IApiService;
import net.mergecreation.myapplication.utils.PreferenceUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends BaseActivity {
    EditText edtName,edtPhone,edtAddress;
    Button btnRegisTration, btnClear;
    IApiService iApiService;
    UserRegistrationModel userRegistrationModel;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        activateToolbar("রেজিস্ট্রেশন");
        iApiService = ApiIClientInstance.getInstance().create(IApiService.class);
        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtMobileNumber);
        edtAddress = findViewById(R.id.edtAddress);
        btnRegisTration = findViewById(R.id.btnRegistration);
        btnClear = findViewById(R.id.btnClear);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtName.setText("");
                edtPhone.setText("");
                edtAddress.setText("");
            }
        });

        btnRegisTration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRegistration(edtName.getText().toString(),edtPhone.getText().toString(),edtAddress.getText().toString());
                intent = new Intent(RegistrationActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
    private void userRegistration(String name, String phoneNumber, String address)
    {
        Call<UserRegistrationModel>call = iApiService.registerUser(name,phoneNumber,address);
        call.enqueue(new Callback<UserRegistrationModel>() {
            @Override
            public void onResponse(Call<UserRegistrationModel> call, Response<UserRegistrationModel> response) {
                if(response.isSuccessful())
                {
                    userRegistrationModel = response.body();

                    PreferenceUtils.savePhoneNumber(userRegistrationModel.getMobileNumber(),RegistrationActivity.this);
                    PreferenceUtils.saveUserAddress(userRegistrationModel.getAddress(),RegistrationActivity.this);
                    PreferenceUtils.saveUserId(userRegistrationModel.getId(),RegistrationActivity.this);
                    PreferenceUtils.saveUserName(userRegistrationModel.getName(),RegistrationActivity.this);

                }
            }

            @Override
            public void onFailure(Call<UserRegistrationModel> call, Throwable t) {
                call.cancel();
                Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
