/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package irbra;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Daniel
 */
public class Irbra extends Application {    
    //Gameplay View Variables
    static Stage gameplayStage = new Stage();
    static GamePlayViewController gameplayController;
    //
    @Override
    @SuppressWarnings("Convert2Lambda")
    public void start(Stage stage) throws Exception {
        //Ebi
        GameInterface inter=new GameInterface();
        AboutPage ab = new AboutPage();
        
        inter.start(stage);
        ab.start(stage);
        
        inter.show();
        //end Ebi
        
        //Gameplay View Variables
        FXMLLoader gameplayFXMLLoader = new FXMLLoader(getClass().getResource("GamePlayView.fxml"));		
	Parent gameplayRoot = gameplayFXMLLoader.load();		
	gameplayController = gameplayFXMLLoader.getController();
		
	Scene gameplayScene = new Scene(gameplayRoot);

        gameplayScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
	    public void handle(KeyEvent event){

                if (null != event.getCode()) switch (event.getCode()) {
                    case D:
                        gameplayController.getPlayer().moveRight();
                        gameplayController.getGameMap().load(gameplayController.getGameplayGridPane(),
                                                             gameplayController.getPlayer().getPosOnMapX(),
                                                             gameplayController.getPlayer().getPosOnMapY());
                        gameplayController.getPlayerStackPane().toFront();
                        gameplayController.updateLabelsPosition();
                        if(gameplayController.getGameMap().hasMonsterOnScreen(gameplayController.getPlayer().getPosOnMapX(),
                                                                              gameplayController.getPlayer().getPosOnMapY())){
                            gameplayController.setLblStatusText("A Monster has been detected! Press 'F' to attack!");
                        }else{
                            gameplayController.setLblStatusText("No monsters on the screen.");
                        }
                        break;
                    case A:
                        gameplayController.getPlayer().moveLeft();
                        gameplayController.getGameMap().load(gameplayController.getGameplayGridPane(),
                                                             gameplayController.getPlayer().getPosOnMapX(),
                                                             gameplayController.getPlayer().getPosOnMapY());
                        gameplayController.getPlayerStackPane().toFront();
                        gameplayController.updateLabelsPosition();
                        if(gameplayController.getGameMap().hasMonsterOnScreen(gameplayController.getPlayer().getPosOnMapX(),
                                                                              gameplayController.getPlayer().getPosOnMapY())){
                            gameplayController.setLblStatusText("A Monster has been detected! Press 'F' to attack!");
                        }else{
                            gameplayController.setLblStatusText("No monsters on the screen.");
                        }
                        break;
                    case W:		        	
                        gameplayController.getPlayer().moveUp();
                        gameplayController.getGameMap().load(gameplayController.getGameplayGridPane(),
                                                             gameplayController.getPlayer().getPosOnMapX(),
                                                             gameplayController.getPlayer().getPosOnMapY());
                        gameplayController.getPlayerStackPane().toFront();
                        gameplayController.updateLabelsPosition();
                        if(gameplayController.getGameMap().hasMonsterOnScreen(gameplayController.getPlayer().getPosOnMapX(),
                                                                              gameplayController.getPlayer().getPosOnMapY())){
                            gameplayController.setLblStatusText("A Monster has been detected! Press 'F' to attack!");
                        }else{
                            gameplayController.setLblStatusText("No monsters on the screen.");
                        }
                        break;
                    case S:
                        gameplayController.updateLabelsPosition();
                        gameplayController.getPlayer().moveDown();
                        gameplayController.getGameMap().load(gameplayController.getGameplayGridPane(),
                                                             gameplayController.getPlayer().getPosOnMapX(),
                                                             gameplayController.getPlayer().getPosOnMapY());
                        gameplayController.getPlayerStackPane().toFront(); 
                        if(gameplayController.getGameMap().hasMonsterOnScreen(gameplayController.getPlayer().getPosOnMapX(),
                                                                              gameplayController.getPlayer().getPosOnMapY())){
                            gameplayController.setLblStatusText("A Monster has been detected! Press 'F' to attack!");
                        }else{
                            gameplayController.setLblStatusText("No monsters on the screen.");
                        }
                        break;
                    case F:
                        //If there is a monster on the screen,
                        if(gameplayController.getGameMap().hasMonsterOnScreen(gameplayController.getPlayer().getPosOnMapX(),
                                                                              gameplayController.getPlayer().getPosOnMapY())){
                            //Player hits the monster
                            gameplayController.getPlayer().hitMonster(gameplayController.getGameMap().getMonsterOnScreen(gameplayController.getPlayer().getPosOnMapX(),
                                                                                                                     gameplayController.getPlayer().getPosOnMapY()));
                            try{
                            //Displays monster's HP on chatlog
                            gameplayController.enterTextOnChatlog(""+ gameplayController.getGameMap().getMonsterOnScreen(gameplayController.getPlayer().getPosOnMapX(),
                                                                                                                        gameplayController.getPlayer().getPosOnMapY()).getEntityName() +
                                                                  " current health points: " + gameplayController.getGameMap().getMonsterOnScreen(gameplayController.getPlayer().getPosOnMapX(),
                                                                                                                        gameplayController.getPlayer().getPosOnMapY()).getHealthPoints());
                            }catch(NullPointerException e){
                                gameplayController.enterTextOnChatlog("You've killed the monster!");
                            }
                        }
                        gameplayController.updateLblSkills();
                    default:
                        break;
                }
            }
	});
        
        gameplayStage.setScene(gameplayScene);
        // 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void showGameplayStage(){
        gameplayStage.show();
        GameInterface.stage.hide();
    }
    
}