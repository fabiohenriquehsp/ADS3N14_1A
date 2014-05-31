package com.senac.apps.model;

public class Avl extends Arvore {

	private boolean cont;
	private int local;

	public Avl() {
		super();

	}

	public Nodo buscarElemento(int x) {
		return super.buscarElemento(x);
	}

	private void casoDireita(Nodo p, boolean h) {
		Nodo ptu = new Nodo();
		boolean testeRaiz = false;

		if (p == pricipal)
			testeRaiz = true;
		ptu = p.esquerda;
		if (ptu.fatorBalanco == -1) {
			p.esquerda = ptu.direita;

			if (ptu.direita != null) {
				ptu.direita.pai = p;
			}
			if (p != pricipal) {
				p.pai.esquerda = ptu;
			}
			ptu.pai = p.pai;
			ptu.direita = p;
			p.pai = ptu;
			p.fatorBalanco = 0;
			p = ptu;
			if (testeRaiz)
				pricipal = ptu;
		} else {
			Nodo ptv = new Nodo();
			ptv = ptu.direita;
			ptu.direita = ptv.esquerda;
			if (ptv.esquerda != null) {
				ptv.esquerda.pai = ptu;
			}
			ptv.esquerda = ptu;
			ptu.pai = ptv;
			p.esquerda = ptv.direita;
			if (ptv.direita != null) {
				ptv.direita.pai = p;
			}
			ptv.direita = p;
			if (p.pai != null) {
				p.pai.direita = ptv;
			}
			ptv.pai = p.pai;
			p.pai = ptv;
			if (ptv.fatorBalanco == -1)
				p.fatorBalanco = 1;
			else
				p.fatorBalanco = 0;
			if (ptv.fatorBalanco == 1)
				ptu.fatorBalanco = -1;
			else
				ptu.fatorBalanco = 0;
			if (testeRaiz)
				pricipal = ptv;
			p = ptv;
		}
		p.fatorBalanco = 0;
		cont = false;

	}

	private void casoEsquerda(Nodo p, boolean h) {
		Nodo ptu = new Nodo();
		boolean testeraiz = false;

		if (p == pricipal)
			testeraiz = true;
		ptu = p.direita;
		if (ptu.fatorBalanco == 1) {
			p.direita = ptu.esquerda;

			if (ptu.esquerda != null) {
				ptu.esquerda.pai = p;
			}
			if (p != pricipal) {
				p.pai.direita = ptu;
			}
			ptu.pai = p.pai;
			ptu.esquerda = p;
			p.pai = ptu;
			p.fatorBalanco = 0;
			p = ptu;
			if (testeraiz)
				pricipal = ptu;
		} else {
			Nodo ptv = new Nodo();
			ptv = ptu.esquerda;
			ptu.esquerda = ptv.direita;
			if (ptv.direita != null) {
				ptv.direita.pai = ptu;
			}
			ptv.direita = ptu;
			ptu.pai = ptv;
			p.direita = ptv.esquerda;
			if (ptv.esquerda != null) {
				ptv.esquerda.pai = p;
			}
			ptv.esquerda = p;
			if (p.pai != null) {
				p.pai.esquerda = ptv;
			}
			p.pai = ptv;
			if (ptv.fatorBalanco == 1)
				p.fatorBalanco = -1;
			else
				p.fatorBalanco = 0;
			if (ptv.fatorBalanco == -1)
				ptu.fatorBalanco = 1;
			else
				ptu.fatorBalanco = 0;
			if (testeraiz)
				pricipal = ptv;
			p = ptv;
		}
		p.fatorBalanco = 0;
		cont = false;
	}

	public boolean inserirElemento(int x) {
		curso = new Nodo(x);
		if (pricipal == null) {
			pricipal = curso;
		} else {
			curso = pricipal;
			insAVL(x, curso, false);
		}
		System.out.println(exibirPreOrdem());
		return true;
	}

