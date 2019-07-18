package com.example.loginmvvm.Login.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.loginmvvm.Login.ViewModel.LoginViewModel;
import com.example.loginmvvm.R;

public class LoginActivity extends AppCompatActivity {
EditText editName , editPassword ;
Button loginBtn ;
LoginViewModel viewModel ;
private  final String loginUrl= "http://10.0.2.2/userProject/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editName = findViewById(R.id.edit_username );
        editPassword = findViewById(R.id.edit_password);
        loginBtn = findViewById(R.id.login_btn);
        viewModel = new LoginViewModel(this);


        // for handle login button . . . ;
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString() ;
                String password = editPassword.getText().toString() ;
                viewModel.sendRequest(loginUrl,name , password);

            }
        });



    }


}
