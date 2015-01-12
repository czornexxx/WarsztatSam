package wDanych;

import java.util.ArrayList;

import wBazy.bKlient;

public class Pracownik {
	
	private String pesel;
	private String imie;
	private String nazwisko;
	private String miejscowosc;
	private String kodPocztowy;
	private String ulica;
	private String stanowisko;
	private boolean intnieje; 

	// Kolekcje danych	
		private ArrayList<Klient> lKlientow = null;
		private ArrayList<Zlecenia> lZlecen = null;
	
	
	public Pracownik(String pesel, String imie, String nazwisko,
			String miejscowosc, String kodPocztowy, String ulica, String stanowisko) {

		this.pesel = pesel;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.miejscowosc = miejscowosc;
		this.kodPocztowy = kodPocztowy;
		this.ulica = ulica;
		this.stanowisko = stanowisko;
		this.intnieje = false;
	}
	
//*********** Modyfikacja danych ************
		
	public Klient nowyKlient(String Pesel, String Imie, String Nazwisko, String Adres){
		
		Klient nowyKlient = new Klient(Pesel, Imie, Nazwisko, Adres);
		bKlient.ZapiszKlienta(nowyKlient);
		
		lKlientow.add(nowyKlient);
		
		return nowyKlient;
	}

	public Klient wyszukajKlienta(String Pesel){
		
		for(Klient kl: lKlientow){
			
			if(kl.getPesel().equals(Pesel))
				return kl;			
		}
		
		return null;		
	}
	
	public ArrayList<Klient> wyszukajKlienta(String Imie, String Nazwisko){
		
		ArrayList<Klient> tmplKlientow = new ArrayList<Klient>();
		
		
		for(Klient kl: lKlientow){
			
			System.out.println(kl.toString());
			
			if(kl.getImie().equals(Imie) && kl.getNazwisko().equals(Nazwisko))
				tmplKlientow.add(kl);			
		}
		
		if(tmplKlientow.size() > 0)		
			return tmplKlientow;
	
		return null;
	}
	
	

//*********** Wyswietlanie danych ************
	
	public void showKlient(){
		
		for(Klient kl :lKlientow){
			
			System.out.println(kl.toString());
			System.out.println(kl.showCars());
		}		
	}
	
	
	
	
	
	
//*********** Setery Getery *****************
	
	
	
	public String getStanowisko() {
		return stanowisko;
	}


	public ArrayList<Klient> getlKlientow() {
		return lKlientow;
	}


	public void setlKlientow(ArrayList<Klient> lKlientow) {
		this.lKlientow = lKlientow;
	}


	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getMiejscowosc() {
		return miejscowosc;
	}

	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}

	public String getKodPocztowy() {
		return kodPocztowy;
	}

	public void setKodPocztowy(String kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public boolean isIntnieje() {
		return intnieje;
	}

	public void setIntnieje(boolean intnieje) {
		this.intnieje = intnieje;
	}


	@Override
	public String toString() {
		return "Pracownik [pesel=" + pesel + ", imie=" + imie + ", nazwisko="
				+ nazwisko + ", miejscowosc=" + miejscowosc + ", kodPocztowy="
				+ kodPocztowy + ", ulica=" + ulica + ", stanowisko="
				+ stanowisko + "]";
	}

}
