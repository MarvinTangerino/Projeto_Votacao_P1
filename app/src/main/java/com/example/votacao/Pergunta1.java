package com.example.votacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pergunta1 extends AppCompatActivity {


    Button btnNina, btnSophie, btnPacoca, btnBela, btnLuna;

    int nina, sophie, pacoca, bela, luna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pergunta1);

        btnBela = (Button) findViewById(R.id.btnBela);
        btnLuna = (Button) findViewById(R.id.btnLuna);
        btnNina = (Button) findViewById(R.id.btnNina);
        btnSophie = (Button) findViewById(R.id.btnSophie);
        btnPacoca = (Button) findViewById(R.id.btnPacoca);

        if ()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void exibirTelaLogin () {
        Intent tela = new Intent(Pergunta1.this, login.class);
        startActivity(tela);
        finish();
    }
}