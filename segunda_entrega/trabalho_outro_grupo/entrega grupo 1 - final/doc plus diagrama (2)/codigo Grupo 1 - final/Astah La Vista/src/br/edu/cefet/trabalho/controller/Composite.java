package br.edu.cefet.trabalho.controller;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component{

	private List<Component> filhos = new ArrayList<>();
	
	@Override
	public void desenha() {
		for(Component comp : filhos) {
			if(comp.isDesenhado() == false) {
				comp.desenha();
			}
		}	
	}

	public List<Component> getFilhos() {
		return filhos;
	}

	public void addFilhos(Component filho) {
		filhos.add(filho);
	}

}
