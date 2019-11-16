
import java.util.*;

public class Iscritto {

	private String tipo;
	private int id;
	private List<Iscritto> listaSeguaci;
	
	public Iscritto(String tipo, int id) {
		this.tipo = tipo;
		this.id = id;
		listaSeguaci = new LinkedList<Iscritto>();
	}
	
	public void addSeguace(Iscritto i) {
		listaSeguaci.add(i);
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public int getID() {
		return id;
	}
	
	public int getNumeroSeguaci() {
		return listaSeguaci.size();
	}
	
	
	public String toString() {
		return id + " ";
	}
}
