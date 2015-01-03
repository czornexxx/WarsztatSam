package wDanych;

import java.util.ArrayList;

public class Usluga {

	public static ArrayList<Usluga> ListaUslug = new ArrayList<Usluga>(0);
	
	private String idUsluga;
	private String nazwa;
	private String opis;
	private String cena;
	private boolean dostepna;
	
	
	public Usluga(String idUsluga, String nazwa, String opis, String cena, boolean dostepna) {
		super();
		this.idUsluga = idUsluga;
		this.nazwa = nazwa;
		this.opis = opis;
		this.cena = cena;
		this.dostepna = dostepna;
	}
	
	public Usluga(String nazwa, String opis, String cena, boolean dostepna) {
		super();
		this.nazwa = nazwa;
		this.opis = opis;
		this.cena = cena;
		this.dostepna = dostepna;
	}

	public static String showUsluga(String idUsl){
		
		String tmp = "";
		
		Usluga znaleziona = null;
		
		for(Usluga usl: ListaUslug){
			
			if(usl.getIdUsluga().equals(idUsl)){
				
				znaleziona = usl;
				break;				
			}			
		}
		
		if(znaleziona != null){
			
			tmp = znaleziona.toString();
		}
		
		
		return tmp;
	}
	
	public static String wypiszUslugi(){
				
			String tmp = "";
			
			for(Usluga us: ListaUslug)
				tmp += us.toString() + "\n";
			
			return tmp;	
	}
		
	@Override
	public String toString() {
		return "Usluga [idUsluga=" + idUsluga + ", nazwa=" + nazwa + ", opis="
				+ opis + ", cena=" + cena + ", dostepna=" + dostepna + "]";
	}
	
	// Getery setery
	
	public String getIdUsluga() {
		return idUsluga;
	}
	public void setIdUsluga(String idUsluga) {
		this.idUsluga = idUsluga;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getCena() {
		return cena;
	}
	public void setCena(String cena) {
		this.cena = cena;
	}
	public String getDostepna(){
	
		String tmpDostapena = "";
		if(dostepna)
			tmpDostapena = "1";
		else
			tmpDostapena = "0";
		
		return tmpDostapena;
	}
	public boolean isDostepna() {
		return dostepna;
	}
	public void setDostepna(boolean dostepna) {
		this.dostepna = dostepna;
	}

}
