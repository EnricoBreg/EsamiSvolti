
import java.util.*;
import java.io.*;

public class Gestione {

	public static void main(String[] args) {
		
		List<Spettacolo> listaSpettacoli = new LinkedList<Spettacolo>();
		List<Iscritto> listaIscritti = new LinkedList<Iscritto>();
		Map<Integer, Spettacolo> codSpettacolo = new HashMap<Integer, Spettacolo>();
		//LETTURA DEL FILE spettacoli.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("spettacoli.txt"));
			String str = br.readLine();
			
			while(str != null) {
				String titolo = str;
				str = br.readLine();
				StringTokenizer tok = new StringTokenizer(str);
				int codice = Integer.parseInt(tok.nextToken());
				String tipo = tok.nextToken();
				
				if(tipo.equals("serie")) {
					str = br.readLine();
					tok = new StringTokenizer(str);
					int stagione = Integer.parseInt(tok.nextToken());
					int numeroPuntate = Integer.parseInt(tok.nextToken());
					String produttore = br.readLine();
					str = br.readLine();
					int annoUscita = Integer.parseInt(str);
					
					Spettacolo s = new Serie(titolo,codice,tipo,stagione,numeroPuntate,produttore,annoUscita);
					listaSpettacoli.add(s);
					codSpettacolo.put(codice, s);
				}
				
				if(tipo.equals("film")) {
					str = br.readLine();
					int durata = Integer.parseInt(str);
					String produttore = br.readLine();
					str = br.readLine();
					int annoUscita = Integer.parseInt(str);
					
					Spettacolo s = new Film(titolo,codice,tipo,durata,produttore,annoUscita);
					listaSpettacoli.add(s);
					codSpettacolo.put(codice, s);
				}
				str = br.readLine();
			}
			br.close();
		}
		catch (IOException ex)
		{
			System.err.println(ex);
		}
		
		
		// LETTURA DEL FILE visualizzazioni.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("visualizzazioni.txt"));
			String str = br.readLine();
			
			while(str != null) {
				StringTokenizer tok = new StringTokenizer(str);
				int codiceUtente = Integer.parseInt(tok.nextToken());
				String nome = tok.nextToken();
				String cognome = tok.nextToken();
				str = br.readLine();
				
				Iscritto i = new Iscritto(codiceUtente,nome,cognome);
				
				tok = new StringTokenizer(str);
				while(tok.hasMoreTokens()) {
					int codice = Integer.parseInt(tok.nextToken());
					Spettacolo s = codSpettacolo.get(codice);
					i.addVisualizzazione(s);
				}
				listaIscritti.add(i);
				str = br.readLine();
			}
			br.close();
		}
		catch(IOException ex)
		{
			System.err.println(ex);
		}
		
		
		// STAMPA DEGLI SPETTACOLI
		System.out.println("tipo, titolo, codice, stagione, n. puntate, durata, anno, produttore");
		for (Spettacolo s : listaSpettacoli) {
			System.out.println(s);
		}
		
		// PUNTO 4
		System.out.println("\nutente\tspettacoli visti");
		for(Iscritto i : listaIscritti) {
			List<Spettacolo> vis = i.getVisualizzazioni();
			System.out.println(i.getNome() + " " + i.getCognome());
			for(Spettacolo s : vis) {
				System.out.println("\t" + s.getTitolo() + " "+ s.getTipo());
			}
		}
		
		// PUNTO 5
		System.out.println();
		for (Iscritto i : listaIscritti) {
			System.out.println(i);
		}
	}
}
