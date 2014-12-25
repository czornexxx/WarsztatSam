package wBazy;

import java.sql.ResultSet;
import java.sql.SQLException;

import wDanych.Samochod;;

public class bSamochod {
	
	private static obslugaZapytan obsZap = obslugaZapytan.ObslugaZapytan;
	
	public static Samochod Wczytaj(String idKlienta){	
		
		Samochod nowySamochod = null;
		ResultSet rs = null;
		
		rs = obsZap.select("SELECT idSamochod, Klient_Pesel, Marka, Model, NumerRej, Rok FROM samochod WHERE Klient_Pesel = " + idKlienta );
		
		if(rs != null){	
			
			try {
				if(rs.next())
				
					nowySamochod = new Samochod(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));	// Utworzenie uzytkownika z danych z bazy
					nowySamochod.setIstnieje(true);		// ustawienie, �e klient ma dane w bazie.
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}

		return nowySamochod;
	}
	
	
	public static int Zapisz(Samochod samochod){
		
		int result = -1;
		if(samochod != null){
			
			String query = "INSERT INTO samochod ( Klient_Pesel, Marka, Model, NumerRej, Rok ) VALUES ( '" + 
							samochod.getKlientPesel() + "','" + samochod.getMarka() + "','" + samochod.getModel() + "','" + samochod.getNrRejstracyjny() + "','" + 
							samochod.getRokProdukcji() + "');";
			
			result = obsZap.insert(query);
			
			if(result == 1){
			
				samochod.setIstnieje(true);
				Samochod tmp = bSamochod.Wczytaj(samochod.getKlientPesel());
				samochod.setIdSamochodu(tmp.getIdSamochodu());				
			}
		}
		return result; 
	}
	
	public static int Aktualizuj(Samochod samochod){
		
		int result = -1;
		if(samochod != null){
			
			String query = "UPDATE samochod SET idSamochod ='"+ samochod.getIdSamochodu() +"', Klient_Pesel ='"+ samochod.getKlientPesel() +"', Marka = '"+ samochod.getMarka()
					+"', Model = '"+ samochod.getMarka() +"', NumerRej = '" + samochod.getNrRejstracyjny() +"', Rok = '" + samochod.getRokProdukcji() +
					"' WHERE `Pesel`='" + samochod.getKlientPesel() +"';";
			
			result = obsZap.insert(query);			
		}
		
		return result;
	}
	
}
