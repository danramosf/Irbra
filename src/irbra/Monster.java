package irbra;

import javafx.scene.control.Label;
import javafx.scene.image.Image;

/**
 *
 * @author Daniel Ferreira
 */
public abstract class Monster extends VisibleEntity {
  
    private final int MAXHP;
    
    private int healthPoints;
    private int expPoints;
    private boolean dead;
    
    private int spawnPosX;
    private int spawnPosY;
    private int posOnMapY;
    private int posOnMapX;
    
    private Label lblMonsterName;
    private Label lblMonsterHP = new Label();

    public Monster(int entityId, String monsterName, Image monsterSpritesheet, int MAXHP, int spawnPosX,int spawnPosY,boolean pushable) {
        super(entityId, monsterName, monsterSpritesheet, false, pushable);
        this.MAXHP = MAXHP;
        this.spawnPosX = spawnPosX;
        this.spawnPosY = spawnPosY;
        this.posOnMapX = spawnPosX;
        this.posOnMapY = spawnPosY;
        this.lblMonsterName = new Label(monsterName);
        this.lblMonsterHP = new Label(""+MAXHP);
        this.healthPoints = MAXHP;
        this.dead = false;
    }
    
    public Monster(int entityId, String monsterName, Image monsterSpritesheet, int MAXHP, int spawnPosX,int spawnPosY,boolean pushable, int imgNumOfParts) {
        super(entityId, monsterName, monsterSpritesheet, false, pushable, imgNumOfParts);
        this.MAXHP = MAXHP;
        this.spawnPosX = spawnPosX;
        this.spawnPosY = spawnPosY;
        this.posOnMapX = spawnPosX;
        this.posOnMapY = spawnPosY;
        this.lblMonsterName = new Label(monsterName);
        this.lblMonsterHP = new Label(""+MAXHP);
        this.healthPoints = MAXHP;
        this.dead = false;
    }
    
    public int getHealthPoints(){
        return this.healthPoints;
    }
    
    public int getMAXHP(){
        return this.MAXHP;
    }
    
    public int getExpPoints(){
        return this.expPoints;
    }    
    
    public void setExpPoints(int expPoints){
        this.expPoints = expPoints;
    }

    /**
     * @return the spawnPosX
     */
    public int getSpawnPosX() {
        return spawnPosX;
    }

    /**
     * @param spawnPosX the spawnPosX to set
     */
    public void setSpawnPosX(int spawnPosX) {
        this.spawnPosX = spawnPosX;
    }

    /**
     * @return the spawnPosY
     */
    public int getSpawnPosY() {
        return spawnPosY;
    }

    /**
     * @param spawnPosY the spawnPosY to set
     */
    public void setSpawnPosY(int spawnPosY) {
        this.spawnPosY = spawnPosY;
    }

    /**
     * @return the posOnMapY
     */
    public int getPosOnMapY() {
        return posOnMapY;
    }

    /**
     * @param posOnMapY the posOnMapY to set
     */
    public void setPosOnMapY(int posOnMapY) {
        this.posOnMapY = posOnMapY;
    }

    /**
     * @return the posOnMapX
     */
    public int getPosOnMapX() {
        return posOnMapX;
    }

    /**
     * @param posOnMapX the posOnMapX to set
     */
    public void setPosOnMapX(int posOnMapX) {
        this.posOnMapX = posOnMapX;
    }
    
    public Label getLblMonsterName(){
        return this.lblMonsterName;
    }
    
    public Label getLblMonsterHP(){
        return this.lblMonsterHP;
    }
    
    public void setLblMonsterHP(int monsterHP){
        this.lblMonsterHP.setText(""+monsterHP);
    }
    
    public void removeHealthPoints(int hp){
        this.healthPoints = this.healthPoints - hp;
        if(this.healthPoints <= 0){
            die();
        }
    }
    
    public boolean isDead(){
        return this.dead;
    }
    
    public void setDead(boolean dead){
        this.dead = dead;
    }
    
    public abstract void die();
    public abstract void atkPlayer();
    public abstract void goToPlayer();
    
}
