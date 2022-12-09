
package com.mycompany.arvoresjava;

public class Cidades {
    public String nome;
    public String pais;
    public String latitude;
    public String longitude;
    public int    jogadores;
    public int    primeiraLetraASCI;

    public Cidades(String nome, String pais, String latitude, String longitude, int jogadores) {
        this.nome = nome;
        this.pais = pais;
        this.latitude = latitude;
        this.longitude = longitude;
        this.jogadores = jogadores;
        this.primeiraLetraASCI = primeiraLetraTOASCI(this.nome);
    }
    
    public Cidades(){
        
    }
    
    public int  primeiraLetraTOASCI(String nome){
        int i;
        char c;
        
        c = nome.charAt(0);
        
        i = c;
        
        return i;
        
    }
    

    public String getNome() {
        return nome;
    }
    
    public int getPrimeiraLetra(){
        return primeiraLetraASCI;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getJogadores() {
        return jogadores;
    }

    public void setJogadores(int jogadores) {
        this.jogadores = jogadores;
    }
    
}
