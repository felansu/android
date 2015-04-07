package com.example.prova;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by felansu on 06/04/2015.
 */
public class segundatela extends Activity {

    private TextView procedimento;
    private TextView data;
    private TextView valor;
    private TextView medico;

    private String P_valor;
    private String P_medico;
    private Date P_date;

    private SimpleDateFormat format;
    private StringBuilder mensagem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segundatela);

        this.procedimento = (TextView) findViewById(R.id.tvProcedimento);
        this.data = (TextView) findViewById(R.id.tvData);
        this.valor = (TextView) findViewById(R.id.tvValor);
        this.medico = (TextView) findViewById(R.id.tvMedico);

        this.format = new SimpleDateFormat("dd/MM/yyyy");
        this.mensagem = new StringBuilder();

        Intent it = getIntent();
        if (!it.equals(null)) {
            String procedimento = it.getStringExtra("procedimento");
            this.P_valor = it.getStringExtra("valor");
            this.P_medico = it.getStringExtra("procedimento");
            this.P_date = new Date(it.getStringExtra("data"));

            this.procedimento.setText(this.procedimento.getText() + procedimento);
            this.valor.setText(this.valor.getText() + P_valor);
            this.medico.setText(this.medico.getText() + P_medico);
            this.data.setText(this.data.getText() + this.format.format(P_date));
        }

    }

    public void validar(View view) {
        this.mensagem = new StringBuilder();
        if (Integer.valueOf(this.P_valor) > 200) {
            Toast.makeText(getBaseContext(), "O valor é maior de 200", Toast.LENGTH_LONG).show();
            this.mensagem.append("# O valor é maior de 200");
        }
        if (this.P_medico.length() > 20) {
            Toast.makeText(getBaseContext(), "O nome do medico contem mais de 20 caracteres", Toast.LENGTH_LONG).show();
            this.mensagem.append("# O nome do medico contem mais de 20 caracteres");
        }
        if (P_date.after(new Date())) {
            Toast.makeText(getBaseContext(), "A data determinada é maior que a atual", Toast.LENGTH_LONG).show();
        }

    }

    public void voltar(View view) {
        Intent it = new Intent();
        it.putExtra("retorno", this.mensagem.toString());
        setResult(RESULT_OK, it);
        finish();
    }
}