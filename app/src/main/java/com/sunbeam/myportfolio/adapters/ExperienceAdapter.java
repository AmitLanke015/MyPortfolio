package com.sunbeam.myportfolio.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sunbeam.myportfolio.R;
import com.sunbeam.myportfolio.models.Experience;

import java.util.List;

public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.ExperienceViewHolder> {

    private List<Experience> experienceList;

    public ExperienceAdapter(List<Experience> experienceList) {
        this.experienceList = experienceList;
    }

    @NonNull
    @Override
    public ExperienceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_experience, parent, false);
        return new ExperienceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExperienceViewHolder holder, int position) {
        Experience experience = experienceList.get(position);
        holder.tvTitle.setText(experience.getTitle());
        holder.tvDate.setText(experience.getDate());
        holder.tvDesc.setText(experience.getDescription());
        
        // Hide line for last item?
        if (position == experienceList.size() - 1) {
            holder.line.setVisibility(View.GONE);
        } else {
            holder.line.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return experienceList.size();
    }

    static class ExperienceViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDate, tvDesc;
        View line;

        public ExperienceViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_exp_item_title);
            tvDate = itemView.findViewById(R.id.tv_exp_item_date);
            tvDesc = itemView.findViewById(R.id.tv_exp_item_desc);
            line = itemView.findViewById(R.id.view_line);
        }
    }
}
