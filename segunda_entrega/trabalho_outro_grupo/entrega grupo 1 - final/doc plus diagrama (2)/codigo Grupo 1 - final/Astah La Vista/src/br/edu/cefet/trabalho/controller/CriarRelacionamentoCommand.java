package br.edu.cefet.trabalho.controller;

import br.edu.cefet.trabalho.model.Elemento;
import br.edu.cefet.trabalho.model.Relacionamento;
import br.edu.cefet.trabalho.view.Command;

public class CriarRelacionamentoCommand implements Command{

	private Relacionamento relacionamento;
	private String nome;
	private Elemento element1; 
	private Elemento element2; 
	private String sentido;
	private String papel1; 
	private String papel2; 
	private String multi1; 
	private String multi2; 
	private String mod1; 
	private String mod2;
	private String nav1; 
	private String nav2;
	
	public CriarRelacionamentoCommand(Relacionamento relacionamento, String nome, Elemento element1, Elemento element2, String sentido,
			String papel1, String papel2, String multi1, String multi2, String mod1, String mod2,
			String nav1, String nav2){
		this.relacionamento = relacionamento;
		this.nome = nome;
		this.element1 = element1;
		this.element2 = element2;
		this.sentido = sentido;
		this.papel1 = papel1;
		this.papel2 = papel2;
		this.multi1 = multi1;
		this.multi2 = multi2;
		this.mod1 = mod1;
		this.mod2 = mod2;
		this.nav1 = nav1;
		this.nav2 = nav2;
	}
	
	@Override
	public void execute() {
		DiagramController.criarRelacionamento(relacionamento, nome, element1, element2, sentido, papel1, papel2, multi1, multi2,
				mod1, mod2, nav1, nav2);
	}

}
