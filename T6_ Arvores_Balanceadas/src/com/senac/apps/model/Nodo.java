package com.senac.apps.model;


public class Nodo {

	public int dado;
	public Nodo pai;
	public Nodo esquerda;
	public Nodo direita;
	public int fatorBalanco;

	public Nodo() {

	}

	public Nodo(int x) {
		this.dado = x;
		this.pai = null;
		this.esquerda = null;
		this.direita = null;
		this.fatorBalanco = 0;
	}

	public Nodo(int x, Nodo esquerda, Nodo direita) {
		this.dado = x;
		this.pai = null;
		this.esquerda = esquerda;
		this.direita = direita;
		this.direita.pai = this;
		this.esquerda.pai = this;

	}

	public Nodo elemento() {
		return this;
	}
}
