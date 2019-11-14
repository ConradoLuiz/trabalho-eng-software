package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FormularioAlunoTest {

	FormularioAluno f;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		FormularioAluno.setExecutaValidacoes(true);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		FormularioAluno.setExecutaValidacoes(false);
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testFormularioAlunoNomeIdadeValidos() {
		assertDoesNotThrow(() -> f = new FormularioAluno("Diogo", 35));
		assertNotNull(f);
	}
	
	@Test
	void testFormularioAlunoNomeVazio() {
		assertThrows(IllegalArgumentException.class,
						() -> f = new FormularioAluno("", 25));
		assertNull(f);
	}
	
	@Test
	void testFormularioAlunoNomeMaiorQueLimite() {
		assertThrows(IllegalArgumentException.class,
						() -> f = new FormularioAluno("1234567890123456789012345678901234567890", 25));
		assertNull(f);
	}
	
	@Test
	void testFormularioAlunoNomeLimiteInferiorValido() {
		assertDoesNotThrow(() -> f = new FormularioAluno("D", 25));
		assertNotNull(f);
	}
	
	@Test
	void testFormularioAlunoNomeLimiteSuperiorValidoMenosUm() {
		assertDoesNotThrow(() -> f = new FormularioAluno("12345678901234567890123456789", 25));
		assertNotNull(f);
	}
	
	@Test
	void testFormularioAlunoNomeLimiteSuperiorValido() {
		assertDoesNotThrow(() -> f = new FormularioAluno("123456789012345678901234567890", 25));
		assertNotNull(f);
	}
	
	@Test
	void testFormularioAlunoNomeLimiteSuperiorInvalido() {
		assertThrows(IllegalArgumentException.class,
						() -> f = new FormularioAluno("1234567890123456789012345678901", 25));
		assertNull(f);
	}
	
	@Test
	void testFormularioAlunoIdadeVazia() {
		assertThrows(IllegalArgumentException.class,
						() -> f = new FormularioAluno("Diogo", null));
		assertNull(f);
	}
	
	@Test
	void testFormularioAlunoIdadeMaiorQueLimite() {
		assertThrows(IllegalArgumentException.class,
						() -> f = new FormularioAluno("Diogo", 300));
		assertNull(f);
	}
	
	@Test
	void testFormularioAlunoIdadeLimiteInferiorInvalido() {
		assertThrows(IllegalArgumentException.class,
						() -> f = new FormularioAluno("Diogo", -1));
		assertNull(f);
	}
	
	@Test
	void testFormularioAlunoIdadeLimiteInferiorValido() {
		assertDoesNotThrow(() -> f = new FormularioAluno("Diogo", 0));
		assertNotNull(f);
	}
	
	@Test
	void testFormularioAlunoIdadeLimiteInferiorValidoMaisUm() {
		assertDoesNotThrow(() -> f = new FormularioAluno("Diogo", 1));
		assertNotNull(f);
	}
	
	@Test
	void testFormularioAlunoIdadeLimiteSuperiorValidoMenosUm() {
		assertDoesNotThrow(() -> f = new FormularioAluno("Diogo", 149));
		assertNotNull(f);
	}
	
	@Test
	void testFormularioAlunoIdadeLimiteSuperiorValido() {
		assertDoesNotThrow(() -> f = new FormularioAluno("Diogo", 150));
		assertNotNull(f);
	}
	
	@Test
	void testFormularioAlunoIdadeLimiteSuperiorInvalido() {
		assertThrows(IllegalArgumentException.class,
						() -> f = new FormularioAluno("Diogo", 151));
		assertNull(f);
	}
	
	

}
