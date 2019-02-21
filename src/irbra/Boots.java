package irbra;

import javafx.scene.image.Image;

/**
 *
 * @author Daniel Ferreira
 */
public class Boots extends Armor {
    
    private int speed;
    
    public Boots(int bootsId, String bootsName, Image bootsImg, int bootsDef, int speed) {
        super(bootsId, bootsName, bootsImg, bootsDef);
        this.speed = speed;
    }
    
    public int getSpeed(){
        return this.speed;
    }
    
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
}
