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

public class graphical extends AppCompatActivity {

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
    Thread t;int ans =0; private Button b01,b02,sub;
    public RadioButton m1,m2,m3,m4,m5;
    private LinearLayout cardView1,cardView2,cardView3;

    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24;
    int d1=0,d2=0,d3=0,d4=0,d5=0,d6=0,d7=0,d8=0,d9=0,d10=0,d11=0,d12=0,d13=0,d14=0,d15=0,d16=0,d17=0,d18=0,d19=0,d20=0,d21=0,d22=0,d23=0,d24=0;
    int p=0,s=0,k=0,p1=0,s1=0,k1=0,s2=0,p2=0,k2=0;

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Are you sure you want to Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        graphical.super.onBackPressed();
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
        setContentView(R.layout.activity_graphical);

        data = "0";

        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        getSupportActionBar().hide();

        b1 = findViewById(R.id.button1);b2 = findViewById(R.id.button2);b3 = findViewById(R.id.button3);b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);b6 = findViewById(R.id.button6);b7 = findViewById(R.id.button7);b8 = findViewById(R.id.button8);

        b9 = findViewById(R.id.button9);b10 = findViewById(R.id.button10);b11 = findViewById(R.id.button11);b12 = findViewById(R.id.button12);
        b13 = findViewById(R.id.button13);b14 = findViewById(R.id.button14);b15 = findViewById(R.id.button15);b16 = findViewById(R.id.button16);

        b17 = findViewById(R.id.button17);b18 = findViewById(R.id.button18);b19 = findViewById(R.id.button19);b20 = findViewById(R.id.button20);
        b21 = findViewById(R.id.button21);b22 = findViewById(R.id.button22);b23 = findViewById(R.id.button23);b24 = findViewById(R.id.button24);

        cardView1= findViewById(R.id.cardView);
        cardView2= findViewById(R.id.cardView1);
        cardView3= findViewById(R.id.cardView2);
        b01 = findViewById(R.id.button01);
        b02 = findViewById(R.id.button);
        sub = findViewById(R.id.subButton);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d1++;s++;
                if(d1==1 && s==1) b1.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d1==2) {b1.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d1=0;s=0;}
                    else if(d2==1) {b2.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d2=0;d1=0;s=0;}
                    else if(d3==1) {b3.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d3=0;d1=0;s=0;}
                    else if(d4==1) {b4.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d4=0;d1=0;s=0;}
                    else if(d5==1) {
                        k++;
                        //if(k==4) { img.setVisibility(View.INVISIBLE); text1.setVisibility(View.VISIBLE); }
                        b1.setVisibility(View.INVISIBLE);
                        b5.setVisibility(View.INVISIBLE);d5=0;d1=0;s=0;
                        //b5.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d5=0;d1=0;s=0;
                    }
                    else if(d6==1) {b6.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d6=0;d1=0;s=0;}
                    else if(d7==1) {b7.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d7=0;d1=0;s=0;}
                    else if(d8==1) {b8.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d8=0;d1=0;s=0;}
                }



            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d2++;s++;
                if(d2==1 && s==1) b2.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d1==1) {b1.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d1=0;d2=0;s=0;}
                    else if(d2==2) {b2.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d2=0;s=0;}
                    else if(d3==1) {b3.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d3=0;d2=0;s=0;}
                    else if(d4==1) {b4.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d4=0;d2=0;s=0;}
                    else if(d5==1) {b5.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d5=0;d2=0;s=0;}
                    else if(d6==1) {
                        k++;
                        //if(k==4) { img.setVisibility(View.INVISIBLE); text1.setVisibility(View.VISIBLE); }
                        b2.setVisibility(View.INVISIBLE);
                        b6.setVisibility(View.INVISIBLE);d6=0;d2=0;s=0;
                        //b6.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d6=0;d2=0;s=0;
                    }
                    else if(d7==1) {b7.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d7=0;d2=0;s=0;}
                    else if(d8==1) {b8.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d8=0;d2=0;s=0;}
                }


            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d3++;s++;
                if(d3==1 && s==1) b3.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d1==1) {b1.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d1=0;d3=0;s=0;}
                    else if(d2==1) {b2.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d2=0;d3=0;s=0;}
                    else if(d3==2) {b3.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d3=0;s=0;}
                    else if(d4==1) {b4.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d4=0;d3=0;s=0;}
                    else if(d5==1) {b5.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d5=0;d3=0;s=0;}
                    else if(d6==1) {b6.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d6=0;d3=0;s=0;}
                    else if(d7==1) {
                        k++;
                        //if(k==4) { img.setVisibility(View.INVISIBLE); text1.setVisibility(View.VISIBLE); }
                        //b7.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d7=0;d2=0;s=0;
                        b3.setVisibility(View.INVISIBLE);d7=0;d3=0;s=0;
                        b7.setVisibility(View.INVISIBLE);
                    }
                    else if(d8==1) {b8.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d8=0;d2=0;s=0;}
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d4++;s++;
                if(d4==1 && s==1) b4.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d1==1) {b1.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d1=0;d4=0;s=0;}
                    else if(d2==1) {b2.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d2=0;d4=0;s=0;}
                    else if(d3==1) {b3.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d3=0;d4=0;s=0;}
                    else if(d4==2) {b4.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d4=0;s=0;}
                    else if(d5==1) {b5.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d5=0;d4=0;s=0;}
                    else if(d6==1) {b6.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d6=0;d4=0;s=0;}
                    else if(d7==1) {b7.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d7=0;d4=0;s=0;}
                    else if(d8==1) {
                        k++;
                        // if(k==4) { img.setVisibility(View.INVISIBLE); text1.setVisibility(View.VISIBLE); }
                        b4.setVisibility(View.INVISIBLE);
                        b8.setVisibility(View.INVISIBLE);d8=0;d4=0;s=0;
                        //b8.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d8=0;d2=0;s=0;
                    }
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d5++;s++;
                if(d5==1 && s==1) b5.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d1==1) {
                        k++;
                        //if(k==4) { img.setVisibility(View.INVISIBLE); text1.setVisibility(View.VISIBLE); }
                        //b1.setBackgroundDrawable(getResources().getDrawable(R.color.color1));
                        b1.setVisibility(View.INVISIBLE);
                        b5.setVisibility(View.INVISIBLE);d1=0;d5=0;s=0;
                    }
                    else if(d2==1) {b2.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d2=0;d5=0;s=0;}
                    else if(d3==1) {b3.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d3=0;d5=0;s=0;}
                    else if(d4==1) {b4.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d4=0;d5=0;s=0;}
                    else if(d5==2) {b5.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d5=0;s=0;}
                    else if(d6==1) {b6.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d6=0;d5=0;s=0;}
                    else if(d7==1) {b7.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d7=0;d5=0;s=0;}
                    else if(d8==1) {b8.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d8=0;d5=0;s=0;}
                }
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d6++;s++;
                if(d6==1 && s==1) b6.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d1==1) {b1.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d1=0;d6=0;s=0;}
                    else if(d2==1) {
                        k++;
                        //if(k==4) { img.setVisibility(View.INVISIBLE); text1.setVisibility(View.VISIBLE); }
                        b2.setVisibility(View.INVISIBLE);
                        b6.setVisibility(View.INVISIBLE);
                        //b2.setBackgroundDrawable(getResources().getDrawable(R.color.color1));
                        d2=0;d6=0;s=0;
                    }
                    else if(d3==1) {b3.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d3=0;d6=0;s=0;}
                    else if(d4==1) {b4.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d4=0;d6=0;s=0;}
                    else if(d5==1) {b5.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d5=0;d6=0;s=0;}
                    else if(d6==2) {b6.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d6=0;s=0;}
                    else if(d7==1) {b7.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d7=0;d6=0;s=0;}
                    else if(d8==1) {b8.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d8=0;d6=0;s=0;}
                }
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d7++;s++;
                if(d7==1 && s==1) b7.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d1==1) {b1.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d1=0;d7=0;s=0;}
                    else if(d2==1) {b2.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d2=0;d7=0;s=0;}
                    else if(d3==1) {
                        k++;
                        // if(k==4) { img.setVisibility(View.INVISIBLE); text1.setVisibility(View.VISIBLE); }
                        b3.setVisibility(View.INVISIBLE);
                        b7.setVisibility(View.INVISIBLE);
                        //b3.setBackgroundDrawable(getResources().getDrawable(R.color.color1));
                        d3=0;d7=0;s=0;
                    }
                    else if(d4==1) {b4.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d4=0;d7=0;s=0;}
                    else if(d5==1) {b5.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d5=0;d7=0;s=0;}
                    else if(d6==1) {b6.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d6=0;d7=0;s=0;}
                    else if(d7==2) {b7.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d7=0;s=0;}
                    else if(d8==1) {b8.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d8=0;d7=0;s=0;}
                }
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d8++;s++;
                if(d8==1 && s==1) b8.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d1==1) {b1.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d1=0;d8=0;s=0;}
                    else if(d2==1) {b2.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d2=0;d8=0;s=0;}
                    else if(d3==1) {b3.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d3=0;d8=0;s=0;}
                    else if(d4==1) {
                        k++;
                        //if(k==4) { img.setVisibility(View.INVISIBLE); text1.setVisibility(View.VISIBLE); }
                        b4.setVisibility(View.INVISIBLE);
                        b8.setVisibility(View.INVISIBLE);
                        //b4.setBackgroundDrawable(getResources().getDrawable(R.color.color1));
                        d4=0;d8=0;s=0;
                    }
                    else if(d5==1) {b5.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d5=0;d8=0;s=0;}
                    else if(d6==1) {b6.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d6=0;d8=0;s=0;}
                    else if(d7==1) {b7.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d7=0;d8=0;s=0;}
                    else if(d8==2) {b8.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d8=0;s=0;}
                }
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d9++;s1++;
                if(d9==1 && s1==1) b9.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d9==2) {b9.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d9=0;s1=0;}
                    else if(d10==1) {b10.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d10=0;d9=0;s1=0;}
                    else if(d11==1) {b11.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d11=0;d9=0;s1=0;}
                    else if(d12==1) {b12.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d12=0;d9=0;s1=0;}
                    else if(d13==1) {
                        k1++;
                        //if(k==4) { text1.setVisibility(View.VISIBLE); }
                        b9.setVisibility(View.INVISIBLE);
                        b13.setVisibility(View.INVISIBLE);d13=0;d9=0;s1=0;
                        //b13.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d13=0;d9=0;s=0;
                    }
                    else if(d14==1) {b14.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d14=0;d9=0;s1=0;}
                    else if(d15==1) {b15.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d15=0;d9=0;s1=0;}
                    else if(d16==1) {b16.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d16=0;d9=0;s1=0;}
                }



            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d10++;s1++;
                if(d10==1 && s1==1) b10.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d9==1) {b9.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d9=0;d10=0;s1=0;}
                    else if(d10==2) {b10.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d10=0;s1=0;}
                    else if(d11==1) {b11.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d11=0;d10=0;s1=0;}
                    else if(d12==1) {b12.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d12=0;d10=0;s1=0;}
                    else if(d13==1) {b13.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d13=0;d10=0;s1=0;}
                    else if(d14==1) {
                        k1++;
                        //if(k==4) { text1.setVisibility(View.VISIBLE); }
                        b10.setVisibility(View.INVISIBLE);
                        b14.setVisibility(View.INVISIBLE);d14=0;d10=0;s1=0;
                        //b14.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d14=0;d10=0;s=0;
                    }
                    else if(d15==1) {b15.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d15=0;d10=0;s1=0;}
                    else if(d16==1) {b16.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d16=0;d10=0;s1=0;}
                }


            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d11++;s1++;
                if(d11==1 && s1==1) b11.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d9==1) {b9.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d9=0;d11=0;s1=0;}
                    else if(d10==1) {b10.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d10=0;d11=0;s1=0;}
                    else if(d11==2) {b11.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d11=0;s1=0;}
                    else if(d12==1) {b12.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d12=0;d11=0;s1=0;}
                    else if(d13==1) {b13.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d13=0;d11=0;s1=0;}
                    else if(d14==1) {b14.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d14=0;d11=0;s1=0;}
                    else if(d15==1) {
                        k1++;
                        //if(k==4) { text1.setVisibility(View.VISIBLE); }
                        //b15.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d15=0;d10=0;s=0;
                        b11.setVisibility(View.INVISIBLE);d15=0;d11=0;s1=0;
                        b15.setVisibility(View.INVISIBLE);
                    }
                    else if(d16==1) {b16.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d16=0;d10=0;s1=0;}
                }
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d12++;s1++;
                if(d12==1 && s1==1) b12.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d9==1) {b9.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d9=0;d12=0;s1=0;}
                    else if(d10==1) {b10.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d10=0;d12=0;s1=0;}
                    else if(d11==1) {b11.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d11=0;d12=0;s1=0;}
                    else if(d12==2) {b12.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d12=0;s1=0;}
                    else if(d13==1) {b13.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d13=0;d12=0;s1=0;}
                    else if(d14==1) {b14.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d14=0;d12=0;s1=0;}
                    else if(d15==1) {b15.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d15=0;d12=0;s1=0;}
                    else if(d16==1) {
                        k1++;
                        //if(k==4) { text1.setVisibility(View.VISIBLE); }
                        b12.setVisibility(View.INVISIBLE);
                        b16.setVisibility(View.INVISIBLE);d16=0;d12=0;s1=0;
                        //b16.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d16=0;d10=0;s=0;
                    }
                }
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d13++;s1++;
                if(d13==1 && s1==1) b13.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d9==1) {
                        k1++;
                        //if(k==4) { text1.setVisibility(View.VISIBLE); }
                        //b9.setBackgroundDrawable(getResources().getDrawable(R.color.color1));
                        b9.setVisibility(View.INVISIBLE);
                        b13.setVisibility(View.INVISIBLE);d9=0;d13=0;s1=0;
                    }
                    else if(d10==1) {b10.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d10=0;d13=0;s1=0;}
                    else if(d11==1) {b11.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d11=0;d13=0;s1=0;}
                    else if(d12==1) {b12.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d12=0;d13=0;s1=0;}
                    else if(d13==2) {b13.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d13=0;s1=0;}
                    else if(d14==1) {b14.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d14=0;d13=0;s1=0;}
                    else if(d15==1) {b15.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d15=0;d13=0;s1=0;}
                    else if(d16==1) {b16.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d16=0;d13=0;s1=0;}
                }
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d14++;s1++;
                if(d14==1 && s1==1) b14.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d9==1) {b9.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d9=0;d14=0;s1=0;}
                    else if(d10==1) {
                        k1++;
                        //if(k==4) { text1.setVisibility(View.VISIBLE); }
                        b10.setVisibility(View.INVISIBLE);
                        b14.setVisibility(View.INVISIBLE);
                        //b10.setBackgroundDrawable(getResources().getDrawable(R.color.color1));
                        d10=0;d14=0;s1=0;
                    }
                    else if(d11==1) {b11.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d11=0;d14=0;s1=0;}
                    else if(d12==1) {b12.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d12=0;d14=0;s1=0;}
                    else if(d13==1) {b13.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d13=0;d14=0;s1=0;}
                    else if(d14==2) {b14.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d14=0;s1=0;}
                    else if(d15==1) {b15.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d15=0;d14=0;s1=0;}
                    else if(d16==1) {b16.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d16=0;d14=0;s1=0;}
                }
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d15++;s1++;
                if(d15==1 && s1==1) b15.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d9==1) {b9.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d9=0;d15=0;s1=0;}
                    else if(d10==1) {b10.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d10=0;d15=0;s1=0;}
                    else if(d11==1) {
                        k1++;
                        //if(k==4) { text1.setVisibility(View.VISIBLE); }
                        b11.setVisibility(View.INVISIBLE);
                        b15.setVisibility(View.INVISIBLE);
                        //b11.setBackgroundDrawable(getResources().getDrawable(R.color.color1));
                        d11=0;d15=0;s1=0;
                    }
                    else if(d12==1) {b12.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d12=0;d15=0;s1=0;}
                    else if(d13==1) {b13.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d13=0;d15=0;s1=0;}
                    else if(d14==1) {b14.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d14=0;d15=0;s1=0;}
                    else if(d15==2) {b15.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d15=0;s1=0;}
                    else if(d16==1) {b16.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d16=0;d15=0;s1=0;}
                }
            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d16++;s1++;
                if(d16==1 && s1==1) b16.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d9==1) {b9.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d9=0;d16=0;s1=0;}
                    else if(d10==1) {b10.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d10=0;d16=0;s1=0;}
                    else if(d11==1) {b11.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d11=0;d16=0;s1=0;}
                    else if(d12==1) {
                        k1++;
                        //if(k==4) { text1.setVisibility(View.VISIBLE); }
                        b12.setVisibility(View.INVISIBLE);
                        b16.setVisibility(View.INVISIBLE);
                        //b12.setBackgroundDrawable(getResources().getDrawable(R.color.color1));
                        d12=0;d16=0;s1=0;
                    }
                    else if(d13==1) {b13.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d13=0;d16=0;s1=0;}
                    else if(d14==1) {b14.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d14=0;d16=0;s1=0;}
                    else if(d15==1) {b15.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d15=0;d16=0;s1=0;}
                    else if(d16==2) {b16.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d16=0;s1=0;}
                }
            }
        });

        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d17++;s2++;
                if(d17==1 && s2==1) b17.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d17==2) {b17.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d17=0;s2=0;}
                    else if(d18==1) {b18.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d18=0;d17=0;s2=0;}
                    else if(d19==1) {b19.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d19=0;d17=0;s2=0;}
                    else if(d20==1) {b20.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d20=0;d17=0;s2=0;}
                    else if(d21==1) {
                        k2++;
                        //if(k==4) { text1.setVisibility(View.VISIBLE); }
                        b17.setVisibility(View.INVISIBLE);
                        b21.setVisibility(View.INVISIBLE);d21=0;d17=0;s2=0;
                        //b21.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d21=0;d17=0;s=0;
                    }
                    else if(d22==1) {b22.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d22=0;d17=0;s2=0;}
                    else if(d23==1) {b23.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d23=0;d17=0;s2=0;}
                    else if(d24==1) {b24.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d24=0;d17=0;s2=0;}
                }



            }
        });
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d18++;s2++;
                if(d18==1 && s2==1) b18.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d17==1) {b17.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d17=0;d18=0;s2=0;}
                    else if(d18==2) {b18.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d18=0;s2=0;}
                    else if(d19==1) {b19.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d19=0;d18=0;s2=0;}
                    else if(d20==1) {b20.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d20=0;d18=0;s2=0;}
                    else if(d21==1) {b21.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d21=0;d18=0;s2=0;}
                    else if(d22==1) {
                        k2++;
                        //if(k==4) { text1.setVisibility(View.VISIBLE); }
                        b18.setVisibility(View.INVISIBLE);
                        b22.setVisibility(View.INVISIBLE);d22=0;d18=0;s2=0;
                        //b22.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d22=0;d18=0;s=0;
                    }
                    else if(d23==1) {b23.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d23=0;d18=0;s2=0;}
                    else if(d24==1) {b24.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d24=0;d18=0;s2=0;}
                }


            }
        });
        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d19++;s2++;
                if(d19==1 && s2==1) b19.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d17==1) {b17.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d17=0;d19=0;s2=0;}
                    else if(d18==1) {b18.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d18=0;d19=0;s2=0;}
                    else if(d19==2) {b19.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d19=0;s2=0;}
                    else if(d20==1) {b20.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d20=0;d19=0;s2=0;}
                    else if(d21==1) {b21.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d21=0;d19=0;s2=0;}
                    else if(d22==1) {b22.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d22=0;d19=0;s2=0;}
                    else if(d23==1) {
                        k2++;
                        //if(k==4) { text1.setVisibility(View.VISIBLE); }
                        //b23.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d23=0;d18=0;s=0;
                        b19.setVisibility(View.INVISIBLE);d23=0;d19=0;s2=0;
                        b23.setVisibility(View.INVISIBLE);
                    }
                    else if(d24==1) {b24.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d24=0;d18=0;s2=0;}
                }
            }
        });
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d20++;s2++;
                if(d20==1 && s2==1) b20.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d17==1) {b17.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d17=0;d20=0;s2=0;}
                    else if(d18==1) {b18.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d18=0;d20=0;s2=0;}
                    else if(d19==1) {b19.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d19=0;d20=0;s2=0;}
                    else if(d20==2) {b20.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d20=0;s2=0;}
                    else if(d21==1) {b21.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d21=0;d20=0;s2=0;}
                    else if(d22==1) {b22.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d22=0;d20=0;s2=0;}
                    else if(d23==1) {b23.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d23=0;d20=0;s2=0;}
                    else if(d24==1) {
                        k2++;
                        //if(k==4) { text1.setVisibility(View.VISIBLE); }
                        b20.setVisibility(View.INVISIBLE);
                        b24.setVisibility(View.INVISIBLE);d24=0;d20=0;s2=0;
                        //b24.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d24=0;d18=0;s=0;
                    }
                }
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d21++;s2++;
                if(d21==1 && s2==1) b21.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d17==1) {
                        k2++;
                        //if(k==4) { text1.setVisibility(View.VISIBLE); }
                        //b17.setBackgroundDrawable(getResources().getDrawable(R.color.color1));
                        b17.setVisibility(View.INVISIBLE);
                        b21.setVisibility(View.INVISIBLE);d17=0;d21=0;s2=0;
                    }
                    else if(d18==1) {b18.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d18=0;d21=0;s2=0;}
                    else if(d19==1) {b19.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d19=0;d21=0;s2=0;}
                    else if(d20==1) {b20.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d20=0;d21=0;s2=0;}
                    else if(d21==2) {b21.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d21=0;s2=0;}
                    else if(d22==1) {b22.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d22=0;d21=0;s2=0;}
                    else if(d23==1) {b23.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d23=0;d21=0;s2=0;}
                    else if(d24==1) {b24.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d24=0;d21=0;s2=0;}
                }
            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d22++;s2++;
                if(d22==1 && s2==1) b22.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d17==1) {b17.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d17=0;d22=0;s2=0;}
                    else if(d18==1) {
                        k2++;
                        //if(k==4) { text1.setVisibility(View.VISIBLE); }
                        b18.setVisibility(View.INVISIBLE);
                        b22.setVisibility(View.INVISIBLE);
                        //b18.setBackgroundDrawable(getResources().getDrawable(R.color.color1));
                        d18=0;d22=0;s2=0;
                    }
                    else if(d19==1) {b19.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d19=0;d22=0;s2=0;}
                    else if(d20==1) {b20.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d20=0;d22=0;s2=0;}
                    else if(d21==1) {b21.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d21=0;d22=0;s2=0;}
                    else if(d22==2) {b22.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d22=0;s2=0;}
                    else if(d23==1) {b23.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d23=0;d22=0;s2=0;}
                    else if(d24==1) {b24.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d24=0;d22=0;s2=0;}
                }
            }
        });
        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d23++;s2++;
                if(d23==1 && s2==1) b23.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d17==1) {b17.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d17=0;d23=0;s2=0;}
                    else if(d18==1) {b18.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d18=0;d23=0;s2=0;}
                    else if(d19==1) {
                        k2++;
                        //if(k==4) { text1.setVisibility(View.VISIBLE); }
                        b19.setVisibility(View.INVISIBLE);
                        b23.setVisibility(View.INVISIBLE);
                        //b19.setBackgroundDrawable(getResources().getDrawable(R.color.color1));
                        d19=0;d23=0;s2=0;
                    }
                    else if(d20==1) {b20.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d20=0;d23=0;s2=0;}
                    else if(d21==1) {b21.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d21=0;d23=0;s2=0;}
                    else if(d22==1) {b22.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d22=0;d23=0;s2=0;}
                    else if(d23==2) {b23.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d23=0;s2=0;}
                    else if(d24==1) {b24.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d24=0;d23=0;s2=0;}
                }
            }
        });
        b24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d24++;s2++;
                if(d24==1 && s2==1) b24.setBackgroundDrawable(getResources().getDrawable(R.color.color2));
                else {
                    if(d17==1) {b17.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d17=0;d24=0;s2=0;}
                    else if(d18==1) {b18.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d18=0;d24=0;s2=0;}
                    else if(d19==1) {b19.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d19=0;d24=0;s2=0;}
                    else if(d20==1) {
                        k2++;
                        //if(k==4) { text1.setVisibility(View.VISIBLE); }
                        b20.setVisibility(View.INVISIBLE);
                        b24.setVisibility(View.INVISIBLE);
                        //b20.setBackgroundDrawable(getResources().getDrawable(R.color.color1));
                        d20=0;d24=0;s2=0;
                    }
                    else if(d21==1) {b21.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d21=0;d24=0;s2=0;}
                    else if(d22==1) {b22.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d22=0;d24=0;s2=0;}
                    else if(d23==1) {b23.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d23=0;d24=0;s2=0;}
                    else if(d24==2) {b24.setBackgroundDrawable(getResources().getDrawable(R.color.color1));d24=0;s2=0;}
                }
            }
        });

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

        if(b1.getVisibility() == view.INVISIBLE && b2.getVisibility() == view.INVISIBLE && b3.getVisibility() == view.INVISIBLE && b4.getVisibility() == view.INVISIBLE ){
            data1 = "1";
        }
        else {data1 ="0";}

        if(b9.getVisibility() == view.INVISIBLE && b10.getVisibility() == view.INVISIBLE && b11.getVisibility() == view.INVISIBLE && b12.getVisibility() == view.INVISIBLE ){
            data2 = "1";
        }
        else {data2 ="0";}

        if(b17.getVisibility() == view.INVISIBLE && b18.getVisibility() == view.INVISIBLE && b19.getVisibility() == view.INVISIBLE && b20.getVisibility() == view.INVISIBLE ){
            data3 = "1";
        }
        else {data3 ="0";}

        float t=120;          // Threshold time
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
        user1.put("Graphical Night",inf);

        documentReference1.set(user1, SetOptions.merge());

        //        if (m1.isChecked()){ data1 = "1";}
