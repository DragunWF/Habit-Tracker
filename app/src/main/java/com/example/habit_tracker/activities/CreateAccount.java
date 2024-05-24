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
import com.example.habit_tracker.utils.Utils;

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
        } else {
            toast(String.format("%s has successfully logged in!", Utils.getString(username)));
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    public void toast(String message) {
        Utils.toast(this, message);
    }
}