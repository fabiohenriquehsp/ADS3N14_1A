package com.senac.apps.ListaTelefonica.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.senac.apps.ListaTelefonica.model.Pessoa;
import com.senac.apps.ListaTelefonica.view.ListaTelefonicaConsoleView;
import com.senac.estruturas.ArvoreBinaria;
import com.senac.estruturas.Nodo;


public class ListaController {
	private ArvoreBinaria<Pessoa> arquivo;
	private ArvoreBinaria<Pessoa> contatos;
	private ListaTelefonicaConsoleView view;
	private Nodo<Pessoa> current;

	public ListaController(ListaTelefonicaConsoleView view) {
		this.view = view;
		this.contatos = new ArvoreBinaria<Pessoa>();
		this.arquivo  = new ArvoreBinaria<Pessoa>();
		this.current = null;
	}

	public void loadFile(String fileName) {
		try {
			
			String line = "";
			Scanner arq = new Scanner(new FileReader(fileName));
			while (arq.hasNext()) {
				String name = arq.nextLine();
				String phone = arq.nextLine();
				// Linha invocar a classe pessoa
				// pessoa set(Phone)
			}

		} catch (FileNotFoundException e) {
			// TODO: handle exception
			view.logError(e.getMessage());
		}
	}

	public void showContato() {
		if (current == null) {
			view.showMessage("Nenhum contato existente.");
		} else {
			Pessoa contato = current.getValor();
			view.printContato(contato.getNome(), contato.getTelefone());
		}
	}
	
	public void nextContato() {
		if (current != null) {
			current = current.getDireita();
			if (current == null)
				current = current.getDireita();
		}
	}
	
	public void previousContato() {
		if (current != null) {
			current = current.getDireita();
			if (current == null)
				current = current.getEsquerda();
		}
	}
		
	public void imprimeArq(String fileName) {
		try {
			
			String line = "";
			Scanner arq = new Scanner(new FileReader(fileName));
			while (arq.hasNext()) {
				String name = arq.nextLine();
				String phone = arq.nextLine();
				System.out.println(name);
				System.out.println(phone);
			}

		} catch (FileNotFoundException e) {
			// TODO: handle exception
			view.logError(e.getMessage());
		}
	}

}
