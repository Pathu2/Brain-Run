package com.example.brainrun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class detective extends AppCompatActivity {

    private static String data = "hello";
    private static String main = "1";
    private static String data1 = "0";
    private static String data2 = "0";
    private static String data3 = "0";
    private static String data4 = "0";
    private static String data5 = "0";

    private String type;

    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String userID;

    int count1=0 ; String num1 = "0";
    boolean continueThread=true;
    Thread t;int ans =0; private Button b1,b2,sub;
    public RadioButton m1,m2,m3,m4,m5;
    private LinearLayout cardView1,cardView2,cardView3;

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Are you sure you want to Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        setResult(Activity.RESULT_CANCELED);
//                        detective.super.onBackPressed();
                        finish();
                    }
                })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detective);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("SHARED_PREFS", MODE_PRIVATE);
        type = getIntent().getStringExtra("type");

        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        data = "0";

        Toast.makeText(this, "Zoom in the images!", Toast.LENGTH_SHORT).show();


        PhotoView photoView1 = (PhotoView) findViewById(R.id.photo_view1);
        photoView1.setImageResource(R.drawable.dt1);

        PhotoView photoView2 = (PhotoView) findViewById(R.id.photo_view2);
        photoView2.setImageResource(R.drawable.dt2);

        PhotoView photoView3 = (PhotoView) findViewById(R.id.photo_view3);
        photoView3.setImageResource(R.drawable.dt3);

        getSupportActionBar().hide();

        m1 = findViewById(R.id.radioButton1);
        m2 = findViewById(R.id.radioButton2);
        sub = findViewById(R.id.button2);
        m3 = findViewById(R.id.radioButton03);
        b1 = findViewById(R.id.button6);
        b2 = findViewById(R.id.button5);

        cardView1= findViewById(R.id.cardView);
        cardView2= findViewById(R.id.cardView1);
        cardView3= findViewById(R.id.cardView2);

        final TextView textView=(TextView)findViewById(R.id.timer);
        t=new Thread(){

            @Override
            public void run(){

                while(continueThread){

                    try {
                        Thread.sleep(1000);  //1000ms = 1 sec

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                ans++;
                                count1++;
                                //if(ans>=9){ count1++; textView.setVisibility(View.VISIBLE); btn.setVisibility(View.VISIBLE); }

                                textView.setText(String.valueOf(count1));
                                data = String.valueOf(count1);
                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        t.start();
    }

    public static String getData(){ return data; }
    public static String getData11(){ return main; }
    public static String getData1(){ return data1; }
    public static String getData2(){ return data2; }
    public static String getData3(){ return data3; }
    public static String getData4(){ return data4; }
    public static String getData5(){ return data5; }

    public void sub (View view){
        continueThread=false;
        if (m1.isChecked()){ data1 = "1";}
        else { data1 = "0";}
        if (m2.isChecked()){ data2 = "1";}
        else { data2 = "0";}
        if (m3.isChecked()){ data3 = "1";}
        else { data3 = "0";}

        float t=80;          // Threshold time
        int a1,a2,a3;                                           // answers
        int r;                                         // time taken to solve the quest.
        int m1 = 30, m2 =30, m3 = 40;                           // Marks
        int inf;

        a1 = Integer.parseInt(data1);
        a2 = Integer.parseInt(data2);
        a3 = Integer.parseInt(data3);
        r = count1;

        if(r <= t) {r = (int)t;}

        inf = (int)((a1*m1 + a2*m2 + a3*m3)*(t/r));

        userID = fAuth.getCurrentUser().getUid();
        DocumentReference documentReference1 = fstore.collection("users").document(userID).collection("Blake's Adventure").document(userID);
        documentReference1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot documentSnapshot = task.getResult();
                    if(documentSnapshot.exists()){
                        Map<String, Object> userData = documentSnapshot.getData();
                        assert userData != null;
                        int maxAdamDays = Integer.parseInt(userData.getOrDefault("Max Detective Blake", "0").toString());
                        int minAdamDays = Integer.parseInt(userData.getOrDefault("Min Detective Blake", "0").toString());
                        int numberOfAttempts = Integer.parseInt(userData.getOrDefault("Number Of Attempts Detective Blake", "0").toString()) + 1;
                        int total = Integer.parseInt(userData.getOrDefault("Detective Blake Total", "0").toString()) + inf;
                        if(inf>maxAdamDays){
                            maxAdamDays = inf;
                        }
                        if(minAdamDays==-1 || minAdamDays>inf){
                            minAdamDays = inf;
                        }
//                        float avg = ((float) total /numberOfAttempts);
//                        @SuppressLint("DefaultLocale") String formattedAvg = String.format("%.2f", avg);
                        Map<String,Object> user1 = new HashMap<>();
                        user1.put("Detective Blake",String.valueOf(inf));
                        user1.put("Min Detective Blake", String.valueOf(minAdamDays));
                        user1.put("Max Detective Blake", String.valueOf(maxAdamDays));
                        user1.put("Number Of Attempts Detective Blake", String.valueOf(numberOfAttempts));
                        user1.put("Detective Blake Total", total);
                        documentReference1.set(user1, SetOptions.merge());
                    } else{
                        Toast.makeText(getApplicationContext(), "Unable to update the scores", Toast.LENGTH_LONG).show();
                    }
                } else{
                    Toast.makeText(getApplicationContext(), "Unable to update the scores", Toast.LENGTH_LONG).show();
                }
            }
        });
        

        SharedPreferences shrd = getSharedPreferences("analysis",MODE_PRIVATE);
        SharedPreferences.Editor shared = shrd.edit();

        shared.putString("time", getData());
        shared.putString("status1", getData1());
        shared.putString("status2", getData2());
        shared.putString("status3", getData3());
        shared.putString("type", type);
        shared.putBoolean("success", true);
        shared.apply();

        Log.i("WHY_NO_WORK", "Sent Data");

        setResult(Activity.RESULT_OK);
        finish();
