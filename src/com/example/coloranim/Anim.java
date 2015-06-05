package com.example.coloranim;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.TextView;

public class Anim extends AsyncTask<Void, Integer, Void> {
	
	private final TextView text;
	private int color;
	int r, g, b;
	int rc, gc, bc;
	
	public Anim(TextView text) {
		this.text = text;
	}
	
	protected void onPreExecute() {
		rc = 0; gc = 0; bc = 0;
	}
	
	@Override
	protected Void doInBackground(Void... params) {
		while(true) {
			r = (int)(Math.random()*256); g = (int)(Math.random()*256); b = (int)(Math.random()*256);
			if(isCancelled()) break;
			do {
				rc = add(r, rc);
				gc = add(g, gc);
				bc = add(b, bc);
				color = Color.argb(255, rc, gc, bc);
				publishProgress(color);
				SystemClock.sleep(10);
				if(isCancelled()) break;
			} while(r != rc && g!=gc && b != bc);
		}
		return null;
	}
	
	private int add(int c, int curc) {
		if(curc < c) return curc +=1;
		else if(curc > c) return curc-=1;
		else return curc;
	}
	
	protected void onProgressUpdate(Integer... values) {
		text.setTextColor(values[0]);
	}
}
