package com.example.brainrun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

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
    private ProgressBar progressBar;
    private int fetchCounter = 0;
    private ScrollView scrollView;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        progressBar = findViewById(R.id.progressBarScore);
        scrollView = findViewById(R.id.scrollViewScore);
        OddScore = findViewById(R.id.OddScore);
        Riddles = findViewById(R.id.RiddleScore);
        PlayingWithGraph = findViewById(R.id.PlayingWithGraphScore);
        BankThief = findViewById(R.id.BankScore);
        TotalCuriousSam = findViewById(R.id.total_score_curioussam);

        SundayGame = findViewById(R.id.SundayScore);
        BlakeBox = findViewById(R.id.BoxScore);
        DetectiveBlake = findViewById(R.id.DetectiveScore);
        GraphicalNight = findViewById(R.id.GraphicalScore);
        TotalBlake = findViewById(R.id.total_score_blake);

        SchoolChaos = findViewById(R.id.ChaosScore);
        PeterDilemma = findViewById(R.id.PeterScore);
        BenTrip = findViewById(R.id.BenScore);
        Football = findViewById(R.id.FootballScore);
        TotalPerfect = findViewById(R.id.total_score_estimation);

        AdamDay = findViewById(R.id.AdamScore);
        CiaSurprise = findViewById(R.id.CiaScore);
        DaneDrawing = findViewById(R.id.DaneScore);
        JohnNorman = findViewById(R.id.JohnNormanScore);
        TotalNext = findViewById(R.id.total_score_next);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF5A5A")));
        userID = fAuth.getCurrentUser().getUid();
        fetchUserData(userID, "What's Next");
        fetchUserData(userID, "Curious Sam");
        fetchUserData(userID, "Blake's Adventure");
        fetchUserData(userID, "Perfect Estimation");
    }


    private void fetchUserData(String userID, String collectionName) {

        DocumentReference documentReference = fStore.collection("users").document(userID).collection(collectionName).document(userID);
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                fetchCounter=fetchCounter+1;
                if(task.isSuccessful()){
                    DocumentSnapshot document = task.getResult();
                    if(document.exists()){
                        Map<String, Object> userData = document.getData();
                        // Process userData as needed
                        switch (collectionName) {
                            case "What's Next":
                                if (userData != null) {
                                    int adamDay = Integer.parseInt(userData.getOrDefault("Adam's Day", "0").toString());
                                    int ciaSurprise = Integer.parseInt(userData.getOrDefault("Cia's Surprise", "0").toString());
                                    int daneDrawing = Integer.parseInt(userData.getOrDefault("Dane's Drawing", "0").toString());
                                    int johnNorman = Integer.parseInt(userData.getOrDefault("John and Norman", "0").toString());
                                    int total = adamDay + ciaSurprise + daneDrawing + johnNorman;
                                    AdamDay.setText(String.valueOf(adamDay));
                                    CiaSurprise.setText(String.valueOf(ciaSurprise));
                                    DaneDrawing.setText(String.valueOf(daneDrawing));
                                    JohnNorman.setText(String.valueOf(johnNorman));
                                    TotalNext.setText(String.valueOf(total));

                                } else {
                                    AdamDay.setText("0");
                                    CiaSurprise.setText("0");
                                    DaneDrawing.setText("0");
                                    JohnNorman.setText("0");
                                    TotalNext.setText("0");
                                }
                                break;
                            case "Curious Sam":
                                if(userData!=null) {
                                    int oddScore = Integer.parseInt(userData.getOrDefault("Odd One Out", "0").toString());
                                    int riddles = Integer.parseInt(userData.getOrDefault("Riddles", "0").toString());
                                    int playingWithGraph = Integer.parseInt(userData.getOrDefault("Playing with Graphs", "0").toString());
                                    int bankThief = Integer.parseInt(userData.getOrDefault("Bank Thief", "0").toString());
                                    int total = oddScore + riddles + playingWithGraph + bankThief;
                                    OddScore.setText(String.valueOf(oddScore));
                                    Riddles.setText(String.valueOf(riddles));
                                    PlayingWithGraph.setText(String.valueOf(playingWithGraph));
                                    BankThief.setText(String.valueOf(bankThief));
                                    TotalCuriousSam.setText(String.valueOf(total));
                                } else {
                                    OddScore.setText("0");
                                    Riddles.setText("0");
                                    PlayingWithGraph.setText("0");
                                    BankThief.setText("0");
                                    TotalCuriousSam.setText("0");
                                }
                                break;
                            case "Blake's Adventure":
                                if(userData!=null) {
                                    int sundayGame = Integer.parseInt(userData.getOrDefault("Sunday's Game", "0").toString());
                                    int blakeBox = Integer.parseInt(userData.getOrDefault("Blake's Boxes", "0").toString());
                                    int detectiveBlake = Integer.parseInt(userData.getOrDefault("Detective Blake", "0").toString());
                                    int graphicalNight = Integer.parseInt(userData.getOrDefault("Graphical Night", "0").toString());

                                    int total = sundayGame + blakeBox + detectiveBlake + graphicalNight;
                                    SundayGame.setText(String.valueOf(sundayGame));
                                    BlakeBox.setText(String.valueOf(blakeBox));
                                    DetectiveBlake.setText(String.valueOf(detectiveBlake));
                                    GraphicalNight.setText(String.valueOf(graphicalNight));

                                    TotalBlake.setText(String.valueOf(total));
                                } else {
                                    SundayGame.setText("0");
                                    BlakeBox.setText("0");
                                    DetectiveBlake.setText("0");
                                    GraphicalNight.setText("0");
                                    TotalBlake.setText("0");
                                }

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

    private void showErrorAndRedirect() {
        Toast.makeText(Dashboard.this, "Error getting scores", Toast.LENGTH_SHORT).show();
        Intent it = new Intent(Dashboard.this, MainActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
        finish();
    }
}