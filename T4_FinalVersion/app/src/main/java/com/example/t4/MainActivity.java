package com.example.t4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnUsuario)
    void entrarUsuario(View view){
        try{
            Intent intent = new Intent(this, Login_Usuario.class);
            startActivity(intent);
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"Login Inválido!",Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btnFuncionario)
    void entrarFuncionario(View view){
        try{
            Intent intent = new Intent(this, Login_Funcionario.class);
            startActivity(intent);
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"Login Inválido!",Toast.LENGTH_SHORT).show();
        }
    }

}
