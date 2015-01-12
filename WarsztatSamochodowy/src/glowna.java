import java.security.*;
import java.sql.Date;
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
		
		
		Klient nowy = new Klient("12312312312", "TestHash", "test", "dodanie");
		bKlient.ZapiszKlienta(nowy);
		
		
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
	
	public static void RecepcjonistaRun(){
		
		int tmp = Logowanie.Zaloguj("rOla", "rOla");
		System.out.println("Status logowania: " + tmp);
		
		Pracownik recepc = Logowanie.pracownik;
		Init.InitRecepcjonista(recepc);

		
		// DODANIE NOWEGO KLIENTA
		//recepc.showKlient();
		//recepc.nowyKlient("85000012341", "Tomek", "Testowy", "Wroclaw ul. nowa");
		
		// WYSZUKIWANIE PO PESELU
		//Klient xxx = recepc.wyszukajKlienta("85000012345");
		
		// WYSZUKIWANIE PO IMIENIU, NAZWISKU
		//ArrayList<Klient> ttmp = recepc.wyszukajKlienta("Tomek","Testowy"); 	
		//if(ttmp != null)
		//	System.out.println(ttmp.toString());
		//else
		//	System.out.println("Nie odnaleziono klienta");
		
		// DODANIE SAMOCHODU 
		Klient xxx = recepc.wyszukajKlienta("85000012345");
		//xxx.dodajSamochod("ford", "mondeo", "xx3342", "2011-04-12");
		//System.out.println(xxx.showCars());
		Samochod ttmp = xxx.wyszukajSamochod("RSR8325");
		//ArrayList<Samochod> ttmp = xxx.wyszukajSamochod("ford","mondeo");
		//System.out.println( MiejsceSerwisowe.ListaMiejscSerwisowych.get(1).toString());
		//ttmp.dodajZlecenie("2004-11-20", "2004-11-30", "2343" , MiejsceSerwisowe.ListaMiejscSerwisowych.get(0).getIdMiejsca());
		
		
		//AKTUALIZACJA ZLECENIA
		Zlecenia tmpzlec = ttmp.zwrocOtwarteZlecenie();
		//tmpzlec.setDataPrzyjecia("2001-01-01");
		//bZlecenia.AktualizujZlecenieKlienta(tmpzlec);
		
		//DODAWANIE NOWYCH USLUG DO ZLECENIA
		//tmpzlec.setDataPrzyjecia("1951-01-01");
		//bZlecenia.AktualizujZlecenieKlienta(tmpzlec);
		//tmpzlec.aktualizujUsluge(Usluga.getUsluga(1).getIdUsluga(), true);
		
		//DODAWANIE CZESCI DO ZLECENIA
		tmpzlec.dodajCzesc(Czesci.getCzesc(1).getIdCzesci(), 9);
		//tmpzlec.aktualizujCzesc(Czesci.ListaCzescia.get(0).getIdCzesci(), 7);
		
		
		System.out.println(tmpzlec.toString());
		System.out.println(ttmp.toString());
		 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Init.InitAll(); 		// Tworzy po³¹cznie, wczytuje ogólne informacje z bazy tj Uslugi, czesci itp.

		KlientRun();
		//AdminRun();

		//RecepcjonistaRun();
		

	}
	
}
