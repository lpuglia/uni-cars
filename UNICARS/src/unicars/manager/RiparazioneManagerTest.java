package unicars.manager;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import unicars.bean.Riparazione;

public class RiparazioneManagerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRiparazioneManager() {
	}

	@Test
	public void testListaRiparazioni() {
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
		r = rm.cercaRiparazione(1);
		assertEquals(r.getTelaio(), "X");	
	}

}
