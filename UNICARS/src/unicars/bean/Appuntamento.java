package unicars.bean;

/**
 * @author Gianluigi Avella
 * Classe Bean che gestisce i dati relativi all'entità Appuntamento
 * I metodi get e set servono per avere il valore e settare un nuovo valore per le variabili indicate
 */

public class Appuntamento {
	
	private String nome = "";
	private String cognome = "";
	private String codice = "";
	private String data = "";
	private String ora = "";
	private String descrizione = "";
	private String contatto = "";
	private int stato = -1;
	
	
	public Appuntamento() {
		super();
		
	}


	public Appuntamento(String nome, String cognome, String codice,
			String data, String ora, String descrizione, String contatto,
			int stato) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codice = codice;
		this.data = data;
		this.ora = ora;
		this.descrizione = descrizione;
		this.contatto = contatto;
		this.stato = stato;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getCodice() {
		return codice;
	}


	public void setCodice(String codice) {
		this.codice = codice;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getOra() {
		return ora;
	}


	public void setOra(String ora) {
		this.ora = ora;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public String getContatto() {
		return contatto;
	}


	public void setContatto(String contatto) {
		this.contatto = contatto;
	}


	public int getStato() {
		return stato;
	}


	public void setStato(int stato) {
		this.stato = stato;
	}
	
}
