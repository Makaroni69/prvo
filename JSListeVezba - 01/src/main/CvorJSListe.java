package main;

public class CvorJSListe {

	CvorJSListe sledeci;
	int podatak;

	public CvorJSListe() {
		super();
		this.sledeci = null;
		this.podatak = Integer.MIN_VALUE;
	}

	public CvorJSListe(int podatak) {
		super();
		this.sledeci = null;
		this.podatak = podatak;
	}

	public CvorJSListe(int podatak, CvorJSListe sledeci) {
		super();
		this.sledeci = sledeci;
		this.podatak = podatak;
	}

}
