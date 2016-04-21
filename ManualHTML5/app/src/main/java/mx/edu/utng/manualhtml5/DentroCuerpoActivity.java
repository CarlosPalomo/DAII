package mx.edu.utng.manualhtml5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Carlos on 02/02/2016.
 */
public class DentroCuerpoActivity extends Activity {
// se manda llamar
    BloqueQuizTres session;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dentro_cuerp_layout);
       //bloqueo tematico
        session= new BloqueQuizTres(getApplicationContext());
        if(session.checkQuiz())
            finish();


    }
}
