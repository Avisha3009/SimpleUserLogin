package com.example.userregistration;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.userregistration.User;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    User u = new User();
    public DBHelper(Context context) {
        super(context, "mydb.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT,age TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(User user1){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", user1.getUsername());
        contentValues.put("password", user1.getPassword());
        contentValues.put("age",user1.getAge());
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
    // returns true if passed username is present in database
    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    // returns the user object if both username and and password match
    public User checkusernamepassword(String username, String password){

        String [] ans = new String[3];
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor!=null &&cursor.moveToFirst()) {
            u.setUsername(cursor.getString(0));
            u.setPassword(cursor.getString(1));
            u.setAge(cursor.getString(2));
        }
        return u;
    }
}