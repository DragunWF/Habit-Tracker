package com.example.habit_tracker;

import android.widget.Button;
import android.widget.TextView;

import com.example.habit_tracker.utils.SessionData;

public class ProfileTemplate {
    private TextView username;
    private Button changePasswordBtn;
    private Button logOutBtn;

    public void start() {
        // username = findViewById(R.id.);
        // changePasswordBtn = findViewById(R.id.);
        // logOutBtn = findViewById(R.id.);

        changePasswordBtn.setOnClickListener(v -> {
            // startActivity(new Intent(ProfileActivity.this, UpdateUser.class);
        });
        logOutBtn.setOnClickListener(v -> {
            // Utils.toast(ProfileActivity.this, "You have successfully logged out!");
            SessionData.logOut();
            // startActivity(new Intent(ProfileActivity.this, LogInAccount.class);
        });
    }
}
