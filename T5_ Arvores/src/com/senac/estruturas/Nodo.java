package com.senac.estruturas;

public  class Nodo<T extends Comparable<T>> implements Comparable<Nodo<T>> {

	private T valor;  
	private Nodo<T> principal; 
	private Nodo<T> esquerda; 
	private Nodo<T> direita;

	public Nodo() {
		valor = null;
		principal = null;
		esquerda = null;
		direita = null;
	}

	public Nodo(T chave) {
		this.valor = chave;
		this.principal = null;
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

	public Nodo<T> getprincipal() {
		return this.principal;
	}

	public void setprincipal(Nodo<T> principal) {
		this.principal = principal;
	}
	
	public void setEsquerda(Nodo<T> esquerda) {
		this.esquerda = esquerda;
		if (this.esquerda != null)
		{
			this.esquerda.setprincipal(this);
		}
	}

	public Nodo<T> getDireita() {
		return direita;
	}

	public void setDireita(Nodo<T> direita) {
		this.direita = direita;
		if (this.direita != null) {
			this.direita.setprincipal(this);
		}
	}

	public boolean verificaFilhos() {
		if (this.getEsquerda() == null && this.getDireita() == null) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Nodo<T> nodo) {
		return valor.compareTo(nodo.getValor());
	}
	
}
