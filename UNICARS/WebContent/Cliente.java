package unicars.bean;

/**
 * @author Gianluigi Avella
 * Classe Bean che gestisce i dati relativi all'entità Cliente
 * I metodi get e set servono per avere il valore e settare un nuovo valore per le variabili indicate
 */

public class Cliente {
	
	private String nome = "";
	private String cognome = "";
	private String dataNascita = "";
	private String luogoNascita = "";
	private String codFis = "";
	private String indirizzo = "";
	private String email = "";
	private String telefono = "";

	public Cliente() {
		super();
		
	}

	public Cliente(String nome, String cognome, String dataNascita,
			String luogoNascita, String codFis, String indirizzo, String email,
			String telefono) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.codFis = codFis;
		this.indirizzo = indirizzo;
		this.email = email;
		this.telefono = telefono;
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

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getCodFis() {
		return codFis;
	}

	public void setCodFis(String codFis) {
		this.codFis = codFis;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
}
