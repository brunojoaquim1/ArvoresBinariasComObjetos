package com.mycompany.arvoresjava;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
import com.mycompany.arvoresjava.ArvorePaises;

public class TestaArvore{
    
        public static void menuLista(){                  		
                    System.out.println("[1]  INSERE CIDADE");
                    System.out.println("[2]  REMOVE CIDADE");
                    System.out.println("[3]  CONSULTA CIDADE");
                    System.out.println("[4]  ESCREVE CIDADES A/Z");
                    System.out.println("[5]  ESCREVE CIDADES Z/A");
                    System.out.println("[6]  ESCREVE PAISES A/Z");
                    System.out.println("[7]  ESCREVE PAISES Z/A");
                    System.out.println("[8]  ESCREVE JOGADORES ORDEM CRESCENTE");
                    System.out.println("[9]  ESCREVE JOGADORES ORDEM DECRESCENTE");
                    System.out.println("[10] CONSULTA CIDADES POR PAIS");
                    System.out.println("[11] CONSULTA JOGADORES POR PAIS");
                    System.out.println("[12] SAIR");
        }
        
        public static Cidades cadastraCidade(){
            
            String nome, pais,latitude, longitude;
            int jogadores;
            
            Scanner lerNome = new Scanner(System.in);
            Scanner lerPais = new Scanner(System.in);
            Scanner lerLatitude = new Scanner(System.in);
            Scanner lerLongitude = new Scanner(System.in);
            Scanner lerjogadores = new Scanner(System.in);
            
            System.out.println("Digite o nome da cidade:");
            nome = lerNome.nextLine();
            System.out.println("Digite o nome do pais:");
            pais = lerPais.nextLine();
            System.out.println("Digite o nome a Latitude:");
            latitude = lerLatitude.nextLine();           
            System.out.println("Digite a longitude:");
            longitude = lerLongitude.nextLine();
            System.out.println("Digite o numero de jogadores:");
            jogadores = lerjogadores.nextInt();
            
            Cidades cidade = new Cidades(nome,pais,latitude,longitude,jogadores);
            
            return cidade;
            
        }
        
        public static void removeCidade(Arvore arv){
            NodoArv cidadeRemove = null;
            String nomeRemoveCidade;


            System.out.println("Digite o nome da cidade que deseja remover:");
            Scanner lerRemoveCidade = new Scanner(System.in);
            nomeRemoveCidade = lerRemoveCidade.nextLine();
            
            cidadeRemove = arv.pesquisa_rec(nomeRemoveCidade);
            
            if (cidadeRemove == null){
                System.out.println("Cidade não cadastrada");
            }else{
                arv.remove(cidadeRemove.getDado());
            }
  
        };
            
        public static void consultaCidade(Arvore arv){
            NodoArv cidadeConsulta = null;
                    
                    String nomeCidadeConsulta;
                    
                    Scanner lerConsultaCidade = new Scanner(System.in);
                    nomeCidadeConsulta = lerConsultaCidade.nextLine();
                    
                    cidadeConsulta = arv.pesquisa_rec(nomeCidadeConsulta);
                    
                    if (cidadeConsulta == null){
                        System.out.println("[ERRO!] Cidade não encontrada!! ");
                        System.out.println("************************************");

                    } else {
                        System.out.println("Pais: " +  cidadeConsulta.getDado().getPais());
                        System.out.println("Latitude: " + cidadeConsulta.getDado().getLatitude());
                        System.out.println("Longitude: " + cidadeConsulta.getDado().getLongitude());
                        System.out.println("Número Jogadores: " + cidadeConsulta.getDado().getJogadores());
                        System.out.println("************************************");
                    }
        };
        
