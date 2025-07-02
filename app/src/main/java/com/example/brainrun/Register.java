package com.example.brainrun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    EditText mFullName,mEmail,mPassword,mPhone;
    Button mRegisterBtn;
    TextView mLoginBtn;
    Spinner mSchoolsSpinner;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    ProgressBar progressBar;
    String userID;
    List<String> schoolsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        mFullName   = findViewById(R.id.fullName);
        mEmail      = findViewById(R.id.Email);
        mPassword   = findViewById(R.id.password);
        mPhone      = findViewById(R.id.phone);
        mRegisterBtn= findViewById(R.id.registerBtn);
        mLoginBtn   = findViewById(R.id.createText);
        mSchoolsSpinner = findViewById(R.id.schoolsSpinner);

        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        progressBar = findViewById(R.id.progressBar);
        schoolsList = new ArrayList<>();
        // Add a default item
        schoolsList.add("Select a school");

        // Fetch schools from Firebase
        fstore.collection("variables").document("schools")
            .get()
            .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists() && document.get("schools") != null) {
                            List<String> schools = (List<String>) document.get("schools");
                            if (schools != null && !schools.isEmpty()) {
                                schoolsList.clear(); // Clear the default item
                                schoolsList.addAll(schools);
                                ArrayAdapter<String> adapter = new ArrayAdapter<>(Register.this,
                                    android.R.layout.simple_spinner_item, schoolsList);
                                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                mSchoolsSpinner.setAdapter(adapter);
                            } else {
                                Toast.makeText(Register.this, "No schools available", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Register.this, "No schools data found", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Log.d("Register", "Error getting schools: ", task.getException());
                        Toast.makeText(Register.this, "Error loading schools", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                final String fullName = mFullName.getText().toString();
                final String phone    = mPhone.getText().toString();
                final String school   = mSchoolsSpinner.getSelectedItem().toString();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required.");
                    return;
                }
                if(school.equals("Select a school")){
                    Toast.makeText(Register.this, "Please select a school", Toast.LENGTH_SHORT).show();
                    return;
                }

                String regex = "^(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{9,}$";
                Pattern pattern = Pattern.compile(regex);
                if (!pattern.matcher(password).matches()) {
                    mPassword.setError("Password must contain at least one capital letter, one special character, and be greater than 8 characters.");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.d("testing","User created successfully");
                            //Toast.makeText(Register.this, "User Created " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fstore.collection("users").document(userID);
                            DocumentReference documentReference1 = fstore.collection("users").document(userID).collection("What's Next").document(userID);
                            DocumentReference documentReference2 = fstore.collection("users").document(userID).collection("Curious Sam").document(userID);
                            DocumentReference documentReference3 = fstore.collection("users").document(userID).collection("Blake's Adventure").document(userID);
                            DocumentReference documentReference4 = fstore.collection("users").document(userID).collection("Perfect Estimation").document(userID);

                            Map<String,Object> user = new HashMap<>();
                            user.put("fname",fullName);
                            user.put("email",email);
                            user.put("phone",phone);
                            user.put("id",userID);
                            user.put("school",school);

                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d("testing","User Profile is created for "+ userID );
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d("testing", "On fail "+ e.toString());
                                }
                            });

                            Map<String,Object> user1 = new HashMap<>();
                            user1.put("Adam's Day","0");
                            user1.put("Cia's Surprise","0");
                            user1.put("Dane's Drawing","0");
                            user1.put("John and Norman","0");

                            user1.put("Max Adam's Day","0");
                            user1.put("Max Cia's Surprise","0");
                            user1.put("Max Dane's Drawing","0");
                            user1.put("Max John and Norman","0");

                            user1.put("Min Adam's Day","-1");
                            user1.put("Min Cia's Surprise","-1");
                            user1.put("Min Dane's Drawing","-1");
                            user1.put("Min John and Norman","-1");

                            user1.put("Number of Attempts Adam's Day","0");
                            user1.put("Number of Attempts Cia's Surprise","0");
                            user1.put("Number of Attempts Dane's Drawing","0");
                            user1.put("Number of Attempts John and Norman","0");

// Adding total fields
                            user1.put("Adam's Day Total", "0");
                            user1.put("Cia's Surprise Total", "0");
                            user1.put("Dane's Drawing Total", "0");
                            user1.put("John and Norman Total", "0");


                            documentReference1.set(user1).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d("testing","Inference Profile is created for "+ userID );
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d("testing","Inference Profile is not created for "+ userID );
                                }
                            });
                            Map<String,Object> user2 = new HashMap<>();
                            user2.put("Bank Thief","0");
                            user2.put("Playing with Graphs","0");
                            user2.put("Riddles","0");
                            user2.put("Odd One Out","0");

                            user2.put("Min Bank Thief","-1");
                            user2.put("Max Bank Thief","0");
                            user2.put("Number of Attempts Bank Thief","0");

                            user2.put("Min Playing with Graphs","-1");
                            user2.put("Max Playing with Graphs","0");
                            user2.put("Number of Attempts Playing with Graphs","0");

                            user2.put("Min Riddles","-1");
                            user2.put("Max Riddles","0");
                            user2.put("Number of Attempts Riddles","0");

                            user2.put("Min Odd One Out","-1");
                            user2.put("Max Odd One Out","0");
                            user2.put("Number of Attempts Odd One Out","0");

                            user2.put("Bank Thief Total", "0");
                            user2.put("Playing with Graphs Total", "0");
                            user2.put("Riddles Total", "0");
                            user2.put("Odd One Out Total", "0");


                            documentReference2.set(user2);
                            Map<String,Object> user3 = new HashMap<>();
                            user3.put("Blake's Boxes","0");
                            user3.put("Detective Blake","0");
                            user3.put("Graphical Night","0");
                            user3.put("Sunday's Game","0");

                            user3.put("Min Blake's Boxes","-1");
                            user3.put("Max Blake's Boxes","0");
                            user3.put("Number of Attempts Blake's Boxes","0");

                            user3.put("Min Detective Blake","-1");
                            user3.put("Max Detective Blake","0");
                            user3.put("Number of Attempts Detective Blake","0");

                            user3.put("Min Graphical Night","-1");
                            user3.put("Max Graphical Night","0");
                            user3.put("Number of Attempts Graphical Night","0");

                            user3.put("Min Sunday's Game","-1");
                            user3.put("Max Sunday's Game","0");
                            user3.put("Number of Attempts Sunday's Game","0");

                            user3.put("Blake's Boxes Total", "0");
                            user3.put("Detective Blake Total", "0");
                            user3.put("Graphical Night Total", "0");
                            user3.put("Sunday's Game Total", "0");


                            documentReference3.set(user3);
                            Map<String,Object> user4 = new HashMap<>();
                            user4.put("Chaos at School","0");
                            user4.put("Peter's Dilemma","0");
                            user4.put("Ben's Trip","0");
                            user4.put("Football Match","0");

                            user4.put("Min Chaos at School","-1");
                            user4.put("Max Chaos at School","0");
                            user4.put("Number of Attempts Chaos at School","0");

                            user4.put("Min Peter's Dilemma","-1");
                            user4.put("Max Peter's Dilemma","0");
                            user4.put("Number of Attempts Peter's Dilemma","0");

                            user4.put("Min Ben's Trip","-1");
                            user4.put("Max Ben's Trip","0");
                            user4.put("Number of Attempts Ben's Trip","0");

                            user4.put("Min Football Match","-1");
                            user4.put("Max Football Match","0");
                            user4.put("Number of Attempts Football Match","0");

                            user4.put("Chaos at School Total", "0");
                            user4.put("Peter's Dilemma Total", "0");
                            user4.put("Ben's Trip Total", "0");
                            user4.put("Football Match Total", "0");


                            documentReference4.set(user4);

                            startActivity(new Intent(getApplicationContext(),Login.class));


                        }else {
                            Log.d("testing","Error in creating new user");
                            Toast.makeText(Register.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });


            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }
}