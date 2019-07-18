package com.example.loginmvvm.UserInformation.Model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.loginmvvm.UserInformation.Model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    public void insertUser(User user);

    @Query("SELECT * From user_info")
    MutableLiveData<AllUsers> getAllUser();

    @Query("SELECT * FROM user_info WHERE id = :userid")
    MutableLiveData<List<User>> getUser(int userid);



}
