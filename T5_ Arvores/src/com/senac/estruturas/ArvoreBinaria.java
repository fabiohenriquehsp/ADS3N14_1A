package com.senac.estruturas;

public class ArvoreBinaria<T extends Comparable<T>>
			implements Comparable<ArvoreBinaria<T>>

{

	public void insert(Nodo<T> novo, T valor) {

		T val = novo.getValor();
		Nodo<T> direita = novo.getDireita();
		Nodo<T> esquerda = novo.getDireita();
		
		int num = val.compareTo(val);
		int v = valor.compareTo(valor);
	
		if (v > num) {
			if (novo.getEsquerda() != null) {
				novo.setEsquerda((Nodo<T>) valor);
			} else {
				novo.setEsquerda((Nodo<T>) valor);
			}

		} else if (valor == novo.getValor()) {
			if (novo.getDireita() != null) {
				novo.setDireita((Nodo<T>) valor);
			} else {
				novo.setDireita((Nodo<T>) valor);
			}
		}

	}

	public Nodo<T> remove(Nodo<T> nodo) {
		if (nodo == null) {
			return null;
		} else if (nodo.getEsquerda() != null) {
			nodo.setEsquerda(remove(nodo.getEsquerda()));
			return nodo;
		} else {
			return nodo.getDireita();
		}

	}

	@Override
	public int compareTo(ArvoreBinaria<T> o) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

	

	
	
}
