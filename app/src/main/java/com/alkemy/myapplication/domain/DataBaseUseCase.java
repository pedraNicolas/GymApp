package com.alkemy.myapplication.domain;

import com.alkemy.myapplication.core.DataBaseConection;

import com.alkemy.myapplication.data.models.RecyclerView.Adapter;
import com.alkemy.myapplication.data.models.RecyclerView.ItemClickListener;
import com.alkemy.myapplication.data.models.User;
import com.alkemy.myapplication.data.models.repo.AppointmentRepository;
import com.alkemy.myapplication.data.models.repo.DateRepository;
import com.alkemy.myapplication.data.models.repo.UserRepository;

import java.util.ArrayList;


public class DataBaseUseCase implements DataBaseConection {
    UserRepository userRepository = new UserRepository();
    DateRepository dateRepository = new DateRepository();
    AppointmentRepository appointmentRepository = new AppointmentRepository();

    public void setUser(String id,
                        String name,
                        String user,
                        Long token,
                        Long cellphone) {
        userRepository.setUserData(id, name, user, token, cellphone);

    }

    public void createUserUC(String user,
                             String password) {
        userRepository.createUser(user, password);
    }

    public void loginUC(String user,
                        String password) {
        userRepository.login(user, password);
    }

    public void setAppointmentRepositoryUC(
            ArrayList<String> list,
            User user,
            int caso) {
        appointmentRepository.appointment(list, user, caso);
    }
    public boolean userAppointmentUC(
            ArrayList<String> list,
            User user){
        return appointmentRepository.userAppointment(list,user);
    }
}




