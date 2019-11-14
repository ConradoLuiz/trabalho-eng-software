package br.edu.cefet.trabalho.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Atributo implements Serializable{

	private static final long serialVersionUID = 4612231281757641429L;
	private String nome;
	private String tipo;
	private String visibilidade;
	private ArrayList<String> modificadores = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	public String getTipo() {
		return tipo;
	}
	public String getVisibilidade() {
		return visibilidade;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setVisibilidade(String visibilidade) {
		this.visibilidade = visibilidade;
	}
	public ArrayList<String> getModificadores() {
		return modificadores;
	}
	public void setModificadores(ArrayList<String> modificadores) {
		this.modificadores = modificadores;
	}
	public String toString() {
		String conc = "";
		for(String mod : modificadores) {
			conc = conc + " " + mod;
		}
		return (visibilidade + " " + conc + " " + tipo + " " + nome);
	}

}
