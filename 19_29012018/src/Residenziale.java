
public class Residenziale extends Cliente {

	private String nome, cognome, indirizzo;
	
	public Residenziale(String tipoCliente, int codice, String nome, String cognome, String tipoContratto,
			String indirizzo) {
		super(tipoCliente,codice,tipoContratto);
		this.cognome = cognome;
		this.nome = nome;
		this.indirizzo = indirizzo;
	}
	
	public String getNominativo() {
		return nome + " " + cognome;
	}
	
	public String toString() {
		return super.toString() + " " + nome + " " + cognome + "\t- " + indirizzo + " " + super.getTipoContratto() + "\t-";
	}

}
