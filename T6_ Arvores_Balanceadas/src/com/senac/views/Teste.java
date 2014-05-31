package com.senac.views;
import com.senac.apps.model.Avl;

public class Teste {

	public static void main(String[] args) {

		Avl arvore = new Avl();
		String parametro = null;
		String teste = " ";

		// Testes
		for (int i = 0; i < 50; i++) {
			arvore.inserirElemento(i);
			System.out.println(
					 arvore.balanco());
		}
		

	}
}
