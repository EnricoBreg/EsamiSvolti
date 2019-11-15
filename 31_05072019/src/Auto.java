
public class Auto extends Veicolo {
	
	private double capienzaBagagliaio;
	private int cilindrata;
	private String categoria;
	
	public Auto(int codice, String tipo, String targa, String modello, String marca, double capienzaBagagliaio,
			int cilindrata, String categoria, double costoGiornaliero) {
		// TODO Auto-generated constructor stub
		super(codice,tipo,targa,modello,marca,costoGiornaliero);
		this.capienzaBagagliaio = capienzaBagagliaio;
		this.categoria = categoria;
		this.cilindrata = cilindrata;
	}

	public String toString() {
		return super.toString() + " " + capienzaBagagliaio + " " + cilindrata + " " + categoria + " " + "\t-\t-\t- ";
	}
}
