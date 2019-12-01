package br.edu.cefet.trabalho.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Metodo implements Serializable{

	private static final long serialVersionUID = -2514026986307535582L;
	private String nome;
	private String tipo;
	private String visibilidade;
	private ArrayList<String> modificadores = new ArrayList<>();
	private ArrayList<Parametro> parametros = new ArrayList<>();
	
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

	public ArrayList<Parametro> getParametros() {
		return parametros;
	}

	public void setParametros(ArrayList<Parametro> parametros) {
		this.parametros = parametros;
	}
	
	public String toString() {
		String conc = "";
		for(String mod : modificadores) {
			conc = conc + " " + mod;
		}
		String param = "";
		for(int i = 0; i < parametros.size(); i++) {
			if(i == (parametros.size() - 1)) {
				param = param + " " + parametros.get(i);
			}
			else {
				param = param + " " + parametros.get(i) + ", ";
			}
		}
		return (visibilidade + " " + conc + " " + tipo + " " + nome + "(" + param + ")");
	}
	
}
