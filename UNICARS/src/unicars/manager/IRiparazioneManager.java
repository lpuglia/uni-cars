package unicars.manager;

import unicars.bean.Riparazione;
import java.util.ArrayList;

public interface IRiparazioneManager {
	public ArrayList<Riparazione> listaRiparazioni();
	public Riparazione cercaRiparazione(int codice);
}
