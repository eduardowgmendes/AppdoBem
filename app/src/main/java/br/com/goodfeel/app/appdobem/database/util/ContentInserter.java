package br.com.goodfeel.app.appdobem.database.util;

import android.database.sqlite.SQLiteDatabase;

public class ContentInserter {

    private SQLiteDatabase database;

    public ContentInserter(SQLiteDatabase database) {
        this.database = database;
    }

    public void insert(String table, String[] columns, Object[] values) {
        database.execSQL("INSERT INTO " + table + "(" + parse(columns) + ") VALUES (" + values + ")");
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }

    public void setDatabase(SQLiteDatabase database) {
        this.database = database;
    }

    private String parse(String[] columns) {
        int lastIndex = columns.length;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i <= columns.length; i++) {

            if (i == lastIndex) {
                str.append(columns);
            }

            str.append(columns);
            str.append(',');
            str.append(' ');
        }

        return str.toString();
    }


}
