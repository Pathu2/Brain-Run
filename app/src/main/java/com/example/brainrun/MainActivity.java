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

        //fAuth = FirebaseAuth.getInstance();
        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        if(fAuth.getCurrentUser() == null){
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
        }

        //getSupportActionBar().hide()
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF5A5A")));

        SharedPreferences getShared1 = getSharedPreferences("Interpretation",MODE_PRIVATE);
        String Inter1 = getShared1.getString("analogy","The Score");

        SharedPreferences getShared2 = getSharedPreferences("Interpretation",MODE_PRIVATE);
        String Inter2 = getShared2.getString("graph","The Score");

        SharedPreferences getShared3 = getSharedPreferences("Interpretation",MODE_PRIVATE);
        String Inter3 = getShared3.getString("riddle","The Score");

        SharedPreferences getShared4 = getSharedPreferences("Interpretation",MODE_PRIVATE);
        String Inter4 = getShared4.getString("oddone","The Score");

        SharedPreferences getShared5 = getSharedPreferences("analysis",MODE_PRIVATE);
        String analysis1 = getShared5.getString("gifts","The Score");

        SharedPreferences getShared6 = getSharedPreferences("analysis",MODE_PRIVATE);
        String analysis2 = getShared6.getString("detective","The Score");

        SharedPreferences getShared7 = getSharedPreferences("analysis",MODE_PRIVATE);
        String analysis3 = getShared7.getString("graphical","The Score");

        SharedPreferences getShared8 = getSharedPreferences("analysis",MODE_PRIVATE);
        String analysis4 = getShared8.getString("sunday1","The Score");

        SharedPreferences getShared9 = getSharedPreferences("Inference",MODE_PRIVATE);
        String Infer1 = getShared9.getString("adam","The Score");

        SharedPreferences getShared10 = getSharedPreferences("Inference",MODE_PRIVATE);
        String Infer2 = getShared10.getString("cia","The Score");

        SharedPreferences getShared11 = getSharedPreferences("Inference",MODE_PRIVATE);
        String Infer3 = getShared11.getString("ben","The Score");

        SharedPreferences getShared12 = getSharedPreferences("Inference",MODE_PRIVATE);
        String Infer4 = getShared12.getString("john","The Score");

        SharedPreferences getShared13 = getSharedPreferences("Evaluation",MODE_PRIVATE);
        String Eval1 = getShared13.getString("school","The Score");

        SharedPreferences getShared14 = getSharedPreferences("Evaluation",MODE_PRIVATE);
        String Eval2 = getShared14.getString("car","The Score");

        SharedPreferences getShared15 = getSharedPreferences("Evaluation",MODE_PRIVATE);
        String Eval3 = getShared15.getString("trip","The Score");

        SharedPreferences getShared16 = getSharedPreferences("Evaluation",MODE_PRIVATE);
        String Eval4 = getShared16.getString("sport","The Score");

//        public void sendReferral(String appInstanceId, String desktopUrl, String uniqueIdentifier) {
//            if (NetworkUtil.getConnectivityStatus(this) == NetworkUtil.TYPE_NOT_CONNECTED) {
//                Toast.makeText(this, R.string.no_internet_message, Toast.LENGTH_SHORT).show();
//                return;
//            }

        userID = fAuth.getCurrentUser().getUid();

        DocumentReference documentReference1 = fstore.collection("users").document(userID).collection("Interpretation").document(userID);
        Map<String,Object> user1 = new HashMap<>();
        user1.put("Int1",Inter1);
        user1.put("Int2",Inter2);
        user1.put("Int3",Inter3);
        user1.put("Int4",Inter4);
        documentReference1.set(user1, SetOptions.merge());

        DocumentReference documentReference2 = fstore.collection("users").document(userID).collection("Analysis").document(userID);
        Map<String,Object> user2 = new HashMap<>();
        user2.put("Ana1",analysis1);
        user2.put("Ana2",analysis2);
        user2.put("Ana3",analysis3);
        user2.put("Ana4",analysis4);
        documentReference2.set(user2, SetOptions.merge());

        DocumentReference documentReference3 = fstore.collection("users").document(userID).collection("Inference").document(userID);
        Map<String,Object> user3 = new HashMap<>();
        user3.put("Inf1",Infer1);
        user3.put("Inf2",Infer2);
        user3.put("Inf3",Infer3);
        user3.put("Inf4",Infer4);
        documentReference3.set(user3, SetOptions.merge());

        DocumentReference documentReference4 = fstore.collection("users").document(userID).collection("Evaluation").document(userID);
        Map<String,Object> user4 = new HashMap<>();
        user4.put("Eva1",Eval1);
        user4.put("Eva2",Eval2);
        user4.put("Eva3",Eval3);
        user4.put("Eva4",Eval4);
        documentReference4.set(user4, SetOptions.merge());
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
                FirebaseAuth.getInstance().signOut();//logout
                super.onBackPressed();
            }
            case R.id.about:
                Toast.makeText(this, "About page is not available", Toast.LENGTH_SHORT).show();
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