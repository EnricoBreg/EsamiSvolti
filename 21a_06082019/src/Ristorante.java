import java.util.*;

public class Ristorante {

	private int codice;
	private String tipo, nome;
	private List<Menu> menu;
	
	public Ristorante(int codice, String tipo, String nome) {
		// TODO Auto-generated constructor stub
		this.codice = codice;
		this.tipo = tipo;
		this.nome = nome;
		menu = new LinkedList<Menu>();
	}
	
	public void addElemento(Menu m) {
		menu.add(m);
	}
	
	public int getCodice() {
		return codice;
	}
	
	public String toString() {
		return nome + "\t " + codice + "\t " + tipo+ "\t ";
	}

	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}

	public float getMedia() {
		float somma = 0;
		for (Menu m : menu) {
			somma += m.getPrezzo();
		}
		return somma / menu.size();
	}
	public List<Menu> getMenu() {
		// TODO Auto-generated method stub
		return menu;
	}

}
