package com.example.brainrun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class splash extends AppCompatActivity {

    //private static int Spash = 24500;
    Button button;
    ImageView rocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent inte = new Intent(splash.this,Login.class);
                startActivity(inte);
                finish();
            }
        }, Spash);*/
        button=findViewById(R.id.test);
        rocket=findViewById(R.id.rocket);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.BounceIn).duration(700).repeat(0).playOn(rocket);
                Intent i=new Intent(splash.this,Login.class);
                startActivity(i);
                finish();
            }
        });

    }
}