package com.example.loginmvvm.UserInformation.Model;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.loginmvvm.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersRepository {

    private static UsersRepository usersRepository ;

    public static UsersRepository getInstance(){
        if (usersRepository == null){
            usersRepository = new UsersRepository();
        }
        return usersRepository ;
    }


    private UserApiInterface userApiInterface ;

    private UsersRepository() {
        userApiInterface = ApiClient.getApiClient("labala").create(UserApiInterface.class);
    }

    public AllUsers getAllUser(){
         AllUsers usersLiveData = new AllUsers();
        final List<User>userList = new ArrayList<>();
         Call<AllUsers>usersCall = userApiInterface.getUsers();
        usersCall.enqueue(new Callback<AllUsers>() {
            @Override
            public void onResponse(Call<AllUsers> call, Response<AllUsers> response) {
                if(response.isSuccessful()){
                    userList.addAll(response.body());
                }
            }

            @Override
            public void onFailure(Call<AllUsers> call, Throwable t) {

            }
        });



}
