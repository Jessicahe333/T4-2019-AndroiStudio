package com.example.t4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Servico_usuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico_usuario);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnDevolucao)
    void devolver(View view){
        Toast.makeText(getApplicationContext(),"Funcionalidade Futura!",Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnAlugar)
    void Alugar(View view){
        Toast.makeText(getApplicationContext(),"Funcionalidade Futura!",Toast.LENGTH_SHORT).show();
    }
}
