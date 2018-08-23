package com.example.bel.firstexercise.servidor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bel.firstexercise.R;
import com.example.bel.firstexercise.dados.DadosClienteList;
import com.example.bel.firstexercise.model.Cliente;
import com.example.bel.firstexercise.model.ConfigurarCampo;
import com.example.bel.firstexercise.model.Contato;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] hints;
    private String[] tags;
    public static DadosClienteList dadosClienteList;
    public List<ConfigurarCampo> campos;
    private String dados = "[{\"nome\": \"Ozzy Osbourne\",  \"telefone\": \"11666666666\",  \"endereço\": \"Rua Java 66\",  \"estado\": \"São Paulo\",  \"email\": \"morcego@gmail.com\",   \"id\":\"01\"}, {\"nome\": \"Ragnar Lothbrok\",   \"telefone\": \"11888888888\",  \"endereço\": \"Rua Json 88\",  \"estado\": \"São Paulo\",  \"email\":\"vikings@gmail.com\",    \"id\": \"02\"},   {\"nome\": \"Justen Bieber\",   \"telefone\": \"11924242424\",  \"endereço\": \"Rua Kotlin 24\",    \"estado\": \"São Paulo\",    \"email\": \"lessi@gmail.com\", \"id\":\"03\"},  {\"nome\": \"Visconde de Sabugosa\",    \"telefone\": \"11555555555\",  \"endereço\": \"Estrada do Html 55\",   \"estado\": \"São Paulo\",    \"email\": \"milhocozido@gmail.com\",   \"id\": \"04\"},  {\"nome\": \"Inês Brasil\", \"telefone\": \"11913131313\",  \"endereço\": \"Avenida Css 13\",   \"estado\": \"São Paulo\",  \"email\": \"ahazany@gmail.com\",   \"id\": \"05\"}]";
    private String contatosStr = "[{\"nome\": \"Ozzy Osbourne\",  \"telefone\": \"11666666666\",  \"endereço\": \"Rua Java 66\",  \"estado\": \"São Paulo\",  \"email\": \"morcego@gmail.com\",   \"id\":\"01\"}, {\"nome\": \"Ragnar Lothbrok\",   \"telefone\": \"11888888888\",  \"endereço\": \"Rua Json 88\",  \"estado\": \"São Paulo\",  \"email\":\"vikings@gmail.com\",    \"id\": \"02\"},   {\"nome\": \"Justen Bieber\",   \"telefone\": \"11924242424\",  \"endereço\": \"Rua Kotlin 24\",    \"estado\": \"São Paulo\",    \"email\": \"lessi@gmail.com\", \"id\":\"03\"},  {\"nome\": \"Visconde de Sabugosa\",    \"telefone\": \"11555555555\",  \"endereço\": \"Estrada do Html 55\",   \"estado\": \"São Paulo\",    \"email\": \"milhocozido@gmail.com\",   \"id\": \"04\"},  {\"nome\": \"Inês Brasil\", \"telefone\": \"11913131313\",  \"endereço\": \"Avenida Css 13\",   \"estado\": \"São Paulo\",  \"email\": \"ahazany@gmail.com\",   \"id\": \"05\"}]";
    private List<Contato> listContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();

        List<Contato> contatos = gson.fromJson(dados,new TypeToken<List<Contato>>(){}.getType());
        LinearLayout linearLayoutFirst = findViewById(R.id.llContainer);

        dadosClienteList = new DadosClienteList();

        inicializarArr();

       for (ConfigurarCampo configurarCampo : campos) {
           EditText editText = new EditText (this);
           editText.setId(configurarCampo.getId());
           editText.setHint(configurarCampo.getHint());
           editText.setTag(configurarCampo.getTag());

           linearLayoutFirst.addView(editText);
       }

        final int childCount = linearLayoutFirst.getChildCount();

        Button btSend = new Button(this);
        btSend.setText("Enviar");
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout linearLayoutFirst = findViewById(R.id.llContainer);
                linearLayoutFirst.setVisibility(View.GONE);

                LinearLayout linearLayoutResultado = findViewById(R.id.llResultado);
                linearLayoutResultado.setVisibility(View.VISIBLE);

                String resultado = "";

                Cliente cliente = new Cliente();

                for(int i = 0 ; i < hints.length; i++){
                    EditText editText = findViewById(i);

                    if(!TextUtils.isEmpty(editText.getText().toString())){
                        resultado += editText.getText().toString() + "\n";
                        cliente.setarCampo(editText.getTag().toString(),editText.getText().toString());
                        editText.setText("");
                    }
                }

                dadosClienteList.inserirCliente(cliente);

                ((TextView) findViewById(R.id.tvResultado)).setText(resultado);

            }
        });

        ((Button)findViewById(R.id.btCliente)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,ClienteActivity.class);
                startActivity(it);
            }
        });

        ((Button)findViewById(R.id.btContato)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,ContatoActivity.class);
                startActivity(it);
            }
        });

        ((Button)findViewById(R.id.btVoltar)).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                LinearLayout linearLayoutFirst = findViewById(R.id.llContainer);
                linearLayoutFirst.setVisibility(View.VISIBLE);

                LinearLayout linearLayoutResultado = findViewById(R.id.llResultado);
                linearLayoutResultado.setVisibility(View.GONE);
            }
        });

        linearLayoutFirst.addView(btSend);
    }

   private void inicializarArr() {

       hints = getResources().getStringArray(R.array.hints);

       tags = getResources().getStringArray(R.array.tags);

       campos = initCampos();

    }

   private List<ConfigurarCampo> initCampos(){

        List<ConfigurarCampo> list = new ArrayList<>();

        ConfigurarCampo campoNome = new ConfigurarCampo();
        campoNome.setHint(getResources().getString(R.string.nome));
        campoNome.setTag("nome");
        campoNome.setId(1);

        list.add(campoNome);

        ConfigurarCampo campoSobrenome = new ConfigurarCampo();
        campoSobrenome.setHint(getResources().getString(R.string.sobrenome));
        campoSobrenome.setTag("sobrenome");
        campoSobrenome.setId(2);

        list.add(campoSobrenome);

        ConfigurarCampo campoDataNascimento = new ConfigurarCampo();
        campoDataNascimento.setHint(getResources().getString(R.string.dataNascimento));
        campoDataNascimento.setTag("dataNascimento");
        campoDataNascimento.setId(3);

        list.add(campoDataNascimento);

        ConfigurarCampo campoCpf = new ConfigurarCampo();
        campoCpf.setHint(getResources().getString(R.string.cpf));
        campoCpf.setTag("cpf");
        campoCpf.setId(4);

        list.add(campoCpf);

        ConfigurarCampo campoEmail = new ConfigurarCampo();
        campoEmail.setHint(getResources().getString(R.string.email));
        campoEmail.setTag("email");
        campoEmail.setId(5);

        list.add(campoEmail);

        ConfigurarCampo campoTelefone = new ConfigurarCampo();
        campoTelefone.setHint(getResources().getString(R.string.telefone));
        campoTelefone.setTag("telefone");
        campoTelefone.setId(6);

        list.add(campoTelefone);

        return list;

    }}
