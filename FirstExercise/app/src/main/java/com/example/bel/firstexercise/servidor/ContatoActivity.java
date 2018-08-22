package com.example.bel.firstexercise.servidor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bel.firstexercise.R;
import com.example.bel.firstexercise.model.Cliente;
import com.example.bel.firstexercise.model.Contato;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class ContatoActivity extends AppCompatActivity {

    List<Contato> contatos;

    @Override

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        contatos = (List<Contato>) new TypeToken<List<Contato>>(){}.getType();

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(this.LAYOUT_INFLATER_SERVICE);

        for (Contato contato : contatos) {

            View v = inflater.inflate(R.layout.item_contato,null,false);

            ((TextView)v.findViewById(R.id.tvNome)).setText(contato.getNome());

            ((TextView)v.findViewById(R.id.tvTelefone)).setText(contato.getTelefone());

            ((TextView)v.findViewById(R.id.tvSobrenome)).setText(contato.getEndereco());

            ((TextView)v.findViewById(R.id.tvNascimento)).setText(contato.getEstado());

            ((TextView)v.findViewById(R.id.tvEmail)).setText(contato.getEmail());

            ((TextView)v.findViewById(R.id.tvCpf)).setText(contato.getId());

            ((LinearLayout)findViewById(R.id.llContainerContato)).addView(v);

        }
    }
}
