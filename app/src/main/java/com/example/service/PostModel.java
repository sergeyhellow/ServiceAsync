package com.example.service;



public class PostModel {
    private String slug;
    private String title;


    public PostModel() {}


    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "PostInfo{" +
                "slug='" + slug + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

