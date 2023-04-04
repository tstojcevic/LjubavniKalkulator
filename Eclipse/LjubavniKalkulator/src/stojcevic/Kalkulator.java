package stojcevic;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Kalkulator {
	
	public static void main(String[] args) {
		
		try {
			new Kalkulator();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Dogodila se greška");
		}
		
	}
	
	public Kalkulator () {
		
		String ime1, ime2;
		String imenaZajedno;
		
		//pohrana znakova
		List<Character> nizZnakova = new ArrayList<Character>();
		//pohrana brojeva
		List<Integer> nizBrojeva = new ArrayList<Integer>();
		
		ime1 = Pomocno.Unos("Unesi prvo ime").replaceAll("\\s", "");
		
		ime2 = Pomocno.Unos("Unesi drugo ime").replaceAll("\\s", "");
		
		imenaZajedno = ime1 + ime2;
		
		for (char znak : imenaZajedno.toCharArray()) {
			nizZnakova.add(znak);
		}
		
		for (char broj : nizZnakova) {
			nizBrojeva.add(Pomocno.prebrojiZnakove(broj, nizZnakova));
		}

		System.out.print(ime1 + " i " + ime2 + " se vole ");
		Pomocno.zbroj(nizBrojeva);
		System.out.print("%");

	}

}
