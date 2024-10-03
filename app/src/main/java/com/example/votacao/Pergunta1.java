package com.example.votacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pergunta1 extends AppCompatActivity {


    Button btnNina, btnSophie, btnPacoca, btnBela, btnLuna, btnNulo, btnBranco, btnIndeciso, btnNaoSabe;

    int nina, sophie, pacoca, bela, luna, nulo, branco, indeciso, naoSabe;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pergunta1);

        nina = 0;
        sophie = 0;
        pacoca = 0;
        bela = 0;
        luna = 0;
        nulo = 0;


        btnBela = (Button) findViewById(R.id.btnBela);
        btnLuna = (Button) findViewById(R.id.btnLuna);
        btnNina = (Button) findViewById(R.id.btnNina);
        btnSophie = (Button) findViewById(R.id.btnSophie);
        btnPacoca = (Button) findViewById(R.id.btnPacoca);
        btnNulo = (Button) findViewById(R.id.btnNulo);
        btnBranco = (Button) findViewById(R.id.btnBranco);
        btnIndeciso = (Button) findViewById(R.id.btnIndeciso);
        btnNaoSabe = (Button) findViewById(R.id.btnNaoSabe);

        btnLuna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Pergunta1.this, "Luna selecionada! ", Toast.LENGTH_LONG).show();
                luna ++;
                exibirTelaLogin();
                finish();
            }
        });

        btnBela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Pergunta1.this, "Bela selecionada! ", Toast.LENGTH_LONG).show();
                bela ++;
                exibirTelaLogin();
                finish();
            }
        });

        btnNina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Pergunta1.this, "Nina selecionada! ", Toast.LENGTH_LONG).show();
                nina ++;
                exibirTelaLogin();
                finish();
            }
        });

        btnSophie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Pergunta1.this, "Sophie selecionada! ", Toast.LENGTH_LONG).show();
                sophie ++;
                exibirTelaLogin();
                finish();
            }
        });

        btnPacoca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Pergunta1.this, "Paçoca selecionada! ", Toast.LENGTH_LONG).show();
                pacoca ++;
                exibirTelaLogin();
                finish();
            }
        });

        btnNulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Pergunta1.this, "Nulo selecionado! ", Toast.LENGTH_LONG).show();
                nulo ++;
                exibirTelaLogin();
                finish();
            }
        });

        btnBranco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Pergunta1.this, "Branco selecionado! ", Toast.LENGTH_LONG).show();
                branco ++;
                exibirTelaLogin();
                finish();
            }
        });

        btnIndeciso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Pergunta1.this, "Indeciso selecionado! ", Toast.LENGTH_LONG).show();
                indeciso ++;
                exibirTelaLogin();
                finish();
            }
        });

        btnNaoSabe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Pergunta1.this, "Não sabe selecionado ! ", Toast.LENGTH_LONG).show();
                naoSabe ++;
                exibirTelaLogin();
                finish();
            }
        });


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