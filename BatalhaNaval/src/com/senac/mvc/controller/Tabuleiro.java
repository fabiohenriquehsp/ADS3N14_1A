package com.senac.mvc.controller;

import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {

	 public void inicializaTabuleiro(int[][] tabuleiro){
	        for(int linha=0 ; linha < 10 ; linha++ )
	            for(int coluna=0 ; coluna < 10 ; coluna++ )
	                tabuleiro[linha][coluna]=-1;
	    }
	    
	    public void mostraTabuleiro(int[][] tabuleiro){
	        System.out.println("\t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8 \t9 \t10");
	        System.out.println();
	        
	        for(int linha=0 ; linha < 10 ; linha++ ){
	            System.out.print((linha+1)+"");
	            for(int coluna=0 ; coluna < 10 ; coluna++ ){
	                if(tabuleiro[linha][coluna]==-1){
	                    System.out.print("\t"+".");
	                }else if(tabuleiro[linha][coluna]==0){
	                    System.out.print("\t"+"-");
	                }else if(tabuleiro[linha][coluna]==1){
	                    System.out.print("\t"+"O");
	                }
	                
	            }
	            System.out.println();
	        }

	    }

	    public void iniciaNavios(int[][] navios){
	        Random sorteio = new Random();
	        
	        for(int navio=0 ; navio < 3 ; navio++){
	            navios[navio][0]=sorteio.nextInt(5);
	            navios[navio][1]=sorteio.nextInt(5);
	            
	            for(int anterior=0 ; anterior < navio ; anterior++){
	                if( (navios[navio][0] == navios[anterior][0])&&(navios[navio][1] == navios[anterior][1]) )
	                    do{
	                        navios[navio][0]=sorteio.nextInt(5);
	                        navios[navio][1]=sorteio.nextInt(5);
	                    }while( (navios[navio][0] == navios[anterior][0])&&(navios[navio][1] == navios[anterior][1]) );
	            }
	            
	        }
	    }

	    public void darTiro(int[] tiro){
	        Scanner entrada = new Scanner(System.in);
	        
	        System.out.print("Linha: ");
	        tiro[0] = entrada.nextInt();
	        tiro[0]--;
	        
	        System.out.print("Coluna: ");
	        tiro[1] = entrada.nextInt();
	        tiro[1]--;
	        
	    }
	    
	    public boolean acertou(int[] tiro, int[][] navios){
	        
	        for(int navio=0 ; navio<navios.length ; navio++){
	            if( tiro[0]==navios[navio][0] && tiro[1]==navios[navio][1]){
	                System.out.printf("Você acertou o tiro (%d,%d)\n",tiro[0]+1,tiro[1]+1);
	                return true;
	            }
	        }
	        return false;
	    }

	    public void instrucao(int[] tiro, int[][] navios, int tentativa){
	        int linha=0,
	            coluna=0;
	        
	        for(int fila=0 ; fila < navios.length ; fila++){
	            if(navios[fila][0]==tiro[0])
	                linha++;
	            if(navios[fila][1]==tiro[1])
	                coluna++;
	        }
	        
	        System.out.printf("\nDica %d: \nlinha %d -> %d navios\n" +
	                                 "coluna %d -> %d navios\n",tentativa,tiro[0]+1,linha,tiro[1]+1,coluna);
	    }

	    public void alteraTabuleiro(int[] tiro, int[][] navios, int[][] tabuleiro){
	        if(acertou(tiro,navios))
	            tabuleiro[tiro[0]][tiro[1]]=1;
	        else
	            tabuleiro[tiro[0]][tiro[1]]=0;
	    }

}
