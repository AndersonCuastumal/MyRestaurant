package com.cc.ander.lapampa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DescriptionActivity extends AppCompatActivity implements OnMapReadyCallback{

    private TextView tMenu,tDireccion;
    private Button bVolver;



    private String pampa;
    private LatLng ubicacion;
    MapView mapView;
    GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        tMenu=findViewById(R.id.tMenu);
        tDireccion=findViewById(R.id.tDireccion);
        bVolver=findViewById(R.id.bVolver);

        mapView=findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        Bundle args = getIntent().getExtras();
        if(args!=null){                 //validacion
            tMenu.setText(args.getString("menu"));
            tDireccion.setText(args.getString("id"));
            pampa=args.getString("pampa");

        }




        bVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DescriptionActivity.this,MainActivity.class);
                startActivityForResult(intent,1234);
                finish();
            }
        });

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        double x=0,y=0;
        String id="",sede="";

        mMap=googleMap;

        if(pampa.equals("Pampa1")){
            x=6.2465145;
            y=-75.5977971;
            id="La Pampa Parrilla Argentina";
            sede="Sede Laureles";

        }else if(pampa.equals("Pampa2")){
            x=6.245753;
            y=-75.5925548;
            id="La Pampa Parrilla Argentina";
            sede="Sede Primer parque Laureles";

        }else if(pampa.equals("Pampa3")){
            x=6.2470994;
            y=-75.5947627;
            id="La Pampa Parrilla Argentina";
            sede="Sede Ay Caramba";

        }else if(pampa.equals("Pampa4")){
            x=6.212851;
            y=-75.559392;
            id="La Pampa Parrilla Argentina";
            sede="Sede ISAGEN";

        }else if(pampa.equals("Pampa5")){
            x=6.2077746;
            y=-75.5648158;
            id="La Pampa Parrilla Argentina";
            sede="Sede La Florida";

        }

        ubicacion=new LatLng(x, y);

        mMap.addMarker(new MarkerOptions()
                .position(ubicacion)
                .title(id)
                .snippet(sede)
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, 15));

    }

    public void Volver(View view) {
    }


    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}
