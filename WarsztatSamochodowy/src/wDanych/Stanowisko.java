package wDanych;

import java.util.ArrayList;

public class Stanowisko {

	private String idStanowisko;
	private String opis;
	private String wynagrodzenie;
	private String nazwa;
	
	public static ArrayList<Stanowisko> listaStanowisk = new ArrayList<Stanowisko>(0);
	
	public Stanowisko(String idStanowisko, String opis, String wynagrodzenie, String nazwa) {
		super();
		this.idStanowisko = idStanowisko;
		this.opis = opis;
		this.wynagrodzenie = wynagrodzenie;
		this.nazwa = nazwa;
	}
	
	
	public Stanowisko(String opis, String wynagrodzenie, String nazwa) {
		super();
		this.opis = opis;
		this.wynagrodzenie = wynagrodzenie;
		this.nazwa = nazwa;
	}

	
	
	@Override
	public String toString() {
		return "Stanowisko [idStanowisko=" + idStanowisko + ", opis=" + opis
				+ ", wynagrodzenie=" + wynagrodzenie + ", nazwa=" + nazwa + "]";
	}	
	
	
	// Getery Setery

	public String getIdStanowisko() {
		return idStanowisko;
	}
	public static ArrayList<Stanowisko> getListaStanowisk() {
		return listaStanowisk;
	}
	public static void setListaStanowisk(ArrayList<Stanowisko> listaStanowisk) {
		Stanowisko.listaStanowisk = listaStanowisk;
	}
	public void setIdStanowisko(String idStanowisko) {
		this.idStanowisko = idStanowisko;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getWynagrodzenie() {
		return wynagrodzenie;
	}
	public void setWynagrodzenie(String wynagrodzenie) {
		this.wynagrodzenie = wynagrodzenie;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}	
	
}
