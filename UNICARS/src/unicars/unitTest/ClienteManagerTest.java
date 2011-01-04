package unicars.unitTest;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import unicars.bean.Cliente;
import unicars.manager.ClienteManager;

public class ClienteManagerTest {

	@Test
	public void testListaClienti() {
		//Dato che questo metodo non richiede dati di input in questo test 
		//si verifica il solo corretto funzionamento del metodo 
		ClienteManager cm = new ClienteManager();
		ArrayList<Cliente> lista = cm.listaClienti();
		String array[] = new String[5];
		array[0] = "DANGRI89A19F654H";
		array[1] = "GIAAVE88H15O159P";
		array[2] = "LUCPUG89B01E357T";
		array[3] = "MARTRA89C14T123F";
		array[4] = "MICFRA89D02A587G";
		
		int contatore = 0;
		int i = 0;
		for(Cliente c : lista)
		{
			assertEquals(c.getCodFis(), array[i++]);
			contatore++;
		}
		assertEquals(contatore, 5);
	}

	@Test
	public void testCercaCliente() {
		ClienteManager cm = new ClienteManager();
		Cliente c = null;
		//Classi di Equivalenza del Codice Fiscale
		//EC025 - Stringa di 16 caratteri alfanumerici definita secondo determinati criteri (maggiori info!!!)
		//EC026 - Qualsiasi altro tipo di stringa
		//EC027 - null
		
		//test EC025
		c = cm.cercaCliente("MICFRA89D02A587G");
		assertEquals(c.getCodFis(), "MICFRA89D02A587G");
		
		//test EC026
		c = cm.cercaCliente("non è un codice fiscale valido !!!");
		assertEquals(c, ClienteManager.CLIENTE_VUOTO);
		
		//test EC027
		c = cm.cercaCliente(null);
		assertEquals(c, ClienteManager.CLIENTE_VUOTO);
	}

}
