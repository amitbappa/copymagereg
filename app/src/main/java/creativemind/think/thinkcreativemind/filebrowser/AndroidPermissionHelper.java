package creativemind.think.thinkcreativemind.filebrowser;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by elena on 3/28/18.
 */

public class AndroidPermissionHelper {
    private AndroidPermission androidPermission;

    public void setAndroidPermission(AndroidPermission androidPermission) {
        this.androidPermission = androidPermission;
    }

    public AndroidPermission getAndroidPermission() {
        return androidPermission;
    }

    public AndroidPermissionHelper(Activity activity) {
        this.androidPermission = new AndroidPermission();
        this.androidPermission.setCameraPermission(false);
        this.androidPermission.setAudioRecordPermission(false);
        this.androidPermission.setReadExternalStoragePermission(false);
        this.androidPermission.setWriteExternalStoragePermission(false);
        this.androidPermission.setActivity(activity);
    }

    public void checkAllPermissions() {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(this.androidPermission.getActivity(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this.androidPermission.getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this.androidPermission.getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this.androidPermission.getActivity(), Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this.androidPermission.getActivity(), Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_GRANTED) {

                this.androidPermission.setCameraPermission(true);
                this.androidPermission.setReadExternalStoragePermission(true);
                this.androidPermission.setWriteExternalStoragePermission(true);
                this.androidPermission.setInternetPermission(true);
                this.androidPermission.setNetworkStatePermission(true);
            } else {
                ActivityCompat.requestPermissions(this.androidPermission.getActivity(),
                        new String[]{
                                Manifest.permission.CAMERA,
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.INTERNET,
                                Manifest.permission.ACCESS_NETWORK_STATE
                        },
                        AndroidPermission.REQUEST_ALL_PERMISSION);
            }
        } else {
            this.androidPermission.setCameraPermission(true);
            this.androidPermission.setReadExternalStoragePermission(true);
            this.androidPermission.setWriteExternalStoragePermission(true);
            this.androidPermission.setInternetPermission(true);
            this.androidPermission.setNetworkStatePermission(true);
        }
    }

