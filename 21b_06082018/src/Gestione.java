
import java.util.*;

import org.xml.sax.HandlerBase;

import java.io.*;
import java.nio.Buffer;

public class Gestione {
	
	public static void main(String[] args) {
		
		List<Giocatore> listaGiocatori = new LinkedList<Giocatore>();
		List<Partita> listaPartite = new LinkedList<Partita>();
		Map<Integer, Giocatore> codGiocatore = new HashMap<Integer, Giocatore>();
		// lettura del file giocatori.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("giocatori.txt"));
			String str = br.readLine();
			while(str != null){
				int codice = Integer.parseInt(str);
				String tipo = br.readLine();
				String nomeCognome = br.readLine();
				
				if(tipo.equals("testa-di-serie")) {
					str = br.readLine();
					StringTokenizer tok = new StringTokenizer(str); 
					int ranking = Integer.parseInt(tok.nextToken());
					int eta = Integer.parseInt(tok.nextToken());
					boolean professionista = Boolean.parseBoolean(tok.nextToken());
					
					Giocatore g = new TestaDiSerie(codice,tipo,nomeCognome,ranking,eta,professionista);
					listaGiocatori.add(g);
					codGiocatore.put(codice, g);
				}
				else if(tipo.equals("normale")) {
					String circolo = br.readLine();
					str = br.readLine();
					StringTokenizer tok = new StringTokenizer(str);
					int setVinti = Integer.parseInt(tok.nextToken());
					int partiteDisputate = Integer.parseInt(tok.nextToken());
					
					Giocatore g = new Normale(codice,tipo,nomeCognome,circolo,setVinti,partiteDisputate);
					listaGiocatori.add(g);
					codGiocatore.put(codice, g);
				}
				str = br.readLine();
				str = br.readLine();				
			}
		}
		catch(IOException ex)
		{
			System.err.println(ex);
		}
		
		// LETTURA DEL FILE partite.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("partite.txt"));
			
			String str = br.readLine();
			while(str != null) {
				StringTokenizer tok = new StringTokenizer(str);
				int giocatore1 = Integer.parseInt(tok.nextToken());
				int giocatore2 = Integer.parseInt(tok.nextToken());
				str = br.readLine();
				tok = new StringTokenizer(str);
				int punti1 = Integer.parseInt(tok.nextToken());
				int punti2 = Integer.parseInt(tok.nextToken());
				
				// aggiunta partita per giocatore 1
				Partita p1 = new Partita(giocatore1,giocatore2,punti1, punti2);
				Giocatore g1 = codGiocatore.get(giocatore1);
				g1.addPartita(p1);
				// aggiunta partita per giocatore 2
				Partita p2 = new Partita(giocatore2, giocatore1, punti2, punti1);
				Giocatore g2 = codGiocatore.get(giocatore2);
				g2.addPartita(p2);
				
				str = br.readLine();
			}
		}
		catch(IOException ex)
		{
			System.err.println(ex);
		}
		
		// STAMPA DELLA LISTA GIOCATORI
		System.out.println("nome, codice, tipo, ranking, eta, professionista, circolo, n., set vinti, n. partite");
		for (Giocatore g : listaGiocatori) {
			System.out.println(g);
		}
		
		// STAMPA DELLA LISTA GIOCATORI E PARTITE
		System.out.println();
		for (Giocatore g : listaGiocatori) {
			listaPartite = g.getPartite();
			System.out.println(g.getNome()+"\n\t"+listaPartite);
		}
		
		// PUNTO 5 
		String migliore = null;
		for (Giocatore g : listaGiocatori) {
			migliore = g.getNome();
			listaPartite = g.getPartite();
			int vittorie = 0;
			for (Partita p : listaPartite) {
				if(p.getPunti1() > p.getPunti2())
					vittorie++;
			}
			g.addVittorie(vittorie);
		}
		int max = 0;
		for (Giocatore g : listaGiocatori) {
			if(g.getVittorie() > max) {
				max = g.getVittorie();
				migliore = g.getNome();
			}
		}
		System.out.println("\nIl giocatore con piu' vittorie e' " + migliore);
	}
}
