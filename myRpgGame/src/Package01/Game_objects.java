package Package01;
import NPCS.NPC;

import NPCS.Dragon;
import NPCS.Troll;

import java.util.ArrayList;
import java.util.List;

public class Game_objects {
    static PC pc = new PC();
    static ArrayList<Room> room = new ArrayList<Room>();
static List<Object> NPCDatabase = new ArrayList<Object>();
public static void initalizeNPCArray(){
    //NPCDatabase.add = NPCDatabase.add(new NPC());
    NPCDatabase.add(new Troll());
    NPCDatabase.add(new Dragon());

}

}
