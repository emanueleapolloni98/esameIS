package ProvaEsame.entity;

public class Docente {
	protected int codice;
	protected String NomeDocente;
	
	public Docente() {
		this.codice = 0;
		this.NomeDocente = "";
	}
	public Docente(int code, String name) {
		this.codice = code;
		this.NomeDocente = name;
	}
	public int getCodice() {
		return this.codice;
	}
	public String getNomeDocente() {
		return this.NomeDocente;
	}
	
	public void setCodice(int cod) {
		this.codice = cod;
		
	}
	public void setNomeDocente(String nome) {
		this.NomeDocente = nome;
	}
	
	public String toString() {
		return "Codice : "+this.codice +" Nome: "+this.NomeDocente;
	}
}
