package com.itai.mymoviesappbylistviewsinglefrag.model;

import java.io.Serializable;

// Constructor MovieContent
public class MovieModel implements Serializable {

    private String name;
    private int imageResourceId;
    private String overview;

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public String toString() {
        return "MovieContent{" +
                "name='" + name + '\'' +
                ", imageResourceId=" + imageResourceId +
                ", overview='" + overview + '\'' +
                '}';
    }

    }
