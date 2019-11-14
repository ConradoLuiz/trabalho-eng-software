package br.edu.cefet.trabalho.controller;

import br.edu.cefet.trabalho.model.Interface;
import br.edu.cefet.trabalho.view.Command;

public class CriarInterfaceCommand implements Command{

	private Interface interface_;
	
	public CriarInterfaceCommand(Interface interface_) {
		this.interface_ = interface_;
	}
	
	@Override
	public void execute() {
		DiagramModel.criarInterface(interface_);
	}
	
}
