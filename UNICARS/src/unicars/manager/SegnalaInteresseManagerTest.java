package unicars.manager;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import unicars.bean.Appuntamento;

public class SegnalaInteresseManagerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSegnalaInteresseManager() {
	}

	@Test
	public void testSegnalaInteresse() {
		SegnalaInteresseManager sim = new SegnalaInteresseManager();
		AppuntamentoManager am = new AppuntamentoManager();
		Appuntamento a = new Appuntamento();
		assertTrue(sim.segnalaInteresse("Danilo", "Grieco", "12345"));
		a = am.cercaAppuntamento(5);
		assertEquals(a.getNome(), "Danilo");
		assertEquals(a.getCognome(), "Grieco");
		assertEquals(a.getContatto(), "12345");
	}

}
