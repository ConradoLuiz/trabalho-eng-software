package br.edu.cefet.trabalho.controller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import br.edu.cefet.trabalho.model.Diagrama;

/** Classe respons�vel por salvar o arquivo do diagrama
 *  e por carregar  no programa um arquivo do diagrama*/

public final class Save_Load {
	private static Diagrama diagrama;
	
	public static void salvar() throws IOException {
		diagrama = DiagramCreationController.getDiagrama();
		String nome = diagrama.getNome();
		escreveDiagramaEmArquivo(nome);
	}
	public static void carregar() throws IOException, ClassNotFoundException {
		try {
			
			JFileChooser chooser = new JFileChooser();
			String nome = null;
			FileNameExtensionFilter filter = new FileNameExtensionFilter("ddlm Files", "ddlm");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				nome = chooser.getSelectedFile().getAbsoluteFile().getName();
			}
			FileInputStream fis = new FileInputStream(nome);
			ObjectInputStream ois = new ObjectInputStream(fis);
			diagrama = (Diagrama)ois.readObject();
			ois.close();
			DiagramCreationController.setDiagrama(diagrama);
			DiagramCreationController.setDiagramaBackup(new Diagrama());
			
			DiagramCreationController.atualizarDiagramaBackup();
		}
		catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo n�o encontrado!");
		}
		catch(NullPointerException e2) {
			JOptionPane.showMessageDialog(null, "Opera��o cancelada!");
		}
	}
	
	public static void escreveDiagramaEmArquivo(String nome) throws IOException {
		FileOutputStream fos = new FileOutputStream(nome + ".ddlm");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(diagrama);
		oos.close();
	}
}
