package com.example.habit_tracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private final String USER_TBL = "user_tbl";
    private final String HABIT_TBL = "habit_tbl";
    private final String UNFINISHED_TBL = "unfinished_tbl";
    private final String COMPLETED_TBL = "completed_tbl";

    private final String USER_ID_PK = "user_id";
    private final String USERNAME = "username";
    private final String PASSWORD = "password";

    private final String HABIT_ID_PK = "habit_id";
    private final String NAME = "name";
    private final String DESCRIPTION = "description";
    private final String TIME = "time";
    private final String SCHEDULE = "schedule";
    private final String USER_ID_FK = "user_id"; //FOREIGN KEY NG MASA
    private final String STATUS = "status";

    private final String UNFINISHED_ID_PK = "unfinished_id";
    //USER_ID_FK
    private final String NAME_FK = "name";

    private final String COMPLETED_ID_PK = "completed_id";
    //USER_ID_FK
    //NAME_FK
    public DatabaseHelper(@Nullable Context context) {
        super(context, "habit.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
