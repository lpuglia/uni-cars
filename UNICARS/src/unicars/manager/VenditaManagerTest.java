package unicars.manager;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import unicars.bean.Appuntamento;
import unicars.bean.Vendita;

public class VenditaManagerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVenditaManager() {
		
	}

	@Test
	public void testListaVendite() {
		VenditaManager vm = new VenditaManager();
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
	public void testCercaVendita() {
		VenditaManager vm = new VenditaManager();
		Vendita v = null;
		v = vm.cercaVendita("0001");
		assertTrue(v.getCodice().equals("0001"));
	}

	@Test
	public void testInserisciVendita() {
		VenditaManager vm = new VenditaManager();
		Vendita v = new Vendita("0004", "MARTRAD16T145J", "W", "18/01/2011", "");
		assertEquals(vm.cercaVendita("0004"), VenditaManager.VENDITA_VUOTO);
		assertTrue(vm.inserisciVendita(v));
		assertTrue(vm.cercaVendita("0004").getCodice().equals(v.getCodice()));
	}

	@Test
	public void testModificaVendita() {
		VenditaManager vm = new VenditaManager();
		Vendita v = vm.cercaVendita("0001");
		assertTrue(v.getData().equals("15/01/2011"));
		v.setStato(2);
		assertTrue(am.modificaAppuntamento(a));
		a = am.cercaAppuntamento("0001");
		assertEquals(a.getStato(), 2);
	}

	@Test
	public void testEliminaVendita() {
		fail("Not yet implemented");
	}

}
