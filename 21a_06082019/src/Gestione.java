import java.util.*;
import java.io.*;

public class Gestione {

	public static void main(String[] args) {
		
		List<Ristorante> listaRistoranti = new LinkedList<Ristorante>();
		
		Map<Integer, Ristorante> codRist = new HashMap<Integer, Ristorante>();
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("ristoranti.txt"));
			
			String str = br.readLine();
			while(str != null) {
				StringTokenizer tok = new StringTokenizer(str);
				int codice = Integer.parseInt(tok.nextToken());
				String tipo = tok.nextToken();
				String nome = br.readLine();
				if(tipo.equals("pub")) {
					str = br.readLine();
					tok = new StringTokenizer(str);
					int numDipendenti = Integer.parseInt(tok.nextToken());
					int numTavoli = Integer.parseInt(tok.nextToken());
					
					Ristorante r = new Pub(codice,tipo,nome,numDipendenti,numTavoli);
					listaRistoranti.add(r);
					codRist.put(codice, r);
				}
				else if(tipo.equals("osteria")) {
					str = br.readLine();
					tok = new StringTokenizer(str);
					int numPosti = Integer.parseInt(tok.nextToken());
					double superficie = Double.parseDouble(tok.nextToken());
					boolean disabili = Boolean.parseBoolean(tok.nextToken());
					
					Ristorante r = new Osteria(codice,tipo,nome,numPosti,superficie,disabili);
					listaRistoranti.add(r);
					codRist.put(codice, r);
				}
				str = br.readLine();
			}
			
		}
		catch (IOException ex)
		{
			System.err.println(ex);
		}
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("menu.txt"));
			String str = br.readLine();
			
			while(str != null) {
				int codice = Integer.parseInt(str);
				String descrizione = br.readLine();
				str = br.readLine();
				StringTokenizer tok = new StringTokenizer(str);
				String tipo = tok.nextToken();
				float prezzo = Float.parseFloat(tok.nextToken());
				float costoMaterie = Float.parseFloat(tok.nextToken());
				
				Menu m = new Menu(descrizione,tipo,prezzo,costoMaterie);
				Ristorante r = codRist.get(codice);
				r.addElemento(m);
				
				str = br.readLine(); // lettura della riga vuota
				str = br.readLine();
				}
				
		}
		catch (IOException e)
		{
			System.err.println(e);
		}
		
		// stampa dei ristoranti
		System.out.println("nome, codice, tipo, n. dipendenti, n. tavoli, n. posti,\n" + 
				"superficie, bagno disabili");
		for (Ristorante r : listaRistoranti) {
			System.out.println(r);
		}
		System.out.println();
		// stampa dei menu
		for (Ristorante r : listaRistoranti) {
			System.out.println(r.getNome());
			List<Menu> menu = r.getMenu();
			System.out.println("\t"+menu);
		}
		
		// ricerca del ristorante più caro
		float max;
		String ristCaro = null;
		for (Ristorante r : listaRistoranti) {
			max = 0;
			if(max < r.getMedia()) {
				max = r.getMedia();
				ristCaro = r.getNome();
			}
		}
		System.out.println("\nIl locale con il menu più caro è "+ ristCaro);
	}

}
