package Package01;

import NPCS.NPC;

import java.util.ArrayList;
import java.util.List;


public class Room {
    int number;
    String name;
    List<String> desc = new ArrayList<>();
    List<String> exits= new ArrayList<>();
    List<NPC> npc= new ArrayList<NPCS.NPC>();

    public Room(int x){
        number = x;

    }
}
