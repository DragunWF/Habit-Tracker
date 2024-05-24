package com.example.habit_tracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.se.omapi.Session;

import androidx.annotation.Nullable;

import com.example.habit_tracker.utils.SessionData;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    //------TABLES-------
    private final String USER_TBL = "user_tbl";
    private final String HABIT_TBL = "habit_tbl";
    private final String UNFINISHED_TBL = "unfinished_tbl";
    private final String COMPLETED_TBL = "completed_tbl";
    //------TABLES-------
    //------USER-COLUMNS-------
    private final String USER_ID_PK = "user_id";
    private final String USERNAME = "username";
    private final String PASSWORD = "password";
    //------USER-COLUMNS-------
    //------HABIT-COLUMNS-------
    private final String HABIT_ID_PK = "habit_id";
    private final String NAME = "name";
    private final String DESCRIPTION = "description";
    private final String TIME = "time";
    private final String SCHEDULE = "schedule";
    private final String USER_ID_FK = "user_id"; //FOREIGN KEY NG MASA
    private final String STATUS = "status";
    //------HABIT-COLUMNS-------
    //------UNFINISHED-COLUMNS------
    private final String UNFINISHED_ID_PK = "unfinished_id";
    private final String HABIT_ID_FK = "habit_id";
    //USER_ID_FK
    private final String DESCRIPTION_FK = "description";
    private final String NAME_FK = "name";
    //------UNFINISHED-COLUMNS------
    //------COMPLETED-COLUMNS------
    private final String COMPLETED_ID_PK = "completed_id";
    //HABIT_ID_FK
    //USER_ID_FK
    //DESCRIPTION_FK
    //NAME_FK
    //------COMPLETED-COLUMNS------
    public DatabaseHelper(@Nullable Context context) {
        super(context, "habit.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String user_tbl = "CREATE TABLE " + USER_TBL + "(" + USER_ID_PK + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                          + USERNAME + " TEXT NOT NULL, " + PASSWORD + " TEXT NOT NULL)";


        String habit_tbl = "CREATE TABLE " + HABIT_TBL + "(" + HABIT_ID_PK + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                          + NAME + " TEXT NOT NULL, " + DESCRIPTION + " TEXT, " + TIME + " TEXT NOT NULL, "
                          + SCHEDULE + " TEXT NOT NULL, " + USER_ID_FK + " INTEGER NOT NULL, " + STATUS + " TEXT NOT NULL, "
                          + "FOREIGN KEY (" + USER_ID_FK + ") REFERENCES " + USER_TBL + "(" + USER_ID_PK + "))";

        String unfinished_tbl = "CREATE TABLE " + UNFINISHED_TBL + "(" + UNFINISHED_ID_PK + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                                + USER_ID_FK + " INTEGER NOT NULL, " + HABIT_ID_FK + " INTEGER NOT NULL, "
                                + DESCRIPTION_FK + " TEXT NOT NULL, " + NAME_FK + " TEXT NOT NULL, "
                                + "FOREIGN KEY (" + USER_ID_FK + ") REFERENCES " + USER_TBL + "(" + USER_ID_PK + "), "
                                + "FOREIGN KEY (" + HABIT_ID_FK + ") REFERENCES " + HABIT_TBL + "(" + HABIT_ID_PK + "), "
                                + "FOREIGN KEY (" + DESCRIPTION_FK + ") REFERENCES " + HABIT_TBL + "(" + DESCRIPTION + "), "
                                + "FOREIGN KEY (" + NAME_FK + ") REFERENCES " + HABIT_TBL + "(" + NAME + "))";

        String completed_tbl = "CREATE TABLE " + COMPLETED_TBL + "(" + COMPLETED_ID_PK + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                                + USER_ID_FK + " INTEGER NOT NULL, " + HABIT_ID_FK + " INTEGER NOT NULL, "
                                + DESCRIPTION_FK + " TEXT NOT NULL, " + NAME_FK + " TEXT NOT NULL, "
                                + "FOREIGN KEY (" + USER_ID_FK + ") REFERENCES " + USER_TBL + "(" + USER_ID_PK + "), "
                                + "FOREIGN KEY (" + HABIT_ID_FK + ") REFERENCES " + HABIT_TBL + "(" + HABIT_ID_PK + "), "
                                + "FOREIGN KEY (" + DESCRIPTION_FK + ") REFERENCES " + HABIT_TBL + "(" + DESCRIPTION + "), "
                                + "FOREIGN KEY (" + NAME_FK + ") REFERENCES " + HABIT_TBL + "(" + NAME + "))";

        db.execSQL(user_tbl);
        db.execSQL(habit_tbl);
        db.execSQL(unfinished_tbl);
        db.execSQL(completed_tbl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String createTable() {
        return "CREATE TABLE " + HABIT_TBL + "(" + HABIT_ID_PK + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + NAME + " TEXT NOT NULL, " + DESCRIPTION + " TEXT, " + TIME + " TEXT NOT NULL, "
                + SCHEDULE + " TEXT NOT NULL, " + USER_ID_FK + " INTEGER NOT NULL, " + STATUS + " TEXT NOT NULL, "
                + "FOREIGN KEY (" + USER_ID_FK + ") REFERENCES " + USER_TBL + "(" + USER_ID_PK + "))";
    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(USERNAME, user.getUsername());
        cv.put(PASSWORD, user.getPassword());
        db.insert(USER_TBL, null, cv);
    }

    public void addHabit(Habit habit) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME, habit.getName());
        cv.put(DESCRIPTION, habit.getDescription());
        cv.put(TIME, habit.getTime());
        cv.put(SCHEDULE, habit.getSchedule());
        cv.put(USER_ID_FK, habit.getUserID());
        cv.put(STATUS, habit.getStatus());
        db.insert(HABIT_TBL, null, cv);
    }

    public void addUnfinishedHabit(Habit habit) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(HABIT_ID_FK, habit.getHabitID());
        cv.put(USER_ID_FK, habit.getUserID());
        cv.put(DESCRIPTION_FK, habit.getDescription());
        cv.put(NAME_FK, habit.getName());
        db.insert(UNFINISHED_TBL, null, cv);
    }

    public void addCompletedHabit(Habit habit) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(HABIT_ID_FK, habit.getHabitID());
        cv.put(USER_ID_FK, habit.getUserID());
        cv.put(DESCRIPTION_FK, habit.getDescription());
        cv.put(NAME_FK, habit.getName());
        db.insert(COMPLETED_TBL, null, cv);
    }

    public List<User> getUser() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + USER_TBL, null);
        List<User> users = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                users.add(new User(cursor.getInt(0),
                         cursor.getString(1),
                         cursor.getString(2)));
            } while(cursor.moveToNext());
        }
        return users;
    }

    public List<Habit> getHabits() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + HABIT_TBL, null);
        List<Habit> habits = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                habits.add(new Habit(cursor.getInt(0),
                                    cursor.getString(1),
                                    cursor.getString(2),
                                    cursor.getString(3),
                                    cursor.getString(4),
                                    cursor.getInt(5),
                                    cursor.getString(6)));
            } while (cursor.moveToNext());
        }
        return habits;
    }

    public List<Habit> getUnfinishedHabits() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + UNFINISHED_TBL, null);
        List<Habit> habits = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                habits.add(new Habit(cursor.getInt(0),
                                     cursor.getString(1),
                                     cursor.getString(2),
                                     cursor.getInt(3)));
            } while(cursor.moveToNext());
        }
        return habits;
    }

    public List<Habit> getCompletedHabits() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + COMPLETED_TBL, null);
        List<Habit> habits = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                habits.add(new Habit(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3)));
            } while(cursor.moveToNext());
        }
        return habits;
    }

    public void updatePassword(String newPassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(PASSWORD, newPassword);
        db.update(USER_TBL, cv, USER_ID_PK + " = ?" , new String[]{String.valueOf(SessionData.getCurrentUser().getUserID())});
        SessionData.getCurrentUser().setPassword(newPassword);
    }

    public void updateHabit(String name, String description, String schedule, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME, name);
        cv.put(DESCRIPTION, description);
        cv.put(SCHEDULE, schedule);
        cv.put(TIME, time);
        db.update(HABIT_TBL, cv, HABIT_ID_PK + " = ?", new String[]{String.valueOf(SessionData.getHabits())});
    }
}
