package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);

        // Vide les tables

        deleteEleves();


        // Remplit les tables

        remplirEleves();


        // SharedPreferences
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        final SharedPreferences.Editor editor = pref.edit();

        // Eleve choisi via le spinner
        final String[] unEleve = new String[1];

        Button btnValider = (Button) findViewById(R.id.btnValiderAccueil);

        //on va créer un écouteur pour un groupe de boutons
        View.OnClickListener ecouteur = new View.OnClickListener() {
            //on implémente la méthode onclick
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnValiderAccueil:
                        // L'élève choisi est envoyé dans le SharedPreferences
                        editor.putString("unEleve", unEleve[0]);
                        editor.commit();

                       Intent intent = new Intent(MainActivity.this, InformationStageActivity.class);
                       startActivity(intent);
                        break;
                }
            }
        };
        btnValider.setOnClickListener(ecouteur);


        // Gestion de la liste déroulante des eleves
        final Spinner spinnerEleves = (Spinner) findViewById(R.id.spinnerEleves);
        // Création d'une instance de la classe DAObdd
        final DAOBdd daoBdd = new DAOBdd(this);
        // On ouvre la table
        daoBdd.open();
        // On récupère le nom de tous les eleves
        List lesEleves = daoBdd.getAllNomEleves();





        ArrayAdapter<String> dataAdapterR = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lesEleves);
            dataAdapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerEleves.setAdapter(dataAdapterR);
            spinnerEleves.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected (AdapterView< ? > parent, View view, int position, long id){
                unEleve[0] = String.valueOf(spinnerEleves.getSelectedItem());
                //Toast.makeText(MainActivity.this, unProf, Toast.LENGTH_SHORT).show();


            }
            @Override
            public void onNothingSelected (AdapterView< ? > adapterView){
        }
        });
        daoBdd.close();


    }



    public void remplirEleves(){
        DAOBdd daoBdd = new DAOBdd(this);
        Eleve eleve1 = new Eleve("Bourdoiseau", "Clement", "2SLAM", "SLAM", "Lacombra", "Deprune");
        Eleve eleve2 = new Eleve("Lory", "Arthur", "2SLAM", "SLAM", "Contant", "Loiret");
        Eleve eleve3 = new Eleve("Debruyne", "Stephane", "1SIO", "SLAM", "Dupont", "Nifon");

        //on ouvre la base de données
        daoBdd.open();
        //on insère les élèves
        daoBdd.insererEleve(eleve1);
        daoBdd.insererEleve(eleve2);
        daoBdd.insererEleve(eleve3);

        //le curseur pour afficher le nombre de eleves dans la base
        //Cursor c = daoBdd.getDataProf();
        //Toast.makeText(getApplicationContext(), " il y a " + String.valueOf(c.getCount()) + " lacs ", Toast.LENGTH_LONG).show();
    }


    public void deleteEleves() {
        DAOBdd daoBdd = new DAOBdd(this);
        daoBdd.open();
        daoBdd.deleteEleves();
    }





}

