package info.geostage.mobiletv.SubSubCategories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import info.geostage.mobiletv.Movies;
import info.geostage.mobiletv.R;

/**
 * An {@link SubSubAdapter} knows how to create a list item layout for each movie
 * in the data source (a list of {@link Movies} objects).
 * <p>
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class SubSubAdapter extends ArrayAdapter<Movies> {

    View movieView;
    TextView titleTextView, idTextView;

    /**
     * Constructs a new {@link SubSubAdapter}.
     *
     * @param context    of the app
     * @param categories is the list of categories, which is the data source of the adapter
     */
    public SubSubAdapter(Context context, List<Movies> categories) {
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
                    R.layout.list_subsubcat, parent, false);
        }
        // Get the {@link Movies} object located at this position in the list
        Movies currentMovie = getItem(position);

        // Find the TextView in the list_category.xml layout with the ID movie_title.
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
