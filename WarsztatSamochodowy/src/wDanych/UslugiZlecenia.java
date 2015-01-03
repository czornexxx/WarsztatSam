package wDanych;

public class UslugiZlecenia {
	

	private String idZlecenia;
	private String idUslugi;
	private boolean wykonano;
	
	
	public UslugiZlecenia(String idZlecenia, String idUslugi, boolean wykonano) {
		super();
		this.idZlecenia = idZlecenia;
		this.idUslugi = idUslugi;
		this.wykonano = wykonano;
	}	
	
	
	public String showUsluga(){
		
		return Usluga.showUsluga(idUslugi);
	}

	@Override
	public String toString() {
		return "UslugiZlecenia [idZlecenia=" + idZlecenia + ", idUslugi="
				+ idUslugi + ", wykonano=" + wykonano + "]";
	}

	// Getery Setery
	
	public String getIdUslugi() {
		return idUslugi;
	}
	public void setIdUslugi(String idUslugi) {
		this.idUslugi = idUslugi;
	}
	public String getIdZlecenia() {
		return idZlecenia;
	}
	public void setIdZlecenia(String idZlecenia) {
		this.idZlecenia = idZlecenia;
	}
	public String getWykonano(){
		
		if(wykonano)
			return "1";
		else
			return "0";		
	}	
	public boolean isWykonano() {
		return wykonano;
	}
	public void setWykonano(boolean wykonano) {
		this.wykonano = wykonano;
	}	

}
