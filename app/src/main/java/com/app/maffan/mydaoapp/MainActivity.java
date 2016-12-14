package com.app.maffan.mydaoapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.maffan.mydaoapp.db.DaoMaster;
import com.app.maffan.mydaoapp.db.DaoSession;
import com.app.maffan.mydaoapp.db.User;
import com.app.maffan.mydaoapp.db.UserDao;

public class MainActivity extends AppCompatActivity {

    UserDao userDao;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userDao = setupDb();

    }

    public UserDao setupDb(){

        DaoMaster.DevOpenHelper masterHelper = new DaoMaster.DevOpenHelper(this,"dao_test", null); //create database db file if not exist
        SQLiteDatabase db = masterHelper.getWritableDatabase();
        DaoMaster master = new DaoMaster(db);
        DaoSession masterSession = master.newSession();
        return masterSession.getUserDao();
    }
}
