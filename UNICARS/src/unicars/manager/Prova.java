package unicars.manager;

import unicars.bean.Vendita;

public class Prova {

	public static void main(String[] args) {
		AppuntamentoManager vm = new AppuntamentoManager();
		System.out.print(vm.cercaAppuntamento("0015"));
		//Vendita v = new Vendita("asd123", "ASD1231234567890", "aSdD123", "21/12/2012", "DSA");
		//vm.inserisciVendita(v); //ok
		
		//System.out.print(vm.cercaVendita("asd123")); //ok
		
		//v.setNote("modifica effettuata");
		//vm.modificaVendita(v); //ok
		
		//vm.eliminaVendita("asd123"); //ok
	}

}
