import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import wBazy.bKlient;
import wBazy.bPracownik;
import wBazy.bSamochod;
import wBazy.obslugaZapytan;
import wBazy.polaczenie;
import wDanych.Klient;
import wDanych.Pracownik;
import wDanych.Samochod;


public class glowna {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		obslugaZapytan obsZap = new obslugaZapytan();
    
		ArrayList<Samochod> Lista = new ArrayList<Samochod>(); 
	
		//Klient staszek = bKlient.WczytajKlienta("23234");
		// Klient nowy = new Klient("7777771", "Ala", "Notakowska", "hahahahah");
		// System.out.println( bKlient.ZapiszKlienta(nowy) );
		 
		 //System.out.println(staszek.toString()); 
		//Pracownik prac = bPracownik.WczytajPracownika("2343");
		
		//prac.setImie("Alan");
		// bPracownik.ZapiszPracownika(prac);
		
		//System.out.println(prac.toString());
		
		Samochod sam = bSamochod.Wczytaj("924731");
		
		//Samochod sam = new Samochod( "924731", "VW", "Puno", "RSR 828", "2000-01-23");
		
		bSamochod.Zapisz(sam);
		System.out.println(sam.toString());
		
		//Klient dam = new Klient("924731", "Alan","JTam","Dobry");
		/*
		try {
		obslugaZapytan obsZap = new obslugaZapytan();
		
		ResultSet rs = obslugaZapytan.ObslugaZapytan.select("Select * from pracownik");
		
		String tmp;

			while(rs.next()){
			    
			 tmp = rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3);
      
			 System.out.println(tmp);
      
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
*/		
	}

}
