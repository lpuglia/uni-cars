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
		//EC034 - stringa composta di sole lettere <= 30
		//EC035 - qualsiasi altro tipo di stringa
		//EC036 - null
		
		//test EC034
		assertTrue(sim.segnalaInteresse("Danilo", "Grieco", "12345", "CD003EF"));
		a = am.cercaAppuntamento(4);
		assertEquals(a.getNome(), "Danilo");
		assertEquals(a.getCognome(), "Grieco");
		assertEquals(a.getContatto(), "12345");
		
		//test EC035
		assertFalse(sim.segnalaInteresse("234tyrhg", "Grieco", "12345", "CD003EF"));
		
		//test EC036
		assertFalse(sim.segnalaInteresse(null, "Grieco", "12345", "CD003EF"));
		
		//classi equivalenza per cognome:
		//EC037 - stringa composta di sole lettere <= 30
		//EC038 - qualsiasi altro tipo di stringa
		//EC039 - null
		
		//il test per EC037 è stato già effettuato nel test EC034
		
		//test EC038
		assertFalse(sim.segnalaInteresse("Danilo", "6g4tf.55", "12345", "CD003EF"));
		
		//EC039
		assertFalse(sim.segnalaInteresse("Danilo", null, "12345", "CD003EF"));

		//classi equivalenza per contatto:
		//EC040 - qualsiasi stringa alfanumerica inclusi gli spazi
		//EC041 - qualsiasi altro tipo di stringa
		//EC042 - null
		
		//il test per EC040 è stato già effettuato nel test EC034
		
		//test EC041
		assertFalse(sim.segnalaInteresse("Danilo", "Grieco", "21eFRG$&£/", "CD003EF"));
		
		//test EC042
		assertFalse(sim.segnalaInteresse("Danilo", "Grieco", null, "CD003EF"));

		//Classi di equivalenza per il campo descrizione (assume i valori di una targa):
		//EC043 - Stringa alfanumerica di 8 caratteri
		//EC044 - Qualsiasi altro tipo di stringa
		//EC045 - null
		
		//il test per EC043 è stato già effettuato nel test EC034
		
		//test EC044
		assertFalse(sim.segnalaInteresse("Danilo", "Grieco", "12345", "435g34£$%"));
		
		//test EC045
		assertFalse(sim.segnalaInteresse("Danilo", "Grieco", "12345", null));


	}

}
