package com.alkemy.myapplication.ui.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.alkemy.myapplication.R;
import com.alkemy.myapplication.data.models.User;
import com.alkemy.myapplication.databinding.ActivityHomeBinding;
import com.alkemy.myapplication.ui.view.fragments.DateFragment;
import com.alkemy.myapplication.ui.view.fragments.ProfileFragment;
import com.alkemy.myapplication.ui.view.fragments.HomeFragment;
import com.alkemy.myapplication.ui.viewmodel.HomeFragmentViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    //Variables
    View view;
    private ActivityHomeBinding binding;
    private HomeFragmentViewModel homeFragmentViewModel;
    HomeFragment homeFragment = new HomeFragment();
    DateFragment dateFragment = new DateFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    Intent intentMainActivity = getIntent();

    public HomeActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, HomeFragment.newInstance())
                    .commitNow();
        }

        homeFragmentViewModel = new ViewModelProvider(this).get(HomeFragmentViewModel.class);
        User user = (User) getIntent().getSerializableExtra("user");
        homeFragmentViewModel.selectItem(user);


        binding.bottonNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.firstFragment:
                    loadFragment(homeFragment);
                    return true;
                case R.id.secondFragment:
                    loadFragment(dateFragment);
                    return true;
                case R.id.thirdFragment:
                    loadFragment(profileFragment);
                    return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }



}