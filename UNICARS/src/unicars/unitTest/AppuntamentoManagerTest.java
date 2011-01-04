package unicars.unitTest;

/**
 * Classe di test per la classe AppuntamentoManager
 * 
 * @author Michele Fratello
 */

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import unicars.bean.Appuntamento;
import unicars.manager.AppuntamentoManager;

public class AppuntamentoManagerTest {

	@Test
	public void testCercaAppuntamento() {
		AppuntamentoManager am = new AppuntamentoManager();
		Appuntamento a = null;

		//TC001 – testCercaAppuntamentoCodiceNotOK
		a = am.cercaAppuntamento(-1);
		assertEquals(a, AppuntamentoManager.APPUNTAMENTO_VUOTO);
		
		//TC002 – testCercaAppuntamentoCodiceOK
		a = am.cercaAppuntamento(1);
		assertEquals(a.getCodice(), 1);
	}

	@Test
	public void testInserisciAppuntamento() {
		AppuntamentoManager am = new AppuntamentoManager();
		Appuntamento a;
				
		//TC003 – testInserisciAppuntamentoOK
		a = new Appuntamento("Danilo", "Grieco", -1, "04/04/2004", "16:00", "prova4", "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(4), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertTrue(am.inserisciAppuntamento(a));
		assertEquals(am.cercaAppuntamento(4).getCodice(), 4);
		
		//TC004 – testInserisciAppuntamentoNomeNotOK
		a = new Appuntamento("-sdf1sd65f13s2df1e65t-", "Grieco", -1, "04/04/2004", "16:00", "prova4", "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//TC011 – testInserisciAppuntamentoNomeNull
		a = new Appuntamento(null, "Grieco", -1, "04/04/2004", "16:00", "prova4", "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//TC005 – testInserisciAppuntamentoCognomeNotOK
		a = new Appuntamento("Danilo", "-sdf1sd3s2df1e65t-", -1, "04/04/2004", "16:00", "prova4", "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//TC012 – testInserisciAppuntamentoCognomeNull
		a = new Appuntamento("Danilo", null, -1, "04/04/2004", "16:00", "prova4", "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//TC006 – testInserisciAppuntamentoDataNotOK
		a = new Appuntamento("Danilo", "Grieco", -1, "asd123", "16:00", "prova4", "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//TC013 – testInserisciAppuntamentoDataNull
		a = new Appuntamento("Danilo", "Grieco", -1, null, "16:00", "prova4", "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//TC007 – testInserisciAppuntamentoOraNotOK
		a = new Appuntamento("Danilo", "Grieco", -1, "04/04/2004", "asd123", "prova4", "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//TC014 – testInserisciAppuntamentoOraNull
		a = new Appuntamento("Danilo", "Grieco", -1, "04/04/2004", null, "prova4", "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//TC008 – testInserisciAppuntamentoDescrizioneNotOK
		a = new Appuntamento("Danilo", "Grieco", -1, "04/04/2004", "16:00", "stringa!-.-", "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//TC015 – testInserisciAppuntamentoDescrizioneNull
		a = new Appuntamento("Danilo", "Grieco", -1, "04/04/2004", "16:00", null, "Via xyz 11", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//TC009 – testInserisciAppuntamentoContattoNotOK
		a = new Appuntamento("Danilo", "Grieco", -1, "04/04/2004", "16:00", "prova4", "", 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//TC016 – testInserisciAppuntamentoContattoNull
		a = new Appuntamento("Danilo", "Grieco", -1, "04/04/2004", "16:00", "prova4", null, 0);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
		
		//TC010 – testInserisciAppuntamentoStatoNotOK
		a = new Appuntamento("Danilo", "Grieco", -1, "04/04/2004", "16:00", "prova4", "Via xyz 11", -7);
		assertEquals(am.cercaAppuntamento(5), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertFalse(am.inserisciAppuntamento(a));
	}
}
