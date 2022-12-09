/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arvoresjava;

/**
 *
 * @author Ideapad3i
 */
public class NodoArvPais {

	  private NodoArvPais pai;
	  private NodoArvPais esq;
	  //private int dado;
          private String dado;
	  private NodoArvPais dir;
	  
	  public NodoArvPais(String pais ){
	  	//dado = d;
                dado = pais; 
	  	pai = null;
	  	esq = null;
	  	dir = null;
	  }
	  
	  public NodoArvPais getEsq(){
	  	return esq;
	  }
	  
	  public void setEsq(NodoArvPais e){
	  	esq = e;
	  }
	  
	  public NodoArvPais getDir(){
	  	return dir;
	  }
	  
	  public void setDir(NodoArvPais d){
	  	dir = d;
	  }
	  
	  public NodoArvPais getPai(){
	  	return pai;
	  }
	  
	  public void setPai(NodoArvPais p){
	  	pai = p;
	  }
	  
	  public String getDado(){
	  	return dado;
	  }
	  
	  public void setDado(String dado){
	  	this.dado = dado;
	  }	  
}
