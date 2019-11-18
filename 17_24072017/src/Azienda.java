
public class Azienda extends Cliente {

	private String ragioneSociale, indirizzo;
	private int partitaIva;
	
	public Azienda(String tipo, String ragioneSociale, int partitaIva, String indirizzo, int codiceCliente) {
		super(tipo, codiceCliente);
		this.ragioneSociale = ragioneSociale;
		this.indirizzo = indirizzo;
		this.partitaIva = partitaIva;
	}
	
	public String toString() {
		return "\t- " + indirizzo + "\t- " + ragioneSociale + " " + partitaIva; 
	}

}
