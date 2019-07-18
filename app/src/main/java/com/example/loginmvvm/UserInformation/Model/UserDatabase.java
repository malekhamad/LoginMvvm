package com.example.loginmvvm.UserInformation.Model;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao userDao() ;

    private static UserDatabase userDatabaseRoom ;

    public static synchronized UserDatabase UgetDatabaseInstance(Context context){
        if(userDatabaseRoom == null){
            userDatabaseRoom = Room.databaseBuilder(context.getApplicationContext(),UserDatabase.class,"user_login")
                    .build();
        }
        return userDatabaseRoom;
    }
}
