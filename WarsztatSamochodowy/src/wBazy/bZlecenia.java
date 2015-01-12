package wBazy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import wDanych.Czesci;
import wDanych.CzesciZlecenia;
import wDanych.Klient;
import wDanych.UslugiZlecenia;
import wDanych.Zlecenia;

public class bZlecenia {

	private static obslugaZapytan obsZap = obslugaZapytan.ObslugaZapytan;
	
	
	public static ArrayList<Zlecenia> WczytajZleceniaKlienta(String idKlienta, String idSamochodu){	
		
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
	
	
	public static int ZapiszZlecenieKlienta(Zlecenia zlecenie){
		
		int result = -1;
		if(zlecenie != null){
			
			String wykonano = "";
			if(zlecenie.isWykonano())
				wykonano = "1";
			else
				wykonano = "0";
				
			String query = "INSERT INTO zlecenia ( DataPrzyjecia, DataZakonczenia, Koszt, Wykonano, Samochod_idSamochod, Samochod_Klient_Pesel, Pracownik_Pesel, MiejsceSerwisowe_idMiejsceSerwisowe ) VALUES "
					+ "('" + zlecenie.getDataPrzyjecia() + "','" + zlecenie.getDataZakonczenia() + "','" + zlecenie.getKoszt() + "','" + wykonano + "','" + zlecenie.getIdSamochod() + "','" + zlecenie.getIdKlientPesel() + "','" + zlecenie.getIdPracownik() + "','" + zlecenie.getIdMiejsceSerisowe() + "');";
			
			result = obsZap.insert(query);			
		
			if(result == 1){
				
				ArrayList<Zlecenia> tmp = WczytajZleceniaKlienta(zlecenie.getIdKlientPesel(), zlecenie.getIdSamochod());
				zlecenie.setIdZlecenia(tmp.get(tmp.size()-1).getIdZlecenia());
			}
			
			// Zapisanie czesci
			if(zlecenie.getCzesciZlecenia().size() > 0){
				
				for(CzesciZlecenia cz:zlecenie.getCzesciZlecenia()){
					
					bCzesciZlecenia.ZapiszCzescZlecenia(cz);					
				}
			}
			
			// Zapisanie uslug
			if(zlecenie.getUslugiZlecenia().size() > 0){
				
				for(UslugiZlecenia usl:zlecenie.getUslugiZlecenia()){
					
					bUslugiZlecenia.ZapiszUslugeZlecenia(usl);				
				}
			}
			
		}
		
		return result;
	}
	
	
	
	
	public static int AktualizujZlecenieKlienta(Zlecenia zlecenie){
		
		int result = -1;
		if(zlecenie != null){
			
			String wykonano = "";
			if(zlecenie.isWykonano())
				wykonano = "1";
			else
				wykonano = "0";
				
			String query = "UPDATE zlecenia SET DataPrzyjecia ='" + zlecenie.getDataPrzyjecia() +"', DataZakonczenia ='" + zlecenie.getDataZakonczenia() +"', Koszt ='" + zlecenie.getKoszt() +"', Wykonano ='" + wykonano +"', Samochod_idSamochod =' " + zlecenie.getIdSamochod() + "', Samochod_Klient_Pesel ='" + zlecenie.getIdKlientPesel()
					        + "', MiejsceSerwisowe_idMiejsceSerwisowe ='" + zlecenie.getIdMiejsceSerisowe() + "' WHERE idZlecenia ='" + zlecenie.getIdZlecenia() +"';";
			
			result = obsZap.update(query);			
		

			// Aktualizowanie czesci
			if(zlecenie.getCzesciZlecenia().size() > 0){
				
				for(CzesciZlecenia cz:zlecenie.getCzesciZlecenia()){
					
					bCzesciZlecenia.AktualizujCzescZlecenia(cz);					
				}
			}
			
			// Aktualizowanie uslug
			if(zlecenie.getUslugiZlecenia().size() > 0){
				
				for(UslugiZlecenia usl:zlecenie.getUslugiZlecenia()){
					
					bUslugiZlecenia.AktualizujUslugeZlecenia(usl);				
				}
			}
			
		}
		
		return result;
	}
	
	
}