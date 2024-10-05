package com.example.votacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pergunta2 extends AppCompatActivity {

    EditText etSeuVoto, etPrimeiroNome, etEstadoCivil, etIdade, etSexo, etTelefone, etData, etHora;
    Button btnCadastrar;

    String voto;
    String nome;
    int estadoCivil;
    int idade;
    int sexo;
    int telefone;
    int data;
    int hora;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pergunta2);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        etSeuVoto = (EditText) findViewById(R.id.etSeuVoto);
        etPrimeiroNome = (EditText) findViewById(R.id.etPrimeiroNome);
        etEstadoCivil = (EditText) findViewById(R.id.etEstadoCivil);
        etIdade = (EditText) findViewById(R.id.etIdade);
        etSexo = (EditText) findViewById(R.id.etSexo);
        etTelefone = (EditText) findViewById(R.id.etTelefone);
        etData = (EditText) findViewById(R.id.etData);
        etHora = (EditText) findViewById(R.id.etHora);




        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exibirTelaPergunta1();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void exibirTelaPergunta1 () {
        Intent tela = new Intent(Pergunta2.this, Pergunta1.class);
        startActivity(tela);
        finish();
    }

}