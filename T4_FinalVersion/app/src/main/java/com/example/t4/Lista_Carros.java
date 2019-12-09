package com.example.t4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import model.Carro;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Lista_Carros extends AppCompatActivity {

    private List<Carro> myCars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_carros);
        ButterKnife.bind(this);
        myCars = new ArrayList();


        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://v2-api.sheety.co/1f6cb541ec427f464b43052269b88dcb/usuario/carros")
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
                    String Marca,Modelo,Ano,Cor,Localizacao,Distancia,Latitude,Longitude;
                    JSONObject todosDadosJson = null;
                    //Log.d("FULAN", "onResponse: "+ "teste");
                    try {
                        todosDadosJson = new JSONObject(response.body().string());
                        //Log.d("FULAN", "onResponse: " + todosDadosJson.toString());
                        JSONArray dados = todosDadosJson.getJSONArray("carros");
                        JSONObject object = null;
                        myCars.clear();
                        for (int i = 0; i < dados.length(); i++) {
                            try {

                                object = dados.getJSONObject(i);
                                myCars.add(new Carro(
                                        object.getInt("id"),
                                        object.getInt("alugado"),
                                        object.getString("marca"),
                                        object.getString("modelo"),
                                        object.getString("ano"),
                                        object.getString("cor"),
                                        object.getString("placa"),
                                        object.getString("localizacao"),
                                        object.getString("distancia"),
                                        object.getDouble("latitude"),
                                        object.getDouble("longitude"))
                                );
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //Log.d("CARA", "onResponse: "+ myCars);
                    final ListView listViewCars = findViewById(R.id.listListaCarros);

                    ArrayList<String> arrayListCars = new ArrayList<>();
                    for(int i = 0; i < myCars.size(); i++){
                        arrayListCars.add("Distância: "+myCars.get(i).getDistancia()+ "\n" + "Localização:"+myCars.get(i).getLocalizacao()+ "\n" + "Latitude: "+myCars.get(i).getLatitude()+ "\n" + "Longitude: "+myCars.get(i).getLongitude());
                        //Log.d("CARA", "onResponse: "+ arrayListCars);
                    }

                    runOnUiThread(
                            () ->{
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,arrayListCars);
                    listViewCars.setAdapter(arrayAdapter);
                                listViewCars.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                                    @Override public void onItemClick(AdapterView<?> adapter,View view, int position, long id){
                                        Intent intent = new Intent(getApplicationContext(),Info_Carro.class);
                                        Bundle bundle = new Bundle();
                                        bundle.putSerializable("LISTA_INFOS",(Serializable) myCars.get(position));
                                        intent.putExtras(bundle);
                                        //based on item add info to intent
                                        Log.d("FULAN", "onResponse: "+ bundle);
                                        startActivity(intent);

                                    }
                                });
                    //Log.d("FULAN", "onResponse: "+ myCars);


                }
                    );
                }

            }
        });
    }
}
