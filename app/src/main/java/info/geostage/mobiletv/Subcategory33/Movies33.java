package info.geostage.mobiletv.Subcategory33;

/**
 * Created by Dimitar on 12.9.2017 г..
 */

/**
 * An {@link Movies33} object contains information related to a single movie.
 */
public class Movies33 {

    /** Movie/Category Title */
    private String mTitle;

    /** Movie/Category ID */
    private String mId;

    /** Url for the cover's preview */
    private String mPreviewURL;

    /**
     * Constructs a new {@link Movies33} object.
     * @param title is the category's title
     * @param id is the category's id
     * @param preview is the category's id
     */

    public Movies33(String title, String id, String preview) {
        mTitle = title;
        mId = id;
        mPreviewURL = preview;

    }

    public String getTitle() {
        return mTitle;
    }

    public String getId() {
        return mId;
    }
    public String getPreview() {
        return mPreviewURL;
    }

}
