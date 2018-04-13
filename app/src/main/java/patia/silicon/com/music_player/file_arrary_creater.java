package patia.silicon.com.music_player;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class starup_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.MainActivity);

    }
    public void listFilesForFolder(final File folder) {
        File folder = new File("Environment.getExternalStorageState()");
        File[] listOfFiles = folder.listFiles();
        starup_screen ob  = new starup_screen();
        String mp3[] = new String[];
        int temp,c=0;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                {
                   temp=  ob.mp3(file.getName());
                   if(temp==1)
                       mp3[c++]=file.getName();
                }
            }
        }
    }
    public int mp3(String n)
    {
        if(n.charAt(n.length()-1)=='3'&&n.charAt(n.length()-2)=='p'&&n.charAt(n.length()-3)=='m')
            return(1);
        else
            return(0);
    }
}
