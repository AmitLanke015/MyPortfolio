package com.sunbeam.myportfolio.models;

public class Certificate {
    private String title;
    private String organization;
    private String date;
    private String description;
    private String url;

    public Certificate(String title, String organization, String date, String description, String url) {
        this.title = title;
        this.organization = organization;
        this.date = date;
        this.description = description;
        this.url = url;
    }

    public String getTitle() { return title; }
    public String getOrganization() { return organization; }
    public String getDate() { return date; }
    public String getDescription() { return description; }
    public String getUrl() { return url; }
}
