package com.alkemy.myapplication.domain;

import android.view.View;

import com.alkemy.myapplication.core.DataBaseConection;
import com.alkemy.myapplication.data.models.repo.ActivitiesRepo;
import com.alkemy.myapplication.data.models.repo.UserRepository;


public class DataBaseUseCase implements DataBaseConection {
    UserRepository userRepository = new UserRepository();
    ActivitiesRepo activitiesRepo = new ActivitiesRepo();

    public void setUser( String id,
                         String name,
                         String user,
                         Long token,
                         Long cellphone){
        userRepository.setUserData(id,name,user,token,cellphone);

    }
    public void createUserUC(String user,
                             String password){
        userRepository.createUser(user,password);
    }

    public void loginUC(String user,
                        String password){
         userRepository.login(user,password);
    }

    public void getActivitiesReserve(String a){
        activitiesRepo.getActivities(a);
    }
}
