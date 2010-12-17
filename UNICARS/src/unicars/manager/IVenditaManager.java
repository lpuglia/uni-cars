package unicars.manager;

import unicars.bean.Vendita;
import java.util.ArrayList;

public interface IVenditaManager {
	public ArrayList<Vendita> listaVendite();
	public Vendita cercaVendita(String codice);
	
	public boolean inserisciVendita(Vendita v);
	public boolean modificaVendita(Vendita v);
	public boolean eliminaVendita(String codice);
}
