import static org.junit.Assert.*;
import java.util.ArrayList;
import ProvaEsame.entity.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ProvaEsame.Exception.DocenteNotFoundException;
import ProvaEsame.Exception.StudenteNotFoundException;
import ProvaEsame.control.GestioneSegreteria;
public class ConsultazionePrenotatiTest {
	
	GestioneSegreteria segreteria = new GestioneSegreteria();
	ArrayList<Prenotazione> prenotati = new ArrayList<Prenotazione>();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test01PrenotazioneStudenteNonRegistrato() {
		Docente d = new Docente(222,"Pippo Pluto");
		Corso c = new Corso("Test",d.getNomeDocente(),9);
		Studente s = new Studente(456,"Pluto","Pippo");
		segreteria.aggiungiDocente(d);
		try {
			segreteria.aggiungiCorso(c);
		} catch (DocenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Appello app = new Appello(123,"Test",d.getNomeDocente());
		try {
			segreteria.creaAppello(app);
		} catch (DocenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			segreteria.prenotazione(s, app);
		} catch (StudenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prenotati = segreteria.visualizzaPrenotati(app);
		assertEquals(0,prenotati.size());
	}
	@Test
	public void test02NessunoStudentePrenotato() {
			Docente d = new Docente(222,"Pippo Pluto");
			Corso c = new Corso("Test",d.getNomeDocente(),9);
			segreteria.aggiungiDocente(d);
			try {
				segreteria.aggiungiCorso(c);
			} catch (DocenteNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Appello app = new Appello(123,"Test",d.getNomeDocente());
			try {
				segreteria.creaAppello(app);
			} catch (DocenteNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				segreteria.prenotazione(null, app);
			} catch (StudenteNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			prenotati = segreteria.visualizzaPrenotati(app);
			assertEquals(0,prenotati.size());
			
		}
	@Test
	public void test03UnoStudentePrenotato() {
		Docente d = new Docente(222,"Pippo Pluto");
		Corso c = new Corso("Test",d.getNomeDocente(),9);
		Studente s = new Studente(144,"Tizio","Sempronio");
		segreteria.aggiungiStudente(s);
		segreteria.aggiungiDocente(d);
		try {
			segreteria.aggiungiCorso(c);
		} catch (DocenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Appello app = new Appello(123,"Test",d.getNomeDocente());
		try {
			segreteria.creaAppello(app);
		} catch (DocenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			segreteria.prenotazione(s, app);
		} catch (StudenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prenotati = segreteria.visualizzaPrenotati(app);
		assertEquals(1,prenotati.size());
		
		for(Prenotazione p : prenotati) {
			System.out.println(p+"\n");
		}
		
	}
	@Test
	public void test04PiuStudentiPrenotati() {
		Docente d = new Docente(222,"Pippo Pluto");
		Corso c = new Corso("Test",d.getNomeDocente(),9);
		Studente s = new Studente(144,"Tizio","Sempronio");
		Studente t = new Studente(146,"Pluto","Pippo");
		Studente a = new Studente(145,"Andonie","Maiotti");
		segreteria.aggiungiStudente(a);
		segreteria.aggiungiStudente(s);
		segreteria.aggiungiStudente(t);
		segreteria.aggiungiDocente(d);
		try {
			segreteria.aggiungiCorso(c);
		} catch (DocenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Appello app = new Appello(123,"Test",d.getNomeDocente());
		try {
			segreteria.creaAppello(app);
		} catch (DocenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			segreteria.prenotazione(s, app);
			segreteria.prenotazione(a,app);
			segreteria.prenotazione(t, app);
		} catch (StudenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		prenotati = segreteria.visualizzaPrenotati(app);
		assertEquals(3,prenotati.size());
		
		for(Prenotazione p : prenotati) {
			System.out.println(p+"\n");
		}
	}
	@Test
	public void test05AppelloNonRegistratoUnaPrenotazione() {
		Docente d = new Docente(222,"Pippo Pluto");
		Corso c = new Corso("Test",d.getNomeDocente(),9);
		Studente s = new Studente(144,"Tizio","Sempronio");
		segreteria.aggiungiStudente(s);
		segreteria.aggiungiDocente(d);
		Appello a = new Appello(123,"Test",d.getNomeDocente());
		try {
			segreteria.aggiungiCorso(c);
		} catch (DocenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			segreteria.prenotazione(s, a);
		} catch (StudenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prenotati = segreteria.visualizzaPrenotati(a);
		assertEquals(0,prenotati.size());
	}
	@Test
	public void test06PrenotazioneSenzaAppello() {
		Docente d = new Docente(222,"Pippo Pluto");
		Corso c = new Corso("Test",d.getNomeDocente(),9);
		Studente s = new Studente(144,"Tizio","Sempronio");
		segreteria.aggiungiStudente(s);
		segreteria.aggiungiDocente(d);
		try {
			segreteria.aggiungiCorso(c);
		} catch (DocenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			segreteria.prenotazione(s, null);
		} catch (StudenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prenotati = segreteria.visualizzaPrenotati(null);
		assertEquals(0,prenotati.size());
}
	
	@Test
	public void test07DocenteNonRegistratoUnAppelloUnaPrenotazione() {
		Docente d = new Docente(222,"Pippo Pluto");
		Corso c = new Corso ("Test",d.getNomeDocente(),9);
	
		try {
			segreteria.aggiungiCorso(c);
		} catch (DocenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Studente s = new Studente(144,"Tizio","Sempronio");
		segreteria.aggiungiStudente(s);
		Appello a = new Appello(123,"Test",d.getNomeDocente());
		try {
			segreteria.creaAppello(a);
		} catch (DocenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			segreteria.prenotazione(s, a);
		} catch (StudenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prenotati = segreteria.visualizzaPrenotati(a);
		assertEquals(0,prenotati.size());
	} 
	@Test
	public void test08PrenotazioneAppelloSenzaDocente() {
		Studente s = new Studente(111,"Tizio","Sempronio");
		segreteria.aggiungiStudente(s);
		Corso c = new Corso("Test",null,9);
		try {
			segreteria.aggiungiCorso(c);
		} catch (DocenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Appello a = new Appello(222,c.getNomeCorso(),null);
		try {
			segreteria.creaAppello(a);
		} catch (DocenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			segreteria.prenotazione(s, a);
		} catch (StudenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prenotati = segreteria.visualizzaPrenotati(a);
		assertEquals(0,prenotati.size());
		
		
	}
	@Test
	public void test09CorsoNonRegistratoUnAppelloUnEsamePrenotato() {
		Docente d = new Docente(111,"Nome Cognome");
		segreteria.aggiungiDocente(d);
		Studente s = new Studente(333,"Tizio","Sempronio");
		segreteria.aggiungiStudente(s);
		Corso c = new Corso("Test",d.getNomeDocente(),9);
		Appello a = new Appello(222, c.getNomeCorso(),d.getNomeDocente());
		
		try {
			segreteria.creaAppello(a);
		} catch (DocenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			segreteria.prenotazione(s,a);
		} catch (StudenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prenotati = segreteria.visualizzaPrenotati(a);
		assertEquals(0,prenotati.size());
	}
	@Test
	public void test10NoCorsoUnAppelloUnEsamePrenotato() {
		Docente d = new Docente(111,"Nome Cognome");
		segreteria.aggiungiDocente(d);
		Studente s = new Studente(333,"Tizio","Sempronio");
		segreteria.aggiungiStudente(s);
		Appello a = new Appello(222, null,d.getNomeDocente());
		
		try {
			segreteria.creaAppello(a);
		} catch (DocenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			segreteria.prenotazione(s,a);
		} catch (StudenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prenotati = segreteria.visualizzaPrenotati(a);
		assertEquals(0,prenotati.size());
	}
	@Test
	public void test11NienteDiNiente(){
		try {
			segreteria.prenotazione(null, null);
		} catch (StudenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prenotati = segreteria.visualizzaPrenotati(null);
		assertEquals(0,prenotati.size());		
	}
	@Test
	public void test12PrenotazioneDuplicata(){
		Studente s = new Studente(111,"Pippo","Pluto");
		segreteria.aggiungiStudente(s);
		Docente d = new Docente(123,"Ajeje Brazorf");
		segreteria.aggiungiDocente(d);
		Corso c = new Corso("Test",d.getNomeDocente(),9);
		try {
			segreteria.aggiungiCorso(c);
		} catch (DocenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Appello  a = new Appello(124,c.getNomeCorso(),d.getNomeDocente());
		try {
			segreteria.creaAppello(a);
		} catch (DocenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			segreteria.prenotazione(s, a);
			segreteria.prenotazione(s, a);
		} catch (StudenteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prenotati = segreteria.visualizzaPrenotati(a);
		
		for(Prenotazione p : prenotati) {
			System.out.println(p+"\n");
		}
		assertEquals(1,prenotati.size());
		
		
		
	}
	
}
		
		



