package mx.edu.utng.manualhtml5;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class PracticasActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practicas);
/**
 * botones para usar el toast como respuesta correcta
 */
		Button body =  (Button)findViewById(R.id.btn_body);
		Button head =  (Button)findViewById(R.id.btn_head);
		/**
		 * toast al darle click al boton
		 */
		body.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(PracticasActivity.this, "Tu respuesta es correcta", Toast.LENGTH_SHORT).show();

			}
		});

		head.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(PracticasActivity.this, "Tu respuesta es correcta", Toast.LENGTH_SHORT).show();

			}
		});


	}

    
}