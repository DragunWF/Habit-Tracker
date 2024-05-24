package com.example.habit_tracker.utils;

import com.example.habit_tracker.data.Habit;
import com.example.habit_tracker.data.User;

import java.util.List;

public class SessionData {
    private static User currentUser;
    private static List<User> users;
    private static List<Habit> habits;
    private static boolean initialize = false;

    public static void initialize() {
        if (!initialize) {
            initialize = true;
            // TODO: Get users from database and add them to users list
        }
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        SessionData.currentUser = currentUser;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        SessionData.users = users;
    }

    public static List<Habit> getHabits() {
        return habits;
    }

    public static void setHabits(List<Habit> habits) {
        SessionData.habits = habits;
    }

    public static boolean isInitialize() {
        return initialize;
    }

    public static void setInitialize(boolean initialize) {
        SessionData.initialize = initialize;
    }
}
