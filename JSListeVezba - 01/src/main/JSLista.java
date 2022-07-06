package main;

public class JSLista {

	CvorJSListe prvi;

	public JSLista() {
		super();
	}

	public JSLista(int[] niz) {
		for (int i = 0; i < niz.length; i++) {
			ubaciNaKraj(niz[i]);
		}
	}

	public boolean praznaLista() {
		if (prvi == null)
			return true;
		return false;
	}

	public void ubaciNaPocetak(int podatak) {
		prvi = new CvorJSListe(podatak, prvi);
	}

	public void ubaciNaKraj(int podatak) {
		if (praznaLista()) {
			prvi = new CvorJSListe(podatak, prvi);
			return;
		}
		CvorJSListe tekuci = prvi;
		while (tekuci.sledeci != null) {
			tekuci = tekuci.sledeci;
		}
		tekuci.sledeci = new CvorJSListe(podatak, null);
	}

	public void ispisiListu() {
		if (praznaLista()) {
			System.out.println("prazna lista");
			return;
		}
		System.out.print("prvi -> ");
		CvorJSListe tekuci = prvi;
		while (tekuci != null) {
			System.out.print(tekuci.podatak + " -> ");
			tekuci = tekuci.sledeci;
		}
		System.out.print("null\n");
	}

	public void izbaciCvor(CvorJSListe cvor) {
		if (null == prvi) {
			return;
		}

		if (prvi == cvor) {
			// Mora da ostane ovako da bi radile druge funkcije
			prvi = prvi.sledeci;
		}

		CvorJSListe brzi = prvi;
		CvorJSListe spori = prvi;
		// Loš kod baciće NullPointerExcpetion za praznu listu
		while (brzi.sledeci != null) {
			if (brzi == cvor) {
				spori.sledeci = brzi.sledeci;
			}
			spori = brzi;
			brzi = brzi.sledeci;
		}

		// slucaj kad dodje do zadnjeg
		if (brzi == cvor) {
			spori.sledeci = brzi.sledeci;
			brzi.sledeci = null;
		}
	}

	public void izbaciCvor_v2(CvorJSListe cvor) {
		if (prvi == null)
			return;
		if (prvi == cvor) {
			prvi = prvi.sledeci;
			return;
		}

		CvorJSListe tekuci = prvi;
		while (tekuci.sledeci != null) {
			if (tekuci.sledeci == cvor) {
				tekuci.sledeci = tekuci.sledeci.sledeci;
				return;
			}
			tekuci = tekuci.sledeci;
		}
	}

	public void ispisiObrnuto(CvorJSListe prviKopija) {
		/*
		 * Mora ovako jer ce inace da vrti do kraja liste ako stavimo prvi == null i
		 * onda ce da baci NullPointerException pokusavajuci da pozove sebe opet
		 */
		if (prviKopija == null)
			return;
		/*
		 * Takodje ne treba da prviKopija prosledjujemo vrednost ovde jer ce onda
		 * promenljiva prviKopija konstanto da ima vrednost prvog i to je recept da umre
		 * kompjuter sa beskonacnom "while petljom" (rekurzijom
		 */
		ispisiObrnuto(prviKopija.sledeci);
		System.out.print(prviKopija.podatak + " ");

		// Za ukras:
		if (prviKopija == prvi)
			System.out.println(); // kao novi red ovo ono
	}

	public boolean postoji(CvorJSListe cvor) {
		CvorJSListe tekuci = prvi;
		while (tekuci != null) {
			if (tekuci == cvor)
				return true;
			tekuci = tekuci.sledeci;
		}
		return false;
	}

	public void invertujListu() {
		if (prvi == null)
			return;

		CvorJSListe prethodni = null;
		CvorJSListe tekuci = prvi;
		while (tekuci != null) {
			CvorJSListe sledeci = tekuci.sledeci;
			tekuci.sledeci = prethodni;
			prethodni = tekuci;
			tekuci = sledeci;
		}
	}