//        else { data1 = "0";}
//        if (m2.isChecked()){ data2 = "1";}
//        else { data2 = "0";}
//        if (m3.isChecked()){ data3 = "1";}
//        else { data3 = "0";}


//        if (m4.isChecked()){ data4 = "1";}
//        else { data4 = "0";}
//        if (m5.isChecked()){ data5 = "1";}
//        else { data5 = "0";}
        Intent intent = new Intent(graphical.this, ascore3.class);
        startActivity(intent);
    }

    public void move1 (View view){ //move front
        if(cardView1.getVisibility() == View.VISIBLE){
            //b01.setVisibility(View.VISIBLE);
            b01.setText("Previous");
            cardView1.setVisibility(View.GONE);
            cardView2.setVisibility(View.VISIBLE);
        }
        else if(cardView2.getVisibility() == View.VISIBLE){
            if(sub.getVisibility()== View.INVISIBLE){
                sub.setVisibility(View.VISIBLE);
            }
            b02.setVisibility(View.INVISIBLE);
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
                            graphical.super.onBackPressed();
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
            //b01.setVisibility(View.INVISIBLE);
            b01.setText("Back");
            cardView2.setVisibility(View.GONE);
            cardView1.setVisibility(View.VISIBLE);
        }
        else if(cardView3.getVisibility() == View.VISIBLE){
            b02.setVisibility(View.VISIBLE);
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