package Stensaxpase;

import java.util.Scanner;
import java.util.Random;

public class Ssp {
	
	public static void main(String[] args) {
		
		try (Scanner key = new Scanner(System.in)) {
			Random rand = new Random(); // Nummer generator
			int anvR = 0; // anv�ndare po�ng
			int datR = 0; // datorns po�ng
			
			
			
			
			
			
			// Fr�ga om spelaren vill spela / presentation av vad vi ska spela
			welcome(); //metoden v�lkommen 
			 
			
			System.out.println("Vill du starta ett nytt spel, (J/N)");
			String spel= key.nextLine().toUpperCase(); //r�kar man skriva j s� blir det J �nd�
			boolean spelA =spel.equals("J");
		   stop();
			
			while(spelA && datR < 3 && anvR < 3) { // kolla om n�gon av oss har n�tt 3 d� avslutar while loopen
				System.out.println("V�j din hand:");
				System.out.println( "0.Sten | 1.Sax | 2.P�se ");
				int anv = key.nextInt();
				int dat = rand.nextInt(3);
				System.out.print("Datorns drag: " + dat); // Vad datorn drar f�r n�got
				if ((anv == 0 && dat == 1) || (anv == 0 && dat == 2) || (anv == 2 && dat == 0)) // i dessa fall vinner jag
				{
					System.out.println("  Du vann  ");
					anvR++;  // �ka med 1 vinst f�r mig
				}
				else if ((anv == 0 && dat == 2) || (anv == 1 && dat == 2) || (anv == 2 && dat == 0)) // i dessa fall vinner datorn 
				
				{
					System.out.println("  Datorn vann  ");
			datR++;  // �ka vinsten med 1 p� datorn
				}
				
				else if (anv == dat)
				
				{
					
					System.out.println(" Det blev lika ");}   // n�r anv och dator  f�r samma s� blir det lika 
				
			}
					System.out.println("Po�ngen �r | " + anvR + " - Datorn: " + datR); //po�nglistan 
	
	
			if (anvR<datR)

					System.out.println("Datorn vann spelet");
					
				else
					System.out.println("Du vann spelet");
		
		
		
		}
		}


	
///metoden Welcome b�rjar h�r
public static void welcome() {		
System.out.println("V�lkommen till mitt lilla spel\n===============================\nVi ska nu spela Sten, Sax eller P�se \nVi kommer att k�ra upp till tre vinster vinner!");
}	

public static void stop() {

	
	try (Scanner key2 = new Scanner(System.in)){
	String spel= key2.nextLine().toUpperCase();
	boolean spelA =spel.equals("N");
	System.out.println("Vad synd att du inte ville spela!");
	}	
}
}