	public void invertujListuSaPomocnom() {
		if (praznaLista())
			return;

		CvorJSListe tekuci = prvi;
		CvorJSListe tekuciDruga = null;
		while (tekuci != null) {
			tekuciDruga = new CvorJSListe(tekuci.podatak, tekuciDruga);
			tekuci = tekuci.sledeci;
		}
	}

	public int brojNegativnihElementa() {
		int brojac = 0;
		CvorJSListe tekuci = prvi;
		while (tekuci != null) {
			if (tekuci.podatak < 0)
				brojac++;
			tekuci = tekuci.sledeci;
		}
		return brojac;
	}

	public int zbirNeparnih() throws urMom {
		if (praznaLista())
			throw new urMom("JBg prazna lista");

		int zbir = 0;
		CvorJSListe tekuci = prvi;
		while (tekuci != null) {
			if (tekuci.podatak % 2 == 1)
				zbir += tekuci.podatak;
			tekuci = tekuci.sledeci;
		}
		return zbir;
	}

	public int proizvodDvocifrenihPozitivnih() {
		int proizvod = 1;
		CvorJSListe tekuci = prvi;
		while (tekuci != null) {
			if (tekuci.podatak < 100 && tekuci.podatak > 9)
				proizvod *= tekuci.podatak;
			tekuci = tekuci.sledeci;
		}
		return proizvod;
	}

	public boolean sortiranaNeopadajuce() {
		if (praznaLista())
			return true;
		CvorJSListe tekuci = prvi;
		// Greška kod njih ako je lista prazna baca NullPointerException
		while (tekuci.sledeci != null) {
			if (tekuci.podatak > tekuci.sledeci.podatak)
				return false;
			tekuci = tekuci.sledeci;
		}
		return true;
	}

	public int maxElementListe() throws urMom {
		if (praznaLista())
			throw new urMom("Prazna lista baki");

		int max = prvi.podatak;
		CvorJSListe tekuci = prvi.sledeci;
		while (tekuci != null) {
			if (tekuci.podatak > max)
				max = prvi.podatak;
			tekuci = tekuci.sledeci;
		}
		return max;
	}

	public void izbaciMinimalniElementListe() throws urMom {
		// Oni su pozvali funkciju za izbacivanje cvora karakteristicne osobine
		// Da ne bi pisali kod od 3 strane tako je najefikasnije

		if (praznaLista())
			return;

		CvorJSListe min = prvi, tekuci = prvi.sledeci;
		while (tekuci != null) {
			if (tekuci.podatak < min.podatak)
				min = tekuci;
			tekuci = tekuci.sledeci;
		}
		izbaciCvor(min);
	}

	public void izbacujePrviElement() {
		CvorJSListe pomocni = prvi;
		prvi = prvi.sledeci;
		pomocni.sledeci = null; // pokupice garbage collection al nmvz mene nervira
	}

	public void izbaciPretposlednji() {
		// Uslov za bez elemenata i sa jednim elementom
		if (prvi == null || prvi.sledeci == null)
			return;
		// Specijalni slucaj je i kad ima dva elemenata. Navedeni kod ne radi, mzd ima
		// resenje neko drugo al jbg
		if (prvi.sledeci.sledeci == null) {
			prvi = prvi.sledeci;
			// Garbage collection u nasoj nadi pokupi pisljivi prvi clan
			return;
		}

		CvorJSListe brzi = prvi;
		CvorJSListe spori = null;

		// da dodjemo do destinacije
		while (brzi.sledeci.sledeci != null) {
			spori = brzi;
			brzi = brzi.sledeci;
		}
		spori.sledeci = brzi.sledeci;

	}

	public void izbaciPoslednji() {
		// Dva slucaja kada ima jedan clan i kada ima 0 clanova
		if (prvi == null)
			return;
		if (prvi.sledeci == null)
			prvi = null;

		CvorJSListe tekuci = prvi.sledeci;
		while (tekuci.sledeci.sledeci != null) {
			tekuci = tekuci.sledeci;
		}
		tekuci.sledeci = null;
	}

