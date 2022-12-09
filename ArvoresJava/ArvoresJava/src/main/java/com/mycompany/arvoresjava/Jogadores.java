package com.mycompany.arvoresjava;

public class Jogadores {
    public String Cidade;
    public String Pais;
    public int    quantidade;

    public Jogadores(String Cidade, String Pais, int quantidade) {
        this.Cidade = Cidade;
        this.Pais = Pais;
        this.quantidade = quantidade;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public int getquantidade() {
        return quantidade;
    }

    public void setJogadores(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
