package com.example.brainrun;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    private TextView OddScore;
    private TextView Riddles;
    private TextView PlayingWithGraph;
    private TextView BankThief;
    private TextView SundayGame;
    private TextView BlakeBox;
    private TextView DetectiveBlake;
    private TextView GraphicalNight;
    private TextView SchoolChaos;
    private TextView PeterDilemma;
    private TextView BenTrip;
    private TextView Football;
    private TextView AdamDay;
    private TextView CiaSurprise;
    private TextView DaneDrawing;
    private TextView JohnNorman;
    private TextView TotalCuriousSam,TotalBlake,TotalNext,TotalPerfect;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        TotalCuriousSam=findViewById(R.id.total_score_curioussam);
        TotalBlake=findViewById(R.id.total_score_blake);
        TotalNext=findViewById(R.id.total_score_next);
        TotalPerfect=findViewById(R.id.total_score_estimation);

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF5A5A")));

        OddScore = findViewById(R.id.OddScore);
        SharedPreferences getShared4 = getSharedPreferences("Interpretation",MODE_PRIVATE);
        String Inter4 = getShared4.getString("oddone","0");
        OddScore.setText(Inter4);

        BankThief=findViewById(R.id.BankScore);
        SharedPreferences getShared1 = getSharedPreferences("Interpretation",MODE_PRIVATE);
        String Inter1 = getShared1.getString("analogy","0");
        BankThief.setText(Inter1);

        PlayingWithGraph = findViewById(R.id.PlayingWithGraphScore);
        SharedPreferences getShared2 = getSharedPreferences("Interpretation",MODE_PRIVATE);
        String Inter2 = getShared2.getString("graph","0");
        PlayingWithGraph.setText(Inter2);

        Riddles=findViewById(R.id.RiddleScore);
        SharedPreferences getShared3 = getSharedPreferences("Interpretation",MODE_PRIVATE);
        String Inter3 = getShared3.getString("riddle","0");
        Riddles.setText(Inter3);

        int i_one=Integer.parseInt(Inter1)+Integer.parseInt(Inter2)+Integer.parseInt(Inter3)+Integer.parseInt(Inter4);
        TotalCuriousSam.setText(String.valueOf(i_one));

        BlakeBox = findViewById(R.id.BoxScore);
        SharedPreferences getShared5 = getSharedPreferences("analysis",MODE_PRIVATE);
        String analysis1 = getShared5.getString("gifts","0");
        BlakeBox.setText(analysis1);

                                break;
                            case "Perfect Estimation":
                                if(userData!=null){
                                    int schoolChaos = Integer.parseInt(userData.getOrDefault("Chaos at School", "0").toString());
                                    int peterDilemma = Integer.parseInt(userData.getOrDefault("Peter's Dilemma", "0").toString());
                                    int benTrip = Integer.parseInt(userData.getOrDefault("Ben's Trip", "0").toString());
                                    int football = Integer.parseInt(userData.getOrDefault("Football Match", "0").toString());
                                    int total = schoolChaos + peterDilemma + benTrip + football;
                                    SchoolChaos.setText(String.valueOf(schoolChaos));
                                    PeterDilemma.setText(String.valueOf(peterDilemma));
                                    BenTrip.setText(String.valueOf(benTrip));
                                    Football.setText(String.valueOf(football));
                                    TotalPerfect.setText(String.valueOf(total));
                                } else {
                                    SchoolChaos.setText("0");
                                    PeterDilemma.setText("0");
                                    BenTrip.setText("0");
                                    Football.setText("0");
                                    TotalPerfect.setText("0");
                                }
                                break;
                        }
                    } else {
                        Log.d("document", "onComplete: error getting document");
                        showErrorAndRedirect();
                    }
                } else {
                    Log.d("user", "onComplete: error getting user");
                    showErrorAndRedirect();
                }
                if(fetchCounter==4){
                    progressBar.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);
//                    progressBar.setVisibility(View.GONE);
//                    scrollView.setVisibility(View.VISIBLE);
                }
            }
        });
    }

        GraphicalNight=findViewById(R.id.GraphicalScore);
        SharedPreferences getShared7 = getSharedPreferences("analysis",MODE_PRIVATE);
        String analysis3 = getShared7.getString("graphical","0");
        GraphicalNight.setText(analysis3);

        SundayGame=findViewById(R.id.SundayScore);
        SharedPreferences getShared8 = getSharedPreferences("analysis",MODE_PRIVATE);
        String analysis4 = getShared8.getString("sunday1","0");
        SundayGame.setText(analysis4);

        int i_two=Integer.parseInt(analysis1)+Integer.parseInt(analysis2)+Integer.parseInt(analysis3)+Integer.parseInt(analysis4);
        TotalBlake.setText(String.valueOf(i_two));

        AdamDay= findViewById(R.id.AdamScore);
        SharedPreferences getShared9 = getSharedPreferences("Inference",MODE_PRIVATE);
        String Infer1 = getShared9.getString("adam","0");
        AdamDay.setText(Infer1);

        CiaSurprise = findViewById(R.id.CiaScore);
        SharedPreferences getShared10 = getSharedPreferences("Inference",MODE_PRIVATE);
        String Infer2 = getShared10.getString("cia","0");
        CiaSurprise.setText(Infer2);

        DaneDrawing = findViewById(R.id.DaneScore);
        SharedPreferences getShared11 = getSharedPreferences("Inference",MODE_PRIVATE);
        String Infer3 = getShared11.getString("ben","0");
        DaneDrawing.setText(Infer3);

        JohnNorman = findViewById(R.id.JohnNormanScore);
        SharedPreferences getShared12 = getSharedPreferences("Inference",MODE_PRIVATE);
        String Infer4 = getShared12.getString("john","0");
        JohnNorman.setText(Infer4);

        int i_three=Integer.parseInt(Infer1)+Integer.parseInt(Infer2)+Integer.parseInt(Infer3)+Integer.parseInt(Infer4);
        TotalNext.setText(String.valueOf(i_three));

        SchoolChaos = findViewById(R.id.ChaosScore);
        SharedPreferences getShared13 = getSharedPreferences("Evaluation",MODE_PRIVATE);
        String Eval1 = getShared13.getString("school","0");
        SchoolChaos.setText(Eval1);

        PeterDilemma = findViewById(R.id.PeterScore);
        SharedPreferences getShared14 = getSharedPreferences("Evaluation",MODE_PRIVATE);
        String Eval2 = getShared14.getString("car","0");
        PeterDilemma.setText(Eval2);

        BenTrip = findViewById(R.id.BenScore);
        SharedPreferences getShared15 = getSharedPreferences("Evaluation",MODE_PRIVATE);
        String Eval3 = getShared15.getString("trip","0");
        BenTrip.setText(Eval3);

        Football = findViewById(R.id.FootballScore);
        SharedPreferences getShared16 = getSharedPreferences("Evaluation",MODE_PRIVATE);
        String Eval4 = getShared16.getString("sport","0");
        Football.setText(Eval4);

        int i_four=Integer.parseInt(Eval1)+Integer.parseInt(Eval2)+Integer.parseInt(Eval3)+Integer.parseInt(Eval4);
        TotalPerfect.setText(String.valueOf(i_four));
    }
}