package unicars.manager;

/**
 * Caso di test per la classe VenditaManager
 * 
 * @author Michele Fratello
 */

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import unicars.bean.Vendita;

public class VenditaManagerTest {

	@Test
	public void testListaVendite() {
		//Dato che questo metodo non richiede dati di input in questo test 
		//si verifica il solo corretto funzionamento del metodo 
		VenditaManager vm = new VenditaManager();
		ArrayList<Vendita> lista = vm.listaVendite();
		
		int contatore = 0;
		int i = 0;
		for(Vendita v : lista)
		{
			assertEquals(v.getCodice(), i++);
			contatore++;
		}
		assertEquals(contatore, 3);
	}

	@Test
	public void testCercaVendita() {
		VenditaManager vm = new VenditaManager();
		Vendita v = null;
		v = vm.cercaVendita(1);
		assertTrue(v.getCodice() == 1);
	}

	@Test
	public void testInserisciVendita() {
		VenditaManager vm = new VenditaManager();
		Vendita v = new Vendita(4, "MARTRA89C14T123F", "W", "18/01/2011", "");
		assertEquals(vm.cercaVendita(4), VenditaManager.VENDITA_VUOTO);
		assertTrue(vm.inserisciVendita(v));
		assertTrue(vm.cercaVendita(4).getCodice() == v.getCodice());
	}

	@Test
	public void testModificaVendita() {
		VenditaManager vm = new VenditaManager();
		Vendita v = vm.cercaVendita(1);
		assertTrue(v.getTelaio().equals("Y"));
		v.setTelaio("W");
		assertTrue(vm.modificaVendita(v));
		v = vm.cercaVendita(1);
		assertTrue(v.getTelaio().equals("W"));
	}

	@Test
	public void testEliminaVendita() {
		VenditaManager vm = new VenditaManager();
		Vendita v = vm.cercaVendita(4);
		assertFalse(v == VenditaManager.VENDITA_VUOTO);
		assertTrue(vm.eliminaVendita(4));
		assertEquals(vm.cercaVendita(4), VenditaManager.VENDITA_VUOTO);
	}

}
