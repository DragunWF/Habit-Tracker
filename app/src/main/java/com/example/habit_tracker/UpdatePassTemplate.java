package com.example.habit_tracker;

import android.widget.Button;
import android.widget.EditText;

import com.example.habit_tracker.utils.Utils;

public class UpdatePassTemplate {
    private EditText newPassword;
    private EditText repeatPassword;
    private Button updateBtn;

    public void start() {
        // newPassword = findViewById(R.id.);
        // repeatPassword = findViewById(R.id.);
        // updateBtn = findViewById(R.id.);

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
        // Utils.toast(this, message);
    }
}
