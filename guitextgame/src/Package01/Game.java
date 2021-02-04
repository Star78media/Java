package Package01;



import Package03.Superitems;
import Package03.item_Empty;
import Package03.item_Orange;
import Package03.item_Potion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Game {
  ChoiceHandler cHandler = new ChoiceHandler();
InventoryHandler iHandler = new InventoryHandler();
static Superitems[]playerItem = new Superitems[5];
item_Potion potion = new item_Potion();
    item_Orange orange = new item_Orange();
    static item_Empty empty = new item_Empty();



    static Ui ui = new Ui();
     VisibilityManager vm = new VisibilityManager(ui);

     Story story = new Story( this,ui, vm);
String nextPos1,nextPos2,nextPos3,nextPos4,nextPos5;
static String inventoryStatus;





    public static void main(String[] args) {
        new Game();

    }

    public Game() {
        inventoryStatus = "close";
        playerItem[0] = potion;
        playerItem[1] = orange;
        playerItem[2] =empty;
        playerItem[3]= empty;
        playerItem[4] = potion;
        ui.createUI(cHandler,iHandler);
       story.defaultSetup();
       vm.showTitleScreen();
    }
public static class InventoryHandler implements  ActionListener {


    public void actionPerformed(ActionEvent event) {
        String yourChoice = event.getActionCommand();
        switch (yourChoice) {
            case "inventoryButton":
                if (inventoryStatus.equals("close")) {
                    ui.choice1.setVisible(false);
                    ui.choice2.setVisible(false);
                    ui.choice3.setVisible(false);
                    ui.choice4.setVisible(false);
                    ui.inventoryPanel.setVisible(true);
                    ui.itemButton1.setText(playerItem[0].name);
                    ui.itemButton2.setText(playerItem[1].name);
                    ui.itemButton3.setText(playerItem[2].name);
                    ui.itemButton4.setText(playerItem[3].name);
                    ui.itemButton5.setText(playerItem[4].name);
                    inventoryStatus = "open";

                } else if (inventoryStatus.equals("open")) {
                    ui.choice1.setVisible(true);
                    ui.choice2.setVisible(true);
                    ui.choice3.setVisible(true);
                    ui.choice4.setVisible(true);
                    ui.inventoryPanel.setVisible(false);
                    inventoryStatus = "close";
                }
                break;
            case "item1":
                    itemUsed(0);
            break;
            case "item2":
                itemUsed(1);
                break;
            case"item3":
                itemUsed(2);
                break;
            case "item4":
                itemUsed(3);
                break;
            case "item5":
                itemUsed(4);
                break;


        }
    }
}
    public static void itemUsed(int slotNumber){
player.hp= player.hp+playerItem[slotNumber].healingValue;
ui.healtBar.setValue(+player.hp);
playerItem[slotNumber]= empty;
        ui.itemButton1.setText(playerItem[0].name);
        ui.itemButton2.setText(playerItem[1].name);
        ui.itemButton3.setText(playerItem[2].name);
        ui.itemButton4.setText(playerItem[3].name);
        ui.itemButton5.setText(playerItem[4].name);

    }

    public class ChoiceHandler implements ActionListener {


        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();


            switch (yourChoice) {
                case "Start":
                    vm.titleToTown();
                    story.townGate();
                    break;
                case "c1":
                    story.selectPositon(nextPos1);
                    break;
                case "c2":
                    story.selectPositon(nextPos2);
                    break;
                case "c3":
                    story.selectPositon(nextPos3);
                    break;
                case "c4":
                    story.selectPositon(nextPos4);
                    break;
                case "inventoryButton":
                    story.selectPositon(nextPos5);
                    break;
            }

        }
    }}