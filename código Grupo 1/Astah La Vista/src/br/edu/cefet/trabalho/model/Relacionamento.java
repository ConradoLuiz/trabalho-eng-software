package br.edu.cefet.trabalho.model;
import java.io.Serializable;
import java.util.ArrayList;

public class Relacionamento implements Serializable{
	
	private static final long serialVersionUID = 7816453452876156745L;
	
	private String nome;
	private String sentido;
	private ArrayList<Elemento> elemento = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Elemento> getElemento() {
		return elemento;
	}
	public void setElemento(ArrayList<Elemento> elemento) {
		this.elemento = elemento;
	}
	public String getSentido() {
		return sentido;
	}
	public void setSentido(String sentido) {
		this.sentido = sentido;
	}
	
	public String toString() {
		return elemento.get(0).getModificador() + " " + elemento.get(0).getNome() + 
				" (" + elemento.get(0).getMutiplicidade() +") " + elemento.get(0).getNavegabilidade() + " " + this.nome + " (" + this.sentido + ") " + 
				elemento.get(1).getNavegabilidade() +
				" (" + elemento.get(1).getMutiplicidade() + ") " 
				+ elemento.get(1).getModificador() + " " + 
				elemento.get(1).getNome() + "\n" + "Papel da classe " + elemento.get(0).getNome() + ": " + elemento.get(0).getPapel()
				+ "\n" + "Papel da classe " + elemento.get(1).getNome() + ": " + elemento.get(1).getPapel();						
	}
	
}
