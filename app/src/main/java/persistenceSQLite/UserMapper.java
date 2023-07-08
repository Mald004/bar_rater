package persistenceSQLite;


import static control.SQLiteDB.AGE;
import static control.SQLiteDB.NAME;
import static control.SQLiteDB.PASSWORD;
import static control.SQLiteDB.USER;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import entities.User;

public class UserMapper  {


    public static long addUser(SQLiteOpenHelper dbHelper, String name, String password, int age){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(NAME,name);
        cv.put(PASSWORD,password);
        cv.put(AGE,age);

        long id = db.insert(USER,null , cv);

        return id;
    }

    public static ArrayList<User> getAllUsers(SQLiteOpenHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<User> userList = new ArrayList<>();

        String query = "SELECT * FROM " + USER;
        Cursor cursor = db.rawQuery(query,null);

        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            int age = cursor.getInt(1);
            String name = cursor.getString(2);
            String password = cursor.getString(3);
            User user = new User(id,name, age, password);
            userList.add(user);
        }
        return userList;
    }

    public static User getUserByName(SQLiteOpenHelper dbHelper, String username){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        User user = null;

        String query = "SELECT * FROM " + USER + " WHERE name = '" + username + "'";
        Cursor cursor = db.rawQuery(query,null);



        while(cursor.moveToNext()){
           int id = cursor.getInt(0);
           int age = cursor.getInt(1);
           String name = cursor.getString(2);

           user = new User(id,age,name);
        }

        return user;
    }


}
