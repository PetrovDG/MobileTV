package info.geostage.mobiletv.Subcategory33;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;


/**
 * Loads a list of categories by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class Movies33Loader extends AsyncTaskLoader<List<Movies33>> {

    /**
     * Tag for log messages
     */
    private static final String LOG_TAG = Movies33Loader.class.getName();

    /**
     * Query URL
     */
    private String mUrl;

    /**
     * Constructs a new {@link Movies33Loader}.
     *
     * @param context of the activity
     * @param url     to load data from
     */
    public Movies33Loader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Movies33> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of categories.
        List<Movies33> categories = QueryUtils33.fetchMovies33Data(mUrl);
        return categories;
    }
}
