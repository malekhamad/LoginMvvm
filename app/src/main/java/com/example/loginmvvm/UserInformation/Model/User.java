package com.example.loginmvvm.UserInformation.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "user_info")
public class User {
    @SerializedName("id")
    @ColumnInfo(name = "id")
    private int id ;

    @SerializedName("username")
    @ColumnInfo(name = "Name")
    private String name;

    @SerializedName("userpass")
    private String password ;

    public User(int id,String name , String password){
        this.id = id ;
        this.name = name ;
        this.password = password ;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
