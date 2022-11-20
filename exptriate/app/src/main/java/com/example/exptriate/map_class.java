package com.example.exptriate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class map_class extends AppCompatActivity {

    EditText etsoure, etdestination;
    Button bttrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_class);

        etsoure = (EditText) findViewById(R.id.et_source);
        etdestination = (EditText) findViewById(R.id.et_destination);
        bttrack = (Button) findViewById(R.id.bt_track);

        bttrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sSource = etsoure.getText().toString().trim();
                String sdestination = etdestination.getText().toString().trim();

                if (sSource.equals("") && sdestination.equals("")){

                    Toast.makeText(getApplicationContext(), "Enter both location",Toast.LENGTH_SHORT).show();
                }else {

                    DisplayTrack(sSource,sdestination);

                }
            }
        });


    }

    private void DisplayTrack(String sSource, String sdestination) {
      try {
          Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + sSource + "/" + sdestination);

          Intent intent = new Intent(Intent.ACTION_VIEW,uri);
          intent.setPackage("com.google.android.apps.maps");
          intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          startActivity(intent);
      }catch (ActivityNotFoundException e){

          Uri uri = Uri.parse("https://play.google.com/store/apps/details?=com.google.android.apps.maps");

          Intent intent = new Intent(Intent.ACTION_VIEW,uri);
          intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          startActivity(intent);

      }

    }
}