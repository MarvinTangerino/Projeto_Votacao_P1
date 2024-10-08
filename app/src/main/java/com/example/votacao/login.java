package com.example.votacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {

    Button btnLogin;
    EditText etLogin, etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        etLogin = (EditText) findViewById(R.id.etLogin);
        etPassword = (EditText) findViewById(R.id.etPassword);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etLogin.getText().toString().equals("entrevistador") && etPassword.getText().toString().equals("entrevistador")) {
                    exibirPergunta2();
                }
                else if (etLogin.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin")) {
                    exibirTelaAdmin();
                }
                else{
                    Toast.makeText(login.this, "Usuário ou senha inválidos!", Toast.LENGTH_LONG).show();
                };
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void exibirPergunta2 () {
        Intent tela = new Intent(login.this, Pergunta2.class);
        startActivity(tela);
        finish();
    }

    private void exibirTelaAdmin() {
        Intent tela = new Intent(login.this, ExibirDados.class);
        startActivity(tela);
        finish();
    }
}