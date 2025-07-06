package com.example.brainrun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String userID;
    private static String data = "1";

    private long bpTime;
    private Toast backToast;

    @Override
    public void onBackPressed() {
//        if(bpTime + 2000 > System.currentTimeMillis()){
//            backToast.cancel();
            //super.onBackPressed();
//            return;
//        }
//        else {
//            backToast = Toast.makeText(getBaseContext(), "Press back again to exit",Toast.LENGTH_SHORT );
//            backToast.show();
//        }
//
//        bpTime = System.currentTimeMillis();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"red\">"+"BRAIN RUN"+"</font>"));


        //fAuth = FirebaseAuth.getInstance();
        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        if(fAuth.getCurrentUser() == null){
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
        }

        //getSupportActionBar().hide()
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFffff")));

        SharedPreferences getShared1 = getSharedPreferences("Interpretation",MODE_PRIVATE);
        String Inter1 = getShared1.getString("analogy","0");

        SharedPreferences getShared2 = getSharedPreferences("Interpretation",MODE_PRIVATE);
        String Inter2 = getShared2.getString("graph","0");

        SharedPreferences getShared3 = getSharedPreferences("Interpretation",MODE_PRIVATE);
        String Inter3 = getShared3.getString("riddle","0");

        SharedPreferences getShared4 = getSharedPreferences("Interpretation",MODE_PRIVATE);
        String Inter4 = getShared4.getString("oddone","0");

        SharedPreferences getShared5 = getSharedPreferences("analysis",MODE_PRIVATE);
        String analysis1 = getShared5.getString("gifts","0");

        SharedPreferences getShared6 = getSharedPreferences("analysis",MODE_PRIVATE);
        String analysis2 = getShared6.getString("detective","0");

        SharedPreferences getShared7 = getSharedPreferences("analysis",MODE_PRIVATE);
        String analysis3 = getShared7.getString("graphical","0");

        SharedPreferences getShared8 = getSharedPreferences("analysis",MODE_PRIVATE);
        String analysis4 = getShared8.getString("sunday1","0");

        SharedPreferences getShared9 = getSharedPreferences("Inference",MODE_PRIVATE);
        String Infer1 = getShared9.getString("adam","0");

        SharedPreferences getShared10 = getSharedPreferences("Inference",MODE_PRIVATE);
        String Infer2 = getShared10.getString("cia","0");

        SharedPreferences getShared11 = getSharedPreferences("Inference",MODE_PRIVATE);
        String Infer3 = getShared11.getString("ben","0");

        SharedPreferences getShared12 = getSharedPreferences("Inference",MODE_PRIVATE);
        String Infer4 = getShared12.getString("john","0");

        SharedPreferences getShared13 = getSharedPreferences("Evaluation",MODE_PRIVATE);
        String Eval1 = getShared13.getString("school","0");

        SharedPreferences getShared14 = getSharedPreferences("Evaluation",MODE_PRIVATE);
        String Eval2 = getShared14.getString("car","0");

        SharedPreferences getShared15 = getSharedPreferences("Evaluation",MODE_PRIVATE);
        String Eval3 = getShared15.getString("trip","0");

        SharedPreferences getShared16 = getSharedPreferences("Evaluation",MODE_PRIVATE);
        String Eval4 = getShared16.getString("sport","0");

//        public void sendReferral(String appInstanceId, String desktopUrl, String uniqueIdentifier) {
//            if (NetworkUtil.getConnectivityStatus(this) == NetworkUtil.TYPE_NOT_CONNECTED) {
//                Toast.makeText(this, R.string.no_internet_message, Toast.LENGTH_SHORT).show();
//                return;
//            }

        userID = fAuth.getCurrentUser().getUid();

//        DocumentReference documentReference1 = fstore.collection("users").document(userID).collection("Curious Sam").document(userID);
//        Map<String,Object> user1 = new HashMap<>();
//        user1.put("Bank Thief",Inter1);
//        user1.put("Playing with Graphs",Inter2);
//        user1.put("Riddles",Inter3);
//        user1.put("Odd One Out",Inter4);
//        documentReference1.set(user1, SetOptions.merge());
//
//        DocumentReference documentReference2 = fstore.collection("users").document(userID).collection("Blake's Adventure").document(userID);
//        Map<String,Object> user2 = new HashMap<>();
//        user2.put("Blake's Boxes",analysis1);
//        user2.put("Detective Blake",analysis2);
//        user2.put("Graphical Night",analysis3);
//        user2.put("Sunday's Game",analysis4);
//        documentReference2.set(user2, SetOptions.merge());
//
//        DocumentReference documentReference3 = fstore.collection("users").document(userID).collection("What's Next").document(userID);
//        Map<String,Object> user3 = new HashMap<>();
//        user3.put("Adam's Day",Infer1);
//        user3.put("Cia's Surprise",Infer2);
//        user3.put("Dane's Drawing",Infer3);
//        user3.put("John and Norman",Infer4);
//        documentReference3.set(user3, SetOptions.merge());
//
//        DocumentReference documentReference4 = fstore.collection("users").document(userID).collection("Perfect Estimation").document(userID);
//        Map<String,Object> user4 = new HashMap<>();
//        user4.put("Chaos at School",Eval1);
//        user4.put("Peter's Dilemma",Eval2);
//        user4.put("Ben's Trip",Eval3);
//        user4.put("Football Match",Eval4);
//        documentReference4.set(user4, SetOptions.merge());
//
//
//        DocumentReference documentReference5 = fstore.collection("users").document(userID);
//        Map<String,Object> user = new HashMap<>();
//        user.put("Bank Thief",Inter1);
//        user.put("Playing with Graphs",Inter2);
//        user.put("Riddles",Inter3);
//        user.put("Odd One Out",Inter4);
//        user.put("Blake's Boxes",analysis1);
//        user.put("Detective Blake",analysis2);
//        user.put("Graphical Night",analysis3);
//        user.put("Sunday's Game",analysis4);
//        user.put("Adam's Day",Infer1);
//        user.put("Cia's Surprise",Infer2);
//        user.put("Dane's Drawing",Infer3);
//        user.put("John and Norman",Infer4);
//        user.put("Chaos at School",Eval1);
//        user.put("Peter's Dilemma",Eval2);
//        user.put("Ben's Trip",Eval3);
//        user.put("Football Match",Eval4);
//        documentReference5.set(user, SetOptions.merge());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_logout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
            {
                SharedPreferences shrd1 = getSharedPreferences("analysis",MODE_PRIVATE);
                SharedPreferences.Editor editor1 =  shrd1.edit();
                editor1.putString("gifts","0");
                editor1.apply();

                SharedPreferences shrd2 = getSharedPreferences("analysis",MODE_PRIVATE);
                SharedPreferences.Editor editor2 =  shrd2.edit();
                editor2.putString("detective","0");
                editor2.apply();

                SharedPreferences shrd3 = getSharedPreferences("analysis",MODE_PRIVATE);
                SharedPreferences.Editor editor3 =  shrd3.edit();
                editor3.putString("graphical","0");
                editor3.apply();

                SharedPreferences shrd4 = getSharedPreferences("analysis",MODE_PRIVATE);
                SharedPreferences.Editor editor4 =  shrd4.edit();
                editor4.putString("sunday1","0");
                editor4.apply();

                SharedPreferences shrd5 = getSharedPreferences("Inference",MODE_PRIVATE);
                SharedPreferences.Editor editor5 =  shrd5.edit();
                editor5.putString("adam","0");
                editor5.apply();

                SharedPreferences shrd6 = getSharedPreferences("Inference",MODE_PRIVATE);
                SharedPreferences.Editor editor6 =  shrd6.edit();
                editor6.putString("cia","0");
                editor6.apply();

                SharedPreferences shrd7 = getSharedPreferences("Inference",MODE_PRIVATE);
                SharedPreferences.Editor editor7 =  shrd7.edit();
                editor7.putString("ben","0");
                editor7.apply();

                SharedPreferences shrd8 = getSharedPreferences("Inference",MODE_PRIVATE);
                SharedPreferences.Editor editor8 =  shrd8.edit();
                editor8.putString("john","0");
                editor8.apply();

                SharedPreferences shrd9 = getSharedPreferences("Evaluation",MODE_PRIVATE);
                SharedPreferences.Editor editor9 =  shrd9.edit();
                editor9.putString("school","0");
                editor9.apply();

                SharedPreferences shrd10 = getSharedPreferences("Evaluation",MODE_PRIVATE);
                SharedPreferences.Editor editor10 =  shrd10.edit();
                editor10.putString("car","0");
                editor10.apply();

                SharedPreferences shrd11 = getSharedPreferences("Evaluation",MODE_PRIVATE);
                SharedPreferences.Editor editor11 =  shrd11.edit();
                editor11.putString("trip","0");
                editor11.apply();

                SharedPreferences shrd12 = getSharedPreferences("Evaluation",MODE_PRIVATE);
                SharedPreferences.Editor editor12 =  shrd12.edit();
                editor12.putString("sport","0");
                editor12.apply();

                SharedPreferences shrd13 = getSharedPreferences("Interpretation",MODE_PRIVATE);
                SharedPreferences.Editor editor13 =  shrd13.edit();
                editor13.putString("analogy","0");
                editor13.apply();

                SharedPreferences shrd14 = getSharedPreferences("Interpretation",MODE_PRIVATE);
                SharedPreferences.Editor editor14 =  shrd14.edit();
                editor14.putString("graph","0");
                editor14.apply();

                SharedPreferences shrd15 = getSharedPreferences("Interpretation",MODE_PRIVATE);
                SharedPreferences.Editor editor15 =  shrd15.edit();
                editor15.putString("riddle","0");
                editor15.apply();

                SharedPreferences shrd16 = getSharedPreferences("Interpretation",MODE_PRIVATE);
                SharedPreferences.Editor editor16 =  shrd16.edit();
                editor16.putString("oddone","0");
                editor16.apply();


                FirebaseAuth.getInstance().signOut();//logout
                super.onBackPressed();
                break;
            }
            case R.id.about: {
//                Toast.makeText(this, "About page is not available", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
                break;
            }
            case R.id.score: {
                //Toast.makeText(this, "About page is not available", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                startActivity(intent);
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }


    public static String getData(){ return data; }


    public void move (View view){
        Intent intent = new Intent(MainActivity.this, Inference.class);
        startActivity(intent);
    }
    public void move1 (View view){
        Intent intent = new Intent(MainActivity.this, interpretation.class);
        startActivity(intent);
    }
    public void move2 (View view){
        Intent intent = new Intent(MainActivity.this, analysis.class);
        startActivity(intent);
    }
    public void move3 (View view){
        Intent intent = new Intent(MainActivity.this, Evaluation.class);
        startActivity(intent);
    }

    public void mov2 (View view){
        FirebaseAuth.getInstance().signOut();//logout
        super.onBackPressed();
//        startActivity(new Intent(getApplicationContext(),MainActivity.class));
//        finish();
    }
}