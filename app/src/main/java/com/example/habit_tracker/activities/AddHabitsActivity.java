package com.example.habit_tracker.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.habit_tracker.R;

public class AddHabitsActivity extends AppCompatActivity {
    private EditText name;
    private EditText description;
    private Button addHabitBtn;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habits);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // name = findViewById(R.id.);
        // description = findViewById(R.id.);

        // addHabitBtn = findViewById(R.id.);
        // backBtn = findViewById(R.id.);

        // addHabitBtn.setOnClickListener(v -> {});
        // backBtn.setOnClickListener(v -> finish());
    }
}