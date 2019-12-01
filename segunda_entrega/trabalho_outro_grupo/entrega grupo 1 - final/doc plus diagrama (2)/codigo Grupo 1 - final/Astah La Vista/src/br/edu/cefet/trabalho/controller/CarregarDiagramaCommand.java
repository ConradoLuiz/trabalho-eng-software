package br.edu.cefet.trabalho.controller;

import java.io.IOException;

import br.edu.cefet.trabalho.view.Command;

public class CarregarDiagramaCommand implements Command{

	@Override
	public void execute() {
		try {
			Save_Load.carregar();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
