package Stensaxpase;

import java.util.Scanner;
import java.util.Random;

public class Ssp {
	
	public static void main(String[] args) {
		
		try (Scanner key = new Scanner(System.in)) {
			Random rand = new Random(); // Nummer generator
			int anvR = 0; // användare poäng
			int datR = 0; // datorns poäng
			
			
			
			
			
			
			// Fråga om spelaren vill spela / presentation av vad vi ska spela
			welcome(); //metoden välkommen 
			 
			
			System.out.println("Vill du starta ett nytt spel, (J/N)");
			String spel= key.nextLine().toUpperCase(); //råkar man skriva j så blir det J ändå
			boolean spelA =spel.equals("J");
		   stop();
			
			while(spelA && datR < 3 && anvR < 3) { // kolla om någon av oss har nått 3 då avslutar while loopen
				System.out.println("Väj din hand:");
				System.out.println( "0.Sten | 1.Sax | 2.Påse ");
				int anv = key.nextInt();
				int dat = rand.nextInt(3);
				System.out.print("Datorns drag: " + dat); // Vad datorn drar för något
				if ((anv == 0 && dat == 1) || (anv == 0 && dat == 2) || (anv == 2 && dat == 0)) // i dessa fall vinner jag
				{
					System.out.println("  Du vann  ");
					anvR++;  // öka med 1 vinst för mig
				}
				else if ((anv == 0 && dat == 2) || (anv == 1 && dat == 2) || (anv == 2 && dat == 0)) // i dessa fall vinner datorn 
				
				{
					System.out.println("  Datorn vann  ");
			datR++;  // öka vinsten med 1 på datorn
				}
				
				else if (anv == dat)
				
				{
					
					System.out.println(" Det blev lika ");}   // när anv och dator  får samma så blir det lika 
				
			}
					System.out.println("Poängen är | " + anvR + " - Datorn: " + datR); //poänglistan 
	
	
			if (anvR<datR)

					System.out.println("Datorn vann spelet");
					
				else
					System.out.println("Du vann spelet");
		
		
		
		}
		}


	
///metoden Welcome börjar här
public static void welcome() {		
System.out.println("Välkommen till mitt lilla spel\n===============================\nVi ska nu spela Sten, Sax eller Påse \nVi kommer att köra upp till tre vinster vinner!");
}	

public static void stop() {

	
	try (Scanner key2 = new Scanner(System.in)){
	String spel= key2.nextLine().toUpperCase();
	boolean spelA =spel.equals("N");
	System.out.println("Vad synd att du inte ville spela!");
	}	
}
}