package ProvaEsame.entity;

public class Prenotazione {
	private int codAppello;
	private int matricola;
	private String nome;
	private String cognome;
	private String esame;
	
	public Prenotazione(int cod, int mat,String name, String surname, String esame) {
		this.matricola = mat;
		this.codAppello = cod;
		this.nome = name;
		this.cognome = surname;
		this.esame = esame;
	}
	public int getCodAppello() {
		return this.codAppello;
	}
	public int getMatricola() {
		return this.matricola;
	}

	public String toString() {
		return "Codice Appello: "+this.codAppello+" Matricola: "+this.matricola+" Nome: "+this.nome+" Cognome: "+this.cognome+ " Esame: "+this.esame; 
	}
}
