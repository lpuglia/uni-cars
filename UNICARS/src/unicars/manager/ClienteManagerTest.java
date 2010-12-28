package unicars.manager;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import unicars.bean.Cliente;

public class ClienteManagerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testClienteManager() {
	}

	@Test
	public void testListaClienti() {
		ClienteManager cm = new ClienteManager();
		ArrayList<Cliente> lista = cm.listaClienti();
		String array[] = new String[5];
		array[0] = "DANGRI89I19F654H";
		array[1] = "GIAAVE88H15O159P";
		array[2] = "LUCPUG89G01E357T";
		array[3] = "MARTRAD16T145J";
		array[4] = "MICFRA89D02A587G";
		
		int contatore = 0;
		int i = 0;
		for(Cliente c : lista)
		{
			assertTrue(c.getCodFis().equals(array[i++]));
			contatore++;
		}
		assertEquals(contatore, 5);
	}

	@Test
	public void testCercaCliente() {
		ClienteManager cm = new ClienteManager();
		Cliente c = null;
		c = cm.cercaCliente("DANGRI89I19F654H");
		assertTrue(c.getCodFis().equals("DANGRI89I19F654H"));
	}

}
