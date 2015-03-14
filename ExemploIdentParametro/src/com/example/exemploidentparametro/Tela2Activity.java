package com.example.exemploidentparametro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Tela2Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela2);

		Intent it = getIntent();

		if (!it.equals(null)) {
			String nome = it.getStringExtra("nome");
			String email = it.getStringExtra("email");

			TextView txtTitulo = (TextView) findViewById(R.id.txtTela2);
			TextView txtNome = (TextView) findViewById(R.id.t2Inome);
			TextView txtEmail = (TextView) findViewById(R.id.t2IEmail);

			
			if (email.equals("Homem")) {
				txtTitulo.setText("Bemvindo "+nome+" !");
			}else{
				txtTitulo.setText("Bemvinda "+nome+" !");
			}
			txtNome.setText("Nome: "+nome);
			txtEmail.setText("E-mail: " + email);
		}
	}
	
	public void voltar(View view){
		finish();
	}
}
