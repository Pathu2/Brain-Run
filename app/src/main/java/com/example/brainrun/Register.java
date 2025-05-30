package com.example.brainrun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import android.widget.Spinner;
import android.widget.ArrayAdapter;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.CollectionReference;

import kotlin.collections.ArrayDeque;


public class Register extends AppCompatActivity {

    EditText mFullName,mEmail,mPassword,mPhone;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    ProgressBar progressBar;
    String userID;
    Spinner mSchoolSpinner;
    TextView schoolLabel;

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
        mSchoolSpinner = findViewById(R.id.school);
        schoolLabel = findViewById(R.id.schoolLabel);
        schoolLabel.setText("Select your school");

        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        progressBar = findViewById(R.id.progressBar);

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        loadSchools();

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                final String fullName = mFullName.getText().toString();
                final String phone    = mPhone.getText().toString();
                final String selectedSchool = mSchoolSpinner.getSelectedItem().toString();

                if (selectedSchool.equals("Select your school")) {
                    Toast.makeText(Register.this, "Please select a school.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required.");
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
                            user.put("school", selectedSchool);

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
                            documentReference2.set(user2);
                            Map<String,Object> user3 = new HashMap<>();
                            documentReference3.set(user3);
                            Map<String,Object> user4 = new HashMap<>();
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

    private void loadSchools() {
        DocumentReference schoolsDocRef = fstore.collection("variables").document("schools");
        schoolsDocRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null && document.exists()) {
                        List<String> schoolList = (List<String>) document.get("schools");
                        if (schoolList != null) {
                            schoolList.add("Others");
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(Register.this, android.R.layout.simple_spinner_item, schoolList);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            mSchoolSpinner.setAdapter(adapter);
                        }
                    }
                }
            }
        });
    }
}