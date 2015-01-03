package wDanych;

public class CzesciZlecenia {

	
	private String idZlecenia;
	private String idCzesci;
	private int ilosc;
	
	public CzesciZlecenia(String idZlecenia, String idCzesci, int ilosc) {
		super();
		this.idZlecenia = idZlecenia;
		this.idCzesci = idCzesci;
		this.ilosc = ilosc;
	}
	
	
	
	public String showCzesc(){
		
		return Czesci.showCzesc(idCzesci);
	}
	
	@Override
	public String toString() {
		return "CzesciZlecenia [idZlecenia=" + idZlecenia + ", idCzesci="
				+ idCzesci + ", ilosc=" + ilosc + "]";
	}
	
	
	// Getery Setery

	public String getIdZlecenia() {
		return idZlecenia;
	}
	public void setIdZlecenia(String idZlecenia) {
		this.idZlecenia = idZlecenia;
	}
	public String getIdCzesci() {
		return idCzesci;
	}
	public void setIdCzesci(String idCzesci) {
		this.idCzesci = idCzesci;
	}
	public int getIlosc() {
		return ilosc;
	}
	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}
	
}
