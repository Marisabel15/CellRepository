package com.example.bel.firstexercise.model;

import com.google.gson.annotations.SerializedName;

public class Contato {

    @SerializedName("nome")
    private String nome;
    @SerializedName("telefone")
    private String telefone;
    @SerializedName("endereço")
    private String endereco;
    @SerializedName("estado")
    private String estado;
    @SerializedName("email")
    private String email;
    @SerializedName("id")
    private int id;

    public Contato() {}

    public String getNome (){
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getTelefone (){
        return telefone;
    }

    public void setTelefone (String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco (){
        return endereco;
    }

    public void setEndereco (String endereco) {
        this.endereco = endereco;
    }

    public String getEstado (){
        return estado;
    }

    public void setEstado (String estado) {
        this.estado = estado;
    }

    public String getEmail (){
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public int getId (){
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

}
