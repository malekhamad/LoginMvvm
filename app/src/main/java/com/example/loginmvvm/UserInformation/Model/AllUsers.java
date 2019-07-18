package com.example.loginmvvm.UserInformation.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AllUsers  {
    private List<User> userList = new ArrayList<>();
    public List<User> getUserList(){
        return userList ;
    }
}