	/*
	 * Napiši funkciju koja vraća listu koja predstavlja simetričnu razliku dve
	 * liste. U novoj listi treba da se nalaze elementi koji se nalaze u prvoj ili
	 * drugoj listi, ali ne u obe liste (unija – presek)
	 */

	public JSLista simetricnaRazlika(JSLista l1, JSLista l2) {
		// Predpostavimo da liste u sebi nemaju iste clanove
		// Ili nemam pojma njihov kod je retardiran
		// Desavanja kada je prazna lista
		if (l1.prvi == null)
			return l2;
		if (l2.prvi == null)
			return l1;

		JSLista novaLista = new JSLista();
		CvorJSListe tekuci = l1.prvi;
		while (tekuci != null) {
			if (!novaLista.postojiPodatak(tekuci.podatak) && !l2.postojiPodatak(tekuci.podatak)) {
				novaLista.ubaciNaPocetak(tekuci.podatak);
			}
			tekuci = tekuci.sledeci;
		}
		tekuci = l2.prvi;
		while (tekuci != null) {
			if (!novaLista.postojiPodatak(tekuci.podatak) && !l1.postojiPodatak(tekuci.podatak)) {
				novaLista.ubaciNaPocetak(tekuci.podatak);
			}
			tekuci = tekuci.sledeci;
		}
		// vljd je tacno jebem li ga, ko im jebe mater
		return novaLista;
	}

	private boolean postojiPodatak(int podatak) {
		CvorJSListe tekuci = prvi;
		while (tekuci != null) {
			if (tekuci.podatak == podatak) {
				return true;
			}
			tekuci = tekuci.sledeci;
		}
		return false;
	}

	public JSLista unakrsnoSpoji(JSLista l1, JSLista l2) {
		// Mora da se pazi , u ovom slucaju samo se prosledjuje adresa objketa koj
		// pokazuje
		// na prvi clan liste koj moze da se menja jer se nalazi u originalnoj (main)
		// metodi
		if (l1.prvi == null)
			return l2;
		if (l2.prvi == null)
			return l1;

		CvorJSListe tekuciL1 = l1.prvi;
		CvorJSListe tekuciL2 = l2.prvi;
		JSLista novaLista = new JSLista();
		while (true) {
			if (tekuciL1 != null) {
				novaLista.ubaciNaPocetak(tekuciL1.podatak);
				tekuciL1 = tekuciL1.sledeci;
			}
			if (tekuciL2 != null) {
				novaLista.ubaciNaPocetak(tekuciL2.podatak);
				tekuciL2 = tekuciL2.sledeci;
			}
			if (tekuciL2 == null && tekuciL1 == null)
				break;
		}
		// A jbg moja uzima u obzir kada liste nisu iste duzine
		return novaLista;
	}

	public JSLista unija(JSLista l1, JSLista l2) {
		if (l1.prvi == null)
			return l2;
		if (l2.prvi == null)
			return l1;

		JSLista novaLista = new JSLista();
		CvorJSListe tekuci;
		tekuci = l1.prvi;
		while (tekuci != null) {
			if (!novaLista.postojiPodatak(tekuci.podatak))
				novaLista.ubaciNaKraj(tekuci.podatak);
			tekuci = tekuci.sledeci;
		}
		tekuci = l2.prvi;
		while (tekuci != null) {
			if (!novaLista.postojiPodatak(tekuci.podatak))
				novaLista.ubaciNaKraj(tekuci.podatak);
			tekuci = tekuci.sledeci;
		}

		return novaLista;
	}

