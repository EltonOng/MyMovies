package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

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


        Movie mList = (Movie) intentReceived.getSerializableExtra("list");

        tvTitle.setText(mList.getTitle());
        tvYear.setText(mList.getYear() + " - ");
        tvGenre.setText(mList.getGenre());
        tvDescription.setText(mList.getDescription());
        tvWatched.setText("Watch on: " + mList.getDateString());
        tvtheatre.setText("In Theatre: " + mList.getIn_theatre());

        rbRating.setNumStars(5);
        rbRating.setRating(mList.getRating());
        rbRating.setIsIndicator(true);


        if(mList.getRated().equals("g")){
            ivRated.setImageResource(R.drawable.rating_g);
        }
        else if(mList.getRated().equals("pg")){
            ivRated.setImageResource(R.drawable.rating_pg);
        }
        else if(mList.getRated().equals("pg13")){
            ivRated.setImageResource(R.drawable.rating_pg13);
        }
        else if(mList.getRated().equals("nc16")){
            ivRated.setImageResource(R.drawable.rating_nc16);
        }
        else if(mList.getRated().equals("m18")){
            ivRated.setImageResource(R.drawable.rating_m18);
        }
        else if(mList.getRated().equals("r21")){
            ivRated.setImageResource(R.drawable.rating_r21);
        }




    }
}
