package com.example.loginmvvm.UserInformation.Model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;

public interface UserApiInterface {
    Call<AllUsers> getUsers();
}
