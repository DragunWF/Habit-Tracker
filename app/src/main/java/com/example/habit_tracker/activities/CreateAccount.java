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

public class CreateAccount extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private EditText repeatPassword;

    private Button goToLoginBtn;
    private Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        goToLoginBtn.setOnClickListener(v -> {
            toast(String.format("%s has successfully logged in!", Utils.getString(username)));
            startActivity(new Intent(CreateAccount.this, LogInAccount.class));
        });
        registerBtn.setOnClickListener(v -> register());
    }

    public void register() {
        if (Utils.isEmpty(username) || Utils.isEmpty(password) || Utils.isEmpty(repeatPassword)) {
            toast("Please do not leave any fields empty!");
        } else if (Utils.getString(password).equals(Utils.getString(repeatPassword))) {
            toast("Password and repeat password fields do not match");
        } else if (isUsernameExists()) {
            toast("Username already exists! Please use a different username");
        } else {
            longToast(String.format("%s has successfully logged in!", Utils.getString(username)));
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    public boolean isUsernameExists() {
        List<User> users = SessionData.getUsers();
        for (User user : users) {
            if (user.getUsername().equals(Utils.getString(username))) {
                return true;
            }
        }
        return false;
    }

    public void toast(String message) {
        Utils.toast(this, message);
    }

    public void longToast(String message) {
        Utils.longToast(this, message);
    }
}