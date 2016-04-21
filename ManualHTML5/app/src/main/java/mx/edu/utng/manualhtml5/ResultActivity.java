package mx.edu.utng.manualhtml5;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;
public class ResultActivity extends Activity {
//se manda llamar para poder graficar
	GraficaHelperDos db= new GraficaHelperDos(this);
	Grafica g= new Grafica();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		sesion=new BloqueQuizDos(getApplicationContext());
//get rating bar object
		RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
//get text view
		TextView t=(TextView)findViewById(R.id.textResult);
//get score
		Bundle b = getIntent().getExtras();
		int score= b.getInt("score");
//display score
		bar.setRating(score);
		switch (score)
		{
			case 0: t.setText("PERDEDOR ERES MALISIMO NO HAS TENIDO NINGUN ACIERTO");
				break;
			case 1: t.setText("Tienes una respuesta correcta y tienes que volver a intentar el quiz");

				break;
			case 2: t.setText("Tienes dos Respuestas correctas.... Tienes que volver a intentar el quiz");

				break;
			/**
			 * Hacer el bloqueo y graficar
			 */
			case 3: t.setText("Tienes 3 Respuestas correctas");
				sesion.createUserQuiz("Pass1","Usuario1");
				Intent i= new Intent(getApplicationContext(), MainActivity.class);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);
				finish();
				g.setNombre("Estructura Global");
				g.setSigla("Q1");
				g.setVotos(8);
				db.insertResult(g);

				break;
			case 4:
				/**
				 * Hacer el bloqueo y graficar
				 */
				t.setText("Tienes 4 Respuestas correctas");
				sesion.createUserQuiz("Pass1","Usuario1");
				Intent ii= new Intent(getApplicationContext(), MainActivity.class);
				ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(ii);
				finish();
				g.setNombre("Estructura Global");
				g.setSigla("Q1");
				g.setVotos(9);
				db.insertResult(g);
				break;
			case 5:t.setText("Tienes 5 Respuestas correctas");
				/**
				 * Hacer el bloqueo y graficar
				 */
				sesion.createUserQuiz("Pass1","Usuario1");
				Intent iii= new Intent(getApplicationContext(), MainActivity.class);
				iii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				iii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(iii);
				finish();
				g.setNombre("Estructura Global");
				g.setSigla("Q1");
				g.setVotos(10);
				db.insertResult(g);

				break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}
	BloqueQuizDos sesion;

}
