
import java.util.*;
import java.io.*;

public class Gestione {
	
	public static void main(String[] args){
		
		double mediaVittHockey = 0.0, mediaVittPallamano = 0.0;
		int vittPallamano = 0, vittHockey = 0; // vittorie per sport
		int countPallamano = 0, countHockey = 0; // conteggio squadre per sport
		
		List<Squadra> listaSquadre = new LinkedList<Squadra>();
		List<Giocatore> listaGiocatori = new LinkedList<Giocatore>();
		Map<Integer, String> codNome = new HashMap<Integer, String>(); // codice squadra, nome squadra
		
		// LETTURA DEL FILE squadre.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("squadre.txt"));
			String str = br.readLine();
			
			while(str != null){
				StringTokenizer tok = new StringTokenizer(str);
				int codice = Integer.parseInt(tok.nextToken());
				String sport = tok.nextToken();
				String nomeSquadra = br.readLine();
				
				codNome.put(codice,nomeSquadra);
				
				if(sport.equals("hockey")){
					countHockey++;
					str = br.readLine();
					tok = new StringTokenizer(str);
					int vittorie = Integer.parseInt(tok.nextToken());
					int sconfitte = Integer.parseInt(tok.nextToken());
					double mediaGoal = Double.parseDouble(tok.nextToken());
					double mediaFalli = Double.parseDouble(tok.nextToken());
					
					Squadra s = new Hockey(codice,sport,nomeSquadra,vittorie,sconfitte,mediaGoal,mediaFalli);
					listaSquadre.add(s);
				}
				if(sport.equals("pallamano")){
					countPallamano++;
					str = br.readLine();
					tok = new StringTokenizer(str);
					int vittorie = Integer.parseInt(tok.nextToken());
					int sconfitte = Integer.parseInt(tok.nextToken());
					double mediaGoal = Double.parseDouble(tok.nextToken());
				
					Squadra s = new Pallamano(codice,sport,nomeSquadra,vittorie,sconfitte,mediaGoal);
					listaSquadre.add(s);
				}
				str = br.readLine(); // LETTURA RIGA VUOTA
				str = br.readLine();
			}
			br.close();
		}
		catch (IOException ex){
			System.err.println(ex);
		}
		
		// LETTURA DEL FILE giocatori.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("giocatori.txt"));
			String str = br.readLine();
			
			while(str != null){
				int codiceSquadra = Integer.parseInt(str);
				String cognome = br.readLine();
				String nome = br.readLine();
				str = br.readLine();
				StringTokenizer tok = new StringTokenizer(str);
				int eta = Integer.parseInt(tok.nextToken());
				int numeroMaglia = Integer.parseInt(tok.nextToken());
				String ruolo = tok.nextToken();
				boolean titolare = Boolean.parseBoolean(tok.nextToken());
				
				String nomeSquadra = codNome.get(codiceSquadra);
				
				Giocatore g = new Giocatore(cognome, nome, eta, numeroMaglia, ruolo, titolare, nomeSquadra);
				listaGiocatori.add(g);
				
				str = br.readLine();
			}
			br.close();
		}
		catch (IOException ex){
			System.err.println(ex);
		}
		
		// PUNTO 3 STAMPA A VIDEO DELLE SQUADRE
		// la colonna di n. medio reti è integrata in n. medio goal
		System.out.println("nome della squadra, codice, n. partite vinte, n. partite perse, n. medio di gol, n. medio di falli, sport");
		for (Squadra s : listaSquadre) {
			System.out.println(s);
		}
		
		// PUNTO 4 STAMPA A VIDEO DEI GIOCATORI
		System.out.println("\nnome, cognome, età, numero di maglia, ruolo, titolare, nome squadra");
		for (Giocatore g : listaGiocatori) {
			System.out.println(g);
		}
		
		// PUNTO 5 CALCOLO VITTORIE TOTALI
		System.out.println();
		for (Squadra s : listaSquadre) {
			
			if(s.getSport().equals("pallamano")){
				Pallamano p = (Pallamano)s;
				vittPallamano += p.getVittorie();
			}
			else {
				Hockey h = (Hockey)s;
				vittHockey += h.getVittorie();
			}
		}
		
		// STAMPA MEDIE VITTORIE PER TIPO SPORT
		mediaVittHockey = (double)vittHockey / countHockey;
		mediaVittPallamano = (double)vittPallamano / countPallamano;
		System.out.println("media partite vinte delle squadre di hockey: " + mediaVittHockey);
		System.out.println("media partite vinte delle squadre di pallamano: " + mediaVittPallamano);
		
	} // main
} // class
