package com.example.arraylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText ra, nome, curso;
    Button btninserir, btnvisualizar;
    ArrayList<Aluno> alunos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ra = findViewById(R.id.editTextRa);
        nome = findViewById(R.id.editTextNome);
        curso = findViewById(R.id.editTextCurso);
        btninserir = findViewById(R.id.buttonInserir);
        btnvisualizar = findViewById(R.id.buttonVisualizar);

        btninserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alunos.add(
                        new Aluno(ra.getText().toString(),
                                  nome.getText().toString(),
                                  curso.getText().toString())
                );
                //limpa os campos
                ra.setText("");
                nome.setText("");
                curso.setText("");

                //posiciona o cursor no cammpo ra
                ra.requestFocus();
            }
        });

        btnvisualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultado = new Intent(MainActivity.this,Resultado.class);
                resultado.putExtra("listaAlunos",alunos);
                startActivity(resultado);
            }
        });
    }
}
