package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateBDD extends SQLiteOpenHelper {

    //table eleve

    private static final String TABLE_ELEVE = "tEleve";
    static final String COL_ID_ELEVE = "_id_eleve";
    private static final String COL_NOM_ELEVE = "Nom";
    private static final String COL_PRENOM_ELEVE = "Prenom";
    private static final String COL_CLASSE_ELEVE = "Classe";
    private static final String COL_SPECIALITE_ELEVE = "Specialite";
    private static final String COL_FK_PROFESSEUR_ELEVE = "nom_prof";
    private static final String COL_FK_TUTEUR_ELEVE = "nom_tuteur";

    private static final String CREATE_TABLE_ELEVE = "CREATE TABLE " + TABLE_ELEVE + " (" + COL_ID_ELEVE + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NOM_ELEVE + " TEXT NOT NULL, " +
            COL_PRENOM_ELEVE + " TEXT NOT NULL, " +
            COL_CLASSE_ELEVE + " TEXT NOT NULL, " +
            COL_SPECIALITE_ELEVE + " TEXT NOT NULL, " +
            COL_FK_PROFESSEUR_ELEVE + " INTEGER, " +
            COL_FK_TUTEUR_ELEVE + " INTEGER )";





    public CreateBDD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//creation des tables

        db.execSQL(CREATE_TABLE_ELEVE);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){


        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ELEVE + ";");
        onCreate(db);
    }

}
