package br.edu.cefet.trabalho.model;

import java.io.Serializable;

import br.edu.cefet.trabalho.controller.DiagramController;

public class Associacao extends Relacionamento implements Serializable{

	private static final long serialVersionUID = 2742509383659435034L;

	@Override
	public void desenha() {
		if(isDesenhado() == false) {
			DiagramController.atualizarImagem("Associa��o desenhada: " + this + "\n");
			setDesenhado(true);
		}
		
	}

}
