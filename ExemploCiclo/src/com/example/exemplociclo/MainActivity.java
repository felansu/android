package com.example.exemplociclo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i("log", "Criando Activity do MainActivity");
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Log.i("log", "Startando Activity do MainActivity");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.i("log", "Resumindo Activity do MainActivity");
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.i("log", "Pausando Activity do MainActivity");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.i("log", "Stopando Activity do MainActivity");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("log", "Destruindo Activity do MainActivity");
	}
	
	public void chamarActivity2(View view){
		Intent it = new Intent(getBaseContext(), Atividade2.class);
		startActivity(it);
//		setContentView(R.layout.activity_atividade2);
	}
	

}
