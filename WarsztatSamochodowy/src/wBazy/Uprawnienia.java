package wBazy;

public enum Uprawnienia { 
	
	ADMIN(0,"root","asdf");
//	WLASCICIEL(1), 
//	KIEROWNIK(2),
//	RECEPCJONISTA(3),  
//	SERWISANT(4),
//	KLIENT(5), 
//	WSZYSCY(6),
//	LOGOWANIE(7);	
	
	private final int nrUprawnienia;
	private final String login;
	private final String haslo;
	
	Uprawnienia(int idx, String Login, String Haslo){
	
		nrUprawnienia = idx;		
		login = Login;
		haslo = Haslo;
	}
	
	public int getNr()
	{
		return nrUprawnienia;
	}
	
	public String getLogin()
	{
		return login;
	}
	
	public String getHaslo()
	{
		return haslo;
	}
}
