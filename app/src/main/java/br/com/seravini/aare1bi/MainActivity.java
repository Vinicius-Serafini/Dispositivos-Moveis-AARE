package br.com.seravini.aare1bi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edAtivo, edLucroLiquido, edPatrimonioLiquido, edNAcoesBolsa, edPrecoAtual;

    private String ativo;
    private Double lucroLiquido, patrimonioLiquido, precoAtual;
    private Long nAcoesBolsa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setup();
    }

    private void setup(){
        this.edAtivo = findViewById(R.id.edAtivo);
        this.edLucroLiquido = findViewById(R.id.edLucroLiquido);
        this.edPatrimonioLiquido = findViewById(R.id.edPatrimonioLiquido);
        this.edNAcoesBolsa = findViewById(R.id.edNAcoesBolsa);
        this.edPrecoAtual = findViewById(R.id.edPrecoAtual);
    }

    public void getVariables(View view){

        // Gambiarra
        if (edAtivo.length() > 0 && edLucroLiquido.length() > 0 && edPatrimonioLiquido.length() > 0
                && edPrecoAtual.length() > 0 && edNAcoesBolsa.length() > 0) {
            this.ativo = edAtivo.getText().toString();
            this.lucroLiquido = Double.parseDouble(edLucroLiquido.getText().toString());
            this.patrimonioLiquido = Double.parseDouble(edPatrimonioLiquido.getText().toString());
            this.precoAtual = Double.parseDouble(edPrecoAtual.getText().toString());
            this.nAcoesBolsa = Long.parseLong(edNAcoesBolsa.getText().toString());

            goToNewActivity();
        }else{
            String erro = "Informe todos os campos";
            Toast.makeText(this, erro, Toast.LENGTH_LONG).show();
        }
    }


    private void goToNewActivity(){


        // vai para a outra Activity passando os dados
        Intent intent = new Intent(MainActivity.this, Resultado.class);
        Bundle b = new Bundle();
        b.putString("ativo", ativo);
        b.putDouble("lucroLiquido", lucroLiquido);
        b.putDouble("patrimonioLiquido", patrimonioLiquido);
        b.putDouble("precoAtual", precoAtual);
        b.putLong("nAcoesBolsa",nAcoesBolsa);
        intent.putExtras(b);
        startActivity(intent);
        //finish(); Descobri que se finalizar a activity na hora de ir para outra não pra pra voltar pelo botão do Android
    }
}
