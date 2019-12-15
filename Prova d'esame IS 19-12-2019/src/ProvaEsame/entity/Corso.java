package ProvaEsame.entity;

public class Corso {
	
	
	protected String nome_corso;
	protected String nome_docente;
	protected int cfu;
	
	public Corso() {
		this.nome_corso = "";
		this.nome_docente = "";
		this.nome_corso = "";
		this.cfu = 0;
	}
	public Corso(String NomeCorso, String NomeDoc, int crediti) {
		
		this.nome_corso = NomeCorso;
		this.nome_docente = NomeDoc;
		this.cfu = crediti;
		
	}

	public String getNomeDocente() {
		return this.nome_docente;
	}
	public String getNomeCorso() {
		return this.nome_corso;
		
	}
	public int getCfu() {
		return this.cfu;
	}
	
	public void setCodiceDocente(String NomeDoc) {
		this.nome_docente = NomeDoc;
	}
	public void setNomeCorso(String corso) {
		this.nome_corso = corso;
	}
	public void setCfu(int crediti) {
		this.cfu = crediti;
	}
	public String toString() {
		return " Nome Corso : "+this.nome_corso+" Docente: "+this.nome_docente+" CFU: "+this.cfu;
	}
}
