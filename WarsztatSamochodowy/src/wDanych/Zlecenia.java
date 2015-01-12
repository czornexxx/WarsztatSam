package wDanych;

import java.util.ArrayList;

import wBazy.bCzesci;
import wBazy.bCzesciZlecenia;
import wBazy.bUslugiZlecenia;


public class Zlecenia {
	
	private String idZlecenia;
	private String dataPrzyjecia;
	private String dataZakonczenia;
	private String koszt;
	private boolean wykonano;
	private String idSamochod;				
	private String idKlientPesel;			// id klienta (pesel)
	private String idPracownik;
	private String idMiejsceSerisowe;
	
	private ArrayList<UslugiZlecenia> uslugiZlecenia = null; 
	private ArrayList<CzesciZlecenia> czesciZlecenia = null;
	
	public Zlecenia(String dataPrzyjecia, String dataZakonczenia,	
			String idSamochod, String idKlientPesel, String idPracownik,
			String idMiejsceSerisowe) {
		
		super();
		this.idZlecenia = "nz";				// nz = nie zapisano
		this.dataPrzyjecia = dataPrzyjecia;
		this.dataZakonczenia = dataZakonczenia;
		this.koszt = "0";
		this.wykonano = false;
		this.idSamochod = idSamochod;
		this.idKlientPesel = idKlientPesel;
		this.idPracownik = idPracownik;
		this.idMiejsceSerisowe = idMiejsceSerisowe;
	}	
	
	public Zlecenia(String dataPrzyjecia,
			String dataZakonczenia, String koszt, boolean wykonano,
			String idSamochod, String idKlientPesel, String idPracownik,
			String idMiejsceSerisowe) {
		
		super();
		this.idZlecenia = "nz";				// nz = nie zapisano
		this.dataPrzyjecia = dataPrzyjecia;
		this.dataZakonczenia = dataZakonczenia;
		this.koszt = koszt;
		this.wykonano = wykonano;
		this.idSamochod = idSamochod;
		this.idKlientPesel = idKlientPesel;
		this.idPracownik = idPracownik;
		this.idMiejsceSerisowe = idMiejsceSerisowe;
	}	
	
	public Zlecenia(String idZlecenia, String dataPrzyjecia,
			String dataZakonczenia, String koszt, boolean wykonano,
			String idSamochod, String idKlientPesel, String idPracownik,
			String idMiejsceSerisowe) {
		
		super();
		this.idZlecenia = idZlecenia;
		this.dataPrzyjecia = dataPrzyjecia;
		this.dataZakonczenia = dataZakonczenia;
		this.koszt = koszt;
		this.wykonano = wykonano;
		this.idSamochod = idSamochod;
		this.idKlientPesel = idKlientPesel;
		this.idPracownik = idPracownik;
		this.idMiejsceSerisowe = idMiejsceSerisowe;
	}	
	
	public String showUslugiZlecenia(){
		
		String tmp = "";
		
		for(UslugiZlecenia usl : uslugiZlecenia)
			tmp += usl.toString() + "\n";
		
		return tmp;
	}
	
	public String showCzesciZlecenia(){
		
		String tmp = "";
		
		for(CzesciZlecenia czesc : czesciZlecenia)
			tmp += czesc.toString() + "\n";
		
		return tmp;
	}
	
//*********** Modyfikacja danych ************

	public int dodajUsluge( String idUslugi, boolean wykonano){
		
		int result = 0;
		
		UslugiZlecenia tmpUs = new UslugiZlecenia(idZlecenia, idUslugi, wykonano);
		result = bUslugiZlecenia.ZapiszUslugeZlecenia(tmpUs);
		
		if(result == 1)
			uslugiZlecenia.add(tmpUs);
		
		return result;		
	}
	
	public int aktualizujUsluge(String idUslugi, boolean wykonano){
		
		int result = 0;
		
		UslugiZlecenia tmpUs = new UslugiZlecenia(idZlecenia, idUslugi, wykonano);
		result = bUslugiZlecenia.AktualizujUslugeZlecenia(tmpUs);
		
		if(result == 1){
			
			for(UslugiZlecenia us: uslugiZlecenia){
				
				if(us.getIdUslugi().equals(idUslugi)){
					
					us.setWykonano(wykonano);
				}
			}
		}
		return result;		
	}
	
	
	
