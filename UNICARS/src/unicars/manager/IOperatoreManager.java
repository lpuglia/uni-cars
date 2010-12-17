package unicars.manager;

import unicars.bean.Operatore;
import java.util.ArrayList;

public interface IOperatoreManager {
	public ArrayList<Operatore> listaOperatori();
	public Operatore cercaOperatore(String username);
}
