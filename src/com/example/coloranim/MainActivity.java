package com.example.coloranim;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private Anim anim;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	
	protected void onResume() {
		super.onResume();
		anim = new Anim((TextView) findViewById(R.id.text));
		anim.execute();
	}
	
	protected void onPause() {
		anim.cancel(true);
		anim = null;
		super.onPause();
	}
	
	public void onBackPressed() {
		anim.cancel(true);
		finish();
	}
}
