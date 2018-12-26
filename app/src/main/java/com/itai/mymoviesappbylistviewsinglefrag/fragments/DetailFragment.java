package com.itai.mymoviesappbylistviewsinglefrag.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.itai.mymoviesappbylistviewsinglefrag.R;
import com.itai.mymoviesappbylistviewsinglefrag.model.MovieModel;


public class DetailFragment extends Fragment{
    private ImageView large, small;
    private TextView title_text, overview_text;
    private FragmentListener mListener;
    private static final String FRAG_MODEL = "FRAG_MODEL";

    /*
     * This is a reusable fragment meant to represent detailed
     * info about each movie corresponding the master list
     *fragment. We we'll have to create n fragments in correspondence
     *to the number of movies.
     *#### the recycler view will give us the movie name i.e model view
     * we use fragment factory ,in conjunction
     *
     * */



    /*todo 1.feed the fragment with the bundle
        todo  2. optional: put a listener to the interface that returns it to the master fragment
    /*todo 3. REMOve On Create if not need
    * */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View fragmentView = inflater.inflate(R.layout.fragment_detail, container, false);

        MovieModel movie =(MovieModel) getArguments().getSerializable(FRAG_MODEL);
        //large and small have the same pic
        large = fragmentView.findViewById(R.id.big_poster);
        small = fragmentView.findViewById(R.id.little_poster);
        title_text = fragmentView.findViewById(R.id.title);
        overview_text = fragmentView.findViewById(R.id.overview);

        large.setImageResource(movie.getImageResourceId());
        small.setImageResource(movie.getImageResourceId());
        title_text.setText(movie.getName());
        overview_text.setText(movie.getOverview());


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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */


}

