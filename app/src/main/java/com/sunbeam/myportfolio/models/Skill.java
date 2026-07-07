package com.sunbeam.myportfolio.models;

public class Skill {
    private String name;
    private int proficiency; // 0 to 100
    private int imageResId;

    public Skill(String name, int proficiency, int imageResId) {
        this.name = name;
        this.proficiency = proficiency;
        this.imageResId = imageResId;
    }

    public String getName() { return name; }
    public int getProficiency() { return proficiency; }
    public int getImageResId() { return imageResId; }
}
