package com.example.brainrun;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class sunday1 extends AppCompatActivity {

    private static String data = "hello";
    private static String main = "1";
    private static String data1 = "0";
    private static String data2 = "0";
    private static String data3 = "0";
    private static String data4 = "0";
    private static String data5 = "0";

    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String userID;

    int count1=0 ; String num1 = "0";
    boolean continueThread=true;
    Thread t;int ans =0; private Button b1,b2,sub;
    public RadioButton m1,m2,m3,m4,m5;
    private LinearLayout cardView1,cardView2,cardView3;

    private RadioButton rb1,rb2,rb3,rb4,rb21,rb22,rb23,rb24,rb31,rb32,rb33,rb34;

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Are you sure you want to Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sunday1.super.onBackPressed();
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
        setContentView(R.layout.activity_sunday1);

        data = "0";

        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        getSupportActionBar().hide();

        rb1=findViewById(R.id.radioButton26);rb2=findViewById(R.id.radioButton27);rb3=findViewById(R.id.radioButton28);rb4=findViewById(R.id.radioButton29);
        rb21=findViewById(R.id.radioButton1);rb22=findViewById(R.id.radioButton2);rb23=findViewById(R.id.radioButton3);rb24=findViewById(R.id.radioButton4);
        rb31=findViewById(R.id.radioButton5);rb32=findViewById(R.id.radioButton6);rb33=findViewById(R.id.radioButton7);rb34=findViewById(R.id.radioButton8);


        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb1.setChecked(true);
                if(rb2.isChecked()){
                    rb2.setChecked(false);
                }
                if(rb3.isChecked()){
                    rb3.setChecked(false);
                }
                if(rb4.isChecked()){
                    rb4.setChecked(false);
                }
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb2.setChecked(true);
                if(rb4.isChecked()){
                    rb4.setChecked(false);
                }
                if(rb3.isChecked()){
                    rb3.setChecked(false);
                }
                if(rb1.isChecked()){
                    rb1.setChecked(false);
                }
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb3.setChecked(true);
                if(rb1.isChecked()){
                    rb1.setChecked(false);
                }
                if(rb2.isChecked()){
                    rb2.setChecked(false);
                }
                if(rb4.isChecked()){
                    rb4.setChecked(false);
                }
            }
        });
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb4.setChecked(true);
                if(rb2.isChecked()){
                    rb2.setChecked(false);
                }
                if(rb3.isChecked()){
                    rb3.setChecked(false);
                }
                if(rb1.isChecked()){
                    rb1.setChecked(false);
                }
            }
        });

        rb21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb21.setChecked(true);
                if(rb22.isChecked()){
                    rb22.setChecked(false);
                }
                if(rb23.isChecked()){
                    rb23.setChecked(false);
                }
                if(rb24.isChecked()){
                    rb24.setChecked(false);
                }
            }
        });
        rb22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb22.setChecked(true);
                if(rb21.isChecked()){
                    rb21.setChecked(false);
                }
                if(rb23.isChecked()){
                    rb23.setChecked(false);
                }
                if(rb24.isChecked()){
                    rb24.setChecked(false);
                }
            }
        });
        rb23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb23.setChecked(true);
                if(rb22.isChecked()){
                    rb22.setChecked(false);
                }
                if(rb21.isChecked()){
                    rb21.setChecked(false);
                }
                if(rb24.isChecked()){
                    rb24.setChecked(false);
                }
            }
        });
        rb24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb24.setChecked(true);
                if(rb22.isChecked()){
                    rb22.setChecked(false);
                }
                if(rb23.isChecked()){
                    rb23.setChecked(false);
                }
                if(rb21.isChecked()){
                    rb21.setChecked(false);
                }
            }
        });

        rb31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb31.setChecked(true);
                if(rb32.isChecked()){
                    rb32.setChecked(false);
                }
                if(rb33.isChecked()){
                    rb33.setChecked(false);
                }
                if(rb34.isChecked()){
                    rb34.setChecked(false);
                }
            }
        });
        rb32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb32.setChecked(true);
                if(rb31.isChecked()){
                    rb31.setChecked(false);
                }
                if(rb33.isChecked()){
                    rb33.setChecked(false);
                }
                if(rb34.isChecked()){
                    rb34.setChecked(false);
                }
            }
        });
        rb33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb33.setChecked(true);
                if(rb32.isChecked()){
                    rb32.setChecked(false);
                }
                if(rb31.isChecked()){
                    rb31.setChecked(false);
                }
                if(rb34.isChecked()){
                    rb34.setChecked(false);
                }
            }
        });
        rb34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb34.setChecked(true);
                if(rb32.isChecked()){
                    rb32.setChecked(false);
                }
                if(rb33.isChecked()){
                    rb33.setChecked(false);
                }
                if(rb31.isChecked()){
                    rb31.setChecked(false);
                }
            }
        });

        b1 = findViewById(R.id.button6);
        b2 = findViewById(R.id.button5);
        sub = findViewById(R.id.button2);
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
        if (rb4.isChecked()){ data1 = "1";}
        else { data1 = "0";}
        if (rb24.isChecked()){ data2 = "1";}
        else { data2 = "0";}
        if (rb33.isChecked()){ data3 = "1";}
        else { data3 = "0";}

        float t=60;          // Threshold time
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

        Map<String,Object> user1 = new HashMap<>();
        user1.put("Sunday's Game",inf);

        documentReference1.set(user1, SetOptions.merge());


        Intent intent = new Intent(sunday1.this, ascore4.class);
        startActivity(intent);
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
                            sunday1.super.onBackPressed();
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