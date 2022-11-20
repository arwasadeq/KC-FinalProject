package com.example.exptriate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

import java.util.Timer;
import java.util.TimerTask;

public class login extends AppCompatActivity implements View.OnClickListener {
    private TextView register;
    private EditText editTextTextPersonName, editTextTextPersonName3;
    private Button login;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register =(TextView) findViewById(R.id.textView8);
        register.setOnClickListener(this);

        login = (Button) findViewById(R.id.button4);
        login.setOnClickListener(this);

        editTextTextPersonName = (EditText) findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName3 = (EditText) findViewById(R.id.editTextTextPersonName3);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        mAuth = FirebaseAuth.getInstance();


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textView8:
            startActivity(new Intent(login.this, signin.class));
                break;

            case R.id.button4:
                userlogin();
                break;

        }


    }

    private void userlogin() {

        String email = editTextTextPersonName.getText().toString().trim();
        String password = editTextTextPersonName3.getText().toString().trim();

        if (email.isEmpty()){
            editTextTextPersonName.setError("email is required!");
            editTextTextPersonName.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextTextPersonName.setError("please enter a valid email");
            editTextTextPersonName.requestFocus();
            return;
        }

        if (password.isEmpty()){
            editTextTextPersonName3.setError("password is required");
            editTextTextPersonName3.requestFocus();
            return;
        }

        if (password.length() < 6){
            editTextTextPersonName3.setError("Min password length is 6 charactars!");
            editTextTextPersonName3.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                
                if (task.isSuccessful()){
                    // redirect to user profile
                    startActivity(new Intent(login.this, slides.class));
                    
                }else {
                    Toast.makeText(login.this, "failed to login! please check your credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
