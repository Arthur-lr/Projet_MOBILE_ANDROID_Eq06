package com.example.myapplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class InformationStageActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_stagiaire);

        //Gestion des boutons enregistrer et annuler
        Button btnValider = (Button) findViewById(R.id.btnValiderInfoStagiaire);
        Button btnAnnuler = (Button) findViewById(R.id.btnAnnulerInfoStagiaire);

        // Gestion des cases des cases EditText
        EditText nomEleve = findViewById(R.id.editNomStg);
        EditText prenomEleve = findViewById(R.id.editPrenomStg);
        EditText spe = findViewById(R.id.editspe);
        EditText classe = findViewById(R.id.editclasse);
        EditText prof = findViewById(R.id.editprof);
        EditText tuteur = findViewById(R.id.edittuteur);


        // Désactive la modification des cases
        nomEleve.setEnabled(false);
        prenomEleve.setEnabled(false);
        classe.setEnabled(false);
        spe.setEnabled(false);
        prof.setEnabled(false);
        tuteur.setEnabled(false);



        // SharedPreferences
        final SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();

        //on va créer un écouteur pour un groupe de boutons
        View.OnClickListener ecouteur = new View.OnClickListener() {
            //on implémente la méthode onclick
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnAnnulerInfoStagiaire:
                        finish();
                        break;
                }
            }
        };
        btnAnnuler.setOnClickListener(ecouteur);


        // Récupère l'élève depuis SharedPreferences
        String unEleve = pref.getString("unEleve", null);
        //Toast.makeText(InformationStageActivity.this, unEleve, Toast.LENGTH_SHORT).show();

        // Récupère les infos de l'élève depuis la bdd
        final DAOBdd daoBdd = new DAOBdd(this);
        daoBdd.open();
        List infoEleve = daoBdd.getEleveById(daoBdd.getIdByPrenomEleve(unEleve));
        daoBdd.close();

        // Rempli les informations de l'élève
        //Toast.makeText(InformationStageActivity.this, infoEleve.toString(), Toast.LENGTH_SHORT).show();
        nomEleve.setText(infoEleve.get(0).toString());
        prenomEleve.setText(infoEleve.get(1).toString());
        classe.setText(infoEleve.get(2).toString());
        spe.setText(infoEleve.get(3).toString());
        prof.setText(infoEleve.get(4).toString());
        tuteur.setText(infoEleve.get(5).toString());
        //Toast.makeText(InformationStageActivity.this, infoEleve.get(2).toString(), Toast.LENGTH_SHORT).show();
        // Active le bouton radio en fonction de l'option de l'élève


    }

}