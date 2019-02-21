/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package irbra;

import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 *
 * @author Ebrahim
 */
public class GameInterface extends Application {
    private GameMenu gameMenu;
    static Stage stage;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        root.setPrefSize(1600,700);
        
        //InputStream a = Files.newInputStream(Paths.get("/res/game.jpg"));
        
        Image img = new Image("/images/game.jpg");       
        
        
        ImageView view = new ImageView(img);
        
        view.fitWidthProperty().bind(root.widthProperty());
        view.fitHeightProperty().bind(root.heightProperty());
        view.setSmooth(true);
        
        gameMenu = new GameMenu();
        
        root.getChildren().addAll(view, gameMenu);
        
        Scene scene = new Scene(root);
        
        //primaryStage.setScene(scene);
        //primaryStage.show();
        stage = new Stage();
        stage.setTitle("Irbra - Game Menu");
        stage.setScene(scene);
        
    }
    private static class GameMenu extends Parent {
         public GameMenu(){
             VBox menu0 = new VBox(15);
             VBox menu1 = new VBox(15);
             
             menu0.setTranslateX(100);
             menu0.setTranslateY(200);
             menu1.setTranslateX(100);
             menu1.setTranslateY(200);
             
             final int offset = 400;
             
             MenuButton btn1 = new MenuButton("    Play");
             btn1.setOnMouseClicked(event -> {
                 FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
                 ft.setFromValue(1);
                 ft.setToValue(0);
                 ft.setOnFinished(evt -> this.setVisible(false));
                 ft.play();
                 
                 //Daniel parts show up(The game)
                 Irbra.showGameplayStage();
             });
             
             MenuButton btn2 = new MenuButton("    About Game");
             btn2.setOnMouseClicked(event -> {
                 AboutPage.show();
             });
             MenuButton btn3 = new MenuButton("    Exit");
             btn3.setOnMouseClicked(event -> {
                 System.exit(0);
             });
             MenuButton btn4 = new MenuButton("Back");
             btn4.setOnMouseClicked(event -> {
                 
             });
             
             MenuButton btn5 = new MenuButton("Options");
             MenuButton btn6 = new MenuButton("About Game");
             menu0.getChildren().addAll(btn1, btn2, btn3);
             
             Rectangle bg = new Rectangle();
            // bg.setFill(Color.GREY);
             bg.setOpacity(0.4);
             
             getChildren().addAll(bg, menu0);
             
         }
    }
    private static class MenuButton extends StackPane {
        private Text text;
        
        public MenuButton(String name){
            text = new Text(name);
            text.setFont(text.getFont().font(20));
            text.setFill(Color.WHITE);
            
            
            Rectangle bg = new Rectangle(250,50);
            bg.setOpacity(0.6);
            bg.setFill(Color.BLACK);
            bg.setEffect(new GaussianBlur(3.5));
            
            setAlignment(Pos.CENTER_LEFT);
            setRotate(-0.5);
            getChildren().addAll(bg,text);
            
            setOnMouseEntered(event -> {
                bg.setTranslateX(10);
                text.setTranslateX(10);
                bg.setFill(Color.WHITE);
                text.setFill(Color.BLACK);
                
            });
            setOnMouseExited(event -> {
                bg.setTranslateX(0);
                text.setTranslateX(0);
                bg.setFill(Color.BLACK);
                text.setFill(Color.WHITE);
            });
            DropShadow drop = new DropShadow(50, Color.WHITE);
            drop.setInput(new Glow());
            
            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));
            
        }
    }
    public static void show(){
        stage.show();
        AboutPage.stage.hide();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}