package br.edu.cefet.trabalho.controller;

import br.edu.cefet.trabalho.view.Command;
import br.edu.cefet.trabalho.view.DiagramCreation;
import br.edu.cefet.trabalho.view.MenuView;

public class CriarDiagramaCommand implements Command{
	
	private MenuView view;
	private DiagramCreation dc;
	
	public CriarDiagramaCommand(MenuView view, DiagramCreation dc) {
		this.view = view;
		this.dc = dc;
	}
	
	@Override
	public void execute() {
		DiagramCreationController.criarDiagrama(dc.getCampo().getText(), view.getTexto().getText());
	}

}
