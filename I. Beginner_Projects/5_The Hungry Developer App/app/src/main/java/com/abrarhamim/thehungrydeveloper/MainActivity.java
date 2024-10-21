package com.abrarhamim.thehungrydeveloper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    CardView startersCard;
    CardView mainsCard;
    CardView dessertCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startersCard = findViewById(R.id.card_view_starters);
        mainsCard = findViewById(R.id.card_view_main);
        dessertCard = findViewById(R.id.card_view_dessert);

        startersCard.setOnClickListener(v -> {

            Intent startersActivityIntent = new Intent(MainActivity.this, StartersActivity.class);

            startActivity(startersActivityIntent);
        });

        mainsCard.setOnClickListener(v -> {
            Intent mainCoursesActivityIntent = new Intent(MainActivity.this, MainCoursesActivity.class);

            startActivity(mainCoursesActivityIntent);
        });

        dessertCard.setOnClickListener(v -> {
            Intent dessertsActivityIntent = new Intent(MainActivity.this, DessertsActivity.class);

            startActivity(dessertsActivityIntent);
        });

        // An 'implicit intent' to open the gmail app
        TextView emailTextView = findViewById(R.id.text_view_email_address);
        emailTextView.setOnClickListener(v -> {
            Intent launchEmailAppIntent = new Intent(Intent.ACTION_SENDTO);
            launchEmailAppIntent.setData(Uri.parse("mailto:thehungrydeveloper@abrarhamim.com"));

            startActivity(launchEmailAppIntent);
        });
    }
}