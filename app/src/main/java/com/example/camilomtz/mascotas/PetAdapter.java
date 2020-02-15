package com.example.camilomtz.mascotas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.camilomtz.R;

import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder>{

    List<Pet> petList;

    public PetAdapter(List<Pet> petList) {
        this.petList = petList;
    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_mascotas,parent,false);
        return new PetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PetViewHolder holder, int position) {

        holder.obPet(petList.get(position));

    }

    @Override
    public int getItemCount() {
        return petList.size();
    }

    public class PetViewHolder  extends RecyclerView.ViewHolder{
        TextView tvDatos1;
        //TextView nombres;
        //TextView tvDatos2;

        public PetViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDatos1 =(TextView) itemView.findViewById(R.id.datos1);

        }



        public void obPet(Pet pets){

            String dato1 = "MASCOTAS"+"\n\n";
            dato1 += "1. Nombre del Propietario:\n -> "+pets.getNombre_del_propietario()+"\n";
            dato1 += "2. Nombre Mascota: "+pets.getNombre_mascota()+"\n";
            dato1 += "3. Raza: "+pets.getRaza()+"\n";
            dato1 += "4. Edad: "+pets.getEdad()+"\n";
            dato1 += "5. Sexo: "+pets.getSexo()+"\n";
            dato1 += "6. Especie: "+pets.getEspecie()+"\n";
            dato1 += "7. Zona: "+pets.getZona()+"\n";

            tvDatos1.setText(dato1);


        }
    }
}
