package sg.edu.rp.c346.mymovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 16043971 on 23/7/2018.
 */

public class CustomAdapter extends ArrayAdapter{

    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Movie> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) parent_context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layout_id, parent, false);
        }

        ImageView ivRated = convertView.findViewById(R.id.imageViewRating);
        TextView tvTitle = convertView.findViewById(R.id.textViewTitle);
        TextView tvYear = convertView.findViewById(R.id.textViewYear);
        TextView tvGenre = convertView.findViewById(R.id.textViewGenre);
        Movie currentItem = movieList.get(position);
        tvTitle.setText(currentItem.getTitle());
        tvYear.setText(currentItem.getYear() + " - ");
        tvGenre.setText(currentItem.getGenre());
        if(currentItem.getRated().equals("g")){
            ivRated.setImageResource(R.drawable.rating_g);
        }
        else if(currentItem.getRated().equals("pg")){
            ivRated.setImageResource(R.drawable.rating_pg);
        }
        else if(currentItem.getRated().equals("pg13")){
            ivRated.setImageResource(R.drawable.rating_pg13);
        }
        else if(currentItem.getRated().equals("nc16")){
            ivRated.setImageResource(R.drawable.rating_nc16);
        }
        else if(currentItem.getRated().equals("m18")){
            ivRated.setImageResource(R.drawable.rating_m18);
        }
        else if(currentItem.getRated().equals("r21")){
            ivRated.setImageResource(R.drawable.rating_r21);
        }
        return convertView;
    }
}
