package com.example.habit_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button profileBtn;
    private Button goToAddHabitsBtn;

    private RecyclerView unfinishedHabitsRecycler;
    private RecyclerView finishedHabitsRecycler;

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter unfinishedHabitsAdapter;
    private RecyclerView.Adapter finishedHabitsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRecyclerViews();
        setButtons();
    }

    private void setButtons() {
        profileBtn.setOnClickListener(v -> {
            // TODO: Remove when required classes are implemented
            // startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        });
        goToAddHabitsBtn.setOnClickListener(v -> {
            // TODO: Remove when required classes are implemented
            // startActivity(new Intent(MainActivity.this, AddHabits.class));
        });
    }

    private void setRecyclerViews() {
        // TODO: Set recycler views and adapters

        layoutManager = new LinearLayoutManager(this);
    }
}