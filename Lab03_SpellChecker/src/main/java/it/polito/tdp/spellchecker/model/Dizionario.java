package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dizionario {
	Set<String> parole=new HashSet<String>();
	
	public void caricaDizionario(String language) {
		String file="";
		if(language.compareTo("Italiano")==0)
			 file="Italian.txt";
		if(language.compareTo("Inglese")==0)
			file="English.txt";
		
		try {
			FileReader fr=new FileReader("src/main/resources/"+file);
			BufferedReader br=new BufferedReader(fr);
			String word;
			while((word=br.readLine())!=null) {
				parole.add(word);
				
				
			}
			br.close();
			fr.close();
		}
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
			
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		
	}
	
	public List<RichWord> controllaTesto(List<String> testoInInput){
		List<RichWord> risultato=new ArrayList<RichWord>();
		for(String daControllare : testoInInput)
			{if(parole.contains(daControllare))
				risultato.add(new RichWord(daControllare,true));
				else {
					risultato.add(new RichWord(daControllare,false));
				}
			}
		return risultato;
		
	}

}
