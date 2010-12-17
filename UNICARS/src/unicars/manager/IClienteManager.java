package unicars.manager;

import unicars.bean.Cliente;
import java.util.ArrayList;

public interface IClienteManager {
	public ArrayList<Cliente> listaClienti();
	public Cliente cercaCliente(String codFis);
}
