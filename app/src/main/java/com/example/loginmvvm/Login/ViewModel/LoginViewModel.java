package com.example.loginmvvm.Login.ViewModel;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.example.loginmvvm.ApiClient;
import com.example.loginmvvm.Login.Model.LoginApiInterface;
import com.example.loginmvvm.Login.Model.LoginInformation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {
Context context ;
    public LoginViewModel (Context context){
        this.context = context  ;
    }

    public void sendRequest(String baseUrl ,String name , String password){
        LoginApiInterface apiInterface = ApiClient.getApiClient(baseUrl).create(LoginApiInterface.class);
        Call<LoginInformation> informationCall = apiInterface.loginCall(name , password);
        informationCall.enqueue(new Callback<LoginInformation>() {
            @Override
            public void onResponse(Call<LoginInformation> call, Response<LoginInformation> response) {
                Toast.makeText(context, response.body().getInformation(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<LoginInformation> call, Throwable t) {
                Toast.makeText(context, "login failuer", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
