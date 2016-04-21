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


public class QuizActivity extends AppCompatActivity {
	List<Question> quesList;
	int score=0;
	int cantidad=0;
	Question currentQ;
	TextView txtQuestion, text;
	RadioButton rdPrimer, rdSegundo, rdTercero;
	Button butNext;
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
		text.setText(text.getText()+String.valueOf(starTime/1000));
		DbHelper db=new DbHelper(this);
		quesList=db.getAllQuestions();
		currentQ=quesList.get(cantidad);
		txtQuestion=(TextView)findViewById(R.id.txv_pregunta);
		rdPrimer=(RadioButton)findViewById(R.id.rd_primer);
		rdSegundo=(RadioButton)findViewById(R.id.rd_segundo);
		rdTercero=(RadioButton)findViewById(R.id.rd_tercero);
		butNext=(Button)findViewById(R.id.btn_siguiente);
		setQuestionView();
		butNext.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
				if(!timerHasStarted){
					countDownTimer.start();
					timerHasStarted=true;
					;
				}else {
					countDownTimer.cancel();
					timerHasStarted=false;

				}
				RadioGroup grp=(RadioGroup)findViewById(R.id.rdg_general);
				RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
				Log.d("yourans", currentQ.getRESPUESTA()+" "+answer.getText());
				if(currentQ.getRESPUESTA().equals(answer.getText()))
				{
					score++;
					Log.d("score", ""+score);
				}
				if(cantidad<5){
					currentQ=quesList.get(cantidad);
					setQuestionView();
				}else{
					Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
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

		@Override
		public void onFinish() {
text.setText("Times up");
			Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
			Bundle b = new Bundle();
			b.putInt("score", score); //Your score
			intent.putExtras(b); //Put your score to your next Intent
			startActivity(intent);
			finish();
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	private void setQuestionView()
	{
		//Cambie answer por question
		txtQuestion.setText(currentQ.getPREGUNTA());
		rdPrimer.setText(currentQ.getOPCIONA());
		rdSegundo.setText(currentQ.getOPCIONB());
		rdTercero.setText(currentQ.getOPCIONC());
		cantidad++;
	}
}
