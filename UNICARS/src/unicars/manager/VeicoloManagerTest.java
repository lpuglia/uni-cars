package unicars.manager;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import unicars.bean.Veicolo;

public class VeicoloManagerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVeicoloManager() {
	}

	@Test
	public void testListaVeicoli() {
		VeicoloManager vm = new VeicoloManager();
		ArrayList<Veicolo> lista = vm.listaVeicoli();
		String array[] = new String[4];
		array[0] = "W";
		array[1] = "X";
		array[2] = "Y";
		array[3] = "Z";
		
		int contatore = 0;
		int i = 0;
		for(Veicolo v : lista)
		{
			assertEquals(v.getTelaio(), array[i++]);
			contatore++;
		}
		assertEquals(contatore, 4);
	}

	@Test
	public void testCercaVeicolo() {
		VeicoloManager vm = new VeicoloManager();
		Veicolo v = VeicoloManager.VEICOLO_VUOTO;
		v = vm.cercaVeicolo("GH004TY");
		assertEquals(v.getTelaio(), "W");
	}
}
