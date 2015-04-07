package com.example.prova;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MyActivity extends Activity {

    private static final int TELA_PRINCIPAL = 0;

    private EditText procedimento;
    private EditText data;
    private EditText valor;
    private EditText medico;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        this.procedimento = (EditText) findViewById(R.id.etNomeProcedimento);
        this.data = (EditText) findViewById(R.id.etData);
        this.valor = (EditText) findViewById(R.id.etValor);
        this.medico = (EditText) findViewById(R.id.etMedico);
    }

    public void enviar(View view) {
        if (this.procedimento.getText().toString().equals("") ||
                this.data.equals("") ||
                this.valor.toString().equals("")||
                this.medico.toString().equals("")) {
            Toast.makeText(getBaseContext(), "Eita! Algum campinho ta vazio camarada !", Toast.LENGTH_LONG).show();
        } else {


            Intent it = new Intent(getBaseContext(), segundatela.class);
            it.putExtra("procedimento", procedimento.getText().toString());
            it.putExtra("data", data.getText().toString());
            it.putExtra("valor", valor.getText().toString());
            it.putExtra("medico", medico.getText().toString());

            startActivityForResult(it, TELA_PRINCIPAL);
        }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == TELA_PRINCIPAL) {
            String resultado = data.getStringExtra("retorno");
            Toast.makeText(getBaseContext(), "Resultado foi: " + resultado + "Resultado do código foi: " + resultCode,
                    Toast.LENGTH_LONG).show();
        }
    }

    public void limpar(View view){
        this.procedimento.setText("");
        this.valor.setText("");
        this.medico.setText("");
        this.data.setText("");
    }

    public void sair(View view) {
        finish();
    }
}
