package patia.silicon.com.music_player;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.io.*;

import java.io.File;
import java.util.ArrayList;
class startup_screen extends AppCompatActivity {
    ArrayList<File> files;
    ArrayList<String>   mp3files;
    ArrayList<String>   files2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public ArrayList<String> Process_starter()
    {
        listf(Environment.getExternalStorageState());
        return(mp3files);
    }
    public void listf(String directoryName) {
        File directory = new File(directoryName);

        // get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                listf(file.getAbsolutePath());
            }
        }
        for(File temp:files)
            files2.add(temp.getName());
        music_list_creater();

    }
    public void music_list_creater()
    {
        for(String t:files2)
        {
            if((t.substring(t.length()-3,t.length()-1)).equals("mp3"))
                mp3files.add(t);
        }
    }
}
