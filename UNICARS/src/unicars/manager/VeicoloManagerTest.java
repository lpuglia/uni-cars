package unicars.manager;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import unicars.bean.Veicolo;

public class VeicoloManagerTest {

	@Test
	public void testListaVeicoli() {
		//Dato che questo metodo non richiede dati di input in questo test 
		//si verifica il solo corretto funzionamento del metodo 
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
		//Classi di equivalenza per il campo targa:
		//EC048 - Stringa alfanumerica di 8 caratteri
		//EC049 - Qualsiasi altro tipo di stringa
		//EC050 - null
		
		//test EC048
		v = vm.cercaVeicolo("GH004TY");
		assertEquals(v.getTelaio(), "W");
		
		//test EC049
		v = vm.cercaVeicolo("stringa non valid@");
		assertEquals(v, VeicoloManager.VEICOLO_VUOTO);
		
		//test EC050
		v = vm.cercaVeicolo(null);
		assertEquals(v, VeicoloManager.VEICOLO_VUOTO);
	}
}
