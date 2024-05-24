package com.example.habit_tracker;

import org.junit.Test;

import static org.junit.Assert.*;

import android.content.Context;

import com.example.habit_tracker.data.DatabaseHelper;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testCreateUserTableQuery() {

        String expectedQuery = "CREATE TABLE habit_tbl(habit_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT NOT NULL, description TEXT, time TEXT NOT NULL, schedule TEXT NOT NULL, user_id INTEGER NOT NULL, status TEXT NOT NULL, FOREIGN KEY (user_id) REFERENCES user_tbl(user_id))";
        String actualQuery = new DatabaseHelper(null).createTable();
        assertEquals(expectedQuery, actualQuery);
    }
}