package wDanych;

import java.util.ArrayList;

public class MiejsceSerwisowe {

	public static ArrayList<MiejsceSerwisowe> ListaMiejscSerwisowych = new ArrayList<MiejsceSerwisowe>(0);
	
	private String idMiejsca;
	private String Nazwa;

	
	public MiejsceSerwisowe(String idMiejsca, String nazwa) {
		super();
		this.idMiejsca = idMiejsca;
		Nazwa = nazwa;
	}
	
	public MiejsceSerwisowe(String nazwa){

		super();
		this.Nazwa = nazwa;
	}
	
	
	public static String wypiszMiejsca(){
		
		String tmp = "";
		
		for(MiejsceSerwisowe ms: ListaMiejscSerwisowych)
			tmp += ms.toString() + "\n";
		
		return tmp;
	}
	
	
	@Override
	public String toString() {
		return "MiejsceSerwisowe [idMiejsca=" + idMiejsca + ", Nazwa=" + Nazwa
				+ "]";
	}
	
	// Getery Setery
	
	public String getIdMiejsca() {
		return idMiejsca;
	}


	public void setIdMiejsca(String idMiejsca) {
		this.idMiejsca = idMiejsca;
	}


	public String getNazwa() {
		return Nazwa;
	}


	public void setNazwa(String nazwa) {
		Nazwa = nazwa;
	}
	
}
