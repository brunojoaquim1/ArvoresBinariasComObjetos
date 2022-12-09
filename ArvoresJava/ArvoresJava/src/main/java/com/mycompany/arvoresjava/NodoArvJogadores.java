package com.mycompany.arvoresjava;

/**
 *
 * @author bruno.joaquim
 */
public class NodoArvJogadores {
	  private NodoArvJogadores pai;
	  private NodoArvJogadores esq;
	  //private int dado;
          private Jogadores dado;
	  private NodoArvJogadores dir;
	  
	  public NodoArvJogadores(Jogadores jogadores ){
	  	//dado = d;
                dado = jogadores; 
	  	pai = null;
	  	esq = null;
	  	dir = null;
	  }
	  
	  public NodoArvJogadores getEsq(){
	  	return esq;
	  }
	  
	  public void setEsq(NodoArvJogadores e){
	  	esq = e;
	  }
	  
	  public NodoArvJogadores getDir(){
	  	return dir;
	  }
	  
	  public void setDir(NodoArvJogadores d){
	  	dir = d;
	  }
	  
	  public NodoArvJogadores getPai(){
	  	return pai;
	  }
	  
	  public void setPai(NodoArvJogadores p){
	  	pai = p;
	  }
	  
	  public Jogadores getDado(){
	  	return dado;
	  }
	  
	  public void setDado(Jogadores jogadores ){
	  	this.dado = dado;
	  }	  
}