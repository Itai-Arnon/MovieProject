package com.itai.mymoviesappbylistviewsinglefrag.model;



import java.util.ArrayList;
import java.util.List;


/**
 * Created By Yamin on 22-09-2018
 *
 * Static Methods meant to mediate between the Movie Content
 */



public class MovieContent {

    public static final List<MovieContent> MOVIES = new ArrayList<>();

        public static void clear() {
            MOVIES.clear();
        }

        public static void addMovie(MovieContent movie) {
            MOVIES.add(movie);
        }
    }

