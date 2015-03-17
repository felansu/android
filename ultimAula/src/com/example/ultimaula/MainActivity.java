package com.example.ultimaula;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	final static int N_TELA_PRINCIPAL = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void enviar(View view){
		EditText etNome = (EditText) findViewById(R.id.etNome);
		Intent it = new Intent(getBaseContext(), Tela2.class);
		it.putExtra("nome", etNome.getText().toString());
		// startActivity(it); Só é utilizado quando não queremos receber nada
		startActivityForResult(it, N_TELA_PRINCIPAL);
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		if (requestCode == N_TELA_PRINCIPAL) {
			String resultado = data.getStringExtra("retorno");
			Toast.makeText(getBaseContext(),
					"Resultado foi: "+resultado+
					"Resultado do código foi: "+resultCode,
					Toast.LENGTH_LONG).show();
		}
	}
	
}
