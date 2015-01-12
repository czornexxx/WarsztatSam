package wBazy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import wDanych.CzesciZlecenia;

public class bCzesciZlecenia {

	private static obslugaZapytan obsZap = obslugaZapytan.ObslugaZapytan;
	
	
	public static ArrayList<CzesciZlecenia> WczytajCzesciZlecenia(String idZlecenia){	
		
		ResultSet rs = null;
		ArrayList<CzesciZlecenia> tmpCzesci = new ArrayList<CzesciZlecenia>(0);
		
		rs = obsZap.select("SELECT Czesci_idCzesci, Ilosc FROM zlecenia_has_czesci WHERE Zlecenia_idZlecenia = '" + idZlecenia + "';");
		
		if(rs != null){	
			
			try {
				
				while(rs.next()){
				
					CzesciZlecenia tmpCzesc = new CzesciZlecenia(idZlecenia, rs.getString(1), rs.getInt(2));
					tmpCzesci.add(tmpCzesc);				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return tmpCzesci;
	}
	
	
	public static int ZapiszCzescZlecenia(CzesciZlecenia czescZlecenia){
		
		int result = -1;
		if(czescZlecenia != null){
			
			String query = "INSERT INTO zlecenia_has_czesci (Zlecenia_idZlecenia, Czesci_idCzesci, Ilosc ) VALUES ('" + czescZlecenia.getIdZlecenia() + "','" + czescZlecenia.getIdCzesci() + "','" + czescZlecenia.getIlosc() + "');";
			result = obsZap.insert(query);
						
		}
		
		return result;
	}
	
	
	public static int AktualizujCzescZlecenia(CzesciZlecenia czescZlecenia){
		
		int result = -1;
		if(czescZlecenia != null){
			
			String query = "UPDATE zlecenia_has_czesci SET Ilosc = '" + czescZlecenia.getIlosc() + "' WHERE Zlecenia_idZlecenia ='" + czescZlecenia.getIdZlecenia() + "' AND Czesci_idCzesci = '" + czescZlecenia.getIdCzesci() + "';";
			result = obsZap.update(query);	

		}
		
		return result;
	}
		
}
