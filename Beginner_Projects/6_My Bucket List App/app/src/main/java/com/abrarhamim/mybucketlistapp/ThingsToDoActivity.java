package com.abrarhamim.mybucketlistapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ThingsToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_things_to_do);

        setUpList();

    }

    private void setUpList() {
        RecyclerView list_thingsToDo = findViewById(R.id.recycler_view_things_to_do);

        BucketListEntry[] lists = {
                new BucketListEntry("Kilimanjaro", "Do it the difficult way!", R.drawable.kilimanjaro, 5),
                new BucketListEntry("Northern Lights", "Experience the magic of the aurora borealis in the Arctic Circle", R.drawable.northern_lights, 4),
                new BucketListEntry("Trek to Bandarban", "Explore the hill tracks of Bangladesh and experience indigenous cultures", R.drawable.bandarban, 3.5f),
                new BucketListEntry("Mount Fuji", "Climb Japan's iconic mountain and experience the sunrise from the summit.", R.drawable.mount_fuji, 5),
                new BucketListEntry("Visit Cappadocia", "Take a hot air balloon ride over the unique rock formations and fairy chimneys", R.drawable.cappadocia, 4.5f),
                new BucketListEntry("Saint Moritz", "Experience world-class skiing and luxury in the heart of the Swiss Alps.", R.drawable.saint_moritz, 5)
        };

        BucketListEntryAdapter adapter = new BucketListEntryAdapter(lists);
        list_thingsToDo.setAdapter(adapter);
    }
}