//H3angman Game 2020 by Christer Holm
//What do you know about Doctor Who
package hangMan;

import java.util.Scanner;
class Mainfile
{
  public static void main(String[] args)
  {
    Scanner guess = new Scanner(System.in);
    
    //menu for the game
    System.out.println("============ Doctor Who hangman =============");
    System.out.println("Are you a true Whovian");
    System.out.println("Choose your level\n1 = Doctor Who Word:\n2 = How Played The Doctor\n3 = The Doctors Companion ");
    int diff = guess.nextInt(); 
    if(diff==1) // make a choice to play
    {
      Play obj = new Play();
        obj.Start(diff);
    }else{
      if(diff==2)
      {
        Play obj = new Play();
        obj.Start(diff);
      }else{
        Play obj = new Play();
        obj.Start(3);
      }
    }
   
  }
}