package com.example.votacao;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import database.DatabaseHelper;

public class Pergunta2 extends AppCompatActivity {

    EditText etSeuVoto, etPrimeiroNome, etEstadoCivil, etIdade, etSexo, etTelefone, etData, etHora;
    DatabaseHelper dbHelper;
    Button btnVotoRapido, btnSair;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pergunta2);

        // Inicializando os campos EditText
        etPrimeiroNome = findViewById(R.id.etPrimeiroNome);
        etEstadoCivil = findViewById(R.id.etEstadoCivil);
        etIdade = findViewById(R.id.etIdade);
        etSexo = findViewById(R.id.etSexo);
        etTelefone = findViewById(R.id.etTelefone);
        etData = findViewById(R.id.etData);
        etHora = findViewById(R.id.etHora);
        etSeuVoto = findViewById(R.id.etSeuVoto);
        btnVotoRapido = findViewById(R.id.btnVotoRapido);
        btnSair = findViewById(R.id.btnSair);

        dbHelper = new DatabaseHelper(this);

        findViewById(R.id.btnCadastrar).setOnClickListener(v -> {
            // Capturar os dados dos campos
            String nome = etPrimeiroNome.getText().toString();
            String estadoCivil = etEstadoCivil.getText().toString();
            String idade = etIdade.getText().toString();
            String sexo = etSexo.getText().toString();
            String telefone = etTelefone.getText().toString();
            String data = etData.getText().toString();
            String hora = etHora.getText().toString();
            String voto = etSeuVoto.getText().toString();

            dbHelper.insertData(nome, estadoCivil, idade, sexo, telefone, data, hora, voto);

            LimparCampos();

            Toast.makeText(Pergunta2.this, "Dados cadastrados com sucesso!", Toast.LENGTH_SHORT).show();
        });

        btnVotoRapido.setOnClickListener(view -> exibirVotosRapidos());
        btnSair.setOnClickListener(view -> sair());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void exibirVotosRapidos () {
        Intent tela = new Intent(Pergunta2.this, Pergunta1.class);
        startActivity(tela);
        finish();
    }
    private void sair () {
        Intent tela = new Intent(Pergunta2.this, login.class);
        startActivity(tela);
        finish();
    }

    private void LimparCampos()
    {
        etPrimeiroNome.setText("");
        etEstadoCivil.setText("");
        etIdade.setText("");
        etSexo.setText("");
        etTelefone.setText("");
        etData.setText("");
        etHora.setText("");
        etSeuVoto.setText("");
    }
}
