package wBazy;

import java.sql.ResultSet;
import java.sql.SQLException;

import wDanych.Stanowisko;

public class bStanowisko {

	private static obslugaZapytan obsZap = obslugaZapytan.ObslugaZapytan;
	
	
	public static void WczytajStanowiska(){	
		
		ResultSet rs = null;
		
		rs = obsZap.select("SELECT idStanowisko, Opis, Wynagrodzenie, Nazwa FROM stanowisko;");
		
		if(rs != null){	
			
			try {
				
				Stanowisko.listaStanowisk.clear();
				
				while(rs.next()){
				
					Stanowisko tmpStan = new Stanowisko(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));	
					Stanowisko.listaStanowisk.add(tmpStan);				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	
	public static int ZapiszStanowisko(Stanowisko stanowisko){
		
		int result = -1;
		if(stanowisko != null){
			
		
			String query = "INSERT INTO stanowisko ( Opis, Wynagrodzenie, Nazwa ) VALUES ('" + stanowisko.getOpis() + "','" + stanowisko.getWynagrodzenie() + "','" + stanowisko.getNazwa() +"');";
			result = obsZap.insert(query);
			
			if(result == 1)				
				WczytajStanowiska(); 		
			}
		
		return result;
	}	
	
	public static int AktualizujStanowisko(Stanowisko stanowisko){
		
		int result = -1;
		if(stanowisko != null){

			String query = "UPDATE stanowisko SET  Opis ='"+ stanowisko.getOpis() + "', Wynagrodzenie ='" + stanowisko.getWynagrodzenie() + "', Nazwa = '" + stanowisko.getNazwa() +
					       "' WHERE idStanowisko ='"+ stanowisko.getIdStanowisko() +"';";
			
			result = obsZap.update(query);	
			
			if(result == 1)				
				WczytajStanowiska();			
		}
		
		return result;
	}
	
}
