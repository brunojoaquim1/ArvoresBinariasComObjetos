package com.mycompany.arvoresjava;
public class Arvore{
	
	private NodoArv raiz;
	
	public Arvore(){
		raiz = null;
	}
	
	public void insNodo( Cidades cidade ){
		if( raiz == null )
		  raiz = new NodoArv( cidade );
		else
		  insere( raiz, cidade );
	}
	
	public void insere( NodoArv atual, Cidades cidade){
	  	//if( d < atual.getDado() ){
                if( cidade.getNome().compareTo(atual.getDado().getNome()) > 0 ){
	  		if( atual.getEsq() == null ){
	  			NodoArv aux = new NodoArv(cidade);
	  			atual.setEsq(aux);
	  			atual.getEsq().setPai(atual);
	  			
	  		}
	  		else
	  		  insere( atual.getEsq(), cidade );
	  	}
	  	else{	  
	  		if( atual.getDir() == null){
	  			NodoArv aux = new NodoArv(cidade);
	  			atual.setDir(aux);
	  			atual.getDir().setPai(atual);
	  		}
	  		else
	  		  insere( atual.getDir(), cidade );
	     }
	  }	  
	
	
	public void preFixado(){
		preFix( raiz );
	}
	
	public void preFix( NodoArv raiz){
		if( raiz == null )
		  return;
		
		System.out.print( raiz.getDado().getNome() + " ");
		
		preFix( raiz.getEsq() );
		preFix( raiz.getDir() );
	}
	
	public void central(){
		inFix( raiz );
	}
	
	public void inFix( NodoArv raiz){
		if( raiz == null )
		  return;
		
		inFix( raiz.getEsq() );
		
		System.out.print( raiz.getDado().getNome() + " ");
		
		inFix( raiz.getDir() );
	}
	
	public void posFixado(){
		posFix( raiz );
	}
	
	public void posFix( NodoArv raiz){
		if( raiz == null )
		  return;

		posFix( raiz.getEsq() );
		posFix( raiz.getDir() );
		
		System.out.print( raiz.getDado().getNome() + " ");		
	}
	
	public boolean pesquisa(Cidades cidade){
	//Retorna V ou F, caso o valor exista ou não
		boolean res = pesq_arv( raiz, cidade );
		return res;
	}
	
	public boolean pesq_arv( NodoArv raiz, Cidades cidade ){		
	//Realiza a pesquisa por um método não recursivo.
		boolean achou = false;
		NodoArv aux = raiz;
		
		while((achou == false) && (aux!= null)){
			
			if(aux.getDado()==cidade){
				achou = true;
			}
			else{
				if(cidade.getNome().compareTo(aux.getDado().getNome())<= 0)
					aux = aux.getEsq();
				else
					aux = aux.getDir();
			}
		}
		return achou;
	}
	
	public NodoArv pesquisa_rec(Cidades cidade){
	//Retorna V ou F, caso o valor exista ou não
		NodoArv res = pesq_arv_rec( raiz, cidade );
		return res;
	}
	
	public NodoArv pesq_arv_rec(NodoArv raiz,Cidades cidade){
				
		NodoArv res=null;
				
		if(raiz!=null){
			if(raiz.getDado()==cidade){
				res=raiz;
			}
			else{
				if(cidade.getNome().compareTo( raiz.getDado().getNome()) < 0 )
					res = pesq_arv_rec(raiz.getEsq(),cidade);
				else
					res = pesq_arv_rec(raiz.getDir(),cidade);
			}
		}
		return res;
	}

    public void remove(Cidades cidade){
    	NodoArv atual;
    	
    	// Verifica se o nodo existe  	
    	atual = this.pesquisa_rec( cidade );
    	
    	if(atual == null){
    		System.out.println("O Elemento "+cidade.getNome()+" Nao Esta Presente na Arvore");
		}
			
		// Chamada de Métodos
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
	// Remove uma folha da árvore - Nodo folha não possui filhos
	
		NodoArv pai = atual.getPai();
		if(pai==null){ //o nodo a ser excluído é a raíz da árvore
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
		
		if(pai==null){//o nodo a ser excluído é a raíz da árvore
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
	} // fim método remove com 1 filho


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
			if(auxPai == atual){ //um nivel abaixo do dado a ser excluído
				atual.setEsq(null); //anula a árv. esquerda
			}
			else{
				auxPai.setDir(null);
			}
		}
		
		//Nodo com um filho a esquerda
		if((aux.getEsq()!=null) && (aux.getDir()==null)){
			atual.setDado(aux.getDado());
										
			auxPai = aux.getPai();
			if(auxPai == atual){ //um nível abaixo do dado a ser excluído
				atual.setEsq(aux.getEsq());
			}
			else{
				auxPai.setDir(aux.getEsq());
			}

		}				
	}// fim do método
}
