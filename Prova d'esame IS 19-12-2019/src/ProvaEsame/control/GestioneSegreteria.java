package ProvaEsame.control;
import ProvaEsame.entity.Docente;
import ProvaEsame.entity.Prenotazione;
import ProvaEsame.entity.Studente;
import ProvaEsame.Exception.DocenteNotFoundException;
import ProvaEsame.Exception.StudenteNotFoundException;
import ProvaEsame.entity.Appello;
import ProvaEsame.entity.Corso;
import ProvaEsame.entity.DataAppello;

import java.sql.Date;
import java.util.ArrayList;



public class GestioneSegreteria {
	private ArrayList<Studente> ListaStudenti;
	private ArrayList<Docente> ListaDocenti;
	private ArrayList<Corso> ListaCorsi;
	private ArrayList<Appello> ListaAppelli;
	private ArrayList<Prenotazione> ListaPrenotazioni;
	private ArrayList<DataAppello> ListaProve;
	
	
	public GestioneSegreteria() {
		ListaStudenti = new ArrayList<Studente>();
		ListaDocenti = new ArrayList<Docente>();
		ListaCorsi = new ArrayList<Corso>();
		ListaAppelli = new ArrayList<Appello>();
		ListaPrenotazioni = new ArrayList<Prenotazione>();
	}
	
	public void aggiungiStudente(Studente s) {
		ListaStudenti.add(s);
	
	}

	public void aggiungiDocente(Docente d) {
		
		ListaDocenti.add(d);
	}
	
	
	public void aggiungiCorso(Corso c) throws DocenteNotFoundException {
		boolean trovato = false;
		for(Docente d : ListaDocenti) {
			if(d.getNomeDocente()==c.getNomeDocente()) {
				trovato = false;
				ListaCorsi.add(c);
				System.out.println("Corso Aggiunto Correttamente");
				
			}
		}
		if(trovato == false) {
			throw new DocenteNotFoundException("Docente non trovato");
		}
		
	}
			
		public void creaAppello(Appello a) throws DocenteNotFoundException {
		boolean trovato = false;
		boolean trovato2 = false;
		for(Docente d : ListaDocenti) {
			if(d.getNomeDocente() == a.getNomeDocente()) {
				trovato2 = true;
			}
		}
		for(Corso c : ListaCorsi) {
			if(c.getNomeCorso().equals(a.getNomeEsame())) {
				trovato = true;
			}
		}
		if(trovato == true && trovato2==true) {
			
			ListaAppelli.add(a);
			System.out.println("Appello creato correttamente");
		}
		else {
			throw new DocenteNotFoundException("Corso or Docente no found");
			
		}
	}

	public void prenotazione(Studente st, Appello app) throws StudenteNotFoundException {
		boolean trovato = false;
		boolean trovato2 = false;
		String esame = null;
		String nome = null;
		String cognome = null;
		for(Appello a : ListaAppelli) {
			if(a.getCodice()==app.getCodice()) {
				trovato = true;
				esame = a.getNomeEsame();
			}
		}
		for(Studente s : ListaStudenti) {
			if(s.getMatricola() == st.getMatricola()) {
				trovato2 = true;
				nome = s.getNome();
				cognome = s.getCognome();
			}
		}
		if(trovato == true && trovato2 == true) {
			Prenotazione p = new Prenotazione(app.getCodice(),st.getMatricola(),nome,cognome,esame);
			ListaPrenotazioni.add(p);
		}
		else {
			throw new StudenteNotFoundException("Appello o Studente non trovato");
		}
	}
	public ArrayList<Prenotazione> visualizzaPrenotati(Appello app){
		ArrayList<Prenotazione> trovati = new ArrayList<Prenotazione>();
		
		for(Prenotazione p : ListaPrenotazioni) {
			if(p.getCodAppello()==app.getCodice()) {
				trovati.add(p);
			}
		}
		System.out.println("Numero Studenti Prenotati = "+trovati.size());
		return trovati;
		
	}
	public void  impostaProve(Appello a,Date data, String lab, String tipo) {
	
		for(Appello ap : ListaAppelli) {
			if(ap.getCodice()==a.getCodice()) {
				DataAppello prova = new DataAppello(a.getNomeEsame(),a.getCodice(),
						a.getNomeDocente(),data,lab,tipo);
				ListaProve.add(prova);
			}
		}
	}
}
	

