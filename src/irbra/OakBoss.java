package irbra;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Daniel Ferreira
 */
public class OakBoss extends Monster {
    
    private static final Image IMAGE = new Image("images/The_Demon_Oak.gif");
    private static final Image IMAGE_DEAD = new Image("images/10813.gif");

    public OakBoss(int spawnPosX, int spawnPosY) {
        super(5002, "The Oak Boss", IMAGE, 800, spawnPosX, spawnPosY, false, 30);
    }

    @Override
    public void die() {
        setExpPoints(800);
        super.setImgNumOfParts(4);
        getSpriteSheetImageView().setImage(IMAGE_DEAD);
        setSpriteSheetImageView2(new ImageView(IMAGE_DEAD));
        setSpriteSheetImageView3(new ImageView(IMAGE_DEAD));
        setSpriteSheetImageView4(new ImageView(IMAGE_DEAD));
        setDead(true);
    }

    @Override
    public void atkPlayer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void goToPlayer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
