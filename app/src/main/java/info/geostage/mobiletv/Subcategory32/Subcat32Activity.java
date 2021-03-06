package info.geostage.mobiletv.Subcategory32;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;

import info.geostage.mobiletv.CategoryActivity;
import info.geostage.mobiletv.R;
import info.geostage.mobiletv.SettingsActivity;
import info.geostage.mobiletv.Subcategory33.Movies33;
import info.geostage.mobiletv.Subcategory33.Movies33Adapter;
import info.geostage.mobiletv.Subcategory33.Subcat33Activity;


public class Subcat32Activity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Movies33>> {

    /**
     * Tag for the log messages
     */
    private static final String LOG_TAG = Subcat33Activity.class.getName();

    /**
     * URL for movies from the Mobile TV platform
     */
    private static final String LINK = "http://dev.mobiletv.bg/4P1/kidsvod/json.php?user=veroun1@gmail.com&pass=test1&mode=categories";

    /**
     * Constant value for the movies loader ID.
     */
    private static final int MOVIES_LOADER_ID = 1;

    /**
     * Adapter for the list of movies
     */
    private Movies33Adapter movies33Adapter;

    /**
     * TextView that is displayed when the list is empty
     */
    private TextView mEmptyStateTextView;

    /**
     * Progress Bar to use while running query
     */
    View progressBar;
    private SharedPreferences mSharedPreferences;
    private RelativeLayout mRelativeLayout;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                Intent settingsIntent = new Intent(this, SettingsActivity.class);
                startActivity(settingsIntent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcat33);


        // Find a reference to the {@link ListView} in the layout
        ListView moviesListView = (ListView) findViewById(R.id.list33);

        // Get the widgets reference from XML layout
        mRelativeLayout = (RelativeLayout) findViewById(R.id.list_layout33);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        moviesListView.setEmptyView(mEmptyStateTextView);

        // Create a new adapter that takes an empty list of movies as input
        movies33Adapter = new Movies33Adapter(this, new ArrayList<Movies33>());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        moviesListView.setAdapter(movies33Adapter);

        // Set an item click listener on the ListView, which sends an intent to a web browser
        // to open a website with more information about the selected article.
        moviesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Movies33 currentMovie = movies33Adapter.getItem(position);
                String subcheck = String.valueOf(currentMovie.getId());
                if (subcheck.equals("32")) {
                    Intent intent33 = new Intent(Subcat32Activity.this, CategoryActivity.class);
                    startActivity(intent33);
                }

            }
        });

        // Get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        // Get details on the currently active default data network
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        // If there is a network connection, fetch data
        if (networkInfo != null && networkInfo.isConnected()) {
            // Get a reference to the LoaderManager, in order to interact with loaders.
            LoaderManager loaderManager = getLoaderManager();
            // Initialize the loader. Pass in the int ID constant defined above and pass in null for
            // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
            // because this activity implements the LoaderCallbacks interface).
            loaderManager.initLoader(MOVIES_LOADER_ID, null, this);
        } else {
            // Otherwise, display error
            // First, hide loading indicator so error message will be visible
            progressBar = findViewById(R.id.progress_bar);
            progressBar.setVisibility(View.GONE);

            // Update empty state with no connection error message
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }

        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("test1", "test1".toCharArray());
            }
        });

        // Get the instance of SharedPreferences object
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        // Retrieve background color value as a string
        String backgroundColor = mSharedPreferences.getString(getString(R.string.key_background_color), "#FFFFFF");
        // Set a layout background color based on user preference settings
        mRelativeLayout.setBackgroundColor(Color.parseColor(backgroundColor));

    }

    private static class Movies33Loader extends AsyncTaskLoader<List<Movies33>> {

        /**
         * Tag for log messages
         */
        private final String LOG_TAG = Movies33Loader.class.getName();

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
            List<Movies33> categories = QueryUtils32.fetchMovies33Data(mUrl);
            return categories;
        }
    }

    @Override
    public Loader<List<Movies33>> onCreateLoader(int id, Bundle args) {

        Uri baseUri = Uri.parse(LINK);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        return new Movies33Loader(this, uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(Loader<List<Movies33>> loader, List<Movies33> categories) {

        // Hide progress bar because the data has been loaded
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);

        // Set empty state text to display "No songs found!"
        mEmptyStateTextView.setText(R.string.no_songs);

        // Clear the adapter of previous movies data
        movies33Adapter.clear();

        // If there is a valid list of {@link Movies}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (categories != null && !categories.isEmpty()) {
            movies33Adapter.addAll(categories);
        } else {
            // Hide progress bar because the data has been loaded
            progressBar = findViewById(R.id.progress_bar);
            progressBar.setVisibility(View.GONE);
        }

    }

    @Override
    public void onLoaderReset(Loader<List<Movies33>> loader) {
        // Loader reset, so we can clear out our existing data.
        movies33Adapter.clear();
    }

    @Override
    public void onRestart() {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }
}