	public JSLista presek(JSLista l1, JSLista l2) {
		if (l1.prvi == null || l2.prvi == null)
			return new JSLista();

		JSLista novaLista = new JSLista();
		CvorJSListe tekuci = l1.prvi;
		while (tekuci != null) {
			if (l2.postojiPodatak(tekuci.podatak) || !novaLista.postojiPodatak(tekuci.podatak)) {
				novaLista.ubaciNaKraj(tekuci.podatak);
			}
			tekuci = tekuci.sledeci;
		}
		tekuci = l2.prvi;
		while (tekuci != null) {
			if (l1.postojiPodatak(tekuci.podatak) || !novaLista.postojiPodatak(tekuci.podatak)) {
				novaLista.ubaciNaKraj(tekuci.podatak);
			}
			tekuci = tekuci.sledeci;
		}
		return novaLista;
	}

	public int zbirNaParnimMestimaListe() throws urMom {
		if (praznaLista())
			throw new urMom("Prazna lista miki");

		int zbir = 0;
		boolean flipper = false;
		CvorJSListe tekuci = prvi;
		while (tekuci != null) {
			if (flipper) {
				zbir += tekuci.podatak;
				flipper = false;
				continue;
			}
			flipper = true;
		}

		return zbir;
	}

	// 23.
	public boolean paranBrojElMesto() {
		if (praznaLista())
			return true;

		int brojac = 0;
		boolean flipper = false;
		// x = -1 - x;
		CvorJSListe tekuci = prvi;
		while (tekuci != null) {
			if (flipper) {
				if (tekuci.podatak % 2 == 0)
					brojac++;
				flipper = false;
				continue;
			}
			flipper = true;
		}
		return brojac % 2 == 0;
	}

	public void ubaciDuploVeciNaPreposlednjeMeste() {
		// Prvo par uslova
		if (prvi == null || prvi.sledeci == null)
			return;

		CvorJSListe tekuci = prvi.sledeci;
		CvorJSListe prethodni = prvi;

		while (tekuci.sledeci != null) {
			prethodni = tekuci;
			tekuci = tekuci.sledeci;
		}
		prethodni.sledeci = new CvorJSListe(prvi.podatak * 2, tekuci);

	}

	public void ubaciPozitivanPosleNegtaivnog() {
		if (prvi == null)
			return;
		CvorJSListe tekuci = null;
		while (tekuci != null) {
			if (tekuci.podatak < 0)
				tekuci.sledeci = new CvorJSListe(tekuci.podatak * (-1), tekuci.sledeci);
			tekuci = tekuci.sledeci;
		}
	}

	public int brojPutaKojiSeNajcesciElementPonovio() {
		CvorJSListe tekuci = prvi;
		int maxPojavljivanje = 0;
		// Bice ekstremno neefiksan
		/*
		 * Jedan od nacina poboljsanog rada jeste da se napravi niz sa brojem clanova
		 * velicine jednog bajta u kome ce da se skladiste promenljive gde ce da se
		 * proveravaju da li su vec bile istrazivane. U slucaju da ima vise od 128
		 * vrednosti počeće da precrtava brojeve sa pocetka i upisuje tu. Ja cu raditi
		 * neefikasno.
		 * 
		 */
		while (tekuci != null) {
			int broj = brojPojavljivanja(tekuci.podatak);
			if (broj > maxPojavljivanje)
				maxPojavljivanje = broj;
			tekuci = tekuci.sledeci;
		}
		return maxPojavljivanje;
	}

	private int brojPojavljivanja(int podatak) {
		int brojPojavljivanja = 0;
		CvorJSListe tekuci = prvi;
		while (tekuci != null) {
			if (tekuci.podatak == podatak)
				brojPojavljivanja++;
			tekuci = tekuci.sledeci;
		}
		return brojPojavljivanja;
	}

	public static boolean listaUListi(CvorJSListe glavaUKojojSeTrazi, CvorJSListe glava) {
		CvorJSListe tekuci1 = glavaUKojojSeTrazi;
		CvorJSListe tekuci2 = glava;

		while (tekuci2 != null) {
			if (tekuci2.podatak == tekuci1.podatak) {
				tekuci2 = tekuci2.sledeci;
				tekuci1 = tekuci1.sledeci;
				continue;
			} else {
				tekuci2 = glava;
			}
			tekuci1 = tekuci1.sledeci;
			if (tekuci1 == null) {
				return false;
			}
		}
		return true;
	}

