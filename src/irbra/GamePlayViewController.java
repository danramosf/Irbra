package irbra;

import irbra.exceptions.WrongWeaponTypeException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author Daniel Ferreira and Ebrahim Zhalesani
 */
public class GamePlayViewController implements Initializable {
    
    @FXML
    private Label lblStatus;
       
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        player = new Player(1,"Noob", "Assassin");
        
        //initializing the equipments inventory
        try{
            Weapon sword = new Weapon(760,"Simple Sword",new Image("images/items/760.gif"), 10,"Sword");
            player.setEquippedWeapon(sword);
//            Weapon axe = new Weapon(7287,"Strong Axe",new Image("images/items/7287.gif"), 70,"Axe");
//            player.setEquippedWeapon(axe);
//            Weapon crossbow = new Weapon(8750,"Head Shot Crossbow",new Image("images/items/8750.gif"), 1000,"Distance");
//            player.setEquippedWeapon(crossbow);
        }catch(WrongWeaponTypeException ex){
            System.out.println(ex);
        }
        
        Amulet amulet = new Amulet(7797,"Simple Amulet",new Image("images/items/7797.gif"), 0);
        player.setEquippedAmulet(amulet);
        Helmet helmet = new Helmet(3255,"Simple Helmet",new Image("images/items/3255.gif"), 1);
        player.setEquippedHelmet(helmet);        
        Backpack backpack = new Backpack(3883,"Brown Backpack",new Image("images/items/3883.gif"));
        player.setEquippedBackpack(backpack);
        Armor armor = new Armor(3278,"Simple Armor",new Image("images/items/3278.gif"), 1);
        player.setEquippedArmor(armor);
        Shield shield = new Shield(3326,"Simple Shield",new Image("images/items/3326.gif"), 15);
        player.setEquippedShield(shield);
        Ring ring = new Ring(808,"Skull Ring",new Image("images/items/808.gif"), -1);
        player.setEquippedRing(ring);
        Legs legs = new Legs(3262,"Simple Legs",new Image("images/items/3262.gif"), 1);
        player.setEquippedLegs(legs);
        Boots boots = new Boots(7799,"Vulcano Boots",new Image("images/items/7799.gif"), 1, 2);
        player.setEquippedBoots(boots);
        //End initializing the equipments inventory
        gameMap = new GameMap(gameplayGridPane);
        
        gameMap.load(gameplayGridPane,player.getPosOnMapX() ,player.getPosOnMapY());
        player.load(playerStackPane);
        playerStackPane.toFront();
             
        playerPosX.setText("X: " + player.getPosOnMapX());
        playerPosY.setText("Y: " + player.getPosOnMapY());
        
        lblPlayerName.setText(""+player.getEntityName());
        lblPlayerVocation.setText(""+player.getVocation());
        updateLblSkills();
        
        //Filling the equipment inventory
        ImageView ivWeapon = new ImageView(player.getEquippedWeapon().getSpriteSheet());
        weaponSP.getChildren().add(ivWeapon);
        ImageView ivAmulet = new ImageView(player.getEquippedAmulet().getSpriteSheet());
        amuletSP.getChildren().add(ivAmulet);
        ImageView ivHelmet = new ImageView(player.getEquippedHelmet().getSpriteSheet());
        helmetSP.getChildren().add(ivHelmet);
        ImageView ivBackpack = new ImageView(player.getEquippedBackpack().getSpriteSheet());
        backpackSP.getChildren().add(ivBackpack);
        ImageView ivArmor = new ImageView(player.getEquippedArmor().getSpriteSheet());
        armorSP.getChildren().add(ivArmor);
        ImageView ivShield = new ImageView(player.getEquippedShield().getSpriteSheet());
        shieldSP.getChildren().add(ivShield);
        ImageView ivRing = new ImageView(player.getEquippedRing().getSpriteSheet());
        ringSP.getChildren().add(ivRing);
        ImageView ivLegs = new ImageView(player.getEquippedLegs().getSpriteSheet());
        legsSP.getChildren().add(ivLegs);
        ImageView ivBoots = new ImageView(player.getEquippedBoots().getSpriteSheet());
        bootsSP.getChildren().add(ivBoots);
        //End filling the equipment inventory
    }
    
    @FXML
    private StackPane playerStackPane;
    
    @FXML
    private GridPane gameplayGridPane;
    @FXML
    private StackPane amuletSP;
    @FXML
    private StackPane helmetSP;
    @FXML
    private StackPane backpackSP;
    @FXML
    private StackPane armorSP;
    @FXML
    private StackPane legsSP;
    @FXML
    private StackPane bootsSP;
    @FXML
    private StackPane weaponSP;
    @FXML
    private StackPane shieldSP;
    @FXML
    private StackPane ringSP;
    @FXML
    private StackPane ammoSP;
    
    @FXML
    private Rectangle rectHP;
    @FXML
    private Rectangle rectExp;
    
    @FXML
    private Label lblSkillsExp;
    @FXML
    private Label lblSkillsHp;
    @FXML
    private Label lblSkillsSw;
    @FXML
    private Label lblSkillsAxe;
    @FXML
    private Label lblSkillsDis;
    @FXML
    private Label lblSkillsDef;
    
    @FXML
    private Label lblPlayerName;
    @FXML
    private Label lblPlayerVocation;
    @FXML
    private Label lblPlayerLevel;
    @FXML
    private Label playerPosX;
    @FXML
    private Label playerPosY;
    @FXML
    private TextField tfChat; 
    @FXML
    private TextArea taChatlog;
    
    private Player player;
    private GameMap gameMap;
    
    
    public Player getPlayer(){
        return this.player;
    }
    
    public GameMap getGameMap(){
        return this.gameMap;
    }
    
    public GridPane getGameplayGridPane(){
        return this.gameplayGridPane;
    }
    
    public StackPane getPlayerStackPane(){
        return this.playerStackPane;
    }
    
    public void updateLabelsPosition(){
        playerPosX.setText("X: " + player.getPosOnMapX());
        playerPosY.setText("Y: " + player.getPosOnMapY());
    }
    
    @FXML
    public void enterTextOnChatlog(){
        this.taChatlog.setText(this.taChatlog.getText() + "\n" + player.getEntityName() + ": "
                + this.tfChat.getText());
        this.tfChat.clear();
    }
    
    public void enterTextOnChatlog(String text){
        this.taChatlog.setText(this.taChatlog.getText() + "\n" + "System: "
                + text);
    }
    
    public void setLblStatusText(String text){
        lblStatus.setText(text);
    }
    
    public void updateLblSkills(){
        lblPlayerLevel.setText("Lvl: "+player.getExpLevel());
        lblSkillsExp.setText(""+player.getExpPoints());
        lblSkillsHp.setText(""+player.getHealthPoints());
        lblSkillsSw.setText(""+player.getSkillSwordLevel());
        lblSkillsAxe.setText(""+player.getSkillAxeLevel());
        lblSkillsDis.setText(""+player.getSkillDistanceLevel());
        lblSkillsDef.setText(""+player.getSkillDeffenceLevel());
        rectHP.setWidth(calculateRectHpWidth());
        rectExp.setWidth(calculateRectExpWidth());
        
    }
    
    public double calculateRectHpWidth(){
        double x = (100 * player.getHealthPoints())/250;        
        return 175*(x/100);
    }
    
    public double calculateRectExpWidth(){
        double x = (100 * player.getExpPoints())/200;
        return 175*(x/100);
    }
    
}
