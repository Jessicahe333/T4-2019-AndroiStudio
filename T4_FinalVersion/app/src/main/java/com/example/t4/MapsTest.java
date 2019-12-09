package com.example.t4;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.ButterKnife;
import model.Carro;

public class MapsTest extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double mLat;
    private double mLon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpas_test);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        ButterKnife.bind(this);
        Intent veioDeOutraTela = getIntent();
        Bundle bundle =  veioDeOutraTela.getExtras();

        mLat = ((Carro) bundle.getSerializable("Localizacao")).getLatitude();
        mLon = ((Carro) bundle.getSerializable("Localizacao")).getLongitude();
        Log.d("FULAN", "onResponse: "+ mLat + " - " + mLon);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(mLat, mLon);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Localização do usuário"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 17.5f)); //17.5f nível de zoom pouco acima da rua

    }
}
