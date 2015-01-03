package wDanych;

import wBazy.bCzesci;
import wBazy.bMiejsceSerwisowe;
import wBazy.bSamochod;
import wBazy.bStanowisko;
import wBazy.bUsluga;
import wBazy.obslugaZapytan;

public class Init {

	
public static void InitAll(){

	new obslugaZapytan();								// w celu utworzenia polaczenia z uprawnienaimi logowania
	
	bUsluga.WczytajUslugi();							// wczytanie wszystkich dostepnych uslug w bazie
	bCzesci.WczytajCzesci(); 							// wczytanie wszystkich czesci na magazynie
	bMiejsceSerwisowe.WczytajMiejscaSerwisowe();		// wczytanie wszystkich miejsc serwisowych w bazie
	bStanowisko.WczytajStanowiska();
}
	

public static void InitKlient(Klient klient){
	
	// Wczytanie samochodow klienta
	klient.setlSamochody(bSamochod.WczytajSamochodyKlienta(klient.getPesel()));
	
}


}
