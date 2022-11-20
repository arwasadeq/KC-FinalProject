package com.example.exptriate;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaCodec;
import android.os.Bundle;
import android.util.Patterns;
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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

public class signin extends AppCompatActivity implements View.OnClickListener {
    private TextView txetView9, textView10;
    private EditText editTextTextPersonName4, editTextTextPersonName2, editTextTextPersonName5, editTextTextPersonName6;
    private ProgressBar progressBar2;


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        mAuth = FirebaseAuth.getInstance();

        txetView9 = (TextView) findViewById(R.id.textView9);
        txetView9.setOnClickListener(this);

        textView10 = (TextView) findViewById(R.id.textView10);
        textView10.setOnClickListener(this);

        Button register = (Button) findViewById(R.id.button2);
        register.setOnClickListener(this::onClick);

        editTextTextPersonName4 = (EditText) findViewById(R.id.editTextTextPersonName4);
        editTextTextPersonName2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        editTextTextPersonName5 = (EditText) findViewById(R.id.editTextTextPersonName5);
        editTextTextPersonName6 = (EditText) findViewById(R.id.editTextTextPersonName6);

        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textView9:
                startActivity(new Intent(this, login.class));
                break;
            case R.id.button2:
                creatuser();

        }

    }

    private void creatuser() {
        String Email = editTextTextPersonName5.getText().toString().trim();
        String password = editTextTextPersonName6.getText().toString().trim();
        String fulname = editTextTextPersonName4.getText().toString().trim();
        String age = editTextTextPersonName2.getText().toString().trim();

        if (fulname.isEmpty()) {
            editTextTextPersonName4.setError("fulname is required!");
            editTextTextPersonName4.requestFocus();
            return;
        }
        if (age.isEmpty()) {
            editTextTextPersonName2.setError("age is required");
            editTextTextPersonName2.requestFocus();
            return;
        }
        if (Email.isEmpty()) {
            editTextTextPersonName5.setError("Email is required");
            editTextTextPersonName5.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            editTextTextPersonName6.setError("password is required");
            editTextTextPersonName6.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            editTextTextPersonName5.setError("please provide valid Email!");
            editTextTextPersonName5.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            editTextTextPersonName6.setError("password is required");
            editTextTextPersonName6.requestFocus();
            return;
        }
        if (password.length() < 6) {
            editTextTextPersonName6.setError("Min password should be 6 characters!");
            editTextTextPersonName6.requestFocus();
            return;
        }

        progressBar2.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(Email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            user user = new user(fulname, age, Email);

                            FirebaseDatabase.getInstance().getReference("users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {


                                            if (task.isSuccessful()) {
                                                Toast.makeText(signin.this, "user has been registered successfully", Toast.LENGTH_LONG).show();
                                                startActivity(new Intent(signin.this, login.class));
                                                progressBar2.setVisibility(View.GONE);

                                                // redirect to login Layout
                                            } else {
                                                Toast.makeText(signin.this, "faild to register! try again!", Toast.LENGTH_LONG).show();
                                                progressBar2.setVisibility(View.GONE);

                                            }
                                        }

                                    });
                        } else
                            Toast.makeText(signin.this, "faild to register! try again!", Toast.LENGTH_LONG).show();
                        progressBar2.setVisibility(View.GONE);
                    }


                });
    }};
