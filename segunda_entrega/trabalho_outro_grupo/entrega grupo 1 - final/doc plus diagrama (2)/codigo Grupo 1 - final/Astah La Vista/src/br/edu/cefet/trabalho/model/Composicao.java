package br.edu.cefet.trabalho.model;

import java.io.Serializable;

import br.edu.cefet.trabalho.controller.DiagramController;

public class Composicao extends Relacionamento implements Serializable{

	private static final long serialVersionUID = 883667236290363689L;

	@Override
	public void desenha() {
		if(isDesenhado() == false) {
			DiagramController.atualizarImagem("Composi��o desenhada: " + this + "\n");
			setDesenhado(true);
		}
	}

}
