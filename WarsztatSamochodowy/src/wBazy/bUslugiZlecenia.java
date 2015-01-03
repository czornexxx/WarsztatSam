package wBazy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import wDanych.UslugiZlecenia;

public class bUslugiZlecenia {
	
	private static obslugaZapytan obsZap = obslugaZapytan.ObslugaZapytan;
	
	
	
	public static ArrayList<UslugiZlecenia> WczytajUslugiZlecenia(String idZlecenia){	
		
		ResultSet rs = null;
		ArrayList<UslugiZlecenia> tmpUslugi = new ArrayList<UslugiZlecenia>(0);
		
		rs = obsZap.select("SELECT Us³uga_idUs³uga, Wykonano FROM zlecenia_has_us³uga WHERE Zlecenia_idZlecenia = '" + idZlecenia + "';");
		
		if(rs != null){	
			
			try {
				
				while(rs.next()){
				
					UslugiZlecenia tmpUsl = new UslugiZlecenia(idZlecenia, rs.getString(1), rs.getBoolean(2));
					tmpUslugi.add(tmpUsl);				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return tmpUslugi;
	}
	
	
	public static int ZapiszUslugeZlecenia(UslugiZlecenia uslugaZlecenia){
		
		int result = -1;
		if(uslugaZlecenia != null){
			
			String query = "INSERT INTO zlecenia_has_us³uga (Zlecenia_idZlecenia, Us³uga_idUs³uga, Wykonano ) VALUES ('" + uslugaZlecenia.getIdZlecenia() + "','" + uslugaZlecenia.getIdUslugi() + "','" + uslugaZlecenia.getWykonano() + "');";
			result = obsZap.insert(query);
						
		}
		
		return result;
	}
	
	
	public static int AktualizujUslugeZlecenia(UslugiZlecenia uslugaZlecenia){
		
		int result = -1;
		if(uslugaZlecenia != null){
			
			String query = "UPDATE zlecenia_has_us³uga SET Wykonano ='" + uslugaZlecenia.getWykonano() + "' WHERE Zlecenia_idZlecenia ='" + uslugaZlecenia.getIdZlecenia() + "' AND " + "Us³uga_idUs³uga ='"+ uslugaZlecenia.getIdUslugi() + "';";
			result = obsZap.update(query);	
			
		}
		
		return result;
	}
		
	
}