        public static void paisesAZ(Arvore arv){

            String data =  arv.devolvePaises();
            
            String[] split = data.split(";");
           
            ArrayList<String> paisesFinal = new ArrayList<>();
            
            ArvorePaises arvPais = new ArvorePaises();
            
            for(int i = 0 ; i < split.length; i++ ){
                //arvPais.insNodo(split[i]); 
                if(paisesFinal.contains(split[i])){
                   //paisesFinal.add(split[i]);
                }else{
                    paisesFinal.add(split[i]);
                }
            }
            
            for (Iterator<String> iterator = paisesFinal.iterator(); iterator.hasNext(); ) {
               String paises = iterator.next();
               arvPais.insNodo(paises);
            }             
            
            arvPais.central();
  

        } 
        
        public static void paisesZA(Arvore arv){

            String data =  arv.devolvePaises();
            
            String[] split = data.split(";");
           
            ArrayList<String> paisesFinal = new ArrayList<>();
            
            ArvorePaises arvPais = new ArvorePaises();
            
            for(int i = 0 ; i < split.length; i++ ){
                //arvPais.insNodo(split[i]); 
                if(paisesFinal.contains(split[i])){
                   //paisesFinal.add(split[i]);
                }else{
                    paisesFinal.add(split[i]);
                }
            }
            
            for (Iterator<String> iterator = paisesFinal.iterator(); iterator.hasNext(); ) {
               String paises = iterator.next();
               arvPais.insNodo(paises);
            }             
            
            arvPais.centralDireita();
  

        }
        
        public static void jogadoresCrescente(Arvore arv){
            
            ArrayList<Jogadores> jogadoresList = new ArrayList<>();
            
            ArvoreJogadores arvJogadores = new ArvoreJogadores();


            
           jogadoresList =  arv.centralInsereJogadores();
           
            for (Iterator<Jogadores> iterator = jogadoresList.iterator(); iterator.hasNext(); ) {
               Jogadores jogadores = iterator.next();
               //System.out.println("Quantidade: " + jogadores.quantidade);
               //System.out.println("Cidade: " + jogadores.Cidade);
               arvJogadores.insNodo(jogadores);
            } 
            arvJogadores.central();

           
        }
        
        public static void jogadoresDecrescente(Arvore arv){
            
            ArrayList<Jogadores> jogadoresList = new ArrayList<>();
            
            ArvoreJogadores arvJogadores = new ArvoreJogadores();


            
           jogadoresList =  arv.centralInsereJogadores();
           
            for (Iterator<Jogadores> iterator = jogadoresList.iterator(); iterator.hasNext(); ) {
               Jogadores jogadores = iterator.next();
               //System.out.println("Quantidade: " + jogadores.quantidade);
               //System.out.println("Cidade: " + jogadores.Cidade);
               arvJogadores.insNodo(jogadores);
            } 
            arvJogadores.centralDireita();

           
        }        
        
        
            
        

        
        
