package pl.froger.helloactivities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button btnOpenNewActivity;
	private TextView tvLifetime;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		tvLifetime = (TextView) findViewById(R.id.tvLifetime);
		btnOpenNewActivity = (Button) findViewById(R.id.btnOpenNewActivity);
		btnOpenNewActivity.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent startAnotherActivity = new Intent(getApplicationContext(), AnotherActivity.class);
				startActivity(startAnotherActivity);
			}
		});
		setCurrentStateInTextView("onCreate");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		setCurrentStateInTextView("onRestart");
	}
	@Override
	protected void onStart() {
		super.onStart();
		setCurrentStateInTextView("onStart");
	}
	@Override
	protected void onResume() {
		super.onResume();
		setCurrentStateInTextView("onResume");
	}
	@Override
	protected void onPause() {
		setCurrentStateInTextView("onPause");
		super.onPause();
	}
	@Override
	protected void onStop() {
		setCurrentStateInTextView("onStop");
		super.onStop();
	}
	@Override
	protected void onDestroy() {
		setCurrentStateInTextView("onDestroy");
		super.onDestroy();
	}
	
	private void setCurrentStateInTextView(String state) {
		String text = tvLifetime.getText().toString() + state + " "
				+ getNowTime() + "\n";
		tvLifetime.setText(text);
	}
	private String getNowTime() {
		DateFormat df = new SimpleDateFormat("H:m:s:S");
		Date now = Calendar.getInstance().getTime();
		return df.format(now);
	}
}