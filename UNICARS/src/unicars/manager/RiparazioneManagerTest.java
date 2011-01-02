package unicars.manager;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import unicars.bean.Riparazione;

public class RiparazioneManagerTest {

	@Test
	public void testListaRiparazioni() {
		//Dato che questo metodo non richiede dati di input in questo test 
		//si verifica il solo corretto funzionamento del metodo 
		RiparazioneManager rm = new RiparazioneManager();
		ArrayList<Riparazione> lista = rm.listaRiparazioni();
		String array[] = new String[3];
		array[0] = "X";
		array[1] = "Y";
		array[2] = "Z";
		
		int contatore = 0;
		int i = 0;
		for(Riparazione r : lista)
		{
			assertEquals(r.getTelaio(), array[i++]);
			contatore++;
		}
		assertEquals(contatore, 3);
	}

	@Test
	public void testCercaRiparazione() {
		RiparazioneManager rm = new RiparazioneManager();
		Riparazione r = RiparazioneManager.RIPARAZIONE_VUOTO;
		//classi di equivalenza per il codice:
		//EC032 - valori interi appartenenti a [0, 999999]
		//EC033 - valori interi non appartenenti a [0, 999999]
		
		//test EC032
		r = rm.cercaRiparazione(1);
		assertEquals(r.getTelaio(), "Y");
		
		//test EC033
		r = rm.cercaRiparazione(-1);
		assertEquals(r, RiparazioneManager.RIPARAZIONE_VUOTO);
	}

}
