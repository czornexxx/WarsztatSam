package wBazy;

import java.sql.ResultSet;
import java.sql.SQLException;

import wDanych.Czesci;

public class bCzesci {
	
	private static obslugaZapytan obsZap = obslugaZapytan.ObslugaZapytan;
	
	public static void WczytajCzesci(){	
		
		ResultSet rs = null;
		
		rs = obsZap.select("SELECT idCzesci, Model, Cena, Firma, Nazwa, StanMagazynowy FROM czesci;");
		
		if(rs != null){	
			
			try {
				
				Czesci.ListaCzescia.clear();
				
				while(rs.next()){
				
					Czesci tmpCzesc = new Czesci(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));	// Utworzenie uzytkownika z danych z bazy
					Czesci.ListaCzescia.add(tmpCzesc);				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	
	public static int ZapiszCzesc(Czesci czesc){
		
		int result = -1;
		if(czesc != null){
			
		
			String query = "INSERT INTO czesci ( Model, Cena, Firma, Nazwa, StanMagazynowy ) VALUES ('" + czesc.getModel() + "','" + czesc.getCena() + "','" +
							czesc.getFirma() + "','" + czesc.getNazwa() + "','" + czesc.getStanMagazynowy() +"');";
			result = obsZap.insert(query);
			
			if(result == 1)					
				WczytajCzesci(); 					
		}
		
		return result;
	}	
	
	public static int AktualizujCzesc(Czesci czesc){
		
		int result = -1;
		if(czesc != null){

			String query = "UPDATE czesci SET  Model ='"+ czesc.getModel() + "', Cena ='" + czesc.getCena() + "', Firma = '" + czesc.getFirma() + "', Nazwa ='" + czesc.getNazwa() + 
						   "', StanMagazynowy ='" + czesc.getStanMagazynowy() + "' WHERE idCzesci ='"+ czesc.getIdCzesci() +"';";
			
			result = obsZap.update(query);	
			
			if(result == 1)				
				WczytajCzesci();				
			
		}
		
		return result;
	}
}
