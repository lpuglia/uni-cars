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
		//Dato che questo metodo non richiede dati di input in questo test 
		//si verifica il solo corretto funzionamento del metodo 
		
		AppuntamentoManager am = new AppuntamentoManager();
		ArrayList<Appuntamento> lista = am.listaAppuntamenti();
		
		int contatore = 0;
		int i = 1;
		for(Appuntamento a : lista)
		{
			assertEquals(a.getCodice(), i++);
			contatore++;
		}
		assertEquals(contatore, 3);
	}

	@Test
	public void testCercaAppuntamento() {
		AppuntamentoManager am = new AppuntamentoManager();
		Appuntamento a = null;
		//classi di equivalenza per il codice:
		//EC001 - valori interi non appartenenti a [0, 999999]
		//EC002 - valori interi appartenenti a [0, 999999]
		
		//test EC001
		a = am.cercaAppuntamento(-1);
		assertEquals(a, null);
		
		//test EC002
		a = am.cercaAppuntamento(1);
		assertEquals(a.getCodice(), 1);
	}

	@Test
	public void testInserisciAppuntamento() {
		AppuntamentoManager am = new AppuntamentoManager();
		Appuntamento a;
		//classi equivalenza per nome:
		//EC003 - stringa composta di sole lettere <= 30
		//EC004 - qualsiasi altro tipo di stringa
		//EC005 - null
		
		//test EC003
		a = new Appuntamento("Danilo", "Grieco", -1, "04/04/2004", "16:00", "prova4", "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(4), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertTrue(am.inserisciAppuntamento(a));
		assertEquals(am.cercaAppuntamento(4).getCodice(), 4);
		
		//test EC004
		a = new Appuntamento("df132sdf156-sdf1sd65f13s2df1e65t-1sf32sd1f", "Grieco", -1, "04/04/2004", "16:00", "prova4", "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//test EC005
		a = new Appuntamento(null, "Grieco", -1, "04/04/2004", "16:00", "prova4", "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//classi equivalenza per cognome:
		//EC006 - stringa composta di sole lettere <= 30
		//EC007 - qualsiasi altro tipo di stringa
		//EC008 - null
		
		//il test per EC006 è stato già effettuato nel test EC003
		
		////test EC007
		a = new Appuntamento("Danilo", "df132sdf156-sdf1sd3s2df1e65t-1sf32sd1f", -1, "04/04/2004", "16:00", "prova4", "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//test EC008
		a = new Appuntamento("Danilo", null, -1, "04/04/2004", "16:00", "prova4", "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//classi equivalenza per data:
		//EC009 - stringa con formato gg/mm/aaaa
		//EC0010 - qualsiasi altro tipo di stringa
		//EC0011 - null
		
		//il test per EC009 è stato già effettuato nel test EC003
		
		//test EC010
		a = new Appuntamento("Danilo", "Grieco", -1, "data non valida 123", "16:00", "prova4", "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//test EC011
		a = new Appuntamento("Danilo", "Grieco", -1, null, "16:00", "prova4", "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//classi equivalenza per ora:
		//EC012 - stringa con formato hh:mm
		//EC013 - qualsiasi altro tipo di stringa
		//EC014 - null
		
		//il test per EC012 è stato già effettuato nel test EC003
		
		//test EC013
		a = new Appuntamento("Danilo", "Grieco", -1, "04/04/2004", "ora non valida 321", "prova4", "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//test EC014
		a = new Appuntamento("Danilo", "Grieco", -1, "04/04/2004", null, "prova4", "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//classi equivalenza per descrizione:
		//EC015 - qualsiasi stringa alfanumerica inclusi gli spazi
		//EC016 - qualsiasi altro tipo di stringa
		//EC017 - null
		
		//il test per EC016 è stato già effettuato nel test EC003
		
		//test EC016
		a = new Appuntamento("Danilo", "Grieco", -1, "04/04/2004", "16:00", "stringa non valida!-.-", "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//test EC017
		a = new Appuntamento("Danilo", "Grieco", -1, "04/04/2004", "16:00", null, "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//classi equivalenza per contatto:
		//EC018 - qualsiasi stringa alfanumerica inclusi gli spazi
		//EC019 - qualsiasi altro tipo di stringa
		//EC020 - null
		
		//il test per EC018 è stato già effettuato nel test EC003
		
		//test EC019
		a = new Appuntamento("Danilo", "Grieco", -1, "04/04/2004", "16:00", "prova4", "stringa non valida!-.-", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//test EC020
		a = new Appuntamento("Danilo", "Grieco", -1, "04/04/2004", "16:00", "prova4", null, 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//classi equivalenza per stato:
		//EC021 - intero appartenente all'intervallo [0, 2]
		//EC022 - intero non appartenente all'intervallo [0,2]
		
		//il test per EC021 è stato già effettuato nel test EC03
		
		//test EC022
		a = new Appuntamento("Danilo", "Grieco", -1, "04/04/2004", "16:00", "prova4", "Via xyz 11", -7);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
	}

	@Test
	public void testModificaAppuntamento() {
		//Dato che le classi di equivalenza degli input di questo metodo sono esattamente le stesse
		//del metodo inserisciAppuntamento in questo test si verifica il solo corretto funzionamento del metodo 
		//nel caso di input validi
		AppuntamentoManager am = new AppuntamentoManager();
		Appuntamento a = am.cercaAppuntamento(1);
		assertEquals(a.getStato(), 0);
		a.setStato(2);
		assertTrue(am.modificaAppuntamento(a));
		a = am.cercaAppuntamento(1);
		assertEquals(a.getStato(), 2);
	}

	@Test
	public void testEliminaAppuntamento() {
		//Dato che le classi di equivalenza dell input di questo metodo sono esattamente le stesse
		//del metodo cercaAppuntamento in questo test si verifica il solo corretto funzionamento del metodo 
		//nel caso di input valido
		AppuntamentoManager am = new AppuntamentoManager();
		Appuntamento a = am.cercaAppuntamento(4);
		assertNotSame(a, AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertTrue(am.eliminaAppuntamento(4));
		assertEquals(am.cercaAppuntamento(4), AppuntamentoManager.APPUNTAMENTO_VUOTO);
	}
}
