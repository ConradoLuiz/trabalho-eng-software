package br.edu.cefet.trabalho.controller;

import br.edu.cefet.trabalho.model.Classe;
import br.edu.cefet.trabalho.model.Elemento;
import br.edu.cefet.trabalho.model.Interface;
import br.edu.cefet.trabalho.model.Relacionamento;

public final class DiagramController {
	
	private static Composite c = new Composite();
	
	public static void atualizarImagem(String texto){
		DiagramCreationController.getDiagrama().setImagem(DiagramCreationController.getDiagrama().getImagem() + texto);
	}
	
	//Cria��o dos elementos
	
	public static void criarClasse(Classe classe) {
		DiagramCreationController.getDiagrama().addElemento(classe);
		c.addFilhos(classe);
		c.desenha();
	}
	
	public static void criarInterface(Interface interface_) {
		DiagramCreationController.getDiagrama().addElemento(interface_);
		c.addFilhos(interface_);
		c.desenha();
	}
	
	public static void criarRelacionamento(Relacionamento relacionamento, String nome, Elemento element1, Elemento element2, String sentido,
											String papel1, String papel2, String multi1, String multi2, String mod1, String mod2,
											String nav1, String nav2) {
		
		relacionamento.setNome(nome);
		relacionamento.setSentido(sentido);
		
		preencheValoresElemento(element1, papel1, multi1, mod1, nav1);
		preencheValoresElemento(element2, papel2, multi2, mod2, nav2);
				
		relacionamento.addElementos(element1, element2);
		
		DiagramCreationController.getDiagrama().addRelacionamento(relacionamento);
		c.addFilhos(relacionamento);
		c.desenha();
	}
	
	public static void preencheValoresElemento(Elemento element,String papel, String multi, 
			                              String mod, String nav) {
		element.setPapel(papel);
		element.setMutiplicidade(multi);
		element.setModificador(mod);
		element.setNavegabilidade(nav);
	}
	
	public static void undo() {
		DiagramCreationController.atualizarDiagrama();
	}
}
