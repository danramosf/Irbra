package irbra;

import java.util.Random;
import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author Daniel Ferreira
 */
public class Player extends VisibleEntity implements Walkable {
	
    //Creating a spritesheet animation
    private static final Image IMAGE = new Image("images/charSample2.png");
    private static final ImageView imageView = new ImageView(IMAGE);
		
    private static final int COLUMNS  =   3;
    private static final int COUNT    =  3;
    private static final int OFFSET_X =  10;
    private static final int OFFSET_Y =  10;
    private static final int WIDTH    = 34;
    private static final int HEIGHT   = 34;
    
    private int posOnMapX;
    private int posOnMapY;
        
    private int expLevel;
    private int healthPoints;
    private int skillSwordLevel;
    private int skillAxeLevel;
    private int skillDistanceLevel;
    private int skillDeffenceLevel;
    private String vocation;
      
    private Weapon equippedWeapon;
    private Amulet equippedAmulet;
    private Helmet equippedHelmet;
    private Backpack equippedBackpack;
    private Armor equippedArmor;
    private Shield equippedShield;
    private Ring equippedRing;
    private Legs equippedLegs;
    private Boots equippedBoots;
        
    private double expPoints;
    private double skillSwordPoints;
    private double skillAxePoints;
    private double skillDistancePoints;
    private double skillDeffencePoints;
        
    private static final SpriteAnimation defaultAnimation = new SpriteAnimation (
        imageView,
        Duration.millis(500),
        COUNT, COLUMNS,
        OFFSET_X, OFFSET_Y,
        WIDTH, HEIGHT
    );
	
    private static final Animation moveUpAnimation = new SpriteAnimation(
        imageView,
        Duration.millis(500),
        COUNT, COLUMNS,
        OFFSET_X, OFFSET_Y,
        WIDTH, HEIGHT
    );
	
    private static final Animation moveRightAnimation = new SpriteAnimation(
        imageView,
        Duration.millis(500),
        COUNT, COLUMNS,
        OFFSET_X, OFFSET_Y + 34,
        WIDTH, HEIGHT
    );
	
    private static final Animation moveDownAnimation = new SpriteAnimation(
        imageView,
        Duration.millis(500),
        COUNT, COLUMNS,
        OFFSET_X, OFFSET_Y + 68,
        WIDTH, HEIGHT
    );
	
    private static final Animation moveLeftAnimation = new SpriteAnimation(
        imageView,
        Duration.millis(500),
        COUNT, COLUMNS,
        OFFSET_X, OFFSET_Y + 102,
        WIDTH, HEIGHT
    );	

    public Player(int entityId, String entityName,String vocation) {
	super(entityId, entityName, imageView, false, true, defaultAnimation);
	this.posOnMapX = 46; //x
	this.posOnMapY = 5; //y
        this.expLevel = 1;
        this.healthPoints = 250;
        this.skillSwordLevel = 1;
        this.skillAxeLevel = 1;
        this.skillDistanceLevel = 1;
        this.skillDeffenceLevel = 1;
        if("Assassin".equals(vocation) ||
            "Knight".equals(vocation) || 
            "Sorcerer".equals(vocation) || 
            "Ranger".equals(vocation) || 
            "Warrior".equals(vocation) ||
            "Archer".equals(vocation)){
            this.vocation = vocation;
        }
    }
        
    public Player(int entityId, String entityName, String vocation, int posOnMapX, int posOnMapY) {
        super(entityId, entityName, imageView, false, true, defaultAnimation);
	this.posOnMapX = posOnMapX; //x
	this.posOnMapY = posOnMapY; //y
        this.expLevel = 1;
        this.healthPoints = 250;
        this.skillSwordLevel = 1;
        this.skillAxeLevel = 1;
        this.skillDistanceLevel = 1;
        this.skillDeffenceLevel = 1;
        if("Assassin".equals(vocation) ||
            "Knight".equals(vocation) || 
            "Sorcerer".equals(vocation) || 
            "Ranger".equals(vocation) || 
            "Warrior".equals(vocation) ||
            "Archer".equals(vocation)){
            this.vocation = vocation;
        }
    }
        
    @Override
    public void load(Pane gameplayViewport){		
        super.createViewport(gameplayViewport.getLayoutX(), gameplayViewport.getLayoutY(), gameplayViewport.getWidth(), gameplayViewport.getHeight() );
                        
            
        imageView.setViewport(this.getViewport());	
        defaultAnimation.setCycleCount(1);
        defaultAnimation.play();
		
        imageView.setFitWidth(gameplayViewport.getWidth());
	imageView.setFitHeight(gameplayViewport.getHeight());
	imageView.setLayoutX(gameplayViewport.getLayoutX());
	imageView.setLayoutY(gameplayViewport.getLayoutY());
        gameplayViewport.getChildren().addAll(imageView);
		
    }
	