	public void sortirajListu() {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorJSListe tekuci = prvi;
		CvorJSListe pomocni = prvi.sledeci;
		while (tekuci.sledeci != null) {
			pomocni = tekuci.sledeci;
			while (pomocni != null) {
				if (tekuci.podatak > pomocni.podatak)
					zameniDvaCvora(tekuci, pomocni);
				pomocni = pomocni.sledeci;
			}
			tekuci = tekuci.sledeci;
		}

	}

	private void zameniDvaCvora(CvorJSListe tekuci, CvorJSListe pomocni) {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		int podatak = tekuci.podatak;
		tekuci.podatak = pomocni.podatak;
		pomocni.podatak = podatak;
	}

	public void ubaciSortiranoRastuce(int podatak) {
		if (prvi == null || prvi.podatak > podatak) {
			ubaciNaPocetak(podatak);
		}

		CvorJSListe tekuci = prvi;
		while (tekuci.sledeci != null) {
			if (tekuci.sledeci.podatak > podatak) {
				break;
			}
			tekuci = tekuci.sledeci;
		}
		tekuci.sledeci = new CvorJSListe(podatak, tekuci.sledeci);
	}

	public int brojParovaSaSumomK(int k) throws urMom {
		if (prvi == null)
			throw new urMom("nedovoljno elemenata u listi");

		int brojac = 0;
		CvorJSListe tekuci = this.prvi;
		CvorJSListe pomocni = tekuci;
		while (tekuci.sledeci != null) {
			pomocni = tekuci.sledeci;
			while (pomocni != null) {
				if ((tekuci.podatak + pomocni.podatak) == k)
					brojac++;
				pomocni = pomocni.sledeci;
			}
			tekuci = tekuci.sledeci;
		}
		return brojac;
	}

	public void ubaciP(int p) {
		/*
		 * if(element < p) then ubaci posle elemnta
		 */
		if (prvi == null) {
			ubaciNaKraj(p);
			return;
		}
		CvorJSListe tekuci = prvi;
		while (tekuci.sledeci != null) {
			if (tekuci.podatak < p) {
				tekuci.sledeci = new CvorJSListe(p, tekuci.sledeci);
				return;
			}
			tekuci = tekuci.sledeci;
		}
		tekuci.sledeci = new CvorJSListe(p);
	}

	public void izbaciSaIndeksa(int index) {
		if (prvi == null || index < 0) {
			System.out.println("Indeks mora biti pozitivan");
			return;
		}

		if (index == 0) {
			prvi = prvi.sledeci;
			return;
		}

		int brojac = 0;
		CvorJSListe tekuci = prvi;
		while (tekuci.sledeci != null) {
			if (brojac == index - 1) {
				tekuci.sledeci = tekuci.sledeci.sledeci;
				return;
			}
			brojac++;
			tekuci = tekuci.sledeci;
		}

		System.out.println("Indeks previse veliki");
	}

	public void izbaciSaBrojem(int broj) {
		if (prvi == null) {
			System.out.println("Lista je prazna");
			return;
		}

		int brojac = 0;
		CvorJSListe tekuci = prvi;
		while (tekuci != null) {
			if (tekuci.podatak == broj) {
				izbaciSaIndeksa(brojac);
			} else {
				brojac++;
			}
			tekuci = tekuci.sledeci;
		}

	}

	public void izbaciSveKojiSePonavljaju_v2() {
		if (prvi == null || prvi.sledeci == null)
			return;

		CvorJSListe tekuci = prvi;
		while (tekuci != null) {
			if (brojPojavljivanja(tekuci.podatak) > 1) {
				CvorJSListe pomocni = tekuci;
				while (pomocni != null) {
					if (pomocni.podatak == tekuci.podatak) {
						izbaciCvor_v2(pomocni);
					}
					pomocni = pomocni.sledeci;
				}
			}
			tekuci = tekuci.sledeci;
		}
	}

