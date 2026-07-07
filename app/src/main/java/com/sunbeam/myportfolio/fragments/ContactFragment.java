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

import com.sunbeam.myportfolio.R;

public class ContactFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.card_email).setOnClickListener(v -> openEmail());
        view.findViewById(R.id.card_phone).setOnClickListener(v -> openDialer());
        view.findViewById(R.id.card_linkedin).setOnClickListener(v -> openUrl("https://www.linkedin.com/in/amit-lanke-5986a2225"));
        view.findViewById(R.id.card_github).setOnClickListener(v -> openUrl("https://github.com/AmitLanke015"));
        view.findViewById(R.id.card_location).setOnClickListener(v -> openMap());
    }

    private void openEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:alanke015@gmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Portfolio Inquiry");
        startActivity(intent);
    }

    private void openDialer() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+919112657257"));
        startActivity(intent);
    }

    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void openMap() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q=Pune, Maharashtra"));
        startActivity(intent);
    }
}
