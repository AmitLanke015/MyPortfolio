package com.sunbeam.myportfolio.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.sunbeam.myportfolio.R;
import com.sunbeam.myportfolio.adapters.ExperienceAdapter;
import com.sunbeam.myportfolio.viewmodels.PortfolioViewModel;

public class ExperienceFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_experience, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.rv_experience);

        PortfolioViewModel viewModel = new ViewModelProvider(this).get(PortfolioViewModel.class);
        viewModel.getExperiences().observe(getViewLifecycleOwner(), experiences -> {
            ExperienceAdapter adapter = new ExperienceAdapter(experiences);
            recyclerView.setAdapter(adapter);
        });
    }
}
