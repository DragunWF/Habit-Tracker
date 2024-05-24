package com.example.habit_tracker.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.habit_tracker.R;
import com.example.habit_tracker.data.DatabaseHelper;
import com.example.habit_tracker.data.Habit;
import com.example.habit_tracker.utils.SessionData;
import com.example.habit_tracker.utils.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddHabitsActivity extends AppCompatActivity {
    private EditText name;
    private EditText description;
    private Button addHabitBtn;
    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habits);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = findViewById(R.id.addHabitsName);
        description = findViewById(R.id.addHabitsDesc);

        addHabitBtn = findViewById(R.id.addHabitsBtn1);
        backBtn = findViewById(R.id.backBtn);

        setButtons();
    }

    @SuppressLint("SimpleDateFormat")
    private void setButtons() {
        addHabitBtn.setOnClickListener(v -> {
            if (Utils.isEmpty(name) || Utils.isEmpty(description)) {
                toast("Please do not leave any fields empty!");
            } else {
                DatabaseHelper db = new DatabaseHelper(AddHabitsActivity.this);
                db.addHabit(new Habit(
                        Utils.getString(name), Utils.getString(description),
                        new SimpleDateFormat("hh:mm").format(new Date()),
                        new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
                        SessionData.getCurrentUser().getUserID(), "unfinished"
                ));
            }
        });
        backBtn.setOnClickListener(v -> finish());
    }

    private void toast(String message) {
        Utils.toast(this, message);
    }
}