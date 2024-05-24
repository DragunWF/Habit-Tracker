package com.example.habit_tracker.data;

public class Habit {
    private int habitID;
    private String name;
    private String description;
    private String time;
    private String schedule;
    private int userID;
    private String status;

    public Habit(int habitID, String name, String description, String time, String schedule, int userID, String status) {
        this.habitID = habitID;
        this.name = name;
        this.description = description;
        this.time = time;
        this.schedule = schedule;
        this.userID = userID;
        this.status = status;
    }

    public Habit(String name, String description, String time, String schedule, int userID, String status) {
        this.name = name;
        this.description = description;
        this.time = time;
        this.schedule = schedule;
        this.userID = userID;
        this.status = status;
    }

    public Habit(int habitID, String description, String name, int userID) {
        this.habitID = habitID;
        this.description = description;
        this.name = name;
        this.userID = userID;
    }

    public int getHabitID() {
        return habitID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
