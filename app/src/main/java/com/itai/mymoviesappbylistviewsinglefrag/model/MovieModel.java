package com.itai.mymoviesappbylistviewsinglefrag.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Objects;

// Constructor MovieContent
public class MovieModel implements  Parcelable {

    private String name;
    private int imageResourceId;
    private String overview;

    public MovieModel(){}

    protected MovieModel(Parcel in) {
        name = in.readString();
        imageResourceId = in.readInt();
        overview = in.readString();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(imageResourceId);
        dest.writeString(overview);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieModel)) return false;
        MovieModel that = (MovieModel) o;
        return imageResourceId == that.imageResourceId &&
                Objects.equals(name, that.name) &&
                Objects.equals(overview, that.overview);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, imageResourceId, overview);
    }
}
