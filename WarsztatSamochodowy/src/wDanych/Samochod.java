package wDanych;

import java.util.ArrayList;

public class Samochod {

	private String idSamochodu;
	private String klientPesel;
	private String marka;
	private String model;
	private String nrRejstracyjny;
	private String rokProdukcji;
	private boolean istnieje;
	
	private ArrayList<Zlecenia> listaZlecen = new ArrayList<Zlecenia>(0);

	public Samochod(String idSamochodu, String klientPesel, String marka,
			String model, String nrRejstracyjny, String rokProdukcji) {
		
		super();
		this.idSamochodu = idSamochodu;
		this.klientPesel = klientPesel;
		this.marka = marka;
		this.model = model;
		this.nrRejstracyjny = nrRejstracyjny;
		this.rokProdukcji = rokProdukcji;
	}
	
	public Samochod(String klientPesel, String marka,
			String model, String nrRejstracyjny, String rokProdukcji) {
		
		super();
		this.klientPesel = klientPesel;
		this.marka = marka;
		this.model = model;
		this.nrRejstracyjny = nrRejstracyjny;
		this.rokProdukcji = rokProdukcji;
	}

	
	
	
	public String showZlecenia(){
		
		String tmp = "";
		
		for(Zlecenia zlec: listaZlecen)
			tmp += zlec.toString() + "\n";
		
		return tmp;
	}
	
	
	//************ SETERY GETERY ********************
	

	public String getIdSamochodu() {
		return idSamochodu;
	}

	public ArrayList<Zlecenia> getListaZlecen() {
		return listaZlecen;
	}

	public void setListaZlecen(ArrayList<Zlecenia> listaZlecen) {
		this.listaZlecen = listaZlecen;
	}

	public String getKlientPesel() {
		return klientPesel;
	}

	public void setKlientPesel(String klientPesel) {
		this.klientPesel = klientPesel;
	}

	public void setIdSamochodu(String idSamochodu) {
		this.idSamochodu = idSamochodu;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNrRejstracyjny() {
		return nrRejstracyjny;
	}

	public void setNrRejstracyjny(String nrRejstracyjny) {
		this.nrRejstracyjny = nrRejstracyjny;
	}

	public String getRokProdukcji() {
		return rokProdukcji;
	}

	public void setRokProdukcji(String rokProdukcji) {
		this.rokProdukcji = rokProdukcji;
	}

	public boolean isIstnieje() {
		return istnieje;
	}

	public void setIstnieje(boolean istnieje) {
		this.istnieje = istnieje;
	}

	@Override
	public String toString() {
		return "Samochod [idSamochodu=" + idSamochodu + ", klientPesel="
				+ klientPesel + ", marka=" + marka + ", model=" + model
				+ ", nrRejstracyjny=" + nrRejstracyjny + ", rokProdukcji="
				+ rokProdukcji + ", istnieje=" + istnieje + "]";
	}
	
}