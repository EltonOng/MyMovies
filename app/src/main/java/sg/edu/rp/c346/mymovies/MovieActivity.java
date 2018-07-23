package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MovieActivity extends AppCompatActivity {

    ImageView ivRated;
    TextView tvTitle;
    TextView tvYear;
    TextView tvGenre;
    TextView tvDescription;
    TextView tvWatched;
    TextView tvtheatre;
    RatingBar rbRating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        ivRated = findViewById(R.id.imageViewRating);
        tvTitle = findViewById(R.id.textViewTitle);
        tvYear = findViewById(R.id.textViewYear);
        tvGenre = findViewById(R.id.textViewGenre);
        tvDescription = findViewById(R.id.textViewDescription);
        tvWatched = findViewById(R.id.textViewWatched);
        tvtheatre = findViewById(R.id.textViewThreatre);
        rbRating = findViewById(R.id.ratingBar);

        Intent intentReceived = getIntent();
        String title = intentReceived.getStringExtra("title");
        String year = intentReceived.getStringExtra("year");
        String genre = intentReceived.getStringExtra("genre");
        String description = intentReceived.getStringExtra("description");
        String theatre = intentReceived.getStringExtra("theatre");
        String watched = intentReceived.getStringExtra("date");
        String rated = intentReceived.getStringExtra("rated");
        int rating = intentReceived.getIntExtra("rating",0);

        tvTitle.setText(title);
        tvYear.setText(year + " - ");
        tvGenre.setText(genre);
        tvDescription.setText(description);
        tvWatched.setText("Watch on: " + watched);
        tvtheatre.setText("In Theatre: " + theatre);

        rbRating.setNumStars(5);
        rbRating.setRating(rating);
        rbRating.setIsIndicator(true);

        if(rated.equals("g")){
            ivRated.setImageResource(R.drawable.rating_g);
        }
        else if(rated.equals("pg")){
            ivRated.setImageResource(R.drawable.rating_pg);
        }
        else if(rated.equals("pg13")){
            ivRated.setImageResource(R.drawable.rating_pg13);
        }
        else if(rated.equals("nc16")){
            ivRated.setImageResource(R.drawable.rating_nc16);
        }
        else if(rated.equals("m18")){
            ivRated.setImageResource(R.drawable.rating_m18);
        }
        else if(rated.equals("r21")){
            ivRated.setImageResource(R.drawable.rating_r21);
        }



    }
}
