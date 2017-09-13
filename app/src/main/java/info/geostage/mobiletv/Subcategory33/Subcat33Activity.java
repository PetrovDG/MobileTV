package info.geostage.mobiletv.Subcategory33;

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
import info.geostage.mobiletv.SubSubCategories.SubSubCat100;
import info.geostage.mobiletv.SubSubCategories.SubSubCat101;
import info.geostage.mobiletv.SubSubCategories.SubSubCat102;
import info.geostage.mobiletv.SubSubCategories.SubSubCat103;
import info.geostage.mobiletv.SubSubCategories.SubSubCat104;
import info.geostage.mobiletv.SubSubCategories.SubSubCat105;
import info.geostage.mobiletv.SubSubCategories.SubSubCat106;
import info.geostage.mobiletv.SubSubCategories.SubSubCat107;
import info.geostage.mobiletv.SubSubCategories.SubSubCat108;
import info.geostage.mobiletv.SubSubCategories.SubSubCat109;
import info.geostage.mobiletv.SubSubCategories.SubSubCat110;
import info.geostage.mobiletv.SubSubCategories.SubSubCat111;
import info.geostage.mobiletv.SubSubCategories.SubSubCat112;
import info.geostage.mobiletv.SubSubCategories.SubSubCat113;
import info.geostage.mobiletv.SubSubCategories.SubSubCat114;
import info.geostage.mobiletv.SubSubCategories.SubSubCat115;
import info.geostage.mobiletv.SubSubCategories.SubSubCat116;
import info.geostage.mobiletv.SubSubCategories.SubSubCat117;
import info.geostage.mobiletv.SubSubCategories.SubSubCat118;
import info.geostage.mobiletv.SubSubCategories.SubSubCat119;
import info.geostage.mobiletv.SubSubCategories.SubSubCat120;
import info.geostage.mobiletv.SubSubCategories.SubSubCat121;
import info.geostage.mobiletv.SubSubCategories.SubSubCat122;
import info.geostage.mobiletv.SubSubCategories.SubSubCat123;
import info.geostage.mobiletv.SubSubCategories.SubSubCat124;
import info.geostage.mobiletv.SubSubCategories.SubSubCat125;
import info.geostage.mobiletv.SubSubCategories.SubSubCat126;
import info.geostage.mobiletv.SubSubCategories.SubSubCat127;
import info.geostage.mobiletv.SubSubCategories.SubSubCat128;
import info.geostage.mobiletv.SubSubCategories.SubSubCat129;
import info.geostage.mobiletv.SubSubCategories.SubSubCat62;
import info.geostage.mobiletv.SubSubCategories.SubSubCat65;
import info.geostage.mobiletv.SubSubCategories.SubSubCat69;
import info.geostage.mobiletv.SubSubCategories.SubSubCat72;
import info.geostage.mobiletv.SubSubCategories.SubSubCat74;
import info.geostage.mobiletv.SubSubCategories.SubSubCat75;
import info.geostage.mobiletv.SubSubCategories.SubSubCat77;
import info.geostage.mobiletv.SubSubCategories.SubSubCat78;
import info.geostage.mobiletv.SubSubCategories.SubSubCat79;
import info.geostage.mobiletv.SubSubCategories.SubSubCat80;
import info.geostage.mobiletv.SubSubCategories.SubSubCat81;
import info.geostage.mobiletv.SubSubCategories.SubSubCat82;
import info.geostage.mobiletv.SubSubCategories.SubSubCat83;
import info.geostage.mobiletv.SubSubCategories.SubSubCat84;
import info.geostage.mobiletv.SubSubCategories.SubSubCat85;
import info.geostage.mobiletv.SubSubCategories.SubSubCat86;
import info.geostage.mobiletv.SubSubCategories.SubSubCat87;
import info.geostage.mobiletv.SubSubCategories.SubSubCat88;
import info.geostage.mobiletv.SubSubCategories.SubSubCat89;
import info.geostage.mobiletv.SubSubCategories.SubSubCat90;
import info.geostage.mobiletv.SubSubCategories.SubSubCat91;
import info.geostage.mobiletv.SubSubCategories.SubSubCat92;
import info.geostage.mobiletv.SubSubCategories.SubSubCat93;
import info.geostage.mobiletv.SubSubCategories.SubSubCat94;
import info.geostage.mobiletv.SubSubCategories.SubSubCat95;
import info.geostage.mobiletv.SubSubCategories.SubSubCat96;
import info.geostage.mobiletv.SubSubCategories.SubSubCat97;
import info.geostage.mobiletv.SubSubCategories.SubSubCat98;
import info.geostage.mobiletv.SubSubCategories.SubSubCat99;


