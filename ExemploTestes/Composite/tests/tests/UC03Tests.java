package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import composite.Atributo;
import composite.Classe;
import composite.Metodo;

class UC03Tests {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCriarClasse() {
		
		Classe c = new Classe();
		Atributo a = new Atributo();
		Atributo b = new Atributo();
		Metodo m = new Metodo();
		c.addFilho(a);
		c.addFilho(b);
		c.addFilho(m);
		
		String s = c.desenha();
	
		//realiza as asserções
		//aqui está simplificado, estas asserções podem
		//ser diferentes nos casos de teste de vocês
		
		assertTrue(s.contains("classe"));
		assertTrue(s.contains("atributo"));
		assertTrue(s.contains("método"));
		
	}

}
