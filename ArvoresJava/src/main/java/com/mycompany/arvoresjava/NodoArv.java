package com.mycompany.arvoresjava;

class NodoArv{
	  private NodoArv pai;
	  private NodoArv esq;
	  //private int dado;
          private Cidades dado;
	  private NodoArv dir;
	  
	  public NodoArv(Cidades cidade ){
	  	//dado = d;
                dado = cidade; 
	  	pai = null;
	  	esq = null;
	  	dir = null;
	  }
	  
	  public NodoArv getEsq(){
	  	return esq;
	  }
	  
	  public void setEsq(NodoArv e){
	  	esq = e;
	  }
	  
	  public NodoArv getDir(){
	  	return dir;
	  }
	  
	  public void setDir(NodoArv d){
	  	dir = d;
	  }
	  
	  public NodoArv getPai(){
	  	return pai;
	  }
	  
	  public void setPai(NodoArv p){
	  	pai = p;
	  }
	  
	  public Cidades getDado(){
	  	return dado;
	  }
	  
	  public void setDado(Cidades dado){
	  	this.dado = dado;
	  }	  
}