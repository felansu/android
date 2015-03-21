package com.example.trabalho1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private final int TELA_PRINCIPAL = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void enviar(View view) {
		EditText etNome = (EditText) findViewById(R.id.etNome);
		EditText etEmail = (EditText) findViewById(R.id.etEmail);
		EditText etIdade = (EditText) findViewById(R.id.etIdade);

		if (!faltanCampos(etNome, etEmail, etIdade)) {
			Log.i("Log", "Todos os campos forem preenchidos");
			
			Intent it = new Intent(getBaseContext(), MostrarDados.class);
			it.putExtra("nome",etNome.getText().toString());
			it.putExtra("email",etEmail.getText().toString());
			it.putExtra("idade",etIdade.getText().toString());
			
			startActivityForResult(it, TELA_PRINCIPAL);
		}
	}

	public Boolean faltanCampos(EditText nome, EditText email, EditText idade) {
		Log.i("Log", "Verificando campos requeridos");
		
		if (nome.getText().toString().length() == 0)
			nome.setError("Opa ! O nome é requerido !");

		if (email.getText().toString().length() == 0)
			email.setError("O e-mail é super necessário !");

		if (idade.getText().toString().length() == 0)
			idade.setError("Não tenha vergonha da sua idade !");

		return (nome.getError() != null || email.getError() != null || idade.getError() != null) 
				? true : false;
	}

	public void sair(View v) {
		Log.i("Log", "Saindo do programa");
		finish();
		System.exit(0);
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		if (requestCode == TELA_PRINCIPAL) {
			String resultado = data.getStringExtra("erros");
			if (resultado!=null) {
				Toast.makeText(getBaseContext(),
						"Cara, tem que arrumar os seguintes campos: \n"+resultado,
						Toast.LENGTH_LONG).show();
			}
		}
	}
}
