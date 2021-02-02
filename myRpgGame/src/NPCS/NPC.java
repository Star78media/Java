package NPCS;

public abstract class NPC {


        public String name;
        public String Id ="NPC";
        public String desc;
        int Hp;
        int accuracy;
        public void look(){
            System.out.println(name);
            System.out.println("accuracy"+accuracy);
            System.out.println("Hp;" +Hp);

        }


    }
