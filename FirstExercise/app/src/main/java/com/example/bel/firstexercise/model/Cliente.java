package com.example.bel.firstexercise.model;

public class Cliente {
    private String nome;
    private String sobrenome;
    private String dataNascimento;
    private String cpf;
    private String email;
    private String telefone;

    public Cliente() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setarCampo(String nomeDoCampo, String valorDoCampo) {

        switch (nomeDoCampo){

            case "nome":
                setNome(valorDoCampo);
                break;

            case "sobrenome":
                setSobrenome(valorDoCampo);
                break;

            case "nascimento":
                setDataNascimento(valorDoCampo);
                break;

            case "cpf":
                setCpf(valorDoCampo);
                break;

            case "email":
                setEmail(valorDoCampo);
                break;

            case "telefone":
                setTelefone(valorDoCampo);
                break;
        }
    }
}
