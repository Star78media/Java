package Package01;

import Package02.*;

import javax.swing.*;



public class Story {
    Game game;
    Ui ui;
    VisibilityManager vm;
    player player = new player();
    superDalek Enemy;

    int silverRing;
    int keyRing;



    public Story(Game g, Ui userInterface, VisibilityManager vManager) {
        game = g;
        ui = userInterface;
        vm = vManager;

    }

    public void defaultSetup() {
        Package01.player.hp = 15;
        ui.healtBar.setValue(Package01.player.hp);
        player.currentWeapond = new Weapon_knife();
        ui.weaponNameLabel.setText(player.currentWeapond.name);
        silverRing= 0;
        keyRing = 0;








    }
public void selectPositon(String nextPosition){
switch (nextPosition){
    case "townGate":townGate();break;
    case "talkGuard":talkGuard();break;
    case "attackGuard":attackGuard();break;
    case "crossRoad":crossRoad();break;
    case "north": north();break;
    case "east":east();break;
    case "west": west();break;
    case"fight": fight();break;
    case "playerAttack":playerAttack();break;
    case "dalekattack" :dalekattack();break;
    case "win": win();break;
    case "lose": lose();break;
    case "ending": ending();break;
    case "toTitle":toTitle();break;


}
}
    public void townGate() {
        ui.image  = new ImageIcon("/home/weeping/IdeaProjects/guitextgame/src/graf/gate.png");
        ui.imageLabel.setIcon(ui.image);

        ui.mainTextArea.setText("You standing in front of the gate to the Citadel\n A guard is standing in front of you. \nA Women standing on your left\n\n What do you want to do?");
        ui.choice1.setText("Talk to the guard");
        ui.choice2.setText("Attack the guard");
        ui.choice3.setText("Talk to the women");
        ui.choice4.setText("Leave");


        game.nextPos1 = "talkGuard";
        game.nextPos2 = "attackGuard";
        game.nextPos3 = "talkWomen";
        game.nextPos4 = "crossRoad";
        game.nextPos5 = "inventory";
    }

    public void talkGuard() {
        ui.image  = new ImageIcon("/home/weeping/IdeaProjects/guitextgame/src/graf/guard.png");
        ui.imageLabel.setIcon(ui.image);
        if (silverRing==1) {
            ui.mainTextArea.setText("Guard: Hello stranger. I have never seen you face!\n" +
                    "I´m sorry but if you not have the Ring of Citadel i can not let you in!\n\n the big bad Dalek has taking it from us.\n" +
                    "Find it and i let yo in!");

            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPos1 = "townGate";
            game.nextPos2 = "";
            game.nextPos3 = "";
        } else {
ending();
        }
    }


