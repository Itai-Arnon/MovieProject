package com.itai.mymoviesappbylistviewsinglefrag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.itai.mymoviesappbylistviewsinglefrag.fragments.DetailFragment;
import com.itai.mymoviesappbylistviewsinglefrag.model.MovieModel;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements DetailFragment.FragmentListener {
    private static final int SIZE = 2;
    private ViewPager viewPager;
    protected ScreenSlidePagerAdapter pagerAdapter;
    private static final String FRAG_MODEL = "FRAG_MODEL";//Bundle KEY
    private static final String MOVIE_LIST = "movieList";
    private  final  String MOVIE_DATA = "movie" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        System.out.println("Lol!!");
        Log.d("MyTag", "MyLogMessage");

        viewPager = findViewById(R.id.pager); //fragment layout replaced by pager layout
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), loadMovies());
        viewPager.setAdapter(pagerAdapter);
        Intent movieFromList = getIntent();
        MovieModel movieFrom = movieFromList.getParcelableExtra(MOVIE_DATA);

        int index = loadMovies().indexOf(movieFrom); // movieModels.indexOf();
        if(-1 != index){
            viewPager.setCurrentItem(index);
        }
        // throw new Exception("my exception message");
    }

    private ArrayList<MovieModel> loadMovies() {

        ArrayList<MovieModel> movies = new ArrayList<>(9);

        MovieModel movie1 = new MovieModel();
        MovieModel movie2 = new MovieModel();
        MovieModel movie3 = new MovieModel();
        MovieModel movie4 = new MovieModel();
        MovieModel movie5 = new MovieModel();
        MovieModel movie6 = new MovieModel();
        MovieModel movie7 = new MovieModel();
        MovieModel movie8 = new MovieModel();
        MovieModel movie9 = new MovieModel();

        movie1.setName("Jurassic World - Fallen Kingdom");
        movie2.setName("The Meg");
        movie3.setName("The First Purge");
        movie4.setName("Deadpool 2");
        movie5.setName("Black Panther");
        movie6.setName("Ocean's Eight");
        movie7.setName("Interstellar");
        movie8.setName("Thor - Ragnarok");
        movie9.setName("Guardians of the Galaxy");

        movie1.setImageResourceId(R.drawable.jurassic_world_fallen_kingdom);
        movie2.setImageResourceId(R.drawable.the_meg);
        movie3.setImageResourceId(R.drawable.the_first_purge);
        movie4.setImageResourceId(R.drawable.deadpool_2);
        movie5.setImageResourceId(R.drawable.black_panther);
        movie6.setImageResourceId(R.drawable.ocean_eight);
        movie7.setImageResourceId(R.drawable.interstellar);
        movie8.setImageResourceId(R.drawable.thor_ragnarok);
        movie9.setImageResourceId(R.drawable.guardians_of_the_galaxy);

        movie1.setOverview("Three years after the demise of Jurassic World, a volcanic eruption threatens the remaining dinosaurs on the isla Nublar, so Claire Dearing, the former park manager, recruits Owen Grady to help prevent the extinction of the dinosaurs once again");
        movie2.setOverview("A deep sea submersible `pilot revisits his past fears in the Mariana Trench, and accidentally unleashes the seventy foot ancestor of the Great White Shark believed to be extinct");
        movie3.setOverview("To push the crime rate below one percent for the rest of the year, the New Founding Fathers of America test a sociological theory that vents aggression for one night in one isolated community. But when the violence of oppressors meets the rage of the others, the contagion will explode from the trial-city borders and spread across the nation");
        movie4.setOverview("Wisecracking mercenary Deadpool battles the evil and powerful Cable and other bad guys to save a boy's life");
        movie5.setOverview("King T'Challa returns home from America to the reclusive, technologically advanced African nation of Wakanda to serve as his country's new leader. However, T'Challa soon finds that he is challenged for the throne by factions within his own country as well as without. Using powers reserved to Wakandan kings, T'Challa assumes the Black Panther mantel to join with girlfriend Nakia, the queen-mother, his princess-kid sister, members of the Dora Milaje (the Wakandan 'special forces') and an American secret agent, to prevent Wakanda from being dragged into a world war");
        movie6.setOverview("Debbie Ocean, a criminal mastermind, gathers a crew of female thieves to pull off the heist of the century at New York's annual Met Gala");
        movie7.setOverview("Interstellar chronicles the adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space travel and conquer the vast distances involved in an interstellar voyage");
        movie8.setOverview("Thor is on the other side of the universe and finds himself in a race against time to get back to Asgard to stop Ragnarok, the prophecy of destruction to his homeworld and the end of Asgardian civilization, at the hands of an all-powerful new threat, the ruthless Hela");
        movie9.setOverview("Light years from Earth, 26 years after being abducted, Peter Quill finds himself the prime target of a manhunt after discovering an orb wanted by Ronan the Accuser");

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);
        movies.add(movie6);
        movies.add(movie7);
        movies.add(movie8);
        movies.add(movie9);

        return movies;

    }

    @Override  //3.12.18
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    @Override
    public void returnToList() {
        Intent returnTo = new Intent(this,MoviesActivity.class);
        startActivity(returnTo);
    }

    //20.12.18
    class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        private final ArrayList<MovieModel> movieModels;

        //constructor
        public ScreenSlidePagerAdapter(FragmentManager manager, ArrayList<MovieModel> movieModels) {
            super(manager);
            this.movieModels = movieModels;
        }

        @Override
        public Fragment getItem(int position) {
            return DetailFragment.newInstance(movieModels.get(position));
        }

        @Override
        public int getCount() {
            return movieModels == null ? 0 : movieModels.size();
        }//pager function
    }
}