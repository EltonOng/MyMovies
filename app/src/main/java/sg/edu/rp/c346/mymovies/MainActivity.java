package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    int viewId;

    ArrayList<Movie> alMovie;
    CustomAdapter caMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.listViewMovies);

        alMovie = new ArrayList<>();
        Calendar date1 = Calendar.getInstance();
        date1.set(2014,11,15);
        Calendar date2 = Calendar.getInstance();
        date2.set(2015,5,15);

        Movie m1 = new Movie("The Avengers","2012","pg13","Action | Sci-Fi",date1,"Golden Village - Bishan","Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.",4);
        Movie m2 = new Movie("Planes","2013","pg","Animation | Comedy",date2,"Cathy - AMK Hub","A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.",2);

        alMovie.add(m1);
        alMovie.add(m2);

        caMovie = new CustomAdapter(this, R.layout.movie_item,alMovie);
        lvMovie.setAdapter(caMovie);

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movie currentItem = alMovie.get(i);
                Intent intent = new Intent(getBaseContext(), MovieActivity.class);

                intent.putExtra("title",currentItem.getTitle());
                intent.putExtra("year",currentItem.getTitle());
                intent.putExtra("rated",currentItem.getRated());
                intent.putExtra("genre",currentItem.getGenre());
                intent.putExtra("date",currentItem.getDateString());
                intent.putExtra("theatre",currentItem.getIn_theatre());
                intent.putExtra("description",currentItem.getDescription());
                intent.putExtra("rating",currentItem.getRating());
                startActivity(intent);
            }
        });



    }
}