//        Intent intent = new Intent(detective.this, ascore2.class);
//        startActivity(intent);
    }

    public void move1 (View view){ //move front
        if(cardView1.getVisibility() == View.VISIBLE){
            //b1.setVisibility(View.VISIBLE);
            b1.setText("Previous");
            cardView1.setVisibility(View.GONE);
            cardView2.setVisibility(View.VISIBLE);
        }
        else if(cardView2.getVisibility() == View.VISIBLE){
            if(sub.getVisibility()== View.INVISIBLE){
                sub.setVisibility(View.VISIBLE);
            }
            b2.setVisibility(View.INVISIBLE);
            cardView2.setVisibility(View.GONE);
            cardView3.setVisibility(View.VISIBLE);
        }
//        else if(cardView3.getVisibility() == View.VISIBLE){
//            cardView3.setVisibility(View.GONE);
//            cardView4.setVisibility(View.VISIBLE);
//        }
//        else if(cardView4.getVisibility() == View.VISIBLE){
//            cardView4.setVisibility(View.GONE);
//            cardView5.setVisibility(View.VISIBLE);
//        }
        else {
            int k1=0;
        }
    }

    public void move (View view){

        if(cardView1.getVisibility()==View.VISIBLE){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage("Are you sure you want to Exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            setResult(Activity.RESULT_CANCELED);
                            finish();
//                            detective.super.onBackPressed();
                        }
                    })

                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        if(cardView2.getVisibility() == View.VISIBLE){
            //b1.setVisibility(View.INVISIBLE);
            b1.setText("Back");
            cardView2.setVisibility(View.GONE);
            cardView1.setVisibility(View.VISIBLE);
        }
        else if(cardView3.getVisibility() == View.VISIBLE){
            b2.setVisibility(View.VISIBLE);
            cardView3.setVisibility(View.GONE);
            cardView2.setVisibility(View.VISIBLE);
            sub.setVisibility(View.INVISIBLE);
        }
//        else if(cardView4.getVisibility() == View.VISIBLE){
//            cardView4.setVisibility(View.GONE);
//            cardView3.setVisibility(View.VISIBLE);
//        }
//        else if(cardView5.getVisibility() == View.VISIBLE){
//            cardView5.setVisibility(View.GONE);
//            cardView4.setVisibility(View.VISIBLE);
//        }
        else {
            int k1=0;
        }
    }
}