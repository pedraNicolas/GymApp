package com.alkemy.myapplication.ui.viewmodel;

import android.content.ClipData;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alkemy.myapplication.data.models.User;
import com.alkemy.myapplication.data.models.repo.AppointmentRepository;
import com.alkemy.myapplication.domain.DataBaseUseCase;
import com.alkemy.myapplication.ui.view.HomeActivity;
import com.alkemy.myapplication.ui.view.fragments.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragmentViewModel extends ViewModel {
    DataBaseUseCase dataBaseUseCase = new DataBaseUseCase();
    AppointmentRepository appointmentRepository = new AppointmentRepository();


    private final MutableLiveData<User> selectedItem = new MutableLiveData<User>();

    public void selectItem(User user) {
        selectedItem.setValue(user);
    }

    public LiveData<User> getSelectedItem() {
        return selectedItem;
    }

    public void setAppointmentRepositoryVM(
            ArrayList<String> list,
            User user,
            int caso) {
        dataBaseUseCase.setAppointmentRepositoryUC(list, user,caso);
    }
    public boolean userAppointmentVM(
            ArrayList<String> list,
            User user) {
        return dataBaseUseCase.userAppointmentUC(list, user);
    }

}
