package creativemind.think.util;

import android.content.SharedPreferences;

/**
 * Created by elena on 3/29/18.
 */

public class AppSettings {

    static SharedPreferences sharedpreferences;


    public static void setAppPathInPutOutput(String inPutOutput)
    {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(AppConstant.INPUT_FILE_PATH, inPutOutput);


        editor.commit();
    }
}
