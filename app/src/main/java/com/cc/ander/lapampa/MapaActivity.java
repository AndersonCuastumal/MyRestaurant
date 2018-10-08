package com.cc.ander.lapampa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaActivity extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener {



    private double x1,x2,x3,x4,x5=0,y1,y2,y3,y4,y5=0;
    private String id1,id2,id3,id4,id5,sede1,sede2,sede3,sede4,sede5;
    private Button bCerrar;

    MapView mapView;
    GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        bCerrar=findViewById(R.id.bCerrar);
        bCerrar.setOnClickListener(this);
        mapView=findViewById(R.id.map1);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;


        x1=6.2465145;
        y1=-75.5977971;
        id1="La Pampa Parrilla Argentina";
        sede1="Sede Laureles";

        LatLng location1=new LatLng(x1,y1);
        mMap.addMarker(new MarkerOptions()
                .position(location1)
                .title(id1)
                .snippet(sede1)
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location1, 15));


        x2=6.245753;
        y2=-75.5925548;
        id2="La Pampa Parrilla Argentina";
        sede2="Sede Primer parque Laureles";

        LatLng location2=new LatLng(x2,y2);

        mMap.addMarker(new MarkerOptions()
                .position(location2)
                .title(id2)
                .snippet(sede2)
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location2, 15));


        x3=6.2470994;
        y3=-75.5947627;
        id3="La Pampa Parrilla Argentina";
        sede3="Sede Ay Caramba";

        LatLng location3=new LatLng(x3,y3);

        mMap.addMarker(new MarkerOptions()
                .position(location3)
                .title(id3)
                .snippet(sede3)
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location3, 15));



        x4=6.212851;
        y4=-75.559392;
        id4="La Pampa Parrilla Argentina";
        sede4="Sede ISAGEN";
        LatLng location4=new LatLng(x4,y4);

        mMap.addMarker(new MarkerOptions()
                .position(location4)
                .title(id4)
                .snippet(sede4)
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location4, 15));

        x5=6.2077746;
        y5=-75.5648158;
        id5="La Pampa Parrilla Argentina";
        sede5="Sede La Florida";

        LatLng location5=new LatLng(x5,y5);
        mMap.addMarker(new MarkerOptions()
                .position(location5)
                .title(id5)
                .snippet(sede5)
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location5, 15));

    }

    public void close(View view) {
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(MapaActivity.this,MainActivity.class);
        startActivityForResult(intent,2);
        finish();
    }
}
