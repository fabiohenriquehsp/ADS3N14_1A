package com.senac.mvc.view;

public class viewTabuleiro {

	public static void mostraTabuleiro(int[][] tabuleiro) {
		System.out.println("\t0 \t1 \t2 \t3 \t4\t5 \t6 \t7 \t8 \t9");
		System.out.println();
		String campos[] = new String[10];
		campos[0] = "A";
		campos[1] = "B";
		campos[2] = "C";
		campos[3] = "D";
		campos[4] = "E";
		campos[5] = "F";
		campos[6] = "G";
		campos[7] = "H";
		campos[8] = "I";
		campos[9] = "J";

		for (int linha = 0; linha < 10; linha++) {
			System.out.print((campos[linha]) + "");
			for (int coluna = 0; coluna < 10; coluna++) {
				if (tabuleiro[linha][coluna] == -1) {
					System.out.print("\t" + ".");
				} else if (tabuleiro[linha][coluna] == 0) {
					System.out.print("\t" + "-");
				} else if (tabuleiro[linha][coluna] == 1) {
					System.out.print("\t" + "0");
				}

			}
			System.out.println();
		}
	}

	public static void LocalizacaoJogo(int[] tiro, int[][] navios, int tentativa) {
		int linha = 0, coluna = 0;

		for (int fila = 0; fila < navios.length; fila++) {
			if (navios[fila][0] == tiro[0])
				linha++;
			if (navios[fila][1] == tiro[1])
				coluna++;
		}

		System.out.printf("\nLocalizaçao %d: \nlinha %d -> %d navios\n"
				+ "coluna %d -> %d navios\n", tentativa, tiro[0] + 1, linha,
				tiro[1] + 1, coluna);
	}

}
