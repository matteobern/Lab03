package it.polito.tdp.spellchecker.model;

public class RichWord {
public String parola;
public boolean corretta;

public RichWord(String parola, boolean corretta) {
	this.parola = parola;
	this.corretta = corretta;
}

public boolean isCorretta() {
	return corretta;
}

public void setCorretta(boolean corretta) {
	this.corretta = corretta;
}


}
