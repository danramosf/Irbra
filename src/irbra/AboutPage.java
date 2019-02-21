package irbra;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Ebrahim Zhalesani
 */
public class AboutPage extends Application {
    static Stage stage;
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        
        root.setPrefSize(1600,700);
        //InputStream a = Files.newInputStream(Paths.get("/res/game.jpg"));
        
        Image img = new Image("/images/game.jpg");
        
        ImageView view = new ImageView(img);
        
        view.fitWidthProperty().bind(root.widthProperty());
        view.fitHeightProperty().bind(root.heightProperty());
        view.setSmooth(true);
        root.getChildren().add(view);
        
        StackPane fp = new StackPane();
        Rectangle rec = new Rectangle(950,250,950,250);
        rec.setOpacity(0.6);
        rec.setFill(Color.BLACK);
        rec.setEffect(new GaussianBlur(3.5));
        //rec.setStroke(Color.BLUE);
        rec.setStrokeWidth(10);
        String aboutGame  = " IrBra Game "+System.lineSeparator()+" This game "
                + "has been created by Daniel Ferreira and Ebrahim Zhalehsani "
                + System.lineSeparator()+ " This game has been created for the"
                + " class PROG24178 Object Oriented" + System.lineSeparator() +
                " Programming 2 - Java - 1181_39856,"
                + " taught by Jonathan Penava" + System.lineSeparator()+
                " In this game, start a journey and kill monsters" + System.lineSeparator()+
                "Credits: The sprites used on this prototype has been" + System.lineSeparator()+ 
                "taken from the game Tibia, which belongs to Cipsoft." + System.lineSeparator()+
                "See more at www.cipsoft.com and www.tibia.com";
        Font font;
        font = Font.loadFont(AboutPage.class.getResource("/font/mw3.ttf").toExternalForm(), 22);
        Label label = new Label(aboutGame);
        label.setFont(font);
        //label.setStyle("-fx-font-size:24;");
        label.setStyle("-fx-text-fill:white;");
        //fp.setStyle("-fx-background-color:black;");
        fp.setPadding(new Insets(20,20,20,20));
        fp.setAlignment(Pos.CENTER);
        //fp.setHgap(20);
        //fp.setVgap(20);
        fp.getChildren().addAll(rec,label);
        root.setCenter(fp);     
        
        FlowPane fp1 = new FlowPane();
        MenuButton back = new MenuButton("back");
        back.setOnMouseClicked(event -> {
            
            GameInterface.show();
            
        });
        fp1.setPadding(new Insets(20,20,40,20));
        fp1.setAlignment(Pos.CENTER);
        fp1.setHgap(20);
        fp1.setVgap(20);
        fp1.getChildren().addAll(back);
        root.setBottom(fp1);
        //primaryStage.setTitle("Hello World!");
        //primaryStage.setScene(scene);
        //primaryStage.show();
        Scene scene = new Scene(root, 1600, 700);
        stage = new Stage();
        stage.setTitle("About Page");
        stage.setScene(scene);
    }
    public static void show(){
        stage.show();
        GameInterface.stage.hide();
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
            
            setAlignment(Pos.CENTER);
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}