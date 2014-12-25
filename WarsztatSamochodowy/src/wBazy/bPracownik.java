package wBazy;

import java.sql.ResultSet;
import java.sql.SQLException;

import wDanych.Pracownik;

public class bPracownik {

	private static obslugaZapytan obsZap = obslugaZapytan.ObslugaZapytan;
	
	public static Pracownik WczytajPracownika(String Pesel){	
		
		Pracownik nowyPracownik = null;
		ResultSet rs = null;
		
		rs = obsZap.select("SELECT Pesel, Imie, Nazwisko, Miejscowosc, KodPocztowy, Ulica, Stanowisko_idStanowisko FROM pracownik WHERE pesel = " + Pesel );
		
		if(rs != null){	
			
			try {
				if(rs.next())
				
					nowyPracownik = new Pracownik(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));	// Utworzenie uzytkownika z danych z bazy
					nowyPracownik.setIntnieje(true);		// ustawienie, ¿e pracownika ma dane w bazie.
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return nowyPracownik;
	}
	
	
	public static int ZapiszPracownika(Pracownik pracownik){
		
		int result = -1;
		if(pracownik != null){
			
			String query = "INSERT INTO pracownik ( Pesel, Imie, Nazwisko, Miejscowosc, KodPocztowy, Ulica, Stanowisko_idStanowisko) "
					+ "VALUES ('" + pracownik.getPesel() + "','" + pracownik.getImie() + "','" + pracownik.getNazwisko() + "','" +
					pracownik.getMiejscowosc()+ "','" + pracownik.getKodPocztowy() + "','" + pracownik.getUlica() + "','" + pracownik.getStanowisko()+"');";
			
			result = obsZap.insert(query);			
		}
		
		return result;
	}
	
	/*
	public static int AktualizujPraconwika(Pracownik pracownik){
		
		int result = -1;
		if(pracownik != null){
			
			String query = "UPDATE klient SET Imie ='"+ klient.getImie()+"', Nazwisko ='"+ klient.getNazwisko() +"', Adres = '"+ klient.getAdres() +"' WHERE `Pesel`='"+ klient.getPesel() +"';";
			
			result = obsZap.insert(query);			
		}
		
		return result;
	} */
	
}
