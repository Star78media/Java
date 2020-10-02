import java.util.Scanner; //importer scanner 

public class password {


			public static void main(String[] args)
		    {
		 
		    	
				String pass= "Whovian";
		        String inputP;
		        try (Scanner input = new Scanner(System.in)) { 
					for (int i = 0; i < 3; i++) {  // ger tre möjligheter att slå in lösenordet 
					    System.out.println("Enter Your Doctor Who Password:");
					    inputP = input.nextLine(); 
					    if(!inputP.equals(pass)) { // om pass inte är korrekt visas 
					        System.out.println("Wrong password"); // fel meddelande så att det
					    } else{ // om pass är korrekt så skrivs det här ut
					        System.out.println("Welcome to Galleifrey!");  //När de kommit in så får de det här meddelandet. 
					        break;
					    }
					}
				}
		    }
		}
