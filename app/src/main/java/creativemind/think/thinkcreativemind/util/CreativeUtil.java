package creativemind.think.thinkcreativemind.util;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.SparseArray;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by elena on 4/1/18.
 */

public class CreativeUtil {

    public static  Bitmap getBitmapFromAssets(String fileName) {
        AssetManager assetManager = ImageRecogApp.getContext().getAssets();

        InputStream istr = null;
        try {
            istr = assetManager.open(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istr);

        return bitmap;
    }

    public static Bitmap getBitMapFromFile(String fileName) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmap = BitmapFactory.decodeFile(fileName, options);

        return bitmap;


    }

    public static String startScanImageForExtractText(final Bitmap bitmap) {
        TextRecognizer textRecognizer = new TextRecognizer.Builder(ImageRecogApp.getContext()).build();
        Bitmap bitMap =bitmap;

        Frame imageFrame = new Frame.Builder()

                .setBitmap(bitMap)                 // your image bitmap
                .build();

        String imageText = "";
        StringBuilder resultentText = new StringBuilder();


        SparseArray<TextBlock> textBlocks = textRecognizer.detect(imageFrame);

        for (int i = 0; i < textBlocks.size(); i++) {
            TextBlock textBlock = textBlocks.get(textBlocks.keyAt(i));
            imageText = textBlock.getValue();                   // return string
            resultentText.append(imageText);

            Log.d("TEST", imageText);
        }

        return resultentText.toString();
    }
}
