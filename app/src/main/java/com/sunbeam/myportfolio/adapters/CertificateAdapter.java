package com.sunbeam.myportfolio.adapters;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.sunbeam.myportfolio.R;
import com.sunbeam.myportfolio.models.Certificate;

import java.util.List;

public class CertificateAdapter extends RecyclerView.Adapter<CertificateAdapter.CertificateViewHolder> {

    private List<Certificate> certificateList;

    public CertificateAdapter(List<Certificate> certificateList) {
        this.certificateList = certificateList;
    }

    @NonNull
    @Override
    public CertificateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_certificate, parent, false);
        return new CertificateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CertificateViewHolder holder, int position) {
        Certificate certificate = certificateList.get(position);
        holder.tvTitle.setText(certificate.getTitle());
        holder.tvOrg.setText(certificate.getOrganization());
        holder.tvDate.setText(certificate.getDate());
        holder.tvDesc.setText(certificate.getDescription());

        holder.btnView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(certificate.getUrl()));
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return certificateList.size();
    }

    static class CertificateViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvOrg, tvDate, tvDesc;
        MaterialButton btnView;

        public CertificateViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_cert_title);
            tvOrg = itemView.findViewById(R.id.tv_cert_org);
            tvDate = itemView.findViewById(R.id.tv_cert_date);
            tvDesc = itemView.findViewById(R.id.tv_cert_desc);
            btnView = itemView.findViewById(R.id.btn_view_cert);
        }
    }
}
