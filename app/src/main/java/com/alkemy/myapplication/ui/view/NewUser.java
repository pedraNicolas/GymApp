package com.alkemy.myapplication.ui.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.alkemy.myapplication.data.network.services.encrypter.EncrypterServiceImplement;
import com.alkemy.myapplication.databinding.ActivityUserResponseBinding;
import com.alkemy.myapplication.ui.viewmodel.NewUserViewModel;

public class NewUser extends AppCompatActivity {
    private ActivityUserResponseBinding binding;
    private NewUserViewModel newUserViewModel = new NewUserViewModel();
    EncrypterServiceImplement encrypterServiceImplement = new EncrypterServiceImplement();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserResponseBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //Instancia de view model
        newUserViewModel = new ViewModelProvider(this).get(NewUserViewModel.class);
        Log.i("NewUserViewModel", "NewUserViewModel is initialized");


    }

    protected void onResume() {
        super.onResume();
        userCreate();
    }

    private void userCreate() {
        //Set ID a User.java
        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String id = binding.idTextView.getText().toString();
                //Set Name a User.java
                String name = binding.nameTextView.getText().toString();
                //Set User a User.java
                String user = binding.userTextView.getText().toString();
                //Set Password a User.java
                String passwordPut = binding.passwordTextView.getText().toString();
                String hashPass = encrypterServiceImplement.encryptPassword(passwordPut);
                newUserViewModel.createUser(id,name,user,hashPass,0,0);
            }
        });
    }
}
