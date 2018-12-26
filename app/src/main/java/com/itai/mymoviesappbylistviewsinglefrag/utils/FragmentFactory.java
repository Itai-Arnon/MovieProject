package com.itai.mymoviesappbylistviewsinglefrag.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.itai.mymoviesappbylistviewsinglefrag.fragments.DetailFragment;
import com.itai.mymoviesappbylistviewsinglefrag.model.MovieModel;

public class FragmentFactory extends Fragment {
    private static final String FRAG_MODEL = "FRAG_MODEL";

    //factory method, recieves which number the fragment is
    public static DetailFragment newInstance( MovieModel movie) {

        DetailFragment movieFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(FRAG_MODEL, movie);
        movieFragment.setArguments(bundle);
    return movieFragment;
    }
}