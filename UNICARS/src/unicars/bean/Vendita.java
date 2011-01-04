package unicars.bean;

/**
 * Classe Bean che gestisce i dati relativi all'entita' Vendita
 * I metodi get e set servono per avere il valore e settare un nuovo valore per le variabili indicate
 *
 * @author Gianluigi Avella
 */

public class Vendita {
	
	private int codice = -1;
	private String codFis = "";
	private String telaio = "";
	private String data = "";
	private String note = "";
	
	public Vendita() {
		super();
	}

	public Vendita(int codice, String codFis, String telaio,
			String data, String note) {
		super();
		this.codice = codice;
		this.codFis = codFis;
		this.telaio = telaio;
		this.data = data;
		this.note = note;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
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
