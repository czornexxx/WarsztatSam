package wBazy;

import java.sql.ResultSet;
import java.sql.SQLException;

import wDanych.MiejsceSerwisowe;

public class bMiejsceSerwisowe {
	
	private static obslugaZapytan obsZap = obslugaZapytan.ObslugaZapytan;
	
	public static void WczytajMiejscaSerwisowe(){	
		
		ResultSet rs = null;
		
		rs = obsZap.select("SELECT idMiejsceSerwisowe, Nazwa FROM miejsceserwisowe;");
		
		if(rs != null){	
			
			try {
				
				MiejsceSerwisowe.ListaMiejscSerwisowych.clear();
				
				while(rs.next()){
				
					MiejsceSerwisowe tmpMSerw = new MiejsceSerwisowe(rs.getString(1), rs.getString(2));	// Utworzenie uzytkownika z danych z bazy
					MiejsceSerwisowe.ListaMiejscSerwisowych.add(tmpMSerw);				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	
	public static int ZapiszMiejsceSerwisowe(MiejsceSerwisowe miejsceSerwisowe){
		
		int result = -1;
		if(miejsceSerwisowe != null){
			
			String query = "INSERT INTO miejsceserwisowe ( Nazwa ) VALUES ('" + miejsceSerwisowe.getNazwa() + "');";
			result = obsZap.insert(query);
			
			if(result == 1){
				
				WczytajMiejscaSerwisowe(); 		// jeœli poprawnie dodano to zaktualizuj liste. 				
			}						
		}
		
		return result;
	}
	
	public static int AktualizujMiejsceSerwisowe(MiejsceSerwisowe miejsceSerwisowe){
		
		int result = -1;
		if(miejsceSerwisowe != null){
			
			String query = "UPDATE miejsceserwisowe SET idMiejsceSerwisowe ='"+ miejsceSerwisowe.getIdMiejsca() +"', Nazwa ='"+ miejsceSerwisowe.getNazwa() +
					 	   "' WHERE `idMiejsceSerwisowe`='"+ miejsceSerwisowe.getIdMiejsca() +"';";
			
			result = obsZap.update(query);	
			
			if(result == 1){
				
				WczytajMiejscaSerwisowe(); 				
			}
		}
		
		return result;
	}
}
