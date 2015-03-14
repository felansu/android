package com.example.exemploidentparametro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void enviar(View view) {
		EditText etNome = (EditText) findViewById(R.id.iNome);
		EditText etEmail = (EditText) findViewById(R.id.iEmail);
		
		setContentView(R.layout.activity_main);
		
//		Toast.makeText(getBaseContext(), "Nome: " + etNome.getText().toString()
//				+"\n E-mail: " +etEmail.getText().toString(),Toast.LENGTH_LONG).show();
		
		Intent it = new Intent(getBaseContext(), Tela2Activity.class);
		it.putExtra("nome", etNome.getText().toString());
		it.putExtra("email", etEmail.getText().toString());
		
		//Não retorna
		startActivity(it);
	}

}
