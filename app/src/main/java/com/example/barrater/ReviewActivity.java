package com.example.barrater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import entities.Review;

public class ReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void sendData(Button button){
        EditText navnText = findViewById(R.id.navn);
        EditText adresseText = findViewById(R.id.addrese);
        EditText crowdedText = findViewById(R.id.crowd);
        EditText hyggeligText = findViewById(R.id.hygge);
        EditText lokationText = findViewById(R.id.lokation);
        EditText pladsText = findViewById(R.id.plads);
        EditText musikText = findViewById(R.id.musik);
        EditText alderGennemsnitText = findViewById(R.id.alder);
        EditText sportText = findViewById(R.id.seSport);
        EditText spilText = findViewById(R.id.spil);
        EditText ølVariantText = findViewById(R.id.ølVarianter);
        EditText charmeText = findViewById(R.id.charme);
        EditText typerText = findViewById(R.id.typer);
        EditText ølPrisText = findViewById(R.id.ølPris);
        EditText shotPrisText = findViewById(R.id.shotPris);
        EditText drinkPrisText = findViewById(R.id.drinksPris);

        String navn = navnText.toString();
        String adresse = adresseText.toString();
        int crowded = Integer.parseInt(crowdedText.toString());
        int hyggelig = Integer.parseInt(hyggeligText.toString());
        int lokation = Integer.parseInt(lokationText.toString());
        int plads = Integer.parseInt(pladsText.toString());
        int musik = Integer.parseInt(musikText.toString());
        int aldersGennemsnit = Integer.parseInt(alderGennemsnitText.toString());
        int sport = Integer.parseInt(sportText.toString());
        int spil = Integer.parseInt(spilText.toString());
        int ølVariant = Integer.parseInt(ølVariantText.toString());
        int charme = Integer.parseInt(charmeText.toString());
        int typer = Integer.parseInt(typerText.toString());
        int ølPris = Integer.parseInt(ølPrisText.toString());
        int shotPris = Integer.parseInt(shotPrisText.toString());
        int drinkPris = Integer.parseInt(drinkPrisText.toString());

        Review review = new Review(navn,adresse,crowded,hyggelig,lokation,plads,musik,aldersGennemsnit,sport,spil,ølVariant,charme,typer,ølPris,shotPris,drinkPris);


    }
}