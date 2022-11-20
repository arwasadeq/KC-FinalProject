package com.example.exptriate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class slide3 extends AppCompatActivity {
    ArrayList<shapes> shapelist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide3);

        shapes Malware = new shapes("Malware", R.drawable.malware, "هندسة كمبيوتر");
        shapes Statistics = new shapes("Statistics", R.drawable.statistics, "الاحصاء");
        shapes Mathematics = new shapes("Mathematics", R.drawable.mathematics, "رياضيات");
        shapes Excel_VBA = new shapes("Excel_VBA", R.drawable.excel, "هندسة كمبيوتر");
        shapes Engineering = new shapes("Engineering", R.drawable.engineering, "هندسة معمارية");
        shapes Aviation = new shapes("Aviation", R.drawable.aviationcon, "هندسة الطيران");

        shapelist.add(Malware);
        shapelist.add(Statistics);
        shapelist.add(Mathematics);
        shapelist.add(Excel_VBA);
        shapelist.add(Engineering);
        shapelist.add(Aviation);

        shapeadapter shapeadapter = new shapeadapter(this, 0, shapelist);
        ListView listView = findViewById(R.id.Library);
        listView.setAdapter(shapeadapter);






    }
}