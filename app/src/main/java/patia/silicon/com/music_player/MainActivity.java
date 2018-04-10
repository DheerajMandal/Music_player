package patia.silicon.com.music_player;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    ImageButton play,forward,backward;
    SeekBar seekBar;
    //Runnable is used to perform a task one-time or repeated execution of time.
    Runnable runnable;
    Handler handler;
LinearLayout linearLayout;

    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        mediaPlayer.release();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout=(LinearLayout)findViewById(R.id.inflator_linear_layout);
        mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.music);
        seekBar=(SeekBar)findViewById(R.id.seekbar);
        play=(ImageButton)findViewById(R.id.play);
        backward=(ImageButton)findViewById(R.id.backward);
        forward=(ImageButton)findViewById(R.id.forward);
        handler=new Handler();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                //to set the seekbar to its max
                seekBar.setMax(mediaPlayer.getDuration());

                changeseekbar();

            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser)
                {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }

    private void changeseekbar()
    {

        seekBar.setProgress(mediaPlayer.getCurrentPosition());
        if (mediaPlayer.isPlaying())
        {
            runnable=new Runnable() {
                @Override
                public void run() {
                    changeseekbar();
                }
            };
            handler.postDelayed(runnable,1000);

        }
    }


    public void button(View view) {
        switch (view.getId())
        {
            case R.id.play:
                if (mediaPlayer.isPlaying())
                {
                    mediaPlayer.pause();
                    changeseekbar();
                }
                else {
                    mediaPlayer.start();
                    changeseekbar();

                }


                break;
            case R.id.forward:
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()+5000);
                break;
            case R.id.backward:
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()-5000);

        }

        Toast.makeText(this, "yes it works", Toast.LENGTH_SHORT).show();

    }

    public void arrow_button(View view) {
        LayoutInflater inflater=getLayoutInflater();
        View view1=View.inflate(MainActivity.this,R.layout.music_front_page,null);
        linearLayout.addView(view1);

    }
}
