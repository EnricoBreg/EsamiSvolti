
public class Veicolo {
	
	private int codice;
	private String tipo, targa, modello, marca;
	private double costoGiornaliero;
	
	public Veicolo(int codice, String tipo, String targa, String modello, String marca, double costoGiornaliero) {
		// TODO Auto-generated constructor stub
		this.codice = codice;
		this.tipo = tipo;
		this.targa = targa;
		this.modello = modello;
		this.marca = marca;
		this.costoGiornaliero = costoGiornaliero;
	}
	
	public double getCosto() {
		return costoGiornaliero;
	}
	
	public String getTarga() {
		return targa;
	}
	
	public String toString() {
		return tipo + " " + targa + " " + codice + " " + modello + " " + marca + " " + costoGiornaliero;
	}
}
