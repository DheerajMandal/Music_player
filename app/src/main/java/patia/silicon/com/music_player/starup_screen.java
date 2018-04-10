package patia.silicon.com.music_player;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class starup_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starup_screen);

    }

    public void check(View view) {
        Intent intent=new Intent(starup_screen.this,MainActivity.class);
        startActivity(intent);

    }
}
