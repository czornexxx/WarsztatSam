package wDanych;

public class Pracownik {
	
	private String pesel;
	private String imie;
	private String nazwisko;
	private String miejscowosc;
	private String kodPocztowy;
	private String ulica;
	private String stanowisko;
	private boolean intnieje; 
	
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
	
	
//*********** Setery Getery *****************
	
	public String getStanowisko() {
		return stanowisko;
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
