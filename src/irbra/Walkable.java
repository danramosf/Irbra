package irbra;

import javafx.scene.layout.Pane;

/**
 *
 * @author Daniel Ferreira
 */
public interface Walkable {
    
    public void moveRight();
    public void moveLeft();
    public void moveUp();
    public void moveDown();
    public void load(Pane gameplayViewport);
    
}
