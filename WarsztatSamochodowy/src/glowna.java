import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import wBazy.Uprawnienia;
import wBazy.bCzesci;
import wBazy.bCzesciZlecenia;
import wBazy.bKlient;
import wBazy.bMiejsceSerwisowe;
import wBazy.bPracownik;
import wBazy.bSamochod;
import wBazy.bStanowisko;
import wBazy.bUsluga;
import wBazy.bUslugiZlecenia;
import wBazy.bZlecenia;
import wBazy.obslugaZapytan;
import wBazy.polaczenie;
import wDanych.Czesci;
import wDanych.CzesciZlecenia;
import wDanych.Init;
import wDanych.Klient;
import wDanych.Logowanie;
import wDanych.MiejsceSerwisowe;
import wDanych.Pracownik;
import wDanych.Samochod;
import wDanych.Stanowisko;
import wDanych.Usluga;
import wDanych.UslugiZlecenia;
import wDanych.Zlecenia;


public class glowna {


	public static void KlientRun(){
	
		int tmp = Logowanie.Zaloguj("test", "test");
		System.out.println("Status logowania: " + tmp);

		Klient kl = Logowanie.klient;
		
		for(Samochod sam: kl.getlSamochody()){
			
			System.out.println(sam.toString());

			for(Zlecenia zlec: sam.getListaZlecen()){
				
				for(UslugiZlecenia usl:zlec.getUslugiZlecenia()){
					
					System.out.println(usl.showUsluga());					
				}
				
				for(CzesciZlecenia cze:zlec.getCzesciZlecenia()){
					
					System.out.println(cze.showCzesc());					
				}
			}		
		}
	}
	
	public static void AdminRun(){
		
		int tmp = Logowanie.Zaloguj("admin", "admin");
		System.out.println("Status logowania: " + tmp);
		
		// DODANIE CZESCI
		/*
		Czesci nowa = new Czesci("FP222", "20", "Bosh", "Filtr Powietrza", 20);
		bCzesci.ZapiszCzesc(nowa);
		*/

		// DODANIE USLUGI
		/*
		Usluga nowa = new Usluga("Wyniana kolumny mc-persona", "Naprawa polega na wymianie kolumny", "100", true);
		bUsluga.ZapiszUsluge(nowa);
		*/

		// DODANIE MIEJSCA SERWISOWEGO
		/*
		MiejsceSerwisowe nowe = new MiejsceSerwisowe("Podnosnik xxx");
		bMiejsceSerwisowe.ZapiszMiejsceSerwisowe(nowe);
		*/

		//DODANIE STANOWISKA PRACY
		/*
		Stanowisko nowe = new Stanowisko("Test Test", "20000", "jakas nazwa");
		bStanowisko.ZapiszStanowisko(nowe);
		*/
		
	
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Init.InitAll(); 		// Tworzy po³¹cznie, wczytuje ogólne informacje z bazy tj Uslugi, czesci itp.

		//KlientRun();
		
		AdminRun();
				
	  
	}

}
