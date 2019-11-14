package br.edu.cefet.trabalho.controller;

import br.edu.cefet.trabalho.model.Atributo;
import br.edu.cefet.trabalho.model.Classe;
import br.edu.cefet.trabalho.model.Elemento;
import br.edu.cefet.trabalho.model.Interface;
import br.edu.cefet.trabalho.model.Metodo;
import br.edu.cefet.trabalho.model.Relacionamento;

public final class DiagramModel {
	
	public static void atualizarImagem(String texto){
		DiagramCreationController.getDiagrama().setImagem(DiagramCreationController.getDiagrama().getImagem() + texto);
	}
	
	//Criação dos elementos
	
	public static void criarClasse(Classe classe) {
		DiagramCreationController.getDiagrama().getElementos().add(classe);
		atualizarImagem("Classe '" + classe.getNome() + "' desenhada\n");
		if(!classe.getAtributos().isEmpty()) {
			for(Atributo atr : classe.getAtributos()) {
				atualizarImagem("\tAtributo '" + atr + "' desenhado\n");
			}
		}
		if(!classe.getMetodos().isEmpty()) {
			for(Metodo met : classe.getMetodos()) {
				atualizarImagem("\tMétodo '" + met + "' desenhado\n");
			}
		}
	}
	
	public static void criarInterface(Interface interface_) {
		DiagramCreationController.getDiagrama().getElementos().add(interface_);
		atualizarImagem("Interface '" + interface_.getNome() + "' desenhada\n");
		if(interface_.getAtributos().size() != -1) {
			for(Atributo atr : interface_.getAtributos()) {
				atualizarImagem("\tAtributo '" + atr + "' desenhado\n");
			}
		}
		if(interface_.getMetodos().size() != -1) {
			for(Metodo met : interface_.getMetodos()) {
				atualizarImagem("\tMétodo '" + met + "' desenhado\n");
			}
		}
	}
	
	public static void criarRelacionamento(Relacionamento relacionamento, String nome, Elemento element1, Elemento element2, String sentido,
											String papel1, String papel2, String multi1, String multi2, String mod1, String mod2,
											String nav1, String nav2) {
		
		relacionamento.setNome(nome);
		relacionamento.getElemento().add(element1);
		relacionamento.getElemento().add(element2);
		relacionamento.setSentido(sentido);
  		
		relacionamento.getElemento().get(0).setPapel(papel1);
		relacionamento.getElemento().get(0).setMutiplicidade(multi1);
		relacionamento.getElemento().get(0).setModificador(mod1);
		relacionamento.getElemento().get(0).setNavegabilidade(nav1);
		relacionamento.getElemento().get(1).setPapel(papel2);
		relacionamento.getElemento().get(1).setMutiplicidade(multi2);
		relacionamento.getElemento().get(1).setModificador(mod2);
		relacionamento.getElemento().get(1).setNavegabilidade(nav2);
		
		DiagramCreationController.getDiagrama().getRelacionamentos().add(relacionamento);
	}
}
