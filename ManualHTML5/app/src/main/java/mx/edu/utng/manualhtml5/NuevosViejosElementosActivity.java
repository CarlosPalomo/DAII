package mx.edu.utng.manualhtml5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Carlos on 02/02/2016.
 */
public class NuevosViejosElementosActivity extends Activity {
    BloqueCuatro session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuev_viej_layout);
        /**
         * Bloqueo de temario
         */
        session= new BloqueCuatro(getApplicationContext());
        if(session.checkQuiz())
            finish();


    }
}
