package com.senac.mvc.controller;

public class Tabuleiro {

	public static void inicializaTabuleiro(int[][] tabuleiro) {
		for (int linha = 0; linha < 10; linha++)
			for (int coluna = 0; coluna < 10; coluna++)
				tabuleiro[linha][coluna] = -1;
	}

}
