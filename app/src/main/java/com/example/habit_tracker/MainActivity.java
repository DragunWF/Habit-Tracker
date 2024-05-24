package com.example.habit_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button profileBtn;
    private Button goToAddHabitsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileBtn.setOnClickListener(v -> {
            // TODO: Remove when required classes are implemented
            // startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        });
        goToAddHabitsBtn.setOnClickListener(v -> {
            // TODO: Remove when required classes are implemented
            // startActivity(new Intent(MainActivity.this, AddHabits.class));
        });
    }
}