
import java.util.*;
import java.io.*;

public class Gestione {

	public static void main(String[] args) {
		
		List<Squadra> listaSquadre = new LinkedList<Squadra>();
		List<Giocatore> listaGiocatori = new LinkedList<Giocatore>();
		Map<Integer,Squadra> codNome = new HashMap<Integer, Squadra>();
		
		// LETTURA DEL FILE squadre.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("squadre.txt"));
			
			String str = br.readLine();
			while(str != null) {
				StringTokenizer tok = new StringTokenizer(str);
				int codice = Integer.parseInt(tok.nextToken());
				String sport = tok.nextToken();
				String nomeSquadra = br.readLine();
				
				
				// caso pallacanestro
				if(sport.equals("pallacanestro")) {
					str = br.readLine();
					tok = new StringTokenizer(str);
					int vittorie = Integer.parseInt(tok.nextToken());
					int sconfitte = Integer.parseInt(tok.nextToken());
					double mediaFalli = Double.parseDouble(tok.nextToken());
					int puntiTotali = Integer.parseInt(tok.nextToken());
					
					Squadra s = new Pallacanestro(codice,sport,nomeSquadra,vittorie,sconfitte,mediaFalli,puntiTotali);
					listaSquadre.add(s);
					codNome.put(codice, s);
				}
				//caso pallamano
				if(sport.equals("pallamano")) {
					str = br.readLine();
					tok = new StringTokenizer(str);
					int vittorie = Integer.parseInt(tok.nextToken());
					int sconfitte = Integer.parseInt(tok.nextToken());
					double mediaGoal = Double.parseDouble(tok.nextToken());
					
					Squadra s = new Pallamano(codice,sport,nomeSquadra,vittorie,sconfitte,mediaGoal);
					listaSquadre.add(s);
					codNome.put(codice, s);
				}
				str = br.readLine();
				str = br.readLine();
			}
		}
		catch(IOException ex)
		{
			System.err.println(ex);
		}
		
		// LETTURA DEL FILE giocatori.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("giocatori.txt"));
			String str = br.readLine();
			while(str != null) {
				int codiceSquadra = Integer.parseInt(str);
				String cognome = br.readLine();
				String nome = br.readLine();
				str = br.readLine();
				StringTokenizer tok = new StringTokenizer(str);
				boolean titolare = Boolean.parseBoolean(tok.nextToken());
				int eta = Integer.parseInt(tok.nextToken());
				int numeroMaglia = Integer.parseInt(tok.nextToken());
				String ruolo = tok.nextToken();
				
				str = br.readLine();
				Squadra s = codNome.get(codiceSquadra);
				String nomeSquadra = s.getNome();
				Giocatore g = new Giocatore(codiceSquadra,nomeSquadra,cognome,nome,titolare,eta,numeroMaglia,ruolo);
				listaGiocatori.add(g);
				s.addGiocatore(g);
			}
		}
		catch(IOException ex)
		{
			System.err.println(ex);
		}
		
		
		
		
		// STAMPA DI TUTTE LE SQUADRE
		System.out.println("nome della squadra, codice, n. partite vinte, n. partite perse, punti totali, n. medio di falli, n. medio di reti, sport");
		for (Squadra s : listaSquadre) {
			System.out.println(s);
		}
		
		// STAMPA  DI TUTTI I GIOCATORI
		System.out.println("\nnome, cognome, età, numero di maglia, ruolo, nome squadra");
		for (Giocatore g : listaGiocatori) {
			System.out.println(g);
		}
		
		// STAMPA NUMERO GIOCATORI CIASCUNA SQUADRA
		System.out.println();
		for (Squadra s : listaSquadre) {
			System.out.println(s.getNome() + " " + s.getNumeroGiocatori());
		}
		
		
	}
}
