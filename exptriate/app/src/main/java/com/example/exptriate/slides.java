package com.example.exptriate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class slides extends AppCompatActivity {

    Spinner spinner;
    String[] country = {"Britain","Japan","Almanya","Turkey","Chaina","France","America"};


    private Button button6;

    public void openactivity_slide2() {
        Intent intent = new Intent(this, slide2.class);
        startActivity(intent);}
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_slides);

                button6 = findViewById(R.id.button6);
                spinner = findViewById(R.id.spliner);

                ArrayAdapter<String> adapter=new ArrayAdapter<String>(slides.this, R.layout.item_file,country);
                adapter.setDropDownViewResource(R.layout.item_file);
                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        String value=adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(slides.this, value, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

                button6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        Intent intent = new Intent(slides.this, slide2.class);
                        openactivity_slide2();
                    }});
                            }
                        }



