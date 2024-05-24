package com.example.habit_tracker.utils;

import com.example.habit_tracker.data.User;

public class SessionData {
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        SessionData.currentUser = currentUser;
    }
}
