package net.mergecreation.myapplication.base;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import net.mergecreation.myapplication.R;

public class BaseActivity extends AppCompatActivity {
    private Toolbar toolbar;

    public Toolbar activateToolbar(CharSequence title)
    {
        if(toolbar==null)
        {
            toolbar =(Toolbar)findViewById(R.id.app_bar);
            if(toolbar!=null)
            {
                setSupportActionBar(toolbar);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
               // getSupportActionBar().setDisplayShowHomeEnabled(true);
                getSupportActionBar().setTitle(title);
                getSupportActionBar().setDisplayShowTitleEnabled(true);
                getSupportActionBar().getElevation();
               // getSupportActionBar().
            }
        }
        return toolbar;
    }
   /* @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }*/

}
