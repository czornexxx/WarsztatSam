package wDanych;
import java.sql.ResultSet;
import java.sql.SQLException;

import wBazy.Uprawnienia;
import wBazy.bKlient;
import wBazy.bPracownik;
import wBazy.obslugaZapytan;

public class Logowanie {
	
	private static obslugaZapytan obsZap = obslugaZapytan.ObslugaZapytan;
	private static String IdPracownik;
	private static String IdKlient;
	public static int IdUprawnienia;
	public static Klient klient;
	public static Pracownik pracownik;
	
	public Logowanie()
	{
	}
	
	public static int Zaloguj(String login, String haslo)
	{		
		ResultSet rs = null;
		int result = -1;	// -1 -> logowanie nie udane, 0 -> problem z uprawnieniami, 1 -> logowanie udane
		
		rs = obsZap.select("SELECT Uprawnienia, IdKlient, IdPracownik FROM logowanie WHERE Login = '" + login + "' AND Haslo = '" + haslo + "';");
		
		try {
			if (rs.next()){
				
				IdUprawnienia = rs.getInt(1);			// odczytanie danych z logowania
				IdKlient = rs.getString(2);
				IdPracownik = rs.getString(3);
				result = 0;
				
				// zmiana uprawnien polaczenia na odpowiednie dla uzytkownika
				
				if(IdUprawnienia == Uprawnienia.KLIENT.getNr()){
					
					obsZap.changePrivileges(IdUprawnienia);
					klient = bKlient.WczytajKlienta(IdKlient);
					result = 1;
					
					Init.InitKlient(klient);
					
				}else if(IdUprawnienia == Uprawnienia.ADMIN.getNr() || IdUprawnienia == Uprawnienia.WLASCICIEL.getNr() ||
						IdUprawnienia == Uprawnienia.KIEROWNIK.getNr() || IdUprawnienia == Uprawnienia.RECEPCJONISTA.getNr() ||
						IdUprawnienia == Uprawnienia.SERWISANT.getNr() ){
					
					obsZap.changePrivileges(IdUprawnienia);
					pracownik = bPracownik.WczytajPracownika(IdPracownik);
					result = 1;
				}else{
					
					System.err.println("Dziwne dane w uprawnieniach do logowania");
				}
				// Stworzenie nowej osoby w zaleznosci od uprawnien

				System.out.println("Id upr: " + IdUprawnienia + " idKlient: "+ IdKlient + " idPraco: " + IdPracownik);
			
			}
			else {
				System.out.println("Nie ma takiego uzytkownika");
				System.out.println(rs.toString());
			}
		} catch (SQLException e) {

			System.err.println("Problem z logowaniem");
		}
		
		return result;
	}

}
