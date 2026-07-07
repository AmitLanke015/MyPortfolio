package com.sunbeam.myportfolio.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.sunbeam.myportfolio.R;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btn_resume).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://drive.google.com/file/d/111wNL4ssdwu6Z4dxe9FExBgLbVfZJ3KZ/view?usp=sharing"));
            startActivity(intent);
        });

        view.findViewById(R.id.btn_projects).setOnClickListener(v -> 
            Navigation.findNavController(view).navigate(R.id.navigation_projects));

        view.findViewById(R.id.btn_contact).setOnClickListener(v -> 
            Navigation.findNavController(view).navigate(R.id.navigation_contact));

        view.findViewById(R.id.btn_more_about).setOnClickListener(v -> 
            Navigation.findNavController(view).navigate(R.id.navigation_about));
    }
}
