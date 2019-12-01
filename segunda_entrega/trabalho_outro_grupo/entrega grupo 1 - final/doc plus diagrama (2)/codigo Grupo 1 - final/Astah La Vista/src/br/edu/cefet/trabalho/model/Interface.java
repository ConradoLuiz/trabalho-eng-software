package br.edu.cefet.trabalho.model;

import java.io.Serializable;

import br.edu.cefet.trabalho.controller.DiagramController;

public class Interface extends Elemento implements Serializable{

	private static final long serialVersionUID = 2517087991070088794L;

	@Override
	public void desenha() {
		if(isDesenhado() == false) {
			DiagramController.atualizarImagem("Interface '" + this.getNome() + "' desenhada\n");
			if(this.getAtributos().size() != -1) {
				for(Atributo atr : this.getAtributos()) {
					DiagramController.atualizarImagem("\tAtributo '" + atr + "' desenhado\n");
				}
			}
			if(this.getMetodos().size() != -1) {
				for(Metodo met : this.getMetodos()) {
					DiagramController.atualizarImagem("\tM�todo '" + met + "' desenhado\n");
				}
			}
			this.setDesenhado(true);
		}
		
	}
	
}
