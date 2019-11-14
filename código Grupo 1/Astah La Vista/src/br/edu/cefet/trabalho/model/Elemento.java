package br.edu.cefet.trabalho.model;
import java.io.Serializable;
import java.util.ArrayList;

public class Elemento implements Serializable{
	
	private static final long serialVersionUID = 1947362547361987896L;
	
	private String nome;
	private ArrayList<Atributo> atributos = new ArrayList<>();
	private ArrayList<Metodo> metodos = new ArrayList<>();
	
	//Caso contido dentro de um relacionamento,
	//a classe elemento apresenta mais estes atributos:
	
	private String mutiplicidade;
	private String papel;
	private String modificador;
	private String navegabilidade;
	
	//Getters e Setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<Atributo> getAtributos() {
		return atributos;
	}
	
	public ArrayList<Metodo> getMetodos() {
		return metodos;
	}
	
	public String toString() {
		return this.nome;
	}

	public String getMutiplicidade() {
		return mutiplicidade;
	}

	public void setMutiplicidade(String mutiplicidade) {
		this.mutiplicidade = mutiplicidade;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public String getModificador() {
		return modificador;
	}

	public void setModificador(String modificador) {
		
		this.modificador = modificador;
	}

	public String getNavegabilidade() {
		return navegabilidade;
	}

	public void setNavegabilidade(String navegabilidade) {
		this.navegabilidade = navegabilidade;
	}

}
