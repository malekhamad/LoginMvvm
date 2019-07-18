package com.example.loginmvvm.Login.Model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginApiInterface {

@POST("user_login.php")
@FormUrlEncoded
Call<LoginInformation>loginCall(@Field("Name") String name , @Field("Password") String password);


}