	public int dodajCzesc( String idCzesci, int ilosc){
		
		int result = 0;
		
		CzesciZlecenia tmpCZ = new CzesciZlecenia(idZlecenia, idCzesci, ilosc);
		result = bCzesciZlecenia.ZapiszCzescZlecenia(tmpCZ);
		
		if(result == 1){
			czesciZlecenia.add(tmpCZ);
			bCzesci.WczytajCzesci(); 			// Aktualizacja magazynu
		}
		
		return result;		
	}
	
	public int aktualizujCzesc(String idCzesci, int ilosc){
		
		int result = 0;
		
		CzesciZlecenia tmpCZ = new CzesciZlecenia(idZlecenia, idCzesci, ilosc);
		result = bCzesciZlecenia.AktualizujCzescZlecenia(tmpCZ);
		
		if(result == 1){
			
			for(CzesciZlecenia cz: czesciZlecenia){
				
				if(cz.getIdCzesci().equals(idCzesci)){
					
					cz.setIlosc(ilosc);
					bCzesci.WczytajCzesci(); 				// Aktualizacja magazynu
				}
			}
		}
		
		return result;		
	}
	
	
	@Override
	public String toString() {
		return "Zlecenia [idZlecenia=" + idZlecenia + ", dataPrzyjecia="
				+ dataPrzyjecia + ", dataZakonczenia=" + dataZakonczenia
				+ ", koszt=" + koszt + ", wykonano=" + wykonano
				+ ", idSamochod=" + idSamochod + ", idKlientPesel="
				+ idKlientPesel + ", idPracownik=" + idPracownik
				+ ", idMiejsceSerisowe=" + idMiejsceSerisowe + "]";
	}
	
	// Getery Setery
	
	public ArrayList<CzesciZlecenia> getCzesciZlecenia() {
		return czesciZlecenia;
	}
	public void setCzesciZlecenia(ArrayList<CzesciZlecenia> czesciZlecenia) {
		this.czesciZlecenia = czesciZlecenia;
	}	
	public ArrayList<UslugiZlecenia> getUslugiZlecenia() {
		return uslugiZlecenia;
	}
	public void setUslugiZlecenia(ArrayList<UslugiZlecenia> uslugiZlecenia) {
		this.uslugiZlecenia = uslugiZlecenia;
	}
	public String getIdZlecenia() {
		return idZlecenia;
	}
	public void setIdZlecenia(String idZlecenia) {
		this.idZlecenia = idZlecenia;
	}
	public String getDataPrzyjecia() {
		return dataPrzyjecia;
	}
	public void setDataPrzyjecia(String dataPrzyjecia) {
		this.dataPrzyjecia = dataPrzyjecia;
	}
	public String getDataZakonczenia() {
		return dataZakonczenia;
	}
	public void setDataZakonczenia(String dataZakonczenia) {
		this.dataZakonczenia = dataZakonczenia;
	}
	public String getKoszt() {
		return koszt;
	}
	public void setKoszt(String koszt) {
		this.koszt = koszt;
	}
	public boolean isWykonano() {
		return wykonano;
	}
	public void setWykonano(boolean wykonano) {
		this.wykonano = wykonano;
	}
	public String getIdSamochod() {
		return idSamochod;
	}
	public void setIdSamochod(String idSamochod) {
		this.idSamochod = idSamochod;
	}
	public String getIdKlientPesel() {
		return idKlientPesel;
	}
	public void setIdKlientPesel(String idKlientPesel) {
		this.idKlientPesel = idKlientPesel;
	}
	public String getIdPracownik() {
		return idPracownik;
	}
	public void setIdPracownik(String idPracownik) {
		this.idPracownik = idPracownik;
	}
	public String getIdMiejsceSerisowe() {
		return idMiejsceSerisowe;
	}
	public void setIdMiejsceSerisowe(String idMiejsceSerisowe) {
		this.idMiejsceSerisowe = idMiejsceSerisowe;
	}
	
		
}
