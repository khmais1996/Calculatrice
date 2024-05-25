package com.example.calculator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CalculatorDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "calculator.db";
    private static final int DATABASE_VERSION = 1;

    public CalculatorDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_HISTORY_TABLE = "CREATE TABLE " + CalculatorContract.HistoryEntry.TABLE_NAME + " (" +
                CalculatorContract.HistoryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CalculatorContract.HistoryEntry.COLUMN_EXPRESSION + " TEXT NOT NULL, " +
                CalculatorContract.HistoryEntry.COLUMN_RESULT + " REAL NOT NULL);";
        db.execSQL(SQL_CREATE_HISTORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CalculatorContract.HistoryEntry.TABLE_NAME);
        onCreate(db);
    }
}
