package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.cefet.trabalho.view.DiagramCreation;
import br.edu.cefet.trabalho.view.MenuView;

public class UC01Tests {

	

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
	void testarCriarDiagrama() {
		
		MenuView view = new MenuView();
		DiagramCreation dc = new DiagramCreation(view); 
		dc.
		dc.criarDiagrama();
		
	}
}
