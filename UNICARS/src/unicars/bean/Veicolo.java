package unicars.bean;

/**
 * Classe Bean che gestisce i dati relativi all'entita' Veicolo
 * I metodi get e set servono per avere il valore e settare un nuovo valore per le variabili indicate
 *
 * @author Gianluigi Avella
 */

public class Veicolo {
	
	private String tipo = "";
	private String targa = "";
	private String telaio = "";
	private String marca = "";
	private String modello = "";
	private String allestimento = "";
	private Double prezzoA = 0.0;
	private Double prezzoV = 0.0;
	private String colore = "";
	
	public Veicolo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Veicolo(String tipo, String targa, String telaio, String marca,
			String modello, String allestimento, Double prezzoA,
			Double prezzoV, String colore) {
		super();
		this.tipo = tipo;
		this.targa = targa;
		this.telaio = telaio;
		this.marca = marca;
		this.modello = modello;
		this.allestimento = allestimento;
		this.prezzoA = prezzoA;
		this.prezzoV = prezzoV;
		this.colore = colore;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getTelaio() {
		return telaio;
	}

	public void setTelaio(String telaio) {
		this.telaio = telaio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getAllestimento() {
		return allestimento;
	}

	public void setAllestimento(String allestimento) {
		this.allestimento = allestimento;
	}

	public Double getPrezzoA() {
		return prezzoA;
	}

	public void setPrezzoA(Double prezzoA) {
		this.prezzoA = prezzoA;
	}

	public Double getPrezzoV() {
		return prezzoV;
	}

	public void setPrezzoV(Double prezzoV) {
		this.prezzoV = prezzoV;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	
}
