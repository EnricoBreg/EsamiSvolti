
import java.util.*;
import java.io.*;

public class Gestione {

	public static void main(String[] args) {
		
		List<Impiegato> listaImpiegati = new LinkedList<Impiegato>();
		List<Cliente> listaClienti = new LinkedList<Cliente>();
		Map<Integer, String> codNome = new HashMap<Integer, String>();
		Map<Integer, Double> codCosto = new HashMap<Integer, Double>();
		Map<Integer, Impiegato> codImpiegato = new HashMap<Integer, Impiegato>();
		// LETTURA DEL FILE impegati.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("impiegati.txt"));
			String str = br.readLine();
			
			while(str != null) {
				StringTokenizer tok = new StringTokenizer(str);
				int codice = Integer.parseInt(tok.nextToken());
				String tipo = tok.nextToken();
				String nominativo = br.readLine();
				codNome.put(codice, nominativo);
				
				if(tipo.equals("guida")) {
					str = br.readLine();
					tok = new StringTokenizer(str);
					int telefono = Integer.parseInt(tok.nextToken());
					boolean inglese = Boolean.parseBoolean(tok.nextToken());
					int appuntamenti = Integer.parseInt(tok.nextToken());
					double costoOrario = Double.parseDouble(tok.nextToken());
					
					Impiegato i = new Guida(codice,tipo,nominativo,telefono,inglese,appuntamenti,costoOrario);					
					listaImpiegati.add(i);
					codCosto.put(codice, costoOrario);
					codImpiegato.put(codice, i);
				}
				if(tipo.equals("sommelier")) {
					str = br.readLine();
					tok = new StringTokenizer(str);
					int oreSettimanali = Integer.parseInt(tok.nextToken());
					double costoOrario = Double.parseDouble(tok.nextToken());
					String specialita = br.readLine();
					
					Impiegato i = new Sommelier(codice,tipo,nominativo,oreSettimanali,costoOrario,specialita);
					listaImpiegati.add(i);
					codCosto.put(codice, costoOrario);
					codImpiegato.put(codice, i);
				}
				str = br.readLine();
			}
			br.close();
		}
		catch(IOException e) {
			System.err.println(e);
		}
		
		// PUNTO 2 LETTURA DEL FILE visitatori.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("visitatori.txt"));
			String str = br.readLine();
			
			while(str != null) {
				int codiceCliente = Integer.parseInt(str);
				String nominativo = br.readLine();
				
				Cliente c = new Cliente(codiceCliente,nominativo);
				
				str = br.readLine();
				while(str != null && !str.equals("")) {
					StringTokenizer tok = new StringTokenizer(str);
					int codiceImpiegato = Integer.parseInt(tok.nextToken());
					double durata = Double.parseDouble(tok.nextToken());
					
					String nomeImpiegato = codNome.get(codiceImpiegato);
					double costoOrario = codCosto.get(codiceImpiegato);
					double totale = costoOrario * durata;
					
					Impiegato i = codImpiegato.get(codiceImpiegato);
					i.setServizio();
					Servizio s = new Servizio(nomeImpiegato,costoOrario,totale);
					c.addServizio(s);
					str = br.readLine();
				}
				listaClienti.add(c);
				str = br.readLine();
			}
		}
		catch(IOException e) {
			System.err.println(e);
		}		
		
		// PUNTO 3 
		System.out.println("nome, codice, tipo, ore settimanali, specialità, telefono, inglese, app.sett., costo orario");
		for (Impiegato i : listaImpiegati) {
			System.out.println(i);
		}
		
		// PUNTO 4
		System.out.println();
		for (Cliente c : listaClienti) {
			System.out.println(c);
		}
		
		
		// PUNTO 5
		System.out.println();
		try
		{
			BufferedReader kbr = new BufferedReader(new InputStreamReader(System.in));
			String str = kbr.readLine();
			int codiceImpiegato = Integer.parseInt(str);
			
			Impiegato i = codImpiegato.get(codiceImpiegato);
			
			System.out.println(i.getNumeroServizi());
			
			kbr.close();
		}
		catch(IOException e) {
			System.err.println(e);
		}
		
		System.out.println("FINE PROGRAMMA.");
		
	}
}
