package br.edu.cefet.trabalho.model;

import java.io.Serializable;

import br.edu.cefet.trabalho.controller.DiagramController;

public class Classe extends Elemento implements Serializable{

	private static final long serialVersionUID = 6583240428612326554L;

	@Override
	public void desenha() {
		if(isDesenhado() == false) {
			DiagramController.atualizarImagem("Classe '" + this.getNome() + "' desenhada\n");
			if(!this.getAtributos().isEmpty()) {
				for(Atributo atr : this.getAtributos()) {
					DiagramController.atualizarImagem("\tAtributo '" + atr + "' desenhado\n");
				}
			}
			if(!this.getMetodos().isEmpty()) {
				for(Metodo met : this.getMetodos()) {
					DiagramController.atualizarImagem("\tM�todo '" + met + "' desenhado\n");
				}
			}
			this.setDesenhado(true);
		}
	}
	
}
