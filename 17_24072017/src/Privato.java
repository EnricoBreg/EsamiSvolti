
public class Privato extends Cliente {
	
	private String nominativo, indirizzo, codiceFiscale;
	
	public Privato(String tipo, String nominativo, String indirizzo, String codiceFiscale, int codiceCliente) {
		super(tipo,codiceCliente);
		this.nominativo = nominativo;
		this.indirizzo = indirizzo;
		this.codiceFiscale = codiceFiscale;
	}
	
	public String toString() {
		return nominativo + " " + indirizzo + " " + codiceFiscale + "\t-\t- ";
	}
	
}
