
public class Partecipante {
	private int codice;
	private String nome,cognome,tipo;
	
	public Partecipante(int cod, String tipo, String nome, String cognome) {
		this.codice = cod;
		this.nome = nome;
		this.cognome = cognome;
		this.tipo = tipo;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public int getCod() {
		return codice;
	}
	
	
	public String toString() {
		return tipo + " " + codice + " " + nome + " " + cognome + " ";
	}
}
