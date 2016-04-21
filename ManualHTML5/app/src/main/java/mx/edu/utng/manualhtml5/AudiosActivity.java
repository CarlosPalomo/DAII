package mx.edu.utng.manualhtml5;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by Carlos on 15/02/2016.
 */
public class AudiosActivity extends ActionBarActivity {
    /*
    se declara la variable para playing para los audios
     */
    boolean playing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audios);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /**
         * se declaran los botones para iniciar y detener el audio
         */
        Button btnPlay = (Button) findViewById(R.id.btn_start);
        Button btnPause = (Button) findViewById(R.id.btn_pause);
        Button btnStop = (Button) findViewById(R.id.btn_stop);
/**
 * se declaran los botones para iniciar y detener el audio enseguida de los anteriores
 */
        Button btnPlayy = (Button) findViewById(R.id.btn_startt);
        Button btnPausee = (Button) findViewById(R.id.btn_pausee);
        Button btnTopp = (Button) findViewById(R.id.btn_topp);

//se manda llamar el audio
        final MediaPlayer mp = MediaPlayer.create(AudiosActivity.this, R.raw.introdu);
        final MediaPlayer mpp = MediaPlayer.create(AudiosActivity.this, R.raw.porque);

//el boton play se le asiga que tarea es del primer audio
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!playing) {
                    mp.start();
                    playing = true;
                }
            }
        });
//el boton play se le asiga que tarea es del segundo audio
        btnPlayy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!playing) {
                    mpp.start();
                    playing = true;
                }
            }
        });
// a los bones de pause se tienen que detener cuando el audio se este escuchando
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playing) {
                    mp.pause();
                    playing = false;
                }
            }
        });

        btnPausee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playing) {
                    mpp.pause();
                    playing = false;
                }
            }
        });
//este boton los saca de la actividad
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playing) {
                    mp.stop();
                    playing = false;
                }
                AudiosActivity.this.finish();
            }
        });

        btnTopp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playing) {
                    mpp.stop();
                    playing = false;
                }
                AudiosActivity.this.finish();
            }
        });

    }


}
