
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

public class Evaluation extends AppCompatActivity {

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
            t1.setVisibility(View.VISIBLE);
        }
        else if(expandableView1.getVisibility() == View.VISIBLE){
            expandableView1.setVisibility(View.GONE);
            c1.setVisibility(View.VISIBLE);
            c3.setVisibility(View.VISIBLE);
            c4.setVisibility(View.VISIBLE);
            t2.setVisibility(View.VISIBLE);
        }
        else if(expandableView2.getVisibility() == View.VISIBLE){
            expandableView2.setVisibility(View.GONE);
            c2.setVisibility(View.VISIBLE);
            c1.setVisibility(View.VISIBLE);
            c4.setVisibility(View.VISIBLE);
            t3.setVisibility(View.VISIBLE);
        }
        else if(expandableView3.getVisibility() == View.VISIBLE){
            expandableView3.setVisibility(View.GONE);
            c2.setVisibility(View.VISIBLE);
            c3.setVisibility(View.VISIBLE);
            c1.setVisibility(View.VISIBLE);
            t4.setVisibility(View.VISIBLE);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation);

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

        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);

        SharedPreferences getShared13 = getSharedPreferences("Evaluation",MODE_PRIVATE);
        String Eval1 = getShared13.getString("school","0");
        int E1=parseInt(Eval1);


        SharedPreferences getShared14 = getSharedPreferences("Evaluation",MODE_PRIVATE);
        String Eval2 = getShared14.getString("car","0");
        int E2=parseInt(Eval2);


        SharedPreferences getShared15 = getSharedPreferences("Evaluation",MODE_PRIVATE);
        String Eval3 = getShared15.getString("trip","0");
        int E3=parseInt(Eval3);


        SharedPreferences getShared16 = getSharedPreferences("Evaluation",MODE_PRIVATE);
        String Eval4 = getShared16.getString("sport","0");
        int E4=parseInt(Eval4);

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF5A5A")));
        bar.setTitle("Perfect Estimation");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Count1==0&&E1==0)
                {
                    Intent intent = new Intent(Evaluation.this, school.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    overridePendingTransition (0, 0);
                    putValueInSharedPrefs(++Count1);
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(Evaluation.this);

                    builder.setMessage("Do you want to play again?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(Evaluation.this, school.class);
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
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Count2==0&&E2==0)
                {
                    Intent intent = new Intent(Evaluation.this, car.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    overridePendingTransition (0, 0);
                    putValueInSharedPrefs(++Count2);
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(Evaluation.this);

                    builder.setMessage("Do you want to play again?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(Evaluation.this, car.class);
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
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Count3==0&&E3==0)
                {
                    Intent intent = new Intent(Evaluation.this, trip.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    overridePendingTransition (0, 0);
                    putValueInSharedPrefs(++Count3);
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(Evaluation.this);

                    builder.setMessage("Do you want to play again?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(Evaluation.this, trip.class);
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
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Count4==0&&E4==0)
                {
                    Intent intent = new Intent(Evaluation.this, sports.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    overridePendingTransition (0, 0);
                    putValueInSharedPrefs(++Count4);
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(Evaluation.this);

                    builder.setMessage("Do you want to play again?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(Evaluation.this, sports.class);
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
        if (Count1>0 || E1>0){
            b1.setText("START ACTIVITY AGAIN");
            t1.setText("Start Game Again");
        }

        if (Count2>0 || E2>0){
            b2.setText("START ACTIVITY AGAIN");
            t2.setText("Start Game Again");
        }

        if (Count3>0 || E3>0){
            b3.setText("START ACTIVITY AGAIN");
            t3.setText("Start Game Again");
        }
        if (Count4>0 || E4>0){
            b4.setText("START ACTIVITY AGAIN");
            t4.setText("Start Game Again");
        }
    }

    public void show1(View view) {
        t1.setVisibility(View.INVISIBLE);
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
        t2.setVisibility(View.INVISIBLE);
        if(expandableView1.getVisibility() == View.GONE){
            //TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
            expandableView1.setVisibility(View.VISIBLE);

            c1.setVisibility(View.GONE);
            c3.setVisibility(View.GONE);
            c4.setVisibility(View.GONE);
        }
//        else {
//            expandableView1.setVisibility(View.GONE);
//
//            c1.setVisibility(View.VISIBLE);
//            c3.setVisibility(View.VISIBLE);
//            c4.setVisibility(View.VISIBLE);
//        }
    }
    public void show2(View view) {
        t3.setVisibility(View.INVISIBLE);
        if(expandableView2.getVisibility() == View.GONE){
            //TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
            expandableView2.setVisibility(View.VISIBLE);

            c2.setVisibility(View.GONE);
            c1.setVisibility(View.GONE);
            c4.setVisibility(View.GONE);
        }
//        else {
//            expandableView2.setVisibility(View.GONE);
//
//            c2.setVisibility(View.VISIBLE);
//            c1.setVisibility(View.VISIBLE);
//            c4.setVisibility(View.VISIBLE);
//        }
    }
    public void show3(View view) {
        t4.setVisibility(View.INVISIBLE);
        if(expandableView3.getVisibility() == View.GONE){
            //TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
            expandableView3.setVisibility(View.VISIBLE);

            c2.setVisibility(View.GONE);
            c3.setVisibility(View.GONE);
            c1.setVisibility(View.GONE);
        }
//        else {
//            expandableView3.setVisibility(View.GONE);
//
//            c2.setVisibility(View.VISIBLE);
//            c3.setVisibility(View.VISIBLE);
//            c1.setVisibility(View.VISIBLE);
//        }
    }

    /*public void move (View view){
        Intent intent = new Intent(Evaluation.this, car.class);
        startActivity(intent);
    }
    public void move1 (View view){
        Intent intent = new Intent(Evaluation.this, school.class);
        startActivity(intent);
    }
    public void move2 (View view){
        Intent intent = new Intent(Evaluation.this, trip.class);
        startActivity(intent);
    }
    public void move3 (View view){
        Intent intent = new Intent(Evaluation.this, sports.class);
        startActivity(intent);
    }*/
    public void putValueInSharedPrefs(int count)
    {
        editor = sharedPreferences.edit();
        editor.putInt("DISMISS_BUTTON_CLICK_COUNT", count);
        editor.apply();
    }
}