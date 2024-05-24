package com.example.habit_tracker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.habit_tracker.MainActivity;
import com.example.habit_tracker.R;
import com.example.habit_tracker.utils.SessionData;
import com.example.habit_tracker.utils.Utils;

public class LogInAccount extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button loginBtn;
    private Button createAccountBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_account);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SessionData.initialize();

        createAccountBtn.setOnClickListener(v -> {
            // TODO: Remove when implemented
            // startActivity(LogInAccount.this, SignInActivity.class);
        });
    }

    public void login() {
        if (Utils.isEmpty(username) || Utils.isEmpty(password)) {
            toast("Please do not leave any fields empty!");
        } else {
            toast(String.format("Welcome to Habit Tracker! %s", Utils.getString(username)));
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    public void toast(String message) {
        Utils.toast(this, message);
    }
}