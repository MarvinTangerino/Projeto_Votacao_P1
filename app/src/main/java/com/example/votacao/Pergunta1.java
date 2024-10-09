package com.example.votacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import database.DatabaseHelper;
import database.VotosDatabaseHelper;

public class Pergunta1 extends AppCompatActivity {


    ImageButton btnNina, btnSophie, btnPacoca, btnBela, btnLuna;
    Button btnNulo, btnBranco, btnIndeciso, btnNaoSabe;
    VotosDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pergunta1);

        dbHelper = new VotosDatabaseHelper(this);

        btnBela = (ImageButton) findViewById(R.id.btnBela);
        btnLuna = (ImageButton) findViewById(R.id.btnLuna);
        btnNina = (ImageButton) findViewById(R.id.btnNina);
        btnSophie = (ImageButton) findViewById(R.id.btnSophie);
        btnPacoca = (ImageButton) findViewById(R.id.btnPacoca);
        btnNulo = (Button) findViewById(R.id.btnNulo);
        btnBranco = (Button) findViewById(R.id.btnBranco);
        btnIndeciso = (Button) findViewById(R.id.btnIndeciso);
        btnNaoSabe = (Button) findViewById(R.id.btnNaoSabe);

        btnLuna.setOnClickListener(view -> {
            Toast.makeText(Pergunta1.this, "Luna selecionada! ", Toast.LENGTH_LONG).show();
            dbHelper.adicionarVoto("Luna");
            exibirTelaLogin();
        });

        btnBela.setOnClickListener(view -> {
            Toast.makeText(Pergunta1.this, "Bela selecionada! ", Toast.LENGTH_LONG).show();
            dbHelper.adicionarVoto("Bela");
            exibirTelaLogin();
        });

        btnNina.setOnClickListener(view -> {
            Toast.makeText(Pergunta1.this, "Nina selecionada! ", Toast.LENGTH_LONG).show();
            dbHelper.adicionarVoto("Nina");
            exibirTelaLogin();
        });

        btnSophie.setOnClickListener(view -> {
            Toast.makeText(Pergunta1.this, "Sophie selecionada! ", Toast.LENGTH_LONG).show();
            dbHelper.adicionarVoto("Sophie");
            exibirTelaLogin();
        });

        btnPacoca.setOnClickListener(view -> {
            Toast.makeText(Pergunta1.this, "Paçoca selecionada! ", Toast.LENGTH_LONG).show();
            dbHelper.adicionarVoto("Paçoca");
            exibirTelaLogin();
        });

        btnNulo.setOnClickListener(view -> {
            Toast.makeText(Pergunta1.this, "Nulo selecionado! ", Toast.LENGTH_LONG).show();
            dbHelper.adicionarVoto("Nulo");
            exibirTelaLogin();
        });

        btnBranco.setOnClickListener(view -> {
            Toast.makeText(Pergunta1.this, "Branco selecionado! ", Toast.LENGTH_LONG).show();
            dbHelper.adicionarVoto("Branco");
            exibirTelaLogin();
        });

        btnIndeciso.setOnClickListener(view -> {
            Toast.makeText(Pergunta1.this, "Indeciso selecionado! ", Toast.LENGTH_LONG).show();
            dbHelper.adicionarVoto("Indeciso");
            exibirTelaLogin();
        });

        btnNaoSabe.setOnClickListener(view -> {
            Toast.makeText(Pergunta1.this, "Não sabe selecionado! ", Toast.LENGTH_LONG).show();
            dbHelper.adicionarVoto("Não Sabe");
            exibirTelaLogin();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void exibirTelaLogin () {
        Intent tela = new Intent(Pergunta1.this, Pergunta2.class);
        startActivity(tela);
        finish();
    }
}