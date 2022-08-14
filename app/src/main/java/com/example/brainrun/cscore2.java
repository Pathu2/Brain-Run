package com.example.brainrun;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class cscore2 extends AppCompatActivity {

    String data1; // = car.getData();
//    String data = car.getData11();
    String data11; // = car.getData1();
    String data22; // = car.getData2();
    String data33; // = car.getData3();
//    String data44 = car.getData4();
//    String data55 = car.getData5();

    private ProgressBar progressBar;

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
//        Intent i=new Intent(cscore2.this,Evaluation.class);
        finish();
//        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cscore2);
        data1 = getIntent().getStringExtra("time");
        data11 = getIntent().getStringExtra("status1");
        data22 = getIntent().getStringExtra("status2");
        data33 = getIntent().getStringExtra("status3");

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF5A5A")));
        bar.setTitle("Peter's Dilemma");
        TextView textview0 = findViewById(R.id.textView19);
        int sec = Integer.parseInt(data1);
        int min = 0;
        if(sec > 59) {
            min = sec / 60;
            sec = sec % 60;
            textview0.setText( min +" min "+sec+ " sec");
        }
        else{
            textview0.setText( data1 + " sec");
        }
        TextView textview1 = findViewById(R.id.textView18);
        if (Integer.parseInt(data11) == 0) {
            textview1.setText("Wrong");
            textview1.setTextColor(getResources().getColor(R.color.red));
        }
        else {
            textview1.setText("Right");
            textview1.setTextColor(getResources().getColor(R.color.green));
        }
        TextView textview2 = findViewById(R.id.textView9);
        if (Integer.parseInt(data22) == 0) {
            textview2.setText("Wrong");
            textview2.setTextColor(getResources().getColor(R.color.red));
        }
        else {
            textview2.setText("Right");
            textview2.setTextColor(getResources().getColor(R.color.green));
        }
        TextView textview3 = findViewById(R.id.textView12);
        if (Integer.parseInt(data33) == 0) {
            textview3.setText("Wrong");
            textview3.setTextColor(getResources().getColor(R.color.red));
        }
        else {
            textview3.setText("Right");
            textview3.setTextColor(getResources().getColor(R.color.green));
        }

        float t=90;          // Threshold time
        int a1,a2,a3;                                           // answers
        int r;                                         // time taken to solve the quest.
        int m1 = 30, m2 =30, m3 = 40;                           // Marks
        int inf;

        a1 = Integer.parseInt(data11);
        r = Integer.parseInt(data1);
        a2 = Integer.parseInt(data22);
        //r2 = Integer.parseInt(data2);
        a3 = Integer.parseInt(data33);
        //r3 = Integer.parseInt(data3);

        if(r <= t) {r = (int)t;}
        //if(r2 <= t2) {r2 = (int)t2;}
        //if(r3 <= t3) {r3 = (int)t3;}

        inf = (int)((a1*m1 + a2*m2 + a3*m3)*(t/r));

        String ans = String.valueOf(inf);
        SharedPreferences shrd = getSharedPreferences("Evaluation",MODE_PRIVATE);
        SharedPreferences.Editor editor =  shrd.edit();
        editor.putString("car",ans);
        editor.apply();

//        TextView textView7 = findViewById(R.id.textView16);
//        textView7.setText(ans + " %");

//        progressBar = (ProgressBar)findViewById(R.id.progressBar7);
//        progressBar.setProgress(inf);
        //TextView textviews = findViewById(R.id.textView15);
        //textviews.setText(inf+"/100");
    }
}