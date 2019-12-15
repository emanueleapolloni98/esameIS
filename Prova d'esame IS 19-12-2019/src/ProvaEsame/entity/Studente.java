package ProvaEsame.entity;
import java.util.Random;
public class Studente {
	protected int Matricola;
	protected String Nome;
	protected String Cognome;
	protected int pin;
	
	public Studente() {
		this.Matricola = 0;
		this.Nome = "";
		this.Cognome = "";
		this.pin = 0;
	}
	public Studente(int mat, String name, String surname) {
		this.Matricola = mat;
		this.Nome = name;
		this.Cognome = surname;
		Random rand = new Random();
		this.pin = rand.nextInt(99999);
	}
	public int getMatricola() {
		return this.Matricola;
	}
	public String getNome() {
		return this.Nome;
	}
	public String getCognome() {
		return this.Cognome;
	}
	public int getPin() {
		return this.pin;
	}
	public void setMatricola(int mat) {
		this.Matricola = mat;
	}
	public void setNome(String name) {
		this.Nome = name;
	}
	public void setCognome(String surname) {
		this.Cognome = surname;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String toString() {
		return "Matricola: N"+this.Matricola+" Nome: "+this.Nome+" Cognome: "+this.Cognome;
	}
}
