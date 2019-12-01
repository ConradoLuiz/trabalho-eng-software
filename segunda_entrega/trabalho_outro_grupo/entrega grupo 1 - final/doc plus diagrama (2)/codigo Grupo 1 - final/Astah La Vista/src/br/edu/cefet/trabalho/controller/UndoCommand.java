package br.edu.cefet.trabalho.controller;

import br.edu.cefet.trabalho.view.Command;

public class UndoCommand implements Command{

	@Override
	public void execute() {
		DiagramController.undo();
	}
}
