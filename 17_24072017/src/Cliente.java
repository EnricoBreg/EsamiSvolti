
import java.util.*;

public class Cliente {

	private String tipo;
	private int codiceCliente;
	
	public Cliente(String tipo, int codiceCliente) {
		this.tipo = tipo;
		this.codiceCliente = codiceCliente;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public int getCodiceCliente() {
		return codiceCliente;
	}
	
}
