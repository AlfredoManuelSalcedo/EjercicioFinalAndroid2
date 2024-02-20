package com.example.ejerciciofinalandroid2;

import android.provider.BaseColumns;

public final class FeedReaderContract {
    private FeedReaderContract() {}
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "cripto";
        public static final String COLUMN_NAME_NAME = "nombre";
        public static final String COLUMN_NAME_VALOR = "valor";
        public static final String COLUMN_NAME_CANTIDAD = "cantidad";
    }
}