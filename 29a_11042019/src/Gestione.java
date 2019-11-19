
import java.util.*;
import java.io.*;

public class Gestione {

	public static void main(String[] args) {
		
		List<Dipendente> listaDipendenti = new LinkedList<Dipendente>();
		List<Cliente> listaClienti = new LinkedList<Cliente>();
		Map<Integer,Double> codCosto = new HashMap<Integer, Double>();
		Map<Integer,Dipendente> codDipendente = new HashMap<Integer, Dipendente>();
		// LETTURA DEL FILE dipendenti.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("dipendenti.txt"));
			String str = br.readLine();
			
			while(str != null) {
				StringTokenizer tok = new StringTokenizer(str);
				int codice = Integer.parseInt(tok.nextToken());
				String tipo = tok.nextToken();
				String nominativo = br.readLine();
				str = br.readLine();
				
				if(tipo.equals("trainer")) {
					tok = new StringTokenizer(str);
					int oreSettimanali = Integer.parseInt(tok.nextToken());
					double costoOrario = Double.parseDouble(tok.nextToken());
					String specialita = br.readLine();
					
					Dipendente d = new Trainer(codice,tipo,nominativo,oreSettimanali,costoOrario,specialita);
					listaDipendenti.add(d);
					codCosto.put(codice, costoOrario);
					codDipendente.put(codice, d);
				}
				if(tipo.equals("nutrizionista")) {
					tok = new StringTokenizer(str);
					int telefono = Integer.parseInt(tok.nextToken());
					boolean medico = Boolean.parseBoolean(tok.nextToken());
					int appuntamenti = Integer.parseInt(tok.nextToken());
					double costoOrario = Double.parseDouble(tok.nextToken());
					
					Dipendente d = new Nutrizionista(codice,tipo,nominativo,telefono,medico,appuntamenti,costoOrario);
					listaDipendenti.add(d);
					codCosto.put(codice, costoOrario);
					codDipendente.put(codice, d);
				}
				str = br.readLine();
			}
			br.close();
		}
		catch(IOException e) {
			System.err.println(e);
		}
		
		// PUNTO 2 LETTURA DEL FILE clienti.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("clienti.txt"));
			String str = br.readLine();
			
			while(str != null) {
				int codiceCliente = Integer.parseInt(str);
				String nominativo = br.readLine();
				str = br.readLine();
				
				Cliente c = new Cliente(codiceCliente,nominativo);
				
				// servizi utilizzati
				while(str != null && !str.equals("")) {
					StringTokenizer tok = new StringTokenizer(str);
					int codiceDipendente = Integer.parseInt(tok.nextToken());
					double durata = Double.parseDouble(tok.nextToken());
					
					double costoOrario = codCosto.get(codiceDipendente);
					Dipendente d = codDipendente.get(codiceDipendente);
					d.incServiziSvolti();	
					Servizio s = new Servizio(durata,costoOrario);
					c.addServizio(s);				
					str = br.readLine();
				}
				listaClienti.add(c);
				str = br.readLine();
			}
			br.close();
		}
		catch(IOException e) {
			System.err.println(e);
		}
		
		// PUNTO 3 
		System.out.println("nome, codice, tipo, ore settimanali, specialità, telefono, medico, app.sett., costo orario");
		for (Dipendente d : listaDipendenti) {
			System.out.println(d);
		}
		
		// PUNTO 4
		System.out.println();
		for (Cliente c : listaClienti) {
			System.out.println(c);
		}
		
		// PUNTO 5
		System.out.println();
		int max = 0;
		String who = null;
		for (Dipendente d : listaDipendenti) {
			if(d.getServiziSvolti() > 0) {
				max = d.getServiziSvolti();
				who = d.getNominativo();
			}
		}
		System.out.println(who + " " + max);
		System.out.println("\nFINE PROGRAMMA.");
	}
}
