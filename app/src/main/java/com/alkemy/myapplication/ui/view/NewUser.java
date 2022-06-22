package com.alkemy.myapplication.ui.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.alkemy.myapplication.data.network.services.encrypter.EncrypterServiceImplement;
import com.alkemy.myapplication.databinding.ActivityUserResponseBinding;
import com.alkemy.myapplication.ui.viewmodel.NewUserViewModel;

public class NewUser extends AppCompatActivity {
    private ActivityUserResponseBinding binding;
    private NewUserViewModel userViewModel = new NewUserViewModel();
    EncrypterServiceImplement encrypterServiceImplement = new EncrypterServiceImplement();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserResponseBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //Instancia de view model
        userViewModel = new ViewModelProvider(this).get(NewUserViewModel.class);
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
                String name = binding.nameTextView.getText().toString();
                String user = binding.userTextView.getText().toString();
                if (!name.isEmpty() || !user.isEmpty()) {
                    String id = binding.idTextView.getText().toString();
                    String passwordPut = binding.passwordTextView.getText().toString();
                    userViewModel.createUser(id, name, user, passwordPut, 0L, 0L);
                }else{
                    Toast.makeText(getApplicationContext(),"User and Password is requerid",Toast.LENGTH_SHORT).show();
                }
            }

            });
        }
    }
