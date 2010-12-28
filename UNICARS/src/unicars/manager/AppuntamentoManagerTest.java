package unicars.manager;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import unicars.bean.Appuntamento;

public class AppuntamentoManagerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAppuntamentoManager() {
		
	}

	@Test
	public void testListaAppuntamenti() {
		AppuntamentoManager am = new AppuntamentoManager();
		ArrayList<Appuntamento> lista = am.listaAppuntamenti();
		
		int contatore = 0;
		int i = 0;
		for(Appuntamento a : lista)
		{
			assertTrue(a.getCodice() == i++);
			contatore++;
		}
		assertEquals(contatore, 4);
	}

	@Test
	public void testCercaAppuntamento() {
		AppuntamentoManager am = new AppuntamentoManager();
		Appuntamento a = null;
		a = am.cercaAppuntamento(1);
		assertTrue(a.getCodice() == 1);
	}

	@Test
	public void testInserisciAppuntamento() {
		AppuntamentoManager am = new AppuntamentoManager();
		Appuntamento a = new Appuntamento("Danilo", "Grieco", 4, "04/04/2004", "16:00", "prova4", "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(4), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertTrue(am.inserisciAppuntamento(a));
		assertTrue(am.cercaAppuntamento(4).getCodice() == a.getCodice());
	}

	@Test
	public void testModificaAppuntamento() {
		AppuntamentoManager am = new AppuntamentoManager();
		Appuntamento a = am.cercaAppuntamento(1);
		assertTrue(a.getStato() == 0);
		a.setStato(2);
		assertTrue(am.modificaAppuntamento(a));
		a = am.cercaAppuntamento(1);
		assertEquals(a.getStato(), 2);
	}

	@Test
	public void testEliminaAppuntamento() {
		AppuntamentoManager am = new AppuntamentoManager();
		Appuntamento a=am.cercaAppuntamento(4);
		assertFalse(a.equals(AppuntamentoManager.APPUNTAMENTO_VUOTO));
		assertTrue(am.eliminaAppuntamento(4));
		assertEquals(am.cercaAppuntamento(4), AppuntamentoManager.APPUNTAMENTO_VUOTO);
	}
}
