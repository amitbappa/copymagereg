package creativemind.think.thinkcreativemind;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.io.IOException;
import java.io.InputStream;

import creativemind.think.thinkcreativemind.filebrowser.AndroidPermissionHelper;
import creativemind.think.thinkcreativemind.filebrowser.FileexplorerActivity;
import creativemind.think.thinkcreativemind.util.AppSettings;
import creativemind.think.thinkcreativemind.util.CreativeUtil;
import creativemind.think.thinkcreativemind.util.ImageRecogApp;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,View.OnClickListener{
    AndroidPermissionHelper mPermissionHelper;
    ImageView image_selected;
    TextView textView_imageScanText;
    Button start_Scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppSettings.setAppPathInPutOutput("");

        ImageRecogApp.getInstance().setFolderBrowse(false);
        mPermissionHelper = new AndroidPermissionHelper(this);
        mPermissionHelper.checkReadWriteExternalPermission();
        Toolbar toolbar =  findViewById(R.id.toolbar);
        image_selected= findViewById(R.id.imageView_select);
        start_Scan= findViewById(R.id.button_startSan);
        start_Scan.setOnClickListener((View.OnClickListener) this);
        textView_imageScanText=findViewById(R.id.textView_imageScanText);
        setImageFromSelectedPath();
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

            Intent intent1 = new Intent(this, FileexplorerActivity.class);
            startActivity(intent1);

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setImageFromSelectedPath()
    {
        try {

            if (AppSettings.getInputPath().trim().length() > 0) {
                image_selected.setImageBitmap(CreativeUtil.getBitMapFromFile(AppSettings.getInputPath()));
            }
            startScanImage();
        }
        catch (Exception e){

        }

    }

    public void startScanImage()
    {
        String outPut=CreativeUtil.startScanImageForExtractText(CreativeUtil.getBitMapFromFile(AppSettings.getInputPath()));

        textView_imageScanText.setText(outPut);
    }

    public Bitmap getBitmapFromAssets(String fileName) {
        AssetManager assetManager = getAssets();

        InputStream istr = null;
        try {
            istr = assetManager.open(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istr);

        return bitmap;
    }

    @Override
    protected void onResume() {
        super.onResume();
        setImageFromSelectedPath();
    }

    @Override
    protected void onPause() {
        super.onPause();
        setImageFromSelectedPath();
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.button_startSan:
                startScanImage();

                break;

        }

    }
}