	public static void main(String args[]){
            
            Scanner ler = new Scanner(System.in);
            Scanner lerFind1 = new Scanner(System.in);
            Scanner lerFind2 = new Scanner(System.in);


            
            int menuOption = 10;
            
		
            Arvore arv = new Arvore();
            
	    
            Cidades c1 = new Cidades("Caxias do Sul","Brasil","-29.1678","-51.1794",20);
            Cidades c2 = new Cidades("Bage","Brasil","-31.3285","-54.1073",45);
            Cidades c3 = new Cidades("Recife","Brasil","-27.5969","-34.8813",45);
            Cidades c4 = new Cidades("Florianopolis","Brasil","-8.05428","-34.8813",12);
            Cidades c5 = new Cidades("Sao Paulo","Brasil","-23.5489","-46.6388",200);
            Cidades c6 = new Cidades("Antonio Prado", "Brasil" , "-28.168","-51.789",20);
            Cidades c7 = new Cidades("Zurique","Suiça","30.450","78.258",8);
            Cidades c8 = new Cidades("Lisboa","Portugal","40.620","-35.220",9);
            Cidades c9 = new Cidades("Miami","EUA","30.450","36,230",9);
            Cidades c10 = new Cidades("Toronto","Canada","30.450","36,230",9);
            Cidades c11 = new Cidades("Jaquirana","Zelandia","30.450","36,230",9);
            Cidades c12 = new Cidades("Berlim","Alemanha","30.450","36,230",9);
            
	    arv.insNodo(c1);
	    arv.insNodo(c2);
	    arv.insNodo(c3);
            arv.insNodo(c4);
            arv.insNodo(c5);
            arv.insNodo(c6);
            arv.insNodo(c7);
            arv.insNodo(c8);
            arv.insNodo(c9);
            arv.insNodo(c10);
            arv.insNodo(c11);
            arv.insNodo(c12);

            
            System.out.printf("Informe uma opcao para o menu:\n");
            menuLista();
            menuOption = ler.nextInt();
            
            do{
                switch(menuOption){
                    case 1 :                    		
                    System.out.println("************************************");
                    System.out.println("INSERE CIDADE");
                    System.out.println("************************************");
                    Cidades cidade = null ;
                    cidade = cadastraCidade();
                    
                    arv.insNodo(cidade);
                    
                break;
                
                case 2:
                    System.out.println("************************************");
                    System.out.println("REMOVE CIDADE");
                    System.out.println("************************************");
                    removeCidade(arv);
		
                break;
                case 3:
                    System.out.println("************************************");
                    System.out.println("CONSULTA CIDADE");
                    System.out.println("************************************");
                    consultaCidade(arv);

                break;
                case 4:
                    System.out.println("************************************");
                    System.out.println("ESCREVE CIDADES A/Z");
                    System.out.println("************************************");
                    arv.central();
                    System.out.println("************************************");
  
                break;
                case 5:
                    System.out.println("************************************");
                    System.out.println("ESCREVE CIDADES Z/A");
                    System.out.println("************************************");
                    arv.centralDireita();

                break;
                case 6:
                    System.out.println("************************************");
                    System.out.println("ESCREVE PAISES A/Z");
                    System.out.println("************************************");
                    paisesAZ(arv);
                    break;
                case 7:
                    System.out.println("************************************");
                    System.out.println("ESCREVE PAISES Z/A");
                    System.out.println("************************************");
                    paisesZA(arv);
                break;
                case 8:
                    System.out.println("************************************");
                    System.out.println("ESCREVE JOGADORES ORDEM CRESCENTE");
                    System.out.println("************************************");
                    jogadoresCrescente(arv);
                    
                break;
                case 9:
                    System.out.println("************************************");
                    System.out.println("ESCREVE JOGADORES ORDEM DECRESCENTE");
                    System.out.println("************************************");
                    jogadoresDecrescente(arv);
                break;
                case 10:
                    String find1 ;
                    
                    System.out.println("************************************");
                    System.out.println("CONSULTA CIDADES POR PAIS");
                    System.out.println("************************************");
                    System.out.println("Digite o Pais");
                    find1 = lerFind1.nextLine();
                    
                    arv.listaCidadesPais(find1);
                    
                break;
                case 11:
                    String find2 ;

                    
                    System.out.println("************************************");
                    System.out.println("CONSULTA JOGADORES POR PAIS");
                    System.out.println("************************************");
                    System.out.println("Digite o Pais");
                    find2 =  lerFind2.nextLine();
                    arv.jogadoresPorPais(find2);
                    
                break;
                case 12:
                    System.out.println("************************************");
                    System.out.println("SAIR");
                    System.out.println("************************************");
                break;
                    
                default:
                }
                    menuLista();
                    menuOption = ler.nextInt();
                }while (menuOption != 12 );

		/*
		System.out.println("\n Pos-Fixado:\n");
		arv.posFixado( );			
		System.out.println("\n");	
		System.out.println(arv.pesquisa(c1));
		System.out.println("\n Remoção:\n");
		arv.remove( 100 );		
		arv.central();	
*/
	
    }
}