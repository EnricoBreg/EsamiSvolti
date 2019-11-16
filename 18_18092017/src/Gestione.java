
import java.util.*;
import java.io.*;

public class Gestione {

	public static void main(String[] args) {
		
		List<Iscritto> listaIscritti = new LinkedList<Iscritto>();
		Map<Integer,Iscritto> idIscritto = new HashMap<Integer, Iscritto>();
		// LETTURA DEL FILE iscritti.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("iscritti.txt"));
			
			String str = br.readLine();
			while(str != null) {
				StringTokenizer tok = new StringTokenizer(str);
				String tipo = tok.nextToken();
				int id = Integer.parseInt(tok.nextToken());
				
				if(tipo.equals("individuo")) {
					String nominativo = br.readLine();
					String indirizzo = br.readLine();
					str = br.readLine();
					tok = new StringTokenizer(str);
					String username = tok.nextToken();
					String password = tok.nextToken();
					
					Iscritto i = new Individuo(tipo,id,nominativo,indirizzo,username,password);
					listaIscritti.add(i);
					idIscritto.put(id, i);
				}
				if(tipo.equals("azienda")) {
					String ragioneSociale = br.readLine();
					String indirizzo = br.readLine();
					String gestore = br.readLine();
					str = br.readLine();
					tok = new StringTokenizer(str);
					String username = tok.nextToken();
					String password = tok.nextToken();
					
					Iscritto i = new Azienda(tipo,id,ragioneSociale,indirizzo,gestore,username,password);
					listaIscritti.add(i);
					idIscritto.put(id, i);
				}
				str = br.readLine();
				str = br.readLine();
			}
			br.close();
		}
		catch (IOException ex)
		{
			System.err.println(ex);
		}
		
		// LETTURA DEL FILE segue.txt
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader("segue.txt"));
			
			String str = br.readLine();
			while(str != null) {
				int id = Integer.parseInt(str);
				Iscritto i = idIscritto.get(id);
				
				
				str = br.readLine();
				StringTokenizer tok = new StringTokenizer(str);
				
				while(tok.hasMoreTokens()) {
					id = Integer.parseInt(tok.nextToken());
					Iscritto seguace = idIscritto.get(id);
					i.addSeguace(seguace);
				}
			str = br.readLine();
			}
			br.close();
		}
		catch(IOException ex)
		{
			System.err.println(ex);
		}
		
		System.out.println("ID,\tNOME/COGNOME\tRAGIONE SOCIALE\tNOME/COGNOME GESTORE ACCOUNT\tINDIRIZZO\tUSERNAME\tLUNGH PASS");
		// STAMPA DI TUTTI GLI ISCRITTI
		for (Iscritto i : listaIscritti) {
			System.out.println(i);
		}
		
		System.out.println();
		// STAMPA DI ISCRITTI E NUMERO SEGUACI
		System.out.println("ID\tNOMINATIVO/RAGIONE SOCIALE\tNUM SEGUACI");
		for (Iscritto i : listaIscritti) {
			if(i.getTipo().equals("individuo")) {
				Individuo ind = (Individuo)i;
				System.out.println(ind.getID() + "\t" +ind.getNominativo() +"\t" +ind.getNumeroSeguaci());
			} else if(i.getTipo().equals("azienda")) {
				Azienda azienda = (Azienda)i;
				System.out.println(azienda.getID() + "\t"+azienda.getRagioneSociale()+"\t"+azienda.getNumeroSeguaci());
			}
		}
		
		// PUNTO 5 STAMPA DELL'UTENTE CON PIU' SEGUACI
		System.out.println();
		
		int max = 0;
		String utentePiuSeguito = null;
		for (Iscritto i : listaIscritti) {
			if(i.getNumeroSeguaci() > max) {
				max = i.getNumeroSeguaci();
				if(i.getTipo().equals("individuo")) {
					Individuo ind = (Individuo)i;
					utentePiuSeguito = ind.getNominativo();
				}
				else if(i.getTipo().equals("azienda")) {
					Azienda azienda = (Azienda)i;
					utentePiuSeguito = azienda.getRagioneSociale();
				}
			}
		}
		System.out.println(utentePiuSeguito);
		System.out.println("\nFINE PROGRAMMA.");
	}
}
