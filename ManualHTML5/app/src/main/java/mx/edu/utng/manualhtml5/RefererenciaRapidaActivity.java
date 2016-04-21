package mx.edu.utng.manualhtml5;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Carlos on 02/02/2016.
 */
public class RefererenciaRapidaActivity extends Activity {
    BloqueQuizCinco sessioncinco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.referen_rapid_layout);
        //bloqueo de contenido
        sessioncinco= new BloqueQuizCinco(getApplicationContext());
        if(sessioncinco.checkQuiz())
            finish();

    }
}
