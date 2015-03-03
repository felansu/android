package com.example.exemplologcat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.v("log", "Verbose - Esta � uma mensagem preta");
		Log.d("log", "Debug - cor azul");
		Log.w("log", "Warning - esta � uma mensagem de alerta");
		Log.e("log", "Erro - esta � uma mensagem de erro");
		Log.i("log", "Info - informa��o");
	}
	
	// developer.android.com/reference/android/app/Activity.html

}
