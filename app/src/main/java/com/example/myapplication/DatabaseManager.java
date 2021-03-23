package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Suivi.db";
    private static final int DATABASE_VERSION= 2;

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSql = "create table T_Etudiants ("
                      +  " id integer primary key autoincrement,"
                      + " lastname text not null"
                      + ")";
        db.execSQL(strSql);
        Log.i("DATABASE", "onCreate invoked");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String strSql = "drop table T_Etudiants";
        db.execSQL(strSql);
        this.onCreate(db);
        Log.i("DATABASE", "onUpgrade invoked" );
    }

    public void insertEtudiants(String lastname){
        lastname = lastname.replace( "'", "''" );

        String strSql = "insert into T_Etudiants (lastname) values ('"
                + lastname +"'"+ ")";
        this.getWritableDatabase().execSQL( strSql );
        Log.i( "DATABASE", "insertScore invoked" );
    }



}
