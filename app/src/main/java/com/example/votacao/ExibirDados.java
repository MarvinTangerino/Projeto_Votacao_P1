package com.example.votacao;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import database.DatabaseHelper;

public class ExibirDados extends AppCompatActivity {

    TextView txtExibirDados;
    DatabaseHelper dbHelper;
    Button btnProxVotos, btnLogout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exibirdados);

        txtExibirDados = findViewById(R.id.txtExibirDados);
        btnProxVotos = findViewById(R.id.btnProxVotos);
        btnLogout = findViewById(R.id.btnLogout);
        dbHelper = new DatabaseHelper(this);

        // Exibir os dados do banco de dados no TextView
        exibirDados();

        btnProxVotos.setOnClickListener(view -> exibirProxVotos());
        btnLogout.setOnClickListener(view -> logout());
    }

    private void exibirDados() {
        Cursor res = dbHelper.getAllData();
        if (res.getCount() == 0) {
            txtExibirDados.setText("Nenhum dado encontrado.");
            return;
        }

        StringBuilder dados = new StringBuilder();
        while (res.moveToNext()) {
            // Concatena os dados obtidos do banco
            dados.append("Nome: ").append(res.getString(1)).append("\n")
                    .append("Estado Civil: ").append(res.getString(2)).append("\n")
                    .append("Idade: ").append(res.getString(3)).append("\n")
                    .append("Sexo: ").append(res.getString(4)).append("\n")
                    .append("Telefone: ").append(res.getString(5)).append("\n")
                    .append("Data: ").append(res.getString(6)).append("\n")
                    .append("Hora: ").append(res.getString(7)).append("\n")
                    .append("Voto: ").append(res.getString(8)).append("\n\n");
        }

        txtExibirDados.setText(dados.toString());
    }

    private void exibirProxVotos() {
        Intent tela = new Intent(ExibirDados.this, ExibirVotos.class);
        startActivity(tela);
        finish();
    }

    private void logout() {
        Intent tela = new Intent(ExibirDados.this, login.class);
        startActivity(tela);
        finish();
    }
}
