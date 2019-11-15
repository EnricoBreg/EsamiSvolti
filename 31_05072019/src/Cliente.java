
import java.util.*;

public class Cliente {

	private String nominativo;
	private List<Noleggio> listaNoleggi;
	
	public Cliente(String nominativo) {
		this.nominativo = nominativo;
		listaNoleggi = new LinkedList<Noleggio>();
	}
	
	public void addNoleggio(Noleggio n) {
		listaNoleggi.add(n);
	}
	
	private double getMax() {
		
		double max = 0.0;
		for (Noleggio n : listaNoleggi) {
			if(n.getCosto() > max)
				max = n.getCosto();
		}
		return max;
	}
	
	public List<Noleggio> getNoleggi(){
		return listaNoleggi;
	}
	
	public String toString() {
		return nominativo + " " + getMax() + " " + listaNoleggi.size();
	}

}
