package mx.edu.utng.manualhtml5;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;
import android.view.View.OnClickListener;

/**
 * Created by Carlos on 29/02/2016.
 */
public class CalificaActivity extends Activity {
    RatingBar rtbCalificanos;
    Button btnCalificanos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificanos);
        addListenerButtonClick();
    }
    //Para dar la calificaciones con estrellas
    public void addListenerButtonClick(){
        rtbCalificanos=(RatingBar)findViewById(R.id.rtb_calificanos);
        btnCalificanos=(Button)findViewById(R.id.btn_Calificanos);

        //Muestra las estrellas
        btnCalificanos.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating =String.valueOf(rtbCalificanos.getRating());
                Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();

            }
        });

    }
}
