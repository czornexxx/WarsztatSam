package wBazy;

public enum Uprawnienia { 
	
	ADMIN(0,"root","asdf"),
	WLASCICIEL(1,"wlasciciel","wlasciciel"), 
	KIEROWNIK(2,"kierownik","kierownik"),
	RECEPCJONISTA(3,"recepcja","recepcja"),  
	SERWISANT(4,"serwisant","serwisant"),
	KLIENT(5,"klient","klient1"), 
	WSZYSCY(6,"all","all"),
	LOGOWANIE(7,"login","login1");	
	
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
