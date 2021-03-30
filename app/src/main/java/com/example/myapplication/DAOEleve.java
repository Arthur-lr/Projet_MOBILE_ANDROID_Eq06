package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;

public class DAOEleve {

    static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "bddSuivi.db";
    static final String TABLE_ELEVE = "televe";
    static final String COL_ID = "id";
    static final int NUM_COL_ID = 0;
    static final String COL_NOM = "Nom";
    static final int NUM_COL_NOM = 1;
    static final String COL_PRENOM = "Prenom";
    static final int NUM_COL_PRENOM = 2;
    private CreateTableEleve tableEleve;
    private Context context;
    private SQLiteDatabase db;

    public DAOEleve(Context context) {
        this.context = context;
        tableEleve = new CreateTableEleve(context, NOM_BDD, null, VERSION_BDD);
    }
    public DAOEleve open(){
        db = tableEleve.getWritableDatabase();
        return this;
    }
    public DAOEleve close (){
        db.close();
        return null;
    }
    public long insererEleve (Eleve unEleve){
        ContentValues values = new ContentValues();
        values.put(COL_NOM, unEleve.getNom());
        values.put(COL_PRENOM, unEleve.getPrenom());

        return db.insert(TABLE_ELEVE, null, values);
    }
    private Eleve cursorToEleve(Cursor c) {
        if (c.getCount() == 0)
            return null;

        c.moveToFirst();
        Eleve unEleve = new Eleve(null,null);

        unEleve.setNom(c.getString(NUM_COL_NOM));
        unEleve.setPrenom(c.getString(NUM_COL_PRENOM));
        c.close();
        return unEleve;

    }

    public Eleve getEleveWithNom(String Nom){
        Cursor c = db.query(TABLE_ELEVE, new String[] {COL_ID, COL_NOM, COL_PRENOM}, COL_NOM + "like \"" + Nom + "\"", null, null, null, null);
        return cursorToEleve(c);
    }

    public Cursor getData(){
        return  db.rawQuery("SELECT * FROM televe", null);
    }
}
