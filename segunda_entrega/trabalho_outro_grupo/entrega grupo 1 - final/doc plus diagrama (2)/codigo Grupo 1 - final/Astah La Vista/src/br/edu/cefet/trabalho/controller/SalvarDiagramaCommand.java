package br.edu.cefet.trabalho.controller;

import java.io.IOException;

import br.edu.cefet.trabalho.view.Command;

public class SalvarDiagramaCommand implements Command{

	@Override
	public void execute() {
		try {
			Save_Load.salvar();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
