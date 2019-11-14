
public class Menu {
	
	
	private float prezzo, costoMaterie;
	private String descrizione,tipo;
	
	public Menu( String descrizione, String tipo, float prezzo, float costoMaterie) {
		// TODO Auto-generated constructor stub
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.prezzo = prezzo;
		this.costoMaterie = costoMaterie;
	}

	public String getDescrizione() {
		return descrizione;
	}
	
	public String toString() {
		return descrizione + " " + prezzo + "-" + costoMaterie;
	}

	public float getPrezzo() {
		// TODO Auto-generated method stub
		return prezzo;
	}
}
