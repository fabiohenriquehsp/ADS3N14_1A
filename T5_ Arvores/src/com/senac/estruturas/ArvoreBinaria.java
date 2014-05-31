package com.senac.estruturas;

public class ArvoreBinaria<T extends Comparable<T>>

{

	private Nodo<T> raiz;
	private int cmp = 0;

	public ArvoreBinaria() {
		this.raiz = null;
	}

	public void insert(Nodo<T> novo) {

		if (this.raiz == null) {
			this.raiz = novo;
		} else {
			if (novo.compareTo(raiz) == 0) {
				this.raiz = novo;
			} else {
				this.insertNodo(raiz, novo);
			}
		}

	}

	private void insertNodo(Nodo<T> nodoPrincipal, Nodo<T> nodoInserir) {
		int result = nodoPrincipal.compareTo(nodoInserir);
		// # valor menor que zero insere esquerda
		if (result < 0) {
			this.insereEsquerda(nodoPrincipal, nodoInserir);
		}
		// # valor maior que zero insere direita
		else if (result > 0) {
			this.insereDireita(nodoPrincipal, nodoInserir);
		} else {
			nodoPrincipal.setValor(nodoInserir.getValor());
			this.insereDireita(nodoPrincipal, nodoInserir);
		}
	}

	private void insereEsquerda(Nodo<T> nodoPrincipal, Nodo<T> nodoInserir) {
		// # valor diferente de zero insere
		if (nodoPrincipal.getEsquerda() != null) {
			this.insertNodo(nodoPrincipal.getEsquerda(), nodoInserir);
		} else {
			nodoPrincipal.setEsquerda(nodoInserir);
		}
	}

	private void insereDireita(Nodo<T> nodoPai, Nodo<T> nodoInserir) {
		// # valor diferente de zero insere
		if (nodoPai.getDireita() != null) {
			this.insertNodo(nodoPai.getDireita(), nodoInserir);
		} else {
			nodoPai.setDireita(nodoInserir);
		}
	}

	public void remove(Nodo<T> removeNodo) {
		if (!removeNodo.verificaFilhos()) {
			Nodo<T> nodoPai = removeNodo.getprincipal();
			removeNodo.setprincipal(null);
			if (nodoPai.getEsquerda() != null) {
				if (nodoPai.getEsquerda().compareTo(removeNodo) == 0) {
					nodoPai.setEsquerda(null);
				}
			} else if (nodoPai.getDireita() != null) {
				if (nodoPai.getDireita().compareTo(removeNodo) == 0) {
					nodoPai.setDireita(null);
				}
			}
		} else if (removeNodo.getDireita() != null
				^ removeNodo.getEsquerda() != null) {
			Nodo<T> nodoPai = removeNodo.getprincipal();
			removeNodo.setprincipal(null);
			if (removeNodo.getDireita() != null) {
				if (nodoPai.getEsquerda() != null) {
					if (nodoPai.getEsquerda().compareTo(removeNodo) == 0) {
						nodoPai.setEsquerda(removeNodo.getDireita());
					}
				} else if (nodoPai.getDireita() != null) {
					if (nodoPai.getDireita().compareTo(removeNodo) == 0) {
						nodoPai.setDireita(removeNodo.getDireita());
					}
				}
			} else if (removeNodo.getEsquerda() != null) {
				if (nodoPai.getEsquerda() != null) {
					if (nodoPai.getEsquerda().compareTo(removeNodo) == 0) {
						nodoPai.setEsquerda(removeNodo.getEsquerda());
					}
				} else if (nodoPai.getDireita() != null) {
					if (nodoPai.getDireita().compareTo(removeNodo) == 0) {
						nodoPai.setDireita(removeNodo.getEsquerda());
					}
				}
			}
		} else {

			Nodo<T> nodoAnterior = removeNodo.getEsquerda();
			removeNodo.setValor(nodoAnterior.getValor());
			this.remove(nodoAnterior);

		}
	}

	// # 'nodo' refere-se ao nó-pai, neste caso
	public Nodo<T> buscar(Nodo no, Nodo valor) {
		if (no == null) {
			// # valor não encontrado
			return null;
		} else {
			int no_valor = valor.compareTo(no);
			if (valor == no)
				// # valor encontrado
				return no;
			else if (no_valor < 0) {
				// # busca na subárvore esquerda
				return this.buscar(no.getDireita(), valor);
			} else if (no_valor > 0) {
				// # busca na subárvore direita
				return this.buscar(no.getEsquerda(), valor);
			} else {
				return null;
			}

		}

	}
	
	public Nodo<T> getHead() {
		return this.raiz;
	}

	public int getComparacoes() {
		return this.cmp;
	}
	
}
