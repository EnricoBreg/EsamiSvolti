import java.io.*;
import java.util.*;

public class Gestione {

	public static void main(String[] args) {
		
		List<Partecipante> listaPartecipanti = new LinkedList<Partecipante>();
		List<Conferenza> listaConferenze = new LinkedList<Conferenza>();
		Map<Integer,Partecipante> codPart = new HashMap<Integer, Partecipante>();
		// lettura del file partcipanti.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("partecipanti.txt"));
			
			String str = br.readLine();
			while(str != null) {
				StringTokenizer tok = new StringTokenizer(str);
				int codice = Integer.parseInt(tok.nextToken());
				String tipo = tok.nextToken();
				String nome = br.readLine();
				String cognome = br.readLine();
				if(tipo.equals("studente")) {
					String corso = br.readLine();
					String uni = br.readLine();
					int annoCorso = Integer.parseInt(br.readLine());
					
					Partecipante p = new Studente(codice, tipo, nome, cognome, corso, uni, annoCorso);
					listaPartecipanti.add(p);
					codPart.put(codice,p);
				}
				else if(tipo.equals("regolare")) {
					String ente = br.readLine();
					tok = new StringTokenizer(br.readLine());
					int numDip = Integer.parseInt(tok.nextToken());
					boolean accademico = Boolean.parseBoolean(tok.nextToken());
					
					Partecipante p = new Regolare(codice,tipo,nome,cognome,ente,numDip,accademico);
					listaPartecipanti.add(p);
					codPart.put(codice, p);
				}
				
				str = br.readLine();
			}
		}
		catch (IOException ex)
		{
			System.err.println(ex);
		}		
		
		// lettura del file conferenze.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("conferenze.txt"));
			
			String str = br.readLine();
			while(str != null) {
				String nomeConferenza = str;
				String luogoConferenza = br.readLine();
				str = br.readLine();
				Conferenza c = new Conferenza(nomeConferenza, luogoConferenza);
				listaConferenze.add(c);
				str = br.readLine();
				while(str != null && !str.equals("")) {
					StringTokenizer tok = new StringTokenizer(str);
					int codice = Integer.parseInt(tok.nextToken());
					int costo = Integer.parseInt(tok.nextToken());
					// definire i metodi
					Partecipante p = codPart.get(codice);
					c.addPartecipante(costo, p);
					str = br.readLine();
				}
				str = br.readLine();
			}
		}
		catch (IOException ex)
		{
			System.err.println(ex);
		}
		// stampa lista partecipanti
		System.out.println("tipo, codice, nome, cognome, corso di studi, università, anno di\n" + 
				"corso, ente di appartenenza, numero di dipendenti, accademico");
		for (Partecipante p : listaPartecipanti) {
			System.out.println(p);
		}
		
		// stampa delle conferenze
		System.out.println();
		for (Conferenza c : listaConferenze) {
			System.out.println(c);
		}	
		
	}

}
