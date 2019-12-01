package br.edu.cefet.trabalho.controller;

public abstract class Component {
	
	private boolean desenhado;
	
	public abstract void desenha();

	public boolean isDesenhado() {
		return desenhado;
	}

	public void setDesenhado(boolean desenhado) {
		this.desenhado = desenhado;
	}
}
