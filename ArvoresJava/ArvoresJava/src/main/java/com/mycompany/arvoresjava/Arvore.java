/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arvoresjava;

import java.util.ArrayList;

public class Arvore{
	
	private NodoArv raiz;
	
	public Arvore(){
		raiz = null;
	}
	
	public void insNodo(Cidades c){
		if( raiz == null )
		  raiz = new NodoArv( c );
		else
		  insere( raiz, c );
	}
	
	public void insere( NodoArv atual, Cidades c ){
	  	if( c.getNome().compareTo(atual.getDado().getNome()) < 0 ){
	  		if( atual.getEsq() == null ){
	  			NodoArv aux = new NodoArv(c);
	  			atual.setEsq(aux);
	  			atual.getEsq().setPai(atual);
	  			
	  		}
	  		else
	  		  insere( atual.getEsq(), c );
	  	}
	  	else{	  
	  		if( atual.getDir() == null){
	  			NodoArv aux = new NodoArv(c);
	  			atual.setDir(aux);
	  			atual.getDir().setPai(atual);
	  		}
	  		else
	  		  insere( atual.getDir(), c );
	     }
	  }	  
	
	
	public void preFixado(){
		preFix( raiz );
	}
	
	public void preFix( NodoArv raiz){
		if( raiz == null )
		  return;
                String newLine = System.getProperty("line.separator");
                
                System.out.println(newLine);
		System.out.println( raiz.getDado().getNome() + newLine);
		
		preFix( raiz.getEsq() );
		preFix( raiz.getDir() );
	}
        
        public String devolvePaises(){
		preFixdevolvePaises( raiz );
                return this.paises;
	}
        
        String paises = "" ;
        public void preFixdevolvePaises( NodoArv raiz){
		if( raiz == null )
		  return;

		paises = paises + (raiz.getDado().getPais() + ";");
		
		preFixdevolvePaises( raiz.getEsq() );
		preFixdevolvePaises( raiz.getDir() );
                
	}
    
         
        
        public void centralDireita(){
            inFixDireita(raiz);
        }
        
        public void inFixDireita( NodoArv raiz){
        if( raiz == null )
          return;
        
            inFixDireita( raiz.getDir() );
            
            System.out.println( raiz.getDado().getNome() +  "");
            
            inFixDireita( raiz.getEsq() );

            
	}
        
                
        public void central(){
            inFix( raiz );
	}
	public void inFix( NodoArv raiz){
		if( raiz == null )
		  return;

                        
		inFix( raiz.getEsq() );
		
		System.out.println( raiz.getDado().getNome() +  "");
                
		
		inFix( raiz.getDir() );
	}
        
        ArrayList<Jogadores> jogadoresList = new ArrayList<>();
        
        public ArrayList centralInsereJogadores(){
            inFixInsereJogadores( raiz );
            return jogadoresList;
	}
        
	public void inFixInsereJogadores( NodoArv raiz){
		if( raiz == null )
		  return ;

                        
		inFixInsereJogadores( raiz.getEsq() );
		
		Jogadores j = new Jogadores(raiz.getDado().getNome(),raiz.getDado().getPais(),raiz.getDado().jogadores);
                jogadoresList.add(j);
		
		inFixInsereJogadores( raiz.getDir() );
	}
        
        public void listaCidadesPais(String Pais){
                    inFixlistaCidadesPais( raiz,Pais );
                }
        
	public void inFixlistaCidadesPais( NodoArv raiz,String Pais ){
		if( raiz == null )
		  return ;         
		inFixlistaCidadesPais( raiz.getEsq(), Pais );
		
                if(raiz.getDado().getPais().equals(Pais)){
                    System.out.println(raiz.getDado().getNome());

                }

		inFixlistaCidadesPais( raiz.getDir(), Pais );
	}

        int jogadoresPorPais;
        
        public void jogadoresPorPais(String Pais){
            jogadoresPorPais = 0 ;
            
            inFixjogadoresPorPais( raiz,Pais );
            
            System.out.println("Quantidade total de players no pais: " + jogadoresPorPais);    
        }
        
	public void inFixjogadoresPorPais( NodoArv raiz,String Pais ){
		if( raiz == null )
		  return ;         
		inFixjogadoresPorPais( raiz.getEsq(), Pais );
		
                if(raiz.getDado().getPais().equals(Pais)){
                    System.out.println("Cidade: " + raiz.getDado().getNome() + " | " + "Quantidade de Jogadores:" + raiz.getDado().getJogadores());
                    jogadoresPorPais = jogadoresPorPais + raiz.getDado().getJogadores();
                }

		inFixjogadoresPorPais( raiz.getDir(), Pais );
	}         
	
	public void posFixado(){
		posFix( raiz );
	}
	
	public void posFix( NodoArv raiz){
		if( raiz == null )
		  return;

		posFix( raiz.getEsq() );
		posFix( raiz.getDir() );
		
		System.out.println( raiz.getDado().getNome() + "\n");		
	}
	
	public Cidades pesquisa(String Nome){
		Cidades cidade = pesq_arv( raiz, Nome );
		return cidade;
	}
	
