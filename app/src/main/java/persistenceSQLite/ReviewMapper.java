package persistenceSQLite;

import static control.SQLiteDB.ADDRESSE;
import static control.SQLiteDB.ALDERS_GENNEMSNIT;
import static control.SQLiteDB.CHARME;
import static control.SQLiteDB.CROWDED;
import static control.SQLiteDB.DRINK_PRIS;
import static control.SQLiteDB.HYGGELIG;
import static control.SQLiteDB.KAN_SE_SPORT;
import static control.SQLiteDB.LOKATION;
import static control.SQLiteDB.MUSIK;
import static control.SQLiteDB.NAVN;
import static control.SQLiteDB.PLADS;
import static control.SQLiteDB.SHOT_PRIS;
import static control.SQLiteDB.SPIL;
import static control.SQLiteDB.TYPER;
import static control.SQLiteDB.ØLVARIANTER;
import static control.SQLiteDB.ØL_PRIS;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import entities.Review;

public class ReviewMapper {

    public void addReview(SQLiteOpenHelper dbHelper, String name, String adress, Review review, int userID){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(NAVN,name);
        cv.put(ADDRESSE,adress);
        cv.put(CROWDED,review.getCrowded());
        cv.put(HYGGELIG,review.getHyggelig());
        cv.put(LOKATION,review.getLokation());
        cv.put(PLADS,review.getPlads());
        cv.put(MUSIK,review.getMusik());
        cv.put(ALDERS_GENNEMSNIT,review.getAlder_gennemsnit());
        cv.put(KAN_SE_SPORT,review.getKan_se_sport());
        cv.put(SPIL,review.getSpil());
        cv.put(ØLVARIANTER,review.getØlvarianter());
        cv.put(CHARME,review.getCharme());
        cv.put(TYPER,review.getTyper());
        cv.put(ØL_PRIS,review.getØl_pris());
        cv.put(SHOT_PRIS,review.getShit_pris());
        cv.put(DRINK_PRIS,review.getDrink_pris());
        cv.put("user_ID",userID);

    }
}