    @Override
    public void moveRight(){
        if(this.posOnMapY < 40){
            moveRightAnimation.setCycleCount(1);
            moveRightAnimation.play();

            //imageView.setLayoutX(imageView.getLayoutX() + 55);
            this.posOnMapY++; //y++
        }
    }
	
    @Override
    public void moveLeft(){
        if(this.posOnMapY > 5){
            moveLeftAnimation.setCycleCount(1);
            moveLeftAnimation.play();

            //imageView.setLayoutX(imageView.getLayoutX() - 55);
            this.posOnMapY--; //y--
        }
    }
    
    @Override
    public void moveUp(){
        if(this.posOnMapX > 7){
            moveUpAnimation.setCycleCount(1);
            moveUpAnimation.play();

            //imageView.setLayoutY(imageView.getLayoutY() - 55);
            this.posOnMapX--; //x--
        }
    }
	
    @Override
    public void moveDown(){
        if(this.posOnMapX < 46){
            moveDownAnimation.setCycleCount(1);
            moveDownAnimation.play();

            //imageView.setLayoutY(imageView.getLayoutY() + 55);
            this.posOnMapX++; //x++
        }
    }
	
    public ImageView getImageView(){
	return this.imageView;
    }
	
    public int getPosOnMapX(){
	return this.posOnMapX;
    }
	
    public void setPosOnMapX(int x){
	this.posOnMapX = x;
    }
	
    public int getPosOnMapY(){
	return this.posOnMapY;
    }
	
    public void setPosOnMapY(int y){
        this.posOnMapY= y;
    }
        
    /**
     * @return the expLevel
     */
    public int getExpLevel() {
        return expLevel;
    }
    
    public String getVocation(){
        return this.vocation;
    }
    
    public void setVocation(String vocation){
        if(vocation == "Assassin" ||
           vocation == "Knight" || 
           vocation == "Sorcerer" || 
           vocation == "Ranger" || 
           vocation == "Warrior" ||
           vocation == "Archer"){
            this.vocation = vocation;
        }
    }

    /**
     * @param expLevel the expLevel to set
     */
    public void setExpLevel(int expLevel) {
        this.expLevel = expLevel;
    }

    /**
     * @return the healthPoints
     */
    public int getHealthPoints() {
        return healthPoints;
    }

    /**
     * @param healthPoints the healthPoints to set
     */
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * @return the skillSwordLevel
     */
    public int getSkillSwordLevel() {
        return skillSwordLevel;
    }

    /**
     * @param skillSwordLevel the skillSwordLevel to set
     */
    public void setSkillSwordLevel(int skillSwordLevel) {
        this.skillSwordLevel = skillSwordLevel;
    }

    /**
     * @return the skillAxeLevel
     */
    public int getSkillAxeLevel() {
        return skillAxeLevel;
    }

    /**
     * @param skillAxeLevel the skillAxeLevel to set
     */
    public void setSkillAxeLevel(int skillAxeLevel) {
        this.skillAxeLevel = skillAxeLevel;
    }

    /**
     * @return the skillDistanceLevel
     */
    public int getSkillDistanceLevel() {
        return skillDistanceLevel;
    }

    /**
     * @param skillDistanceLevel the skillDistanceLevel to set
     */
    public void setSkillDistanceLevel(int skillDistanceLevel) {
        this.skillDistanceLevel = skillDistanceLevel;
    }

    /**
     * @return the skillDeffenceLevel
     */
    public int getSkillDeffenceLevel() {
        return skillDeffenceLevel;
    }

    /**
     * @param skillDeffenceLevel the skillDeffenceLevel to set
     */
    public void setSkillDeffenceLevel(int skillDeffenceLevel) {
        this.skillDeffenceLevel = skillDeffenceLevel;
    }

    /**
     * @return the equippedWeapon
     */
    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    /**
     * @param equippedWeapon the equippedWeapon to set
     */
    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    /**
     * @return the expPoints
     */
    public double getExpPoints() {
        return expPoints;
    }

    /**
     * @param expPoints the expPoints to set
     */
    public void setExpPoints(double expPoints) {
        this.expPoints = expPoints;
    }
    
    /**
     * @return the equippedAmulet
     */
    public Amulet getEquippedAmulet() {
        return equippedAmulet;
    }

    /**
     * @param equippedAmulet the equippedAmulet to set
     */
    public void setEquippedAmulet(Amulet equippedAmulet) {
        this.equippedAmulet = equippedAmulet;
    }

    /**
     * @return the equippedHelmet
     */
    public Helmet getEquippedHelmet() {
        return equippedHelmet;
    }

    /**
     * @param equippedHelmet the equippedHelmet to set
     */
    public void setEquippedHelmet(Helmet equippedHelmet) {
        this.equippedHelmet = equippedHelmet;
    }

    /**
     * @return the equippedBackpack
     */
    public Backpack getEquippedBackpack() {
        return equippedBackpack;
    }

