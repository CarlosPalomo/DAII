package mx.edu.utng.manualhtml5;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
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

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    /**
     * reproducir la cancion de fondo
     */
    private MediaPlayer reproductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /**
         * mandar llamar la cancion
         */
        reproductor=MediaPlayer.create(this, R.raw.musi);
        reproductor.setLooping(true);
        reproductor.start();

        Button btnAlert=(Button)findViewById(R.id.btn_Alert);

        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Estas seguro de salir de la aplicacion?");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert=builder.create();
                alert.show();

            }
        });

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
        drawer.setDrawerListener(toggle);
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


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.temas) {
            startActivity(new Intent(MainActivity.this,ContenidoActivity.class));
        }
    else if (id == R.id.videos) {
            startActivity(new Intent(MainActivity.this, VideoActivity.class));
        } else if (id == R.id.audio) {
            startActivity(new Intent(MainActivity.this, AudiosActivity.class));
        } else if (id == R.id.graf) {
            startActivity(new Intent(MainActivity.this, GraficoActivityDos.class));
        } else if (id == R.id.login) {
            startActivity(new Intent(MainActivity.this, RegistrateActivity.class));
        }
        else if (id == R.id.cuestionario) {
         startActivity(new Intent(MainActivity.this, CuestionarioActivity.class));
        }
        else if (id == R.id.correo) {
            startActivity(new Intent(MainActivity.this, CorreoActivity.class));
        }
        else if (id == R.id.registrar) {
            startActivity(new Intent(MainActivity.this, RegistrateActivity.class));
        } else if (id == R.id.calificanos) {
            startActivity(new Intent(MainActivity.this, CalificaActivity.class));
        } else if (id == R.id.acerca) {
            startActivity(new Intent(MainActivity.this, AcercaActivity.class));
        } else if (id == R.id.practicas) {
            startActivity(new Intent(MainActivity.this, PracticasActivity.class));
        }
        else if (id == R.id.config) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * para que la musica de fondo se detenga cuando se cierra la app
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(reproductor.isPlaying()){
            reproductor.stop();
            reproductor.release();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        reproductor.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        reproductor.pause();
    }
}