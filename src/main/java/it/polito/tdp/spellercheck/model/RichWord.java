package it.polito.tdp.spellercheck.model;

public class RichWord {
	
	private String parola;
	private boolean corretta;
	
	public RichWord(String parola) {
		super();
		this.parola = parola;
		this.corretta = false;
	}
	
	
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public boolean isCorretta() {
		return corretta;
	}
	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}


	@Override
	public String toString() {
		return "RichWord [parola=" + parola + ", corretta=" + corretta + "]";
	}
	
	
	

}
