package com.example.votacao;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import database.VotosDatabaseHelper;

public class ExibirVotos extends AppCompatActivity {

    TextView txtVotosRapidos;
    Button btnVoltar;
    VotosDatabaseHelper dbHelper = new VotosDatabaseHelper(this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exibirvotosrapidos);

        txtVotosRapidos = findViewById(R.id.txtVotosRapidos);
        btnVoltar = findViewById(R.id.btnVoltar);
        dbHelper = new VotosDatabaseHelper(this);

        exibirVotos();

        btnVoltar.setOnClickListener(view -> voltar());
    }

    private void voltar(){
        Intent tela = new Intent(ExibirVotos.this, ExibirDados.class);
        startActivity(tela);
        finish();
    }

    private void exibirVotos() {
        Cursor res = dbHelper.getAllVotos();
        int totalVotos = dbHelper.getTotalVotos();

        if (res.getCount() == 0) {
            txtVotosRapidos.setText("Nenhum voto registrado.");
            return;
        }

        StringBuilder builder = new StringBuilder();
        while (res.moveToNext()) {
            int nomeIndex = res.getColumnIndex("nome");
            int quantidadeIndex = res.getColumnIndex("quantidade");

            if (nomeIndex == -1 || quantidadeIndex == -1) {
                txtVotosRapidos.setText("Erro: coluna não encontrada.");
                return;
            }

            String nome = res.getString(nomeIndex);
            int quantidade = res.getInt(quantidadeIndex);

            double percentual = (quantidade / (double) totalVotos) * 100;

            builder.append("Nome: ").append(nome).append("\n")
                    .append("Votos: ").append(quantidade).append("\n")
                    .append("Percentual: ").append(String.format("%.2f", percentual)).append("%\n\n");
        }
        txtVotosRapidos.setText(builder.toString());
        res.close();
    }
}
