package unicars.manager;

import unicars.bean.Appuntamento;
import java.util.ArrayList;

public interface IAppuntamentoManager {
	public ArrayList<Appuntamento> listaAppuntamenti();
	public Appuntamento cercaAppuntamento(String codice);
	
	public boolean inserisciAppuntamento(Appuntamento a);
	public boolean modificaAppuntamento(Appuntamento a);
	public boolean eliminaAppuntamento(String codice);
}