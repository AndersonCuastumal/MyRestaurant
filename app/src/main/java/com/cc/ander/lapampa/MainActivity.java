package com.cc.ander.lapampa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<Restaurante> listaRestaurante;
    RecyclerView recyclerRestaurante;
    private Button bMapa;
    private String cursor="";
    private String id,menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaRestaurante=new ArrayList<>();
        recyclerRestaurante=findViewById(R.id.RecyclerId);
        recyclerRestaurante.setLayoutManager(new LinearLayoutManager(this));
        bMapa=findViewById(R.id.bMapa);

        bMapa.setOnClickListener(this);
        llenarRestaurante();
        adapterRestaurantes adapter=new adapterRestaurantes(listaRestaurante);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(MainActivity.this,DescriptionActivity.class);
                startActivityForResult(intent,1234);
                cursor=listaRestaurante.get(recyclerRestaurante.getChildAdapterPosition(view)).getId();
                Toast.makeText(getApplicationContext(),"seleccion: "+cursor,Toast.LENGTH_SHORT).show();

                if(cursor.equals("Pampa1")){

                    id="cra #24 60-23";
                    menu="Bandeja paisa, hambuergesa, papas fritas";

                    intent.putExtra("menu",menu);
                    intent.putExtra("id",id);
                    intent.putExtra("pampa",cursor);


               }else if(cursor.equals("Pampa2")){

                    id="cra #24 60-23";
                    menu="sopa chocolo, sancocho, helado";

                    intent.putExtra("menu",menu);
                    intent.putExtra("id",id);
                    intent.putExtra("pampa",cursor);
                }else if(cursor.equals("Pampa3")){

                    id="cra #24 60-23";
                    menu="patacones, cerveza, yuca";

                    intent.putExtra("menu",menu);
                    intent.putExtra("id",id);
                    intent.putExtra("pampa",cursor);
                }else if(cursor.equals("Pampa4")){

                    id="cra #24 60-23";
                    menu="mondongo, caviar, sudado";

                    intent.putExtra("menu",menu);
                    intent.putExtra("id",id);
                    intent.putExtra("pampa",cursor);
                }else if(cursor.equals("Pampa5")){

                    id="cra #24 60-23";
                    menu="arroz con leche, carne asada, salchicho";

                    intent.putExtra("menu",menu);
                    intent.putExtra("id",id);
                    intent.putExtra("pampa",cursor);
                }
                startActivityForResult(intent,1);
            }
        });
        recyclerRestaurante.setAdapter(adapter);
    }

    private void llenarRestaurante() {
        listaRestaurante.add(new Restaurante("Pampa1","Direccion: a, Tv. 39 ##76-41, Medellín, Antioquia",R.drawable.pampa1));
        listaRestaurante.add(new Restaurante("Pampa2","Direccion: Cra. 73, Medellín, Antioquia",R.drawable.pampa2));
        listaRestaurante.add(new Restaurante("Pampa3","Direccion: Cra. 75 #4010, Medellín, Antioquia",R.drawable.pampa3));
        listaRestaurante.add(new Restaurante("Pampa4","Direccion: Cra 30 # 10 C - 228, Local 295, Mall Interplaza, Medellín, Antioquia",R.drawable.pampa4));
        listaRestaurante.add(new Restaurante("Pampa5","Direccion: Cra. 33 #8A-05, Medellín, Antioquia",R.drawable.pampa5));

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == 1234 && resultCode == RESULT_OK){
            Toast.makeText(this, data.getExtras().getString("llegaron"),
                    Toast.LENGTH_SHORT).show();
        }

        if( requestCode == 2 && resultCode == RESULT_OK){
            Toast.makeText(this, data.getExtras().getString("llegaron"),
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void goingto(View view) {
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this,MapaActivity.class);
        startActivityForResult(intent,2);
        finish();
    }
}
