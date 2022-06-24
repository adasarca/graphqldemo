package com.adasarca.graphqldemo.model;

public class Link {

    private int id;
    private String url;
    private String description;

    private Integer userId;

    public Link() {}

    public Link(String url, String description, Integer userId) {
        this.url = url;
        this.description = description;
        this.userId = userId;
    }

    public Link(int id, String url, String description, Integer userId) {
        this.id = id;
        this.url = url;
        this.description = description;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
