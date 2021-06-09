package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DAOBdd {

        static final int VERSION_BDD = 1;
        private static final String NOM_BDD = "SuiviStage.db";



        //table Eleve
        static final String TABLE_ELEVE = "tEleve";
        static final String COL_ID_ELEVE = "_id_eleve";
        static final int NUM_COL_ELEVE = 0;
        static final String COL_NOM_ELEVE = "Nom";
        static final int NUM_COL_NOM_ELEVE = 1;
        static final String COL_PRENOM_ELEVE = "Prenom";
        static final int NUM_COL_PRENOM_ELEVE = 2;
        static final String COL_CLASSE_ELEVE = "Classe";
        static final int NUM_COL_CLASSE_ELEVE = 3;
        static final String COL_SPECIALITE_ELEVE = "Specialite";
        static final int NUM_COL_SPECIALITE_ELEVE = 4;
        static final String COL_FK_PROFESSEUR_ELEVE = "nom_prof";
        static final int NUM_COL_FK_PROFESSEUR_ELEVE = 5;
        static final String COL_FK_TUTEUR_ENTREPRISE_ELEVE = "nom_tuteur";
        static final int NUM_COL_FK_TUTEUR_ENTREPRISE_ELEVE = 6;






        private CreateBDD tableCourante;
        private Context context;
        private SQLiteDatabase db;
        //le constructeur
        public DAOBdd(Context context){
            this.context = context;
            tableCourante = new CreateBDD(context, NOM_BDD, null, VERSION_BDD);
        }
       

        public com.example.myapplication.DAOBdd open(){
            db = tableCourante.getWritableDatabase();
            return this;
        }
        public com.example.myapplication.DAOBdd close(){
            db.close();
            return null;
        }



        // Permet de retourner une liste contenant uniquement le noms des élèves
        public List<String> getAllNomEleves(){
            List<String> listeNomEleves = new ArrayList<>();
            Cursor c = db.rawQuery("SELECT Prenom, Nom FROM tEleve", null);
            if(c.moveToFirst()) {
                do {
                    listeNomEleves.add(c.getString(0));
                } while (c.moveToNext());
            }
            c.close();
            //db.close();
            return listeNomEleves;
        }



        // Permet de retourner l'id d'un élève depuis son prenom
        public String getIdByPrenomEleve(String prenomEleve) {
            String idEleve = "";
            Cursor c = db.rawQuery("SELECT * FROM tEleve WHERE prenom = "+"'"+prenomEleve+"'", null);
            if(c.moveToFirst()) {
                idEleve = c.getString(0);
            }
            c.close();
            return idEleve;
        }

        // Retourne les infos d'un élève depuis son id
        public List<String> getEleveById(String idEleve) {
            List<String> infoEleve = new ArrayList<>();
            Cursor c = db.rawQuery("SELECT * FROM tEleve WHERE _id_eleve = "+"'"+idEleve+"' ", null);
            if(c.moveToFirst()) {
                infoEleve.add(c.getString(1)); // Nom
                infoEleve.add(c.getString(2)); // Prenom
                infoEleve.add(c.getString(3)); // classe
                infoEleve.add(c.getString(4)); // spe
                infoEleve.add(c.getString(5)); // prof
                infoEleve.add(c.getString(6)); // tuteur
            }
            c.close();
            return infoEleve;
        }





        public long insererEleve (Eleve unEleve){
            //Création d'un ContentValues (fonctionne comme une HashMap)
            ContentValues values = new ContentValues();
            //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
            values.put(COL_NOM_ELEVE, unEleve.getNom());
            values.put(COL_PRENOM_ELEVE, unEleve.getPrenom());
            values.put(COL_CLASSE_ELEVE, unEleve.getClasse());
            values.put(COL_SPECIALITE_ELEVE, unEleve.getSpecialite());
            values.put(COL_FK_PROFESSEUR_ELEVE, unEleve.getId_professeur());
            values.put(COL_FK_TUTEUR_ENTREPRISE_ELEVE, unEleve.getId_tuteur());

            //on insère l'objet dans la BDD via le ContentValues
            return db.insert(TABLE_ELEVE, null, values);
        }







        public void deleteEleves(){
            db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '" + TABLE_ELEVE + "'");
            db.execSQL("delete from "+ TABLE_ELEVE);
            db.close();
        }

    }
