package com.sunbeam.myportfolio.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.sunbeam.myportfolio.R;
import com.sunbeam.myportfolio.models.Skill;

import java.util.List;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.SkillViewHolder> {

    private List<Skill> skillList;

    public SkillAdapter(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public void updateSkills(List<Skill> newSkills) {
        this.skillList = newSkills;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SkillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_skill, parent, false);
        return new SkillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillViewHolder holder, int position) {
        Skill skill = skillList.get(position);
        holder.tvName.setText(skill.getName());
        holder.tvPercent.setText(skill.getProficiency() + "%");
        
        // Use a post delay or ObjectAnimator to ensure animation triggers after binding
        holder.progress.setProgress(0);
        holder.progress.post(() -> {
            holder.progress.setProgressCompat(skill.getProficiency(), true);
        });
        
        // Use local image resource
        if (skill.getImageResId() != 0) {
            holder.ivBg.setImageResource(skill.getImageResId());
        } else {
            holder.ivBg.setImageResource(R.drawable.gradient_background);
        }
    }

    @Override
    public int getItemCount() {
        return skillList.size();
    }

    static class SkillViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPercent;
        CircularProgressIndicator progress;
        ImageView ivBg;

        public SkillViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_skill_name);
            tvPercent = itemView.findViewById(R.id.tv_skill_percent);
            progress = itemView.findViewById(R.id.progress_skill);
            ivBg = itemView.findViewById(R.id.iv_skill_bg);
        }
    }
}
