package creativemind.think.thinkcreativemind.filebrowser;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import creativemind.think.thinkcreativemind.R;
import creativemind.think.thinkcreativemind.util.ImageRecogApp;


public class FileChooser extends ListActivity implements AdapterView.OnItemLongClickListener {

    private File currentDir;
    private FileArrayAdapter adapter;

    File file = Environment.getExternalStorageDirectory();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentDir = file;
        fill(file,ImageRecogApp.getInstance().isFolderBrowse());
    }

    private void fill(File f , boolean isFolderBrowse) {
        File[] dirs = f.listFiles();
        this.setTitle("Current Dir: " + f.getName());
        List<Item> dir = new ArrayList<Item>();
        List<Item> fls = new ArrayList<Item>();
        try {
            for (File ff : dirs) {
                if (ff.getName().startsWith(".")) continue;

                Date lastModDate = new Date(ff.lastModified());
                DateFormat formater = DateFormat.getDateTimeInstance();
                String date_modify = formater.format(lastModDate);
                if (ff.isDirectory()) {

                    File[] fbuf = ff.listFiles();
                    int buf = 0;
                    if (fbuf != null) {
                        buf = fbuf.length;
                    } else buf = 0;
                    String num_item = String.valueOf(buf);
                    if (buf == 0) num_item = num_item + " item";
                    else num_item = num_item + " items";

                    //String formated = lastModDate.toString();
                    dir.add(new Item(ff.getName(), num_item, date_modify, ff.getAbsolutePath(), "directory_icon"));
                } else {

                    if (isFolderBrowse) continue;

                    fls.add(new Item(ff.getName(), ff.length() + " Byte", date_modify, ff.getAbsolutePath(), "file_icon"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(dir);
        if (!isFolderBrowse) { // If user try to browse folder and file then isFolderBrowse flag should be false
            Collections.sort(fls);
            dir.addAll(fls);
        }

        if (!f.getName().equalsIgnoreCase("sdcard"))
            dir.add(0, new Item("..", "Parent Directory", "", f.getParent(), "directory_up"));
        adapter = new FileArrayAdapter(FileChooser.this, R.layout.file_view, dir);
        this.setListAdapter(adapter);
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);
        Item o = adapter.getItem(position);
        l.setOnItemLongClickListener((AdapterView.OnItemLongClickListener) this);
        currentDir = new File(o.getPath());
        if (o.getImage().equalsIgnoreCase("directory_icon") || o.getImage().equalsIgnoreCase("directory_up")) {
            fill(currentDir,ImageRecogApp.getInstance().isFolderBrowse());

        } /*else {
            onFileClick(o);
        }*/
    }



    private void onFileClick(Item o) {
        //Toast.makeText(this, "Folder Clicked: "+ currentDir, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.putExtra("GetPath", currentDir.toString());
        intent.putExtra("GetFileName", o.getName());
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        Item o = adapter.getItem(position);
        currentDir = new File(o.getPath());
        onFileClick(o);
        /*if (o.getImage().equalsIgnoreCase("directory_icon") || o.getImage().equalsIgnoreCase("directory_up")) {

        }*/
        return true;
    }
}
