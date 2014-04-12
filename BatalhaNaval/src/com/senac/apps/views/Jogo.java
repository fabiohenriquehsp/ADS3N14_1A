package com.senac.apps.views;

import com.senac.estruturas.Jogador;
import com.senac.mvc.controller.Navio;
import com.senac.mvc.controller.Tabuleiro;
import com.senac.mvc.view.viewTabuleiro;

public class Jogo {

	static int[][] tabuleiro = new int[10][10];
	static int[][] portaAvioes = new int[5][5];
	static int[] tiro = new int[2];
	static int tentativas = 0;
	static int acertos = 0;

	public static void main(String[] args) {

		Tabuleiro Tabuleiro = new Tabuleiro();
		viewTabuleiro ViewTabuleiro = new viewTabuleiro();
		Jogador jogador = new Jogador();
		Navio navio = new Navio();

		Tabuleiro.inicializaTabuleiro(tabuleiro);
		ViewTabuleiro.mostraTabuleiro(tabuleiro);
		navio.portaAvioes(portaAvioes);

		System.out.println();

		do {
			viewTabuleiro.mostraTabuleiro(tabuleiro);
			jogador.tiro(tiro);
			tentativas++;

			if (jogador.acertou(tiro, portaAvioes)) {
				viewTabuleiro.LocalizacaoJogo(tiro, portaAvioes, tentativas);
				acertos++;
			} else
				viewTabuleiro.LocalizacaoJogo(tiro, portaAvioes, tentativas);

			jogador.alteraTabuleiro(tiro, portaAvioes, tabuleiro);

		} while (acertos != 5);

		System.out.println("\n\n\nJogo terminado. Você acertou os 5 navios em "
				+ tentativas + " tentativas");
		viewTabuleiro.mostraTabuleiro(tabuleiro);

	}

}
