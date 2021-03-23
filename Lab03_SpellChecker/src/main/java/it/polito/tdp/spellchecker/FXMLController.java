/**
 /**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.spellchecker.model.Dizionario;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private Dizionario model;
	
	

    @FXML // fx:id="finestraLingue"
    private ComboBox<String> finestraLingue; // Value injected by FXMLLoader

    @FXML // fx:id="testoDaControllare"
    private TextArea testoDaControllare; // Value injected by FXMLLoader

    @FXML // fx:id="testoErrato"
    private TextArea testoErrato; // Value injected by FXMLLoader

    @FXML // fx:id="numeroErrori"
    private Label numeroErrori; // Value injected by FXMLLoader

    @FXML // fx:id="tempoImpiegato"
    private Label tempoImpiegato; // Value injected by FXMLLoader
    
    public void setModel(Dizionario model){
		this.model=model;
		String lingue[]= {"Inglese","Italiano"};
		finestraLingue.getItems().addAll( lingue);
	}

    @FXML
   public void controllaTesto(ActionEvent event) {
         List<String> parole=new ArrayList<String>();
    	 model.caricaDizionario(finestraLingue.getValue());
         String daControllare=testoDaControllare.getText();
        daControllare=daControllare.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
        daControllare=daControllare.replaceAll("\s+", " ").toLowerCase();
        String lista[]=daControllare.split(" ");
        for(String parola:lista)
        	parole.add(parola);
       int errate=0;
       long inizio=System.nanoTime();
        List<RichWord>risultato=model.controllaTesto(parole);
        long fine=System.nanoTime();
        for(RichWord rich : risultato)
        	{if(!rich.isCorretta())
        		{testoErrato.appendText(rich.parola+"\n");
        		 errate++;
        		}
        	}
        numeroErrori.setText("Il testo contiene "+errate+" errori");
        tempoImpiegato.setText(""+(fine-inizio)+" nanosecondi");
       // StringTokenizer st = new StringTokenizer(inputText, " ");
    }

    @FXML
    void pulisciTesto(ActionEvent event) {
    	testoDaControllare.clear();
    	testoErrato.clear();
    	numeroErrori.setText("Calcolo Errori");
    	tempoImpiegato.setText("Calcolo tempo(in nanosecondi)");
    }

}



