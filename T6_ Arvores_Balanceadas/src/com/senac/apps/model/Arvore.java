package com.senac.apps.model;

public class Arvore {

	protected Nodo pricipal;
	protected int posicao;
	protected int tamanho;
	protected Nodo curso;
	protected Nodo cursoAuxi;
	protected String mostra;

	public Arvore() {
		this.pricipal = null;
		this.curso = null;
		this.cursoAuxi = null;
		this.tamanho = 0;
		this.mostra = " ";

	}

	public Arvore(int var) {
		this.pricipal = new Nodo(var);
		this.curso = pricipal;
		this.tamanho = 0;
		this.mostra = " ";
	}

	public Nodo pai(Nodo var) {
		if (var == pricipal)
			return null;
		else
			return var.pai;
	}

	public Nodo raiz() {
		return this.pricipal;
	}

	public int Filhos(Nodo p) {
		int f = 0;
		if (p.esquerda != null)
			f++;
		if (p.direita != null)
			f++;
		return f;
	}

	public boolean externo(Nodo var) {
		if (var.direita == null && var.esquerda == null)
			return true;
		else
			return false;
	}

	public boolean interno(Nodo var) {
		if (var.direita != null || var.esquerda != null)
			return true;
		else
			return false;

	}

	public boolean Raiz(Nodo var) {
		if (pricipal == var)
			return true;
		else
			return false;
	}

	public int tamanho() {
		if (pricipal == null) {
			return 0;
		} else {
			Nodo nod = pricipal;
			tamanho++;
			if (nod.direita != null) {
				tamanho = 1 + calTamanho(nod.direita);
			}
			if (nod.esquerda != null) {
				tamanho = 1 + calTamanho(nod.esquerda);
			}
			curso = nod;
		}

		int t = tamanho;
		tamanho = 0;
		return t;
	}

	private int calTamanho(Nodo var) {

		if (var.direita != null) {
			tamanho = 1 + calTamanho(var.direita);
		}
		if (var.esquerda != null) {
			tamanho = 1 + calTamanho(var.esquerda);
		}
		return tamanho;
	}

	public boolean Vazia() {
		if (pricipal == null)
			return true;
		else
			return false;
	}

	public int profundidade(Nodo var) {
		int prof = 0;
		Nodo nod = var;
		while (nod.pai != null) {
			prof++;
			nod = nod.pai;
		}
		return prof;
	}

	public int altura(Nodo var) {
		if (pricipal == null) {
			return 0;
		} else {
			int alt = 1;
			while (var.pai != null) {
				alt++;
				var = var.pai;
			}
			return alt;
		}
	}

	private int maisprofundo = 1;

	public int altura() {
		int var = 1;
		if (pricipal == null) {
			return 0;
		} else {
			if (pricipal.esquerda != null) {
				max(pricipal.esquerda, var + 1);
			}
			if (pricipal.direita != null) {
				max(pricipal.direita, var + 1);
			}
		}
		return maisprofundo;
	}

	private int max(Nodo p, int valor) {
		int x = valor;
		if (maisprofundo < x)
			maisprofundo = x;
		if (p.esquerda != null) {
			max(p.esquerda, x + 1);
		}
		if (p.direita != null) {
			max(p.direita, x + 1);
		}
		return 0;
	}

	public String exibirPreOrdem() {
		if (pricipal == null)
			return "";
		Nodo p = this.pricipal;
		mostra = mostra + Integer.toString(p.dado) + " ";
		if (p.esquerda != null) {
			mostra = mostra + "(" + exibirPreOrdem(p.esquerda) + ")";
		}
		if (p.direita != null) {
			mostra = mostra + "(" + exibirPreOrdem(p.direita) + ")";
		}
		String pr = mostra;
		mostra = " ";
		return pr;
	}

	private String exibirPreOrdem(Nodo p) {
		mostra = Integer.toString(p.dado) + " ";
		if (p.esquerda != null) {
			mostra = mostra + "( " + exibirPreOrdem(p.esquerda) + ")";
		}
		if (p.direita != null) {
			mostra = mostra + "(" + exibirPreOrdem(p.direita) + ")";
		}
		String pr = mostra;
		mostra = " ";
		return pr;
	}

	public String exibirOrdem() {
		if (pricipal == null)
			return "";
		Nodo p = this.pricipal;

		if (p.esquerda != null) {
			mostra = mostra + "(" + exibirOrdem(p.esquerda) + ")";
		}
		mostra = mostra + Integer.toString(p.dado) + " ";
		if (p.direita != null) {
			mostra = mostra + "(" + exibirOrdem(p.direita) + ")";
		}
		String pr = mostra;
		mostra = " ";
		return pr;
	}

