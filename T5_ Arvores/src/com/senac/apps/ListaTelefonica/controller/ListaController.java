package com.senac.apps.ListaTelefonica.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
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

	public void loadFile(String filename) {
		try {
			Scanner arq = new Scanner(new FileReader(filename));
			while(arq.hasNext()) {
				String name = arq.nextLine();
				String phone = arq.nextLine();
				Pessoa pessoa = new Pessoa(name);
				pessoa.setTelefone(phone);
				arquivo.insert(new Nodo<Pessoa>(pessoa));
				if (!name.startsWith("#"))
					contatos.insert(new Nodo<Pessoa>(pessoa));
			}
			current = contatos.getHead();
		} catch (FileNotFoundException e) {
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
		
	
	public void insertContato(Pessoa p) {
		Nodo<Pessoa> nodo = new Nodo<Pessoa>(p);
		contatos.insert(nodo);
		System.out.println("Contatos " + current.getValor() + ".");

	}
	
	public void insertContato() {
		Pessoa contato = new Pessoa();
		contato.setNome(view.readString("Nome"));
		contato.setTelefone(view.readString("Telefone"));
		Nodo<Pessoa> novo = new Nodo<Pessoa>(contato);
		contatos.insert(novo);
		arquivo.insert(new Nodo<Pessoa>(contato));
		current = novo;
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

	
	public void saveFile(String filename) {
		FileWriter arq = null;
		try {
			arq = new FileWriter(filename,false);
			Nodo<Pessoa> iter = arquivo.getHead();
			while (iter != null) {
				Pessoa contato = iter.getValor();
				if (contatos.buscar(current, iter) == null) {
					if (!contato.getNome().startsWith("#"))
						arq.append("#"+contato.getNome()+"\n");
					else
						arq.append(contato.getNome()+"\n");						
				} else {
					arq.append(contato.getNome()+"\n");
				}
				arq.append(contato.getTelefone()+"\n");
				iter = iter.getprincipal();
			}
		} catch (IOException e) {
			view.showMessage(e.getMessage());
		} finally {
			if (arq != null)
				try {
					arq.close();
				} catch (IOException e) {
					view.showMessage(e.getMessage());
				}
		}
	}
	
	
	
}
