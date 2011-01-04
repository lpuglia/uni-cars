package unicars.unitTest;

import static org.junit.Assert.*;
import org.junit.Test;
import unicars.bean.Appuntamento;
import unicars.manager.AppuntamentoManager;
import unicars.manager.SegnalaInteresseManager;

public class SegnalaInteresseManagerTest {

	@Test
	public void testSegnalaInteresse() {
		SegnalaInteresseManager sim = new SegnalaInteresseManager();
		AppuntamentoManager am = new AppuntamentoManager();
		Appuntamento a;
		
		//TC017 – testSegnalaInteresseOK
		assertEquals(am.cercaAppuntamento(4), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertTrue(sim.segnalaInteresse("Danilo", "Grieco", "12345", "CD003EF"));
		a = am.cercaAppuntamento(4);
		assertEquals(a.getNome(), "Danilo");
		assertEquals(a.getCognome(), "Grieco");
		assertEquals(a.getContatto(), "12345");
		
		//TC018 – testSegnalaInteresseNomeNotOK
		assertFalse(sim.segnalaInteresse("234tyrhg", "Grieco", "12345", "CD003EF"));
		
		//TC019 – testSegnalaInteresseNomeNull
		assertFalse(sim.segnalaInteresse(null, "Grieco", "12345", "CD003EF"));
		
		//TC020 – testSegnalaInteresseCognomeNotOK
		assertFalse(sim.segnalaInteresse("Danilo", "6g4tf.55", "12345", "CD003EF"));
		
		//TC021 – testSegnalaInteresseCognomeNull
		assertFalse(sim.segnalaInteresse("Danilo", null, "12345", "CD003EF"));

		//TC022 – testSegnalaInteresseDescrizioneNotOK
		assertFalse(sim.segnalaInteresse("Danilo", "Grieco", "21eFRG$&£/", "CD003EF"));
		
		//TC023 – testSegnalaInteresseDescrizioneNull
		assertFalse(sim.segnalaInteresse("Danilo", "Grieco", null, "CD003EF"));

		//TC024 – testSegnalaInteresseContattoNotOK
		assertFalse(sim.segnalaInteresse("Danilo", "Grieco", "12345", "435g34£$%"));
		
		//TC025 – testSegnalaInteresseContattoNull
		assertFalse(sim.segnalaInteresse("Danilo", "Grieco", "12345", null));
	}
}
