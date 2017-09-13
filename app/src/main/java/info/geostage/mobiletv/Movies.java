package info.geostage.mobiletv;

/**
 * Created by Dimitar on 12.9.2017 г..
 */

/**
 * An {@link Movies} object contains information related to a single movie.
 */
public class Movies {

    /** Movie/Category Title */
    private String mTitle;

    /** Movie/Category ID */
    private String mId;

    /**
     * Constructs a new {@link Movies} object.
     * @param title is the category's title
     * @param id is the category's id
     */

    public Movies(String title, String id) {
        mTitle = title;
        mId = id;

    }

    public String getTitle() {
        return mTitle;
    }

    public String getId() {
        return mId;
    }

}
