package com.example.exemplociclo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Atividade2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_atividade2);
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i("log", "Startando Activity do Atividade2");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.i("log", "Resumindo Activity do Atividade2");
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.i("log", "Pausando Activity do Atividade2");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.i("log", "Stopando Activity do Atividade2");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("log", "Destruindo Activity do Atividade2");
	}
	
	public void voltarMenu(View view) {
		finish();
	}
}
