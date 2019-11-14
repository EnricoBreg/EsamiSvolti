
public class Voto {
	
	private int codiceCorso;
	private String votoConseguito;
	private String nome;
	
	public Voto(String nome, int codiceCorso, String votoConseguito) {
		this.codiceCorso = codiceCorso;
		this.votoConseguito = votoConseguito;
		this.nome = nome;
	}
	
	public float getVoto() {
		return Float.parseFloat(votoConseguito);
	}
	
	public String toString() {
		return "("+codiceCorso+","+votoConseguito+")";
	}

	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}
}
