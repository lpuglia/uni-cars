package unicars.bean;

/**
 * @author Gianluigi Avella
 * Classe Bean che gestisce i dati relativi all'entità Vendita
 * I metodi get e set servono per avere il valore e settare un nuovo valore per le variabili indicate
 */

public class Vendita {
	
	private String codice = "";
	private String codFis = "";
	private String telaio = "";
	private int stato = -1;
	private String data = "";
	private String note = "";
	
	public Vendita() {
		super();
	}

	public Vendita(String codice, String codFis, String telaio, int stato,
			String data, String note) {
		super();
		this.codice = codice;
		this.codFis = codFis;
		this.telaio = telaio;
		this.stato = stato;
		this.data = data;
		this.note = note;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getCodFis() {
		return codFis;
	}

	public void setCodFis(String codFis) {
		this.codFis = codFis;
	}

	public String getTelaio() {
		return telaio;
	}

	public void setTelaio(String telaio) {
		this.telaio = telaio;
	}

	public int getStato() {
		return stato;
	}

	public void setStato(int stato) {
		this.stato = stato;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
	
}
