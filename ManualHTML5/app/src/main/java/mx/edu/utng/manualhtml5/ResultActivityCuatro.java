package mx.edu.utng.manualhtml5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;



public class ResultActivityCuatro extends Activity {


	GraficaHelperDos db= new GraficaHelperDos(this);
	Grafica g= new Grafica();

	BloqueCuatro session;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		session= new BloqueCuatro(getApplicationContext());
		//get rating bar object
		RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
		bar.setNumStars(5);
		bar.setStepSize(0.5f);
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
		case 1:

			t.setText("Tienes una Respuesta correcta.... Tienes que volver a intentar el quiz");
break;
		case 2:
			t.setText("Tienes dos Respuestas correctas.... Tienes que volver a intentar el quiz");
		break;
		case 3:
			/**
			 * Hacer el bloqueo y graficar
			 */
			g.setNombre("Nuevos y Viejos elementos");
			g.setSigla("Q4");
			g.setVotos(8);
			db.insertResult(g);

			session.createUserQuiz("pass", "pass");
			Intent i=new Intent(getApplicationContext(), GraficoActivityDos.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);
			finish();
			break;

		case 4:
			/**
			 * Hacer el bloqueo y graficar
			 */
			g.setNombre("Nuevos y Viejos elementos");
			g.setSigla("Q4");
			g.setVotos(9);
			db.insertResult(g);

			session.createUserQuiz("pass", "pass");
			Intent ii=new Intent(getApplicationContext(), GraficoActivityDos.class);
			ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(ii);
			finish();
			break;
			case 5:
				/**
				 * Hacer el bloqueo y graficar
				 */
				g.setNombre("Nuevos y Viejos elementos");
				g.setSigla("Q4");
				g.setVotos(10);
				db.insertResult(g);

				session.createUserQuiz("pass", "pass");
				Intent iii=new Intent(getApplicationContext(), GraficoActivityDos.class);
				iii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				iii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(iii);
				finish();
		break;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
		return true;
	}
}
