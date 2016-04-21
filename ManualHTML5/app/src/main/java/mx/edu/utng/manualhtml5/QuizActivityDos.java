package mx.edu.utng.manualhtml5;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;



public class QuizActivityDos extends AppCompatActivity {

	List<Question> quesList;
	int score=0;
	int qid=0;
	Question currentQ;
	TextView txtQuestion, text;
	RadioButton rdPrimer, rdSegundo, rdTercero;
	Button butNext;
	//llamar a la clase para el bloqueo
	BloqueQuizDos session;
	CountDownTimer countDownTimer;
	boolean timerHasStarted=false;
	final long starTime=30*1000;
	final long interval=1*1000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		text=(TextView)findViewById(R.id.timers);
		countDownTimer=new MyCountDownTimer(starTime, interval);
		text.setText(text.getText() + String.valueOf(starTime / 1000));
		//bloqueo
		session= new BloqueQuizDos(getApplicationContext());
		if(session.checkQuiz())
			finish();
		//base de datos
		DbHelper db=new DbHelper(this);
		quesList=db.getAllQuestionsdos();
		currentQ=quesList.get(qid);
		txtQuestion=(TextView)findViewById(R.id.txv_pregunta);
		rdPrimer=(RadioButton)findViewById(R.id.rd_primer);
		rdSegundo=(RadioButton)findViewById(R.id.rd_segundo);
		rdTercero=(RadioButton)findViewById(R.id.rd_tercero);
		butNext=(Button)findViewById(R.id.btn_siguiente);
		setQuestionView();
		//control de cuestionario
		butNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!timerHasStarted){
					countDownTimer.start();
					timerHasStarted=true;
					butNext.setText("Siguiente");
				}else {
					countDownTimer.cancel();
					timerHasStarted=false;
					butNext.setText("Empezar");
				}
				RadioGroup grp=(RadioGroup)findViewById(R.id.rdg_general);
				RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
				Log.d("yourans", currentQ.getRESPUESTA()+" "+answer.getText());
				if(currentQ.getRESPUESTA().equals(answer.getText()))
				{
					score++;
					Log.d("score", "Your score"+score);
				}
				if(qid<5){					
					currentQ=quesList.get(qid);
					setQuestionView();
				}else{
					Intent intent = new Intent(QuizActivityDos.this, ResultActivityDos.class);
					Bundle b = new Bundle();
					b.putInt("score", score); //Your score
					intent.putExtras(b); //Put your score to your next Intent
					startActivity(intent);
					finish();
				}
			}
		}

		);

	}
	public class MyCountDownTimer extends CountDownTimer{
		public MyCountDownTimer(long starTime , long interval){
			super(starTime, interval);
		}

		@Override
		public void onTick(long millisUntilFinished) {
			text.setText(""+millisUntilFinished/1000);
		}
//fin del tiempo
		@Override
		public void onFinish() {
			text.setText("Times up");
			Intent a = new Intent(getApplicationContext(), ResultActivity.class);
			startActivity(a);
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
		return true;
	}
	//obtener la pregunta
	private void setQuestionView()
	{
		txtQuestion.setText(currentQ.getPREGUNTA());
		rdPrimer.setText(currentQ.getOPCIONA());
		rdSegundo.setText(currentQ.getOPCIONB());
		rdTercero.setText(currentQ.getOPCIONC());
		qid++;
	}
}
