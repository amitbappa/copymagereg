package creativemind.think.util;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;


/**
 * Created by elena on 3/29/18.
 */

public class ImageRecogApp extends Application  {

    private static ImageRecogApp singleton;
    private static Context sContext;
    public static boolean isTab = false;

    @Override
    public void onCreate() {
        super.onCreate();

        singleton = this;
        sContext = this;
    }

    public static ImageRecogApp getInstance() {
        if (singleton == null) {
            singleton = new ImageRecogApp();
        }

        return singleton;
    }

    public static Context getContext() {
        return sContext;
    }

    /**
     * for checking device is table of not.
     *
     * @return boolean value true or false.
     */
    public boolean isTablet() {
        return (sContext.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }


}
