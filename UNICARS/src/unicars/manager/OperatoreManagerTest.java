package unicars.manager;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import unicars.bean.Operatore;

public class OperatoreManagerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOperatoreManager() {
	}

	@Test
	public void testListaOperatori() {
		OperatoreManager om = new OperatoreManager();
		ArrayList<Operatore> lista = om.listaOperatori();
		String array[] = new String[3];
		array[0] = "marco";
		array[1] = "phantom";
		array[2] = "thephilantropist";
		
		int contatore = 0;
		int i = 0;
		for(Operatore o : lista)
		{
			assertTrue(o.getUsername().equals(array[i++]));
			contatore++;
		}
		assertEquals(contatore, 3);
	}

	@Test
	public void testCercaOperatore() {
		OperatoreManager om = new OperatoreManager();
		Operatore o = OperatoreManager.OPERATORE_VUOTO;
		o = om.cercaOperatore("marco");
		assertEquals(o.getUsername(), "marco");
	}

	@Test
	public void testLoginOperatore() {
		OperatoreManager om = new OperatoreManager();
		Operatore o = OperatoreManager.OPERATORE_VUOTO;
		o = om.loginOperatore("marco", "unicars");
		assertEquals("marco", o.getUsername());
		assertEquals("unicars", o.getPassword());
	}

}
