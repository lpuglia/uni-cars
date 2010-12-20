package unicars.utility;

/**
 * @author Gianluigi Avella
 * Classe Bean di utilità che restituisce il giusto messaggio a seconda degli esiti delle azioni fatte dall'utente
 * I metodi get e set servono per avere il valore e settare un nuovo valore per le variabili indicate
 */
public class Messaggio {
	
	private String messaggio;

	public Messaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
}