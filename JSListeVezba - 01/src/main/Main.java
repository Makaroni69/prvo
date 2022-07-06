package main;

public class Main {

	public static void sortirajNiz(int[] niz) {
		for (int i = 0; i < niz.length; i++) {
			for (int j = i; j < niz.length; j++) {
				if(niz[i] > niz[j]) {
					int pomocni = niz[i];
					niz[i] = niz[j];
					niz[j] = pomocni;
				}
			}
		}
	}
	
	public static void prikaziNiz(int[] niz) {
		for (int i = 0; i < niz.length; i++) {
			System.out.print(niz[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] niz = {2,2};
		JSLista lista = new JSLista(niz);
		lista.ispisiListu();
		lista.pitajKuracKakoDaNazovemOvo_01(6);
		lista.ispisiListu();
	}

	
}
