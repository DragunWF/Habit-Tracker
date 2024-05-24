package com.example.habit_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.habit_tracker.data.Habit;
import com.example.habit_tracker.utils.HabitRecycler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button profileBtn;
    private Button goToAddHabitsBtn;

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