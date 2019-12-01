package br.edu.cefet.trabalho.model;

import java.io.Serializable;

import br.edu.cefet.trabalho.controller.DiagramController;

public class Agregacao extends Relacionamento implements Serializable{

	private static final long serialVersionUID = -4250329985281681063L;

	@Override
	public void desenha() {
		if(isDesenhado() == false) {
			DiagramController.atualizarImagem("Agrega��o desenhada: " + this + "\n");
			setDesenhado(true);
		}
		
	}

}
