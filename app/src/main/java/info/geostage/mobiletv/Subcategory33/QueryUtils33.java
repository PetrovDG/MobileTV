package info.geostage.mobiletv.Subcategory33;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Dimitar on 12.9.2017 г..
 */

public final class QueryUtils33 {
    private static final String KEY_CAT_ID = "category_id";
    private static final String KEY_ID = "subcategory_id";
    private static final String KEY_TITLE = "subcategory_name";
    private static final String KEY_COVER = "cover";

    private static final String KEY_COVER_LINK = "https://tvc.mobiletv.bg/sxm/images/subcategory/";


    /**
     * Tag for the log messages
     */
    private static final String LOG_TAG = QueryUtils33.class.getSimpleName();

    /**
     * Create a private constructor because no one should ever create a {@link QueryUtils33} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
     */
    private QueryUtils33() {
    }

    /**
     * Query the mobile-tv movies and return a list of {@link Movies33} objects.
     */
    public static List<Movies33> fetchMovies33Data(String requestUrl) {

        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        // Extract relevant fields from the JSON response and create a list of {@link Movies33}
        List<Movies33> movies = extractFeatureFromJson(jsonResponse);

        // Return the list of {@link Movies33}
        return movies;
    }

    /**
     * Returns new URL object from the given string URL.
     */
    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL ", e);
        }
        return url;
    }

    /**
     * Make an HTTP request to the given URL and return a String as the response.
     */
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the movies JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /**
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    /**
     * Return a list of {@link Movies33} objects that has been built up from
     * parsing the given JSON response.
     */
    private static List<Movies33> extractFeatureFromJson(String moviesJSON) {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(moviesJSON)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding movies to
        List<Movies33> movies = new ArrayList<>();

        // Try to parse the JSON response string. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            // Create a JSONObject from the JSON response string
            JSONObject baseJsonResponse = new JSONObject(moviesJSON);

            // Extract the JSONArray associated with the key called "subcategories",
            // which represents a list of movies).
            JSONArray subcategories = baseJsonResponse.getJSONArray("subcategories");

            // Variables for JSON parsing
            JSONObject currentMovies;
            String cat_id;
            String id;
            String title;
            String cover;
            String preview;
            String idcheck;
            // For each movie in the moviesArray, create an {@link Movies33} object
            for (int i = 0; i < subcategories.length(); i++) {

                // Get a single category at position i within the list of categories
                currentMovies = subcategories.getJSONObject(i);

                // Check if key "category_id" exists and if yes, return value
                if (currentMovies.has(KEY_CAT_ID)) {
                    cat_id = currentMovies.getString(KEY_CAT_ID);
                } else {
                    cat_id = null;
                }

                // Check if key "subcategory_id" exists and if yes, return value
                if (currentMovies.has(KEY_ID)) {
                    id = currentMovies.getString(KEY_ID);
                } else {
                    id = null;
                }

                // Check if key "subcategory_name" exists and if yes, return value
                if (currentMovies.has(KEY_TITLE)) {
                    title = currentMovies.getString(KEY_TITLE);
                } else {
                    title = null;
                }

                // Check if key "cover" exists and if yes, return value
                if (currentMovies.has(KEY_COVER)) {
                    cover = currentMovies.getString(KEY_COVER);
                } else {
                    cover = null;
                }


                preview = String.valueOf(KEY_COVER_LINK + cover);

                idcheck = String.valueOf(cat_id);
                if (idcheck.equals("33")) {
                    // Create the Movie object and add it to the ArrayList
                    Movies33 movie = new Movies33(title, id, preview);
                    movies.add(movie);
                }
            }

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e(LOG_TAG, "Problem parsing the Movies JSON results", e);

        }

        // Return the list of Movies
        return movies;
    }

}
