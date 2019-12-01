package br.edu.cefet.trabalho.model;
import java.io.Serializable;
import java.util.ArrayList;

public class Diagrama implements Serializable{
	
	private static final long serialVersionUID = 8934726354928479873L;
	
	private String nome;
	private ArrayList<Elemento> elementos = new ArrayList<>();
	private ArrayList<Relacionamento> relacionamentos = new ArrayList<>();
	private String imagem;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Elemento> getElementos() {
		return elementos;
	}

	public ArrayList<Relacionamento> getRelacionamentos() {
		return relacionamentos;
	}

	public void setElementos(ArrayList<Elemento> elementos) {
		this.elementos = elementos;
	}

	public void addElemento(Elemento e){
		this.elementos.add(e);
	}
	
	public void setRelacionamentos(ArrayList<Relacionamento> relacionamentos) {
		this.relacionamentos = relacionamentos;
	}
	
	public void addRelacionamento(Relacionamento r){
		this.relacionamentos.add(r);
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getImagem() {
		return imagem;
	}
	
}
