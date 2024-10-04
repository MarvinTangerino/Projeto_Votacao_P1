package com.example.votacao;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pergunta2 extends AppCompatActivity {

    EditText etSeuVoto, etPrimeiroNome, etEstadoCivil, etIdade, etSexo, etTelefone, etData, etHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pergunta2);

        etPrimeiroNome = findViewById(R.id.etPrimeiroNome);
        etEstadoCivil = findViewById(R.id.etEstadoCivil);
        etIdade = findViewById(R.id.etIdade);
        etSexo = findViewById(R.id.etSexo);
        etTelefone = findViewById(R.id.etTelefone);
        etData = findViewById(R.id.etData);
        etHora = findViewById(R.id.etHora);
        etSeuVoto = findViewById(R.id.etSeuVoto);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}