package com.example.exptriate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class slide2 extends AppCompatActivity {

    Button button;
    Button button2;
    Button button3;
    Button button4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide2);

        button = (Button) findViewById(R.id.button7);
        button2 = (Button) findViewById(R.id.button6);
        button3 = (Button) findViewById(R.id.button5);
        button4 = (Button) findViewById(R.id.button8);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity3();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openactivity3();{
                Intent intent2 = new Intent(slide2.this, home.class);
                startActivity(intent2);
            }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openactivity3();{
                Intent intent3 = new Intent(slide2.this, map_class.class);
                startActivity(intent3);
            }

            }
        });

    }
    public void openactivity3(){
        Intent intent = new Intent(this, slide3.class);
        startActivity(intent);
    }



    }
