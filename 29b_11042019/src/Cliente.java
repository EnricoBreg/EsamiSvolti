
import java.util.*;

public class Cliente {

	private int codiceCliente;
	private String nominativo;
	private List<Servizio> servizi;
	
	public Cliente(int codiceCliente, String nominativo) {
		this.codiceCliente = codiceCliente;
		this.nominativo = nominativo;
		servizi = new LinkedList<Servizio>();
	}
	
	public void addServizio(Servizio s) {
		servizi.add(s);
	}
	
	public String toString() {
		return nominativo + " " + servizi;
	}

}
