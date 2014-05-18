package com.senac.estruturas;

public class PesquisaBinaria <T extends Comparable<T>>
extends ListaEncadeada<T> 
{
	
	public int buscaBinaria(Nodo<T> tabela,int valor)
	{
		 boolean achou = false;
		 T chave = tabela.getData();

		 int alto = chave.compareTo(chave) - 1;
		 int baixo = 0;
		 int meio = alto / 2;
		 
		    while (!achou && alto >= baixo) {
		        if (valor == meio) {
		            achou = true;
		        } else if (valor < meio) {
		            alto = meio -1;
		        } else {
		            baixo = meio + 1;
		        }
		        meio = (alto + baixo) / 2;
		    }
		    return ( (achou) ? meio : -1);
		
	}


}
