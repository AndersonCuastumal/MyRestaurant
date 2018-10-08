package com.cc.ander.lapampa;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class adapterRestaurantes extends RecyclerView.Adapter<adapterRestaurantes.ViewHolderRestaurantes> implements View.OnClickListener{


    ArrayList<Restaurante> listaRestaurante;
    private View.OnClickListener selection;

    public adapterRestaurantes(ArrayList<Restaurante> listaRestaurante) {
        this.listaRestaurante = listaRestaurante;
    }

    @NonNull
    @Override
    public ViewHolderRestaurantes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_restautantes,null,false);
        view.setOnClickListener(this);
        return new ViewHolderRestaurantes(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderRestaurantes holder, int position) {
        holder.tinfo.setText(listaRestaurante.get(position).getId());
        holder.tinfo.setText(listaRestaurante.get(position).getInfo());
        holder.Ifoto.setImageResource(listaRestaurante.get(position).getImage());
    }

    @Override
    public int getItemCount() {

        return listaRestaurante.size();
    }

    public void setOnClickListener(View.OnClickListener selection){
        this.selection=selection;
    }


    @Override
    public void onClick(View view) {
        if(selection!=null){
            selection.onClick(view);
        }
    }

    public class ViewHolderRestaurantes extends RecyclerView.ViewHolder{
        TextView tid,tinfo;
        ImageView Ifoto;
        public ViewHolderRestaurantes(View itemView) {
            super(itemView);
            tid=itemView.findViewById(R.id.tNombre);
            tinfo=itemView.findViewById((R.id.tInfo));
            Ifoto=itemView.findViewById(R.id.idImage);
        }
    }
}
