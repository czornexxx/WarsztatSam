package wBazy;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class polaczenie {

	static String IP = "mysql://127.0.0.1/";
	static String nazwaBazy = "bazatest";
	
	private String polaczenieURL; 
	private Connection conn;
	private Statement stmt;
	private Uprawnienia privileges; 
	
	public polaczenie(int uprawnienia) {
	
		boolean laczyc = false;
		
		// root
		if(uprawnienia == Uprawnienia.ADMIN.getNr()){	// 0
		
			polaczenieURL = "jdbc:" + IP + nazwaBazy + "?user="+Uprawnienia.ADMIN.getLogin()+"&password="+Uprawnienia.ADMIN.getHaslo();		
			laczyc = true;
			privileges = Uprawnienia.ADMIN; 
		}else if(uprawnienia == Uprawnienia.KLIENT.getNr()){	// 5	
		
			polaczenieURL = "jdbc:" + IP + nazwaBazy + "?user="+Uprawnienia.KLIENT.getLogin()+"&password="+Uprawnienia.KLIENT.getHaslo();			
			laczyc = true;
			privileges = Uprawnienia.KLIENT;
		}else if(uprawnienia == Uprawnienia.LOGOWANIE.getNr()){	 // 7
		
			polaczenieURL = "jdbc:" + IP + nazwaBazy + "?user="+Uprawnienia.LOGOWANIE.getLogin()+"&password="+Uprawnienia.LOGOWANIE.getHaslo();			
			laczyc = true;
			privileges = Uprawnienia.LOGOWANIE;
		}else if(uprawnienia == Uprawnienia.WLASCICIEL.getNr()){	 // 1
		
			polaczenieURL = "jdbc:" + IP + nazwaBazy + "?user="+Uprawnienia.WLASCICIEL.getLogin()+"&password="+Uprawnienia.WLASCICIEL.getHaslo();			
			laczyc = true;
			privileges = Uprawnienia.WLASCICIEL;
		}else if(uprawnienia == Uprawnienia.KIEROWNIK.getNr()){	 // 2
		
			polaczenieURL = "jdbc:" + IP + nazwaBazy + "?user="+Uprawnienia.KIEROWNIK.getLogin()+"&password="+Uprawnienia.KIEROWNIK.getHaslo();			
			laczyc = true;
			privileges = Uprawnienia.KIEROWNIK;
		}else if(uprawnienia == Uprawnienia.RECEPCJONISTA.getNr()){	 // 3
		
			polaczenieURL = "jdbc:" + IP + nazwaBazy + "?user="+Uprawnienia.RECEPCJONISTA.getLogin()+"&password="+Uprawnienia.RECEPCJONISTA.getHaslo();			
			laczyc = true;
			privileges = Uprawnienia.RECEPCJONISTA;
		}else if(uprawnienia == Uprawnienia.SERWISANT.getNr()){	 // 4
		
			polaczenieURL = "jdbc:" + IP + nazwaBazy + "?user="+Uprawnienia.SERWISANT.getLogin()+"&password="+Uprawnienia.SERWISANT.getHaslo();			
			laczyc = true;
			privileges = Uprawnienia.SERWISANT;
		}else if(uprawnienia == Uprawnienia.WSZYSCY.getNr()){	 // 6
		
			polaczenieURL = "jdbc:" + IP + nazwaBazy + "?user="+Uprawnienia.WSZYSCY.getLogin()+"&password="+Uprawnienia.WSZYSCY.getHaslo();			
			laczyc = true;
			privileges = Uprawnienia.WSZYSCY;
		}else{
			
			System.err.println("B³êdne uprawnienia");
		}
		
		
		if(laczyc){
			
			try{	
                
				Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(polaczenieURL);
                stmt = conn.createStatement();
                
			}			
            catch(ClassNotFoundException wyjatek) {
                System.out.println("Problem ze sterownikiem");
        }

        catch(SQLException wyjatek) {
                //e.printStackTrace();
                //System.out.println("Problem z logowaniem\nProsze sprawdzic:\n nazwê u¿ytkownika, has³o, nazwê bazy danych lub adres IP serwera");
             System.out.println("SQLException: " + wyjatek.getMessage());
             System.out.println("SQLState: " + wyjatek.getSQLState());
             System.out.println("VendorError: " + wyjatek.getErrorCode());
        }
			
		}	
		
	}
	
	
public ResultSet select(String query){
	
	ResultSet rs = null;
	
	try {
		
		rs = stmt.executeQuery(query);
		
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("wystapil blad zapytnia");
	}
	
	return rs;
}

public int insert(String query){	
	
	int result = -1;
	try{	
		 result = stmt.executeUpdate(query);
	}catch(SQLException wyjatek) {
        //e.printStackTrace();
		System.out.println("Wystapil blad zapytania insert");
		System.out.println("SQLException: " + wyjatek.getMessage());
        System.out.println("SQLState: " + wyjatek.getSQLState());
        System.out.println("VendorError: " + wyjatek.getErrorCode());
	}
	
	return result;
}

public int update(String query){	
	
	int result = -1;
	try{	
		result = stmt.executeUpdate(query);
	}catch(SQLException wyjatek) {
        //e.printStackTrace();
		System.out.println("Wystapil blad zapytania update");
		System.out.println("SQLException: " + wyjatek.getMessage());
        System.out.println("SQLState: " + wyjatek.getSQLState());
        System.out.println("VendorError: " + wyjatek.getErrorCode());
	}
	
	return result;
}
	
public Uprawnienia getPrivileges()
{
	return privileges;
}

}
