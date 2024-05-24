package com.example.habit_tracker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.habit_tracker.R;
import com.example.habit_tracker.utils.SessionData;
import com.example.habit_tracker.utils.Utils;

public class ProfileActivity extends AppCompatActivity {
    private TextView username;
    private Button changePasswordBtn;
    private Button logOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.displayUsername);
        changePasswordBtn = findViewById(R.id.updatePassBtn);
        logOutBtn = findViewById(R.id.logoutBtn);

        changePasswordBtn.setOnClickListener(v -> {
            startActivity(new Intent(ProfileActivity.this, UpdatePassActivity.class));
        });
        logOutBtn.setOnClickListener(v -> {
            Utils.toast(ProfileActivity.this, "You have successfully logged out!");
            SessionData.logOut();
            startActivity(new Intent(ProfileActivity.this, LogInAccount.class));
        });
    }
}