package com.example.loginmvvm.UserInformation.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.loginmvvm.R;
import com.example.loginmvvm.UserInformation.Model.AllUsers;
import com.example.loginmvvm.UserInformation.Model.User;
import com.example.loginmvvm.databinding.ActivityUsersInformationBinding;
import com.example.loginmvvm.databinding.UserItemListBinding;

import java.util.ArrayList;
import java.util.List;

public class UsersInformation extends AppCompatActivity {
   ActivityUsersInformationBinding userBinding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_information);
        // initialize views and casting if exist . . . . ;
        initializeViews();

    }

    private void initializeViews(){
        userBinding = DataBindingUtil.setContentView(this,R.layout.activity_users_information);

    }

    private class RecyclerUserViewHolder extends RecyclerView.ViewHolder{
        UserItemListBinding userItemListBinding ;
        public RecyclerUserViewHolder(UserItemListBinding viewList){
            super(viewList.getRoot());
            userItemListBinding = viewList ;
        }
    }

    private class RecyclerUserAdapter extends RecyclerView.Adapter<RecyclerUserViewHolder>{
        List<User>userList = new ArrayList<>();
        Context context ;
        int resource ;
        public RecyclerUserAdapter(Context context , int resource , MutableLiveData<AllUsers>users){
            this.context = context ;
            this.resource = resource ;
            users.observe(UsersInformation.this, new Observer<AllUsers>() {
                @Override
                public void onChanged(AllUsers allUsers) {
                    userList.addAll(allUsers.getUserList());
                }
            });
        }

        @NonNull
        @Override
        public RecyclerUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            UserItemListBinding itemListBinding = DataBindingUtil.inflate(LayoutInflater.from(context),resource,parent,false);

            return new RecyclerUserViewHolder(itemListBinding);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerUserViewHolder holder, int position) {
             User user = userList.get(position);
             holder.userItemListBinding.setUser(user);
        }

        @Override
        public int getItemCount() {
            return userList.size();
        }
    }

}