	public Cidades pesq_arv( NodoArv raiz, String  Nome){		
	//Realiza a pesquisa por um m�todo n�o recursivo.
                Cidades cidade = null;
		boolean achou = false;
		NodoArv aux = raiz;
		
		while((achou == false)&& (aux!= null)){
			
                    if(aux.getDado().getNome() == Nome ){
                            achou = true;
                            cidade = aux.getDado();
                    }
                    else{
                        if(aux.getDado().getNome().compareTo(Nome) < 0 ){
                            aux = aux.getDir();
                        }else{
                            aux = aux.getEsq();
                        }

                    }
		}
		return cidade;
	}
	
	public NodoArv pesquisa_rec(String Nome ){
	//Retorna V ou F, caso o valor exista ou n�o
                //NodoArv res = null;
                Cidades cidades = null;
                
                NodoArv res  = pesq_arv_rec( raiz, Nome );
		
                //cidades = res.getDado();
                
                return res;
	}
	
	public NodoArv pesq_arv_rec(NodoArv raiz,String Nome){
				
		NodoArv res=null;
				
		if(raiz!=null){
			if(compareStrings(raiz.getDado().getNome(),Nome) == 0){
				res=raiz;
			}
			else{
                            if(compareStrings(Nome,raiz.getDado().getNome()) == 2){
                                res = pesq_arv_rec(raiz.getEsq(),Nome);
                            } 
                            else{
                                res = pesq_arv_rec(raiz.getDir(),Nome);

                            }
			}
		}
		return res;
	}

    public void remove(Cidades c){
    	NodoArv atual;
    	
    	// Verifica se o nodo existe  	
    	atual = this.pesquisa_rec( c.getNome() );
    	
    	if(atual == null){
    		System.out.println("O Elemento "+c.getNome()+" Nao Esta Presente na Arvore");
		}
			
		// Chamada de M�todos
		if((atual.getEsq()==null) && (atual.getDir()==null))
    		removeFolha(atual);
    	else{
			if((atual.getEsq()!=null) && (atual.getDir()!=null))
    			removeDoisFilhos( atual );
    		else
    			removeUmFilho( atual );
    	}		
    }    	
    
	public void removeFolha( NodoArv atual){
	// Remove uma folha da �rvore - Nodo folha n�o possui filhos
	
		NodoArv pai = atual.getPai();
		if(pai==null){ //o nodo a ser exclu�do � a ra�z da �rvore
			raiz = null;
		}
		else{
			if(pai.getEsq()==atual){
				pai.setEsq(null);
			}
			else{
				pai.setDir(null);
			}
		}
	}
	
	public void removeUmFilho( NodoArv atual ){
	//Remove um nodo que possui um filho
	
		NodoArv pai = atual.getPai();
		
		if(pai==null){//o nodo a ser exclu�do � a ra�z da �rvore
			if(atual.getEsq()!=null){
				raiz = atual.getEsq();
			}
			else{
				raiz = atual.getDir();
			}
		}
		else{
			if(atual.getEsq()==null){
				if(pai.getDir()==atual){
					pai.setDir(atual.getDir());
				}
				else{ //pai.getEsq()==atual
					pai.setEsq(atual.getDir());
				}
			}
			else{ //atual.getDir()==null
		
				if(pai.getDir()==atual){
					pai.setDir(atual.getEsq());
				}
				else{ //pai.getEsq()==atual
					pai.setEsq(atual.getEsq());
				}
			
			}	
		}
	} // fim m�todo remove com 1 filho


	public void removeDoisFilhos( NodoArv atual ){
	//Remove um nodo que possui dois filhos
	
	
		//Busca o elemento mais da direita (desce a esq. e depois a direita)
		
		NodoArv aux=atual.getEsq();
		
		NodoArv auxPai=null;
		
		while(aux.getDir()!=null){
			aux = aux.getDir();
		}
		//Nodo Folha
		if((aux.getEsq()==null) && (aux.getDir()==null)){
			atual.setDado(aux.getDado());
			
			auxPai = aux.getPai();
			if(auxPai == atual){ //um nivel abaixo do dado a ser exclu�do
				atual.setEsq(null); //anula a �rv. esquerda
			}
			else{
				auxPai.setDir(null);
			}
		}
		
		//Nodo com um filho a esquerda
		if((aux.getEsq()!=null) && (aux.getDir()==null)){
			atual.setDado(aux.getDado());
										
			auxPai = aux.getPai();
			if(auxPai == atual){ //um n�vel abaixo do dado a ser exclu�do
				atual.setEsq(aux.getEsq());
			}
			else{
				auxPai.setDir(aux.getEsq());
			}

		}				
	}// fim do m�todo
        
        
        public int  primeiraLetraTOASCI(String nome){
        int i;
        char c;
        
        c = nome.charAt(0);
        
        i = c;
        
        return i; 
    }
    
        public static int compareStrings(String s1, String s2) {

        int comparedResult = s1.compareTo(s2);
        
        int i;

        if (comparedResult > 0) {
            //Vem ANTES
            //System.out.println(s1 + " comes after " + s2);
            i = 1;
        } else if (comparedResult < 0) {
            //VEM DEPOIS
            //System.out.println(s1 + " comes before " + s2);
            i = 2;
        } else {
            //É IGUAL
            //System.out.println(s1 + " is equal to " + s2);
            i = 0;
        }
        
        return i;
        }
        
}
