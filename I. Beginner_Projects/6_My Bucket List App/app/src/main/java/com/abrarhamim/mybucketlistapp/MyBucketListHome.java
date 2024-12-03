package com.abrarhamim.mybucketlistapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MyBucketListHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupClickListeners();
        
    }

    private void setupClickListeners() {
        CardView thingsToDoCard = findViewById(R.id.card_view_things_to_do);
        CardView placesToGoCard = findViewById(R.id.card_view_places_to_go);

        thingsToDoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyBucketListHome.this, ThingsToDoActivity.class);
                startActivity(intent);
            }
        });

        //Random git push
        //Random git push
        placesToGoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyBucketListHome.this, PlacesToVisitActivity.class);
                startActivity(intent);
            }
        });
    }
}