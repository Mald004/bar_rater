package control;


import static android.os.Build.ID;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entities.User;

public class SQLiteDB extends SQLiteOpenHelper {
    private static SQLiteDB instance;
    private static Map<Context, SQLiteDB> instances = new HashMap<>();

    public static final String USER = "user";
    public static final String AGE = "age";
    public static final String NAME = "name";
    public static final String PASSWORD = "password";
    public static final String REVIEW = "review";
    public static final String NAVN = "navn";
    public static final String ADDRESSE = "addresse";
    public static final String CROWDED = "crowded";
    public static final String HYGGELIG = "hyggelig";
    public static final String LOKATION = "lokation";
    public static final String PLADS = "plads";
    public static final String MUSIK = "musik";
    public static final String ALDERS_GENNEMSNIT = "alders_gennemsnit";
    public static final String KAN_SE_SPORT = "kan_se_sport";
    public static final String SPIL = "spil";
    public static final String ØLVARIANTER = "ølvarianter";
    public static final String CHARME = "charme";
    public static final String TYPER = "typer";
    public static final String ØL_PRIS = "øl_pris";
    public static final String SHOT_PRIS = "shot_pris";
    public static final String DRINK_PRIS = "drink_pris";
    public static final String DATO = "dato";

    private SQLiteDB(@Nullable Context context) {
        super(context, "bar_rater", null, 1);
    }

    //This is called the first time the database is accessed. There should be code in here to create a new database.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTableStatement = "CREATE TABLE IF NOT EXISTS " + USER + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " + AGE + " INTEGER NOT NULL, " + NAME + " TEXT NOT NULL, " + PASSWORD + " TEXT NOT NULL, UNIQUE (id), UNIQUE (name));";
        String createReviewTableStatement = "CREATE TABLE IF NOT EXISTS " + REVIEW + " (idreview INTEGER PRIMARY KEY AUTOINCREMENT, " + NAVN + " TEXT NOT NULL, " + ADDRESSE + " TEXT NOT NULL, " + CROWDED + " INTEGER NOT NULL, " + HYGGELIG + " INTEGER NOT NULL, " + LOKATION + " INTEGER NOT NULL, " + PLADS + " INTEGER NOT NULL, " + MUSIK + " INTEGER NOT NULL, " + ALDERS_GENNEMSNIT + " INTEGER NOT NULL, " + KAN_SE_SPORT + " INTEGER NOT NULL, " + SPIL + " INTEGER NOT NULL, " + ØLVARIANTER + " INTEGER NOT NULL, " + CHARME + " INTEGER NOT NULL, " + TYPER + " INTEGER NOT NULL, " + ØL_PRIS + " INTEGER NOT NULL, " + SHOT_PRIS + " INTEGER NOT NULL, " + DRINK_PRIS + " INTEGER NOT NULL, " + USER + "_ID INTEGER NOT NULL, " + DATO + " TEXT NOT NULL DEFAULT (strftime('%Y-%m-%d %H:%M:%S', 'now', 'localtime')), FOREIGN KEY (user_ID) REFERENCES user (id));";
        db.execSQL(createUserTableStatement);
        db.execSQL(createReviewTableStatement);
    }


    //This is called if the database number changes. It prevents previous users apps from breaking when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long addUser(String name, String password, int age){
        //writeable meaning writing to the database.
     SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(NAME,name);
        cv.put(PASSWORD,password);
        cv.put(AGE,age);

        long id = db.insert(USER,null , cv);

        return id;
    }

        public ArrayList<User> getAllUsers() {
            SQLiteDatabase db = this.getReadableDatabase();
            ArrayList<User> userList = new ArrayList<>();

            Cursor cursor = db.rawQuery(USER,null);

            while(cursor.moveToNext()){
               int id = cursor.getInt(1);
               int age = cursor.getInt(2);
               String name = cursor.getString(3);
               String password = cursor.getString(4);
               User user = new User(id,name, age, password);
               userList.add(user);
            }
            return userList;
        }

    public static SQLiteDB getInstance(Context context) {
        SQLiteDB instance = instances.get(context);
        if (instance == null) {
            instance = new SQLiteDB(context);
            instances.put(context, instance);
        }
        return instance;
    }
}

