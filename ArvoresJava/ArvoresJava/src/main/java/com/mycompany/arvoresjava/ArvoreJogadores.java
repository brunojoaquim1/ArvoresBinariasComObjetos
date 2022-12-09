/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arvoresjava;

/**
 *
 * @author bruno.joaquim
 */
public class ArvoreJogadores {
    
        
    	private NodoArvJogadores raiz;
	
	public ArvoreJogadores(){
		raiz = null;
	}
	
	public void insNodo(Jogadores jogadores){
		if( raiz == null )
		  raiz = new NodoArvJogadores(jogadores);
		else
		  insere( raiz, jogadores );
	}
	
	public void insere( NodoArvJogadores atual, Jogadores j ){
	  	if( j.quantidade < atual.getDado().quantidade ){
	  		if( atual.getEsq() == null ){
	  			NodoArvJogadores aux = new NodoArvJogadores(j);
	  			atual.setEsq(aux);
	  			atual.getEsq().setPai(atual);
	  			
	  		}
	  		else
	  		  insere( atual.getEsq(), j );
	  	}
	  	else{	  
	  		if( atual.getDir() == null){
	  			NodoArvJogadores aux = new NodoArvJogadores(j);
	  			atual.setDir(aux);
	  			atual.getDir().setPai(atual);
	  		}
	  		else
	  		  insere( atual.getDir(), j );
	     }
	  }
        
                        
        public void central(){
            inFix( raiz );
	}
	public void inFix( NodoArvJogadores raiz){
		if( raiz == null )
		  return;

                        
		inFix( raiz.getEsq() );
		
		System.out.println("Quantidade: " +  raiz.getDado().quantidade +  " | " + raiz.getDado().Cidade);
                
		
		inFix( raiz.getDir() );
	}
        
         public void centralDireita(){
            inFixDireita(raiz);
        }
        
        public void inFixDireita( NodoArvJogadores raiz){
        if( raiz == null )
          return;
        
            inFixDireita( raiz.getDir() );
            
            System.out.println("Quantidade: " +  raiz.getDado().quantidade +  " | " + raiz.getDado().Cidade);
            
            inFixDireita( raiz.getEsq() );

            
	}

    
}
