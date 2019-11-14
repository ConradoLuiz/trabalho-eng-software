package br.edu.cefet.trabalho.controller;
import java.util.ArrayList;

import br.edu.cefet.trabalho.model.Diagrama;
import br.edu.cefet.trabalho.model.Elemento;
import br.edu.cefet.trabalho.model.Relacionamento;

/** Classe responsável por manter o estado atual do diagrama.
 *  É também responsável por manter uma versão anterior do
 *  diagrama para a chamada do UNDO. A classe é também responásavel
 *  por tratar dos eventos dos botões selecionados na classe DiagramCreation*/

//MUDAR PARA "DiagramStateController"
public class DiagramCreationController{
	private static Diagrama diagrama;
	private static Diagrama diagramaBackup;
	
	public static void criarDiagrama(String nome, String imagem) {
		diagrama = new Diagrama();
		diagrama.setNome(nome);
		diagramaBackup = new Diagrama();
		atualizarDiagramaBackup();
	}
	
	public static void atualizarDiagrama() {
		diagrama.setNome(diagramaBackup.getNome());
		diagrama.setElementos((ArrayList<Elemento>)diagramaBackup.getElementos().clone());
		diagrama.setRelacionamentos((ArrayList<Relacionamento>)diagramaBackup.getRelacionamentos().clone());
		diagrama.setImagem(diagramaBackup.getImagem());
	}
	public static void atualizarDiagramaBackup() {
		diagramaBackup.setNome(diagrama.getNome());
		diagramaBackup.setElementos((ArrayList<Elemento>)diagrama.getElementos().clone());
		diagramaBackup.setRelacionamentos((ArrayList<Relacionamento>)diagrama.getRelacionamentos().clone());
		diagramaBackup.setImagem(diagrama.getImagem());
	}
	
	public static Diagrama getDiagrama() {
		return diagrama;
	}

	public static void setDiagrama(Diagrama diagrama) {
		DiagramCreationController.diagrama = diagrama;
	}

	public static Diagrama getDiagramaBackup() {
		return diagramaBackup;
	}

	public static void setDiagramaBackup(Diagrama diagramaBackup) {
		DiagramCreationController.diagramaBackup = diagramaBackup;
	}
	
}
