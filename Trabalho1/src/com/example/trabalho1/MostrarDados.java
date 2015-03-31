package com.example.trabalho1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MostrarDados extends Activity {

	private TextView nome;
	private TextView email;
	private TextView idade;
	private StringBuilder erros;
	
	public MostrarDados() {
		this.erros = new StringBuilder();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mostrar_dados);
		
		nome = (TextView) findViewById(R.id.txtNome);
		email = (TextView) findViewById(R.id.txtEmail);
		idade = (TextView) findViewById(R.id.txtIdade);
		
		Intent it = getIntent();
		nome.setText(it.getStringExtra("nome"));
		email.setText(it.getStringExtra("email"));
		idade.setText(it.getStringExtra("idade"));
	}
	
	public void verificacao(View view){
		Vibrator v = (Vibrator) getBaseContext().getSystemService(Context.VIBRATOR_SERVICE);
		v.vibrate(500);
		validaCampos();
		abreDialogo();

	}
	
	private void abreDialogo() {
		new AlertDialog.Builder(this)
	    .setTitle("Campos validados !")
	    .setMessage(erros.length()==0?"Tudo ok!":erros)
	    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	        }
	     })
	    .setIcon(android.R.drawable.ic_dialog_alert)
	     .show();
	}

	public void validaCampos(){
		if(nome.getText().toString().length()>15){
			nome.setError("Opa! Que nome é esse amigão ?! No máximo 15 tá ?");
			erros.append(nome.getError()+"\n");
		}
		if(Integer.valueOf(idade.getText().toString())>18){
			idade.setError("Tem mais de 18 !");
			erros.append(idade.getError()+"\n");
		}
		if(!isValidEmail(email.getText())){
			email.setError("Certeza é um e-mail camarada?");
			erros.append(email.getError()+"\n");
		}
	}
	
	public boolean isValidEmail(CharSequence email) {
		  return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
	}
	
	public void voltar(View view){
		Log.i("Log", "Voltando da tela 'MostrarDados' para 'MainActivity'");
		Intent it = new Intent();
		it.putExtra("erros",erros.toString());
		setResult(RESULT_CANCELED, it);
		finish();
	}
}
