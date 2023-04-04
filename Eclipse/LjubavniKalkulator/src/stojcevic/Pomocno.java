package stojcevic;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Pomocno {
	
	public static String Unos(String poruka) {
		while (true) {
			try {
				String unos = JOptionPane.showInputDialog(poruka);
				if (unos.length() > 0) {
					return unos;
				}
				throw new Exception();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Obavezan unos imena");
			}
		}
	}
	
	
	
	public static int prebrojiZnakove(char znak, List<Character> ukupnoZnakova) {
		int dupliZnak = 0;
		for (char pojediniZnak : ukupnoZnakova) {
			if (pojediniZnak == znak) {
				dupliZnak++;
			}
		}
		return dupliZnak;
	}
	
	
	
	public static void zbroj(List<Integer> nizBrojeva) {

		List<Integer> dobiveniZbroj = new ArrayList<Integer>();

		for (int brojZaProvjeru : nizBrojeva) {
			if (brojZaProvjeru > 9) {
				dobiveniZbroj.add(brojZaProvjeru / 10);
				int ostatak = brojZaProvjeru % 10;
				if (ostatak != 0) {
					dobiveniZbroj.add(ostatak);
				}
			} else {
				dobiveniZbroj.add(brojZaProvjeru);
			}
		}
	
		int velicinaNiza = dobiveniZbroj.size();

		if (velicinaNiza < 3 && brojManjiOd100(dobiveniZbroj)) {

			System.out.print(pretvorbaURezultat(dobiveniZbroj));

		} else { 
			
			List<Integer> noviNiz = new ArrayList<Integer>();

			if (velicinaNiza % 2 == 0) {

				iterirajParno(velicinaNiza, dobiveniZbroj, noviNiz);

			} else {

				iterirajNeparno(velicinaNiza, dobiveniZbroj, noviNiz);

			}
			zbroj(noviNiz);
		}

	}



	public static void iterirajNeparno(int velicinaNiza, List<Integer> dobiveniZbroj, List<Integer> noviNiz) {
		
		int breakpoint = velicinaNiza / 2;

		for (int i = 0; i <= breakpoint; i++) {

			int zadnji = (velicinaNiza - i) - 1;

			if (i == zadnji) {
				
				noviNiz.add(dobiveniZbroj.get(i));

			} else {
				
				noviNiz.add(dobiveniZbroj.get(i) + dobiveniZbroj.get(zadnji));

			}

		}

	}
		


	public static void iterirajParno(int velicinaNiza, List<Integer> dobiveniZbroj, List<Integer> noviNiz) {
		
				int breakpoint = (velicinaNiza / 2) - 1;

				for (int i = 0; i <= breakpoint; i++) {
					
					int zadnji = (velicinaNiza - i) - 1;
					
					noviNiz.add(dobiveniZbroj.get(i) + dobiveniZbroj.get(zadnji));

				}

			}
		



	public static int pretvorbaURezultat(List<Integer> dobiveniZbroj) {
		
		int prviZbroj = 0;
		for (Integer broj : dobiveniZbroj) {
			prviZbroj = (prviZbroj * 10) + broj;
		}

		return prviZbroj;
	}



	public static boolean brojManjiOd100(List<Integer> dobiveniZbroj) {
		
				int ukupno = pretvorbaURezultat(dobiveniZbroj);

				if (ukupno <= 100) {
					return true;
				} else {
					return false;
				}
	}

}
