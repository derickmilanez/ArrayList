package com.example.arraylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Resultado extends AppCompatActivity {
    TextView resultado;
    Button btnvoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        resultado = findViewById(R.id.textViewResultado);
        btnvoltar = findViewById(R.id.buttonVoltar);
        //Recupera dados da intent (Serializados)
        ArrayList<Aluno> listaAlunos = (ArrayList<Aluno>)getIntent().getSerializableExtra("listaAlunos");

        //concatena os resultados
        String tmp = new String();

        //percorrendo a lista de alunos
        for(Aluno aluno : listaAlunos){
            tmp = tmp + aluno.getRa() + ", " +
                        aluno.getNome() + ", " +
                        aluno.getCurso()  +  ".\n";
        }
        resultado.setText(tmp);

        btnvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
