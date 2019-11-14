package composite;

public class Classe extends ElementoComposto{
	
	@Override
	public String desenha() {
		String saida = super.desenha();
		//código para desenhar a própria classe (borda, delimitadores, etc)
		System.out.println("Desenhou classe");
		return saida + "Desenhou classe\n";
	}
	
	@Override
	public void addFilho(Elemento e) {
		if(e instanceof Atributo || e instanceof Metodo)
			super.addFilho(e);
		else
			throw new IllegalArgumentException("Filho de tipo inválido!");
	}

}
