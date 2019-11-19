
import java.util.*;

public class Cliente {

	private String tipoCliente, tipoContratto;
	private int codice; // id cliente
	private List<Lettura> letture;
	
	public Cliente(String tipoCliente, int codice, String tipoContratto) {
		this.tipoCliente = tipoCliente;
		this.codice = codice;
		this.tipoContratto = tipoContratto;
		letture = new LinkedList<Lettura>();
	}
	
	public void addLettura(double consumo) {
		Lettura l = new Lettura(consumo);
		letture.add(l);
	}
	
	public int getId() {
		return codice;
	}
	
	public String getTipoCliente() {
		return tipoCliente;
	}	
	
	public String toString() {
		return codice + " " + tipoCliente;
	}

	public String getTipoContratto() {
		return tipoContratto;
	}

	public List<Lettura> getLetture() {
		return letture;
	}
}
