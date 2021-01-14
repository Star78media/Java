import java.util.Arrays;

public class Main {

public static void main(String[] args) {
        String[] doors = new String[3];
        int nOSteps = 1000;
        int guess =0;  //Den dörr programmet gissar på
        int removedDoor; //Den dörr som ska tas bort
        int wins = 0;   //Antal vunna omgånger
        int losses = 0; //Antal förlorade omgångar

        //Huvudloopen körs nOSteps gånger

        for (int i = 0; i<nOSteps;i++) {
        doors = setup(doors);
        guess = getRandom();

        removedDoor = removeDoor(guess, doors);

        for (int j = 1; j <= doors.length; j++) {

        if (j == guess || j == removedDoor) {
        //  System.out.println("j == "+ j+ " guess = "+guess );
        //  System.out.println("Removed door" +removedDoor );
        }else{
        guess = j;
        break;         //När vi väl bytt dörr så bryter vi (så klart) loopen och allt fungerar!

        }
        }

        if (doors[guess-1].equals("Car")) {
        wins += 1;
        //  System.out.println("WIN");
        } else {
        losses += 1;
        // System.out.println("LOSER!");
        }

        }

        System.out.println("wins: " +wins + " losses: " +losses);


        }


public static int getRandom(){
        return (int)(Math.random()*3+1);

        }

/**
 * @param doors DörrArrayen
 * @return En DörrArrayen nu fylld med två getter och en bil i slumpmässiga positioner.
 */
public static String[] setup (String [] doors){
        int win = getRandom();

        for (int i=1;i<=doors.length;i++){
        if (i == win){
        doors[i-1] ="Car";
        }
        else{
        doors[i-1] = "Goat";
        }

        }
        return doors;
        }

/**
 * @param guess Aktuell gissning
 * @param doors Arrayen av dörrar
 * @return Ett heltal med som representerar den dörr av de kvarvarande som innehåller en get!
 */
public static int removeDoor (int guess, String[] doors){

        // System.out.println("RemoveDoor Guess: " +guess +" "+Arrays.toString(doors));
        for (int i = 1; i<=doors.length ; i++){
        if (i != guess){
        if(doors[i-1].equals("Goat")){
        doors[i-1] ="Removed";
        //       System.out.println("Removing: "+ doors[i-1] +" " +(i-1));
        return i;
        }
        }
        }
      /*
      Här skulle man med fördel kunna kasta ett exception istället. Hamnar vi här är något fel.
      Crash before thrash!
       */
        System.out.println("Oops!");
        return 0;

        }
        }