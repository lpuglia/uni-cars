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
		//classi di equivalenza per il codice:
		//EC051 - valori interi non appartenenti a [0, 999999]
		//EC052 - valori interi appartenenti a [0, 999999]
		
		//test EC051
		v = vm.cercaVendita(-1);
		assertEquals(v, VenditaManager.VENDITA_VUOTO);
		
		//test EC052
		v = vm.cercaVendita(0);
		assertEquals(v.getCodice(), 0);
	}

	@Test
	public void testInserisciVendita() {
		VenditaManager vm = new VenditaManager();
		Vendita v;
		//Classi di Equivalenza del Codice Fiscale
		//EC053 - Stringa di 16 caratteri alfanumerici definita secondo determinati criteri (maggiori info!!!)
		//EC054 - Qualsiasi altro tipo di stringa
		//EC055 - null
		
		//test EC053
		v = new Vendita(-1, "MARTRA89C14T123F", "W", "18/01/2011", "test inserimento");
		assertEquals(vm.cercaVendita(3), VenditaManager.VENDITA_VUOTO);
		assertTrue(vm.inserisciVendita(v));
		assertEquals(vm.cercaVendita(3).getCodice(), 3);
		
		//test EC054
		v = new Vendita(-1, "stringa non valid@!", "W", "18/01/2011", "test inserimento");
		assertEquals(vm.cercaVendita(4), VenditaManager.VENDITA_VUOTO);
		assertFalse(vm.inserisciVendita(v));
		
		//test EC055
		v = new Vendita(-1, null, "W", "18/01/2011", "test inserimento");
		assertEquals(vm.cercaVendita(4), VenditaManager.VENDITA_VUOTO);
		assertFalse(vm.inserisciVendita(v));
		
		//Classi di Equivalenza del Telaio
		//EC056 - stringa alfanumerica di massimo 17 caratteri (maggiori info!!!)
		//EC057 - Qualsiasi altro tipo di stringa
		//EC058 - null
		
		//il test per EC056 è stato già effettuato nel test EC053
		
		//test EC057
		v = new Vendita(-1, "MARTRA89C14T123F", "stringa non valid@!", "18/01/2011", "test inserimento");
		assertEquals(vm.cercaVendita(4), VenditaManager.VENDITA_VUOTO);
		assertFalse(vm.inserisciVendita(v));
		
		//test EC058
		v = new Vendita(-1, "MARTRA89C14T123F", null, "18/01/2011", "test inserimento");
		assertEquals(vm.cercaVendita(4), VenditaManager.VENDITA_VUOTO);
		assertFalse(vm.inserisciVendita(v));
		
		//classi equivalenza per data:
		//EC059 - stringa con formato gg/mm/aaaa
		//EC060 - qualsiasi altro tipo di stringa
		//EC061 - null
		
		//il test per EC059 è stato già effettuato nel test EC053
		
		//test EC060
		v = new Vendita(-1, "MARTRA89C14T123F", "W", "asdasdasd", "test inserimento");
		assertEquals(vm.cercaVendita(4), VenditaManager.VENDITA_VUOTO);
		assertFalse(vm.inserisciVendita(v));
		
		//test EC061
		v = new Vendita(-1, "MARTRA89C14T123F", "W", null, "test inserimento");
		assertEquals(vm.cercaVendita(4), VenditaManager.VENDITA_VUOTO);
		assertFalse(vm.inserisciVendita(v));
		
		//classi equivalenza per descrizione:
		//EC062 - qualsiasi stringa alfanumerica inclusi gli spazi
		//EC063 - qualsiasi altro tipo di stringa
		//EC064 - null
		
		//il test per EC062 è stato già effettuato nel test EC053
		
		//test EC063
		v = new Vendita(-1, "MARTRA89C14T123F", "W", "18/01/2011", "asd!$£V£%V");
		assertEquals(vm.cercaVendita(4), VenditaManager.VENDITA_VUOTO);
		assertFalse(vm.inserisciVendita(v));
		
		//test EC064
		v = new Vendita(-1, "MARTRA89C14T123F", "W", "18/01/2011", null);
		assertEquals(vm.cercaVendita(4), VenditaManager.VENDITA_VUOTO);
		assertFalse(vm.inserisciVendita(v));
	}

	@Test
	public void testModificaVendita() {
		//Dato che le classi di equivalenza degli input di questo metodo sono esattamente le stesse
		//del metodo inserisciVendita ad eccezione del codice che in questo caso deve essere validato
		//in questo test si verificano solo tali classi
		VenditaManager vm = new VenditaManager();
		Vendita v;
		
		//classi di equivalenza per il codice:
		//EC065 - valori interi non appartenenti a [0, 999999]
		//EC066 - valori interi appartenenti a [0, 999999]
		
		//test EC065
		v = vm.cercaVendita(0);
		v.setCodice(-1);
		assertFalse(vm.modificaVendita(v));
		
		//test EC066
		v = vm.cercaVendita(0);
		assertEquals(v.getTelaio(), "Y");
		v.setTelaio("W");
		assertTrue(vm.modificaVendita(v));
		v = vm.cercaVendita(0);
		assertEquals(v.getTelaio(), "W");
	}

	@Test
	public void testEliminaVendita() {
		//Dato che le classi di equivalenza dell input di questo metodo sono esattamente le stesse
		//del metodo cercaVendita in questo test si verifica il solo corretto funzionamento del metodo 
		//nel caso di input valido
		VenditaManager vm = new VenditaManager();
		Vendita v = vm.cercaVendita(3);
		assertNotSame(v, VenditaManager.VENDITA_VUOTO);
		assertTrue(vm.eliminaVendita(3));
		assertEquals(vm.cercaVendita(3), VenditaManager.VENDITA_VUOTO);
	}

}
