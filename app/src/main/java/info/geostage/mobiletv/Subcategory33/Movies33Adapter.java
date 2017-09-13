package info.geostage.mobiletv.Subcategory33;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

import info.geostage.mobiletv.R;


/**
 * An {@link Movies33Adapter} knows how to create a list item layout for each movie
 * in the data source (a list of {@link Movies33} objects).
 * <p>
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class Movies33Adapter extends ArrayAdapter<Movies33> {

    View movieView;
    TextView titleTextView, idTextView;

    /**
     * Constructs a new {@link Movies33Adapter}.
     *
     * @param context of the app
     * @param categories  is the list of categories, which is the data source of the adapter
     */
    public Movies33Adapter(Context context, List<Movies33> categories) {
        super(context, 0, categories);
    }

    /**
     * Returns a list view that displays information about the movie at the given position
     * in the list of categories.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        movieView = convertView;
        if (movieView == null) {
            movieView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_subcat33, parent, false);
        }
        // Get the {@link Movies33} object located at this position in the list
        Movies33 currentMovie = getItem(position);

        // Find the ImageView in the list_subcat33.xml layout with the ID image.
        ImageView thumbnailImageView = (ImageView) movieView.findViewById(R.id.image);
        // Check if there is a link to an image, otherwise use placeholder image.
        if (currentMovie.getPreview() != null) {
            Picasso.with(getContext()).load(currentMovie.getPreview()).into(thumbnailImageView);
        } else {
            thumbnailImageView.setImageResource(R.drawable.no_picture);
        }

        // Find the TextView in the list_subcat33.xml layout with the ID movie_title.
        titleTextView = (TextView) movieView.findViewById(R.id.title);
        // Get the title from the currentMovie object and set this text on the TextView.
        titleTextView.setText(currentMovie.getTitle());

        // Find the TextView in the list_category.xml layout with the ID movie_id.
        idTextView = (TextView) movieView.findViewById(R.id.movie_id);
        // Get the title from the currentMovie object and set this text on the TextView.
        idTextView.setText(currentMovie.getId());

        return movieView;
    }

}
