package Package01;

public class VisibilityManager {
    Ui ui;
    public VisibilityManager(Ui userInterface){
    ui = userInterface;

    }
    public void showTitleScreen(){
       //show titelScreen
        ui.titleNamePanel.setVisible(true);
        ui.startButton.setVisible(true);
        //hide the Game Screen
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
        ui.healtBarPanel.setVisible(false);
        ui.healtBar.setVisible(false);
        ui.imagePanel.setVisible(false);
    }
    public void titleToTown(){

        //hide titelScreen
        ui.titleNamePanel.setVisible(false);
        ui.startButton.setVisible(false);
        //show the Game Screen
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true );
        ui.healtBarPanel.setVisible(true);
        ui.healtBar.setVisible(true);
        ui.imagePanel.setVisible(true);
    }
}

