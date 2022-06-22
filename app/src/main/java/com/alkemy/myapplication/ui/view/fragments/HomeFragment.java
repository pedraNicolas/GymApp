package com.alkemy.myapplication.ui.view.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alkemy.myapplication.data.models.User;
import com.alkemy.myapplication.databinding.FragmentHomeBinding;
import com.alkemy.myapplication.ui.viewmodel.HomeFragmentViewModel;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    HomeFragmentViewModel homeFragmentViewModel;
    LocalDateTime todaysDate = LocalDateTime.now();
//    public HomeFragment() {
//    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        homeFragmentViewModel = new ViewModelProvider(requireActivity()).get(HomeFragmentViewModel.class);
        User user = homeFragmentViewModel.getSelectedItem().getValue();
        Log.d("fragment", user.getName());
        binding.editTextDate.setText(todaysDate.toString());
        binding.helloTextView.setText("Hola " + user.getName());
        binding.remainsTokenTextView.setText("Tokens disponibles: " + user.getToken().toString());

        binding.electrofitnessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeFragmentViewModel.getActivitiesReserveVM("electrofitness");
                System.out.println("button");
            }
        });
        //binding.helloTextView.setText(name);


        return binding.getRoot();
    }
}