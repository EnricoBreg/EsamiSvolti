
public class Prodotto {

	private String descrizione;
	private int qtaVenduta, prezzo;
	
	public Prodotto(String descrizione, int qtaVenduta, int prezzo) {
		this.descrizione = descrizione;
		this.qtaVenduta = qtaVenduta;
		this.prezzo = prezzo;
	}
	
	public String toString() {
		return descrizione+" "+qtaVenduta+" "+getTotale();
	}

	private int getTotale() {
		return qtaVenduta*prezzo;
	}

	public String getDescrizione() {
		return descrizione;
	}

}
