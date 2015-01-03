package wBazy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import wDanych.Zlecenia;

public class bZlecenia {

	private static obslugaZapytan obsZap = obslugaZapytan.ObslugaZapytan;
	
	
	public static ArrayList<Zlecenia> WczytajSamochodyKlienta(String idKlienta, String idSamochodu){	
		
		ArrayList<Zlecenia> zlecenia = new ArrayList<Zlecenia>(0);
		ResultSet rs = null;
		
		rs = obsZap.select("SELECT idZlecenia, DataPrzyjecia, DataZakonczenia, Koszt, Wykonano, Samochod_idSamochod, Samochod_Klient_Pesel, Pracownik_Pesel, MiejsceSerwisowe_idMiejsceSerwisowe "
							+ "FROM zlecenia WHERE Samochod_Klient_Pesel = '" + idKlienta + "' AND Samochod_idSamochod = '" + idSamochodu + "' ;");
		
		if(rs != null){	
			
			try {
				while(rs.next()){
				
					Zlecenia tmpSam = new Zlecenia(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));	// Utworzenie uzytkownika z danych z bazy
					zlecenia.add(tmpSam);				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		
			// Wczytnaie uslug, czesci.
			if(!zlecenia.isEmpty()){
			
				for(Zlecenia zlec : zlecenia){		// Wczytanie uslug, czesci w zleceniu
			
					zlec.setUslugiZlecenia(bUslugiZlecenia.WczytajUslugiZlecenia(zlec.getIdZlecenia()));
					zlec.setCzesciZlecenia(bCzesciZlecenia.WczytajCzesciZlecenia(zlec.getIdZlecenia()));
				}			
			}		
		}

		return zlecenia;
	}
	
}