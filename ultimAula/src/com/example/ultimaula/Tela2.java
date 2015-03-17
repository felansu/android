package com.example.ultimaula;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Tela2 extends Activity {

	private TextView tvNome;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela2);

		Intent it = getIntent();
		if (!it.equals(null)) {
			String nome = it.getStringExtra("nome");
			tvNome = (TextView) findViewById(R.id.tvNome);
			tvNome.setText(nome);
		}
	}
	
	public void retornarInformacao(View view){
		Intent it = new Intent();
		it.putExtra("retorno", "informação validada !");
		setResult(RESULT_OK, it);
		finish();
	}
}
