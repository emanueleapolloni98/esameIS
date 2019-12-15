package ProvaEsame.entity;

public class Appello {
	protected int Codice;
	protected String NomeEsame;
	protected String NomeDocente;
	
	public Appello(int code, String esame, String nome_doc) {
		this.Codice = code;
		this.NomeEsame = esame;
		this.NomeDocente = nome_doc;
	}
	public int getCodice() {
		return this.Codice;
	}
	public String getNomeEsame() {
		return this.NomeEsame;
	}
	public String getNomeDocente() {
		return this.NomeDocente;
	}
	public void setNomeDocente(String nome) {
		this.NomeDocente = nome;
	}
	public void setCodice(int code) {
		this.Codice = code;
	}
	public void setNomeEsame(String esame) {
		this.NomeEsame = esame;
	}
	public String toString() {
		return "Codice Appello: "+this.Codice+"Esame :"+this.NomeEsame+" Docente: "+this.NomeDocente;
	}
}
