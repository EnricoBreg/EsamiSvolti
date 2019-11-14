
import java.util.*;
import java.io.*;

public class Gestione {
	
	public static void main(String[] args) {
		
		List<Corso> listaCorsi = new LinkedList<Corso>();
		List<Studente> listaStudenti = new LinkedList<Studente>();
		Map<Integer,Studente> matNome = new HashMap<Integer, Studente>();
		Map<Integer,String> codNome = new HashMap<Integer, String>();
		
		// LETTURA DEL FILE corsi.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("corsi.txt"));
			
			String str = br.readLine();
			while(str != null) {
				StringTokenizer tok = new StringTokenizer(str);
				int codiceCorso = Integer.parseInt(tok.nextToken());
				String tipo = tok.nextToken();
				String nomeCorso = br.readLine();
				String docente = br.readLine();
				codNome.put(codiceCorso, nomeCorso); // per punto 5
				if(tipo.equals("teoria")) {
					str = br.readLine();
					tok = new StringTokenizer(str);
					int codiceAula = Integer.parseInt(tok.nextToken());
					int oreSettimanali = Integer.parseInt(tok.nextToken());
					double oreLezione = Double.parseDouble(tok.nextToken());
					
					Corso c = new Teoria(codiceCorso, tipo, nomeCorso, docente, codiceAula, oreLezione, oreSettimanali);
					listaCorsi.add(c);
				}
				if(tipo.equals("laboratorio")) {
					String lab = br.readLine();
					String assistente = br.readLine();
					int posti = Integer.parseInt(br.readLine());
					
					Corso c = new Laboratorio(codiceCorso,tipo,nomeCorso,docente,lab,assistente, posti);
					listaCorsi.add(c);
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
		
		// LETTURA DEL FILE studenti.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("studenti.txt"));
			
			String str = br.readLine();
			while(str != null) {
				int matricola = Integer.parseInt(str);
				String nomeCognome = br.readLine();
				str = br.readLine();
				
				Studente s = new Studente(matricola,nomeCognome);
				matNome.put(matricola, s);
				
				while(str != null && !str.equals("")) {
					StringTokenizer tok = new StringTokenizer(str);
					int codiceCorso = Integer.parseInt(tok.nextToken());
					String voto = tok.nextToken();
					if(voto.equals("30L"))
						voto = "31";
					String nome = codNome.get(codiceCorso);
					Voto v = new Voto(nome,codiceCorso,voto);
					s.addVoto(v);
					str = br.readLine();
				}
				listaStudenti.add(s);
				str = br.readLine();
			}
			br.close();
		}
		catch (IOException ex)
		{
			System.err.println(ex);
		}
		
		// STAMPA DI CORSI
		System.out.println("nome, codice, docente, tipo, aula, ore sett., ore/lez., lab.,\n" + 
				"assistente, postazioni");
		for (Corso c : listaCorsi) {
			System.out.println(c);
		}
		
		// STAMPA DEGLI STUDENTI
		System.out.println();
		for (Studente s : listaStudenti) {
			System.out.println(s);
		}
		
		// RICERCA DELLO STUDENTE
		try
		{
			BufferedReader kbr = new BufferedReader(new InputStreamReader(System.in));
			
			int matrRicerca = Integer.parseInt(kbr.readLine());
			Studente s = matNome.get(matrRicerca);
			System.out.println();
			System.out.println(s.getNome() + " " + s.getNomeCorsoEVotoMax());
			kbr.close();
		}
		catch(IOException ex) {
			System.err.println(ex);
		}
	}
}
