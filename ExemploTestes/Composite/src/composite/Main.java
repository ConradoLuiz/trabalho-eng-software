package composite;

public class Main {
	
	public static void main(String[] args) {
		
		Classe c = new Classe();
		Atributo a = new Atributo();
		Atributo b = new Atributo();
		Metodo m = new Metodo();
		c.addFilho(a);
		c.addFilho(b);
		c.addFilho(m);
		
		
		Classe c1 = new Classe();
		Atributo a1 = new Atributo();
		Metodo m1 = new Metodo();
		c1.addFilho(a1);
		c1.addFilho(m1);
		
		Diagrama d = new Diagrama();
		d.addFilho(c);
		d.addFilho(c1);
		
		d.desenha();
		
	}

}
