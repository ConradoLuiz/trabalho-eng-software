package main;

public class FormularioAluno {
	
	private static boolean executaValidacoes = false;
	
	//Obrigatório até 30 caracteres
	private String nome;
	
	//Obrigatório maior que zero e menor que 150
	private Integer idade;

	public FormularioAluno(String nome, Integer idade) {
		
		if(executaValidacoes == true) {
			if(nome == "") 
				throw new IllegalArgumentException("Nome deve ser preenchido");
			
			if(nome.length() > 30)
				throw new IllegalArgumentException("Nome deve ter até 30 caracteres");
			
			if(idade == null)
				throw new IllegalArgumentException("Idade deve ser preenchida");
			
			if(idade < 0 || idade > 150)
				throw new IllegalArgumentException("Idade deve ser entre um e 150");
		}
		
		this.nome = nome;
		this.idade = idade;
	}
	
	public String getNome() {
		return nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public static boolean isExecutaValidacoes() {
		return executaValidacoes;
	}

	public static void setExecutaValidacoes(boolean executaValidacoes) {
		FormularioAluno.executaValidacoes = executaValidacoes;
	}
	
	

}
