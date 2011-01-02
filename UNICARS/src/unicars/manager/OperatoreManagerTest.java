package unicars.manager;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;
import unicars.bean.Operatore;

public class OperatoreManagerTest {

	@Test
	public void testListaOperatori() {
		//Dato che questo metodo non richiede dati di input in questo test 
		//si verifica il solo corretto funzionamento del metodo 
		OperatoreManager om = new OperatoreManager();
		ArrayList<Operatore> lista = om.listaOperatori();
		String array[] = new String[3];
		array[0] = "janus";
		array[1] = "phantom";
		array[2] = "thephilantropist";
		
		int contatore = 0;
		int i = 0;
		for(Operatore o : lista)
		{
			assertEquals(o.getUsername(), array[i++]);
			contatore++;
		}
		assertEquals(contatore, 3);
	}

	@Test
	public void testCercaOperatore() {
		OperatoreManager om = new OperatoreManager();
		Operatore o = OperatoreManager.OPERATORE_VUOTO;
		//Classi di equivalenza per il campo username:
		//EC028 - stringa alfanumerica con in aggiunta i caratteri "!", "-", "_" di lunghezza compresa tra 3 e 20 caratteri
		//EC029 - qualsiasi altro tipo di stringa
		//EC030 - null
		
		//test EC028
		o = om.cercaOperatore("janus");
		assertEquals(o.getUsername(), "janus");
		
		//test EC029
		o = om.cercaOperatore("stringa non valid@");
		assertEquals(o, OperatoreManager.OPERATORE_VUOTO);
		
		//test EC030
		o = om.cercaOperatore(null);
		assertEquals(o, OperatoreManager.OPERATORE_VUOTO);
	}

	@Test
	public void testLoginOperatore() {
		OperatoreManager om = new OperatoreManager();
		Operatore o = OperatoreManager.OPERATORE_VUOTO;
		//Dato che i controlli sull'username sono gli stessi verranno testate solo le classi di equivalenza per la password:
		//EC031 - stringa alfanumerica con in aggiunta i caratteri "!", "-", "_" di lunghezza compresa tra 6 e 20 caratteri
		//EC032 - qualsiasi altro tipo di stringa
		//EC033 - null
		
		//test EC031
		o = om.loginOperatore("janus", "unicars");
		assertEquals("janus", o.getUsername());
		assertEquals("unicars", o.getPassword());
		
		//test EC032
		o = om.loginOperatore("janus", "123");
		assertEquals(o, OperatoreManager.OPERATORE_VUOTO);
		
		//test EC033
		o = om.loginOperatore("janus", null);
		assertEquals(o, OperatoreManager.OPERATORE_VUOTO);
	}
}
