package com.itai.mymoviesappbylistviewsinglefrag.adapters;

import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itai.mymoviesappbylistviewsinglefrag.R;
import com.itai.mymoviesappbylistviewsinglefrag.model.MovieModel;

import java.util.ArrayList;
//4.12.18

public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.ViewHolder> {
    private ArrayList<MovieModel> dataArray;
    private PagerListener listener;

    public MovieRecyclerAdapter(ArrayList<MovieModel> dataArray,PagerListener listener) {
        this.dataArray = dataArray;
        this.listener = listener;
    }

    public interface PagerListener {

        void gotoFragmentListener(MovieModel movie);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int pos) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie,
                parent, false);
        final ViewHolder VH = new ViewHolder(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieModel movie = dataArray.get(VH.getAdapterPosition());
                if (listener != null)
                    //onLocation will be defined completely in FavoriteFrag
                    listener.gotoFragmentListener(movie);
            }

        });

        return VH;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieRecyclerAdapter.ViewHolder viewHolder, int pos) {

        ImageView imgSource;
        TextView title_text, overview_text;

        View singleItemView = viewHolder.mItemView;
        MovieModel movie = dataArray.get(pos);

        imgSource = singleItemView.findViewById(R.id.item_movie_iv);
        title_text = singleItemView.findViewById(R.id.item_movie_tv_title);
        overview_text = singleItemView.findViewById(R.id.item_movie_tv_overview);

        if (movie != null) {
            imgSource.setImageResource(movie.getImageResourceId());
            title_text.setText(movie.getName());
            overview_text.setText(movie.getOverview());
        }
    }
 //public void OnClickYouTube(View view) {


    //provides better control of what views to show within the CardView
    @Override
    public int getItemViewType(final int position) {
        return R.layout.item_movie;
    }



    @Override
    public int getItemCount() {
        return dataArray.size();
    }

   static class ViewHolder extends RecyclerView.ViewHolder {
        private View mItemView;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
        }
    }


}



