package composite;

import java.util.ArrayList;
import java.util.List;

public abstract class ElementoComposto extends Elemento{

	private List<Elemento> filhos;
	
	public ElementoComposto() {
		this.filhos = new ArrayList<Elemento>();
	}
	
	@Override
	public String desenha() {
		String saida = "";
		for (Elemento elemento : filhos) {
			saida += elemento.desenha();
		}
		return saida;
	}
	
	public void addFilho(Elemento e) {
		filhos.add(e);
	}

}
