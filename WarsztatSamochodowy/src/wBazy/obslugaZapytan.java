package wBazy;

import java.sql.ResultSet;

import wBazy.polaczenie;

public class obslugaZapytan {
	
	public static obslugaZapytan ObslugaZapytan = null; 
	private static polaczenie pol;
		
	public obslugaZapytan(){
		
		pol = new polaczenie(0);
		ObslugaZapytan = this; 
	}
	
	public ResultSet select(String query){	
		
		ResultSet rs = null;
		
		rs = pol.select(query);
		
		return rs;
	}
	
	public int insert(String query){	
		
		return pol.insert(query);		
	}
	
	public int update(String query){
		
		return pol.update(query);
	}

}