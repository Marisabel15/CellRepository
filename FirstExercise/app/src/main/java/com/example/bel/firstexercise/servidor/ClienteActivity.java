package com.example.bel.firstexercise.servidor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bel.firstexercise.R;
import com.example.bel.firstexercise.model.Cliente;
import com.example.bel.firstexercise.model.Contato;

import java.util.List;

public class ClienteActivity extends AppCompatActivity {

    List<Cliente> clientes;

    @Override

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        clientes = MainActivity.dadosClienteList.recuperarClientes();

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(this.LAYOUT_INFLATER_SERVICE);

        for (Cliente cliente : clientes) {

            View v = inflater.inflate(R.layout.item_cliente,null,false);

            ((TextView)v.findViewById(R.id.tvNome)).setText(cliente.getNome());

            ((TextView)v.findViewById(R.id.tvSobrenome)).setText(cliente.getSobrenome());

            ((TextView)v.findViewById(R.id.tvNascimento)).setText(cliente.getDataNascimento());

            ((TextView)v.findViewById(R.id.tvCpf)).setText(cliente.getCpf());

            ((TextView)v.findViewById(R.id.tvEmail)).setText(cliente.getEmail());

            ((TextView)v.findViewById(R.id.tvTelefone)).setText(cliente.getTelefone());

            ((LinearLayout)findViewById(R.id.llContainerClientes)).addView(v);

        }
    }
}
