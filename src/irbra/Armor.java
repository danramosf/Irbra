package irbra;

import javafx.scene.image.Image;

/**
 *
 * @author Daniel Ferreira
 */
public class Armor extends VisibleEntity {
    
    private int armDef;
    
    public Armor(int armorId, String armorName, Image armorImg, int armDef) {
        super(armorId, armorName, armorImg, true, true);
        this.armDef = armDef;
    }

    /**
     * @return the armDef
     */
    public int getArmDef() {
        return armDef;
    }

    /**
     * @param armDef the armDef to set
     */
    public void setArmDef(int armDef) {
        this.armDef = armDef;
    }
    
    
}
