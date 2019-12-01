package br.edu.cefet.trabalho.controller;

import br.edu.cefet.trabalho.model.Classe;
import br.edu.cefet.trabalho.view.Command;

public class CriarClasseCommand implements Command{

	private Classe classe;
	
	public CriarClasseCommand(Classe classe) {
		this.classe = classe;
	}
	
	@Override
	public void execute() {
		DiagramController.criarClasse(classe);
	}

}
