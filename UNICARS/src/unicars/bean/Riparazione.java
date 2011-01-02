package unicars.bean;

/**
 * Classe Bean che gestisce i dati relativi all'entità Riparazione
 * I metodi get e set servono per avere il valore e settare un nuovo valore per le variabili indicate
 *
 * @author Gianluigi Avella
 */

public class Riparazione {
	
	private int codice = -1;
	private String telaio = "";
	private String descrizione = "";
	private int stato = -1;
	private String dataInizio = "";
	private String dataFine = "";

	
	public Riparazione() {
		super();
	}


	public Riparazione(int codice, String telaio, String descrizione,
			int stato, String dataInizio, String dataFine) {
		super();
		this.codice = codice;
		this.telaio = telaio;
		this.descrizione = descrizione;
		this.stato = stato;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}


	public int getCodice() {
		return codice;
	}


	public void setCodice(int codice) {
		this.codice = codice;
	}


	public String getTelaio() {
		return telaio;
	}


	public void setTelaio(String telaio) {
		this.telaio = telaio;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public int getStato() {
		return stato;
	}


	public void setStato(int stato) {
		this.stato = stato;
	}


	public String getDataInizio() {
		return dataInizio;
	}


	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}


	public String getDataFine() {
		return dataFine;
	}


	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}
	

}