	public void izbaciSveNeparne() {
		if (prvi == null) {
			return;
		}
		CvorJSListe tekuci = prvi;
		while (tekuci != null) {
			if (tekuci.podatak % 2 == 1) {
				izbaciCvor_v2(tekuci);
			}
			tekuci = tekuci.sledeci;
		}
	}

	public int zbirNajvecaTri() {
		if (prvi == null || prvi.sledeci == null || prvi.sledeci.sledeci == null)
			return Integer.MIN_VALUE;

		CvorJSListe tekuci = prvi;
		int e1 = Integer.MIN_VALUE;
		int e2 = Integer.MIN_VALUE;
		int e3 = Integer.MIN_VALUE;
		while (tekuci != null) {
			// Math.min(Math.min(e1,e2),e3);
			int min;
			if ((min = minimumThree(e1, e2, e3)) > tekuci.podatak)
				if (min == e1)
					e1 = tekuci.podatak;
				else if (min == e2)
					e2 = tekuci.podatak;
				else
					e3 = tekuci.podatak;
		}
		return e1 + e2 + e3;
	}

	private int minimumThree(int a, int b, int c) {
		if (a <= b && a <= c)
			return a;
		if (b <= a && b <= c)
			return b;
		return c;
	}

	public void zameniDvaCvoraZapravo(CvorJSListe cvor1, CvorJSListe cvor2) {
		// Da li cvor1 ili cvor2 pointuje
		// Da li postoji lista sa vise od jednog elementa
		if (cvor1 == null || cvor2 == null || prvi == null || prvi.sledeci == null || cvor1 == cvor2)
			return;

		// postavlja prethodni ispred cvora
		// ujedno i proverava da li postoji dati cvor
		CvorJSListe tekuci = prvi;
		CvorJSListe prethCvor1 = null;
		CvorJSListe postojanje1 = null;
		while (tekuci != null) {
			if (tekuci == cvor1) {
				postojanje1 = tekuci;
				break;
			}
			prethCvor1 = tekuci;
			tekuci = tekuci.sledeci;
		}
		
		tekuci = prvi;
		CvorJSListe prethCvor2 = null;
		CvorJSListe postojanje2 = null;
		while (tekuci != null) {
			if (tekuci == cvor2) {
				postojanje2 = tekuci;
				break;
			}
			prethCvor2 = tekuci;
			tekuci = tekuci.sledeci;
		}

		if (postojanje1 == null || postojanje2 == null) {
			return;
		}

		// Ispituje se da li je doslo do prvog clana
		if (prethCvor1 != null) {
			prethCvor1.sledeci = cvor2;
		} else {
			prvi = cvor2; // ostaje cvor1 da drzi taj prvi
		}

		if (prethCvor2 != null) {
			prethCvor2.sledeci = cvor1;
		} else {
			prvi = cvor1;
		}

		// Da li su jedan poredDrugog
		if (prethCvor1 == cvor2) {
			cvor2.sledeci = cvor1.sledeci;
			cvor1.sledeci = cvor2;
			return;
		} else if (prethCvor2 == cvor1) {
			cvor1.sledeci = cvor2.sledeci;
			cvor2.sledeci = cvor1;
			return;
		}

		/*
		 * Ovako znaci... Uzeli smo cvor1 na sta pokazuje i rekli smo da pokazuje na sta
		 * god je pokazivao cvor2, zatim smo rekli da cvor2 pokazuje na sta god je bio
		 * pokazivao cvor1 pre izmene njegove promenljive pod imenom sledece.
		 */
		CvorJSListe pomocni = cvor1.sledeci;
		cvor1.sledeci = cvor2.sledeci;
		cvor2.sledeci = pomocni;

	}

