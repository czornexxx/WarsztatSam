package wDanych;

import java.util.ArrayList;

public class Klient {

	private String pesel;
	private String imie;
	private String nazwisko;
	private String adres;
	private boolean intnieje; 
	
// Kolekcje danych	
	private ArrayList<Samochod> lSamochody = null;
	
	public Klient(String Pesel, String Imie, String Nazwisko, String Adres){
		
		this.pesel = Pesel;
		this.imie = Imie;
		this.nazwisko = Nazwisko;
		this.adres = Adres;
	}

	
	public boolean isIntnieje() {
		return intnieje;
	}

	public void setIntnieje(boolean intnieje) {
		this.intnieje = intnieje;
	}

	@Override
	public String toString() {
		return "Klient [Pesel=" + pesel + ", Imie=" + imie + ", Nazwisko="
				+ nazwisko + ", Adres=" + adres + "]";
	}
	
	public String showCars() {
		
		String tmp = "";
		
		for(Samochod tmpSam : lSamochody)
			tmp += tmpSam.toString() + " \n"; 
			
		return tmp;
	}
	
//**************** SETERY GETERY **************************
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


	public String getAdres() {
		return adres;
	}

	
	public void setAdres(String adres) {
		this.adres = adres;
	}

	
	public ArrayList<Samochod> getlSamochody() {
		return lSamochody;
	}


	public void setlSamochody(ArrayList<Samochod> lSamochody) {
		this.lSamochody = lSamochody;
	}
	
}
