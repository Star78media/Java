package Package01;

import NPCS.NPC;

import java.util.Scanner;




public class Game_Logic {




    public Game_Logic(){
    Game_objects.room.add(new Room(1));
    Game_objects.room.get(0).name="The Kitchen";
    Game_objects.room.get(0).desc.add("Desc Line 1");
    Game_objects.room.get(0).desc.add("Desc Line 2");
    Game_objects.room.get(0).desc.add("Desc Line 3");
    Game_objects.room.get(0).desc.add("Desc Line 4");
    Game_objects.room.get(0).exits.add("South 2");
    Game_objects.room.get(0).exits.add("North 3");

}
public void waiterCommand() {
    if (Game_objects.pc.inRoom == 0) {
        createCharacter();
    }
    System.out.println("What do?");
    Scanner sc = new Scanner(System.in);
    String com = sc.nextLine();
    String[] words = com.split(" ");
    processCommand(words);
}
   public void processCommand(String[]x)
   {
if(x[0].equals("look"))
{
    look(x);
       }
       if(x[0].equals("summon"))
       {
           summon(x);
       }

   }
   void look(String[]x)
   {

if(x.length ==1){
    for(int i = 0; i < Game_objects.room.size();  i++){
        if (Game_objects.room.get(i).number == Game_objects.pc.inRoom){
        System.out.println(Game_objects.room.get(i).name);
        for (int y = 0; y <Game_objects.room.get(i).desc.size();y++){
            System.out.println(Game_objects.room.get(i).desc.get(y));


             }
        System.out.println("Exits");
        for(int y =0; y<Game_objects.room.get(i).exits.size();y++){
            String exitNameFull = Game_objects.room.get(i).exits.get(y);
            String[]exitName = exitNameFull.split("");
            System.out.println(exitName[0]);
        }
        for (int y=0; y <Game_objects.room.get(i).npc.size(); y++){
            System.out.println(Game_objects.room.get(i).npc.get(y).desc);
        }
    }


}
   }
if (x.length ==2){
    if(x[1].equals("self")){
        Game_objects.pc.look();
    }
for (int y= 0;y<Game_objects.room.size();y++){
    if(Game_objects.room.get(y).number == Game_objects.pc.inRoom){
        for (int i = 0; i< Game_objects.room.get(y).npc.size();i++){
            if(x[1].equalsIgnoreCase(Game_objects.room.get(y).npc.get(i).Id)) {
                Game_objects.room.get(y).npc.get(i).look();
            
            }
        }
    }
}
}
}
public void summon(String[]x){
    if(x.length ==1) {
        System.out.println("Summon What Exactly");
    }
    if (x.length == 2){
        for (int i = 0; i< Game_objects.NPCDatabase.size(); i++){
            NPC localNPC =(NPC) Game_objects.NPCDatabase.get(i);
            if (localNPC.Id.equalsIgnoreCase(x[1])){
            for (int y =0 ;y <Game_objects.room.size();y++)   {
                if(Game_objects.room.get(y).number == Game_objects.pc.inRoom){
       try{
    Game_objects.room.get(y).npc.add((NPC) Class.forName(localNPC.Id).newInstance());
    System.out.println("You Summon A "+ Game_objects.room.get(y).npc.get(Game_objects.room.get(y).npc.size()-1).name);


} catch (InstantiationException| IllegalAccessException| ClassNotFoundException e){
   e.printStackTrace();
}
                }
            }
            }
        }
    }
}




    public void createCharacter(){
    System.out.println("Welcome to the Game.What is your name?");
    Scanner sc = new Scanner(System.in);
       Game_objects.pc.name = sc.next();
       System.out.println("For the Sake of simplicity,the good are going to give you 100Hp and 75 accuracy from the Start");
       Game_objects.pc.hp = 100;
       Game_objects.pc.accuracy =75;
       Game_objects.pc. inRoom = 1;

   }
}