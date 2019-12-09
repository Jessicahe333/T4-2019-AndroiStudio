package com.example.t4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import model.Carro;

public class Info_Carro extends AppCompatActivity {
    private Carro myInfo;

    @BindView(R.id.textInfoCarro)
    protected TextView textInfoCarro;

//    @BindView(R.id.listViewInfo)
//    protected ListView listViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacao_carro);
        ButterKnife.bind(this);
        Intent veioDeOutraTela = getIntent();
        Bundle bundle =  veioDeOutraTela.
                getExtras();

        myInfo = (Carro) bundle.getSerializable("LISTA_INFOS");
        textInfoCarro.append("Marca:"+ myInfo.getMarca() +"\n");
        textInfoCarro.append("Modelo:"+myInfo.getModelo()+"\n");
        textInfoCarro.append("Ano:"+myInfo.getAno()+"\n");
        textInfoCarro.append("Cor:"+myInfo.getCor()+"\n");
        textInfoCarro.append("Placa:"+myInfo.getPlaca()+"\n");
        textInfoCarro.append("Localização:"+myInfo.getLocalizacao()+"\n");
        textInfoCarro.append("Distância:"+myInfo.getDistancia());
        textInfoCarro.append("Latitude:"+myInfo.getLatitude());

//        ArrayAdapter<Carro> adapter = new ArrayAdapter(this,
//                android.R.layout.simple_list_item_1, myInfo);
//        listViewInfo.setAdapter(adapter);

    }
    @OnClick(R.id.btnBuscarCarro)
    void buscarCarro(){
        Intent intent1 = new Intent(getApplicationContext(), MapsTest.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Localizacao",(Serializable) myInfo);
        intent1.putExtras(bundle);
        //based on item add info to intent
        Log.d("FULAN", "onResponse: "+ bundle);
        startActivity(intent1);
    }
}
