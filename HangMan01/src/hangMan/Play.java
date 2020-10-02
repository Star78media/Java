//Hangman Game 2020 by Christer Holm
//What do you know about Doctor Who





package hangMan;

import java.util.Random;
import java.util.Scanner;
public class Play
{
    public Play()
    {
      
    }
    public void Start(int diff)
    {
      //Determine the difficulty

    String words[] = new String[8];
      String hints[] = new String[8];
      switch(diff)
      {
        case 1:
          
          words[0] = "tardis";
          hints[0] = "Blue box";
          words[1] = "sontarans";
          hints[1] = "Old enemy";
          words[2] = "dalek";
          hints[2] = "Exterminate";
          words[3] = "cybermen";
          hints[3] = "Delete";
          words[4] = "weeping";
          hints[4] = "Don´t Blink";
          words[5] = "river";
          hints[5] = "Spoilers";
          words[6] = "rose";
          hints[6] = "Bad Wolf";
          words[7] = "fez";
          hints[7] = "Eleventh Doctor";
         
          break;
        case 2:
          words[0] = "matt";
          hints[0] = "Eleventh Doctor";
          words[1] = "david";
          hints[1] = "tenth Doctor";
          words[2] = "john";
          hints[2] = "The War Doctor";
          words[3] = "paul";
          hints[3] = "Eighth Doctor";
          words[4] = "sylvester";
          hints[4] = "Seventh Doctor ";
          words[5] = "jodie";
          hints[5] = "Thirteenth Doctor";
          words[6] = "christopher";
          hints[6] = "Ninth Doctor";
          words[7] = "peter";
          hints[7] = "Twelfth Doctor";
   
          break;
        case 3:
          words[0] = "rose";
          hints[0] = "Ninth Doctor";
          words[1] = "amy";
          hints[1] = "Eleventh Doctor";
          words[2] = "rory";
          hints[2] = "Eleventh Doctor";
          words[3] = "clara";
          hints[3] = "Twelfth Doctor and Eleventh Doctor";
          words[4] = "bill";
          hints[4] = "Twelfth Doctor";
          words[5] = "sarah";
          hints[5] = "Tenth Doctor and Fourth Doctor";
          words[6] = "ryan";
          hints[6] = "Thirteenth Doctor";
          words[7] = "donna";
          hints[7] = "Tenth Doctor";
         
      }
      String word;
      Random rand = new Random();
      int w1 = rand.nextInt(8);
      word = words[w1];
      String hint = hints[w1];
      String guess = "";
      int wl = word.length()+1;
      for(int i=1;i<wl;i++)
      {
        guess += "-";
      }
      //here you start the guessing!
      String lu = "";
      int tt = 0;
      boolean canPlay = true;
      Main(guess, tt, canPlay, lu, word, hint);
}
public void Main(String guess, int tt, boolean canPlay, String lu, String word, String hint)
    {
      if(tt==6) 
      {
       canPlay = false;
       Lose(); 
      }else{
        
        String man[] = new String[7];
        man[0] = " --\n   |\n   |\n   |\n_____\n";
        man[1] = " --\n o |\n   |\n   |\n_____\n";
        man[2] = " --\n o |\n/  |\n   |\n_____\n";
        man[3] = " --\n o |\n/| |\n   |\n_____\n";
        man[4] = " --\n o |\n/|\\|\n   |\n_____\n";
        man[5] = " --\n o |\n/|\\|\n/  |\n_____\n";
        man[6] = " --\n o |\n/|\\|\n/ \\|\n_____\n";
        char g1[] = guess.toCharArray();
        char w2[] = word.toCharArray();
        System.out.println(man[0]);
        for(int x=0;x<g1.length;x++)
        {
          System.out.print(g1[x]);
        }
        System.out.println();
        Guess(guess, tt, canPlay, lu, word, g1, w2, man, hint);
       }
    }
    public void Guess(String guess, int tt, boolean canPlay, String lu, String word, char g1[], char w2[], String man[], String hint)
    {
        String tg1 = new String(g1);
        String tg2 = new String(w2);
        if(tg1.equals(tg2))
        {
        Win();
        }else{
        if(tt == 6)
        {
          System.out.println("\n\nYou are no true Whovian!\nThe word was "+word);
          
          Lose();
        }else{
      Scanner input = new Scanner(System.in);
      System.out.print("Now you have to guess the letter:("+hint+"): ");
      String letter = input.next();
      if(word.contains(letter))
      {
        if(lu.contains(letter))
        {
          tt +=1;
          System.out.println("Wrong guess!");
        }else{
        int wl = word.length();
        for(int i=0;i<wl;i++)
        {
          char aChar = letter.charAt(0);
          char bChar = w2[i];
          if(bChar==aChar)
          {
            g1[i] = aChar;
          }
        }
       }
      }else{
        tt +=1;
        System.out.println("Wrong guess!");
        lu += letter;
      }
      System.out.println();
      System.out.println(man[tt]);
      for(int x=0;x<g1.length;x++)
        {
          System.out.print(g1[x]);
        }
        System.out.println("\n\n");
        lu += letter;
        Guess(guess, tt, canPlay, lu, word, g1, w2, man, hint);
        }
      }
    }
    public void Lose() //metod loser
    {
      Scanner input1 = new Scanner(System.in);
      System.out.print("\nDo you want to play again?(Y/N): ");
      String pa1 = input1.next();
      if(pa1.contains("y") || pa1.contains("Y"))
      {
        System.out.print("\nChoose your level\n1 = Doctor Who Word:\n2 = How Played The Doctor\n3 = The Doctors Companion ");
        int diff1 = input1.nextInt();
        Start(diff1); //start new game
      }else{
      }
    }
    public void Win()  //metod win
    {
    System.out.println("\n\n\\o/\n | \n/ \\"); //print th winner of the game 
      System.out.println("You Won!\n");
      Scanner input2 = new Scanner(System.in);
      System.out.print("\nDo you want to play again?(Y/N): ");
      String pa = input2.next();
      if(pa.contains("y") || pa.contains("Y"))
      {
        System.out.print("\nChoose your level\n1 = Doctor Who Word:\n2 = How Played The Doctor\n3 = The Doctors Companion ");
        int diff2 = input2.nextInt();
        Start(diff2); //start new game 
      }else{
      }
    }
}