public class Subcat33Activity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Movies33>> {

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
                if (subcheck.equals("98")) {
                    Intent intent98 = new Intent(Subcat33Activity.this, SubSubCat98.class);
                    startActivity(intent98);
                } else if (subcheck.equals("99")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat99.class);
                    startActivity(intent99);
                } else if (subcheck.equals("77")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat77.class);
                    startActivity(intent99);
                } else if (subcheck.equals("122")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat122.class);
                    startActivity(intent99);
                } else if (subcheck.equals("65")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat65.class);
                    startActivity(intent99);
                } else if (subcheck.equals("107")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat107.class);
                    startActivity(intent99);
                } else if (subcheck.equals("108")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat108.class);
                    startActivity(intent99);
                } else if (subcheck.equals("123")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat123.class);
                    startActivity(intent99);
                } else if (subcheck.equals("119")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat119.class);
                    startActivity(intent99);
                } else if (subcheck.equals("112")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat112.class);
                    startActivity(intent99);
                } else if (subcheck.equals("87")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat87.class);
                    startActivity(intent99);
                } else if (subcheck.equals("62")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat62.class);
                    startActivity(intent99);
                } else if (subcheck.equals("90")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat90.class);
                    startActivity(intent99);
                } else if (subcheck.equals("116")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat116.class);
                    startActivity(intent99);
                } else if (subcheck.equals("120")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat120.class);
                    startActivity(intent99);
                } else if (subcheck.equals("79")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat79.class);
                    startActivity(intent99);
                } else if (subcheck.equals("126")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat126.class);
                    startActivity(intent99);
                } else if (subcheck.equals("106")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat106.class);
                    startActivity(intent99);
                } else if (subcheck.equals("118")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat118.class);
                    startActivity(intent99);
                } else if (subcheck.equals("102")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat102.class);
                    startActivity(intent99);
                } else if (subcheck.equals("109")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat109.class);
                    startActivity(intent99);
                } else if (subcheck.equals("125")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat125.class);
                    startActivity(intent99);
                } else if (subcheck.equals("95")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat95.class);
                    startActivity(intent99);
                } else if (subcheck.equals("75")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat75.class);
                    startActivity(intent99);
                } else if (subcheck.equals("72")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat72.class);
                    startActivity(intent99);
                } else if (subcheck.equals("97")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat97.class);
                    startActivity(intent99);
                } else if (subcheck.equals("74")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat74.class);
                    startActivity(intent99);
                } else if (subcheck.equals("80")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat80.class);
                    startActivity(intent99);
                } else if (subcheck.equals("91")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat91.class);
                    startActivity(intent99);
                } else if (subcheck.equals("93")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat93.class);
                    startActivity(intent99);
                } else if (subcheck.equals("89")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat89.class);
                    startActivity(intent99);
                } else if (subcheck.equals("92")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat92.class);
                    startActivity(intent99);
                } else if (subcheck.equals("86")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat86.class);
                    startActivity(intent99);
                } else if (subcheck.equals("85")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat85.class);
                    startActivity(intent99);
                } else if (subcheck.equals("113")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat113.class);
                    startActivity(intent99);
                } else if (subcheck.equals("81")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat81.class);
                    startActivity(intent99);
                } else if (subcheck.equals("104")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat104.class);
                    startActivity(intent99);
                } else if (subcheck.equals("117")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat117.class);
                    startActivity(intent99);
                } else if (subcheck.equals("82")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat82.class);
                    startActivity(intent99);
                } else if (subcheck.equals("83")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat83.class);
                    startActivity(intent99);
                } else if (subcheck.equals("101")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat101.class);
                    startActivity(intent99);
                } else if (subcheck.equals("114")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat114.class);
                    startActivity(intent99);
                } else if (subcheck.equals("103")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat103.class);
                    startActivity(intent99);
                } else if (subcheck.equals("94")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat94.class);
                    startActivity(intent99);
                } else if (subcheck.equals("110")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat110.class);
                    startActivity(intent99);
                } else if (subcheck.equals("84")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat84.class);
                    startActivity(intent99);
                } else if (subcheck.equals("105")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat105.class);
                    startActivity(intent99);
                } else if (subcheck.equals("100")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat100.class);
                    startActivity(intent99);
                } else if (subcheck.equals("128")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat128.class);
                    startActivity(intent99);
                } else if (subcheck.equals("124")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat124.class);
                    startActivity(intent99);
                } else if (subcheck.equals("121")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat121.class);
                    startActivity(intent99);
                } else if (subcheck.equals("96")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat96.class);
                    startActivity(intent99);
                } else if (subcheck.equals("78")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat78.class);
                    startActivity(intent99);
                } else if (subcheck.equals("129")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat129.class);
                    startActivity(intent99);
                } else if (subcheck.equals("115")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat115.class);
                    startActivity(intent99);
                } else if (subcheck.equals("111")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat111.class);
                    startActivity(intent99);
                } else if (subcheck.equals("127")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat127.class);
                    startActivity(intent99);
                } else if (subcheck.equals("88")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat88.class);
                    startActivity(intent99);
                } else if (subcheck.equals("69")) {
                    Intent intent99 = new Intent(Subcat33Activity.this, SubSubCat69.class);
                    startActivity(intent99);

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
            List<Movies33> categories = QueryUtils33.fetchMovies33Data(mUrl);
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

        // Set empty state text to display "No serials found!"
        mEmptyStateTextView.setText(R.string.no_series);

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

