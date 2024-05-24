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
import com.example.habit_tracker.data.User;
import com.example.habit_tracker.utils.SessionData;
import com.example.habit_tracker.utils.Utils;

import java.util.List;

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

        username = findViewById(R.id.usernameLogin);
        password = findViewById(R.id.passwordLogin);
        loginBtn = findViewById(R.id.logInBtn);
        // createAccountBtn = findViewById(R.id.);

        loginBtn.setOnClickListener(v -> login());
        createAccountBtn.setOnClickListener(v -> {
            // TODO: Remove when implemented
            // startActivity(LogInAccount.this, SignInActivity.class);
        });
    }

    public void login() {
        if (Utils.isEmpty(username) || Utils.isEmpty(password)) {
            toast("Please do not leave any fields empty!");
        } else if (!isUserMatch()) {
            toast("Username and password does not match!");
        } else {
            toast(String.format("Welcome to Habit Tracker! %s", Utils.getString(username)));
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    public boolean isUserMatch() {
        List<User> users = SessionData.getUsers();
        for (User user : users) {
            if (user.getUsername().equals(Utils.getString(username)) &&
                    user.getPassword().equals(Utils.getString(password))) {
                SessionData.setCurrentUser(user);
                return true;
            }
        }
        return false;
    }

    public void toast(String message) {
        Utils.toast(this, message);
    }
}