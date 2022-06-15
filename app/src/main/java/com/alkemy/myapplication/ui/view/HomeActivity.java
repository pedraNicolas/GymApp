package com.alkemy.myapplication.ui.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.alkemy.myapplication.R;
import com.alkemy.myapplication.databinding.ActivityHomeBinding;
import com.alkemy.myapplication.databinding.ActivityMainBinding;
import com.alkemy.myapplication.ui.view.fragments.DateFragment;
import com.alkemy.myapplication.ui.view.fragments.ProfileFragment;
import com.alkemy.myapplication.ui.view.fragments.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;

    HomeFragment homeFragment = new HomeFragment();
    DateFragment dateFragment = new DateFragment();
    ProfileFragment profileFragment = new ProfileFragment();

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

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.commit();
    }
}