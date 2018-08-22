package com.example.bel.firstexercise.dados;

import com.example.bel.firstexercise.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class DadosClienteList {
    private List<Cliente> clientes;

    public DadosClienteList(){ clientes = new ArrayList<>();}

    public void inserirCliente(Cliente cliente){clientes.add(cliente);}

    public List<Cliente> recuperarClientes () {return clientes;}
}
