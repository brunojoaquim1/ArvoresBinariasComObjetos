
package com.mycompany.arvoresjava;


public class ArvorePaises {
    
    	private NodoArvPais raiz;
	
	public ArvorePaises(){
		raiz = null;
	}
	
	public void insNodo(String pais){
		if( raiz == null )
		  raiz = new NodoArvPais(pais);
		else
		  insere( raiz, pais );
	}
	
	public void insere( NodoArvPais atual, String pais ){
	  	if( primeiraLetraTOASCI(pais) < primeiraLetraTOASCI(atual.getDado()) ){
	  		if( atual.getEsq() == null ){
	  			NodoArvPais aux = new NodoArvPais(pais);
	  			atual.setEsq(aux);
	  			atual.getEsq().setPai(atual);
	  			
	  		}
	  		else
	  		  insere( atual.getEsq(), pais );
	  	}
	  	else{	  
	  		if( atual.getDir() == null){
	  			NodoArvPais aux = new NodoArvPais(pais);
	  			atual.setDir(aux);
	  			atual.getDir().setPai(atual);
	  		}
	  		else
	  		  insere( atual.getDir(), pais );
	     }
	  }
        
                        
        public void central(){
            inFix( raiz );
	}
	public void inFix( NodoArvPais raiz){
		if( raiz == null )
		  return;

                        
		inFix( raiz.getEsq() );
		
		System.out.println( raiz.getDado() +  "");
                
		
		inFix( raiz.getDir() );
	}
        
         public void centralDireita(){
            inFixDireita(raiz);
        }
        
        public void inFixDireita( NodoArvPais raiz){
        if( raiz == null )
          return;
        
            inFixDireita( raiz.getDir() );
            
            System.out.println( raiz.getDado() +  "");
            
            inFixDireita( raiz.getEsq() );

            
	}
        
        
        
        public int  primeiraLetraTOASCI(String nome){
        int i;
        char c;
        
        c = nome.charAt(0);
        
        i = c;
        
        return i;
        
    }
    
}
