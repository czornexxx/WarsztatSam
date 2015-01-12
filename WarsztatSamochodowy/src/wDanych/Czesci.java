package wDanych;

import java.util.ArrayList;

public class Czesci {

	public static ArrayList<Czesci> ListaCzescia = new ArrayList<Czesci>(0);
	
	private String idCzesci;
	private String model;
	private String cena;
	private String firma;
	private String nazwa;
	private int stanMagazynowy;

	
	public Czesci(String idCzesci, String model, String cena, String firma,
			String nazwa, int stanMagazynowy) {
		super();
		this.idCzesci = idCzesci;
		this.model = model;
		this.cena = cena;
		this.firma = firma;
		this.nazwa = nazwa;
		this.stanMagazynowy = stanMagazynowy;
	}	
	
		
	public Czesci(String model, String cena, String firma, String nazwa,
			int stanMagazynowy) {
		super();
		this.model = model;
		this.cena = cena;
		this.firma = firma;
		this.nazwa = nazwa;
		this.stanMagazynowy = stanMagazynowy;
	}


	public static String showCzesc(String idCze){
		
		String tmp = "";
		
		Czesci znaleziona = null;
		
		for(Czesci cze: ListaCzescia){
			
			if(cze.getIdCzesci().equals(idCze)){
				
				znaleziona = cze;
				break;				
			}			
		}
		
		if(znaleziona != null){
			
			tmp = znaleziona.toString();
		}
				
		return tmp;
	}
	
	
	public static Czesci getCzesc(int id){
		
		if(id > ListaCzescia.size())
			return null;
		
		return ListaCzescia.get(id);		
	}

	@Override
	public String toString() {
		return "Czesci [idCzesci=" + idCzesci + ", model=" + model + ", cena="
				+ cena + ", firma=" + firma + ", nazwa=" + nazwa
				+ ", stanMagazynowy=" + stanMagazynowy + "]";
	}
	
	public static String showCzesci(){
		
		String tmp = "";
		
		for(Czesci czesc : ListaCzescia)
			tmp += czesc.toString() + "\n";
		
		return tmp;
	}
	
	// Getery Setery
	
	public String getIdCzesci() {
		return idCzesci;
	}
	public void setIdCzesci(String idCzesci) {
		this.idCzesci = idCzesci;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCena() {
		return cena;
	}
	public void setCena(String cena) {
		this.cena = cena;
	}
	public String getFirma() {
		return firma;
	}
	public void setFirma(String firma) {
		this.firma = firma;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public int getStanMagazynowy() {
		return stanMagazynowy;
	}
	public void setStanMagazynowy(int stanMagazynowy) {
		this.stanMagazynowy = stanMagazynowy;
	}
	
	
	
}
