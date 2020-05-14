package br.com.seravini.aare1bi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    private TextView txtAtivoResutado, txtLpa, txtPl, txtRoe, txtVpa, txtPvp;

    private String ativo;
    private Double lucroLiquido, patrimonioLiquido, precoAtual;
    private Long nAcoesBolsa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        setup();
        mostrarResultado();
    }


    private void setup(){
        Bundle b = getIntent().getExtras();

        if (b != null) {
            this.ativo = b.getString("ativo");
            this.lucroLiquido = b.getDouble("lucroLiquido");
            this.patrimonioLiquido = b.getDouble("patrimonioLiquido");
            this.precoAtual = b.getDouble("precoAtual");
            this.nAcoesBolsa = b.getLong("nAcoesBolsa");
        }

        this.txtAtivoResutado = findViewById(R.id.txtAtivoResultado);
        this.txtLpa = findViewById(R.id.txtLpa);
        this.txtPl = findViewById(R.id.txtPl);
        this.txtRoe = findViewById(R.id.txtRoe);
        this.txtVpa = findViewById(R.id.txtVpa);
        this.txtPvp = findViewById(R.id.txtPvp);

    }



    public void mostrarResultado(){

        // Gambiarra

        Double lpa = lucroLiquido / nAcoesBolsa;
        Double pl = precoAtual / lpa;
        Double roe = (lucroLiquido/patrimonioLiquido) * 100;
        Double vpa = patrimonioLiquido/nAcoesBolsa;
        Double pvp = precoAtual / vpa;

        txtAtivoResutado.setText(ativo);
        txtLpa.setText(String.format("L/PA: %.2f", lpa));
        txtPl.setText(String.format("P/L: %.2f", pl));
        txtRoe.setText(String.format("ROE: %.2f", roe));
        txtVpa.setText(String.format("VPA: %.2f", vpa));
        txtPvp.setText(String.format("P/VP: %.2f", pvp));

    }


}
