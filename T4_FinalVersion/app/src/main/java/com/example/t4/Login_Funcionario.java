package com.example.t4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import model.Funcionario;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Login_Funcionario extends AppCompatActivity {

    private List<Funcionario> myEmployees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__funcionario);
        ButterKnife.bind(this);
        myEmployees = new ArrayList();
    }

    @BindView(R.id.editTextNome_F) EditText editTextNome_F;
    @BindView(R.id.editTextSenha_F) EditText editTextSenha_F;
    @OnClick(R.id.btnLogin_F)
    public void login_F() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://v2-api.sheety.co/1f6cb541ec427f464b43052269b88dcb/usuario/funcionario")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    String login, senha;
                    JSONObject todosDadosJson = null;
                    //Log.d("FULAN", "onResponse: "+ "teste");
                    try {
                        todosDadosJson = new JSONObject(response.body().string());
                        Log.d("FULAN", "onResponse: " + todosDadosJson.toString());
                        JSONArray dados = todosDadosJson.getJSONArray("funcionario");
                        JSONObject object = null;
                        myEmployees.clear();
                        for (int i = 0; i < dados.length(); i++) {
                            try {

                                object = dados.getJSONObject(i);
                                myEmployees.add(new Funcionario(
                                        object.getInt("id"),
                                        object.getString("login"),
                                        object.getString("senha"))
                                );
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try{
                        login = editTextNome_F.getText().toString();
                        senha = editTextSenha_F.getText().toString();
                        for(int i = 0; i < myEmployees.size(); i++){
                            if(login.equals(myEmployees.get(i).getLogin()) && senha.equals(myEmployees.get(i).getSenha())){
                                Intent intent1 = new Intent(getApplicationContext(), Lista_Carros.class);
                                startActivity(intent1);
                                return;
                            }
                        }
                        runOnUiThread(
                                () -> {
                                    Toast.makeText(getApplicationContext(),"Login Inválido!",Toast.LENGTH_SHORT).show();
                                }
                        );

                    }catch (Exception e){
//                        Toast.makeText(getApplicationContext(),"Login Inválido!",Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }

                    Log.d("FULAN", "onResponse: "+myEmployees);
                }
            }
        });
    }
}
