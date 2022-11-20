package com.example.exptriate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exptriate.databinding.ActivityMainBinding;

public class home extends AppCompatActivity {

    ActivityMainBinding binding;
     private Button button;
     private EditText editText;
     private EditText editText2;
     private EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        button = (Button) findViewById(R.id.sendbtn);
        editText = (EditText) findViewById(R.id.emailaddress);
        editText2 = (EditText) findViewById(R.id.message);
        editText3 = (EditText) findViewById(R.id.subject);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    String email = editText.getText().toString();
                    String message = editText2.getText().toString();
                    String sendbtn = button.getText().toString();
                    String subject = editText3.getText().toString();

                    String[] address = email.split(",");

                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("mailto"));
                        intent.putExtra(Intent.EXTRA_EMAIL, address);
                        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
                        intent.putExtra(Intent.EXTRA_TEXT,message);

                        if (intent.resolveActivity(getPackageManager()) != null){
                            startActivity(intent);
                        }else {
                            Toast.makeText(home.this, "No App is Installed", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
    }
}