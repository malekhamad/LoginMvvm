package com.example.loginmvvm.Login.Model;

import com.google.gson.annotations.SerializedName;

public class LoginInformation {
    private String Name ;
    private String Password ;

    @SerializedName("id")
    private String information ;

    public String getInformation() {
        return information;
    }
}