	// 36.
	public void preskociIzbrisi(int m, int n) {
		CvorJSListe tekuci = prvi;
		while (tekuci != null) {
			for (int i = 0; i < m; i++) {
				tekuci = tekuci.sledeci;
			}
			for (int i = 0; i < n; i++) {
				CvorJSListe zaIzbacivanje = tekuci;
				tekuci = tekuci.sledeci;
				izbaciCvor(zaIzbacivanje);
			}
		}
	}

	public void izbaciElementeKojiImajuVeciKvadratOdZbira() {
		int zbir = zbirSvihElemenata();
		CvorJSListe tekuci = prvi;
		while (tekuci != null) {
			CvorJSListe pomocni = tekuci;
			tekuci = tekuci.sledeci;
			if (Math.pow(pomocni.podatak, 2) > zbir) {
				izbaciCvor(pomocni);
			}
		}
	}

	private int zbirSvihElemenata() {
		CvorJSListe tekuci = prvi;
		int zbir = Integer.MIN_VALUE;
		while (tekuci != null) {
			zbir += tekuci.podatak;
			tekuci = tekuci.sledeci;
		}
		return zbir;
	}

	public void ubaciNaNtuPozicijuOdKraja(int podatak, int n) {
		CvorJSListe prethodni = prvi;
		CvorJSListe tekuci = prethodni;

		// pravi rastojanje
		while (tekuci != null && n != 0) {
			tekuci = tekuci.sledeci;
			n--;
		}
		// dodje do kraja ko sto kaze u zadatku
		while (tekuci != null) {
			tekuci = tekuci.sledeci;
			prethodni = prethodni.sledeci;
		}
		prethodni.sledeci = new CvorJSListe(podatak, prethodni.sledeci);
	}

	public void izbaciSveElementeManjeOdBroja(int broj) {
		CvorJSListe tekuci = prvi;
		while (tekuci != null) {
			if (tekuci.podatak < broj) {
				izbaciCvor(tekuci);
			}
			// Ovo samo moze u javi zbog garbage collection
			tekuci = tekuci.sledeci;
		}
	}

	public int brojParovaZbirVeciOdK(int k) {
		if (prvi == null || prvi.sledeci == null)
			return 0;
		int brojac = 0;
		CvorJSListe tekuci = prvi, pomocni = prvi.sledeci;
		while (tekuci.sledeci != null) {
			pomocni = tekuci.sledeci;
			while (pomocni != null) {
				if (tekuci.podatak + pomocni.podatak > k) {
					brojac++;
				}
				pomocni = pomocni.sledeci;
			}
			tekuci = tekuci.sledeci;
		}
		return brojac;
	}

	public static int najveciZbirTemperature(JSLista l1, JSLista l2) {
		int zbirMax = Integer.MIN_VALUE;
		CvorJSListe t1 = l1.prvi;
		CvorJSListe t2 = l2.prvi;
		while (t1 != null && t2 != null) {
			if (t1.podatak + t2.podatak > zbirMax) {
				zbirMax = t1.podatak + t2.podatak;
			}
			t1 = t1.sledeci;
			t2 = t2.sledeci;
		}
		return zbirMax;
	}

	public void izbaciPreBroja(int broj) {
		if (prvi == null || prvi.sledeci == null)
			return;
		if (prvi.sledeci.podatak == broj) {
			prvi = prvi.sledeci;
			return;
		}

		CvorJSListe tekuci = prvi;
		while (tekuci.sledeci.sledeci != null) {
			if (tekuci.sledeci.sledeci.podatak == broj) {
				tekuci.sledeci = tekuci.sledeci.sledeci;
				continue;
			}
			tekuci = tekuci.sledeci;
		}
	}

