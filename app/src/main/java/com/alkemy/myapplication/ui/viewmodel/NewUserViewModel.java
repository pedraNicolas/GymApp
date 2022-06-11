package com.alkemy.myapplication.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.alkemy.myapplication.domain.DataBaseUseCase;

public class NewUserViewModel extends ViewModel {

    DataBaseUseCase dataBaseUseCase = new DataBaseUseCase();
    public void createUser( String id,
                       String name,
                       String user,
                       String password,
                       int token,
                       int cellphone){
    dataBaseUseCase.setUser(id,name,user,password,token,cellphone);
    }

//    public void userList(){
//        User currentUser =
//    }


    public NewUserViewModel() {
        Log.i("NewUserViewModel","ViewModel is Created");



    }
}
