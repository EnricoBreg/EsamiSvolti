
import java.util.*;
import java.io.*;

public class Gestione {

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		
		List<Scontrino> listaScontrini = new LinkedList<Scontrino>();
		Map<String, Integer> totali = new HashMap<String, Integer>();
		Map<Integer,Integer> totali_cliente = new HashMap<Integer, Integer>();
		// LETTURA DEL FILE scontrini.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("scontrini.txt"));
			String str = br.readLine();
			
			while(str != null) {
				StringTokenizer tok = new StringTokenizer(str);
				String tipo = tok.nextToken();
				int codiceScontrino = Integer.parseInt(tok.nextToken());
				// str = br.readLine();
				String data = br.readLine();
				
				Scontrino s = new Scontrino(data, codiceScontrino);
				
				if(tipo.equals("privato")) {
					String nominativo = br.readLine();
					String indirizzo = br.readLine();
					str = br.readLine();
					tok = new StringTokenizer(str);
					String codiceFiscale = tok.nextToken();
					int codiceCliente = Integer.parseInt(tok.nextToken());
					
					Cliente c = new Privato(tipo,nominativo,indirizzo,codiceFiscale,codiceCliente);	
					s.setCliente(c);
					
					// aggiunta dei prodotti acquistati
					str = br.readLine();
					while(str != null && !str.equals("")) {
						String descrizione = str;
						str = br.readLine();
						tok = new StringTokenizer(str);
						
						int qtaVenduta = Integer.parseInt(tok.nextToken());
						int prezzo = Integer.parseInt(tok.nextToken());
						Prodotto p = new Prodotto(descrizione,qtaVenduta,prezzo);
						s.addProdotto(p);
						str = br.readLine();
						
						// PUNTO 5
						if(totali.get(descrizione) == null)
							totali.put(descrizione, new Integer(prezzo*qtaVenduta));
						else {
							int tot = totali.get(descrizione);
							totali.put(descrizione, new Integer(tot+prezzo*qtaVenduta));	
						}
						
						// PUNTO 6
						if(totali_cliente.get(codiceCliente) == null)
							totali_cliente.put(codiceCliente, new Integer(qtaVenduta*prezzo));
						else {
							int tot = totali_cliente.get(codiceCliente);
							totali_cliente.put(codiceCliente, new Integer(tot+qtaVenduta*prezzo));
						}
					}
				}
				
				if(tipo.equals("azienda")) {
					String ragioneSociale = br.readLine();
					int partitaIva = Integer.parseInt(br.readLine());
					int codiceCliente = Integer.parseInt(br.readLine());
					String indirizzo = br.readLine();
					
					Cliente c = new Azienda(tipo,ragioneSociale,partitaIva,indirizzo,codiceCliente);
					s.setCliente(c);
					
					str = br.readLine();
					while(str != null && !str.equals("")) {
						String descrizione = str;
						str = br.readLine();
						tok = new StringTokenizer(str);
						
						int qtaVenduta = Integer.parseInt(tok.nextToken());
						int prezzo = Integer.parseInt(tok.nextToken());
						Prodotto p = new Prodotto(descrizione,qtaVenduta,prezzo);
						s.addProdotto(p);
						str = br.readLine();
						
						// PUNTO 5
						if(totali.get(descrizione) == null)
							totali.put(descrizione, new Integer(prezzo*qtaVenduta));
						else {
							int tot = totali.get(descrizione);
							totali.put(descrizione, new Integer(tot+prezzo*qtaVenduta));	
						}
					}
				}
				listaScontrini.add(s);
				str = br.readLine();
			}
			br.close();
		}
		catch(IOException ex)
		{
			System.err.println(ex);
		}
		
		// PUNTO 2 
		System.out.println("ID Data Nome/Cognome Indirizzo CodiceFiscale RagioneSociale PartitaIva CodiceCliente");
		for (Scontrino s : listaScontrini) {
			Cliente c = s.getCliente();
			if(c.getTipo().equals("privato")) {
				Privato p = (Privato)c;
				System.out.println(s.toString() + " " + p.toString() + " " + p.getCodiceCliente());
			}
			else { // se c.getTipo().equals("azienda")
				Azienda a = (Azienda)c;
				System.out.println(s.toString() + " " + a.toString() + " " + a.getCodiceCliente());
			}
		}
		
		
		// PUNTO 3
		System.out.println(); // riga separatore
		System.out.println("Descrizione Quantità Prezzo Totale");
		for (Scontrino s : listaScontrini) {
			List<Prodotto> prodotti = s.getProdotti();
			for (Prodotto p : prodotti) {
				System.out.println(p);
			}
		}
		
		// PUNTO 4
		System.out.println("\nDescrizione Totale");
		System.out.println(totali);
	
		// PUNTO 5
		int codiceCliente = Integer.parseInt(args[0]);
		if(totali_cliente.get(codiceCliente) == null)
			System.out.println("\nNessuna corrispondenza con il codice cliente inserito. \nFINE PROGRAMMA");
		else {
			System.out.println("\nCod Cliente\tTotale Speso");
			System.out.println(codiceCliente + "\t\t" + totali_cliente.get(codiceCliente));
		}
	}	
}
