package com.alkemy.myapplication.domain;

import android.view.View;

import com.alkemy.myapplication.core.DataBaseConection;
import com.alkemy.myapplication.data.models.User;
import com.alkemy.myapplication.data.models.repo.UserRepository;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.Map;

public class DataBaseUseCase implements DataBaseConection {
    UserRepository userRepository = new UserRepository();
    public void setUser( String id,
                         String name,
                         String user,
                         String password,
                         int token,
                         int cellphone){
        userRepository.setUserData(id,name,user,password,token,cellphone);

    }
    public void createUserUC(String user,
                             String password){
        userRepository.createUser(user,password);
    }

    public void loginUC(String user,
                        String password){
         userRepository.login(user,password);
    }
}