    /**
     * @param equippedBackpack the equippedBackpack to set
     */
    public void setEquippedBackpack(Backpack equippedBackpack) {
        this.equippedBackpack = equippedBackpack;
    }

    /**
     * @return the equippedArmor
     */
    public Armor getEquippedArmor() {
        return equippedArmor;
    }

    /**
     * @param equippedArmor the equippedArmor to set
     */
    public void setEquippedArmor(Armor equippedArmor) {
        this.equippedArmor = equippedArmor;
    }

    /**
     * @return the equippedShield
     */
    public Shield getEquippedShield() {
        return equippedShield;
    }

    /**
     * @param equippedShield the equippedShield to set
     */
    public void setEquippedShield(Shield equippedShield) {
        this.equippedShield = equippedShield;
    }

    /**
     * @return the equippedRing
     */
    public Ring getEquippedRing() {
        return equippedRing;
    }

    /**
     * @param equippedRing the equippedRing to set
     */
    public void setEquippedRing(Ring equippedRing) {
        this.equippedRing = equippedRing;
    }

    /**
     * @return the equippedLegs
     */
    public Legs getEquippedLegs() {
        return equippedLegs;
    }

    /**
     * @param equippedLegs the equippedLegs to set
     */
    public void setEquippedLegs(Legs equippedLegs) {
        this.equippedLegs = equippedLegs;
    }

    /**
     * @return the equippedBoots
     */
    public Boots getEquippedBoots() {
        return equippedBoots;
    }

    /**
     * @param equippedBoots the equippedBoots to set
     */
    public void setEquippedBoots(Boots equippedBoots) {
        this.equippedBoots = equippedBoots;
    }
        
    public void upgradeLevel(){
        this.setExpPoints(0);
        this.setExpLevel(this.getExpLevel() + 1);
    }
        
    public void downgradeLevel(){
        this.setExpPoints(0);
        if(this.getExpLevel() > 0){
            this.setExpLevel(this.getExpLevel() - 1);
        }
    }
        
    public void upgradeSwordSkills(){
        this.skillSwordPoints = 0;
        this.setSkillSwordLevel(this.getSkillSwordLevel() + 1);
    }
        
    public void upgradeAxeSkills(){
        this.skillAxePoints = 0;
        this.setSkillAxeLevel(this.getSkillAxeLevel() + 1);
    }
        
    public void upgradeDistanceSkills(){
        this.skillDistancePoints = 0;
        this.setSkillDistanceLevel(this.getSkillDistanceLevel() + 1);
    }
        
    public void upgradeDeffenceSkills(){
        this.skillDeffencePoints = 0;
        this.setSkillDeffenceLevel(this.getSkillDeffenceLevel() + 1);
    }
        
    public void hitMonster(Monster monster){
        if(monster.isDead()){
            return;
        }
        if("Sword".equals(this.getEquippedWeapon().getType())){
            monster.removeHealthPoints(calculateDemage("Sword"));
            this.skillSwordPoints += (100/this.getSkillSwordLevel());
            if(this.skillSwordPoints > 100){
                upgradeSwordSkills();
            }
        }
        if("Axe".equals(this.getEquippedWeapon().getType())){
            monster.removeHealthPoints(calculateDemage("Axe"));
            this.skillAxePoints += (100/this.getSkillAxeLevel());
            if(this.skillAxePoints > 100){
                upgradeAxeSkills();
            }
        }
        if("Distance".equals(this.getEquippedWeapon().getType())){
            monster.removeHealthPoints(calculateDemage("Distance"));
            this.skillDistancePoints += (100/this.getSkillDistanceLevel());
            if(this.skillDistancePoints > 100){
                upgradeDistanceSkills();
            }
        }
        if(monster.isDead()){
            setExpPoints(this.expPoints += monster.getExpPoints());
            for(int i=0; i < (monster.getExpPoints()/200); i++){
                upgradeLevel();
                if((i>0) && (i >= monster.getExpPoints()/200)){
                    //Add the remainder exp points
                    setExpPoints(monster.getExpPoints() % 200);
                }
            }            
        }
    }
        
    public int calculateDemage(String weaponType){
        Random rand = new Random();
        int dmg = 0;
           
        if(this.getEquippedWeapon() == null){
            return (rand.nextInt(3) + 1);
        }
        if(weaponType == "Sword"){
            dmg = this.getEquippedWeapon().getAtk() + (rand.nextInt(this.getSkillSwordLevel()) + 1);
        }
           
        if(weaponType == "Axe"){
            dmg = this.getEquippedWeapon().getAtk() + (rand.nextInt(this.getSkillAxeLevel()) + 1);
        }
           
        if(weaponType == "Distance"){
            dmg = this.getEquippedWeapon().getAtk() + (rand.nextInt(this.getSkillDistanceLevel()) + 1);
        }
           
        return dmg; 
    }	

}