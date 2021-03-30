package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CreateTableEleve extends SQLiteOpenHelper {

    private static final String TABLE_ELEVE = "table_eleve";
    static final String COL_ID = "id";
    private static final String COL_NOM = "Nom";
    private static final String COL_PRENOM = "Prenom";

    private static final String CREATE_TABLE = "CREATE TABLE" + TABLE_ELEVE + " ("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_NOM + " TEXT NOT NULL," +
            " " + COL_PRENOM + " TEXT NOT NULL);";

    public CreateTableEleve(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE " + TABLE_ELEVE + ";");
        onCreate(db);
    }
}
