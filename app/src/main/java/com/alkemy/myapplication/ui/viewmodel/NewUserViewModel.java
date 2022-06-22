package com.alkemy.myapplication.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.alkemy.myapplication.domain.DataBaseUseCase;

public class NewUserViewModel extends ViewModel {

    DataBaseUseCase dataBaseUseCase = new DataBaseUseCase();

    public void createUser(String id,
                           String name,
                           String user,
                           String password,
                           Long token,
                           Long cellphone) {
        dataBaseUseCase.setUser(id, name, user, token, cellphone);
        dataBaseUseCase.createUserUC(user, password);
    }

    public void loginVM(String user,
                        String password) {
        dataBaseUseCase.loginUC(user, password);
    }

//    public void userList(){
//        User currentUser =
//    }


    public NewUserViewModel() {
        Log.i("NewUserViewModel", "ViewModel is Created");


    }
}
