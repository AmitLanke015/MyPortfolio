package com.sunbeam.myportfolio.models;

public class Project {
    private String title;
    private String description;
    private String technologies;
    private String githubUrl;
    private String demoUrl;
    private int imageResId;

    public Project(String title, String description, String technologies, String githubUrl, String demoUrl, int imageResId) {
        this.title = title;
        this.description = description;
        this.technologies = technologies;
        this.githubUrl = githubUrl;
        this.demoUrl = demoUrl;
        this.imageResId = imageResId;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getTechnologies() { return technologies; }
    public String getGithubUrl() { return githubUrl; }
    public String getDemoUrl() { return demoUrl; }
    public int getImageResId() { return imageResId; }
}
