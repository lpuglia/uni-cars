package unicars.manager;

import static org.junit.Assert.*;
import org.junit.Test;
import unicars.bean.Appuntamento;

public class SegnalaInteresseManagerTest {

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
