package br.edu.cefet.trabalho.model;

import java.io.Serializable;

public class Parametro implements Serializable{

	private static final long serialVersionUID = 5998487490173506103L;
	private String nome;
	private String tipo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		return tipo + " " + nome;
	}
	
}
