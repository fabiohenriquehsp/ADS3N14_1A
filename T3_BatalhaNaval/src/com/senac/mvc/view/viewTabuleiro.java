package com.senac.mvc.view;

import com.senac.mvc.controller.Tabuleiro;

public class viewTabuleiro {

	 public static void main(String[] args) {
		 
		    Tabuleiro t = new Tabuleiro();
	        int[][] tabuleiro = new int[10][10];
	        int[][] navios = new int[5][2];
	        int[] tiro = new int[2];
	        int tentativas=0,
	            acertos=0;
	        
	        t.inicializaTabuleiro(tabuleiro);
	        t.iniciaNavios(navios);
	        
	        System.out.println();
	        
	        do{
	            t.mostraTabuleiro(tabuleiro);
	            t.darTiro(tiro);
	            tentativas++;
	            
	            if(t.acertou(tiro,navios)){
	            	t.instrucao(tiro,navios,tentativas);
	                acertos++;
	            }                
	            else
	            	t.instrucao(tiro,navios,tentativas);
	            
	            t.alteraTabuleiro(tiro,navios,tabuleiro);
	            

	        }while(acertos!=5);
	        
	        System.out.println("\n\n\nJogo terminado. Você acertou os 3 navios em "+tentativas+" tentativas");
	        t.mostraTabuleiro(tabuleiro);
	    }

}
