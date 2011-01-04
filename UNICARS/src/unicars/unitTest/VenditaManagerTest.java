package unicars.unitTest;

/**
 * Classe di test per la classe VenditaManager
 * NOTA: per l'esecuzione della classe di test il database deve trovarsi nella sua istanza iniziale
 * ripristinato tramite l'esecuzione della classe PoplaDB contenuto nel package unicars.stub
 * 
 * @author Michele Fratello
 */

import static org.junit.Assert.*;
import org.junit.Test;
import unicars.bean.Vendita;
import unicars.manager.VenditaManager;

public class VenditaManagerTest {

	@Test
	public void testModificaVendita() {
		VenditaManager vm = new VenditaManager();
		Vendita v;
		
		//TC026 - testModificaVenditaCodiceNotOK
		v = vm.cercaVendita(1);
		v.setCodice(-1);
		assertFalse(vm.modificaVendita(v));
		
		//TC027 - testModificaVenditaOK
		v = vm.cercaVendita(1);
		assertEquals(v.getTelaio(), "Y");
		v.setTelaio("W");
		assertTrue(vm.modificaVendita(v));
		v = vm.cercaVendita(1);
		assertEquals(v.getTelaio(), "W");
		
		//TC028 - testModificaVenditaCodFisNotOK
		v = vm.cercaVendita(1);
		v.setCodFis("stringa non valid@!");
		assertFalse(vm.modificaVendita(v));
		
		//TC029 - testModificaVenditaCodFisNull
		v = vm.cercaVendita(1);
		v.setCodFis(null);
		assertFalse(vm.modificaVendita(v));
		
		//TC030 - testModificaVenditaTelaioNotOK
		v = vm.cercaVendita(1);
		v.setTelaio("stringa non valid@!");
		assertFalse(vm.modificaVendita(v));
		
		//TC031 - testModificaVenditaTelaioNull
		v = vm.cercaVendita(1);
		v.setTelaio(null);
		assertFalse(vm.modificaVendita(v));
		
		//TC032 - testModificaVenditaDataNotOK
		v = vm.cercaVendita(1);
		v.setData("asdasdasd");
		assertFalse(vm.modificaVendita(v));
		
		//TC033 - testModificaVenditaDataNull
		v = vm.cercaVendita(1);
		v.setData(null);
		assertFalse(vm.modificaVendita(v));
		
		//TC034 - testModificaVenditaNoteNotOK
		v = vm.cercaVendita(1);
		v.setNote("asd!$-V-%V");
		assertFalse(vm.modificaVendita(v));
		
		//TC035 - testModificaVenditaNoteNull
		v = vm.cercaVendita(1);
		v.setNote(null);
		assertFalse(vm.modificaVendita(v));
	}
}
