package composite;

import java.util.ArrayList;
import java.util.List;

public class Diagrama extends ElementoComposto{

	
	@Override
	public String desenha() {
		String saida = super.desenha();
		//desenha o diagrama
		System.out.println("Desenha o diagrama");
		return saida + "Desenha o diagrama\n";
	}


}
