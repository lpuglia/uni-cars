package unicars.manager;

/**
 * Classe di test per la classe AppuntamentoManager
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
		//3 classi di equivalenza per l'input:
		//valori minori di 0
		//valori compresi tra 0 e 999999
		//valori maggiori di 999999
		
		//prima classe di equivalenza
		a = am.cercaAppuntamento(-1);
		assertEquals(a, null);
		
		//seconda classe di equivalenza
		a = am.cercaAppuntamento(1);
		assertEquals(a.getCodice(), 1);
		
		//terza classe di equivalenza
		a = am.cercaAppuntamento(10000000);
		assertEquals(a, null);
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
