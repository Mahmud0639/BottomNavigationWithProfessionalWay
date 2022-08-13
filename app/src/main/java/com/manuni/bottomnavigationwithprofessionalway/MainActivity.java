package com.manuni.bottomnavigationwithprofessionalway;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.manuni.bottomnavigationwithprofessionalway.fragments.EmailFragment;
import com.manuni.bottomnavigationwithprofessionalway.fragments.GalleryFragment;
import com.manuni.bottomnavigationwithprofessionalway.fragments.InfoFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragments(new GalleryFragment());
    }
    public boolean loadFragments(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer,fragment).commit();
        }

        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment myFragment = null;
        switch (item.getItemId()){
            case R.id.gallery:
                myFragment = new GalleryFragment();
                break;
            case R.id.email:
                myFragment = new EmailFragment();
                break;
            case R.id.info:
                myFragment = new InfoFragment();
                break;
        }
        return loadFragments(myFragment);
    }

    @Override
    public void onBackPressed() {


        if (bottomNavigationView.getSelectedItemId()==R.id.gallery){
            super.onBackPressed();
            finish();
        }else {
            bottomNavigationView.setSelectedItemId(R.id.gallery);
        }
    }
}