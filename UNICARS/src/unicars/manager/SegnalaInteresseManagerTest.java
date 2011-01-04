package unicars.manager;

import static org.junit.Assert.*;
import org.junit.Test;
import unicars.bean.Appuntamento;

public class SegnalaInteresseManagerTest {

	@Test
	public void testSegnalaInteresse() {
		SegnalaInteresseManager sim = new SegnalaInteresseManager();
		AppuntamentoManager am = new AppuntamentoManager();
		Appuntamento a;
		//classi equivalenza per nome:
		//EC036 - stringa composta di sole lettere <= 30
		//EC037 - qualsiasi altro tipo di stringa
		//EC038 - null
		
		//test EC036
		assertEquals(am.cercaAppuntamento(4), AppuntamentoManager.APPUNTAMENTO_VUOTO);
		assertTrue(sim.segnalaInteresse("Danilo", "Grieco", "12345", "CD003EF"));
		a = am.cercaAppuntamento(4);
		assertEquals(a.getNome(), "Danilo");
		assertEquals(a.getCognome(), "Grieco");
		assertEquals(a.getContatto(), "12345");
		
		//test EC037
		assertFalse(sim.segnalaInteresse("234tyrhg", "Grieco", "12345", "CD003EF"));
		
		//test EC038
		assertFalse(sim.segnalaInteresse(null, "Grieco", "12345", "CD003EF"));
		
		//classi equivalenza per cognome:
		//EC039 - stringa composta di sole lettere <= 30
		//EC040 - qualsiasi altro tipo di stringa
		//EC041 - null
		
		//il test per EC039 è stato già effettuato nel test EC036
		
		//test EC040
		assertFalse(sim.segnalaInteresse("Danilo", "6g4tf.55", "12345", "CD003EF"));
		
		//EC041
		assertFalse(sim.segnalaInteresse("Danilo", null, "12345", "CD003EF"));

		//classi equivalenza per contatto:
		//EC042 - qualsiasi stringa alfanumerica inclusi gli spazi
		//EC043 - qualsiasi altro tipo di stringa
		//EC044 - null
		
		//il test per EC042 è stato già effettuato nel test EC036
		
		//test EC043
		assertFalse(sim.segnalaInteresse("Danilo", "Grieco", "21eFRG$&£/", "CD003EF"));
		
		//test EC044
		assertFalse(sim.segnalaInteresse("Danilo", "Grieco", null, "CD003EF"));

		//Classi di equivalenza per il campo descrizione (assume i valori di una targa):
		//EC045 - Stringa alfanumerica di 8 caratteri
		//EC046 - Qualsiasi altro tipo di stringa
		//EC047 - null
		
		//il test per EC045 è stato già effettuato nel test EC036
		
		//test EC046
		assertFalse(sim.segnalaInteresse("Danilo", "Grieco", "12345", "435g34£$%"));
		
		//test EC047
		assertFalse(sim.segnalaInteresse("Danilo", "Grieco", "12345", null));


	}

}
