package creativemind.think.thinkcreativemind.filebrowser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import creativemind.think.thinkcreativemind.R;
import creativemind.think.thinkcreativemind.util.AppConstant;
import creativemind.think.thinkcreativemind.util.AppSettings;
import creativemind.think.thinkcreativemind.util.ImageRecogApp;

public class FileexplorerActivity extends Activity implements OnClickListener {

    private static final int REQUEST_PATH = 1;

    String curFileName;

    TextView editTextImagPath;
    TextView outPutLocation;

    Button btnSave;
    Button btnCancel;
    Button button_browse;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_dd);
        editTextImagPath = findViewById(R.id.editText_ImagPath);
        editTextImagPath.setText(AppSettings.getInputPath());

        button_browse=findViewById(R.id.button_browse);

        outPutLocation = findViewById(R.id.textView_outputLocation);
        btnSave = findViewById(R.id.btn_save);
        btnCancel = findViewById(R.id.btn_cancel);
        try {
            outPutLocation.setText(AppSettings.outPutPath());
            btnSave.setOnClickListener(this);
            btnCancel.setOnClickListener(this);
            button_browse.setOnClickListener(this);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public void getfile(View view) {
        Intent intent1 = new Intent(this, FileChooser.class);
        startActivityForResult(intent1, REQUEST_PATH);
    }

    // Listen for results.
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // See which child activity is calling us back.
        if (requestCode == REQUEST_PATH) {
            if (resultCode == RESULT_OK) {
                curFileName = ImageRecogApp.getInstance().isFolderBrowse() ? data.getStringExtra(AppConstant.GET_FILE_PATH) :
                        data.getStringExtra(AppConstant.GET_FILE_PATH);// + data.getStringExtra(AppConstant.GET_FILE_NAME);
                editTextImagPath.setText(curFileName);
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel:
                finish();
                break;
            case R.id.btn_save:

                AppSettings.setAppPathInPutOutput(curFileName);
                finish();
                break;
            case R.id.button_browse:
                getfile(v);
                break;
        }
    }
}
