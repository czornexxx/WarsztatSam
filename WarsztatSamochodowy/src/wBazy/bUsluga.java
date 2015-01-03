package wBazy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import wDanych.MiejsceSerwisowe;
import wDanych.Usluga;

public class bUsluga {

	private static obslugaZapytan obsZap = obslugaZapytan.ObslugaZapytan;
		
	public static void WczytajUslugi(){	
		
		ResultSet rs = null;
		
		rs = obsZap.select("SELECT idUs³uga, Nazwa, Opis, Cena, Dostepna FROM us³uga;");
		
		if(rs != null){	
			
			try {
				
				Usluga.ListaUslug.clear();
				
				while(rs.next()){
				
					Usluga tmpUsl = new Usluga(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5));	// Utworzenie uzytkownika z danych z bazy
					Usluga.ListaUslug.add(tmpUsl);				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	
	public static int ZapiszUsluge(Usluga usluga){
		
		int result = -1;
		if(usluga != null){
			
		
			String query = "INSERT INTO Us³uga ( Nazwa, Opis, Cena, Dostepna ) VALUES ('" + usluga.getNazwa() + "','" + usluga.getOpis() + "','" + usluga.getCena() + "','" +
							usluga.getDostepna() +"');";
			result = obsZap.insert(query);
			
			if(result == 1)				
				WczytajUslugi(); 		// jeœli poprawnie dodano to zaktualizuj liste. 				
				
		}
		
		return result;
	}	
	
	public static int AktualizujUsluge(Usluga usluga){
		
		int result = -1;
		if(usluga != null){

			String query = "UPDATE Us³uga SET  Nazwa ='"+ usluga.getNazwa() + "', Opis ='" + usluga.getOpis() + "', Cena = '" + usluga.getCena() + "', Dostepna ='" + usluga.getDostepna() +
					       "' WHERE idUs³uga ='"+ usluga.getIdUsluga() +"';";
			
			result = obsZap.update(query);	
			
			if(result == 1)				
				WczytajUslugi(); 				
			
		}
		
		return result;
	}
}
