package com.example.receberdadoscomvalidacao;

import android.app.Activity;
import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Tela2 extends Activity {
	public static final int SUCESSO = 0;
	public static final int ERRO = 1;

	private String mensagemDeValidacao;

	String nome;
	String idade;
	String cpf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela2);

		TextView nome = (TextView) findViewById(R.id.tvNome);
		TextView cpf = (TextView) findViewById(R.id.tvCPF);
		TextView idade = (TextView) findViewById(R.id.tvIdade);

		Intent it = getIntent();
		this.nome = it.getStringExtra("nome");
		nome.setText(this.nome);

		this.idade = it.getStringExtra("idade");
		idade.setText(this.idade);

		this.cpf = it.getStringExtra("cpf");
		cpf.setText(it.getStringExtra("cpf"));
	}

	public void validar(View view) {
		Intent it = new Intent();
		Integer idadeAuxiliar = null;
		try {
			idadeAuxiliar = Integer.parseInt(idade);
		} catch (ParseException e) {
			setResult(ERRO, it);
		}
		mensagemDeValidacao = "";
		if (idadeAuxiliar > 5) {
			mensagemDeValidacao = "Validação realizada com sucesso !";
		} else {
			mensagemDeValidacao = "Dados invalidados !";
		}
		it.putExtra("retorno", mensagemDeValidacao);
		setResult(SUCESSO, it);
		finish();
		
	}

	public void finalizar(View view) {
		finish();
	}

}
