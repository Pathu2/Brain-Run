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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    String data1 = MainActivity.getData();

    EditText mEmail,mPassword;
    Button mLoginBtn,createNew,createBtn2;
    TextView mCreateBtn,forgotTextLink,forgot,tex;
    ProgressBar progressBar;
    FirebaseAuth fAuth;


    @Override
    public void onBackPressed() {
        if(forgot.getVisibility() == View.INVISIBLE){
            mPassword.setVisibility(View.VISIBLE);
            mLoginBtn.setVisibility(View.VISIBLE);
            createNew.setVisibility(View.VISIBLE);
            forgot.setVisibility(View.VISIBLE);
            createBtn2.setVisibility(View.INVISIBLE);
            tex.setVisibility(View.INVISIBLE);
            mEmail.setText("");
        }else{
            super.onBackPressed();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        mEmail = findViewById(R.id.Email);
        tex = findViewById(R.id.textView20);
        mPassword = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar2);
        fAuth = FirebaseAuth.getInstance();
        mLoginBtn = findViewById(R.id.loginBtn);
        createNew = findViewById(R.id.createBtn);
        forgot = findViewById(R.id.textView16);
        createBtn2 = findViewById(R.id.createBtn2);
        //mCreateBtn = findViewById(R.id.createText);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required.");
                    return;
                }
                if(password.length() < 6){
                    mPassword.setError("Password Must be >= 6 Characters");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                // authenticate the user
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Register.class));
                            mEmail.setText("");
                            mPassword.setText("");
                            progressBar.setVisibility(View.INVISIBLE);
                        }else {
                            Toast.makeText(Login.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }

                    }
                });

            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPassword.setVisibility(View.INVISIBLE);
                mLoginBtn.setVisibility(View.INVISIBLE);
                createNew.setVisibility(View.INVISIBLE);
                forgot.setVisibility(View.INVISIBLE);
                createBtn2.setVisibility(View.VISIBLE);
                tex.setVisibility(View.VISIBLE);
            }
        });
        createBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                Log.d("testing", "Reset Password is sent on " + email);

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required.");
                    return;
                }else{
                    mPassword.setVisibility(View.VISIBLE);
                    mLoginBtn.setVisibility(View.VISIBLE);
                    createNew.setVisibility(View.VISIBLE);
                    forgot.setVisibility(View.VISIBLE);
                    createBtn2.setVisibility(View.INVISIBLE);
                    tex.setVisibility(View.INVISIBLE);
                    mEmail.setText("");
                }
                //String emailAddress = "user@example.com";
                fAuth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Login.this, "Password is sent on your email "+email, Toast.LENGTH_SHORT).show();
                                    Log.d("testing", "Email sent.");
                                }
                                else{
                                    Log.d("testing","not worked "+ task);
                                }
                            }
                        });
            }
        });
        createNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });

//        if (Integer.parseInt(data1) == 1){
//            super.onBackPressed();
//        }
        if(fAuth.getCurrentUser() != null){
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }

    }
}