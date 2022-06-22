package com.alkemy.myapplication.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import com.alkemy.myapplication.data.models.User;
import com.alkemy.myapplication.databinding.ActivityMainBinding;
import com.alkemy.myapplication.ui.viewmodel.NewUserViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private NewUserViewModel userViewModel = new NewUserViewModel();
    private static MainActivity instance;

    public MainActivity() {
        instance = this;
    }

    public static MainActivity getInstance() {
        return instance;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //Instancia de view model
        userViewModel = new ViewModelProvider(this).get(NewUserViewModel.class);
        getUser();
    }


    public void getUser() {
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userPut;
                String passwordPut;
                userPut = binding.userEditText.getText().toString();
                passwordPut = binding.passEditText.getText().toString();
                if (!userPut.isEmpty() && !passwordPut.isEmpty()) {
                    userViewModel.loginVM(userPut, passwordPut);
                } else {
                    Toast.makeText(MainActivity.this, "User and password are requerid", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void showHome(User user) {
         Intent intentMainActivity = new Intent(this, HomeActivity.class)
                .putExtra("user", user);

        startActivity(intentMainActivity);
    }
}