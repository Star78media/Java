import java.util.Scanner; //importer scanner 

public class password {


			public static void main(String[] args)
		    {
		 
		    	
				String pass= "Whovian";
		        String inputP;
		        try (Scanner input = new Scanner(System.in)) { 
					for (int i = 0; i < 3; i++) {  // ger tre m�jligheter att sl� in l�senordet 
					    System.out.println("Enter Your Doctor Who Password:");
					    inputP = input.nextLine(); 
					    if(!inputP.equals(pass)) { // om pass inte �r korrekt visas 
					        System.out.println("Wrong password"); // fel meddelande s� att det
					    } else{ // om pass �r korrekt s� skrivs det h�r ut
					        System.out.println("Welcome to Galleifrey!");  //N�r de kommit in s� f�r de det h�r meddelandet. 
					        break;
					    }
					}
				}
		    }
		}