	private boolean insAVL(int x, Nodo pt, boolean h) {
		cont = h;
		if (pt == null) {
			pt = new Nodo(x);
			if (posicao == 1) {
				cursoAuxi.esquerda = pt;
			} else if (posicao == 2) {
				cursoAuxi.direita = pt;
			}
			pt.pai = cursoAuxi;
			cont = true;
			posicao = 0;
		} else {
			if (x == pt.dado) {
				pt = null;
				return false;
			}
			if (x < pt.dado) {
				cursoAuxi = pt;
				posicao = 1;
				insAVL(x, pt.esquerda, cont);

				if (cont) {
					if (pt.fatorBalanco == 1) {
						pt.fatorBalanco = 0;
						cont = false;
					} else if (pt.fatorBalanco == 0)
						pt.fatorBalanco = -1;
					else if (pt.fatorBalanco == -1)
						casoDireita(pt, cont);
				}
			} else {
				cursoAuxi = pt;
				posicao = 2;
				insAVL(x, pt.direita, cont);

				if (cont) {

					if (pt.fatorBalanco == -1) {
						pt.fatorBalanco = 0;
						cont = false;
					} else if (pt.fatorBalanco == 0)
						pt.fatorBalanco = 1;
					else if (pt.fatorBalanco == 1)
						casoEsquerda(pt, cont);
				}
			}
		}
		return true;
	}

	public boolean removerElemento(int x) {
		if (pricipal == null) {
			return false;
		} else {
			curso = pricipal;
			remAVL(x, curso, false);
		}
		System.out.println(exibirPreOrdem());
		return true;
	}

	public boolean remAVL(int x, Nodo pt, boolean h) {
		cont = h;

		if (pt == null) {
			return false;
		} else {
			if (x == pt.dado) {
				if (pt.esquerda == null && pt.direita == null) {
					if (pt == pricipal) {
						pricipal = null;
					} else {
						if (posicao == 1)
							pt.pai.esquerda = null;
						else if (posicao == 2)
							pt.pai.direita = null;
					}
					pt = null;
					cont = true;
				} else {
					cursoAuxi = pt;
					if (pt.esquerda == null) {
						pt = pt.direita;
						local = 1;
						if (pt.direita == null) {
							pt = pt.esquerda;
							local = 2;
						} else {

							pt = minDireita(cursoAuxi.direita);

							pt.esquerda = cursoAuxi.esquerda;
							if (cursoAuxi == pricipal) {
								pricipal = pt;
							} else {
								pt.pai = cursoAuxi.pai;
								if (posicao == 1)
									cursoAuxi.pai.esquerda = pt;
								else if (posicao == 2)
									cursoAuxi.pai.direita = pt;
							}
							cursoAuxi = null;
							return true;
						}
					}
				}
				if (cursoAuxi == pricipal) {
					pricipal = pt;
				} else {
					if (local == 1) {
						cursoAuxi.pai.direita = pt;
					} else if (local == 2) {
						cursoAuxi.pai.esquerda = pt;
					}
				}
				cursoAuxi = null;
			}

			else {
				if (x < pt.dado) {
					cursoAuxi = pt;
					posicao = 1;
					remAVL(x, pt.esquerda, cont);

					if (cont) {
						if (pt.fatorBalanco == -1)
							pt.fatorBalanco = 0;
						cont = false;
					} else if (pt.fatorBalanco == 0)
						pt.fatorBalanco = 1;
					else if (pt.fatorBalanco == 1)
						casoEsquerda(pt, cont);
				} else {
					cursoAuxi = pt;
					posicao = 2;
					remAVL(x, pt.direita, cont);

					if (cont) {
						if (pt.fatorBalanco == 1) {
							pt.fatorBalanco = 0;
							cont = false;
						} else if (pt.fatorBalanco == 0)
							pt.fatorBalanco = -1;
						else if (pt.fatorBalanco == -1)
							casoDireita(pt, cont);
					}
				}
			}
		}
		local = 0;
		return true;

	}

	public String exibirPreOrdem() {
		return super.exibirPreOrdem();
	}

	public String balanco() {
		if (pricipal == null)
			return "";
		Nodo p = this.pricipal;
		mostra = mostra + Integer.toString(p.fatorBalanco) + " ";
		if (p.esquerda != null) {
			mostra = mostra + "(" + balanco(p.esquerda) + ")";
		}
		if (p.direita != null) {
			mostra = mostra + "(" + balanco(p.direita) + ")";
		}
		String pr = mostra;
		mostra = " ";
		return pr;
	}

	private String balanco(Nodo p) {
		mostra = Integer.toString(p.fatorBalanco) + " ";
		if (p.esquerda != null) {
			mostra = mostra + "( " + balanco(p.esquerda) + ")";
		}
		if (p.direita != null) {
			mostra = mostra + "(" + balanco(p.direita) + ")";
		}
		String pr = mostra;
		mostra = " ";
		return pr;
	}

}
