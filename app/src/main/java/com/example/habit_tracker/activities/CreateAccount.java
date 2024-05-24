package com.example.habit_tracker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.habit_tracker.MainActivity;
import com.example.habit_tracker.R;
import com.example.habit_tracker.data.DatabaseHelper;
import com.example.habit_tracker.data.User;
import com.example.habit_tracker.utils.SessionData;
import com.example.habit_tracker.utils.Utils;

import java.util.List;

public class CreateAccount extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private EditText repeatPassword;

    private TextView goToLoginBtn;
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

        username = findViewById(R.id.usernameSignUp);
        password = findViewById(R.id.passwordSignUp);
        repeatPassword = findViewById(R.id.repeatPassSignUp);

        goToLoginBtn = findViewById(R.id.logInTextBtn);
        registerBtn = findViewById(R.id.signUpBtn);

        setButtons();
    }

    public void register() {
        if (Utils.isEmpty(username) || Utils.isEmpty(password) || Utils.isEmpty(repeatPassword)) {
            toast("Please do not leave any fields empty!");
        } else if (Utils.getString(password).equals(Utils.getString(repeatPassword))) {
            password.setText("");
            repeatPassword.setText("");
            toast("Password and repeat password fields do not match");
        } else if (isUsernameExists()) {
            toast("Username already exists! Please use a different username");
        } else {
            new DatabaseHelper(this).addUser(new User(
                    Utils.getString(username), Utils.getString(password)
            ));
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

    private void setButtons() {
        goToLoginBtn.setOnClickListener(v -> {
            toast(String.format("%s has successfully logged in!", Utils.getString(username)));
            startActivity(new Intent(CreateAccount.this, LogInAccount.class));
        });
        registerBtn.setOnClickListener(v -> register());
    }

    public void toast(String message) {
        Utils.toast(this, message);
    }

    public void longToast(String message) {
        Utils.longToast(this, message);
    }
}