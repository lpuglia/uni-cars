package unicars.manager;

import unicars.bean.Veicolo;
import java.util.ArrayList;

public interface IVeicoloManager {
	public ArrayList<Veicolo> listaVeicoli();
	public Veicolo cercaVeicolo(String targa);
}
