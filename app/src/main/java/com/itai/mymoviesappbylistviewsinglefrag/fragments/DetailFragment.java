package com.itai.mymoviesappbylistviewsinglefrag.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



import com.itai.mymoviesappbylistviewsinglefrag.R;
import com.itai.mymoviesappbylistviewsinglefrag.model.MovieModel;


public class DetailFragment extends Fragment{
    private ImageView large, small;
    private TextView title_text, overview_text;
    private FragmentListener mListener;
    private static final String FRAG_MODEL = "FRAG_MODEL";

    public static Fragment newInstance(MovieModel movieModel) {
        Bundle args = new Bundle();
        args.putParcelable(FRAG_MODEL, movieModel);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /*
     * This is a reusable fragment meant to represent detailed
     * info about each movie corresponding the master list
     *fragment. We we'll have to create n fragments in correspondence
     *to the number of movies.
     *#### the recycler view will give us the movie name i.e model view
     * we use fragment factory ,in conjunction
     *
     * */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_detail, container, false);

        MovieModel movie = getArguments().getParcelable(FRAG_MODEL);
        //large and small have the same pic
        large = fragmentView.findViewById(R.id.big_poster);
        //small = fragmentView.findViewById(R.id.little_poster);
        title_text = fragmentView.findViewById(R.id.title);
        overview_text = fragmentView.findViewById(R.id.overview);

        large.setImageResource(movie.getImageResourceId());
        //small.setImageResource(movie.getImageResourceId());
        title_text.setText(movie.getName());
        overview_text.setText(movie.getOverview());

        Button return_to_list = fragmentView.findViewById(R.id.return_to_list);
        return_to_list.setOnClickListener(new  OnClickListener() {
            @Override
            public void onClick(View v) {

                mListener.returnToList();
            }
        });

        return fragmentView;
    }

    public interface FragmentListener {
        // TODO: Update argument type and name
        void returnToList();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DetailFragment.FragmentListener) {
            mListener = (DetailFragment.FragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnMovieDetail");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}