	private String exibirOrdem(Nodo p) {

		if (p.esquerda != null) {
			mostra = mostra + "(" + exibirOrdem(p.esquerda) + ")";
		}
		mostra = Integer.toString(p.dado) + " ";
		if (p.direita != null) {
			mostra = mostra + "(" + exibirOrdem(p.direita) + ")";
		}
		String pr = mostra;
		mostra = " ";
		return pr;
	}

	public String exibirPosOrdem() {
		if (pricipal == null)
			return "";
		Nodo p = this.pricipal;

		if (p.esquerda != null) {
			mostra = mostra + "(" + exibirPosOrdem(p.esquerda) + ")";
		}
		if (p.direita != null) {
			mostra = "(" + exibirPosOrdem(p.direita) + ")";
		}
		mostra = mostra + Integer.toString(p.dado) + " ";
		String pr = mostra;
		mostra = " ";
		return pr;
	}

	private String exibirPosOrdem(Nodo p) {

		if (p.esquerda != null) {
			mostra = "(" + exibirPosOrdem(p.esquerda) + ")";
		}
		if (p.direita != null) {
			mostra = "(" + exibirPosOrdem(p.direita) + ")";
		}
		mostra = mostra + Integer.toString(p.dado) + " ";
		String pr = mostra;
		mostra = " ";
		return pr;
	}

	public Nodo filhoEsquerdo(Nodo p) {
		if (externo(p)) {
			return null;
		} else
			return p.esquerda;
	}

	public Nodo filhoDireito(Nodo p) {
		if (externo(p)) {
			return null;
		} else
			return p.direita;
	}

	public Nodo irmao(Nodo p) {

		if (p == pricipal) {
			return null;
		} else if (Filhos(p.pai) == 1) {
			return null;
		} else {
			if (p.pai.direita == p) {

				return p.pai.esquerda;

			} else {
				return p.pai.direita;
			}
		}
	}

	public Nodo buscarElemento(int x) {

		if (pricipal == null) {
			posicao = 0;
			return pricipal;
		}

		if (curso == null)
			return null;

		else if (curso.dado == x)
			return curso;

		else if (x < curso.dado) {
			cursoAuxi = curso;
			curso = curso.esquerda;
			cursoAuxi.esquerda = curso;
			posicao = 1;
			return buscarElemento(x);
		}

		else {
			cursoAuxi = curso;
			curso = curso.direita;
			cursoAuxi.direita = curso;
			posicao = 2;
			return buscarElemento(x);
		}
	}

	public boolean inserirElemento(int x) {
		Nodo p = null;
		this.curso = this.pricipal;
		p = buscarElemento(x);

		if (p != null) {
			return false;
		}

		else {
			p = new Nodo(x);
			if (posicao == 0) {
				this.pricipal = p;
			}

			else if (posicao == 1) {
				p.pai = cursoAuxi;
				cursoAuxi.esquerda = p;
			} else if (posicao == 2) {
				p.pai = cursoAuxi;
				cursoAuxi.direita = p;
			}
		}
		posicao = 4;
		curso = pricipal;
		System.out.println(exibirPreOrdem());
		return true;
	}

	public boolean removerElemento(int x) {
		Nodo p = null;
		curso = pricipal;
		p = buscarElemento(x);
		int local = 0;

		if (p == null) {
			return false;
		} else {
			if (p.esquerda == null && p.direita == null) {
				if (p == pricipal) {
					pricipal = null;
				} else {
					if (posicao == 1)

						p.pai.esquerda = null;
					else if (posicao == 2)
						p.pai.direita = null;
				}
				p = null;
				System.out.println(exibirPreOrdem());
				return true;
			} else {
				cursoAuxi = p;
				if (p.esquerda == null) {
					p = p.direita;
					local = 1;
				} else {
					if (p.direita == null) {
						p = p.esquerda;
						local = 2;//
					} else {

						p = minDireita(cursoAuxi.direita);
						p.esquerda = cursoAuxi.esquerda;
						if (cursoAuxi == pricipal) {

							pricipal = p;
						} else {
							p.pai = cursoAuxi.pai;
							if (posicao == 1)

								cursoAuxi.pai.esquerda = p;
							else if (posicao == 2)
								cursoAuxi.pai.direita = p;
						}
						cursoAuxi = null;
						System.out.println(exibirPreOrdem());
						return true;
					}
				}
			}
			if (cursoAuxi == pricipal) {
				pricipal = p;
			} else {
				if (local == 1)
					cursoAuxi.pai.direita = p;
				else if (local == 2)
					cursoAuxi.pai.esquerda = p;
				p.pai = cursoAuxi.pai;
			}
			cursoAuxi = null;
			System.out.println(exibirPreOrdem());
			return true;
		}
	}

	protected Nodo minDireita(Nodo p) {
		if (p.esquerda == null)
			return p;
		else {
			p = p.esquerda;
			return minDireita(p);
		}
	}

	public boolean removerTodosElementos() {

		while (this.pricipal != null) {
			removerElemento(pricipal.dado);
		}
		return true;
	}
}