
public class Aziendale extends Cliente {

	private String ragioneSociale, indirizzo;
	private double portataMassima;
	
	public Aziendale(String tipoCliente, int codice, String ragioneSociale, double portataMassima, String tipoContratto,
			String indirizzo) {
		super(tipoCliente, codice, tipoContratto);
		this.ragioneSociale = ragioneSociale;
		this.indirizzo = indirizzo;
		this.portataMassima = portataMassima;	
	}
	
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	
	public String toString() {
		return super.toString() + "\t- " + ragioneSociale + " " + indirizzo + " " + super.getTipoContratto() + " " + portataMassima;
	}
}
