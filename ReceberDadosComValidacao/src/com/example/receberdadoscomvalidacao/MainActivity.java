package com.example.receberdadoscomvalidacao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final int TELA_PRINCIPAL = 0;

	EditText nome;
	EditText idade;
	EditText cpf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		nome = (EditText) findViewById(R.id.etNome);
		idade = (EditText) findViewById(R.id.etIdade);
		cpf = (EditText) findViewById(R.id.etCPF);

	}

	public void enviar(View view) {
		Intent it = new Intent(getBaseContext(), Tela2.class);
		it.putExtra("nome", nome.getText().toString());
		it.putExtra("idade", idade.getText().toString());
		it.putExtra("cpf", cpf.getText().toString());

		startActivityForResult(it, TELA_PRINCIPAL);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		String retorno = data.getStringExtra("retorno");
		if (requestCode == TELA_PRINCIPAL) {
			if (resultCode == Tela2.SUCESSO) {
				Toast.makeText(getBaseContext(), retorno, Toast.LENGTH_LONG).show();
			} else if (requestCode == Tela2.ERRO) {
				Toast.makeText(getBaseContext(), retorno, Toast.LENGTH_LONG).show();
			}

		}

	}
}
