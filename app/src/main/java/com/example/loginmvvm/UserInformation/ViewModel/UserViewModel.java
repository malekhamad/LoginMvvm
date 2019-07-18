package com.example.loginmvvm.UserInformation.ViewModel;

import android.app.Application;
import android.content.Context;
import android.service.autofill.UserData;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.loginmvvm.UserInformation.Model.AllUsers;
import com.example.loginmvvm.UserInformation.Model.UserDao;
import com.example.loginmvvm.UserInformation.Model.UserDatabase;
import com.example.loginmvvm.UserInformation.Model.UsersRepository;

public class UserViewModel extends AndroidViewModel {
   private Context context ;
   private UserDao userDao ;
   private UserDatabase userDatabase ;
   private MutableLiveData<AllUsers>userList ;
   UsersRepository usersRepository ;

    public UserViewModel(Application application){
        super(application);
        if(userList == null){
            usersRepository = UsersRepository.getInstance();
            userList = usersRepository.getAllUser();
        }
        userDatabase =UserDatabase.UgetDatabaseInstance(application);
        userDao = userDatabase.userDao();
        userList = userDao.getAllUser() ;

    }



    // get list of users . . . ;
    public MutableLiveData<AllUsers> getUserList(){
        return userList;
    }




}
