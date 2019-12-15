package ProvaEsame.entity;
import java.sql.Date;
public class DataAppello extends Appello {
	protected Date data_prova;
	protected String Laboratorio;
	protected String tipoProva;
	
	public DataAppello(String Nomedoc,int code, String appello, Date dataprova, String lab, String tipo){
		super(code,appello,Nomedoc);
		this.data_prova = dataprova;
		this.Laboratorio = lab;
		this.tipoProva = tipo;
	}
	public Date getDataProva() {
		return this.data_prova;
	}
	public String getLab() {
		return this.Laboratorio;
	}
	public String getTipoProva() {
		return this.tipoProva;
	}
	public String toString() {
		return "Data: "+this.data_prova+" Codice Appello: "+this.Codice+"Esame :"+
				this.NomeEsame+" Laboratorio: "+
				this.Laboratorio+" Tipo: "+this.tipoProva+
				" Docente: "+this.NomeDocente;
	}
}
