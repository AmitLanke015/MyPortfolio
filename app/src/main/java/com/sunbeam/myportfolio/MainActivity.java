package com.sunbeam.myportfolio;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "theme_prefs";
    private static final String KEY_IS_DARK_MODE = "is_dark_mode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);

        // Apply theme before super.onCreate
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        boolean isDarkMode = prefs.getBoolean(KEY_IS_DARK_MODE, false);
        
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        FloatingActionButton fabTheme = findViewById(R.id.fab_theme);
        BottomNavigationView navView = findViewById(R.id.bottom_nav);

        // Update the FAB icon based on the mode we just applied
        // If we are in dark mode, show the "Sun" icon to switch to light
        // If we are in light mode, show the "Moon" icon to switch to dark
        if (isDarkMode) {
            fabTheme.setImageResource(R.drawable.light_mode_24);
        } else {
            fabTheme.setImageResource(R.drawable.dark_mode_24);
        }

        fabTheme.setOnClickListener(v -> toggleTheme());

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();
            NavigationUI.setupWithNavController(navView, navController);
            NavigationUI.setupWithNavController(toolbar, navController);
        }
    }

    private void toggleTheme() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        boolean isDarkMode = prefs.getBoolean(KEY_IS_DARK_MODE, false);
        
        SharedPreferences.Editor editor = prefs.edit();
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            editor.putBoolean(KEY_IS_DARK_MODE, false);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            editor.putBoolean(KEY_IS_DARK_MODE, true);
        }
        editor.apply();
        
        // Activity will be recreated automatically by setDefaultNightMode in most cases,
        // but calling recreate() ensures the UI updates immediately.
        recreate();
    }
}
