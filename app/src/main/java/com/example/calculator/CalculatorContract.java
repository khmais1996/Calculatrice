package com.example.calculator;

import android.provider.BaseColumns;

public final class CalculatorContract {
    private CalculatorContract() {}

    public static class HistoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "history";
        public static final String COLUMN_EXPRESSION = "expression";
        public static final String COLUMN_RESULT = "result";
    }
}
