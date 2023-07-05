package persistenceSQLite;


import static control.SQLiteDB.AGE;
import static control.SQLiteDB.NAME;
import static control.SQLiteDB.PASSWORD;
import static control.SQLiteDB.USER;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import control.SQLiteDB;
import entities.User;

public class UserMapper  {


    public static long addUser(SQLiteDB dbHelper, String name, String password, int age){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(NAME,name);
        cv.put(PASSWORD,password);
        cv.put(AGE,age);

        long id = db.insert(USER,null , cv);

        return id;
    }

    public static ArrayList<User> getAllUsers(SQLiteDB dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
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


}
