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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class ContatoActivity extends AppCompatActivity {

    String jsonContatos = "[{\"nome\": \"Ozzy Osbourne\",  \"telefone\": \"11666666666\",  \"endereço\": \"Rua Java 66\",  \"estado\": \"São Paulo\",  \"email\": \"morcego@gmail.com\",   \"id\":\"01\"}, {\"nome\": \"Ragnar Lothbrok\",   \"telefone\": \"11888888888\",  \"endereço\": \"Rua Json 88\",  \"estado\": \"São Paulo\",  \"email\":\"vikings@gmail.com\",    \"id\": \"02\"},   {\"nome\": \"Justen Bieber\",   \"telefone\": \"11924242424\",  \"endereço\": \"Rua Kotlin 24\",    \"estado\": \"São Paulo\",    \"email\": \"lessi@gmail.com\", \"id\":\"03\"},  {\"nome\": \"Visconde de Sabugosa\",    \"telefone\": \"11555555555\",  \"endereço\": \"Estrada do Html 55\",   \"estado\": \"São Paulo\",    \"email\": \"milhocozido@gmail.com\",   \"id\": \"04\"},  {\"nome\": \"Inês Brasil\", \"telefone\": \"11913131313\",  \"endereço\": \"Avenida Css 13\",   \"estado\": \"São Paulo\",  \"email\": \"ahazany@gmail.com\",   \"id\": \"05\"}]";

    List<Contato> contatos;

    @Override

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        Gson gson = new Gson();

        contatos = gson.fromJson(jsonContatos,new TypeToken<List<Contato>>(){}.getType());

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(this.LAYOUT_INFLATER_SERVICE);

        for (Contato contato : contatos) {

            View v = inflater.inflate(R.layout.item_contato,null,false);

            ((TextView)v.findViewById(R.id.tvNome)).setText(contato.getNome());

            ((TextView)v.findViewById(R.id.tvTelefone)).setText(contato.getTelefone());

            ((TextView)v.findViewById(R.id.tvEndereço)).setText(contato.getEndereco());

            ((TextView)v.findViewById(R.id.tvEstado)).setText(contato.getEstado());

            ((TextView)v.findViewById(R.id.tvEmail)).setText(contato.getEmail());

            ((TextView)v.findViewById(R.id.tvId)).setText(contato.getId());

            ((LinearLayout)findViewById(R.id.llContainerContato)).addView(v);

        }
    }
}
