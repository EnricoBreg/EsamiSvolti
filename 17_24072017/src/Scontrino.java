
import java.util.*;

public class Scontrino {
	
	private int codiceScontrino;
	private String data;
	private Cliente c;
	private List<Prodotto> prodotti;
	
	public Scontrino(String data, int codiceScontrino) {
		this.data = data;
		this.codiceScontrino = codiceScontrino;
		prodotti = new LinkedList<Prodotto>();
	}

	public void addProdotto(Prodotto p) {
		prodotti.add(p);	
	}	
	
	public void setCliente(Cliente c) {
		this.c = c;
	}
	
	public Cliente getCliente() {
		return c;
	}
	
	public String toString() {
		return codiceScontrino + " " + data;
	}

	public List<Prodotto> getProdotti() {
		return prodotti;
	}
}
