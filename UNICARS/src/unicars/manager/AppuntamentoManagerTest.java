package unicars.manager;

/**
 * Caso di test per la classe AppuntamentoManager
 * 
 * @author Michele Fratello
 */

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import unicars.bean.Appuntamento;

public class AppuntamentoManagerTest {

	@Test
	public void testListaAppuntamenti() {
		AppuntamentoManager am = new AppuntamentoManager();
		ArrayList<Appuntamento> lista = am.listaAppuntamenti();
		
		int contatore = 0;
		int i = 1;
		for(Appuntamento a : lista)
		{
			assertTrue(a.getCodice() == i++);
			contatore++;
		}
		assertEquals(contatore, 3);
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
