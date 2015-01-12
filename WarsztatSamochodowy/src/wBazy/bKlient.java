package wBazy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import wDanych.Klient;
import wDanych.Samochod;
import wBazy.obslugaZapytan;;

public class bKlient {

	private static obslugaZapytan obsZap = obslugaZapytan.ObslugaZapytan;
	
	public static Klient WczytajKlienta(String Pesel){	
		
		Klient nowyKlient = null;
		ResultSet rs = null;
		
		rs = obsZap.select("SELECT Pesel, Imie, Nazwisko, Adres FROM klient WHERE pesel = " + Pesel );
		
		if(rs != null){	
			
			try {
				if(rs.next()){
				
					nowyKlient = new Klient(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));	// Utworzenie uzytkownika z danych z bazy
					nowyKlient.setIntnieje(true);		// ustawienie, ¿e klient ma dane w bazie.
				
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}

		return nowyKlient;
	}
	
	public static ArrayList<Klient> WczytajListeKlientow(){	
		
		Klient nowyKlient = null;
		ArrayList<Klient> lKlientow = new ArrayList<Klient>(0);
		ResultSet rs = null;
		
		rs = obsZap.select("SELECT Pesel, Imie, Nazwisko, Adres FROM klient ");
		
		if(rs != null){	
			try {
			while(rs.next()){
				
					nowyKlient = new Klient(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));	// Utworzenie uzytkownika z danych z bazy
					nowyKlient.setIntnieje(true);		// ustawienie, ¿e klient ma dane w bazie.
					
					lKlientow.add(nowyKlient);
				}
			
			// Wczytanie samochodow klietna
			for(Klient kl :lKlientow){
				
				kl.wczytajSamochody();
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}

		return lKlientow;
	}
	
	
	public static int ZapiszKlienta(Klient klient){
		
		int result = -1;
		if(klient != null){
			
			String query = "INSERT INTO klient ( Pesel, Imie, Nazwisko, Adres ) VALUES ('" + klient.getPesel() + "','" + klient.getImie() + "','" + klient.getNazwisko() + "','" + klient.getAdres() + "');";
			
			result = obsZap.insert(query);			
		}
		
		return result;
	}
	
	public static int AktualizujKlienta(Klient klient){
		
		int result = -1;
		if(klient != null){
			
			String query = "UPDATE klient SET Imie ='"+ klient.getImie()+"', Nazwisko ='"+ klient.getNazwisko() +"', Adres = '"+ klient.getAdres() +"' WHERE `Pesel`='"+ klient.getPesel() +"';";
			
			result = obsZap.update(query);			
		}
		
		return result;
	}
	
}
