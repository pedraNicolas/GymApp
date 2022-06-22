package com.alkemy.myapplication.ui.viewmodel;

import android.content.ClipData;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alkemy.myapplication.data.models.User;
import com.alkemy.myapplication.domain.DataBaseUseCase;

public class HomeFragmentViewModel extends ViewModel {
    DataBaseUseCase dataBaseUseCase = new DataBaseUseCase();

    public void getActivitiesReserveVM(String a){
        dataBaseUseCase.getActivitiesReserve(a);
    }

    private final MutableLiveData<User> selectedItem = new MutableLiveData<User>();

    public void selectItem(User user) {
        selectedItem.setValue(user);
    }
    public LiveData<User> getSelectedItem() {
        return selectedItem;
    }
}
