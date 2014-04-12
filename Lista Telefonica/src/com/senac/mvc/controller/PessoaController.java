package com.senac.mvc.controller;
import java.io.IOException;
import java.util.Scanner;

import com.senac.estruturas.ListaEncadeada;
import com.senac.estruturas.ListaOrdenada;
import com.senac.estruturas.Nodo;
import com.senac.estruturas.ReadWriteFile;
import com.senac.mvc.model.Pessoa;
import com.senac.mvc.view.ContatoView;

public class PessoaController {

	private Pessoa contato;
	
	public void criarContato() throws IOException
	{
		Nodo<Integer> nodo = new Nodo<Integer>();
		ListaOrdenada<Integer> list = new ListaOrdenada<Integer>();
		ReadWriteFile file = new ReadWriteFile(); 	
		String path = "D:\\Fabio\\eclipse\\Programas\\Lista Telefonica\\Contatos.txt";	
		file.reader(path);
		
		String nome;
		String telefone;
		Scanner ler = new Scanner(System.in);
		int cont = 1;
		while(true)
		{
		System.out.printf("Informe novo Contato:");
		nome = ler.nextLine();
		System.out.printf("Informe novo Telefone:");
		telefone = ler.nextLine();
		
		contato = new Pessoa();
		contato.setNome(nome);
		contato.setTelefone(telefone);
		file.recorder(path, contato.getNome(),contato.getTelefone(),cont);
		ListaOrdenada<Integer> lista = new ListaOrdenada<Integer>();
		Nodo<Integer> novo = new Nodo<Integer>(cont);
		//lista.insert(novo);
		//lista.insert(new Nodo<Integer>(0), novo);
		//novo.setChave(1);
		lista.insert(new Nodo<Integer>(cont));
		lista.print();cont++;
		}
		
	}
	
	public void exibirContato( ContatoView view )
	{
		view.printContato(contato.getNome(), contato.getTelefone());
	}
	
}