    public void attackGuard() {
        ui.mainTextArea.setText("Guard:Don´t be a foul\n The guard hit you hard and you receive 3 damage ");
        Package01.player.hp = Package01.player.hp -3;

ui.healtBar.setValue(Package01.player.hp);
        ui.image  = new ImageIcon("/home/weeping/IdeaProjects/guitextgame/src/graf/guardkick.png");
        ui.imageLabel.setIcon(ui.image);
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPos1 = "townGate";
        game.nextPos2 = "";
        game.nextPos3 = "";
    }
    public void crossRoad() {
        ui.mainTextArea.setText("This is the Crossroad\n If you go south you are back at the Citadel\n If you go north yo will find a river\n East you will find a forest\n West is the home of Daleks");
        ui.image  = new ImageIcon("/home/weeping/IdeaProjects/guitextgame/src/graf/crossroad.png");
        ui.imageLabel.setIcon(ui.image);

        ui.choice1.setText("Go north");
        ui.choice2.setText("Go east");
        ui.choice3.setText("Go south");
        ui.choice4.setText("Go west");

        game.nextPos1 = "north";
        game.nextPos2 = "east";
        game.nextPos3 = "townGate";
        game.nextPos4 = "west";
    }
    public void north() {
        ui.mainTextArea.setText("There is river in front of you\n You drink the water and rest at the riverside.\n You HP is recovered by 2 HP ");
        Package01.player.hp = Package01.player.hp +2;
        ui.healtBar.setValue(Package01.player.hp);
        ui.image  = new ImageIcon("/home/weeping/IdeaProjects/guitextgame/src/graf/river.png");
        ui.imageLabel.setIcon(ui.image);
        ui.choice1.setText("Go south");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPos1 = "crossRoad";
        game.nextPos2 = "";
        game.nextPos3 = "";
        game.nextPos3 = "";
    }
    public void east() {
        ui.mainTextArea.setText("There a forest in front of you, here is where you find a Sword\n You obtained a Sword  ");
player.currentWeapond =new Weapon_LongSword();
ui.weaponNameLabel.setText(player.currentWeapond.name);
        ui.image  = new ImageIcon("/home/weeping/IdeaProjects/guitextgame/src/graf/forest.png");
        ui.imageLabel.setIcon(ui.image);
        ui.choice1.setText("Go west");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPos1 = "crossRoad";
        game.nextPos2 = "";
        game.nextPos3 = "";
        game.nextPos3 = "";
    }
    public void west() {
        int i =new java.util.Random().nextInt(20)+1;

        if(i<10){
            Enemy = new Enemy_Dalek();

            ui.image  = new ImageIcon("/home/weeping/IdeaProjects/guitextgame/src/graf/dalek.png");
        }
        else {
            Enemy = new Enemy_CyberMan();

            ui.image  = new ImageIcon("/home/weeping/IdeaProjects/guitextgame/src/graf/cyberman.png");
        }
        ui.imageLabel.setIcon(ui.image);

        ui.mainTextArea.setText("You encounter a  " +Enemy.name+"!");


        ui.choice1.setText("Fight");
        ui.choice2.setText("Run");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPos1 = "fight";
        game.nextPos2 = "crossRoad";
        game.nextPos3 = "";
        game.nextPos3 = "";
    }
public void fight(){
    ui.mainTextArea.setText( Enemy.name+":\nHp:"+ Enemy.Hp+ "\nWeapon:" + Enemy.weapon+"\nItem: " + Enemy.item_name+"\n\nWhat do you want to do?");
    ui.choice1.setText("Attack");
    ui.choice2.setText("Run");
    ui.choice3.setText("");
    ui.choice4.setText("");

    game.nextPos1 = "playerAttack";
    game.nextPos2 = "crossRoad";
    game.nextPos3 = "";
    game.nextPos3 = "";
}
public void playerAttack() {
    int playerDamage = new java.util.Random().nextInt(player.currentWeapond.damage);
    ui.mainTextArea.setText("You attack the " + Enemy.name + " and gave it " + playerDamage + " hp damage!");
    Enemy.Hp = Enemy.Hp - playerDamage;
    ui.image  = new ImageIcon("/home/weeping/IdeaProjects/guitextgame/src/graf/fight.png");
    ui.imageLabel.setIcon(ui.image);
    ui.choice1.setText(">");
    ui.choice2.setText("");
    ui.choice3.setText("");
    ui.choice4.setText("");


    if (Enemy.Hp > 0) {
        game.nextPos1 = "dalekattack";

    } else {
        game.nextPos1 = "win";
        game.nextPos2 = "";
        game.nextPos3 = "";
        game.nextPos3 = "";
    }
}
    public void dalekattack () {
        int dalekDamage = new java.util.Random().nextInt(Enemy.attack);
        ui.mainTextArea.setText(Enemy.attackMessage+"\nYou received " +dalekDamage+ " hp damage!");
        ui.image  = new ImageIcon("/home/weeping/IdeaProjects/guitextgame/src/graf/fight.png");
        ui.imageLabel.setIcon(ui.image);
        Package01.player.hp = Package01.player.hp - dalekDamage;
        ui.healtBar.setValue(Package01.player.hp);
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (Package01.player.hp > 0) {
            game.nextPos1 = "fight";

        } else {
            game.nextPos1 = "lose";
            game.nextPos2 = "";
            game.nextPos3 = "";
            game.nextPos3 = "";
        }
    }
       public void win() {


           ui.mainTextArea.setText("You defeated the " + Enemy.name + "\n and dropped a " + Enemy.item_name + "\n\n you obtained a " + Enemy.item_name);
           if (Enemy.item == 1) {
               ui.image = new ImageIcon("/home/weeping/IdeaProjects/guitextgame/src/graf/ring.png");
               silverRing = +1;
           } else if (Enemy.item == 2){
               ui.image = new ImageIcon("/home/weeping/IdeaProjects/guitextgame/src/graf/key.png");
               keyRing = +1;
           }
           ui.imageLabel.setIcon(ui.image);
           ui.choice1.setText("Go east");
           ui.choice2.setText("Use you Tardis");
           ui.choice3.setText("");
           ui.choice4.setText("");

           game.nextPos1 = "crossRoad";
           game.nextPos2 = "townGate";
           game.nextPos3 = "";
           game.nextPos3 = "";
        }
    public void lose() {
        ui.mainTextArea.setText("You are dead\n\n Game Over  ");


        ui.choice1.setText("New Game");
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
ui.inventoryButton.setVisible(false);
        game.nextPos1 = "toTitle";
        game.nextPos2 = "";
        game.nextPos3 = "";
        game.nextPos4 = "";
    }
    public void  ending(){
        ui.mainTextArea.setText("Guard: You killed the Dalek and you have the ring\n Welcome in to the Citadel");
        ui.image  = new ImageIcon("/home/weeping/IdeaProjects/guitextgame/src/graf/gateopen.png");
        ui.imageLabel.setIcon(ui.image);
          ui.choice1.setVisible(false);
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
    }
    public void toTitle(){
        vm.showTitleScreen();
        defaultSetup();
    }

}




