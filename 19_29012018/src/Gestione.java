
import java.util.*;
import java.io.*;

public class Gestione {

	public static void main(String[] args) {
		
		List<Cliente> listaClienti = new LinkedList<Cliente>();
		Map<Integer, Cliente> codCliente = new HashMap<Integer, Cliente>();
		Map<Double, String>  consumoNome = new HashMap<Double, String>();
		// LETTURA DEL FILE clienti.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("clienti.txt"));
			String str = br.readLine();
			
			while(str != null) {
				StringTokenizer tok = new StringTokenizer(str);
				String tipoCliente = tok.nextToken();
				int codice = Integer.parseInt(tok.nextToken());
				
				if(tipoCliente.equals("residenziale")) {
					str = br.readLine();
					tok = new StringTokenizer(str);
					String nome = tok.nextToken();
					String cognome = tok.nextToken();
					String tipoContratto = br.readLine();
					String indirizzo = br.readLine();
					
					Cliente c = new Residenziale(tipoCliente,codice,nome,cognome,tipoContratto,indirizzo);
					listaClienti.add(c);
					codCliente.put(codice, c);
				}
				if(tipoCliente.equals("aziendale")) {
					String ragioneSociale = br.readLine();
					double portataMassima = Double.parseDouble(br.readLine());
					String tipoContratto = br.readLine();
					String indirizzo = br.readLine();
					
					Cliente c = new Aziendale(tipoCliente,codice,ragioneSociale,portataMassima,tipoContratto,indirizzo);
					listaClienti.add(c);
					codCliente.put(codice, c);
				}
				str = br.readLine();
				str =  br.readLine();
			}
			br.close();
		}
		catch (IOException ex) {
			System.err.println(ex);
		}
		
		// LETTURA DEL FILE letture.txt
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("letture.txt"));
			String str = br.readLine();
			while(str != null) {
				StringTokenizer tok = new StringTokenizer(str);
				int codice = Integer.parseInt(tok.nextToken());
				Cliente c = codCliente.get(codice);				
				
				double consumo = Double.parseDouble(tok.nextToken());
				c.addLettura(consumo);
				str = br.readLine();
				
				// per PUNTO 5 seconda soluzione
				if(c.getTipoCliente().equals("residenziale")) {
					Residenziale r = (Residenziale)c;
					consumoNome.put(consumo, r.getNominativo());
				}
				else {
					Aziendale a = (Aziendale)c;
					consumoNome.put(consumo, a.getRagioneSociale());
				}
			}
		}
		catch (IOException ex)
		{
			System.err.println(ex);
		}
		
	
		// PUNTO 3: STAMPA A VIDEO DEI CLIENTI
		System.out.println("ID Tipo Nome/Cognome RagioneSociale Indirizzo TipoContratto PortataMassima");
		for (Cliente c : listaClienti) {
			System.out.println(c);
		}
	
		// PUNTO 4
		System.out.println("\nID Nome/Cognome/RagioneSociale Totale");
		for (Cliente c : listaClienti) {
			List<Lettura> letture = c.getLetture();
			double tot = 0;
			
			for(Lettura l : letture) {
				if(c.getTipoContratto().equals("mercato libero"))
					tot = tot + l.getConsumo() * 1.2; // se contratto è "mercato libero"
				else
					tot = tot + l.getConsumo() * 1.15; // se contratto è "canone concordato"
			}
			
			// per PUNTO 5 seconda soluzione
			if(c.getTipoCliente().equals("residenziale")) {
				Residenziale r = (Residenziale)c;
				System.out.println(r.getId() + "\t" + r.getNominativo() +"\t" + tot);
			}
			else if(c.getTipoCliente().equals("aziendale")) {
				Aziendale a = (Aziendale)c;
				System.out.println(a.getId() + "\t" + a.getRagioneSociale() + " \t" + tot);
			}
		}
	
		
		// PUNTO 5
		System.out.println();
		double max = 0;
		String who = null; // ragioneSociale o nominativo del cliente con la lettura maggiore
		
		// PUNTO 5 -> prima soluzione (senza uso della mappa) 
		/* for (Cliente c : listaClienti) {
			List<Lettura> letture = c.getLetture();
			
			for (Lettura l : letture) {
				if(l.getConsumo() > max) {
					max = l.getConsumo();
					if(c.getTipoCliente().equals("residenziale")) {
						Residenziale r = (Residenziale)c;
						who = r.getNominativo();
					}
					else {
						Aziendale a = (Aziendale)c;
						who = a.getRagioneSociale();
					}
				}
			}
		} */
		
		// PUNTO 5 -> seconda soluzione (con uso della mappa)
		for (Cliente c : listaClienti) {
			List<Lettura> letture = c.getLetture();
			for(Lettura l : letture) {
				if(l.getConsumo() > max) {
					max = l.getConsumo();
					who = consumoNome.get(l.getConsumo());
				}
			}
		}
		System.out.println("Il cliente con la lettura maggiore e': " + who + " con " + max);
	
	}
}