	public void izbaciPrePoslednjegNajveceg() {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorJSListe max = prvi;
		CvorJSListe tekuci = prvi.sledeci;
		while (tekuci != null) {
			if (tekuci.podatak >= max.podatak) {
				max = tekuci;
			}
			tekuci = tekuci.sledeci;
		}

		if (prvi == max)
			return;
		if (prvi.sledeci == max) {
			prvi = prvi.sledeci;
			return;
		}

		tekuci = prvi;
		while (tekuci.sledeci.sledeci != max) {
			tekuci = tekuci.sledeci;
		}
		tekuci.sledeci = max;
	}

	public static JSLista saberiListe(JSLista l1, JSLista l2) {

		if (l1 == null || l2 == null)
			return null;

		JSLista nova = new JSLista();
		// prvi u listu
		CvorJSListe t1 = l1.prvi;
		StringBuilder lista1 = new StringBuilder("");
		while (t1 != null) {
			lista1.append(Integer.toString(t1.podatak));
			t1 = t1.sledeci;
		}
		CvorJSListe t2 = l2.prvi;
		StringBuilder lista2 = new StringBuilder("");
		while (t2 != null) {
			lista2.append(Integer.toString(t2.podatak));
			t2 = t2.sledeci;
		}
		
		int novaLista = Integer.parseInt(lista1.toString())
				+ Integer.parseInt(lista2.toString());
		while(novaLista != 0) {
			nova.prvi = new CvorJSListe(novaLista % 10, nova.prvi.sledeci);
			novaLista /= 10;
		}

		return nova;
	}

	/*
	 * private static int desetNaKojStepen(int n) { n = Math.abs(n); int koef = 0;
	 * while(n != 0) { n /= 10; koef++; } return koef;
	 * 
	 * Vraća nulu ako je n nula,za sve druge vrednosti vraća 1 2 3 4 itd
	 * 
	 * }
	 */
	
	public void ubaciBrojJanuar2020(int broj) {
		if(prvi == null) {
			prvi = new CvorJSListe(broj, prvi);
		}
		CvorJSListe tekuci = prvi;
		while(tekuci != null) {
			if(tekuci.podatak < broj) {
				tekuci.sledeci = new CvorJSListe(broj, tekuci.sledeci);
				return;
			}
		}
		prvi = new CvorJSListe(broj, prvi);
	}
	
	
	// VEOMA PAMETNO RESENJE NIKAD SE NE BIH SETIO
	private CvorJSListe srednjiCvor() {
		if(prvi == null || prvi.sledeci == null)
			return null;
		CvorJSListe spori = prvi;
		CvorJSListe brzi = spori.sledeci;
		while(brzi != null && brzi.sledeci != null) {
			spori = spori.sledeci;
			brzi = brzi.sledeci.sledeci;
		}
		return spori;
	}
	
	public void prebaciSrednjiNaPocetak() {
		CvorJSListe srednji = srednjiCvor();
		izbaciCvor(srednji);
		srednji.sledeci = prvi;
		prvi = srednji;
	}
	
	public void pitajKuracKakoDaNazovemOvo_01(int podatak) {
		if(podatak <= 0) {
			System.out.println("Podatak mora biti veci nule");
			return;
		}
		
		if(prvi == null) {
			prvi = new CvorJSListe(podatak);
			return;
		}
		int proizvod = 1;
		CvorJSListe noviCvor = new CvorJSListe(podatak);
		CvorJSListe prethodni = prvi;
		CvorJSListe tekuci = prvi;
		while(tekuci != null) {
			proizvod *= tekuci.podatak;
			if(proizvod > podatak) {
				prethodni.sledeci = noviCvor;
				noviCvor.sledeci = tekuci;
				return;
			}
			prethodni = tekuci;
			tekuci = tekuci.sledeci;
		}
		prethodni.sledeci = noviCvor;
	}
	
	public void ukloniVisestrukaPonavaljanjaX(int x) {
		boolean terajMiki = false;
		CvorJSListe tekuci = prvi;
		while(tekuci != null) {
			if(tekuci.podatak == x) {
				if(terajMiki) {
					izbaciCvor(tekuci);
				}
			}
			tekuci = tekuci.sledeci;
		}
	}
	
}