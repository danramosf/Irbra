package irbra;

import irbra.exceptions.WrongWeaponTypeException;
import javafx.scene.image.Image;

/**
 *
 * @author Daniel Ferreira
 */
public class Weapon extends VisibleEntity{
    
    private int atk;
    private String type;
    
    public Weapon(int weaponId, String weaponName, Image spriteSheet, int atk, String type) throws WrongWeaponTypeException {
        super(weaponId, weaponName, spriteSheet, true, true);
        this.atk = atk;
        if(type == "Sword" || type == "Axe" || type == "Distance"){
            this.type = type;
        }else{
            throw new WrongWeaponTypeException();
        }
    }
    
    /**
     * 
     * @return the weapon attack (atk) attribute 
     */
    public int getAtk(){
        return this.atk;
    }
    
    /**
     * 
     * @return the weapon type (Sword, Axe or Distance) 
     */
    public String getType(){
        return this.type;
    }
}
