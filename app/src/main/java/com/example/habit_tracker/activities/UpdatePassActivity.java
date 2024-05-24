package com.example.habit_tracker.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.habit_tracker.R;
import com.example.habit_tracker.utils.Utils;

public class UpdatePassActivity extends AppCompatActivity {
    private EditText newPassword;
    private EditText repeatPassword;
    private Button updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_pass);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        newPassword = findViewById(R.id.updateNewPass);
        repeatPassword = findViewById(R.id.updateRepeatPass);
        updateBtn = findViewById(R.id.updatePassBtn1);

        updateBtn.setOnClickListener(v -> {
            if (Utils.isEmpty(newPassword) || Utils.isEmpty(repeatPassword)) {
                toast("Please do not leave any fields empty!");
            } else if (!Utils.getString(newPassword).equals(Utils.getString(repeatPassword))) {
                toast("New password and repeat password fields do not match!");
            } else {
                newPassword.setText("");
                repeatPassword.setText("");
                toast("You have successfully changed your password!");
            }
        });
    }

    private void toast(String message) {
        Utils.toast(this, message);
    }
}