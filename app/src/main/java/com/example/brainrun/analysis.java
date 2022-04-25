package com.example.brainrun;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class analysis extends AppCompatActivity {

    ConstraintLayout expandableView,expandableView1,expandableView2,expandableView3;
    CardView c1,c2,c3,c4;
    TextView t1,t2,t3,t4;
    Button b4,b3,b2,b1;
    SharedPreferences sharedPreferences;  //Declare Globall
    SharedPreferences.Editor editor;      //Declare Globally
    private static int Count1 = 0,Count2=0,Count3=0,Count4=0;

    @Override
    public void onBackPressed() {
        if(expandableView.getVisibility() == View.VISIBLE){
            expandableView.setVisibility(View.GONE);
            c2.setVisibility(View.VISIBLE);
            c3.setVisibility(View.VISIBLE);
            c4.setVisibility(View.VISIBLE);
            t2.setVisibility(View.VISIBLE);
        }
        else if(expandableView1.getVisibility() == View.VISIBLE){
            expandableView1.setVisibility(View.GONE);
            c1.setVisibility(View.VISIBLE);
            c3.setVisibility(View.VISIBLE);
            c4.setVisibility(View.VISIBLE);
            t3.setVisibility(View.VISIBLE);
        }
        else if(expandableView2.getVisibility() == View.VISIBLE){
            expandableView2.setVisibility(View.GONE);
            c2.setVisibility(View.VISIBLE);
            c1.setVisibility(View.VISIBLE);
            c4.setVisibility(View.VISIBLE);
            t4.setVisibility(View.VISIBLE);
        }
        else if(expandableView3.getVisibility() == View.VISIBLE){
            expandableView3.setVisibility(View.GONE);
            c2.setVisibility(View.VISIBLE);
            c3.setVisibility(View.VISIBLE);
            c1.setVisibility(View.VISIBLE);
            t1.setVisibility(View.VISIBLE);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
        sharedPreferences = getApplicationContext().getSharedPreferences("SHARED_PREFS", MODE_PRIVATE);

        //getSupportActionBar().hide();

        expandableView = findViewById(R.id.expand_view1);
        expandableView1 = findViewById(R.id.expand_view);
        expandableView2 = findViewById(R.id.expand_view3);
        expandableView3 = findViewById(R.id.expand_view4);

        c1= findViewById(R.id.cardView1);
        c2= findViewById(R.id.cardView);
        c3= findViewById(R.id.cardView2);
        c4= findViewById(R.id.cardView4);

        t1=findViewById(R.id.card_view_one);
        t2=findViewById(R.id.card_view_two);
        t3=findViewById(R.id.card_view_three);
        t4=findViewById(R.id.card_view_four);

        b4=findViewById(R.id.button4);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button);
        b3=findViewById(R.id.button3);


        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF5A5A")));
        bar.setTitle("Blake's Adventure");

        SharedPreferences getShared7 = getSharedPreferences("analysis",MODE_PRIVATE);
        String analysis3 = getShared7.getString("graphical","0");
        int A3=parseInt(analysis3);

        SharedPreferences getShared5 = getSharedPreferences("analysis",MODE_PRIVATE);
        String analysis1 = getShared5.getString("gifts","0");
        int A1=parseInt(analysis1);

        SharedPreferences getShared8 = getSharedPreferences("analysis",MODE_PRIVATE);
        String analysis4 = getShared8.getString("sunday1","0");
        int A4=parseInt(analysis4);

        SharedPreferences getShared6 = getSharedPreferences("analysis",MODE_PRIVATE);
        String analysis2 = getShared6.getString("detective","0");
        int A2=parseInt(analysis2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(Count4==0&&A1==0)
                    {
                        Intent intent = new Intent(analysis.this, gifts.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        overridePendingTransition (0, 0);
                        putValueInSharedPrefs(++Count4);
                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(analysis.this);

                        builder.setMessage("Do you want to play again?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent(analysis.this, gifts.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        overridePendingTransition (0, 0);
                                        putValueInSharedPrefs(++Count4);
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
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Count3==0&&A3==0)
                {
                    Intent intent = new Intent(analysis.this, graphical.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    overridePendingTransition (0, 0);
                    putValueInSharedPrefs(++Count3);
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(analysis.this);

                    builder.setMessage("Do you want to play again?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(analysis.this, graphical.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                    overridePendingTransition (0, 0);
                                    putValueInSharedPrefs(++Count3);
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
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Count2==0&&A2==0)
                {
                    Intent intent = new Intent(analysis.this, detective.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    overridePendingTransition (0, 0);
                    putValueInSharedPrefs(++Count2);
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(analysis.this);

                    builder.setMessage("Do you want to play again?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(analysis.this, detective.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                    overridePendingTransition (0, 0);
                                    putValueInSharedPrefs(++Count2);
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



            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Count1==0&&A4==0)
                {
                    Intent intent = new Intent(analysis.this, sunday1.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    overridePendingTransition (0, 0);
                    putValueInSharedPrefs(++Count1);
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(analysis.this);

                    builder.setMessage("Do you want to play again?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(analysis.this, sunday1.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                    overridePendingTransition (0, 0);
                                    putValueInSharedPrefs(++Count1);
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


            }

        });

        if (Count1>0 || A4>0){
            b4.setText("START ACTIVITY AGAIN");
            t1.setText("Start Game Again");
        }

        if (Count2>0 || A2>0){
            b2.setText("START ACTIVITY AGAIN");
            t3.setText("Start Game Again");
        }

        if (Count3>0 || A3>0){
            b3.setText("START ACTIVITY AGAIN");
            t4.setText("Start Game Again");
        }
        if (Count4>0 || A1>0){
            b1.setText("START ACTIVITY AGAIN");
            t2.setText("Start Game Again");
        }
    }


    public void show1(View view) {
        t2.setVisibility(View.INVISIBLE);
        if(expandableView.getVisibility() == View.GONE){
            //TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
            expandableView.setVisibility(View.VISIBLE);

            c2.setVisibility(View.GONE);
            c3.setVisibility(View.GONE);
            c4.setVisibility(View.GONE);
        }
//        else {
//            expandableView.setVisibility(View.GONE);
//
//            c2.setVisibility(View.VISIBLE);
//            c3.setVisibility(View.VISIBLE);
//            c4.setVisibility(View.VISIBLE);
//        }
    }
    public void show(View view) {
        t3.setVisibility(View.INVISIBLE);
        if(expandableView1.getVisibility() == View.GONE){
            //TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
            expandableView1.setVisibility(View.VISIBLE);

            c3.setVisibility(View.GONE);
            c1.setVisibility(View.GONE);
            c4.setVisibility(View.GONE);
        }
        /*else {
           expandableView1.setVisibility(View.GONE);

            c3.setVisibility(View.VISIBLE);
            c1.setVisibility(View.VISIBLE);
           c4.setVisibility(View.VISIBLE);
        }*/
    }
    public void show2(View view) {
        t4.setVisibility(View.INVISIBLE);
        if(expandableView2.getVisibility() == View.GONE){
            //TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
            expandableView2.setVisibility(View.VISIBLE);

            c2.setVisibility(View.GONE);
            c1.setVisibility(View.GONE);
            c4.setVisibility(View.GONE);
        }
        /*else {
            expandableView2.setVisibility(View.GONE);

            c2.setVisibility(View.VISIBLE);
            c1.setVisibility(View.VISIBLE);
            c4.setVisibility(View.VISIBLE);
        }*/
    }
    public void show3(View view) {
        t1.setVisibility(View.INVISIBLE);
        if(expandableView3.getVisibility() == View.GONE){
            //TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
            expandableView3.setVisibility(View.VISIBLE);

            c2.setVisibility(View.GONE);
            c3.setVisibility(View.GONE);
            c1.setVisibility(View.GONE);
        }
        /*else {
            expandableView3.setVisibility(View.GONE);

            c2.setVisibility(View.VISIBLE);
            c3.setVisibility(View.VISIBLE);
            c1.setVisibility(View.VISIBLE);
        }*/
    }

    /*public void move1 (View view){
        b1.setText("START ACTIVITY AGAIN");
        t2.setText("Start Game Again");
        Intent intent = new Intent(analysis.this, gifts.class);
        startActivity(intent);
    }

    public void move2 (View view){
        b3.setText("START ACTIVITY AGAIN");
        t4.setText("Start Game Again");
        Intent intent = new Intent(analysis.this, graphical.class);
        startActivity(intent);
    }*/

    public void putValueInSharedPrefs(int count)
    {
        editor = sharedPreferences.edit();
        editor.putInt("DISMISS_BUTTON_CLICK_COUNT", count);
        editor.apply();
    }
}