package com.example.habit_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.habit_tracker.activities.AddHabitsActivity;
import com.example.habit_tracker.activities.ProfileActivity;
import com.example.habit_tracker.data.Habit;
import com.example.habit_tracker.utils.HabitRecycler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageView profileBtn;
    private FloatingActionButton goToAddHabitsBtn;

    private RecyclerView unfinishedHabitsRecycler;
    private RecyclerView finishedHabitsRecycler;

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter unfinishedHabitsAdapter;
    private RecyclerView.Adapter finishedHabitsAdapter;

    private List<Habit> unfinishedHabits = new ArrayList<>();
    private List<Habit> finishedHabits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileBtn = findViewById(R.id.profileBtn);
        goToAddHabitsBtn = findViewById(R.id.addHabitsBtn);

        setRecyclerViews();
        setButtons();
    }

    private void setButtons() {
        profileBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        });
        goToAddHabitsBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AddHabitsActivity.class));
        });
    }

    private void setRecyclerViews() {
        unfinishedHabitsRecycler = findViewById(R.id.unfinishedRecycleView);
        finishedHabits = findViewById(R.id.completedRecycleView);

        unfinishedHabitsRecycler.setHasFixedSize(true);
        finishedHabitsRecycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        unfinishedHabitsRecycler.setLayoutManager(layoutManager);
        finishedHabitsRecycler.setLayoutManager(layoutManager);

        unfinishedHabitsAdapter = new HabitRecycler(unfinishedHabits);
        finishedHabitsAdapter = new HabitRecycler(finishedHabits);

        unfinishedHabitsRecycler.setAdapter(unfinishedHabitsAdapter);
        finishedHabitsRecycler.setAdapter(finishedHabitsAdapter);
    }
}