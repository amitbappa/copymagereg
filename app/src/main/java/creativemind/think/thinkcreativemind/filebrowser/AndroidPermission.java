package creativemind.think.thinkcreativemind.filebrowser;

import android.app.Activity;

/**
 * Created by elena on 3/28/18.
 */

public class AndroidPermission {

    public static final int REQUEST_CAMERA_PERMISSION = 1;
    public static final int REQUEST_WRITE_EXTERNAL_STORAGE_PERMISSION = 2;
    public static final int REQUEST_READ_EXTERNAL_STORAGE_PERMISSION = 3;
    public static final int REQUEST_LOCATION_PERMISSION = 4;
    public static final int REQUEST_ALL_PERMISSION = 5;
    public static final int REQUEST_INTERNET_PERMISSION = 6;
    public static final int REQUEST_NETWORK_STATE_PERMISSION = 7;
    public static final int REQUEST_READ_WRITE_EXTERNAL_STORAGE_PERMISSION = 8;
    public static final int REQUEST_RECORD_AUDIO_PERMISSION = 9;
    private boolean cameraPermission;
    private boolean writeExternalStoragePermission;
    private boolean readExternalStoragePermission;
    private boolean locationPermission;
    private boolean internetPermission;
    private boolean networkStatePermission;
    private boolean audioRecordPermission;

    private Activity activity;

    public boolean hasAudioRecordPermission() {
        return audioRecordPermission;
    }

    public void setAudioRecordPermission(boolean audioRecordPermission) {
        this.audioRecordPermission = audioRecordPermission;
    }

    public boolean hasPermissionReadExternalStorage() {
        return readExternalStoragePermission;
    }

    public void setReadExternalStoragePermission(boolean readExternalStoragePermission) {
        this.readExternalStoragePermission = readExternalStoragePermission;
    }

    public boolean hasPermissionReadWriteExternalStorage() {
        return readExternalStoragePermission && writeExternalStoragePermission;
    }

    public void setReadWriteExternalStoragePermission(boolean readWrireExternalStoragePermission) {
        if(readWrireExternalStoragePermission){
            this.readExternalStoragePermission = true;
            this.writeExternalStoragePermission = true;
        } else {
            this.readExternalStoragePermission = false;
            this.writeExternalStoragePermission = false;
        }
    }

    public boolean hasPermissionCamera() {
        return cameraPermission;
    }

    public void setCameraPermission(boolean cameraPermission) {
        this.cameraPermission = cameraPermission;
    }

    public boolean hasPermissionWriteExternalStorage() {
        return writeExternalStoragePermission;
    }

    public void setWriteExternalStoragePermission(boolean writeExternalStoragePermission) {
        this.writeExternalStoragePermission = writeExternalStoragePermission;
    }

    public boolean hasPermissionInternet() {
        return internetPermission;
    }

    public boolean hasPermissionNetworkState() {
        return networkStatePermission;
    }

    public void setInternetPermission(boolean internetPermission) {
        this.internetPermission = internetPermission;
    }

    public void setNetworkStatePermission(boolean networkStatePermission) {
        this.networkStatePermission = networkStatePermission;
    }

    public boolean hasPermissionLocation() {
        return locationPermission;
    }

    public void setLocationPermission(boolean locationPermission) {
        this.locationPermission = locationPermission;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
