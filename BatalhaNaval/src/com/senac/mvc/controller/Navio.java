package com.senac.mvc.controller;

import java.util.Random;

public class Navio {

	public static void portaAvioes(int[][] portaAvioes) {

		Random sorteio = new Random();

		for (int navio = 0; navio < 5; navio++) {
			portaAvioes[navio][0] = sorteio.nextInt(10);
			portaAvioes[navio][1] = sorteio.nextInt(10);
			portaAvioes[navio][2] = sorteio.nextInt(10);
			portaAvioes[navio][3] = sorteio.nextInt(10);
			portaAvioes[navio][4] = sorteio.nextInt(10);

			// agora vamos checar se esse par não foi sorteado
			// se foi, so sai do do...while enquanto sortear um diferente
			for (int anterior = 0; anterior < navio; anterior++) {
				if ((portaAvioes[navio][0] == portaAvioes[anterior][0])
						&& (portaAvioes[navio][1] == portaAvioes[anterior][1] && portaAvioes[navio][2] == portaAvioes[anterior][2])
						&& (portaAvioes[navio][3] == portaAvioes[anterior][3] && portaAvioes[navio][4] == portaAvioes[anterior][4]))
					do {
						portaAvioes[navio][0] = sorteio.nextInt(10);
						portaAvioes[navio][1] = sorteio.nextInt(10);
						portaAvioes[navio][2] = sorteio.nextInt(10);
						portaAvioes[navio][3] = sorteio.nextInt(10);
						portaAvioes[navio][4] = sorteio.nextInt(10);
					} while ((portaAvioes[navio][0] == portaAvioes[anterior][0])
							&& (portaAvioes[navio][1] == portaAvioes[anterior][1] && portaAvioes[navio][2] == portaAvioes[anterior][2])
							&& (portaAvioes[navio][3] == portaAvioes[anterior][3] && portaAvioes[navio][4] == portaAvioes[anterior][4]));
			}

		}
	}

}
