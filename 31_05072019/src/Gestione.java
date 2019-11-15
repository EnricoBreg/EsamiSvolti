
import java.util.*;
import java.io.*;

public class Gestione {
	
	public static void main(String[] args) {
		
		List<Veicolo> listaVeicoli = new LinkedList<Veicolo>();
		List<Cliente> listaClienti = new LinkedList<Cliente>();
		Map<Integer,Veicolo> codVeicolo = new HashMap<Integer, Veicolo>();
		// LETTURA DEL FILE veicoli.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("veicoli.txt"));
			
			String str = br.readLine();
			while(str != null) {
				StringTokenizer tok = new StringTokenizer(str);
				int codice = Integer.parseInt(tok.nextToken());
				String tipo = tok.nextToken();
				String targa = tok.nextToken();
				String modello = br.readLine();
				String marca = br.readLine();
				
				if(tipo.equals("auto")) {
					str = br.readLine();
					tok = new StringTokenizer(str);
					double capienzaBagagliaio = Double.parseDouble(tok.nextToken());
					int cilindrata = Integer.parseInt(tok.nextToken());
					String categoria = br.readLine();
					double costoGiornaliero = Double.parseDouble(br.readLine());
					
					Veicolo v = new Auto(codice,tipo,targa,modello,marca,capienzaBagagliaio,cilindrata,categoria,costoGiornaliero);
					listaVeicoli.add(v);
					codVeicolo.put(codice, v);
				}
				if(tipo.equals("furgone")) {
					str = br.readLine();
					tok = new StringTokenizer(str);
					boolean rimorchio = Boolean.parseBoolean(tok.nextToken());
					int posti = Integer.parseInt(tok.nextToken());
					boolean vanoCarico = Boolean.parseBoolean(tok.nextToken());
					double costoGiornaliero = Double.parseDouble(br.readLine());
					
					Veicolo v = new Furgone(codice,tipo,targa,modello,marca,rimorchio,posti,vanoCarico,costoGiornaliero);
					listaVeicoli.add(v);
					codVeicolo.put(codice,v);
				}
				str = br.readLine();
			}
			br.close();
		}
		catch(IOException ex)
		{
			System.err.println(ex);
		}
		
		// LETTURA DEL FILE clienti.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("clienti.txt"));
			String str = br.readLine();
			
			while(str != null) {
				String nominativo = str;
				Cliente c = new Cliente(nominativo);
				str = br.readLine();
				
				while(str != null && !str.equals("")) {
					StringTokenizer tok = new StringTokenizer(str);
					int codice = Integer.parseInt(tok.nextToken());
					int durata = Integer.parseInt(tok.nextToken());
					
					Veicolo v = codVeicolo.get(codice);
					double costoGiornaliero = v.getCosto();
					Noleggio n = new Noleggio(codice,durata,v);
					c.addNoleggio(n);
					
					str = br.readLine();
				}
				listaClienti.add(c);
				str = br.readLine();
			}
			
		}
		catch(IOException ex)
		{
			System.err.println(ex);
		}
		
		
		// STAMPA DELLA LISTA VEICOLI
		System.out.println("tipo, targa, codice, modello, marca, costo giornaliero," + 
				"bagagliaio, cilindrata, categoria, rimorchio, numero di posti," + 
				"vano di carico");
		for (Veicolo v : listaVeicoli) {
			System.out.println(v);
		}
		
		// STAMPA DELLA LISTA CLIENTI
		System.out.println();
		for (Cliente c : listaClienti) {
			System.out.println(c);
		}
		
		// PUNTO 5
		System.out.println();
		try
		{
			BufferedReader kbr = new BufferedReader(new InputStreamReader(System.in));
			String targa = kbr.readLine();
			
			int numNol = 0;
			for(Cliente c : listaClienti) {
				List<Noleggio> listaNoleggi = c.getNoleggi();
				for (Noleggio n : listaNoleggi) {
					if(targa.equals(n.getTarga()))
						numNol++;
				}
			}
			if(numNol == 0) {
				System.out.println("Errore. Nessuna corrispondenza trovata.");
				System.exit(-1);
			}
				
			System.out.println(numNol);
		}
		catch(IOException ex)
		{
			System.err.println(ex);
		}
	}
}
