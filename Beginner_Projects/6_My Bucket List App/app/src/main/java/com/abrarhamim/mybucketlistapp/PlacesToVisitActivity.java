package com.abrarhamim.mybucketlistapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class PlacesToVisitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_to_visit);

        setUpList();

    }

    private void setUpList() {
        RecyclerView list = findViewById(R.id.recycler_view_places_to_visit);

        BucketListEntry[] lists = {
                new BucketListEntry("South Korea", "Experience the vibrant culture, K-pop, and historic palaces in Seoul.", R.drawable.south_korea, 5),
                new BucketListEntry("Iceland", "Witness the natural beauty of geysers, volcanoes, and the Northern Lights.", R.drawable.iceland, 5),
                new BucketListEntry("Japan", "Immerse yourself in the unique blend of traditional culture and modern technology.", R.drawable.japan, 5),
                new BucketListEntry("Norway", "Explore the stunning fjords, picturesque landscapes, and the midnight sun.", R.drawable.norway, 5),
                new BucketListEntry("Vietnam", "Discover the vibrant street food, bustling markets, and stunning landscapes.", R.drawable.vietnam, 4.5f)
        };

        BucketListEntryAdapter adapter = new BucketListEntryAdapter(lists);
        list.setAdapter(adapter);
    }
}