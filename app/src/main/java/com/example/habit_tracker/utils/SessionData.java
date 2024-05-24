package com.example.habit_tracker.utils;

public class SessionData {
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        SessionData.currentUser = currentUser;
    }
}
