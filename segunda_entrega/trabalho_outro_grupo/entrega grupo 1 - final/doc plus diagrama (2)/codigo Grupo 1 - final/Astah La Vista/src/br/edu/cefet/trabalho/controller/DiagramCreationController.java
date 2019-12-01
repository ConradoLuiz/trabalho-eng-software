package br.edu.cefet.trabalho.controller;
import java.util.ArrayList;

import br.edu.cefet.trabalho.model.Diagrama;
import br.edu.cefet.trabalho.model.Elemento;
import br.edu.cefet.trabalho.model.Relacionamento;

/** Classe respons�vel por manter o estado atual do diagrama.
 *  � tamb�m respons�vel por manter uma vers�o anterior do
 *  diagrama para a chamada do UNDO. A classe � tamb�m respon�savel
 *  por tratar dos eventos dos bot�es selecionados na classe DiagramCreation*/

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
		String nomeUndo = diagramaBackup.getNome();
		ArrayList<Elemento> eleUndo = (ArrayList<Elemento>)diagramaBackup.getElementos().clone();
		ArrayList<Relacionamento> relaUndo = (ArrayList<Relacionamento>)diagramaBackup.getRelacionamentos().clone();
		String imagemUndo = diagramaBackup.getImagem();
		diagrama.setNome(nomeUndo);
		diagrama.setElementos(eleUndo);
		diagrama.setRelacionamentos(relaUndo);
		diagrama.setImagem(imagemUndo);
	}
	public static void atualizarDiagramaBackup() {
		String nomeBackup = diagrama.getNome();
		ArrayList<Elemento> eleBackup = (ArrayList<Elemento>)diagrama.getElementos().clone();
		ArrayList<Relacionamento> relaBackup = (ArrayList<Relacionamento>)diagrama.getRelacionamentos().clone();
		String imagemBackup = diagrama.getImagem();
		diagramaBackup.setNome(nomeBackup);
		diagramaBackup.setElementos(eleBackup);
		diagramaBackup.setRelacionamentos(relaBackup);
		diagramaBackup.setImagem(imagemBackup);
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
