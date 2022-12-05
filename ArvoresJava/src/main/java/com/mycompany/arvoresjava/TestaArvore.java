package com.mycompany.arvoresjava;
import java.util.Scanner;

public class TestaArvore{

	public static void main(String args[]){
            
            Scanner ler = new Scanner(System.in);
            
            int menuOption = 10;
            
		
            Arvore arv = new Arvore();
            
	    System.out.println( "Inserindo Valores: " );
            Cidades c1 = new Cidades("Caxias do Sul","Brasil","-29.1678","-51.1794",20);
            Cidades c2 = new Cidades("Bage","Brasil","-31.3285","-54.1073",45);
            Cidades c3 = new Cidades("Recife","Brasil","-27.5969","-34.8813",45);
            Cidades c4 = new Cidades("Florianopolis","Brasil","-8.05428","-34.8813",12);
            Cidades c5 = new Cidades("Sao Paulo","Brasil","-23.5489","-46.6388",200);
            
	    arv.insNodo(c1);
	    arv.insNodo(c2);
	    arv.insNodo(c3);
            arv.insNodo(c4);
            arv.insNodo(c5);
            
            System.out.printf("Informe uma opcao para o menu:\n");
            menuOption = ler.nextInt();
            
            do{
                switch(menuOption){
                case 1 :                    		
		System.out.println("\n Pre-Fixado:\n");
		arv.preFixado( );
                break;
                
                case 2:
                System.out.println("\n Central:\n");
		arv.central( );
                break;
                case 3:
                    break; 
                    
                default:
                }
                    System.out.println("\n Opcao Incorreta:\n");
                }while (menuOption != 3 );
            
            
            

            

		/*
		System.out.println("\n Pos-Fixado:\n");
		arv.posFixado( );			
		System.out.println("\n");	
		System.out.println(arv.pesquisa(c1));
		System.out.println("\n Remoção:\n");
		arv.remove( 100 );		
		arv.central();	
*/
	
}}