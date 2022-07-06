package main;

public class CiklicnaJSLista {
	CvorJSListe prvi;

	public CiklicnaJSLista() {
		super();
		prvi = null;
	}

	public CiklicnaJSLista(int[] niz) {

	}

	public void ubaciNaPocetak(int podatak) {
		CvorJSListe noviCvor = new CvorJSListe(podatak, null);
		if(prvi == null) {
			prvi = noviCvor;
			noviCvor.sledeci = prvi;
			return;
		}
		CvorJSListe tekuci = prvi;
		while(tekuci.sledeci != prvi) {
			tekuci = tekuci.sledeci;
		}
		noviCvor.sledeci = prvi;
		tekuci.sledeci = noviCvor;
		prvi = noviCvor;
		
	}

	public void ubaciNaKraj(int podatak) {
		if (prvi == null) {
			ubaciNaPocetak(podatak);
		}
		
		CvorJSListe tekuci = prvi;
		while(tekuci.sledeci != prvi) {
			tekuci = tekuci.sledeci;
		}
		tekuci.sledeci = new CvorJSListe(podatak, prvi);
	}
	
	public int zbir() {
		if(prvi == null)
			return 0;
		CvorJSListe tekuci = prvi;
		int zbir = 0;
		do {
			zbir+= tekuci.podatak;
			tekuci = tekuci.sledeci;
		}while(tekuci != prvi);
		return zbir;
	}
	
	public int brojElemenataUCiklicnoj() {
		if(prvi == null)
			return 0;
		int brojac = 0;
		CvorJSListe tekuci = prvi;
		do {
			brojac++;
			tekuci = tekuci.sledeci;
		} while (tekuci != prvi);
		return brojac;
	}
	
	public int uporediDveListe(CiklicnaJSLista l1, CiklicnaJSLista l2) {
		return Math.abs(l1.brojElemenataUCiklicnoj() - l2.brojElemenataUCiklicnoj());
	}
	
	
}