    public void checkInternetPermission() {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(this.androidPermission.getActivity(), Manifest.permission.INTERNET)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this.androidPermission.getActivity(),
                        new String[]{
                                Manifest.permission.INTERNET
                        },
                        AndroidPermission.REQUEST_INTERNET_PERMISSION);
            } else {
                this.androidPermission.setInternetPermission(true);
            }
        }
    }

    public void checkNetworkStatePermission() {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(this.androidPermission.getActivity(), Manifest.permission.ACCESS_NETWORK_STATE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this.androidPermission.getActivity(),
                        new String[]{
                                Manifest.permission.ACCESS_NETWORK_STATE
                        },
                        AndroidPermission.REQUEST_NETWORK_STATE_PERMISSION);
            } else {
                this.androidPermission.setNetworkStatePermission(true);
            }
        }
    }

    public void checkCameraPermission() {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(this.androidPermission.getActivity(), Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this.androidPermission.getActivity(),
                        new String[]{
                                Manifest.permission.CAMERA
                        },
                        AndroidPermission.REQUEST_CAMERA_PERMISSION);
            } else {
                this.androidPermission.setCameraPermission(true);
            }
        }
    }

    public void checkRecordAudioPermission(Activity mActivity) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            if (mActivity.checkSelfPermission(Manifest.permission.RECORD_AUDIO)
                    != PackageManager.PERMISSION_GRANTED) {
                mActivity.requestPermissions(
                        new String[]{
                                Manifest.permission.RECORD_AUDIO
                        },
                        AndroidPermission.REQUEST_RECORD_AUDIO_PERMISSION);
            } else {
                this.androidPermission.setAudioRecordPermission(true);
            }
        }
    }


    public void checkReadExternalPermission() {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(this.androidPermission.getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this.androidPermission.getActivity(),
                        new String[]{
                                Manifest.permission.READ_EXTERNAL_STORAGE
                        },
                        AndroidPermission.REQUEST_READ_EXTERNAL_STORAGE_PERMISSION);
            } else {
                this.androidPermission.setReadExternalStoragePermission(true);
            }
        }
    }

    public void checkWriteExternalPermission() {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(this.androidPermission.getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this.androidPermission
                                .getActivity(),
                        new String[]{
                                Manifest.permission.WRITE_EXTERNAL_STORAGE
                        },
                        AndroidPermission.REQUEST_WRITE_EXTERNAL_STORAGE_PERMISSION);
            } else {
                this.androidPermission.setWriteExternalStoragePermission(true);
            }
        }
    }

    public void checkReadWriteExternalPermission() {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(this.androidPermission.getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this.androidPermission
                                .getActivity(),
                        new String[]{
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.CAMERA,
                                Manifest.permission.RECORD_AUDIO
                        },
                        AndroidPermission.REQUEST_READ_WRITE_EXTERNAL_STORAGE_PERMISSION);
            } else {
                this.androidPermission.setReadWriteExternalStoragePermission(true);
            }
        }
    }

    public void checkLocationPermission() {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(this.androidPermission.getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this.androidPermission.getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this.androidPermission
                                .getActivity(),
                        new String[]{
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION
                        },
                        AndroidPermission.REQUEST_LOCATION_PERMISSION);
            } else {
                this.androidPermission.setLocationPermission(true);
            }
        }
    }

    public void obtainGrantedPermissions(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case AndroidPermission.REQUEST_CAMERA_PERMISSION:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    this.androidPermission.setCameraPermission(true);
                } else {
                    this.androidPermission.setCameraPermission(false);
                }
                break;
            case AndroidPermission.REQUEST_READ_EXTERNAL_STORAGE_PERMISSION:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    this.androidPermission.setReadExternalStoragePermission(true);
                } else {
                    this.androidPermission.setReadExternalStoragePermission(false);
                }
                break;
            case AndroidPermission.REQUEST_WRITE_EXTERNAL_STORAGE_PERMISSION:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    this.androidPermission.setWriteExternalStoragePermission(true);
                } else {
                    this.androidPermission.setWriteExternalStoragePermission(false);
                }
                break;
            case AndroidPermission.REQUEST_INTERNET_PERMISSION:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    this.androidPermission.setInternetPermission(true);
                } else {
                    this.androidPermission.setInternetPermission(false);
                }
                break;
            case AndroidPermission.REQUEST_NETWORK_STATE_PERMISSION:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    this.androidPermission.setNetworkStatePermission(true);
                } else {
                    this.androidPermission.setNetworkStatePermission(false);
                }
                break;
            case AndroidPermission.REQUEST_READ_WRITE_EXTERNAL_STORAGE_PERMISSION:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    this.androidPermission.setReadWriteExternalStoragePermission(true);
                } else {
                    this.androidPermission.setReadWriteExternalStoragePermission(false);
                }
                break;
            case AndroidPermission.REQUEST_ALL_PERMISSION:
                if (grantResults.length > 0) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        this.androidPermission.setCameraPermission(true);
                    } else {
                        this.androidPermission.setCameraPermission(false);
                    }
                    if (grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                        this.androidPermission.setReadExternalStoragePermission(true);
                    } else {
                        this.androidPermission.setReadExternalStoragePermission(false);
                    }
                    if (grantResults[2] == PackageManager.PERMISSION_GRANTED) {
                        this.androidPermission.setWriteExternalStoragePermission(true);
                    } else {
                        this.androidPermission.setWriteExternalStoragePermission(false);
                    }
                    if (grantResults[3] == PackageManager.PERMISSION_GRANTED) {
                        this.androidPermission.setInternetPermission(true);
                    } else {
                        this.androidPermission.setInternetPermission(false);
                    }
                    if (grantResults[4] == PackageManager.PERMISSION_GRANTED) {
                        this.androidPermission.setNetworkStatePermission(true);
                    } else {
                        this.androidPermission.setNetworkStatePermission(false);
                    }
                } else {
                    this.androidPermission.setWriteExternalStoragePermission(true);
                    this.androidPermission.setCameraPermission(true);
                    this.androidPermission.setReadExternalStoragePermission(true);
                    this.androidPermission.setInternetPermission(true);
                    this.androidPermission.setNetworkStatePermission(true);
                }
                break;
            default:

                break;
        }
    }

    public interface PermissionCallback {
        void onReceivePermissionResult(int requestCode, boolean permissionGranted);
    }

}