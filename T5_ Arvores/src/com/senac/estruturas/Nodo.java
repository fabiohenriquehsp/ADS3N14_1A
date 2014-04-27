package com.senac.estruturas;

public class Nodo<T> {

	private T valor;
	private Nodo<T> esquerda;
	private Nodo<T> direita;

	public Nodo() {
		valor = null;
	}

	public Nodo(T chave) {
		this.valor = chave;
		this.esquerda = null;
		this.direita = null;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public Nodo<T> getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(Nodo<T> esquerda) {
		this.esquerda = esquerda;
	}

	public Nodo<T> getDireita() {
		return direita;
	}

	public void setDireita(Nodo<T> direita) {
		this.direita = direita;
	}

}
