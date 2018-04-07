package creativemind.think.thinkcreativemind.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;

import java.io.File;

import static creativemind.think.thinkcreativemind.util.AppConstant.MyPREFERENCES;

/**
 * Created by elena on 3/29/18.
 */

public class AppSettings {

    static SharedPreferences sharedpreferences;


    public static void setAppPathInPutOutput(String inPutPath)
    {
        sharedpreferences = ImageRecogApp.getContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        String outPutPath= Environment.getExternalStorageDirectory().getPath();
        File file = new File(outPutPath+"/creative");
        file.mkdirs();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(AppConstant.INPUT_FILE_PATH, inPutPath);
        editor.putString(AppConstant.OUTPUT_FOLDER_PATH, file.getAbsolutePath());
        editor.commit();
    }

    public static String getInputPath()
    {
        sharedpreferences = ImageRecogApp.getContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        return sharedpreferences.getString(AppConstant.INPUT_FILE_PATH,"");
    }


    public static String outPutPath()
    {
        sharedpreferences = ImageRecogApp.getContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        return sharedpreferences.getString(AppConstant.OUTPUT_FOLDER_PATH,"");

    }
    public static void setInputPath(String inPutPath){
        sharedpreferences = ImageRecogApp.getContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(AppConstant.INPUT_FILE_PATH, inPutPath);
        editor.commit();

    }

}
