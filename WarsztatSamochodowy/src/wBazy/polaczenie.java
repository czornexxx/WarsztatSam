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
	
	public polaczenie(int uprawnienia) {
	
		boolean laczyc = false;
		
		// root
		if(uprawnienia == 0){
		
			polaczenieURL = "jdbc:" + IP + nazwaBazy + "?user=root&password=asdf";			
			laczyc = true;
		}else if(uprawnienia == 1){		// klient
		
			polaczenieURL = "jdbc:" + IP + nazwaBazy + "?user=klient&password=klient1";			
			laczyc = true;
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
	
}
